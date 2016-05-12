package supersql.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import supersql.codegenerator.CodeGenerator;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;
import supersql.parser.*;
import supersql.parser.org.antlr.v4.runtime.MyErrorStrategy;


public class Start_Parse {

	public static String att = null;
	public static String media = null;
	public ExtList List_tree_a, List_tree_b, list_tfe, list_from, list_media;
	private CodeGenerator codegenerator;
	public static Hashtable<?, ?> atts;
	
	@SuppressWarnings("unchecked")
	public Start_Parse()
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


		//parse query
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

				}
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
				list_from = (ExtList) List_tree_b.get(2);
				System.out.println(list_media);
				System.out.println(list_tfe);
				System.out.println(list_from);
//				TreeConst.getfromInfo(List_tree_b);
				codegenerator = new CodeGenerator();
				
			}catch(Exception e){

			}
		}
	}
	
	public CodeGenerator getcodegenerator(){
		codegenerator.TFEid = 10000;
		return codegenerator;
		
	}
	
//	public Hashtable get_att_info(List<SSQLParseTree> tree){
//		String parent = null;
//		String child = null;
//		int i = 0, id = 0;
//		boolean t_flag = false; // flag for table_alias
//		boolean c_flag = false; // flag for column_name
//
//		while((parent = tree.get(i).parent_info) != "from"){
//		}if(parent.equals("table_alias")){
//			t_flag = true;
//			i++;
//		}else if(parent.equals("column_name")){
//			c_flag = true;
//			i++;
//		}else if(parent.equals("any_name") && t_flag){
//			child = tree.get(i).children.get(0).node;
//			att = child + ".";
//			t_flag = false;
//			i++;
//		}else if(parent.equals("any_name") && c_flag){
//			child = tree.get(i).children.get(0).node;
//			att = att + child;
//			atts.put(id, att);
//			id++;
//			att = null;
//			c_flag = false;
//			i++;
//		}else{
//			i++;
//		}
//		
//		return atts;
//	}

//	//use other class
//	public static void get_TFEschema(List<SSQLParseTree> tree){
//		TFE tfe = null;
//		int i = 0;
//		int id = 0;
//		String parent = null;
//		String child = null;
//		boolean t_flag = false; // flag for table_alias
//		boolean c_flag = false; // flag for column_name
//
//		while((parent = tree.get(i).parent_info) != "from"){
//			if(parent.equals("sorting")){
//				tfe.setOrderBy(tree.get(i).children.get(1).node);
//				i++;
//			}else if(parent.equals("table_alias")){
//				t_flag = true;
//				i++;
//			}else if(parent.equals("column_name")){
//				c_flag = true;
//				i++;
//			}else if(parent.equals("any_name") && t_flag){
//				child = tree.get(i).children.get(0).node;
//				att = child + ".";
//				t_flag = false;
//				i++;
//			}else if(parent.equals("any_name") && c_flag){
//				child = tree.get(i).children.get(0).node;
//				att = att + child;
//				tfe.setId(id);
//				id++;
//				tfe.setAtt(att);
//				attributes.add(tfe);
//				att = null;
//				c_flag = false;
//				i++;
//			}else{
//				i++;
//			}
//		}
//	}

}