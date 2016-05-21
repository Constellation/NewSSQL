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

	private static Hashtable attp;

	private static int attno;

	private static String att_tmp;

	private static String media;

	private static Factory factory;
	
	public static TFE schemaTop;
	public static ExtList sch;
	public static ExtList schema;
	public static Manager manager;
	public static int TFEid;


	public void CodeGenerator(Start_Parse parser) {
		attno = 0;
		initialize(parser);
	}

	public static void initialize(Start_Parse parser){
		attp = new Hashtable();
		ExtList tfe = (ExtList)parser.list_tfe.get(1);

		media = ((ExtList) parser.list_media.get(1)).get(1).toString();
		setFactory(media);
		initiate();

		schemaTop = initialize((ExtList)tfe.get(0));

		sch = schemaTop.makesch();
		schema = schemaTop.makeschImage();
		Log.info("Schema is " + sch);
		Log.info("le0 is " + schemaTop.makele0());

		parser.schemaTop = schemaTop;
		parser.sch = sch;
		parser.schema = schema;
		
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
		tfe = read_attribute(list);

		return tfe;

	}

	private static TFE read_attribute(ExtList tfe_tree){
		String att = new String();
		TFE out_sch = null;
		if(tfe_tree.get(0).toString().equals("operand")){
			if(((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("table_alias")){
				att = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
				att = att + ((ExtList)tfe_tree.get(1)).get(1).toString();
				att = att + ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(2)).get(1)).get(0)).get(1)).get(0);
				Attribute Att = makeAttribute(att);
				out_sch = Att;
			}else if(((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("column_name")){
				att = ((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(0)).get(1)).get(0)).get(1)).get(0).toString();
				Attribute Att = makeAttribute(att);
				out_sch = Att;
			}else if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("grouper") ){
				out_sch = grouper((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1));
			}
			else{

			}
		}else if(tfe_tree.get(0).toString().equals("h_exp")){
			out_sch = connector_main((ExtList)tfe_tree.get(1), 1);
		}else if(tfe_tree.get(0).toString().equals("v_exp")){
			out_sch = connector_main((ExtList)tfe_tree.get(1), 2);
		}else if(tfe_tree.get(0).toString().equals("d_exp")){
			out_sch = connector_main((ExtList)tfe_tree.get(1), 3);
		}else{
			out_sch = makeschematop((ExtList)((ExtList)tfe_tree.get(1)).get(0));
		}
		return out_sch;
	}
	
	private static Connector connector_main(ExtList operand, int dim){
		ExtList atts = new ExtList();
		
		for(int i = 0; i <= operand.size(); i++){
			TFE att = read_attribute((ExtList)operand.get(i));
			atts.add(att);
			i++;
		}
		
		
		Connector con = createconnector(dim);
		
		for (int i = 0; i < atts.size(); i++) {
			con.setTFE((ITFE) (atts.get(i)));
		}

		return con;
		
	}
	
	private static Grouper grouper(ExtList operand){
		String iterator = new String();
		int dim = 0;
		TFE operand1 = read_attribute((ExtList)operand.get(1));
		
		if(operand.get(operand.size() - 1).toString().equals("!")){
			dim = 2;
		}else if(operand.get(operand.size() - 1).toString().equals(",")){
			dim = 1;
		}
		
		Grouper grp = creategrouper(dim);
		grp.setTFE(operand1);
		
		return grp;
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

		Attribute att = createAttribute();
		attno = att.setItem(attno, name, line, key, attp);

		//		this.setDecoration(att);

		return att;

	}
	
	public Hashtable get_attp() {
		return this.attp;
	}


	//	public static String getMedia(SSQLParseTree node){
	//		String media = node.children.get(1).node;
	//		return media;
	//	}
}
