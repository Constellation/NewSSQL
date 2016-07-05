package supersql.dataconstructor.optimizer;

import static supersql.parser.querytestParser.*;

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
	private SQLManager sqlManager;
	
//	private Map<String, List<String>> mapAttributeTables; //map between an attribute name and a list of table containing this attribute name
	private Map<String, Collection<String>> mapTablePrimaryKeys; //map between a table and its primary keys
	
	private Map<String, Table> mapAliasTable;
	private Map<NameAlias, Table> mapNameTable;
	
	private ArrayList<TfeAttribute> tfeAttributes;
	private ArrayList<Table> fromClauseTables;
	private Predicate whereClausePredicate;
	
//	private Collection<ExtList> joinClauses;
	
	
	public OptimizerPreprocessor(ExtList tfe, ExtList from, WhereInfo where, SQLManager sqlm){
		list_tfe = tfe;
		list_from = from;
		whereInfo = where;
		sqlManager = sqlm;
		
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
	
//	private void getDBInfo(){
//		//Get list of tables
//		dbTables = sqlManager.getTables();
//		
//		//Get mapping table pks
//		for(String table: dbTables){
//			mapTablePrimaryKeys.put(table, sqlManager.getPrimaryKeys(table));
//		}
//		
//	}
	
	private boolean setTfeAttributes() throws Exception{
		if(!setTfeAttributes(list_tfe, new TfePath(), true))
			return false;
		
		//Set the remaining primary key
		for(Table table: fromClauseTables){
			for(String pk: mapTablePrimaryKeys.get(table.getName())){
				if(!table.containsPrimaryKey(pk))
					table.addPrimaryKey(new Attribute(pk, table));
			}
		}
		return true;
	}
	
	//TODO: treat the case of concatenation
	private boolean setTfeAttributes(ExtList componentList, TfePath currentPath, boolean isRoot) throws Exception{
		List operands = componentList.getNodesInDepth(ruleNames[RULE_operand]);
		int currentIndex = 0;
		for(int i=0; i<operands.size(); i++){
			ExtList operand = (ExtList) operands.get(i);
			if(operand.contains("||"))
				return false;
			
			ExtList operandFirstInfo = (ExtList)((ExtList) operand.get(1)).get(0);
			String operandType = (String)operandFirstInfo.get(0);
			
			if((operandType).equals(ruleNames[RULE_grouper])){
				if(!setTfeAttributes(operandFirstInfo, (new TfePath(currentPath)).addIndex(currentIndex++), false))
					return false;
			}
			else if(operandType.equals(ruleNames[RULE_exp])){
				if(!setTfeAttributes(operandFirstInfo, currentPath, false))
					return false;
			}	
			else if((currentIndex = processAttributeWithoutSlTolerance(operand, currentPath, currentIndex)) == -1)
				return false;
//			else if(operandType.equals(ruleNames[RULE_table_alias]) || operandType.equals(ruleNames[RULE_column_name])){
//				if(operandType.equals(ruleNames[RULE_table_alias])){
//					TfePath path = (new TfePath(currentPath)).setLeafIndex(i);
//					String name = (String)((ExtList)((ExtList)((ExtList) operand.getNodesInDepth(ruleNames[RULE_column_name]).get(0)).getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
//
//					String alias = (String) ((ExtList)((ExtList)operandFirstInfo.getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
//					Table table = mapAliasTable.get(alias);
//					TfeAttribute newAttribute = new TfeAttribute(name, table, path);
//					tfeAttributes.add(newAttribute);
//					
//					//Add this attribute to the table
//					if(mapTablePrimaryKeys.get(table.getName()).contains(name))
//						table.addPrimaryKey(newAttribute);
//					else table.addAttribute(newAttribute);
//				} 
//				else return false;
//			}
//			
//			else if(operandType.equals(ruleNames[RULE_function])){
//				ExtList functionNameNode = (ExtList) operand.getNodesInDepth(ruleNames[RULE_function_name]).get(0);
//				ExtList anyNameNodeFunction = (ExtList) functionNameNode.getNodesInDepth(ruleNames[RULE_any_name]).get(0);
//				String functionName = (String) ((ExtList) anyNameNodeFunction.get(1)).get(0);
//				
//				if(functionName.equalsIgnoreCase("imagefile") || functionName.equalsIgnoreCase("image")){
//					ExtList functionTableInfoNode = (ExtList) operandFirstInfo.getNodesInDepth(ruleNames[RULE_operand]).get(0);
//					ExtList functionTableInfoTypeNode = (ExtList) ((ExtList) functionTableInfoNode.get(1)).get(0);
//					String functionTableInfoType = (String) functionTableInfoTypeNode.get(0);
//					
//					if(functionTableInfoType.equals(ruleNames[RULE_table_alias])){
//						TfePath path = (new TfePath(currentPath)).setLeafIndex(i);
//						String name = (String)((ExtList)((ExtList)((ExtList) functionTableInfoNode.getNodesInDepth(ruleNames[RULE_column_name]).get(0)).getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
//
//						String alias = (String) ((ExtList)((ExtList)functionTableInfoTypeNode.getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
//						Table table = mapAliasTable.get(alias);
//						TfeAttribute newAttribute = new TfeAttribute(name, table, path);
//						tfeAttributes.add(newAttribute);
//						
//						//Add this attribute to the table
//						if(mapTablePrimaryKeys.get(table.getName()).contains(name))
//							table.addPrimaryKey(newAttribute);
//						else table.addAttribute(newAttribute);
//					} 
//					else if(!functionTableInfoType.equals(ruleNames[RULE_sl]))
//						return false;
//				}
//				
//				else if(functionName.equalsIgnoreCase("link")){
//					ArrayList subOperands = operandFirstInfo.getNodesInDepth(ruleNames[RULE_operand]);
//					if(subOperands.size()<3)
//						return false;
//					
//					ExtList firstOperand = (ExtList) subOperands.get(0);
//					ExtList firstOperandTypeNode = (ExtList) ((ExtList) firstOperand.get(1)).get(0);
//					String firstOperandType = (String)firstOperandTypeNode.get(0);
//					if(firstOperandType.equals(ruleNames[RULE_table_alias])){
//						TfePath path = (new TfePath(currentPath)).setLeafIndex(i);
//						String name = (String)((ExtList)((ExtList)((ExtList) firstOperand.getNodesInDepth(ruleNames[RULE_column_name]).get(0)).getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
//
//						String alias = (String) ((ExtList)((ExtList)firstOperandTypeNode.getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
//						Table table = mapAliasTable.get(alias);
//						TfeAttribute newAttribute = new TfeAttribute(name, table, path);
//						tfeAttributes.add(newAttribute);
//						
//						//Add this attribute to the table
//						if(mapTablePrimaryKeys.get(table.getName()).contains(name))
//							table.addPrimaryKey(newAttribute);
//						else table.addAttribute(newAttribute);
//					} 
//					else if(!firstOperandType.equals(ruleNames[RULE_sl]))
//						return false;
//					
//					ExtList thirdOperand = (ExtList) subOperands.get(2);
//					ExtList thirdOperandTypeNode = (ExtList) ((ExtList) firstOperand.get(1)).get(0);
//					String thirdOperandType = (String)firstOperandTypeNode.get(0);
//					if(thirdOperandType.equals(ruleNames[RULE_table_alias])){
//						TfePath path = (new TfePath(currentPath)).setLeafIndex(i);
//						String name = (String)((ExtList)((ExtList)((ExtList) thirdOperand.getNodesInDepth(ruleNames[RULE_column_name]).get(0)).getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
//
//						String alias = (String) ((ExtList)((ExtList)thirdOperandTypeNode.getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
//						Table table = mapAliasTable.get(alias);
//						TfeAttribute newAttribute = new TfeAttribute(name, table, path);
//						tfeAttributes.add(newAttribute);
//						
//						//Add this attribute to the table
//						if(mapTablePrimaryKeys.get(table.getName()).contains(name))
//							table.addPrimaryKey(newAttribute);
//						else table.addAttribute(newAttribute);
//					} 
//					else return false;
//				}
//				else return false;
//			}
		}
		return true;
	}
	
	private boolean isACurlBracketOperand(ExtList operand){
		ExtList operandContent = (ExtList) operand.get(1);
		Object firstInfo = operandContent.get(0);
		
		return firstInfo.equals("{");
	}
	
	private int processAttributeWithSlTolerance(ExtList operand, TfePath currentPath, int currentIndex) throws Exception{
		if(operand.contains("||"))
			return -1;
		
		ExtList operandFirstInfo = (ExtList)((ExtList) operand.get(1)).get(0);
		String operandType = (String)operandFirstInfo.get(0);
		if(operandType.equals(ruleNames[RULE_table_alias])){
			TfePath path = (new TfePath(currentPath)).setLeafIndex(currentIndex++);
			String name = (String)((ExtList)((ExtList)((ExtList) operand.getNodesInDepth(ruleNames[RULE_column_name]).get(0)).getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);

			String alias = (String) ((ExtList)((ExtList)operandFirstInfo.getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
			Table table = mapAliasTable.get(alias);
			TfeAttribute newAttribute = new TfeAttribute(name, table, path);
			boolean alreadyHere = false;
			for(TfeAttribute alreadyHereAttribute: tfeAttributes){
				if(alreadyHereAttribute.equals(newAttribute)){
					alreadyHereAttribute.addPath(path);
					alreadyHere = true;
					break;
				}
			}
			if(!alreadyHere){
				tfeAttributes.add(newAttribute);
				//Add this attribute to the table
				if(mapTablePrimaryKeys.get(table.getName()).contains(name))
					table.addPrimaryKey(newAttribute);
				else table.addAttribute(newAttribute);
			}
		}
		else if(operandType.equals(ruleNames[RULE_function])){
			currentIndex = processFunction(operand, currentPath, currentIndex);
			if(currentIndex == -1)
				return -1;
		}
		else if(!operandType.equals(ruleNames[RULE_sl]))
			return -1;
		
		return currentIndex;
	}
	
	private int processAttributeWithoutSlTolerance(ExtList operand, TfePath currentPath, int currentIndex) throws Exception{
		if(operand.contains("||"))
			return -1;
		
		ExtList operandFirstInfo = (ExtList)((ExtList) operand.get(1)).get(0);
		String operandType = (String)operandFirstInfo.get(0);
		
		if(operandType.equals(ruleNames[RULE_table_alias])){
			TfePath path = (new TfePath(currentPath)).setLeafIndex(currentIndex++);
			String name = (String)((ExtList)((ExtList)((ExtList) operand.getNodesInDepth(ruleNames[RULE_column_name]).get(0)).getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);

			String alias = (String) ((ExtList)((ExtList)operandFirstInfo.getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
			Table table = mapAliasTable.get(alias);
			TfeAttribute newAttribute = new TfeAttribute(name, table, path);
			tfeAttributes.add(newAttribute);
			
			
			//Add this attribute to the table
			if(mapTablePrimaryKeys.get(table.getName()).contains(name))
				table.addPrimaryKey(newAttribute);
			else table.addAttribute(newAttribute);
		}
		else if(operandType.equals(ruleNames[RULE_function])){
			currentIndex = processFunction(operand, currentPath, currentIndex);
			if(currentIndex == -1)
				return -1;
		}
		else return -1;
		return currentIndex;
	}
	
	private int processFunction(ExtList operand, TfePath currentPath, int currentIndex) throws Exception{
		ExtList operandFirstInfo = (ExtList)((ExtList) operand.get(1)).get(0);
		ExtList functionNameNode = (ExtList) operand.getNodesInDepth(ruleNames[RULE_function_name]).get(0);
		ExtList anyNameNodeFunction = (ExtList) functionNameNode.getNodesInDepth(ruleNames[RULE_any_name]).get(0);
		String functionName = (String) ((ExtList) anyNameNodeFunction.get(1)).get(0);
		
		int newIndex = currentIndex;
		if(functionName.equalsIgnoreCase("imagefile") || functionName.equalsIgnoreCase("image")){
			ExtList functionTableInfoNode = (ExtList) operandFirstInfo.getNodesInDepth(ruleNames[RULE_operand]).get(0);
			
			newIndex = processAttributeWithSlTolerance(functionTableInfoNode, currentPath, currentIndex);
			if(newIndex == -1)
				return -1;
		}
		else if(functionName.equalsIgnoreCase("link")){
			ArrayList subOperands = operandFirstInfo.getNodesInDepth(ruleNames[RULE_operand]);
			if(subOperands.size()<3)
				return -1;
			
			ExtList firstOperand = (ExtList) subOperands.get(0);
			ExtList thirdOperand = (ExtList) subOperands.get(2);
			int intermediateIndex = processAttributeWithSlTolerance(firstOperand, currentPath, currentIndex);
			if(intermediateIndex == -1)
				return -1;
			newIndex = processAttributeWithoutSlTolerance(thirdOperand, currentPath, currentIndex);
			if(newIndex == -1)
				return -1;
		}
		
		return newIndex;
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
			if(!sqlManager.hasTable(name))
				return false;
			else{
				//Get the primary keys
				Collection<String> keys = sqlManager.getPrimaryKeys(name);
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
	
//	//TODO: don't forget the parenthesis
//	private boolean addPredicates(boolean isClause, ExtList clauseOrExpression){
//		if(isClause){
//			
//		}
//		else{
//			ExtList expr = clauseOrExpression;
//			ExtList exprContent = (ExtList) expr.get(1);
//			Object firstInfo = exprContent.get(0);
//			if(!(firstInfo instanceof ExtList))
//				return false;
//			
//			ExtList firstInfoList = (ExtList) firstInfo;
//			String firstInfoType = (String) firstInfoList.get(0);
//			
//			if(firstInfoType.equals(ruleNames[RULE_raise_function]))
//				return false;
//			if(firstInfoType.equals(ruleNames[RULE_expr])){
//				if(exprContent.size() >= 3){
//					Object operator = exprContent.get(1);
//					if(operator.equals("OR"))
//						return false;
//					if(operator.equals("||"))
//						return false;
//					if(operator.equals("COLLATE"))
//						return false;
//					if(operator.equals("AND")){
//						if(!addPredicates(false, firstInfoList))
//							return false;
//						if(!addPredicates(false, (ExtList)exprContent.get(2)))
//							return false;
//					}
//					
//					
//					else{
//						String predicateText = "";
//						
//					}
//				}
//			}
//		}
//		return true;
//	}
	
	
	
	private boolean preliminaryChecks(){
		return !Preprocessor.isAggregate() && !Preprocessor.isOrderBy();
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
