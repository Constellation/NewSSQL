package supersql.dataconstructor.optimizer.construction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import supersql.dataconstructor.optimizer.attributes.Attribute;
import supersql.dataconstructor.optimizer.attributes.TfeAttribute;
import supersql.dataconstructor.optimizer.attributes.TfePath;
import supersql.dataconstructor.optimizer.database.Tuple;
import supersql.dataconstructor.optimizer.nodes.Node;
import supersql.dataconstructor.optimizer.nodes.NodeTfeCoordinate;
import supersql.extendclass.ExtList;

public class TreeMaker {
	private Collection<Node> node;
	private Map<Node, List<Tuple>> nodeResults;
	
	private ExtList constructedData;
	
	public TreeMaker(Collection<Node> b, Map<Node, List<Tuple>> br, ExtList cd){
		node = b;
		nodeResults = br;
		constructedData = cd;
	}
	
	public void getConstructedData(){
		for(Node node : node){
			if(nodeResults.containsKey(node))
				getConstructedData(node);
		}
		if(constructedData.isEmpty()){
			for(Node node : node){
				manageEmptiness(node.getCoordinates(), constructedData);
			}
		}
	}
	
	private void getConstructedData(Node node){
		List<Tuple> results = nodeResults.get(node);
		NodeTfeCoordinate nodeCoordinates = node.getCoordinates();
		for(Tuple tuple: results){
			getConstructedData(nodeCoordinates, tuple, constructedData);	
		}
	}
	
	private void manageEmptiness(NodeTfeCoordinate nodeCoordinates, ExtList tfeList){
		Collection<NodeTfeCoordinate> subCoordinates = nodeCoordinates.getSubCoordinates();
		
		for(NodeTfeCoordinate subCoordinate : subCoordinates){
			int subLocalIndex = subCoordinate.getLocalIndex();
			if(subLocalIndex >= tfeList.size()){
				if(subCoordinate.isAttribute())
					tfeList.addObject(subLocalIndex, "");
				else{
					ExtList newSubTupleList = new ExtList();
					ExtList newSubTfeList = new ExtList();
					newSubTupleList.add(newSubTfeList);
					tfeList.addObject(subLocalIndex, newSubTupleList);
					manageEmptiness(subCoordinate, newSubTfeList);
				}
			}
			else{
				Object o = tfeList.get(subLocalIndex);
				if(o == null){
					if(subCoordinate.isAttribute())
						tfeList.addObject(subLocalIndex, "");
					else{
						ExtList newSubTupleList = new ExtList();
						ExtList newSubTfeList = new ExtList();
						newSubTupleList.add(newSubTfeList);
						tfeList.addObject(subLocalIndex, newSubTupleList);
						manageEmptiness(subCoordinate, newSubTfeList);
					}
				}
				else if(o instanceof ExtList){
					ExtList subTupleList = (ExtList) o;
					if(!subTupleList.isEmpty()){
						Object stfel = subTupleList.get(0);
						if(stfel instanceof ExtList)
							manageEmptiness(subCoordinate, (ExtList) stfel);
					}
				}
			}
		}
	}
	
	private void getConstructedData(NodeTfeCoordinate nodeCoordinates, Tuple tuple, ExtList list){
		Collection<NodeTfeCoordinate> subCoordinates = nodeCoordinates.getSubCoordinates();
		
		//When the current coordinate is the root, just call recursively this for all the appropriate subcoordinates
		if(nodeCoordinates.getLocalIndex() == NodeTfeCoordinate.ROOT){
			for(NodeTfeCoordinate subCoordinate: subCoordinates){
				int localIndex = subCoordinate.getLocalIndex();
				ExtList subList;
				if(localIndex >= list.size()){
					subList = new ExtList();
					list.addObject(localIndex, subList);
				}
				else{
					Object sl = list.get(localIndex);
					if(sl instanceof ExtList){
						subList = (ExtList) sl;
					}
					else {
						subList = new ExtList();
						list.add(localIndex, subList);
					}
				}
				
				getConstructedData(subCoordinate, tuple, subList);
			}
		}
		
		else {
			//Get the attributes to be added in this node
			ArrayList<TfePath> neededAttributePaths = new ArrayList<TfePath>();
			ArrayList<Attribute> neededAttributes = new ArrayList<Attribute>();
			HashSet<Attribute> attributeList = tuple.getAttributesList();
			for(NodeTfeCoordinate subCoordinate: subCoordinates){
				if(subCoordinate.isAttribute()){
					TfePath localPath = subCoordinate.getLocalPath();
					boolean found = false;
					for(Attribute att : attributeList){
						if(att instanceof TfeAttribute){
							TfeAttribute tfeAtt = (TfeAttribute) att;
							List<TfePath> paths = tfeAtt.getTfePaths();
							for(TfePath path : paths){
								if(path.equals(localPath)){
									neededAttributePaths.add(path);
									neededAttributes.add(tfeAtt);
									found = true;
									break;
								}
							}
						}
						if(found)
							break;
					}
				}
			}
			
			//Check if the values of the tuple already exists among the values of this node
			boolean createAList = true;
			for(int i=0; i<list.size() && createAList; i++){
				Object sl = list.get(i);
				if(sl instanceof ExtList){
					ExtList subList = (ExtList) sl;
					
					boolean equal = true;
					for(int j=0; j<neededAttributePaths.size() && equal; j++){
						Attribute att = neededAttributes.get(j);
						int index = neededAttributePaths.get(j).getLeafIndex();
						String value = tuple.getValue(att);
						Object comp = subList.get(index);
						
						if(comp instanceof String){
							String compare = (String) comp;
							if(!value.equals(compare))
								equal = false;
						}
					}
					if(equal){
						createAList = false;
						
						for(NodeTfeCoordinate subCoordinate : subCoordinates){
							if(!subCoordinate.isAttribute()){
								int subLocalIndex = subCoordinate.getLocalIndex();
								ExtList subSubList;
								if(subLocalIndex >= subList.size()){
									subSubList = new ExtList();
									subList.addObject(subLocalIndex, subSubList);
								}
								else{
									Object ssl = subList.get(subLocalIndex);
									if(ssl instanceof ExtList){
										subSubList = (ExtList) ssl;
									}
									else{
										subSubList = new ExtList();
										subList.addObject(subLocalIndex, subSubList);
									}	
								}
								getConstructedData(subCoordinate, tuple, subSubList);
								/*ExtList subSubList = new ExtList();
								getConstructedData(subCoordinate, tuple, subSubList);
								subList.addObject(subLocalIndex, new ExtList());*/
							}
						}
					}
				}
			}
			
			//If needed, create a list with the corresponding values of the node
			if(createAList){
				ExtList newSubList = new ExtList();
				for(int k=0; k<neededAttributePaths.size(); k++){
					int index = neededAttributePaths.get(k).getLeafIndex();
					Attribute att = neededAttributes.get(k);
					String value = tuple.getValue(att);
					newSubList.addObject(index, value);
				}
				
				for(NodeTfeCoordinate subCoordinate : subCoordinates){
					if(!subCoordinate.isAttribute()){
						int subLocalIndex = subCoordinate.getLocalIndex();
						ExtList subSubList = new ExtList();
						newSubList.addObject(subLocalIndex, subSubList);
						getConstructedData(subCoordinate, tuple, subSubList);
					}
				}
				list.add(newSubList);
			}
		}
		return;
	}
}
