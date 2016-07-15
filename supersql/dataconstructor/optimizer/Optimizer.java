package supersql.dataconstructor.optimizer;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import supersql.common.Log;
import supersql.dataconstructor.optimizer.attributes.Attribute;
import supersql.dataconstructor.optimizer.attributes.TfeAttribute;
import supersql.dataconstructor.optimizer.nodes.Node;
import supersql.dataconstructor.optimizer.nodes.NodeManager;
import supersql.dataconstructor.optimizer.predicates.Predicate;
import supersql.dataconstructor.optimizer.predicates.PredicateManager;
import supersql.dataconstructor.optimizer.querygraph.QueryGraph;
import supersql.dataconstructor.optimizer.querygraph.QueryTree;
import supersql.dataconstructor.optimizer.querymaker.QueryMaker;
import supersql.dataconstructor.optimizer.tables.Table;

public class Optimizer {
	//Inputs
	Collection<TfeAttribute> tfeAttributes;
	Collection<Table> fromClauseTables;
	Predicate whereClausePredicate;
	
	//Intermediate variables
	NodeManager nodeManager;
	PredicateManager predicateManager;
	QueryGraph queryGraph;
	QueryMaker queryMaker;
	
	public Optimizer(Collection<TfeAttribute> tfeAttributes, Collection<Table> fromClauseTables, Predicate whereClausePredicate){
		this.tfeAttributes = tfeAttributes;
		this.fromClauseTables = fromClauseTables;
		this.whereClausePredicate = whereClausePredicate;
		
		this.nodeManager = new NodeManager();
		this.predicateManager = new PredicateManager();
		
	}
	
	public void optimize() throws Exception{
		Log.info("*****************Start optimization******************");
		nodeManager.initNodesAndTables(tfeAttributes, fromClauseTables);
		boolean existsCycles = true;
	
		while(existsCycles){
			infoOptimizer("Initialize and factorize predicate");
			predicateManager.initPredicate(whereClausePredicate, fromClauseTables);
			predicateManager.factorizePredicate();
			List<Node> nodes = nodeManager.getNodes();
			
			infoOptimizer("Generate query graph");
			queryGraph = new QueryGraph(nodes, predicateManager.getBinaryPredicates());
			
			
			if(queryGraph.detectCycle()){
				infoOptimizer("Contains cycle");
				manageCycles();
			}
			else{
				existsCycles = false;
				infoOptimizer("Make queries");
				queryMaker = new QueryMaker(nodeManager.getNodes(), predicateManager.getUnaryPredicates(), predicateManager.getBinaryPredicates(), queryGraph);
				queryMaker.makeQueries();
				
				infoOptimizer("IRS number: " + nodeManager.getNodes().size());
			}
		}
		return;
	}
	
	public Map<Node, String> getDirectQueries(){
		return queryMaker.getDirectQueries();
	}
	
	public List<String> getMaterializationQueries(){
		return queryMaker.getMaterializationQueries();
	}
	
	public Map<QueryTree, List<String>> getFullReducerQueries(){
		return queryMaker.getFullReducerQueries();
	}
	
	public Map<Node, String> getRetrievalQueries(){
		return queryMaker.getRetrievalQueries();
	}
	
	public Map<String, Attribute> getMapNameAttribute(){
		return queryMaker.getMapNameAttribute();
	}
	
	public Collection<Node> getNodes(){
		return nodeManager.getNodes();
	}
	
	private void manageCycles(){
		List<List<Node>> cycles = queryGraph.getCycleBase();
		infoOptimizer("cycle base: " + cycles);
		infoOptimizer("perform fusion");
		for(List<Node> cycle: cycles){
			nodeManager.fusionNodes(cycle);
		}
		return;
	}
	
	public static void infoOptimizer(String message){
		Log.info("[Query optimizer]: " + message);
	}
	
	public static void errorOptimizer(String message){
		Log.err("[Query optimizer]: " + message);
	}
}
