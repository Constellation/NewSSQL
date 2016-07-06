package supersql.dataconstructor.optimizer.construction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import supersql.common.Log;
import supersql.dataconstructor.optimizer.attributes.Attribute;
import supersql.dataconstructor.optimizer.database.DatabaseManager;
import supersql.dataconstructor.optimizer.database.Tuple;
import supersql.dataconstructor.optimizer.nodes.Node;
import supersql.dataconstructor.optimizer.querygraph.QueryTree;
import supersql.extendclass.ExtList;

public class RetrievalManager {
	private DatabaseManager database;
	
	private Collection<Node> optimizerNodes;
	private Collection<Node> nonMaterializedNodes;
	private Collection<Node> nonExternalNodes;
	
	private Map<Node, String> directRetrievalQueries;
	private Map<Node, String> retrievalQueries;
	private List<String> materializationQueries;
	private Map<QueryTree, List<String>> fullReducerQueries;
	
	private Map<String, Attribute> mapNameAttribute;
	
	//Intermediate variables
	private Map<Node, List<Tuple>> nodeResults;
	
	//Output
	private ExtList constructedData;
	
	public RetrievalManager(DatabaseManager db, Collection<Node> nodes, Map<Node, String> direct,
			Map<Node, String> retrieval, List<String> mat, Map<QueryTree, List<String>> full, Map<String, Attribute> mapName){
		database = db;
		optimizerNodes = nodes;
		directRetrievalQueries = direct;
		retrievalQueries = retrieval;
		materializationQueries = mat;
		fullReducerQueries = full;
		mapNameAttribute = mapName;
		
		nonMaterializedNodes = directRetrievalQueries.keySet();
		
		nodeResults = new Hashtable<Node, List<Tuple>>();
		constructedData = new ExtList();
		
		nonExternalNodes = new ArrayList<Node>();
		for(Node node: optimizerNodes){
			if(!node.isExternalNode())
				nonExternalNodes.add(node);
		}
	}
	
	public void dataConstruction() throws Exception{
		printQueries();
		retrieveData();
		checkEmptiness();
		constructData();
	}
	
	public Map<Node, List<Tuple>> getNodeResults(){
		return nodeResults;
	}
	
	public ExtList getConstructedData(){
		return constructedData;
	}
	
	public void retrieveData() throws Exception{
		Log.info("Data retireval...");
		database.openConnection();
		
		for(Node currentNode: nonMaterializedNodes){
			addNodeResult(currentNode, database.executeQuery(directRetrievalQueries.get(currentNode), mapNameAttribute));
		}
		
		for(String query: materializationQueries){
			database.executeUpdate(query);
		}
		
		
		QueryTree[] trees = fullReducerQueries.keySet().toArray(new QueryTree[0]);
		
		for(int i=0; i<trees.length; i++){
			QueryTree currentTree = trees[i];
			List<String> queryList = fullReducerQueries.get(currentTree);
			if(!queryList.isEmpty()){
				for(String query: queryList){
					database.executeUpdate(query);
				}
			
				setNodeResult(currentTree);
			}
		}
		
		database.closeConnection();
		infoRetrieval("Data retrieval achieved");
	}
	
	public static void infoRetrieval(String message){
		Log.info("[Retrieval manager]: " + message);
	}
	
	public static void errRetrieval(String message){
		Log.err("[Retrieval manager]: " + message);
	}
	
	private void printQueries(){
		infoRetrieval("****************Generated queries******************");
		
		infoRetrieval("-----------Direct retrieval queries-----------");
		for(String query: directRetrievalQueries.values()){
			infoRetrieval(query);
		}
		
		infoRetrieval("-----------Materialization queries-----------");
		for(String query: materializationQueries){
			infoRetrieval(query);
		}
		
		infoRetrieval("-----------Full reducer queries-----------");
		for(List<String> queries: fullReducerQueries.values()){
			for(String query: queries){
				infoRetrieval(query);
			}
		}
		
		infoRetrieval("-----------Retrieval queries-----------");
		for(String query: retrievalQueries.values()){
			infoRetrieval(query);
		}
	}
	
	private void constructData(){
		infoRetrieval("Data construction...");
		TreeMaker treeMaker = new TreeMaker(nonExternalNodes, nodeResults, constructedData);
		treeMaker.getConstructedData();
		infoRetrieval("Data construction achieved");
	}
	
	private void checkEmptiness(){
		boolean isEmpty = false;
		for(Node node : nonExternalNodes){
			if(nodeResults.get(node).isEmpty()){
				isEmpty = true;
				break;
			}
		}
		if(isEmpty){
			for(Node node : nonExternalNodes){
				nodeResults.put(node, new ArrayList<Tuple>());
			}
		}
	}
	
	private void setNodeResult(QueryTree tree) throws Exception{
		Node currentNode = tree.getRoot();
		if(!currentNode.isExternalNode()){
			nodeResults.put(currentNode, database.executeQuery(retrievalQueries.get(currentNode), mapNameAttribute));
			
			for(QueryTree child: tree.getChildren()){
				setNodeResult(child);
			}
		}
	}
	
	private void addNodeResult(Node branch, List<Tuple> set){
		nodeResults.put(branch, set);
	}
}
