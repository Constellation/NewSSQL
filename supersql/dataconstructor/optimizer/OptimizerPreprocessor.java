package supersql.dataconstructor.optimizer;

import static supersql.parser.querytestParser.RULE_any_name;
import static supersql.parser.querytestParser.RULE_column_name;
import static supersql.parser.querytestParser.RULE_compound_operator;
import static supersql.parser.querytestParser.RULE_grouper;
import static supersql.parser.querytestParser.RULE_join_clause;
import static supersql.parser.querytestParser.RULE_join_operator;
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
	
	private Collection<String> dbTables; //List of tables in the database
	private Map<String, List<String>> mapAttributeTables; //map between an attribute name and a list of table containing this attribute name
	private Map<String, Collection<String>> mapTablePrimaryKeys; //map between a table and its primary keys
	
	private Map<String, Table> mapAliasTable;
	private Map<NameAlias, Table> mapNameTable;
	
	private ArrayList<TfeAttribute> tfeAttributes;
	private Collection<StringLiteral> stringLiterals;
	private ArrayList<Table> fromClauseTables;
	private Predicate whereClausePredicate;
	
	private Collection<ExtList> joinClauses;
	
	
	public OptimizerPreprocessor(ExtList tfe, ExtList from, WhereInfo where, SQLManager sqlm){
		list_tfe = tfe;
		list_from = from;
		whereInfo = where;
		sqlManager = sqlm;
		
		mapAttributeTables = new Hashtable<String, List<String>>();
		mapTablePrimaryKeys = new Hashtable<String, Collection<String>>();
		tfeAttributes = new ArrayList<TfeAttribute>();
		fromClauseTables = new ArrayList<Table>();
		whereClausePredicate = new Predicate();
		stringLiterals = new ArrayList<StringLiteral>();
		mapAliasTable = new Hashtable<String, Table>();
		mapNameTable = new Hashtable<NameAlias, Table>();
	}
	
	public boolean setOptimizerInputFromParser(){
		try{
			getDBInfo();
			if(!preliminaryChecks())
				return false;
			
			if(!setFromClauseTables())
				return false;
			
			if(!setTfeAttributes())
				return false;
			
			if(setWhereClausePredicate())
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
	
	public Collection<StringLiteral> getStringLiterals(){
		return stringLiterals;
	}
	
	private void getDBInfo(){
		//Get list of tables
		dbTables = sqlManager.getTables();
		
		//Get mapping attribute table and mapping table pks
		for(String table: dbTables){
			Collection<String> atts = sqlManager.getAttributes(table);
			for(String att: atts){
				if(mapAttributeTables.containsKey(att))
					mapAttributeTables.get(att).add(table);
				else{
					List<String> newTableList = new ArrayList<String>();
					newTableList.add(table);
					mapAttributeTables.put(att, newTableList);
				}
			}
			mapTablePrimaryKeys.put(table, sqlManager.getPrimaryKeys(table));
		}
	}
	
	private boolean setTfeAttributes(){
		return setTfeAttributes(list_tfe, new TfePath());
	}
	
	//TODO: treat the case of concatenation
	private boolean setTfeAttributes(ExtList componentList, TfePath currentPath){
		List operands = componentList.getNodesInDepth(ruleNames[RULE_operand]);
		for(int i=0; i<operands.size(); i++){
			ExtList operand = (ExtList) operands.get(i);
			if(operand.contains("||"))
				return false;
			
			ExtList operandFirstInfo = (ExtList)((ExtList) operand.get(1)).get(0);
			String operandType = (String)operandFirstInfo.get(0);
			
			if((operandType).equals(ruleNames[RULE_grouper])){
				if(!setTfeAttributes(operandFirstInfo, (new TfePath(currentPath)).addIndex(i)))
					return false;
			}
			else if(operandType.equals(ruleNames[RULE_table_alias]) || operandType.equals(ruleNames[RULE_column_name])){
				Table table = null;
				TfePath path = (new TfePath(currentPath)).setLeafIndex(i);
				String name = (String)((ExtList)((ExtList)((ExtList) operand.getNodesInDepth(ruleNames[RULE_column_name]).get(0)).getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
				if(operandType.equals(ruleNames[RULE_table_alias])){
					String alias = (String) ((ExtList)((ExtList)operandFirstInfo.getNodesInDepth(ruleNames[RULE_any_name]).get(0)).get(1)).get(0);
					table = mapAliasTable.get(alias);
				} else{
					List<String> possibleTables = mapAttributeTables.get(name);
					if(possibleTables.size() > 1 || possibleTables.size()<=0) //If an attribute doesn't have alias and can match with several tables, or that this attribute belongs to no table
						return false;
					table = mapNameTable.get(new NameAlias(possibleTables.get(0), ""));
				}
				TfeAttribute newAttribute = new TfeAttribute(name, table, path);
				tfeAttributes.add(newAttribute);
				
				//Add this attribute to the table
				if(mapTablePrimaryKeys.get(table.getName()).contains(name))
					table.addPrimaryKey(newAttribute);
				else table.addAttribute(newAttribute);
			}
			else if(operandType.equals(ruleNames[RULE_sl])){
				String string = (String)((ExtList) operandFirstInfo.get(0)).get(0);
				TfePath path = (new TfePath(currentPath)).setLeafIndex(i);
				StringLiteral newSl = new StringLiteral(string, path);
				stringLiterals.add(newSl);
			}
		}
		
		//Set the remaining primary keys
		for(Table table: fromClauseTables){
			for(String pk: mapTablePrimaryKeys.get(table.getName())){
				if(!table.containsPrimaryKey(pk))
					table.addPrimaryKey(new Attribute(pk, table));
			}
		}
		return true;
	}
	
	private boolean setFromClauseTables(){
		//Exclude UNION, INTERSECT etc..
		if(!list_from.containsNodeInDepth(ruleNames[RULE_compound_operator]))
			return false;
		joinClauses = list_from.getNodesInDepth(ruleNames[RULE_join_clause]);
			
		//Exclude OUTER JOINs
		for(ExtList clause: joinClauses){
			ExtList operator = (ExtList) clause.getNodesInDepth(ruleNames[RULE_join_operator]).get(1);
			if(operator.contains("OUTER"))
				return false;
		}
		
		//Get all the tables of the from clause
		Collection<ExtList> tablesList = list_from.getNodesInDepth(ruleNames[RULE_table_or_subquery]);
		for(ExtList table: tablesList){
			String name = (String) ((ExtList)table.getNodesInDepth(ruleNames[RULE_table_name])).getNodesInDepth(ruleNames[RULE_any_name]).get(0);
			
			//If the table does not exist in the db (need to check because need the primary keys)
			if(!dbTables.contains(name))
				return false;
			
			ExtList aliasList = (ExtList) table.getNodesInDepth(ruleNames[RULE_table_alias]);
			
			if(aliasList.isEmpty()){
				Table newTable = new Table(name);
				fromClauseTables.add(newTable);
				mapNameTable.put(new NameAlias(name, ""), newTable);
			}
			else{
				String alias = (String)((ExtList)aliasList.getNodesInDepth(ruleNames[RULE_any_name])).get(0);
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
	
	private boolean setWhereClausePredicate(){
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
				String attName = att.split(".")[1];
				
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
				String att1Name = att1.split(".")[1], att2Name = att2.split(".")[1];
				
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
