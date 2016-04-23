package supersql.codegenerator;

import java.util.ArrayList;
import java.util.List;

import supersql.src.SSQLParseTree;
import supersql.src.Start_Parse;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.LevenshteinDistance;
import supersql.common.Log;
import supersql.common.ParseXML;

public class CodeGenerator {
	private static Factory factory;
	public static Manager manager;
	public static int TFEid;	
	private static String media;
	
	public static void setFactory(String media) {
		media = media;
		
		if (media.toLowerCase().equals("html")) {
			factory = new Factory();
			// add 20141204 masato for ehtml
		}
//		if (media.toLowerCase().equals("pdf")) {
//			factory = new PDFFactory();
//			// add 20141204 masato for ehtml
//		} else if (media.toLowerCase().equals("html") || media.toLowerCase().equals("ehtml")) {
//			factory = new HTMLFactory();			
//		} else if (media.toLowerCase().equals("x3d")) {
//			factory = new X3DFactory();
//		} else if(media.toLowerCase().equals("xml")){
//			factory = new XMLFactory();
//		} else if (media.toLowerCase().equals("swf")) {
//		 	factory = new SWFFactory();
//		} else if (media.toLowerCase().equals("mobile_html5")) {	//added by goto 20121217
//		 	factory = new Mobile_HTML5Factory();
//		}  else if (media.toLowerCase().equals("csv")) {
//			factory = new SWFFactory();
//		}  else if (media.toLowerCase().equals("html_flexbox")) {
//			factory = new HTML_FlexboxFactory();
//		}
		/*
		 * else if(media.toLowerCase().equals("xml")){ factory = new
		 * XMLFactory(); }
		 */
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

	
	public static void CodeGenerator(Start_Parse parser){
		List<SSQLParseTree> tree = parser.List_tree_b;
		int dim;
		
		
		for(int i = 0; i < tree.size(); i++){
			if(tree.get(i).parent_info.equals("media")){
				media = getMedia(tree.get(i));
				setFactory(media);
				initiate();
			}
			if(tree.get(i).parent_info.equals("d_exp")){
				dim = 3;
				createconnector(dim);
			}
			if(tree.get(i).parent_info.equals("v_exp")){
				dim = 2;
				createconnector(dim);
			}
			if(tree.get(i).parent_info.equals("h_exp")){
				dim = 1;
				createconnector(dim);
			}
			if(tree.get(i).parent_info.equals("grouper")){
				if(tree.get(i).children.get(3).node.equals(",")){
					dim = 1;
				}
				
				if(tree.get(i).children.get(3).node.equals("!")){
					dim = 2;
				}
			}
		}	
	}

	public static void initiate() {
		if (factory != null) {
			Log.out("factory is " + factory);
			factory.createLocalEnv();
			manager = factory.createManager();
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
	
	public static String getMedia(SSQLParseTree node){
		String media = node.children.get(1).node;
		return media;
	}
}
