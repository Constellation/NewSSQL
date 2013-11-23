package supersql.codegenerator.Mobile_HTML5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import supersql.codegenerator.DecorateList;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.TFE;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class Mobile_HTML5 {
	
	public static boolean preProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
		//Pre-process (前処理)
		showProcess(decos, html_env);	//TODO この位置でOKか確認
		
		if(symbol.contains("G1") || symbol.contains("G2")){
			dynamicPreProcess0(symbol, decos, html_env);
		}
		return true;
	}
	public static boolean beforeWhileProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
		if(!symbol.contains("G1") && !symbol.contains("G2")){	//最終的には不要
			dynamicPreProcess(symbol, decos, html_env);
		}
		return true;
	}
	public static boolean whileProcess1(String symbol, DecorateList decos, Mobile_HTML5Env html_env, ExtList data, ExtList data_info, ITFE tfe, ExtList<TFE> tfes, int tfeItems){
		//while process 1 (while内の処理1)
		//Attribute: decos, html_env, data_info
		//C1, C2:    decos, html_env, data, data_info, tfe, tfes, tfeItems
		//G1, G2:    decos, html_env, data, data_info, tfe
//		dynamicStringGetProcess(symbol, decos, html_env, data, data_info, tfe, tfes, tfeItems);
		//dynamicWhileProcess1(symbol, decos, html_env, data, data_info, tfe, tfes, tfeItems);
		if(symbol.contains("G1") || symbol.contains("G2")){
//			dynamicStringGetProcess(symbol, decos, html_env);
			dynamicPreProcess(symbol, decos, html_env);
		}
		return true;
	}
	public static boolean whileProcess2(String symbol, DecorateList decos, Mobile_HTML5Env html_env, ExtList data, ExtList data_info, ITFE tfe, ExtList<TFE> tfes, int tfeItems){
		//while process 2 (while内の処理2)
		//Attribute: decos, html_env, data_info
		//C1, C2:    decos, html_env, data, data_info, tfe, tfes, tfeItems
		//G1, G2:    decos, html_env, data, data_info, tfe
//		dynamicStringGetProcess(symbol, decos, html_env, data, data_info, tfe, tfes, tfeItems);
		//dynamicWhileProcess2(symbol, decos, html_env, data, data_info, tfe, tfes, tfeItems);
		if(symbol.contains("G1") || symbol.contains("G2")){
			dynamicStringGetProcess(symbol, decos, html_env);
		}
		return true;
	}
	public static boolean afterWhileProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
		if(!symbol.contains("G1") && !symbol.contains("G2")){	//最終的には不要
			dynamicStringGetProcess(symbol, decos, html_env);
			dynamicProcess(symbol, decos, html_env);
		}
//		dynamicProcess(symbol, decos, html_env);
		
		return true;
	}
	public static boolean postProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
		if(symbol.contains("G1") || symbol.contains("G2")){
			dynamicProcess(symbol, decos, html_env);
		}
		
		//Post-process (後処理)
		showCloseProcess(decos, html_env);
		Mobile_HTML5Env.divWidth = "";
		dynamicString = "";
		return true;
	}
	
	

	//20130529 dynamic
	//20131118 dynamic
	static String dynamicString = "";
//	static String dynamicString2 = "";
//	static String dynamicString2_buf = "";
	static String dynamicHTMLbuf0 = "";
	static String dynamicHTMLbuf = "";
//	static String dynamicHTMLbuf2 = "";
	static int dynamicCount = 1;
//	static int dynamicWhileCount = 0;
	static String dynamicFuncCountLabel = "___DynamicFunc_CountLabel___";
	public static boolean dynamicDisplay = false;
//	public static ExtList<String> dynamicConnectorProcess(ITFE tfe, ExtList<String> subdata){
//		//TODO このメソッドは不要
//		//For C1, C2, G1, G2
//		if(dynamicDisplay){
////			Log.e("subdata = "+subdata+",	sindex = "+sindex+", dindex = "+dindex+", dindex + ci = "+dindex + ci+",	tfe = "+tfe);
//			String s = createDynamicAttribute(tfe);
//			try{
//				if(!s.isEmpty()){
//					subdata.set(0, s);
//				}
//			}catch(Exception e){}
////			Log.e("subdata = "+subdata);
//		}
//		return subdata;
//	}
	public static String dynamicFuncArgProcess(ITFE tfe){
		//For Function
		return createDynamicAttribute(tfe);
	}
	public static String dynamicAttributeProcess(ITFE tfe){
		//For Attribute (C1, C2, G1, G2)
		return createDynamicAttribute(tfe);
	}
	private static String createDynamicAttribute(ITFE tfe){
		String s = ""+tfe;
		s = s.trim();
		if(s.startsWith("\"") && s.endsWith("\"")){
			//not attribute
			s = s.substring(1,s.length()-1);
		}else{
			//attribute
			s = "'||"+s+"||'";
		}
		return s;
	}
	public static String getDynamicLabel(){	//+Mobile_HTML5.getDinamicLabel()
		//For function's count
		//※ Count付きのfunc()には、+Mobile_HTML5.getDinamicLabel()を付加する
		//TODO dynamicFuncCountLabelがユニーク値かどうか判定
		if(dynamicDisplay){
			return dynamicFuncCountLabel;
		}
		return "";
	}
	//For Dynamic paging
	static int dynamicRow = 1;
	static boolean dynamicRowFlg = false;
	static int dynamicPagingCount = 1;
	static String dynamicPHPfileName =  "";
	//ajax
	static int ajax_loadInterval = 0;
	
	private static boolean dynamicPreProcess0(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
		if(decos.containsKey("dynamic")){
			dynamicHTMLbuf0 = html_env.code.toString();
			dynamicDisplay = true;
			dynamicPHPfileName = html_env.getFileName2()+"_dynamic_"+dynamicCount+".php";
			
	        if(decos.containsKey("row")){
	        	dynamicRow = Integer.parseInt(decos.getStr("row").replace("\"", ""));
	        	if(dynamicRow<1){	//範囲外のとき
	        		Log.err("<<Warning>> row指定の範囲は、1〜です。指定された「row="+dynamicRow+"」は使用できません。");
	        	}else{
	        		dynamicRowFlg = true;
	        		dynamicPHPfileName = html_env.getFileName2()+"_dynamicPaging_"+dynamicPagingCount+".php";
	        	}
	        	//Log.i("dynamicRow = "+dynamicRow);
	        }
			return true;
		}
		return false;
	}
	private static boolean dynamicPreProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
		if(decos.containsKey("dynamic")){
			dynamicHTMLbuf = html_env.code.toString();
			dynamicDisplay = true;
			return true;
		}
		return false;
	}
	private static boolean dynamicWhileProcess1(String symbol, DecorateList decos, Mobile_HTML5Env html_env, ExtList data, ExtList data_info, ITFE tfe, ExtList<TFE> tfes, int tfeItems){
//		if(dFlg && (symbol.contains("G1") || symbol.contains("G2"))){
//			dynamicWhileCount++;
//			Log.e(dynamicWhileCount);
//		}
//		if(Mobile_HTML5.dFlg && tfe!=null){
//		if(Mobile_HTML5.dFlg){
//			if (tfe instanceof Connector || tfe instanceof Attribute
//					|| tfe instanceof Function || tfe instanceof IfCondition) {
//				//'<h1>'||w.wh_id||' '||w.name||'</h1>'
//				Log.i("Ans2: "+tfe);
//				String s = ""+tfe;
//				s = s.trim();
//				if(s.contains("\"")){
//					//not attribute
//					s = s.substring(0,s.length()-1).substring(1);
//				}else{
//					//attribute
//					s = "'||"+s+"||'";
//				}
//				Log.e("s = "+s);
//				
//				String currentHTML = html_env.code.toString();
////				if(w1<w2){
////					currentHTML = currentHTML.substring(0,w1)+currentHTML.substring(w2,currentHTML.length());
////				}
//				//currentHTML = currentHTML.substring(0,w1)+currentHTML.substring(w2,currentHTML.length());
////				dynamicString2 += currentHTML.substring(dynamicHTMLbuf.length()+dynamicString2.length())+s;
////				String a = currentHTML.substring(dynamicHTMLbuf.length()+dynamicString2.length());
//				Log.i("w1 = "+w1+", w2 = "+w2+"	dynamicHTMLbuf.length() = "+dynamicHTMLbuf.length()+", dynamicHTMLbuf2.length()"+dynamicHTMLbuf2.length());
//				String a = currentHTML//.substring(w1,w2)
//						.substring(dynamicHTMLbuf.length()+dynamicHTMLbuf2.length());
////						.substring(dynamicHTMLbuf.length()+dynamicHTMLbuf2.length()+( (w1!=0)? (w2-w1) : 0 ));
//				dynamicString2 += a+s;
////				dynamicString2 += currentHTML//.substring(w1,w2)
////						.substring(dynamicHTMLbuf.length()+dynamicHTMLbuf2.length())+s;
////				Log.i(dynamicString2);
////				Log.i("currentHTML.substring(w1,w2) = "+currentHTML.substring(w1,w2));
////				if(w1<w2){
//////					Log.i("dynamicString2.substring(w1,w2) = "+dynamicString2.substring(w1-dynamicHTMLbuf.length(),w2-dynamicHTMLbuf.length()));
//////					Log.i("a.substring(w1,w2) = "+a.substring(w1-dynamicHTMLbuf.length()+dynamicHTMLbuf2.length(),w2-dynamicHTMLbuf.length()+dynamicHTMLbuf2.length()));
////				}
//				w1=0;
//				w2=0;
////				dynamicHTMLbuf2 = currentHTML;
//				dynamicHTMLbuf2 = a;
////				dynamicString2_buf = dynamicString2;
//				w1 = currentHTML.length();
//				
////				dynamicString2 += currentHTML.substring(dynamicHTMLbuf.length()+dynamicString2.length())+s;
////				Log.i(dynamicString2);
//////				dynamicHTMLbuf2 = currentHTML;
////				dynamicHTMLbuf2 = currentHTML.substring(dynamicHTMLbuf.length()+dynamicString2.length());
//				
//			}
//		}
		return false;
	}
	private static boolean dynamicWhileProcess2(String symbol, DecorateList decos, Mobile_HTML5Env html_env, ExtList data, ExtList data_info, ITFE tfe, ExtList<TFE> tfes, int tfeItems){

		//		String currentHTML = html_env.code.toString();
//		w2 = currentHTML.length();
////		dynamicString2 = dynamicString2.substring(0,dynamicString2_buf.length());
		return false;
	}
//	private static boolean dynamicStringGetProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env, ExtList data, ExtList data_info, ITFE tfe, ExtList<TFE> tfes, int tfeItems){
	private static boolean dynamicStringGetProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
		if(decos.containsKey("dynamic")){
//		Log.e("symbol = "+symbol+" dynamicWhileCount = "+dynamicWhileCount);
//		if(decos.containsKey("dynamic") && dynamicWhileCount<2){
			String currentHTML = html_env.code.toString();
			dynamicString = currentHTML.substring(dynamicHTMLbuf.length(), currentHTML.length());
			html_env.code = new StringBuffer(dynamicHTMLbuf);
//			dynamicHTMLbuf = "";
//			dynamicHTMLbuf = html_env.code.toString();
			//dynamicDisplay = false;
			return true;
		}
		return false;
	}
//	private static boolean dynamicProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env, ExtList data, ExtList data_info, ITFE tfe, ExtList<TFE> tfes, int tfeItems){
	private static boolean dynamicProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
		if(decos.containsKey("dynamic")){
			//if(symbol.contains("Attribute")){
			//	Log.e("in dynamic: <"+symbol+"> "+data+" "+data_info+" "+tfe+" "+tfes+" "+tfeItems);
			//}
//			html_env.code.append("</DIV><!-- End of Show More -->\n");
			
//			dynamicWhileCount = 0;	//init
			
			if(symbol.contains("G1") || symbol.contains("G2")){
//				String currentHTML = html_env.code.toString();
//				String cut = currentHTML.substring(dynamicHTMLbuf0.length(), currentHTML.length());
				html_env.code = new StringBuffer(dynamicHTMLbuf0);
			}
			
//			Log.e("");
//			Log.e("");
//			Log.e(dynamicString2);
//			Log.e("");
//			Log.e("");
			Log.e(" - Start dynamic process -");
//			Log.e(dynamicString);
			
			
			
			//ajax load interval
			if(decos.containsKey("ajax-load") || decos.containsKey("load") || decos.containsKey("load-interval")){
				String s = "";
				if(decos.containsKey("ajax-load")) 			s = decos.getStr("ajax-load");
				else if(decos.containsKey("load")) 			s = decos.getStr("load");
				else if(decos.containsKey("load-interval"))	s = decos.getStr("load-interval");
				s = s.trim().toLowerCase().replaceAll("sec", "").replaceAll("s", "");
				ajax_loadInterval = (int) (Float.parseFloat(s)*1000.0);
				//Log.i(ajax_loadInterval);
			}
			 
			
			
//			dynamicString = dynamicString.replaceAll("'", "\\\\\\\\\\\\\'");											//　' -> \'				//TODO これでOK?
			
			//TODO div, table以外の場合
//			dynamicString = "'"+dynamicString2+"</div>'";
			if(!symbol.contains("G1") && !symbol.contains("G2")){
				if(decos.containsKey("table")){
					dynamicString = "'<table border=1><tr>"+dynamicString+"</tr></table>'";
				}else if(decos.containsKey("table0")){
					dynamicString = "'<table><tr>"+dynamicString+"</tr></table>'";
	//				String close = "";
	//				if(symbol.contains("Attribute")){
	//					close = "</td></tr>";
	//				}else if(symbol.contains("C1") || symbol.contains("G1")){
	//					close = "</tr>";
	//				}
	//				dynamicString = "'"+dynamicString+close+"</table>'";
				}else{
					dynamicString = "'"+dynamicString+"</div>'";
				}
			}else{
				//G1, G2
				dynamicString = "'"+dynamicString+"'";
			}
			
			dynamicString = dynamicString.replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");	//改行コードの削除
//			if(!dynamicRowFlg)	dynamicString = dynamicString.replaceAll("\"", "\\\\\\\\\\\\\"");			//　" -> \\\"			//TODO これでOK?
//			else				dynamicString = dynamicString.replaceAll("\"", "\\\\\"");					//　" -> \"
			dynamicString = dynamicString.replaceAll("\"", "\\\\\"");										//　" -> \"
			Log.e(dynamicString);
			
			
			//String after_from_string = Mobile_HTML5Function.after_from_string;	//TODO
			
			
		    /*  //ユーザ定義
			    $sqlite3_DB = '/Users/goto/Desktop/SQLite_DB/sample2.db';
			    $dynamic_col = "w.name, pr.name, count(*), w.r_year, ko.kind";
			    $col_num = 5;                          //カラム数(Java側で指定)
	    	 *    $table = 'world_heritage w, prefectures pr, wh_prefectures wpr, kind_of_wh ko';
	    	 *    $where0 = 'w.wh_id=wpr.wh_id and wpr.p_id=pr.p_id and w.k_id=ko.k_id';
			    $dynamic_col_array = array("w.name","pr.name", "count(*)", "w.r_year", "ko.kind");
	    	 *    $groupby = " pr.name "; 	           //null => WHERE句にlikeを書く／ not null => HAVING句に～    //[要] Java側で、列名に予約語から始まるものがあるかチェック
	    	 *    $having0 = " count(*)>1 ";
	    	 *    $orderby = " ORDER BY w.name asc ";
	    	 *    $limit = " LIMIT 10 ";
	    	 */
	    	
	    	
//	    	String title = "";
	    	String columns = "";
	    	String after_from = "";
	    	//columns = "w.wh_id, w.name";
	    	//columns = "'<h1>'||w.wh_id||' '||w.name||'</h1>'";
	    	columns = dynamicString;
	    	//after_from = "FROM world_heritage w";
	    	after_from = Mobile_HTML5Function.after_from_string;
	    	
//	    	try{
////	    		//title（第一引数）
//////	    		FuncArg fa1 = (FuncArg) this.Args.get(0);
////	    		if(!fa1.getStr().equals(""))	title = fa1.getStr();
////	    		else							title = "Dynamic";
//	    		//columns（第二引数）
//	    		FuncArg fa2 = (FuncArg) this.Args.get(1);
//	    		columns += fa2.getStr();
//	    		//after_from（第三引数）
//	    		FuncArg fa3 = (FuncArg) this.Args.get(2);
//	    		after_from += fa3.getStr().trim();
//	    	}catch(Exception e){
//	    		Log.info("<Warning> serach関数の引数が不足しています。 ex. dynamic(\"title\", \"c1:column1, c2:column2, ... \", \"From以下\")");
//	    		return false;
//	    	}
//	    	if(columns.trim().equals("") || after_from.equals("")){
//	    		Log.info("<Warning> serach関数の引数が不足しています。 ex. dynamic(\"title\", \"c1:column1, c2:column2, ... \", \"From以下\")");
//	    		return false;
//	    	}
	    	if(after_from.toLowerCase().startsWith("from "))	after_from = after_from.substring("from".length()).trim();
	    	//Log.info(title);
	    	
	    	int col_num=1;
	    	String columns0 = columns;
	    	while(columns0.contains(",")){
	    		columns0 = columns0.substring(columns0.indexOf(",")+1);
	    		col_num++;		//カウント
	    	}
	    	String[] s_name_array = new String[col_num];
	    	String[] s_array = new String[col_num];
	    	columns0 = columns;
	    	for(int i=0; i<col_num-1; i++){
	    		s_array[i] = columns0.substring(0,columns0.indexOf(","));
	    		columns0 = columns0.substring(columns0.indexOf(",")+1);
	    		//Log.i( "s_array["+i+"] = "+s_array[i]+"	"+columns0);
	    	}
	    	s_array[col_num-1] = columns0;
	    	//Log.i( "s_array["+(col_num-1)+"] = "+s_array[col_num-1]);
	    	int j=0;
	    	for(int i=0; i<col_num; i++){
	    		if(s_array[i].contains(":")){
	    			if(!s_array[i].substring(0,s_array[i].indexOf(":")).contains(")"))
	    				s_name_array[j++] = s_array[i].substring(0,s_array[i].indexOf(":"));
	    			s_array[i] = s_array[i].substring(s_array[i].indexOf(":")+1);
	    		}else{
	    			if(!s_array[i].contains(")"))	s_name_array[j++] = s_array[i];
	    		}
	    		//Log.i("s_name_array["+(j-1)+"] = "+s_name_array[j-1] + "	s_array["+i+"] = "+s_array[i]);
	    	}
	    	boolean groupbyFlg = false;	//Flg
	    	//boolean[] aFlg = new boolean[col_num];	//Flg
	    	//boolean[] popFlg = new boolean[col_num];	//Flg
	    	String a = "";
	    	String dynamic_col = "";
	    	String dynamic_col_array = "\"";
	    	String dynamic_aFlg = "\"";		//Flg
	    	String dynamic_mailFlg = "\"";		//Flg
	    	String dynamic_popFlg = "\"";	//Flg
	    	int a_pop_count = 0;
	    	for(int i=0; i<col_num; i++){
	    		a = s_array[i].replaceAll(" ","");
	    		if( a.startsWith("max(") || a.startsWith("min(") || a.startsWith("avg(") ||  a.startsWith("count(") )	groupbyFlg = true;
	    		if(a.startsWith("a(") || a.startsWith("anchor(")){
	    			dynamic_aFlg += "true\""+((i<col_num-1)?(",\""):(""));
	    			if(a.endsWith(")")){
	    				dynamic_col += s_array[i]+",";
	    				dynamic_col_array += s_array[i]+"\",\"";
	    				dynamic_aFlg += ((i<col_num-1)?(""):(",\""))+"false\""+((i<col_num-1)?(",\""):(""));
	    				dynamic_mailFlg += ((i<col_num-1)?(""):(",\""))+"false\""+((i<col_num-1)?(",\""):(""));
	    				dynamic_popFlg += ((i<col_num-1)?(""):(",\""))+"false\""+((i<col_num-1)?(",\""):(""));
	    			}else	a_pop_count++;
	    		}else
	    			dynamic_aFlg += "false\""+((i<col_num-1)?(",\""):(""));
	    		if(a.startsWith("mail(")){
	    			dynamic_mailFlg += "true\""+((i<col_num-1)?(",\""):(""));
	    			if(a.endsWith(")")){
	    				dynamic_col += s_array[i]+",";
	    				dynamic_col_array += s_array[i]+"\",\"";
	    				dynamic_aFlg += ((i<col_num-1)?(""):(",\""))+"false\""+((i<col_num-1)?(",\""):(""));
	    				dynamic_mailFlg += ((i<col_num-1)?(""):(",\""))+"false\""+((i<col_num-1)?(",\""):(""));
	    				dynamic_popFlg += ((i<col_num-1)?(""):(",\""))+"false\""+((i<col_num-1)?(",\""):(""));
	    			}else	a_pop_count++;
	    		}else
	    			dynamic_mailFlg += "false\""+((i<col_num-1)?(",\""):(""));
	    		if(a.startsWith("pop(") || a.startsWith("popup(")){
	    			dynamic_popFlg += "true\""+((i<col_num-1)?(",\""):(""));
	    			if(a.endsWith(")")){
	    				dynamic_col += s_array[i]+",";
	    				dynamic_col_array += s_array[i]+"\",\"";
	    				dynamic_aFlg += ((i<col_num-1)?(""):(",\""))+"false\""+((i<col_num-1)?(",\""):(""));
	    				dynamic_mailFlg += ((i<col_num-1)?(""):(",\""))+"false\""+((i<col_num-1)?(",\""):(""));
	    				dynamic_popFlg += ((i<col_num-1)?(""):(",\""))+"false\""+((i<col_num-1)?(",\""):(""));
	    			}else	a_pop_count++;
	    		}else
	    			dynamic_popFlg += "false\""+((i<col_num-1)?(",\""):(""));
	    		dynamic_col += s_array[i] +((i<col_num-1)?(","):(""));
	    		dynamic_col_array += s_array[i] +"\""+((i<col_num-1)?(",\""):(""));
	    	}
	    	col_num -= a_pop_count;
	//    	dynamic_col = dynamic_col.replaceAll("a\\(","").replaceAll("anchor\\(","").replaceAll("mail\\(","").replaceAll("pop\\(","").replaceAll("popup\\(","").replaceAll("\\)","");
	//    	dynamic_col_array = dynamic_col_array.replaceAll("a\\(","").replaceAll("anchor\\(","").replaceAll("mail\\(","").replaceAll("pop\\(","").replaceAll("popup\\(","").replaceAll("\\)","");
	    	dynamic_col = dynamic_col.replaceAll("a\\(","").replaceAll("anchor\\(","").replaceAll("mail\\(","").replaceAll("pop\\(","").replaceAll("popup\\(","").replaceAll("count\\(\\*\\)","count[*]").replaceAll("\\)","").replaceAll("count\\[\\*\\]","count(*)");
	    	dynamic_col_array = dynamic_col_array.replaceAll("a\\(","").replaceAll("anchor\\(","").replaceAll("mail\\(","").replaceAll("pop\\(","").replaceAll("popup\\(","").replaceAll("count\\(\\*\\)","count[*]").replaceAll("\\)","").replaceAll("count\\[\\*\\]","count(*)");
	    	
	    	//TODO 余計なコードの削除
	    	dynamic_col = dynamicString;
	    	dynamic_col_array = dynamicString;
	    	
	    	//Log.i("	1:"+title+"	2:"+columns+"	col_num:"+col_num);
	    	//Log.i("	dynamic_col:"+dynamic_col+"	dynamic_col_array:"+dynamic_col_array);
	    	//Log.i("	dynamic_aFlg:"+dynamic_aFlg+"	dynamic_popFlg:"+dynamic_popFlg);
	    	//Log.i("	groupbyFlg: "+groupbyFlg);
	    	
	    	
	    	String DBMS = GlobalEnv.getdbms();										//DBMS
	    	String DB = GlobalEnv.getdbname();										//DB
	    	
	    	String query = "";
	    	//Log.i(after_from_string);
//	    	if(after_from.startsWith("#")){					//From以下をクエリの下(#*)から取ってくる場合	//TODO
//	    		if(!after_from_string.contains(after_from)){
//	    			Log.info("<Warning> dynamic関数の第三引数に指定されている '"+after_from+"' が見つかりません。");
//	    			return false;
//	    		}
//	    		query = after_from_string
//	    				.substring(after_from_string.indexOf(after_from)+after_from.length())
//	    				.trim().toLowerCase();
//	    		if(query.contains("#"))	query = query.substring(0,query.indexOf("#")).trim().toLowerCase();
//	    	}else
	    		query = after_from.toLowerCase();			//From以下を第三引数へ書く場合
	
	    	//Log.i("\n	Query: "+query);
	    	String from = "";
	    	String where = "";
	    	String groupby = "";
	    	String having = "";
	    	String orderby = "";
	    	String limit = "";
	    	if(query.contains(" limit ")){
	    		limit = query.substring(query.lastIndexOf(" limit ")+" limit ".length());
	    		query = query.substring(0,query.lastIndexOf(" limit "));
	    	}
	    	if(query.contains(" order by ")){
	    		orderby = query.substring(query.lastIndexOf(" order by ")+" order by ".length());
	    		query = query.substring(0,query.lastIndexOf(" order by "));
	    	}
	    	if(query.contains(" having ")){
	    		having = query.substring(query.lastIndexOf(" having ")+" having ".length());
	    		having = having.replaceAll("\\\"","\\\\\"");	// " -> \"
	    		query = query.substring(0,query.lastIndexOf(" having "));
	    	}
	    	if(query.contains(" group by ")){
	    		groupby = query.substring(query.lastIndexOf(" group by ")+" group by ".length());
	    		query = query.substring(0,query.lastIndexOf(" group by "));
	    	}
	    	if(query.contains(" where ")){
	    		where = query.substring(query.lastIndexOf(" where ")+" where ".length());
	    		where = where.replaceAll("\\'","\\\\'");		// ' -> \'
	    		query = query.substring(0,query.lastIndexOf(" where "));
	    	}
	    	from = query.trim();
	    	//Log.i("	FROM: "+from+"\n	WHERE: "+where+"\n	GROUP: "+groupby+"\n	HAVING: "+having);
	    	//Log.i("	ORDER: "+orderby+"\n	LIMIT: "+limit+"\n	Query: "+query);
	    	
	    	if(!groupbyFlg){
	    		groupby = "";
	    		having = "";
	    	}
	    	
	    	
	    	String statement = "";
	    	String php = "<?php\n";
	    	//sqlite3 php
	    	if(DBMS.equals("sqlite3")){
	    		if(!dynamicRowFlg){
		    		statement += getDynamicHTML(dynamicCount, dynamicPHPfileName);
//		    				"<!-- Dynamic start -->\n" +
//							"<!-- Dynamic Panel start -->\n" +
//							//"<br>\n" +
//							"<div id=\"DYNAMIC"+dynamicCount+"panel\" style=\"\" data-role=\"none\">\n" +
//	//						"<hr>\n<div style=\"font-size:30;\" id=\"DynamicTitle"+dynamicCount+"\">"+title+"</div>\n<hr>\n" +
//							//"<br>\n" +
//							"\n" +
//							"<div id=\"Dynamic"+dynamicCount+"_text0\" data-role=\"none\"><!--データ --></div>\n" +
//							"\n" +
//	//						"<table style=\"table-layout:fixed;\" data-role=\"table\" id=\"table-column-toggle"+dynamicCount+"\" data-mode=\"columntoggle\" class=\"ui-responsive table-stroke\">\n" +
//	//						"  <thead>\n" +
//	//						"    <tr id=\"Dynamic"+dynamicCount+"_text_th\">\n";
//	//	    		for(int i=0; i<col_num; i++){
//	//	    			statement += 
//	//						"        <th data-priority=\"1\">"+s_name_array[i]+"</th>\n";
//	//	    		}
//	//	    		statement += 
//	//	    				"    </tr>\n" +
//	//						"  </thead>\n" +
//	//						"  <tbody>\n" +
//	//						"    <tr>\n";
//	//	    		for(int i=0; i<col_num; i++){
//	//	    			statement +=
//	//						"        <td id=\"Dynamic"+dynamicCount+"_text"+(i+1)+"\" style=\"white-space:nowrap; overflow:hidden; text-overflow:ellipsis;\"></td>\n";
//	//	    		}
//	//	    		statement += 
//	//	    				"    </tr>\n" +
//	//						"  </tbody>\n" +
//	//						"</table>\n" +
//	//						"\n" +
//							//"<br>\n" +
//							"</div>\n" +
//	//						"<script type=\"text/javascript\"> $('#Dynamic"+dynamicCount+"_text_th').hide(); </script>\n" +
//							"<!-- Dynamic Panel end -->\n" +
//							"\n";
	    		}else{
	    			statement += getDynamicPagingHTML(dynamicRow, dynamicPagingCount, dynamicPHPfileName);
	    		}
	    		
	    		
	    		php += 
						"$ret = array();\n" +
						"$ret['result'] = \"\";\n\n";
	    		if(dynamicRowFlg){
	    			php += 
							"if ($_POST['currentPage'] != \"\") {\n" +
							"	$cp = $_POST['currentPage'];\n" +
							"	$r = $_POST['row'];\n" +
							"	$end = $cp * $r;\n" +
							"	$start = $end - $r + 1;\n" +
							"\n";
	    		}
	    		php +=
//    						"if($_POST['dynamic"+dynamicCount+"'] || $_POST['dynamic_words"+dynamicCount+"']){\n" +
//    						"    echo '<script type=\"text/javascript\">window.parent.Dynamic"+dynamicCount+"_refresh();</script>';    //表示をリフレッシュ\n" +
//    						"\n" +
    						"    //ユーザ定義\n" +
							"    $sqlite3_DB = '"+DB+"';\n" +
							"    $dynamic_col = \""+dynamic_col+"\";\n" +
							"    $col_num = "+col_num+";                          //カラム数(Java側で指定)\n" +
							"    $table = '"+from+"';\n" +
							"    $where0 = '"+where+"';\n" +
							"    $dynamic_col_array = array("+dynamic_col_array+");\n" +
							"    $dynamic_col_num = count($dynamic_col_array);\n" +
							"    $dynamic_a_Flg = array("+dynamic_aFlg+");\n" +
							"    $dynamic_mail_Flg = array("+dynamic_mailFlg+");\n" +
							"    $dynamic_pop_Flg = array("+dynamic_popFlg+");\n" +
							"    $groupby = \""+groupby+"\"; 	           //null => WHERE句にlikeを書く／ not null => HAVING句に～    //[要] Java側で、列名に予約語から始まるものがあるかチェック\n" +
							"    $having0 = \""+having+"\";\n" +
							"    $orderby = \""+((orderby!="")?(" ORDER BY "+orderby+" "):("")) +"\";\n" +
							"    $limit = \""+((limit!="")?(" LIMIT "+limit+" "):("")) +"\";\n" +
							((limit!="")?(" $limitNum = "+limit+";\n"):("")) +	//TODO dynamicPaging時にLIMITが指定されていた場合
							"\n" +
							//"    $dynamicWord"+dynamicCount+" = checkHTMLsc($_POST['dynamic_words"+dynamicCount+"']);\n" +
							"    $dynamicWord"+dynamicCount+" = checkHTMLsc('%');\n" +
							"    $dynamicWord"+dynamicCount+" = preg_replace('/　/', ' ', $dynamicWord"+dynamicCount+");       //全角スペースを半角スペースへ\n" +
							"    $dynamicWord"+dynamicCount+" = preg_replace('/\\s+/', ' ', $dynamicWord"+dynamicCount+");      //連続する半角スペースを1つの半角スペースへ\n" +
							"    $dynamicWord"+dynamicCount+" = trim($dynamicWord"+dynamicCount+");                            //trim\n" +
							"    $dynamicWord"+dynamicCount+" = preg_replace('/\\s/', '%', $dynamicWord"+dynamicCount+");       //半角スペースを%へ変換\n" +
							"\n" +
							"    if($dynamicWord"+dynamicCount+" != \"\"){\n" +
							"        $dynamic_db"+dynamicCount+" = new SQLite3($sqlite3_DB);\n" +
							"        $sql = \"SELECT DISTINCT \".$dynamic_col.\" FROM \".$table;\n" +
							"        if($where0 != \"\")    $sql .= \" WHERE \".$where0.\" \";\n" +
							"    \n" +
							"    	//左辺の作成（※Java側でOK?)\n" +
							"        $sw = $dynamicWord"+dynamicCount+";\n" +
							"        $sw_buf = \"\";\n" +
							"        $l_str = \"\";\n" +
							"        foreach($dynamic_col_array as $val)    $l_str .= \"ifnull(\".$val.\",'')||\";\n" +
							"        $l_str = substr($l_str, 0, -2);      //substring   最後の||をカット\n" +
							"        $l_str .= \" LIKE '%\";\n" +
							"        //右辺の作成\n" +
							"        while(strpos($sw,'%')){		//%を含んでいる間\n" +
							"            $pos = strpos($sw,'%');          //indxOf  		%が最初に現れる位置\n" +
							"            $rest = substr($sw, 0, $pos);    //substring    最初の%以降をカット\n" +
							"            $sw = substr($sw, $pos+1);       //substring    最初の%までカット\n" +
							"            $sw_buf .= $l_str.$rest.\"%' AND \";\n" +
							"        }\n" +
							"        $sw_buf .= $l_str.$sw.\"%' \";         //最後のswを結合\n" +
							"        \n" +
							"        if($groupby == \"\"){    //null => WHERE句にlikeを書く／ not null => HAVING句に～\n" +
							"            /*** WHERE句の作成 start ***/\n" +
							"            //WHERE  ifnull(id,'')||ifnull(name,'')||ifnull(r_year,'') LIKE '%sw[1]%'\n" +
							"            //   AND ifnull(id,'')||ifnull(name,'')||ifnull(r_year,'') LIKE '%sw[2]%'...\n" +
							"            \n" +
							"            $WHERE = \"\";\n" +
							"            if($where0 == \"\")   $WHERE = \" WHERE \";\n" +
							"            else                $WHERE = \" AND \";\n" +
							"            $WHERE .= $sw_buf;\n" +
							"            \n" +
							"            $sql .= \" \".$WHERE.\" \";\n" +
							"            //$sql .= $WHERE.\" \".$groupby.\" \";\n" +
							"            /*** WHERE句の作成 end ***/\n" +
							"        }else{                        //null => WHERE句にlikeを書く／ not null => HAVING句に～\n" +
							"            /*** HAVING句の作成 start ***/\n" +
							"            //HAVING  ifnull(id,'')||ifnull(name,'')||ifnull(r_year,'') LIKE '%sw[1]%'\n" +
							"            //    AND ifnull(id,'')||ifnull(name,'')||ifnull(r_year,'') LIKE '%sw[2]%'...\n" +
							"            \n" +
							"            $HAVING = \"\";\n" +
							"            if($having0 == \"\")  $HAVING = \" HAVING \";\n" +
							"            else	            $HAVING = \" HAVING \".$having0.\" AND \";\n" +
							"    		$HAVING .= $sw_buf;\n" +
							"            \n" +
							"            $sql .= \" GROUP BY \".$groupby.\" \".$HAVING;\n" +
							"            /*** HAVING句の作成 end ***/\n" +
							"        }\n" +
							"        $sql .= \" \".$orderby.\" \".$limit;	//order by句とlimitを結合\n" +
							//((dynamicRowFlg)? "//":"") +
							//"        dynamic"+dynamicCount+"_p1('<font color=red>SQL error: '.$sql.\";</font>\");	//エラー時\n" +
							"\n" +
							"        $result = $dynamic_db"+dynamicCount+"->query($sql);\n" +
							"\n" +
							"        $i = 0;\n" +
							"        $pop_num = 0;\n" +
							"        $b = \"\";\n" +
							"        while($row = $result->fetchArray()){\n" +
							"              $i++;\n" +
							//"              $k=0;\n" +
							((dynamicRowFlg)? "              if($i>=$start && $i<=$end){	//New\n":"") +
							"              for($j=0; $j<$dynamic_col_num; $j++){\n" +
							//"                    dynamic"+dynamicCount+"_p2($row[$j], $j+1);     //tdに結果を埋め込む\n" +
//							"					if($dynamic_a_Flg[$j]=='true' || $dynamic_mail_Flg[$j]=='true' || $dynamic_pop_Flg[$j]=='true')	;\n" +
//							"                    else if($j>0 && $dynamic_a_Flg[$j-1]=='true')	dynamic"+dynamicCount+"_p2('<a href=\\\"'.$row[$j].'\\\" target=\\\"_blank\\\" rel=\\\"external\\\" style=\\\"white-space:nowrap; overflow:hidden; text-overflow:ellipsis;\\\">'.$row[$j-1].'</a>', ++$k);     //tdに結果を埋め込む\n" +
//							"                    else if($j>0 && $dynamic_mail_Flg[$j-1]=='true')	dynamic"+dynamicCount+"_p2('<a href=\\\"mailto:'.$row[$j].'\\\" target=\\\"_self\\\" style=\\\"white-space:nowrap; overflow:hidden; text-overflow:ellipsis;\\\">'.$row[$j-1].'</a>', ++$k);     //tdに結果を埋め込む\n" +
//							"                    //else if($j>0 && $dynamic_pop_Flg[$j-1]=='true')	dynamic"+dynamicCount+"_p2('<a href=\\\"'.$row[$j].'\\\" target=\\\"_blank\\\" rel=\\\"external\\\" style=\\\"white-space:nowrap; overflow:hidden; text-overflow:ellipsis;\\\">'.$row[$j-1].'</a>', ++$k);     //tdに結果を埋め込む\n" +
//							"                    else if($j>0 && $dynamic_pop_Flg[$j-1]=='true' && !is_null($row[$j])){\n" +
//							"                    	$pop_str = '<a href=\\\"#dynamic_popup1_'.(++$pop_num).'\\\" data-rel=\\\"popup\\\" data-icon=\\\"arrow-r\\\" style=\\\"white-space:nowrap; overflow:hidden; text-overflow:ellipsis;\\\">'.$row[$j-1].'</a>'\n" +
//							"							.'<div data-role=\\\"popup\\\" id=\\\"dynamic_popup1_'.($pop_num).'\\\" data-transition=\\\"slideup\\\" style=\\\"width:95%;\\\" data-overlay-theme=\\\"a\\\">'\n" +
//							"								.'<a href=\\\"#\\\" data-rel=\\\"back\\\" data-role=\\\"button\\\" data-theme=\\\"a\\\" data-icon=\\\"delete\\\" data-iconpos=\\\"notext\\\" class=\\\"ui-btn-right\\\">Close</a>'\n" +
//							"								.'<h2>'.$row[$j-1].'</h2>'\n" +
//							"								.'<p>'.$row[$j].'</p>'\n" +
//							"							.'</div>';\n" +
//							"                    	dynamic"+dynamicCount+"_p2($pop_str, ++$k);     	//tdに結果を埋め込む\n" +
//							"                    }else									dynamic"+dynamicCount+"_p2($row[$j], ++$k);     //tdに結果を埋め込む\n" +
							"              		//$b .= $row[$j];\n" +
							"              		$b .= str_replace("+dynamicFuncCountLabel+", '_'.$i, $row[$j]);\n" +	//For function's count
							"              }\n" +
							((dynamicRowFlg)? "              }\n":"") +
							"        }\n" +
//							"		 if($i>0)	echo \"<script type=\\\"text/javascript\\\">window.parent.$('#Dynamic"+dynamicCount+"_text_th').show();</script>\";    //カラム名を表示\n" +
							//"        dynamic"+dynamicCount+"_p1($i.' result'.(($i != 1)?('s'):('')));    //件数表示\n" +
							//"        dynamic"+dynamicCount+"_p1('"+dynamicString+"');    //件数表示\n" +
							//((dynamicRowFlg)? "//":"") +
							//"        dynamic"+dynamicCount+"_p1($b);    //データ表示\n" +
							"    }\n" +
							//"	 else{\n" +
							//((dynamicRowFlg)? "//":"") +
							//"        dynamic"+dynamicCount+"_p1('0 results');\n" +
							//"    }\n" +
							"    \n" +
							"    unset($dynamic_db"+dynamicCount+");\n" +
	    					((dynamicRowFlg)? "}\n":"") +
							//"function dynamic"+dynamicCount+"_p1($str){\n" +
							//((dynamicRowFlg)? "//":"") +
							//"    echo '<script type=\"text/javascript\">window.parent.Dynamic"+dynamicCount+"_echo1(\"'.$str.'\");</script>';\n" +
							//"}\n" +
//							"function dynamic"+dynamicCount+"_p2($str,$num){\n" +
//							"    echo '<script type=\"text/javascript\">window.parent.Dynamic"+dynamicCount+"_echo2(\"'.$str.'\",\"'.$num.'\");</script>';\n" +
//							"}\n";
	    					"$ret['result'] = $b;\n";
	    		if(dynamicRowFlg){
	    			php += 
							"$ret['start'] = $start;\n" +
							"$ret['end'] = ($end<$i)? $end:$i;\n" +
							"$ret['all'] = $i;\n" +
							"$ret['info'] = (($ret['start']!=$ret['end'])? ($ret['start'].\" - \") : (\"\")) .$ret['end'].\" / \".$ret['all'];\n" +
							"$ret['currentItems'] = ceil($i/$r);\n";
	    		}
	    		php += 
							"\n" +
							"header(\"Content-Type: application/json; charset=utf-8\");\n" +
							"echo json_encode($ret);\n" +
							"\n" +
							"//XSS対策\n" +
							"function checkHTMLsc($str){\n" +
							"	return htmlspecialchars($str, ENT_QUOTES, 'UTF-8');\n" +
							"}\n" +
							"?>\n";
	    		
//	    		statement += 
//    						"\n" +
//    						"<script type=\"text/javascript\">\n" +
//    						"function Dynamic"+dynamicCount+"_echo1(str){\n" +
//    						"  var textArea = document.getElementById(\"Dynamic"+dynamicCount+"_text0\");\n" +
//    						"  textArea.innerHTML = str;\n" +
//    						"}\n" +
////    						"function Dynamic"+dynamicCount+"_echo2(str,num){\n" +
////    						"  var textArea = document.getElementById(\"Dynamic"+dynamicCount+"_text\"+num);\n" +
////    						//"  textArea.innerHTML += str+\"<br>\";\n" +
////    						//"  $(\"#Dynamic"+dynamicCount+"_text\"+num).html(textArea.innerHTML+str+\"<br>\").trigger(\"create\");\n" +
////    						"  $(\"#Dynamic"+dynamicCount+"_text\"+num).html(textArea.innerHTML+str+\"<br>\");\n" +
////    						"}\n" +
////    						"\n" +
////    						"function Dynamic"+dynamicCount+"_refresh(){\n";
////	    		
////	    		for(int i=0; i<col_num; i++){
////	    			statement +=
////	    					"  document.getElementById(\"Dynamic"+dynamicCount+"_text"+(i+1)+"\").innerHTML = \"\";\n";
////	    		}
////	    		statement +=
////	    					"}\n" +
//    						"</script>\n" +
//    						"<!-- Dynamic end -->\n";
	    		
	    		
	    	}
	    	else if(DBMS.equals("sqlite")){
	    		Log.e("<Warning> dynamic() for 'sqlite' is not implemented yet.");
	    		;	//TODO
	    	}
	    	else if(DBMS.equals("postgresql")){
	    		Log.e("<Warning> dynamic() for 'postgresql' is not implemented yet.");
	    		;	//TODO
	    	}

	    	
	    	// 各引数毎に処理した結果をHTMLに書きこむ
	    	html_env.code.append(statement);
	    	
	    	if(!dynamicRowFlg){
	    		createFile(html_env, dynamicPHPfileName, php);//PHPファイルの作成
//    			Mobile_HTML5Env.PHP += php;
	    		dynamicCount++;
    		}else{
				createFile(html_env, dynamicPHPfileName, php);//PHPファイルの作成
				dynamicPagingCount++;
				dynamicRowFlg = false;
			}
	    	//dynamicCount++;
	    	dynamicDisplay = false;
	    	ajax_loadInterval = 0;
	    	
	    	
			Log.e(" - End dynamic process -");
        	return true;
        }
		return false;
	}
	private static String getDynamicHTML(int num, String phpFileName){
		phpFileName = new File(phpFileName).getName();
		String s =
				"\n" +
				"<!-- Dynamic "+num+" start -->\n" +
				"<!-- Dynamic "+num+" DIV start -->\n" +
				"<div id=\"SSQL_DynamicDisplay"+num+"_Panel\" style=\"\" data-role=\"none\">\n" +
				"<div id=\"SSQL_DynamicDisplay"+num+"\" data-role=\"none\"><!-- Dynamic Display Data --></div>\n" +
				"</div>\n" +
				"<!-- Dynamic "+num+" DIV end -->\n" +
				"\n" +
				"<!-- Dynamic "+num+" JS start -->\n" +
				"<script type=\"text/javascript\">\n" +
				"SSQL_DynamicDisplay"+num+"();	//ロード時に実行\n";
		if(ajax_loadInterval>0){
			s += "setInterval(function(){\n" +
				 "	SSQL_DynamicDisplay"+num+"();\n" +
				 "},"+ajax_loadInterval+");\n";
		}
		s +=	"function SSQL_DynamicDisplay"+num+"_echo(str){\n" +
				"  var textArea = document.getElementById(\"SSQL_DynamicDisplay"+num+"\");\n" +
				"  textArea.innerHTML = str;\n" +
				"}\n" +
				"function SSQL_DynamicDisplay"+num+"(){\n" +
				"	//ajax: PHPへ値を渡して実行\n" +
				"	$.ajax({\n" +
				"		type: \"POST\",\n" +
				"		url: \""+phpFileName+"\",\n" +
				"		dataType: \"json\",\n" +
				"		success: function(data, textStatus){\n" +
				"			if (data.result != \"\") {\n" +
				"				SSQL_DynamicDisplay"+num+"_echo(data.result);\n" +
				"			}\n" +
				"		},\n" +
				"		error: function(XMLHttpRequest, textStatus, errorThrown) {\n" +
				"			SSQL_DynamicDisplay"+num+"_echo(textStatus+\"<br>\"+errorThrown);\n" +
				"		}\n" +
				"	});\n" +
				"}\n" +
				"</script>\n" +
				"<!-- Dynamic "+num+" JS end -->\n" +
				"<!-- Dynamic "+num+" end -->\n\n";
		return s;
	}
	private static String getDynamicPagingHTML(int row, int num, String phpFileName){
		phpFileName = new File(phpFileName).getName();
		return	"\n" +
				"<!-- Dynamic Paging "+num+" start -->\n" +
				"<!-- Dynamic Paging "+num+" DIV start -->\n" +
				//"<div id=\"SSQL_DynamicDisplayPaging"+num+"_Buttons\"></div>\n" +
				"\n" +
				"<div id=\"SSQL_DynamicDisplayPaging"+num+"\" data-role=\"none\"><!-- Dynamic Display Data --></div>\n" +
				"<script type=\"text/javascript\">\n" +
				"function SSQL_DynamicDisplayPaging"+num+"_echo(str){\n" +
				"  var textArea = document.getElementById(\"SSQL_DynamicDisplayPaging"+num+"\");\n" +
				"  textArea.innerHTML = str;\n" +
				"}\n" +
				"</script>\n" +
				"\n" +
				"<div id=\"SSQL_DynamicDisplayPaging"+num+"_Buttons\"></div>\n" +
				"<!-- Dynamic Paging "+num+" DIV end -->\n" +
				"\n" +
				"<!-- Dynamic Paging "+num+" JS start -->\n" +
				"<script type=\"text/javascript\">\n" +
				"SSQL_DynamicDisplayPaging"+num+"(1);	//初期ロード時\n" +
				"SSQL_DynamicDisplayPaging"+num+"_setButtons();\n" +
				"\n" +
				"var SSQL_DynamicDisplayPaging"+num+"_currentItems = 1;		//グローバル変数\n" +
				"function SSQL_DynamicDisplayPaging"+num+"_setButtons(){\n" +
				"	$(function(){\n" +
				"	    $(\"[id=SSQL_DynamicDisplayPaging"+num+"_Buttons]\").pagination({\n" +
				"	        items: SSQL_DynamicDisplayPaging"+num+"_currentItems, //ページング数\n" +
				"	        displayedPages: 2, 	  //表示したいページング要素数\n" +
				"	        onPageClick: function(pageNum){ SSQL_DynamicDisplayPaging"+num+"(pageNum) }\n" +
				"	    })\n" +
				"	});\n" +
				"}\n" +
				"function SSQL_DynamicDisplayPaging"+num+"(pn){\n" +
				"	//ajax: PHPへ値を渡して実行\n" +
				"	$.ajax({\n" +
				"		type: \"POST\",\n" +
				"		url: \""+phpFileName+"\",\n" +
				"		dataType: \"json\",\n" +
				"		data: {\n" +
				"			\"currentPage\": pn,\n" +
				"			\"row\": '"+row+"',\n" +
				"		},\n" +
				"		success: function(data, textStatus){\n" +
				"			if (data.result != \"\") {\n" +
				//"				//SSQL_DynamicDisplayPaging"+num+"_echo(SSQL_DynamicDisplayPaging"+num+"_currentItems+\" \"+data.currentItems+\"<br>\"+data.info+\"<br>\"+data.result);\n" +
				"				SSQL_DynamicDisplayPaging"+num+"_echo(data.result+data.info);\n" +
				"				if(data.currentItems != null && data.currentItems != SSQL_DynamicDisplayPaging"+num+"_currentItems){\n" +
				"					//ページ数が変わった場合の処理\n" +
				"					SSQL_DynamicDisplayPaging"+num+"_currentItems = data.currentItems;\n" +
				"					SSQL_DynamicDisplayPaging"+num+"_setButtons();\n" +
				"				}\n" +
				"			}\n" +
				//"			else {\n" +
				//"				SSQL_DynamicDisplayPaging"+num+"_echo(\"失敗\");\n" +
				//"			}\n" +
				"		},\n" +
				"		error: function(XMLHttpRequest, textStatus, errorThrown) {\n" +
				"			SSQL_DynamicDisplayPaging"+num+"_echo(textStatus+\"<br>\"+errorThrown);\n" +
				"		}\n" +
				"	});\n" +
				"}\n" +
				"</script>\n" +
				"<!-- Dynamic Paging "+num+" JS end -->\n" +
				"<!-- Dynamic Paging "+num+" end -->\n\n";
	}
	
	
	
	
	
	//20131106 show
	static int show_count = 0;
	static int show_count_G2 = 0;
	//static boolean showFlg = false;
	//static String showSymbol = "";	//important variable
	private static boolean showProcess(DecorateList decos, Mobile_HTML5Env html_env){
		if(decos.containsKey("show") || decos.containsKey("show-first") || decos.containsKey("show-next")){
			//showSymbol = symbol;
    		String show = "";
			String showEach = "0";
    		if(decos.containsKey("show"))				show = decos.getStr("show").replaceAll("px", "").replaceAll(";", "");
    		else if(decos.containsKey("show-first"))	show = decos.getStr("show-first").replaceAll("px", "").replaceAll(";", "");
    		if(decos.containsKey("show-next"))	showEach = decos.getStr("show-next").replaceAll("px", "").replaceAll(";", "");
    		//Log.e(show+"  "+showEach);
    		if(show.isEmpty())	show = showEach;
    		//Log.e(show+"  "+showEach);
    		show_count++;
    		
    		String showClass = "ssql_showmore_"+show_count;
    		html_env.code.append(
    				"\n<script>\n" +
    				"	$(document).ready(function() {\n" +
    				"		$('."+showClass+"').showmore({\n" +
    				"	       maxHeight: "+show+",\n" +
    				"	       showEach: "+showEach+"\n" +
    				"	    });\n" +
    				"	});\n" +
    				"</script>\n\n" +
    				"<DIV class=\""+showClass+"\">\n");
    		//showFlg = true;
    		return true;
        }
		else if(decos.containsKey("autoshow") || decos.containsKey("auto-show") || 
				decos.containsKey("autoshow-first") || decos.containsKey("auto-show-first") ||
				decos.containsKey("autoshow-next") || decos.containsKey("auto-show-next")){
			String autoshow = "";
			String autoshowEach = "0";
    		if(decos.containsKey("autoshow"))				autoshow = decos.getStr("autoshow").replaceAll("px", "").replaceAll(";", "");
    		else if(decos.containsKey("autoshow-first"))	autoshow = decos.getStr("autoshow-first").replaceAll("px", "").replaceAll(";", "");
    		else if(decos.containsKey("auto-show"))			autoshow = decos.getStr("auto-show").replaceAll("px", "").replaceAll(";", "");
    		else if(decos.containsKey("auto-show-first"))	autoshow = decos.getStr("auto-show-first").replaceAll("px", "").replaceAll(";", "");
    		if(decos.containsKey("autoshow-next"))			autoshowEach = decos.getStr("autoshow-next").replaceAll("px", "").replaceAll(";", "");
    		else if(decos.containsKey("auto-show-next"))	autoshowEach = decos.getStr("auto-show-next").replaceAll("px", "").replaceAll(";", "");
    		if(autoshow.isEmpty())	autoshow = autoshowEach;
    		show_count++;
    		
    		String autoshowClass = "ssql_showmore_"+show_count;
    		String autoshowButtonClass = "ssql_autoshowmore_"+show_count;
    		String loadID = "ssql_show_loading_"+show_count;
    		String loadImage = "jscss/loading.gif";
    		int timeout = 500;
    		html_env.code.append(
    				"\n<script>\n" +
					"	$(function() {\n" +
					"		//ページ最下部にきたら自動的に次を読み込む\n" +
					"	    $(window).scroll(function() {\n" +
					"		     var current = $(window).scrollTop() + window.innerHeight;\n" +
					"		     if (current < $(document).height() - 100) return;\n" +
					"		     if ($(this).data('loading')) return;\n" +
					"\n" +
					"		     $(this).data('loading', true);\n" +
					"			 var boxHeight = $(\"."+autoshowClass+"\").outerHeight();\n" +
					//"			 //alert( $(\"."+autoshowClass+"\").height() +\"/\"+ $(\"."+autoshowClass+"\").data().boxHeight);\n" +
					"			 if( $(\"."+autoshowClass+"\").height() < $(\"."+autoshowClass+"\").data().boxHeight )\n" +
					"			 	$(\"#"+loadID+"\").html(\"<div id='"+loadID+"'><img src='"+loadImage+"'/></div>\");\n" +
					"		     setTimeout(function(){\n" +
					"			 	$(\"#"+loadID+"\").html(\"<div id='"+loadID+"'></div>\");\n" +
					"				$(\"."+autoshowButtonClass+"\").eq(0).click();\n" +
					"	    	 },"+timeout+");\n" +
					"		     $(this).data('loading', false);\n" +
					"		});\n\n" +
    				"		$('."+autoshowClass+"').showmore({\n" +
    				//"		   moreLink: '<div><input type=\"button\" class=\""+autoshowButtonClass+"\" style=\"visibility:hidden;\"></div>',\n" +
    				"		   moreLink: '<div id=\""+loadID+"\"></div><div><input type=\"button\" class=\""+autoshowButtonClass+"\" style=\"visibility:hidden;\"></div>',\n" +
    				"	       maxHeight: "+autoshow+",\n" +
    				"	       showEach: "+autoshowEach+"\n" +
    				"	    });\n" +
    				"	});\n" +
    				"</script>\n\n" +
    				"<DIV class=\""+autoshowClass+"\">\n");
    		return true;
		}
		return false;
	}
	public static String addShowCountClassName(DecorateList decos){
		//not use
		if(decos.containsKey("show") || decos.containsKey("show-first") || decos.containsKey("show-next") ||
		   decos.containsKey("autoshow") || decos.containsKey("autoshow-first") || decos.containsKey("autoshow-next")||
		   decos.containsKey("auto-show") || decos.containsKey("auto-show-first") ||  decos.containsKey("auto-show-next")){
			show_count_G2++;
			return "show_count_G2_"+show_count+"_"+show_count_G2;
		}
		return "";
	}
	private static boolean showCloseProcess(DecorateList decos, Mobile_HTML5Env html_env){
		if(decos.containsKey("show") || decos.containsKey("show-first") || decos.containsKey("show-next") ||
		   decos.containsKey("autoshow") || decos.containsKey("autoshow-first") || decos.containsKey("autoshow-next")||
		   decos.containsKey("auto-show") || decos.containsKey("auto-show-first") ||  decos.containsKey("auto-show-next")){
        //if(symbol.equals(showSymbol) && showFlg){
        	html_env.code.append("</DIV><!-- End of Show More -->\n");
        	//showFlg = false;
        	show_count_G2 = 0;
        	return true;
        }
		return false;
	}

	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	//create file
	public static boolean createFile(Mobile_HTML5Env html_env, String fileName, String code){
        try {
    		PrintWriter pw;
            if (html_env.charset != null)
	        	pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
	        			new FileOutputStream(fileName),html_env.charset)));
            else
            	pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
    		pw.println(code);
            pw.close();
            return true;
        } catch (Exception e) { }
        return false;
    }
	
}
