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
import supersql.parser.Preprocessor;
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

		parser.schemaTop = schemaTop;
		parser.sch = sch;
		parser.schema = schema;
	}

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

		if(tfe_tree.get(0).toString().equals("operand")){
			if( ((ExtList)tfe_tree.get(1)).get(0) instanceof String ){
				if(((ExtList)tfe_tree.get(1)).get(0).toString().equals("{")){
					((ExtList)tfe_tree.get(1)).remove(0);
					((ExtList)tfe_tree.get(1)).remove(((ExtList)tfe_tree.get(1)).size() - 1);
				}
				out_sch = read_attribute( (ExtList)((ExtList)tfe_tree.get(1)).get(0) );
			}

			if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("sorting") ){
				decos = ((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(1).toString();
				add_deco = true;
				((ExtList)tfe_tree.get(1)).remove(0);
			}
			if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("aggregate") ){
				decos = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
				add_deco = true;
				ExtList att1 = new ExtList();
				att1.add((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(2));
				att1.add(((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(3));
				att1.add((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(4));
				Log.info(att1);
				tfe_tree.remove(1);
				tfe_tree.add(att1);
				Log.info(tfe_tree);
				
			}

			if(((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("table_alias")){
				att = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
				att = att + ((ExtList)tfe_tree.get(1)).get(1).toString();
				att = att + ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(2)).get(1)).get(0)).get(1)).get(0);
				Attribute Att = makeAttribute(att);
				out_sch = Att;
			}else if(((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("column_name")){
				att = ((ExtList)((ExtList)((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0)).get(1)).get(0).toString();
				Attribute Att = makeAttribute(att);
				out_sch = Att;
			}else if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("grouper") ){
				out_sch = grouper((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1));
			}else if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("composite_iterator") ){
				ExtList group = composite( (ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1) );
				add_deco = true;
				decos = (String) group.get(group.size() - 1);
				group.remove(group.size() - 1);
				out_sch = grouper(group);
			}
			else if( ((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("function") ){
				out_sch = func_read((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1));
			}
			else if(((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(0).toString().equals("sl")){
				att = ((ExtList)((ExtList)((ExtList)tfe_tree.get(1)).get(0)).get(1)).get(0).toString();
				Attribute SL = makeAttribute(att);
				out_sch = SL;
			}
			else{

			}
			if( !(((ExtList)tfe_tree.get(1)).get( ((ExtList)tfe_tree.get(1)).size() - 1 ) instanceof ExtList) ){
				String deco = ((ExtList)tfe_tree.get(1)).get( ((ExtList)tfe_tree.get(1)).size() - 1 ).toString();
				if(deco.contains("@{")){
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
		}else if(tfe_tree.get(0).toString().equals("n_exp")){
			out_sch = connector_main((ExtList)tfe_tree.get(1), 0);
		}else if(tfe_tree.get(0).toString().equals("h_exp")){
			if( ((ExtList)tfe_tree.get(1)).size() == 1 )
				out_sch = read_attribute( (ExtList)((ExtList)tfe_tree.get(1)).get(0) );
			else
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
					deco = deco + ", column=" + iterators.get(0);
					iterators.remove(0);
				}
			}else if(iterators.get(0).equals("%")){
				iterators.remove(0);
				deco = deco + ", column=1";
			}

		}
		operand.add(deco);
		Log.info(operand);
		return operand;
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
		Log.info(func_atts);
		fnc.setFname( func_name );
		FunctionData fnd = new FunctionData(func_name);

		String name, value;

		Log.out("[func*read start funcname]=" + fn);
		/* func_read */
		TFE read_tfe = read_attribute(func_atts);

		Log.info("[func*TFE]=" + read_tfe.makele0());
		if (read_tfe instanceof Connector) {
			//		if(read_tfe instanceof Connector && ((Connector) read_tfe).getDimension() == 1){
			for(TFE tfe: ((Connector)read_tfe).tfes){
				fnc.addArg(makeFuncArg(tfe));
			}
		}
		else
			fnc.addArg(makeFuncArg(read_tfe));
		if (fn.equals("select")) {
			fnc.addDeco("select", att_tmp);
		}

		//		this.setDecoration(fnc);

		return fnc;

	}

	private static FuncArg makeFuncArg(TFE arg) {
		FuncArg out_fa;
		Log.info("argsaregs: " + arg);

		if (arg instanceof Attribute) {
			out_fa = new FuncArg(((Attribute) arg).getKey(), arg);
		} else {
			out_fa = new FuncArg("default", arg);
		}

		return out_fa;
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
					name = token.substring(0, equalidx);
					value = token.substring(equalidx + 1);
					decoration_out(tfe, name, value);
				} else {
					// key only
					decoration_out(tfe, token, "");
				}
			}
		}
		Log.out("@ decoration end @");
		// Log.out(toks.DebugTrace());

	}

	private static void decoration_out(ITFE tfe, String name, Object value) {

		/* 鐃緒申?的鐃緒申String鐃緒申鐃緒申鐃宿わ申覆鐃�*/
		tfe.addDeco(name, (String) value);
		Log.info("[decoration name=" + name + " value=" + value + "]");

	}
}
