package supersql.codegenerator;

import java.util.ArrayList;
import java.util.List;

import supersql.codegenerator.Manager;
import supersql.codegenerator.HTML.HTMLFactory;
import supersql.common.GlobalEnv;
import supersql.common.LevenshteinDistance;
import supersql.common.Log;
import supersql.common.ParseXML;
import supersql.extendclass.ExtList;
import supersql.parser.Start_Parse;

public class CodeGenerator {
	private static Factory factory;
	public static Manager manager;
	public static int TFEid;	
	private static String media;


	public static void CodeGenerator(Start_Parse parser){
		ExtList tfe = (ExtList)((ExtList)parser.list_tfe.get(1)).get(0);
		int dim;

		media = ((ExtList) parser.list_media.get(1)).get(1).toString();
		setFactory(media);
		initiate();

		while(tfe.size() != 0){
			System.out.println("TFE:"+tfe);
			if(tfe.get(0).toString().equals("d_exp")){
				dim = 3;
				createconnector(dim);
			}else if(tfe.get(0).toString().equals("v_exp")){
				dim = 2;
				createconnector(dim);
			}else if(tfe.get(0).toString().equals("h_exp")){
				dim = 1;
				createconnector(dim);
			}
			if(tfe.get(0).toString().equals("grouper")){
				
			}
			if(((ExtList)tfe.get(1)).get(0) instanceof String){
				break;
			}else{
				tfe = (ExtList)((ExtList)tfe.get(1)).get(0);
			}
			
		}

		//		
		//		for(int i = 0; i < tree.size(); i++){
		//			if(tree.get(i).equals("media")){
		//				media = getMedia(tree.get(i));
		//				setFactory(media);
		//				initiate();
		//			}
		//			if(tree.get(i).parent_info.equals("d_exp")){
		//				dim = 3;
		//				createconnector(dim);
		//			}
		//			if(tree.get(i).parent_info.equals("v_exp")){
		//				dim = 2;
		//				createconnector(dim);
		//			}
		//			if(tree.get(i).parent_info.equals("h_exp")){
		//				dim = 1;
		//				createconnector(dim);
		//			}
		//			if(tree.get(i).parent_info.equals("grouper")){
		//				if(tree.get(i).children.get(3).node.equals(",")){
		//					dim = 1;
		//				}
		//				
		//				if(tree.get(i).children.get(3).node.equals("!")){
		//					dim = 2;
		//				}
		//			}
		//		}	
	}

	public static void initiate() {
		if (factory != null) {
			Log.out("factory is " + factory);
			factory.createLocalEnv();
			manager = factory.createManager();
		}
	}

	public static void setFactory(String media) {
		if (media.toLowerCase().equals("html")) {
			factory = new HTMLFactory();
			// add 20141204 masato for ehtml
		}
		else {
			String m = media.toLowerCase();
			Log.err("Error[Media]: valid medium '"+m+"' not found");
			//			GlobalEnv.errorText += "Error[Media]: valid medium '"+m+"' not found";
			GlobalEnv.addErr("Error[Media]: valid medium '"+m+"' not found");

			//20131106
			//Log.err("\nGENERATE >>>> "+m+" <<<<");
			String XMLfile = GlobalEnv.MEDIA_XML;
			ArrayList<String> medias = ParseXML.getAttributes(XMLfile, "media", "name");
			String media_list = LevenshteinDistance.checkLevenshteinAndSuggest(m, medias);
			if(!media_list.isEmpty()){
				Log.err("\n## Media list ##\n" + media_list);
				// 20140624_masato
				//				GlobalEnv.errorText += "\n## Media list ##\n" + media_list;
			}
			System.exit(1);
		}
	}

	public static Connector createconnector(int dim){
		Connector connector = new Connector();
		if(dim == 3){
			//factory and manager
			connector = factory.createC3(manager);
		}else if(dim == 2){
			//factory and manager
			connector = factory.createC2(manager);
		}else if(dim == 1){
			//factory and manager
			connector = factory.createC1(manager);
		}
		connector.setId(TFEid++);
		return connector;
	}

	public static Grouper creategrouper(int dim){
		Grouper grouper = null;
		if(dim == 2){
			//factory and manager
			grouper = factory.createG2(manager);
		}else if(dim == 1){
			//factory and manager
			grouper = factory.createG1(manager);
		}
		grouper.setId(TFEid++);
		return grouper;
	}

	//	public static String getMedia(SSQLParseTree node){
	//		String media = node.children.get(1).node;
	//		return media;
	//	}
}
