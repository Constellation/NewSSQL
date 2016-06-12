package supersql.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import supersql.codegenerator.AttributeItem;
import supersql.codegenerator.CodeGenerator;
import supersql.codegenerator.TFE;
import supersql.codegenerator.Mobile_HTML5.Mobile_HTML5Function;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;
import supersql.parser.org.antlr.v4.runtime.MyErrorStrategy;


public class Start_Parse {

	private static boolean jsonQuery = false;
	private static boolean dbpediaQuery = false;
	private boolean foreachFlag = false;
	private ExtList foreachinfo;
	public static boolean sessionFlag = false;
	public static String sessionString = "";
	private CodeGenerator codegenerator;
	public static ArrayList<String> textString = new ArrayList<String>();
	private static boolean prefix = false;
	private FromInfo fromInfo;
	private String groupStatement;
	private String havingStatement;
	private String foreachFrom = "";
	private String foreachWhere = "";
	private StringBuffer from_c = new StringBuffer();
	private StringBuffer where_c = new StringBuffer();
	private StringBuffer order_c = new StringBuffer();
	private StringBuffer group_c = new StringBuffer();
	private StringBuffer having_c = new StringBuffer();
	private StringBuffer embedFrom = new StringBuffer();
	private StringBuffer embedGroup = new StringBuffer();
	private StringBuffer embedHaving = new StringBuffer();
	private StringBuffer embedWhere = new StringBuffer();
	private static String fromInfoString;
	private String QueryImage;


	public static String att = null;
	public static String media = null;
	public ExtList List_tree_a, List_tree_b, list_tfe, list_from_where, list_from, list_where, list_media, list_table;
	public static Hashtable<?, ?> atts;
	public static TFE schemaTop;
	public static ExtList sch;
	public static ExtList schema;
	public WhereInfo whereInfo = new WhereInfo();
	public static boolean distinct = false;



	public Start_Parse() {
		parseSSQL(this.getSSQLQuery(), 10000);
	}

	public Start_Parse(int id) {
		parseSSQL(this.getSSQLQuery(), id);
	}

	public Start_Parse(String a) {
		parseSSQL(this.getSSQLQuery2(), 10000);
	}

	public Start_Parse(StringBuffer querybuffer) {
		parseSSQL(querybuffer.toString(), 10000);
	}
	public static void set_from_info_st(String fi) {
		fromInfoString = fi;
	}
	public static String get_from_info_st() {
		if (fromInfoString == null) {
			return "";
		}
		return fromInfoString;
	}
	public static void setDbpediaQuery(boolean dbpediaQuery) {
		Start_Parse.dbpediaQuery = dbpediaQuery;
	}
	public static void setJsonQuery(boolean jsonQuery) {
		Start_Parse.jsonQuery = jsonQuery;
	}
	public FromInfo get_from_info() {
		return fromInfo;
	}
	public CodeGenerator getcodegenerator(){
		codegenerator.TFEid = 10000;
		return codegenerator;

	}

	public static boolean isDbpediaQuery() {
		return dbpediaQuery;
	}

	public static boolean isJsonQuery() {
		return jsonQuery;
	}

	public TFE get_TFEschema(){
		TFE sch = codegenerator.schemaTop;
		return sch;    	
	}

	public Hashtable get_att_info(){
		Hashtable attp = codegenerator.get_attp();
		return attp;
	}

	public String getTFEsig(ExtList sep_sch) {

		Hashtable atts = this.get_att_info();
		FromInfo from = this.get_from_info();
		WhereInfo where = this.whereInfo;

		int i, idx;
		Object o;
		Integer itemno;
		StringBuffer buf = new StringBuffer();
		for (idx = 0; idx < sep_sch.size(); idx++) {
			o = sep_sch.get(idx);
			if (o instanceof Integer) {

				itemno = (Integer) (sep_sch.get(idx));
				AttributeItem att1 = (AttributeItem) (atts.get(itemno));
				buf.append(att1.getAttributeSig(from) + "@@");
			} else if (o instanceof ExtList) {
				buf.append("(");
				buf.append(getTFEsig((ExtList) o));
				buf.append(")");
			}
		}

		// Where
		buf.append(where.getWhereSig(from));

		return buf.toString();

	}
	public String getSSQLsig() {
		StringBuffer sig = new StringBuffer();
		//		sig.append(QueryImage.replaceAll("\\s",""));
		sig.append(QueryImage);
		String addCondition = GlobalEnv.getCondition();
		if (addCondition != null) {
			sig.append("@@");
			sig.append(addCondition);
		}
		//Log.out("[SSQL sig] = " +sig);
		return sig.toString();
	}

	public Object[] getSQLsig(ExtList sep_sch) {

		Hashtable atts = this.get_att_info();
		FromInfo from = this.get_from_info();
		WhereInfo where = this.whereInfo;

		int idx;
		Integer itemno;
		ExtList schf = sep_sch.unnest();
		StringBuffer buf = new StringBuffer();

		Hashtable sig2idx = new Hashtable();
		TreeSet sorter = new TreeSet();
		String attsig;
		ExtList ordersig = new ExtList();

		for (idx = 0; idx < schf.size(); idx++) {
			itemno = (Integer) (schf.get(idx));
			attsig = ((AttributeItem) (atts.get(itemno))).getAttributeSig(from);
			sig2idx.put(attsig, new Integer(idx));
			sorter.add(attsig);
		}

		Iterator ite = sorter.iterator();
		while (ite.hasNext()) {
			attsig = (String) ite.next();
			buf.append(attsig + "@@");
			ordersig.add(sig2idx.get(attsig).toString());
		}

		Log.out("sig:" + buf);
		Log.out("ordersig:" + ordersig);

		buf.append(where.getWhereSig(from));
		Object[] ret = { buf.toString(), ordersig };

		return ret;
	}

	private String getSSQLQuery()
	{
		//read file & query
		String query = null;
		String filename = GlobalEnv.getfilename();
		if (filename == null || filename.isEmpty()) {
			Log.err("Error[SQLparser]: File Is Not Specified.");
			GlobalEnv.addErr("Error[SQLparser]: File Is Not Specified.");
		}

		Log.info("[Parser:Parser] filename = " + filename);
		// 20140624_masato
		GlobalEnv.queryName = "[Parser:Parser] filename = " + filename;
		BufferedReader in;
		StringBuffer tmp = new StringBuffer();
		try{
			in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));		//changed by goto 20130519 (This is an important change.)
			int c;
			while ((c = in.read()) != -1) {
				tmp.append((char) c);
			}
			query = tmp.toString();
		} catch (FileNotFoundException e) {
			Log.err("Error[SQLparser]: File(" + filename	+ ") Is Not Found.");
			GlobalEnv.addErr("Error[SQLparser]: File(" + filename + ") Is Not Found." + e);
		} catch (IOException e) {
			GlobalEnv.addErr("Error[SQLparser]:" + e);
		}
		return query;


		//parse query

	}

	private String getSSQLQuery2() {

		String query = GlobalEnv.getQuery();
		if (query != null) {
			query = query.trim();
		}

		String filename = GlobalEnv.getfilename();
		if (filename != null) {
			Log.info("[Parser:Parser] filename = " + filename);
			StringBuffer tmp = new StringBuffer();
			String line = new String();
			BufferedReader dis;
			try {

				if (filename.startsWith("http:")) {
					URL fileurl = new URL(filename);

					URLConnection fileurlConnection = fileurl.openConnection();
					/*
					 * DataInputStream dis = new
					 * DataInputStream(fileurlConnection.getInputStream());
					 */
					dis = new BufferedReader(new InputStreamReader(
							fileurlConnection.getInputStream(), "EUC-JP"));
				}

				else {
					dis = new BufferedReader(new FileReader(filename));
					line = null;
				}
				while (true) {
					line = dis.readLine();

					if (line == null || line.equals("-1"))
						break;

					while (line != null && line.contains("/*")) {
						int s = line.indexOf("/*");
						String line1 = line.substring(0, s);
						// tmp.append(" "+line1);
						while (!line.contains("*/"))
							line = dis.readLine();
						int t = line.indexOf("*/");
						line = line1 + line.substring(t + 2);
					}
					// added by goto 20130412
					//					if (line != null && line.contains(commentOutLetters)) {	//commentOutLetters = "--"
					//						boolean dqFlg = false;
					//						int i = 0;
					//
					//						for (i = 0; i < line.length(); i++) {
					//							if (line.charAt(i) == '"' && !dqFlg)
					//								dqFlg = true;
					//							else if (line.charAt(i) == '"' && dqFlg)
					//								dqFlg = false;
					//
					//							if (!dqFlg
					//									&& i < line.length() - 1
					//									&& (line.charAt(i) == GlobalEnv.COMMENT_OUT_LETTER && line
					//									.charAt(i + 1) == GlobalEnv.COMMENT_OUT_LETTER))
					//								break;
					//						}
					//						line = line.substring(0, i);
					//					}

					if (line != null)
						tmp.append(" " + line);
				}
				dis.close();

			} catch (MalformedURLException me) {
				System.out.println("MalformedURLException: " + me);
			} catch (IOException ioe) {
				System.out.println("IOException: " + ioe);
				GlobalEnv.addErr("Error[SQLparser]:" + ioe);
			}

			query = tmp.toString().trim();
		}

		if (query.endsWith(";")) {
			query = query.substring(0, query.length() - 1).trim();
		}

		Log.info("[Parser:Parser] ssql statement = " + query);
		return query;
	}


	private ExtList set_fromInfo(){
		ExtList from_tables = new ExtList();
		//    	ExtList from_table = new ExtList();
		for(int i = 0; i < list_from.size(); i++){
			if(list_from.get(i) instanceof ExtList){
				from_tables.add(((ExtList)list_from.get(i)).get(1));
			}else{
				continue;
			}
		}

		return from_tables;
	}

	private void processKeywords(String where){
		StringBuffer buffer = new StringBuffer();
		buffer = from_c;
		StringTokenizer st = new StringTokenizer(where);
		while (st.hasMoreTokens()) {
			String nt = st.nextToken().toString();
			if (nt.equalsIgnoreCase("WHERE")) {
				buffer = where_c;
			}
			else if (nt.equalsIgnoreCase("ORDER")) {
				buffer = order_c;
			}
			else if (nt.equalsIgnoreCase("GROUP")) {
				buffer = group_c;
			}
			else if (nt.equalsIgnoreCase("HAVING")) {
				buffer = having_c;
			}
			else {
				buffer.append(nt + " ");
			}
			Mobile_HTML5Function.after_from_string += nt+" ";	//added by goto 20130515  "search"
		}
		Log.info(from_c);
	}

	private void postProcess() {
		// FOREACH
		if (!(foreachFrom.equals(""))) {
			from_c.append("," + foreachFrom);
		}

		groupStatement = group_c.toString();
		Log.out("[Paeser:Group] group = " + groupStatement);
		group_c.append(embedGroup + " ");

		havingStatement = having_c.toString();
		Log.out("[Paeser:Having] having = " + havingStatement);
		having_c.append(embedGroup + " ");

		fromInfo = new FromInfo(from_c.toString().trim());
		Log.out("[Parser:From] from = " + fromInfo);
		if (!(foreachFrom.equals(""))) {
			Log.out(foreachFrom
					+ ": Used in FOREACH clause and added to FROM clause ");
		}

		if (Start_Parse.isDbpediaQuery())
			whereInfo.setSparqlWhereQuery(where_c.toString().trim());
		else
			whereInfo.appendWhere(where_c.toString().trim());

		if (embedWhere.length() != 0)
			whereInfo.appendWhere(embedWhere + " ");

		Log.out("WHERE:" + whereInfo);
		// FOREACH
		if (!(foreachWhere.equals(""))) {
			whereInfo.appendWhere(foreachWhere);
			Log.out(foreachWhere
					+ ": Used in FOREACH clause and added to WHERE clause ");
		}

		String addCondition = GlobalEnv.getCondition();
		if (addCondition != null) {
			whereInfo.appendWhere(addCondition);
		}
		Log.out("[Paeser:Where] where = " + whereInfo);
	}

	private void parseSSQL(String query, int id){
		String after_from = "";

		if(!query.toLowerCase().contains("generate")){
			GlobalEnv.addErr("didn't find 'GENERATE'. please start with 'GENERATE'.");
			System.err.println("didn't find 'GENERATE'. please start with 'GENERATE'.");
		}else{
			try{
				String a = query.substring(0, query.toLowerCase().indexOf("generate"));
				String b = query.substring(query.toLowerCase().indexOf("generate"));
				Log.info(a);
				Log.info(b);

				if(a.equals(" ") || a.equals("") || a.equals("\r")){
				}else{

					ANTLRInputStream input_a = new ANTLRInputStream(a);
					prefixLexer lexer_a = new prefixLexer(input_a);
					CommonTokenStream tokens_a = new CommonTokenStream(lexer_a);

					prefixParser parser_a = new prefixParser(tokens_a);
					ParseTree tree_a = parser_a.prefix(); // begin parsing at rule query
					List_tree_a = TreeConst.createSSQLParseTree(tree_a, parser_a);
					Log.info(List_tree_a);
					if(((ExtList)List_tree_a.get(1)).get(0).toString().toLowerCase().equals("foreach"))
						foreachFlag = true;
					foreachinfo = TreeConst.getforeach(List_tree_a);
					prefix = true;

				}
				if(prefix && foreachFlag){
					StringTokenizer str = new StringTokenizer(b);
					String generate = null;
					while(str.hasMoreTokens()){
						String st = str.nextToken();
						if(st.toLowerCase().equals("generate")){
							generate = st + " " + str.nextToken();
							b = b.substring(b.indexOf(str.nextToken()));
							break;
						}
					}
					generate = generate + "[foreach(";
					for(int i = 0; i < foreachinfo.size(); i++){
						if(i == 0)
							generate = generate + foreachinfo.get(i);
						else if(i != 0)
							generate = generate + "," + foreachinfo.get(i);
					}
					generate = generate + ")?";
					String b1 = b.substring(0, b.toLowerCase().indexOf("from"));
					String b2 = b.substring(b.toLowerCase().indexOf("from"));


					b = generate + b1 + "]%" + b2;
					Log.info(b);
				}
				GlobalEnv.foreach_flag = foreachFlag;
				Preprocessor preprocessor = new Preprocessor(b);
				ANTLRInputStream input_b = new ANTLRInputStream(b);
				querytestLexer lexer_b = new querytestLexer(input_b);
				CommonTokenStream tokens_b = new CommonTokenStream(lexer_b);

				querytestParser parser_b = new querytestParser(tokens_b);
				parser_b.setErrorHandler(new MyErrorStrategy());
				ParseTree tree_b = parser_b.query(); // begin parsing at rule query
				List_tree_b = TreeConst.createSSQLParseTree(tree_b, parser_b);
				List_tree_b = (ExtList) List_tree_b.get(1);
				list_media = (ExtList) List_tree_b.get(0);
				list_tfe = (ExtList) List_tree_b.get(1);
				if(List_tree_b.size() > 2){
					list_from_where = (ExtList) List_tree_b.get(2);
					list_from = new ExtList();
					list_where = new ExtList();

					while(true){
						if(((ExtList)((ExtList)list_from_where.get(1)).get(0)).get(0).toString().equals("select_core")){
							list_from_where = (ExtList) ((ExtList)((ExtList)list_from_where.get(1)).get(0)).get(1);
							if(((ExtList)list_from_where.get(list_from_where.size() - 1)).get(0).toString().equals("where")){
								list_where = (ExtList) ((ExtList)list_from_where.get(list_from_where.size() - 1)).get(1);
								for(int i = 0; i < list_from_where.size() - 1; i++){
									list_from.add(list_from_where.get(i));
								}
							}else{
								for(int i = 0; i < list_from_where.size(); i++){
									list_from.add(list_from_where.get(i));
								}
							}
							break;
						}else{
							list_from_where = (ExtList)(ExtList)((ExtList)list_from_where.get(1)).get(0);
						}
					}
					list_table = set_fromInfo();

					after_from = b.substring(b.toLowerCase().indexOf("from") + 4).trim();
					processKeywords(after_from);

				}
//				Log.info(list_media);
//				Log.info(list_tfe);
//				Log.info(list_from);
//				Log.info(list_where);
				postProcess();

				codegenerator = new CodeGenerator();

			}catch(Exception e){

			}
		}
	}
}