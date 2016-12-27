package supersql.codegenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

import supersql.codegenerator.Compiler.Compiler;
import supersql.codegenerator.Compiler.JSP.JSPFactory;
import supersql.codegenerator.Compiler.PHP.PHP;
import supersql.codegenerator.Compiler.Rails.RailsFactory;
import supersql.codegenerator.HTML.HTMLFactory;
import supersql.codegenerator.Mobile_HTML5.Mobile_HTML5;
import supersql.codegenerator.Mobile_HTML5.Mobile_HTML5Factory;
import supersql.codegenerator.Mobile_HTML5.Mobile_HTML5_dynamic;
import supersql.codegenerator.PDF.PDFFactory;
import supersql.codegenerator.VR.VRFactory;
import supersql.codegenerator.Web.WebFactory;
import supersql.codegenerator.X3D.X3DFactory;
import supersql.common.GlobalEnv;
import supersql.common.LevenshteinDistance;
import supersql.common.Log;
import supersql.common.ParseXML;
import supersql.common.Ssedit;
import supersql.ctab.Ctab3;
import supersql.extendclass.ExtList;
import supersql.parser.Preprocessor;
import supersql.parser.Start_Parse;


public class CodeGenerator {

	private static Hashtable attp;

	private static int attno;

	private static String att_tmp;

	private static String media;

	private static Factory factory;

	//	private static boolean decocheck = false;

	public static TFE schemaTop;
	public static ExtList sch;
	public static ExtList schema;
	public static Manager manager;
	public static int TFEid;


	public void CodeGenerator(Start_Parse parser) {
		attno = 0;
		initialize(parser);
	}

	public static TFE initialize(ExtList tfe){
		TFE out_sch = null;
		int dim;
		out_sch = makeschematop(tfe);

		return out_sch;
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
		}else if(media.toLowerCase().equals("mobile_html5")){
			factory = new Mobile_HTML5Factory();
		} else if (media.toLowerCase().equals("bhtml") || media.toLowerCase().equals("html_bootstrap") || media.toLowerCase().equals("responsivehtml")|| media.toLowerCase().equals("responsive_html")) {
			factory = new Mobile_HTML5Factory();
			Sass.bootstrapFlg(true);
		}else if(media.toLowerCase().equals("web")) {
			factory = new WebFactory();
		}else if(media.toLowerCase().equals("x3d")){
			factory = new X3DFactory();
		}else if(media.toLowerCase().equals("vr") || media.toLowerCase().equals("unity")){
			factory = new VRFactory();
		}else if(media.toLowerCase().equals("pdf")){
			factory = new PDFFactory();
		}else if(media.toLowerCase().equals("php")){	//added by goto 20161104
			PHP.isPHP = true;
			supersql.codegenerator.Compiler.Compiler.isCompiler = true;
			factory = new Mobile_HTML5Factory();
			//factory = new PHPFactory();
		}else if(media.toLowerCase().equals("rails")){	//added by goto 20161104
			factory = new RailsFactory();
		}else if(media.toLowerCase().equals("jsp")){	//added by goto 20161104
			factory = new JSPFactory();
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

			//161114 yhac
			if (GlobalEnv.isSsedit_autocorrect()) {
				Ssedit.sseditInfo();
			}

			System.exit(1);
		}
	}

	public static String getMedia(){
		return media;
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

		
		// 2016/12/16 commentout by taji
//		ExtList test = reverse(schemaTop.makele0());
//		Log.info("test:" + test);
//		Log.info( getText(test, Start_Parse.ruleNames) );

		parser.schemaTop = schemaTop;
		parser.sch = sch;
		parser.schema = schema;
	}

	// 2016/12/16 commentout by taji
//	private static ExtList reverse(ExtList extlist){
//		ExtList tmp = new ExtList();
//		if(extlist.get(0).toString().endsWith("G2")){
//			tmp.add("grouper");
//			ExtList G = new ExtList();
//			G.add("[");
//			G.add( reverse((ExtList)extlist.get(1)) );
//			G.add("]");
//			G.add("!");
//			tmp.add(G);
//		}else if(extlist.get(0).toString().endsWith("G1")){
//			tmp.add("grouper");
//			ExtList G = new ExtList();
//			G.add("[");
//			G.add( reverse((ExtList)extlist.get(1)) );
//			G.add("]");
//			G.add(",");
//			tmp.add(G);
//		}else if(extlist.get(0).toString().endsWith("C2")){
//			ExtList C = new ExtList();
//			tmp.add("v_exp");
//			for(int i = 1; i < extlist.size(); i++){
//				C.add(reverse((ExtList)extlist.get(i)));
//				if(i != extlist.size() - 1){
//					C.add("!");
//				}
//			}
//			tmp.add(C);
//		}else if(extlist.get(0).toString().endsWith("C1")){
//			ExtList C = new ExtList();
//			tmp.add("h_exp");
//			for(int i = 1; i < extlist.size(); i++){
//				C.add(reverse((ExtList)extlist.get(i)));
//				if(i != extlist.size() - 1){
//					C.add(",");
//				}
//			}
//			tmp.add(C);
//		}
//		else if(extlist.size() > 1){//function?
//			ExtList F = new ExtList();
//			for(int i = 0; i < extlist.size(); i++){
//				if(extlist.get(i) instanceof ExtList){
//					F.add(reverse((ExtList)extlist.get(i)));
//				}else{
//					ExtList temp1 = new ExtList();
//					temp1.add(extlist.get(i));
//					F.add(reverse(temp1));
//				}
//				if(i != extlist.size() - 1){
//					F.add(",");
//				}
//			}
//			tmp.add(F);
//		}
//		else if( extlist.get(0) instanceof Integer ){
//			ExtList A = new ExtList();
//			A.add(attp.get(extlist.get(0)).toString());
//			tmp.add("operand");
//			tmp.add(A);
//		}else if( extlist.get(0) instanceof String ){
//			ExtList S = new ExtList();
//			S.add( "\"" + extlist.get(0) + "\"" );
//			tmp.add("operand");
//			tmp.add(S);
//		}
//
//		return tmp;
//	}

	public Hashtable get_attp() {
		return this.attp;
	}

	public void generateCode(Start_Parse parser, ExtList data_info) {

		ITFE tfe_info = parser.get_TFEschema();

		//	ɬ�פʤ饳���ȥ����ȳ�����Manager������ѹ�
		//	manager.preProcess(tab,le,le1,le2,le3);
		//	manager.createSchema(tab,le,le1,le2,le3);
		// ?�ֳ��� Grouper�ΤȤ���data_info��Ĵ����?
		if (tfe_info instanceof Grouper && data_info.size() != 0) {
			data_info = (ExtList) data_info.get(0);
		}

		manager.generateCode(tfe_info, data_info);

		manager.finish();


	};
	public StringBuffer generateCode2(Start_Parse parser, ExtList data_info) {
		ITFE tfe_info = parser.get_TFEschema();

		//	ɬ�פʤ饳���ȥ����ȳ�����Manager������ѹ�
		//	manager.preProcess(tab,le,le1,le2,le3);
		//	manager.createSchema(tab,le,le1,le2,le3);

		Log.out("===============================");
		Log.out("     generateCode2 is start     ");
		Log.out("===============================");


		// ?�ֳ��� Grouper�ΤȤ���data_info��Ĵ����?
		if (tfe_info instanceof Grouper && data_info.size() != 0) {
			data_info = (ExtList) data_info.get(0);
		}
		Log.out("data_info.size " + data_info.size());

		if(data_info.size() == 0)
			return manager.generateCodeNotuple(tfe_info);
		else
			return manager.generateCode2(tfe_info, data_info);

	};

	public StringBuffer generateCode3(Start_Parse parser, ExtList data_info) {
		ITFE tfe_info = parser.get_TFEschema();

		//	ɬ�פʤ饳���ȥ����ȳ�����Manager������ѹ�
		//	manager.preProcess(tab,le,le1,le2,le3);
		//	manager.createSchema(tab,le,le1,le2,le3);

		Log.out("===============================");
		Log.out("     generateCode3 is start     ");
		Log.out("===============================");

		// ?�ֳ��� Grouper�ΤȤ���data_info��Ĵ����?
		if (tfe_info instanceof Grouper && data_info.size() != 0) {
			data_info = (ExtList) data_info.get(0);
		}
		Log.out("data_info.size " + data_info.size());

		if(data_info.size() == 0)
			return manager.generateCodeNotuple(tfe_info);
		else
			return manager.generateCode3(tfe_info, data_info);

	};

	public StringBuffer generateCode4(Start_Parse parser, ExtList data_info) {
		ITFE tfe_info = parser.get_TFEschema();

		//	ɬ�פʤ饳���ȥ����ȳ�����Manager������ѹ�
		//	manager.preProcess(tab,le,le1,le2,le3);
		//	manager.createSchema(tab,le,le1,le2,le3);

		Log.out("===============================");
		Log.out("     generateCode4 is start     ");
		Log.out("===============================");

		// ?�ֳ��� Grouper�ΤȤ���data_info��Ĵ����?
		if (tfe_info instanceof Grouper && data_info.size() != 0) {
			data_info = (ExtList) data_info.get(0);
		}
		Log.out("data_info.size " + data_info.size());

		if(data_info.size() == 0)
			return manager.generateCodeNotuple(tfe_info);
		else
			return manager.generateCode4(tfe_info, data_info);

	};

	public StringBuffer generateCssfile(Start_Parse parser, ExtList data_info) {
		ITFE tfe_info = parser.get_TFEschema();

		//	ɬ�פʤ饳���ȥ����ȳ�����Manager������ѹ�
		//	manager.preProcess(tab,le,le1,le2,le3);
		//	manager.createSchema(tab,le,le1,le2,le3);

		Log.out("==================================");
		Log.out("     generateCssfile is start     ");
		Log.out("==================================");

		// ?�ֳ��� Grouper�ΤȤ���data_info��Ĵ����?
		if (tfe_info instanceof Grouper && data_info.size() != 0) {
			data_info = (ExtList) data_info.get(0);
		}
		Log.out("data_info.size " + data_info.size());

		if(data_info.size() == 0)
			return manager.generateCodeNotuple(tfe_info);
		else
			return manager.generateCssfile(tfe_info, data_info);

	}

	private static TFE makeschematop(ExtList list){
		TFE tfe = null;
		tfe = read_attribute(list);

		return tfe;

	}

	private static TFE read_attribute(ExtList tfe_tree){
		String att = new String();
		TFE out_sch = null;
		String decos = new String();
		String iterator = new String();
		boolean add_deco = false;

		Asc_Desc ascDesc = new Asc_Desc();


		if(tfe_tree.get(0).toString().equals("operand")){
			if( ((ExtList)tfe_tree.get(1)).get(((ExtList)tfe_tree.get(1)).size()-1) instanceof String  && !tfe_tree.contains("true")
					&& (decos = ((ExtList)tfe_tree.get(1)).get(((ExtList)tfe_tree.get(1)).size()-1).toString().trim()).startsWith("@")
					){
				ExtList new_out = checkDecoration(tfe_tree, decos);
				//					Log.info(new_out);
				out_sch = read_attribute(new_out);
			}
			else if( ((ExtList)tfe_tree.get(1)).get(0) instanceof String ){
				if(((ExtList)tfe_tree.get(1)).get(0).toString().equals("{")){
					((ExtList)tfe_tree.get(1)).remove(0);
					((ExtList)tfe_tree.get(1)).remove(((ExtList)tfe_tree.get(1)).indexOf("}"));
					out_sch = read_attribute( (ExtList)((ExtList)tfe_tree.get(1)).get(0) );
				}else{
					att =  ((ExtList)tfe_tree.get(1)).get(0).toString();
					Attribute Att = makeAttribute(att);
					out_sch = Att;
				}
			}
			else{
				if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("sorting") ){
					if(decos.isEmpty()){
						decos = ((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(1).toString();
					}
					add_deco = true;
					((ExtList)tfe_tree.get(1)).remove(0);
				}
				if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("aggregate") ){
					if(decos.isEmpty()){
						decos = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
					}else{
						decos = decos + "," + ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
					}
					add_deco = true;
					ExtList att1 = new ExtList();
					if( ((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(2)).get(0).toString().equals("table_alias") ){
						att1.add((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(2));
						att1.add(((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(3));
						att1.add((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(4));
					}else{
						att1.add((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(2));
					}
					tfe_tree.remove(1);
					tfe_tree.add(att1);
					//					Log.info(tfe_tree);
				}

				if( ((ExtList)tfe_tree.get(1)).contains("||") ){
					int idx = ((ExtList)tfe_tree.get(1)).indexOf("||");
					String operand = join_operand((ExtList)tfe_tree.get(1), idx);
					Attribute Att = makeAttribute(operand);
					out_sch = Att;
				}
				else if(((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("table_alias")){
					att = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
					att = att + ((ExtList)tfe_tree.get(1)).get(1).toString();
					//					Log.info( ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(2)).get(1)).get(0)).get(1)).get(0) );
					if( ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(2)).get(1)).get(0)).get(1)).get(0) instanceof ExtList){
						att = att + ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(2)).get(1)).get(0)).get(1)).get(0)).get(1)).get(0);
					}else{
						att = att + ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(2)).get(1)).get(0)).get(1)).get(0);
					}
					Attribute Att = makeAttribute(att);
					out_sch = Att;
				}else if(((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("column_name")){
					if( ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0) instanceof ExtList){
						//						Log.info( ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0)).get(1)).get(0) );
						att = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
					}else{
						att = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
					}
					//					att = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
					Attribute Att = makeAttribute(att);
					out_sch = Att;
				}else if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("grouper") ){
					out_sch = grouper((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1));

					//added by goto 20161113  for Compiler:[ ] -> [ ]@{dynamic}
					Compiler.addDynamicModifier(tfe_tree);
				}else if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("composite_iterator") ){
					ExtList group = composite( (ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1) );
					add_deco = true;
					decos = (String) group.get(group.size() - 1);
					group.remove(group.size() - 1);
					out_sch = grouper(group);
				}
				else if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("function") ){
					String func_name;
					ExtList fn = new ExtList();
					fn = (ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1);
					func_name = ((ExtList)((ExtList)((ExtList)((ExtList)fn.get(0)).get(1)).get(0)).get(1)).get(0).toString();
					if(func_name.equals("cross_tab")){
						GlobalEnv env = new GlobalEnv();
						env.setCtabflag();
						Ctab3 ctab = new Ctab3();
						out_sch = read_attribute(ctab.read_tfe(fn));

						////						out_sch = func_read((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).tfe;
						////						System.err.println(tfe_tree);
						//
					}else{
						out_sch = func_read((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1));
						//						out_sch = func_read((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).fnc;
					}
				}
				else if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("sqlfunc") ){
					String sqlfunc = new String();
					//				Log.info((ExtList)tfe_tree.get(1));
					sqlfunc = getText( (ExtList)tfe_tree.get(1), Start_Parse.ruleNames );
					builder = new String();
					//				sqlfunc = sqlfunc.replaceAll("&","").trim();
					sqlfunc = sqlfunc.replaceAll("\"", "'");
					Attribute func = makeAttribute(sqlfunc);
					out_sch = func;
				}
				else if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("if_then_else") ){
					out_sch = IfCondition((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1));
				}
				else if(((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("sl")){
					att = ((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0).toString();
					Attribute SL = makeAttribute(att);
					out_sch = SL;
				}
				else if(((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("arithmetics")){
					att = getText( (ExtList)((ExtList)tfe_tree.get(1)).get(0), Start_Parse.ruleNames);
					Attribute arithmetics = makeAttribute(att);
					out_sch = arithmetics;
				}
				else{

				}
			}
			if( !(((ExtList)tfe_tree.get(1)).get( ((ExtList)tfe_tree.get(1)).size() - 1 ) instanceof ExtList) ){
				String deco = ((ExtList)tfe_tree.get(1)).get( ((ExtList)tfe_tree.get(1)).size() - 1 ).toString();
				if(deco.contains("@{")){
					//changed by goto 20161205
					ascDesc.add_asc_desc_Array(deco);

					if(add_deco){
						deco = deco.substring(0, deco.lastIndexOf("}")) + "," + decos + "}";
						setDecoration(out_sch, deco);
					}else{
						setDecoration(out_sch, deco);
					}
				}
			}else if(add_deco){
				String deco = "@{" + decos + "}";
				setDecoration(out_sch, deco);
			}
		}else if(tfe_tree.get(0).toString().equals("Decoration")){
			if( ((ExtList)tfe_tree.get(1)).size() == 1 )
				out_sch = read_attribute( (ExtList)((ExtList)tfe_tree.get(1)).get(0) );
			else if( ((ExtList)tfe_tree.get(1)).size() == 0 ){
				((ExtList)tfe_tree.get(1)).add("\"\"");
				//				Log.info(tfe_tree);
				Attribute WS = makeAttribute(((ExtList)tfe_tree.get(1)).get(0).toString());
				out_sch = WS;
			}else{
				out_sch = decoration((ExtList)tfe_tree.get(1), 1);
			}
		}else if(tfe_tree.get(0).toString().equals("n_exp")){
			out_sch = connector_main((ExtList)tfe_tree.get(1), 0);
		}else if(tfe_tree.get(0).toString().equals("h_exp")){
			if( ((ExtList)tfe_tree.get(1)).size() == 1 )
				out_sch = read_attribute( (ExtList)((ExtList)tfe_tree.get(1)).get(0) );
			else if( ((ExtList)tfe_tree.get(1)).size() == 0 ){
				((ExtList)tfe_tree.get(1)).add("\"\"");
				//				Log.info(tfe_tree);
				Attribute WS = makeAttribute(((ExtList)tfe_tree.get(1)).get(0).toString());
				out_sch = WS;
			}else
				out_sch = connector_main((ExtList)tfe_tree.get(1), 1);
		}else if(tfe_tree.get(0).toString().equals("v_exp")){
			if( ((ExtList)tfe_tree.get(1)).size() == 1 )
				out_sch = read_attribute( (ExtList)((ExtList)tfe_tree.get(1)).get(0) );
			else
				out_sch = connector_main((ExtList)tfe_tree.get(1), 2);
		}else if(tfe_tree.get(0).toString().equals("d_exp")){
			if( ((ExtList)tfe_tree.get(1)).size() == 1 ){
				out_sch = read_attribute( (ExtList)((ExtList)tfe_tree.get(1)).get(0) );
			}else
				out_sch = connector_main((ExtList)tfe_tree.get(1), 3);
		}else if(tfe_tree.get(0).toString().equals("expr")){
			int idx = ((ExtList)tfe_tree.get(1)).indexOf("=");
			out_sch = read_attribute( (ExtList)((ExtList)tfe_tree.get(1)).get(idx+1) );
		}
		else{
			out_sch = makeschematop((ExtList)((ExtList)tfe_tree.get(1)).get(0));
		}
		return out_sch;
	}

	private static String join_operand(ExtList extList, int idx) {
		String operand = null;

		if( ((ExtList)extList.get(0)).get(0).toString().equals("table_alias") ){
			operand = ((ExtList)((ExtList)((ExtList)((ExtList)extList.get(0)).get(1)).get(0)).get(1)).get(0).toString();
			operand = operand + extList.get(1).toString();
			if( ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)extList).get(2)).get(1)).get(0)).get(1)).get(0) instanceof ExtList){
				operand = operand + ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)extList).get(2)).get(1)).get(0)).get(1)).get(0)).get(1)).get(0);
			}else{
				operand = operand + ((ExtList)((ExtList)((ExtList)((ExtList)extList.get(2)).get(1)).get(0)).get(1)).get(0);
			}
			//			operand = operand + ((ExtList)((ExtList)((ExtList)((ExtList)extList.get(2)).get(1)).get(0)).get(1)).get(0).toString();
		}else if( ((ExtList)extList.get(0)).get(0).toString().equals("column_name") ){
			if(  ((ExtList)((ExtList)((ExtList)((ExtList)extList.get(0)).get(1)).get(0)).get(1)).get(0) instanceof ExtList){
				operand= ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)extList.get(0)).get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
			}else{
				operand = ((ExtList)((ExtList)((ExtList)((ExtList)extList.get(0)).get(1)).get(0)).get(1)).get(0).toString();
			}
			//			operand = ((ExtList)((ExtList)((ExtList)((ExtList)extList.get(0)).get(1)).get(0)).get(1)).get(0).toString();
		}else if( ((ExtList)extList.get(0)).get(0).toString().equals("sl") ){
			operand = ((ExtList)((ExtList)extList.get(0)).get(1)).get(0).toString();
		}
		else if( ((ExtList)extList.get(0)).get(0).toString().equals("sqlfunc") ){
			//			Log.info(extList);
			operand = getText( (ExtList)extList.get(0), Start_Parse.ruleNames );
			builder = new String();
			operand = operand.replaceAll("\"", "'");
		}
		else if( ((ExtList)extList.get(0)).get(0).toString().equals("arithmetics") ){
			operand = getText( (ExtList)((ExtList)extList.get(0)).get(1), Start_Parse.ruleNames);
		}

		if(idx > -1){
			operand = operand + extList.get(idx).toString();

			extList = (ExtList)((ExtList)extList.get(idx + 1)).get(1);
			//			Log.info(extList);

			String a = join_operand(extList, extList.indexOf("||"));
			//			operand = operand + join_operand(extList, extList.indexOf("||"));
			operand = operand + a;
		}
		//		if( ((ExtList)extList.get(0)).get(0).toString().equals("table_alias") ){
		//			operand = operand + ((ExtList)((ExtList)((ExtList)((ExtList)extList.get(0)).get(1)).get(0)).get(1)).get(0).toString();
		//			operand = operand + extList.get(1).toString();
		//			operand = operand + ((ExtList)((ExtList)((ExtList)((ExtList)extList.get(2)).get(1)).get(0)).get(1)).get(0).toString();
		//		}else if( ((ExtList)extList.get(0)).get(0).toString().equals("column_name") ){
		//			operand = operand + ((ExtList)((ExtList)((ExtList)((ExtList)extList.get(0)).get(1)).get(0)).get(1)).get(0).toString();
		//		}else if( ((ExtList)extList.get(0)).get(0).toString().equals("sl") ){
		//			operand = operand + ((ExtList)((ExtList)extList.get(0)).get(1)).get(0).toString();
		//		}
		return operand;
	}

	private static Decorator decoration(ExtList operand, int dim) {
		ExtList atts = new ExtList();
		for(int i = 0; i <= operand.size(); i++){
			//			Log.info(operand.get(i));
			TFE att = read_attribute((ExtList)operand.get(i));
			atts.add(att);
			i++;
		}
		Decorator deco = createdecorator(1);

		for (int i = 0; i < atts.size(); i++) {
			deco.setTFE((ITFE) (atts.get(i)));
		}
		return deco;
	}

	private static Connector connector_main(ExtList operand, int dim){
		ExtList atts = new ExtList();

		for(int i = 0; i <= operand.size(); i++){
			TFE att = read_attribute((ExtList)operand.get(i));
			atts.add(att);
			i++;
		}
		//		decocheck =false;
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

		if(operand.get(operand.size() - 1).toString().equals("%")){
			dim = 3;
		}else if(operand.get(operand.size() - 1).toString().equals("!")){
			dim = 2;
		}else if(operand.get(operand.size() - 1).toString().equals(",")){
			dim = 1;
		}

		Grouper grp = creategrouper(dim);
		grp.setTFE(operand1);

		return grp;
	}

	private static ExtList composite(ExtList operand){
		int index = operand.indexOf("]");
		String deco = "";
		ArrayList iterators = new ArrayList();

		for(int i = 1; i+index < operand.size(); i++ ){
			iterators.add(operand.get(i+index));
			if(i != 1){
				operand.remove(i+index);
				i--;
			}
		}

		if(iterators.get(0).equals(",")){
			deco = "column=";
			iterators.remove(0);
			deco = deco + iterators.get(0);
			iterators.remove(0);
			if(iterators.get(0).equals("!")){
				iterators.remove(0);
				if(iterators.isEmpty()){
				}else{
					deco = deco + ",row=" + iterators.get(0);
					iterators.remove(0);
				}
			}else if(iterators.get(0).equals("%")){
				iterators.remove(0);
				deco = deco + ", row=1";
			}
		}else if(iterators.get(0).equals("!")){
			deco = "row=";
			iterators.remove(0);
			deco = deco + iterators.get(0);
			iterators.remove(0);
			if(iterators.get(0).equals(",")){
				iterators.remove(0);
				if(iterators.isEmpty()){
				}else{
					deco = deco + ",column=" + iterators.get(0);
					iterators.remove(0);
				}
			}else if(iterators.get(0).equals("%")){
				iterators.remove(0);
				deco = deco + ", column=1";
			}

		}
		operand.add(deco);
		return operand;
	}

	private static Decorator createdecorator(int dim){
		Decorator decorator = new Decorator();
		if(dim == 1){
			//factory and manager
			decorator = factory.createDecoration(manager);
		}
		decorator.setId(TFEid++);
		return decorator;
	}

	private static Connector createconnector(int dim){
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
		}else if(dim == 0){
			//factory and manager
			connector = factory.createC0(manager);
		}
		connector.setId(TFEid++);
		return connector;
	}

	private static Grouper creategrouper(int dim){
		Grouper grouper = null;
		if(dim == 3){
			//factory and manager
			grouper = factory.createG3(manager);
		}else if(dim == 2){
			//factory and manager
			grouper = factory.createG2(manager);
		}else if(dim == 1){
			//factory and manager
			grouper = factory.createG1(manager);
		}
		grouper.setId(TFEid++);
		return grouper;
	}

	private static Function createFunction() {
		Function function = factory.createFunction(manager);
		function.setId(TFEid++);
		return function;
	}

	private static Attribute createAttribute() {
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
		int equalidx = token.indexOf('=');

		boolean equalSignOutsideDoubleQuote = false;
		boolean equalSignOutsideSingleQuote = false;
		if(token.contains("\"")){
			for(int i=0;i<token.length();i++){
				if(token.charAt(i) == '"'){
					break;
				}else if(token.charAt(i)=='='){
					equalSignOutsideDoubleQuote = true;
					break;
				}
			}
		}else equalSignOutsideDoubleQuote = true;
		if(token.contains("'")){
			for(int i=0;i<token.length();i++){
				if(token.charAt(i) == '\''){
					break;
				}else if(token.charAt(i)=='='){
					equalSignOutsideSingleQuote = true;
					break;
				}
			}
		}else equalSignOutsideSingleQuote = true;

		//		if (equalidx != -1 && !skipCondition) {
		if (equalidx != -1 && !skipCondition && equalSignOutsideDoubleQuote && equalSignOutsideSingleQuote) {
			// found key = att
			key = token.substring(0, equalidx);
			token = token.substring(equalidx + 1);		//TODO: <= This causes an error.  ex) "x==100"!  -> solved

			// tk to ignore space between = and value/////////////////
			key = key.trim();
			// tk///////////////////

			Log.out("[makeAttiribute] === Attribute Key : " + key + " ===");
		} else {
		}

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

		return att;

	}

	private static Function func_read(ExtList fn) {

		String token;
		Function fnc = createFunction();
		String func_name = new String();
		ExtList atts = new ExtList();
		ExtList func_atts = new ExtList();

		for(int i = 0; i < fn.size(); i++){
			if(i == 0){
				func_name = ((ExtList)((ExtList)((ExtList)((ExtList)fn.get(i)).get(1)).get(0)).get(1)).get(0).toString();
			}else if(fn.get(i) instanceof String){
				if(fn.get(i).toString().equals(",")){
					atts.add(fn.get(i));
				}else{
					continue;
				}
			}else{
				atts.add(fn.get(i));
			}
		}



		func_atts.add("h_exp");
		func_atts.add(atts);
		fnc.setFname( func_name );
		FunctionData fnd = new FunctionData(func_name);

		String name, value;

		Log.out("[func*read start funcname]=" + fn);
		/* func_read */
		Log.info(func_atts);
		TFE read_tfe = read_attribute(func_atts);

		Log.out("[func*TFE]=" + read_tfe.makele0());
		if (read_tfe instanceof Connector) {
			//		if(read_tfe instanceof Connector && ((Connector) read_tfe).getDimension() == 1){
			for(TFE tfe: ((Connector)read_tfe).tfes){
				fnc.addArg(makeFuncArg(tfe));
			}
		}
		else
			fnc.addArg(makeFuncArg(read_tfe));
		if (func_name.toLowerCase().equals("select")) {
			fnc.addDeco("select", att_tmp);
		}
		return fnc;

	}

	private static FuncArg makeFuncArg(TFE arg) {
		FuncArg out_fa;
		Log.out("argsaregs: " + arg);

		if (arg instanceof Attribute) {
			out_fa = new FuncArg(((Attribute) arg).getKey(), arg);
		} else {
			out_fa = new FuncArg("default", arg);
		}

		return out_fa;
	}

	private static String exprtostring(ExtList expr){
		String str = null;
		String att = null;
		ExtList tfe_tree = (ExtList)((ExtList)((ExtList)expr.get(0)).get(1)).get(0);
		if(tfe_tree.get(0).toString().equals("operand")){
			if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("table_alias") ){
				att = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
				att = att + ((ExtList)tfe_tree.get(1)).get(1).toString();
				if( ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(2)).get(1)).get(0)).get(1)).get(0) instanceof ExtList){
					att = att + ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(2)).get(1)).get(0)).get(1)).get(0)).get(1)).get(0);
				}else{
					att = att + ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(2)).get(1)).get(0)).get(1)).get(0);
				}
				//				att = att + ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(2)).get(1)).get(0)).get(1)).get(0);
			}else if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("column_name") ){
				if( ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0) instanceof ExtList){
					//					Log.info( ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0)).get(1)).get(0) );
					att = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
				}else{
					att = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
				}
				//				att = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
			}
		}
		str = att + expr.get(1).toString() + ((ExtList)((ExtList)((ExtList)((ExtList)expr.get(2)).get(1)).get(0)).get(1)).get(0).toString();
		return str;
	}

	private static TFE IfCondition(ExtList if_then_else) {
		String token = "";
		ExtList firstTFE;
		ExtList secondTFE;

		if(if_then_else.get(0).equals("if")){
			token = exprtostring( (ExtList)((ExtList)if_then_else.get(2)).get(1) );
			Attribute condition = makeAttribute(token, true);
			int t_idx = 0;
			if( if_then_else.indexOf("then") != -1){
				t_idx = if_then_else.indexOf("then");
			}
			firstTFE = (ExtList)if_then_else.get(t_idx + 2);

			int e_idx = 0;
			if( if_then_else.indexOf("else") != -1){
				e_idx = if_then_else.indexOf("else");
			}
			secondTFE = (ExtList)if_then_else.get(e_idx + 2);

			TFE thenTfe = initialize(firstTFE);
			TFE elseTfe = initialize(secondTFE);

			IfCondition out_tfe = makeIfCondition(condition, thenTfe, elseTfe );
			return out_tfe;
		}else{
			token = exprtostring( (ExtList)((ExtList)if_then_else.get(1)).get(1) );
			Attribute condition = makeAttribute(token, true);

			int t_idx = 0;
			if(if_then_else.indexOf("?") != -1){
				t_idx = if_then_else.indexOf("?");
			}
			firstTFE = (ExtList)if_then_else.get(t_idx + 1);

			int e_idx = 0;
			if(if_then_else.indexOf("?") != -1){
				e_idx = if_then_else.indexOf(":");
			}
			secondTFE = (ExtList)if_then_else.get(e_idx + 1);


			TFE thenTfe = initialize(firstTFE);
			TFE elseTfe = initialize(secondTFE);

			IfCondition out_tfe = makeIfCondition(condition, thenTfe, elseTfe );
			return out_tfe;
		}

	}

	private static IfCondition makeIfCondition(Attribute condition, TFE thenTfe, TFE elseTfe) {
		return createIfCondition(condition, thenTfe, elseTfe);
	}

	public static IfCondition createIfCondition(Attribute condition, TFE thenTfe, TFE elseTfe){
		IfCondition ifCondition = factory.createIfCondition(manager, condition, thenTfe, elseTfe);
		ifCondition.setId(TFEid++);
		return ifCondition;
	}

	public Attribute createConditionalAttribute(){
		Attribute condAttribute = factory.createConditionalAttribute(manager);
		condAttribute.setId(TFEid++);
		return condAttribute;
	}

	//	private Attribute makeConditionalAttribute(String condition,
	//			String[] attributes) {
	//
	//		Attribute att = cg.createConditionalAttribute();
	//		attno = att.setItem(attno, attributes[0], attributes[0], null, attp);
	//		if (attributes.length == 2) {
	//			attno = att.setItem(attno, attributes[1], attributes[1], null, attp);
	//		}
	//		att.setCondition(condition);
	//		attno = att.setItem(attno, condition, condition,
	//				null, attp);
	//		this.setDecoration(att);
	//
	//		return att;
	//	}

	private static ExtList checkDecoration(ExtList extList, String decos) {
		String token = new String();
		String name, value;
		int equalidx;
		String deco = decos.substring(decos.indexOf("{")+1, decos.lastIndexOf("}"));
		String[] decolist = deco.split(",");
		ExtList new_list = new ExtList();
		ExtList med = new ExtList();
		extList.add("true");
		med.add(extList);
		for(int i = 0; i < decolist.length; i++) {

			name = new String();
			value = new String();

			// read name
			token = decolist[i];
			equalidx = token.indexOf('=');
			if (equalidx != -1) {
				// key = idx
				name = token.substring(0, equalidx).trim();
				value = token.substring(equalidx + 1).trim();
				if(value.startsWith("\'") && value.endsWith("\'")){
					continue;
				}else if(value.startsWith("\"") && value.endsWith("\"")){
					continue;
				}else if(isNumber(value)){
					continue;
				}else{
					if(!new_list.contains("Decoration"))
						new_list.add("Decoration");
					//value:e.color->[operand, [e.color]]
					ExtList a1 = new ExtList(), a2 = new ExtList();
					a1.add("operand");
					a1.add(a2);
					((ExtList)a1.get(1)).add(value);
					med.add(",");
					med.add(a1);
				}
			}
		}
		new_list.add(med);
		//		decocheck = true;
		if(!new_list.contains("Decoration")){
			return extList;
		}else{
			return new_list;
		}
	}

	private static void setDecoration(ITFE tfe, String decos) {
		String token = new String();
		String name, value;
		int equalidx;
		decos = decos.substring(decos.indexOf("{")+1, decos.lastIndexOf("}"));
		String[] decolist = decos.split(",");
		for(int i = 0; i < decolist.length; i++) {

			name = new String();
			value = new String();

			// read name
			token = decolist[i];
			if (token.toLowerCase().contains("asc") || token.toLowerCase().contains("desc")) {

				Log.out("@ order by found @");

				new Asc_Desc().addOrderBy(token, tfe.toString());
				new Preprocessor().setOrderBy();
				tfe.setOrderBy(token);

				/* "aggregate functions" found */
			} else if (token.equalsIgnoreCase("max") ||
					token.equalsIgnoreCase("min") ||
					token.equalsIgnoreCase("avg") ||
					token.equalsIgnoreCase("sum") ||
					token.equalsIgnoreCase("count") /*||
            		   //added by goto 20130122
            		   toks.lookToken().equalsIgnoreCase("slideshow")*/) {

				Log.out("@ aggregate functions found @");

				new Preprocessor().setAggregate();
				tfe.setAggregate(token);

			}else{
				equalidx = token.indexOf('=');
				if (equalidx != -1) {
					// key = idx
					name = token.substring(0, equalidx).trim();
					value = token.substring(equalidx + 1).trim();
					if(value.startsWith("'")){
						value = value.replaceAll("'", "\"");
					}
					decoration_out(tfe, name, value);
				} else {
					// key only
					// 20161113 halken
					token = token.trim();
					decoration_out(tfe, token, "");
				}
			}
		}
		Log.out("@ decoration end @");
		// Log.out(toks.DebugTrace());

	}

	private CodeGenerator(int id){
		TFEid = id;
	}
	public CodeGenerator() {
	}

	private static void decoration_out(ITFE tfe, String name, Object value) {

		/* 鐃緒申?的鐃緒申String鐃緒申鐃緒申鐃宿わ申覆鐃�*/
		tfe.addDeco(name, (String) value);
		Log.out("[decoration name=" + name + " value=" + value + "]");

	}

	static String builder = new String();
	public static String getText(ExtList tree, String[] ruleNames){
		if(tree.size() != 1){
			for(int i = 0; i < tree.size(); i++){
				if(tree.get(i) instanceof String){
					if(Arrays.asList(ruleNames).contains(tree.get(i).toString())){
						continue;
					}else{
						if( tree.get(i).toString().equals(".") ){
							builder = builder.trim();
							builder += tree.get(i).toString();
						}
						else if(tree.get(i).toString().equals("&")){
							continue;
						}
						else{
							builder += tree.get(i).toString();
							builder += " ";
						}
					}
				}else {
					getText((ExtList)tree.get(i), ruleNames);
				}
			}
		}
		else if(tree.size() == 1 && (tree.get(0) instanceof String)){
			builder += tree.get(0).toString();
			builder += " " ;
			return builder.toString();
		}
		else if(tree.size() == 1 && ((ExtList)tree.get(0)).size() > 1 ){
			return getText((ExtList)tree.get(0), ruleNames);
		}
		else if(tree.size() == 1 && ((ExtList)tree.get(0)).size() == 1 ){
			return getText((ExtList)tree.get(0), ruleNames);
		}
		return builder.toString();
	}

	public static boolean isNumber(String val) {
		try {
			Integer.parseInt(val);
			return true;
		} catch (NumberFormatException nfex) {
			return false;
		}
	}
}
