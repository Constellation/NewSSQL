package supersql.codegenerator;

import java.util.ArrayList;
import java.util.Hashtable;
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

	private static TFE schemaTop;

	private ExtList sch;

	private static Hashtable attp;

	private static int attno;

	private static String att_tmp;
	
	private static Factory factory;
	public static Manager manager;
	public static int TFEid;
	private static String media;


	public void CodeGenerator(Start_Parse parser) {
		attno = 0;
		initialize(parser);
	}

	public static void initialize(Start_Parse parser){
		attp = new Hashtable();
		ExtList tfe = (ExtList)((ExtList)parser.list_tfe.get(1)).get(0);

		media = ((ExtList) parser.list_media.get(1)).get(1).toString();
		setFactory(media);
		initiate();

		schemaTop = initialize(tfe);

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

	public static TFE initialize(ExtList tfe){
		TFE out_sch = null;
		int dim;
		
		out_sch = makeschematop(tfe);
		
		return out_sch;
	}

	private static TFE makeschematop(ExtList list){
		TFE tfe = null;
		ExtList test;
		String att = new String();
		Log.info(list);
		if(list.get(0).toString().equals("operand")){
			test = (ExtList) list.get(1);
			Log.info("test:"+test);
			if(((ExtList)test.get(0)).get(0).toString().equals("table_alias")){
				Log.info(((ExtList)((ExtList)((ExtList)((ExtList)test.get(0)).get(1)).get(0)).get(1)).get(0));
				att = ((ExtList)((ExtList)((ExtList)((ExtList)test.get(0)).get(1)).get(0)).get(1)).get(0).toString();
				att = att + test.get(1).toString();
				att = att + ((ExtList)((ExtList)((ExtList)((ExtList)test.get(2)).get(1)).get(0)).get(1)).get(0).toString();
				Log.info(att);
				Attribute Att = makeAttribute(att);
				tfe = Att;
			}else{
				
			}
		}else{
			tfe = makeschematop((ExtList)((ExtList)list.get(1)).get(0));
		}
		
		return tfe;
		
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
	
	public static Attribute createAttribute() {
	    Attribute attribute = factory.createAttribute(manager);
		attribute.setId(TFEid++);
		return attribute;
	}


	private static Attribute makeAttribute(String token){
		return makeAttribute(token, false);
	}
	
	private static Attribute makeAttribute(String token, boolean skipCondition) {
		String line;
		String name;
		String key = "";

		int as_string = token.toLowerCase().indexOf(" as ");
		if (as_string != -1) {
			line = (String) (token.substring(0, as_string));
			name = (String) (token.substring(as_string + 4));
		} else {
			line = token;
			name = token;
		}

		// tk to ignore space between = and value/////////////////
		line = line.trim();
		name = name.trim();
		att_tmp = name;
		// tk//////////////////////////////////
		Log.out("[makeAttribute] line : " + line);
		Log.out("[makeAttribute] name : " + name);

		Log.info(key);
		Attribute att = createAttribute();
		attno = att.setItem(attno, name, line, key, attp);

//		this.setDecoration(att);

		return att;

	}

	
	//	public static String getMedia(SSQLParseTree node){
	//		String media = node.children.get(1).node;
	//		return media;
	//	}
}
