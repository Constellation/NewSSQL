package supersql.dataconstructor.optimizer;


import static supersql.parser.querytestParser.RULE_any_name;
import static supersql.parser.querytestParser.RULE_column_name;
import static supersql.parser.querytestParser.RULE_compound_operator;
import static supersql.parser.querytestParser.RULE_exp;
import static supersql.parser.querytestParser.RULE_function;
import static supersql.parser.querytestParser.RULE_function_name;
import static supersql.parser.querytestParser.RULE_grouper;
import static supersql.parser.querytestParser.RULE_join_clause;
import static supersql.parser.querytestParser.RULE_operand;
import static supersql.parser.querytestParser.RULE_sl;
import static supersql.parser.querytestParser.RULE_table_alias;
import static supersql.parser.querytestParser.RULE_table_name;
import static supersql.parser.querytestParser.RULE_table_or_subquery;
import static supersql.parser.querytestParser.ruleNames;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import supersql.dataconstructor.optimizer.attributes.Attribute;
import supersql.dataconstructor.optimizer.attributes.TfeAttribute;
import supersql.dataconstructor.optimizer.attributes.TfePath;
import supersql.dataconstructor.optimizer.database.DatabaseManager;
import supersql.dataconstructor.optimizer.predicates.ElementaryBinaryPredicate;
import supersql.dataconstructor.optimizer.predicates.ElementaryUnaryPredicate;
import supersql.dataconstructor.optimizer.predicates.Predicate;
import supersql.dataconstructor.optimizer.tables.Table;
import supersql.db.SQLManager;
import supersql.extendclass.ExtHashSet;
import supersql.extendclass.ExtList;
import supersql.parser.Preprocessor;
import supersql.parser.WhereInfo;
import supersql.parser.WhereParse;

public class OptimizerPreprocessor {
	private ExtList list_tfe, list_from;
	private WhereInfo whereInfo;
	private DatabaseManager dbManager;
	
	private Map<String, Collection<String>> mapTablePrimaryKeys; //map between a table and its primary keys
	
	private Map<String, Table> mapAliasTable;
	private Map<NameAlias, Table> mapNameTable;
	
	private ArrayList<TfeAttribute> tfeAttributes;
	private ArrayList<Table> fromClauseTables;
	private Predicate whereClausePredicate;
	
	public OptimizerPreprocessor(ExtList tfe, ExtList from, WhereInfo where, DatabaseManager dbm){
		list_tfe = tfe;
		list_from = from;
		whereInfo = where;
		dbManager = dbm;
		
		mapTablePrimaryKeys = new Hashtable<String, Collection<String>>();
		tfeAttributes = new ArrayList<TfeAttribute>();
		fromClauseTables = new ArrayList<Table>();
		whereClausePredicate = new Predicate();
		mapAliasTable = new Hashtable<String, Table>();
		mapNameTable = new Hashtable<NameAlias, Table>();
	}
	
	public boolean setOptimizerInputFromParser(){
		try{
//			getDBInfo();
			if(!preliminaryChecks())
				return false;
			
			if(!setFromClauseTables())
				return false;
			
			if(!setTfeAttributes())
				return false;
			
			if(!setWhereClausePredicate())
				return false;
		}catch(Exception e){
			System.err.println("Optimization failed because of an error");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public ArrayList<TfeAttribute> getTfeAttributes(){
		return tfeAttributes;
	}
	
	public ArrayList<Table> getFromClauseTables(){
		return fromClauseTables;
	}
	
	public Predicate getWhereClausePredicate(){
		return whereClausePredicate;
	}
	
	
	private boolean preliminaryChecks(){
		return !Preprocessor.isAggregate() && !Preprocessor.isOrderBy();
	}
	
	private boolean setFromClauseTables() throws Exception{
		//Exclude UNION, INTERSECT etc..
		if(list_from.containsNodeInDepth(ruleNames[RULE_compound_operator]))
			return false;
		
		if(list_from.containsNodeInDepth(ruleNames[RULE_join_clause]))
			return false;
			
//		joinClauses = list_from.getNodesInDepth(ruleNames[RULE_join_clause]);
//		//Exclude OUTER JOINs
//		for(ExtList clause: joinClauses){
//			ExtList operator = (ExtList) clause.getNodesInDepth(ruleNames[RULE_join_operator]).get(1);
//			if(operator.contains("OUTER"))
//				return false;
//		}
		
		//Get all the tables of the from clause
		Collection<ExtList> tablesList = list_from.getNodesInDepth(ruleNames[RULE_table_or_subquery]);
		for(ExtList table: tablesList){
			ExtList tableNameNode = (ExtList)(table.getNodesInDepth(ruleNames[RULE_table_name])).get(0);
			ExtList anyNameNode = (ExtList)(tableNameNode.getNodesInDepth(ruleNames[RULE_any_name])).get(0);
			String name = (String) ((ExtList)anyNameNode.get(1)).get(0);
			
			ExtList aliasList = (ExtList) table.getNodesInDepth(ruleNames[RULE_table_alias]).get(0);
			
			if(aliasList.isEmpty())
				return false;
			
			//If the table does not exist in the db (need to check because need the primary keys)
			if(!dbManager.hasTable(name))
				return false;
			else{
				//Get the primary keys
				Collection<String> keys = dbManager.getPrimaryKeys(name);
				if(keys.isEmpty())
					return false;
				mapTablePrimaryKeys.put(name, keys);
				
				ExtList anyNameNodeAlias = (ExtList)(aliasList.getNodesInDepth(ruleNames[RULE_any_name])).get(0);
				String alias = (String) ((ExtList) anyNameNodeAlias.get(1)).get(0);
				
				if(mapAliasTable.containsKey(alias))//Two different table can't have the same alias
					return false;
				Table newTable = new Table(name, alias);
				fromClauseTables.add(newTable);
				mapAliasTable.put(alias, newTable);
				mapNameTable.put(new NameAlias(name, alias), newTable);
			}
		}
		return true;
	}
	
	private boolean setTfeAttributes() throws Exception{
		boolean result = setTfeAttribute(getNodeContent(list_tfe), new TfePath(), 0) >= 0;
		
		//Add remaning primary keys
		for(Table table: fromClauseTables){
			String tableName = table.getName();
			for(String pk: mapTablePrimaryKeys.get(tableName)){
				if(!table.containsPrimaryKey(pk)){
					Attribute newPk = new Attribute(pk, table);
					table.addPrimaryKey(newPk);
				}
			}
		}
		return result;
	}
	
	private int setTfeAttribute(ExtList currentContent, TfePath currentPath, int initIndex) throws Exception{
		List subOperands = getSubOperands(currentContent);
		int localIndex = initIndex;
		for(int i=0; i<subOperands.size(); i++){
			ExtList subOperand = (ExtList) subOperands.get(i);
			OperandType subOperandType = getOperandType(subOperand);
			ExtList subOperandContent = getNodeContent(subOperand);
			
			switch(subOperandType){
			case EXP:
				localIndex = setTfeAttribute(subOperandContent, currentPath, localIndex);
				if(localIndex < 0)
					return -1;
				break;
			case GROUPER:
				int checkIndex = setTfeAttribute(subOperandContent, new TfePath(currentPath).addIndex(localIndex), 0);
				if(checkIndex < 0)
					return -1;
				localIndex++;
				break;
			case ALIAS:
				if(!addAttribute(subOperand, new TfePath(currentPath).setLeafIndex(localIndex)))
					return -1;
				localIndex++;
				break;
				
			case FUNCTION:
				localIndex = processFunction(subOperand, currentPath, localIndex);
				if(localIndex < 0)
					return -1;
				break;
			case COLUMN:
			case UNKNOWN:
				return -1;
			case SL:
				break;
			}
		}
		return localIndex;
	}
	
	private int processFunction(ExtList functionOperand, TfePath currentPath, int localIndex) throws Exception{
		String functionName = getFunctionName(functionOperand);
		ExtList functionContent = getNodeContent(functionOperand);
		ArrayList subOperands = getSubOperands(functionContent);
		switch(functionName){
		case "imagefile":
		case "image":
			ExtList subOperandIm = (ExtList) subOperands.get(0);
			OperandType subOperandTypeIm = getOperandType(subOperandIm);
			if(subOperandTypeIm.equals(OperandType.ALIAS)){
				if(!addAttribute(subOperandIm, new TfePath(currentPath).setLeafIndex(localIndex)))
					return -1;
				localIndex++;
				return localIndex;
			}
			else if(subOperandTypeIm.equals(OperandType.FUNCTION))
				return processFunction(subOperandIm, currentPath, localIndex);
			
			else if(subOperandTypeIm.equals(OperandType.SL))
				return localIndex;
			else return -1;
		case "foreach":
			for(int i=0; i<subOperands.size(); i++){
				ExtList subOperandFor = (ExtList) subOperands.get(0);
				OperandType subOperandTypeFor = getOperandType(subOperandFor);
				if(subOperandTypeFor.equals(OperandType.ALIAS)){
					if(!addAttribute(subOperandFor, new TfePath(currentPath).setLeafIndex(localIndex)))
						return -1;
					localIndex++;
				}
				else return -1;
			}
			return localIndex;
		case "link":
			ExtList subOperand1 = (ExtList) subOperands.get(0);
			OperandType subOperand1Type = getOperandType(subOperand1);
			
			
			if(subOperand1Type.equals(OperandType.ALIAS)){
				if(!addAttribute(subOperand1, new TfePath(currentPath).setLeafIndex(localIndex)))
					return -1;
				localIndex++;
			}
			else if(subOperand1Type.equals(OperandType.FUNCTION))
				localIndex = processFunction(subOperand1, currentPath, localIndex);
			
			else if(!subOperand1Type.equals(OperandType.SL))
				return -1;
			
			for(int i=2; i<subOperands.size(); i++){
				ExtList subOperand3 = (ExtList) subOperands.get(i);
				OperandType subOperand3Type = getOperandType(subOperand3);
				if(subOperand3Type.equals(OperandType.ALIAS)){
					if(!addAttribute(subOperand3, new TfePath(currentPath).setLeafIndex(localIndex)))
						return -1;
					localIndex++;
				}
				else if(subOperand3Type.equals(OperandType.FUNCTION))
					localIndex = processFunction(subOperand3, currentPath, localIndex);
				else return -1;
			}
			return localIndex;
		
		default:
			return -1;
		}
	}
	
	private boolean addAttribute(ExtList aliasOperand, TfePath path) throws Exception{
		String tableAlias = getTableAlias(aliasOperand);
		if(!mapAliasTable.containsKey(tableAlias))
			return false;
		Table table = mapAliasTable.get(tableAlias);
		String attributeName = getColumnName(aliasOperand);
		
		TfeAttribute newAttribute = new TfeAttribute(attributeName, table, path);
		boolean alreadyExists = false;
		for(TfeAttribute att: tfeAttributes){
			if(att.equals(newAttribute)){
				att.addPath(path);
				alreadyExists = true;
				break;
			}
		}
		
		if(!alreadyExists){
			tfeAttributes.add(newAttribute);
			
			boolean foundPk = false;
			for(String pk: mapTablePrimaryKeys.get(table.getName())){
				if(pk.equals(newAttribute.getName())){
					table.addPrimaryKey(newAttribute);
					foundPk = true;
					break;
				}
			}
			if(!foundPk)
				table.addAttribute(newAttribute);
		}
		return true;
	}
	
	private ArrayList getSubOperands(ExtList node) throws Exception{
		return node.getNodesInDepth(ruleNames[RULE_operand]);
	}
	
	private ExtList getNodeContent(ExtList node) throws Exception{
		return (ExtList) node.get(1);
	}
	
	private OperandType getOperandType(ExtList operand) throws Exception{
		ExtList operandContent = getNodeContent(operand);
		ExtList firstInfo = (ExtList) operandContent.get(0);
		String operandRule = (String) firstInfo.get(0);
		return getOperandType(operandRule);
	}
	
	private OperandType getOperandType(String rule){
		if(rule.equals(ruleNames[RULE_table_alias]))
			return OperandType.ALIAS;
		if(rule.equals(ruleNames[RULE_column_name]))
			return OperandType.COLUMN;
		if(rule.equals(ruleNames[RULE_grouper]))
			return OperandType.GROUPER;
		if(rule.equals(ruleNames[RULE_sl]))
			return OperandType.SL;
		if(rule.equals(ruleNames[RULE_function]))
			return OperandType.FUNCTION;
		if(rule.equals(ruleNames[RULE_exp]))
			return OperandType.EXP;
		
		return OperandType.UNKNOWN;
	}
	
	private String getTableAlias(ExtList operand) throws Exception{
		return getAnyName((ExtList) operand.getNodesInDepth(ruleNames[RULE_table_alias]).get(0));
	}
	
	private String getColumnName(ExtList operand) throws Exception{
		return getAnyName((ExtList) operand.getNodesInDepth(ruleNames[RULE_column_name]).get(0));
	}
	
	private String getFunctionName(ExtList operand) throws Exception{
		return getAnyName((ExtList) operand.getNodesInDepth(ruleNames[RULE_function_name]).get(0));
	}
	
	private String getAnyName(ExtList nameNode) throws Exception{
		ExtList anyNameNode = (ExtList) nameNode.getNodesInDepth(ruleNames[RULE_any_name]).get(0);
		ExtList anyNameNodeContent = getNodeContent(anyNameNode);
		return (String) anyNameNodeContent.get(0);
	}
	
	private boolean setWhereClausePredicate() throws Exception{
		ExtList whereClause = whereInfo.getWhereClause();
		
		for(Object o: whereClause){
			WhereParse predicateInfo = (WhereParse) o;
			
			ExtHashSet usedTables = predicateInfo.getUseTables();
			Set usedAttributes = new HashSet(predicateInfo.getUseAtts());
			String text = predicateInfo.getLine();
			if(usedTables.size() > 2 || usedTables.size() < 1)
				return false;
			
			//Unary predicate
			if(usedTables.size() == 1){
				if(usedAttributes.size() != 1)
					return false;
				
				String tableAlias = (String) usedTables.iterator().next();
				if(!mapAliasTable.containsKey(tableAlias))
					return false;
				
				Table involvedTable = mapAliasTable.get(tableAlias);
				
				String att = (String) usedAttributes.iterator().next();
				String[] split = att.split("\\.");
				String attName = split[1];
				
				Attribute attInTable = involvedTable.getAttribute(attName);
				if(attInTable == null){
					attInTable = new Attribute(attName, involvedTable);
					involvedTable.addAttribute(attInTable);
				}
				
				ElementaryUnaryPredicate newEup = new ElementaryUnaryPredicate(text, attInTable);
				whereClausePredicate.add(newEup);
				
			}
			
			//Binary predicate
			if(usedTables.size() == 2){
				if(usedAttributes.size() != 2)
					return false;
				
				Iterator itTable = usedTables.iterator();
				
				String tableAlias1 = (String) itTable.next(), tableAlias2 = (String) itTable.next();
				if(!mapAliasTable.containsKey(tableAlias1) || !mapAliasTable.containsKey(tableAlias2))
					return false;
				
				Table involvedTable1 = mapAliasTable.get(tableAlias1), 
						involvedTable2 = mapAliasTable.get(tableAlias2);
				
				Iterator itAtt = usedAttributes.iterator();
				String att1 = (String) itAtt.next(), att2 = (String) itAtt.next();
				String att1Name = att1.split("\\.")[1], att2Name = att2.split("\\.")[1];
				
				Attribute att1InTable = involvedTable1.getAttribute(att1Name),
						att2InTable = involvedTable2.getAttribute(att2Name);
				if(att1InTable == null){
					att1InTable = new Attribute(att1Name, involvedTable1);
					involvedTable1.addAttribute(att1InTable);
				}
				if(att2InTable == null){
					att2InTable = new Attribute(att2Name, involvedTable2);
					involvedTable2.addAttribute(att2InTable);
				}
				
				ElementaryBinaryPredicate newEbp = new ElementaryBinaryPredicate(text, att1InTable, att2InTable);
				whereClausePredicate.add(newEbp);
			}
		}
		
		return true;
	}
	
	private enum OperandType{
		EXP,
		GROUPER,
		ALIAS,
		COLUMN,
		FUNCTION,
		SL,
		UNKNOWN
	}
	
	private class NameAlias{
		String name;
		String alias;
		
		NameAlias(String n, String a){
			name = n;
			alias = a;
		}
		
		public boolean equals(Object o){
			if(o instanceof NameAlias)
				return ((NameAlias)o).alias.equals(alias) && ((NameAlias)o).name.equals(name);
			return false;
		}
		
		public int hashCode(){
			return name.hashCode() + alias.hashCode();
		}
	}
}
