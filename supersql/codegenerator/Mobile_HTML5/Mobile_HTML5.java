package supersql.codegenerator.Mobile_HTML5;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import supersql.codegenerator.DecorateList;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.TFE;
import supersql.common.Log;
import supersql.extendclass.ExtList;
import supersql.parser.Start_Parse;

public class Mobile_HTML5 {
	
	public static int gLevel = 0;
	
	public Mobile_HTML5() {

	}
	
	//Process
	public static boolean preProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
		//Pre-process (前処理)
		if(!symbol.contains("G1") && !symbol.contains("G2")){
			Mobile_HTML5_dynamic.dyamicPreStringProcess(symbol, decos, html_env);
		}
		
		Mobile_HTML5_show.showProcess(decos, html_env);	//TODO この位置でOKか確認
		
		if(symbol.contains("G1") || symbol.contains("G2")){
			Mobile_HTML5_dynamic.dynamicPreProcess0(symbol, decos, html_env);
		}
		if(!symbol.contains("G1") && !symbol.contains("G2")){
			Mobile_HTML5_form.formPreProcess(symbol, decos, html_env);
		}
		return true;
	}
	public static boolean beforeWhileProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
//		if(!symbol.contains("G1") && !symbol.contains("G2")){
//			dyamicPreStringProcess(symbol, decos, html_env);
//		}
	
		
		if(!symbol.contains("G1") && !symbol.contains("G2")){
			Mobile_HTML5_dynamic.dynamicPreProcess(symbol, decos, html_env);//最終的には不要
			
//			formPreProcess(symbol, decos, html_env);
		}
		if(symbol.contains("G2")){
			Mobile_HTML5_form.G2 = true;
			//Log.e(Mobile_HTML5_form.G2_dataQuantity);
		}
		if(symbol.contains("G1") || symbol.contains("G2")){
			Mobile_HTML5_dynamic.sindex = 0;
	    	Mobile_HTML5_dynamic.dyamicWhileString = "";
		}
		return true;
	}
	public static boolean whileProcess1_1(String symbol, DecorateList decos, Mobile_HTML5Env html_env, ExtList data, ExtList data_info, ITFE tfe, ExtList<TFE> tfes, int tfeItems){
		//while process 1 (while内の処理1)
		//Attribute: decos, html_env, data_info
		//C1, C2:    decos, html_env, data, data_info, tfe, tfes, tfeItems
		//G1, G2:    decos, html_env, data, data_info, tfe
		if(symbol.contains("G1") || symbol.contains("G2")){
        	if(Mobile_HTML5.gLevel<=1){
        		Mobile_HTML5_dynamic.dyamicWhileCount0++;
        	}
		}
		return true;
	}
	public static boolean whileProcess1(String symbol, DecorateList decos, Mobile_HTML5Env html_env, ExtList data, ExtList data_info, ITFE tfe, ExtList<TFE> tfes, int tfeItems){
		//while process 1 (while内の処理1)
		//Attribute: decos, html_env, data_info
		//C1, C2:    decos, html_env, data, data_info, tfe, tfes, tfeItems
		//G1, G2:    decos, html_env, data, data_info, tfe
		if(symbol.contains("G1") || symbol.contains("G2")){
	    	Mobile_HTML5_dynamic.html_env_code_length = html_env.code.toString().length();
			Mobile_HTML5_dynamic.dynamicPreProcess(symbol, decos, html_env);
		}
		return true;
	}
	public static boolean whileProcess2(String symbol, DecorateList decos, Mobile_HTML5Env html_env, ExtList data, ExtList data_info, ITFE tfe, ExtList<TFE> tfes, int tfeItems){
		//while process 2 (while内の処理2)
		//Attribute: decos, html_env, data_info
		//C1, C2:    decos, html_env, data, data_info, tfe, tfes, tfeItems
		//G1, G2:    decos, html_env, data, data_info, tfe
		if(symbol.contains("G1") || symbol.contains("G2")){
			Mobile_HTML5_dynamic.dynamicStringGetProcess(symbol, decos, html_env);
		}
		Mobile_HTML5_dynamic.dyamicWhileStringProcess(symbol, decos, html_env);
		return true;
	}
	public static boolean whileProcess2_2(String symbol, DecorateList decos, Mobile_HTML5Env html_env, ExtList data, ExtList data_info, ITFE tfe, ExtList<TFE> tfes, int tfeItems){
		//while process 2_2 (while内の処理2_2)
		//Attribute: decos, html_env, data_info
		//C1, C2:    decos, html_env, data, data_info, tfe, tfes, tfeItems
		//G1, G2:    decos, html_env, data, data_info, tfe
//		if(symbol.contains("G1") || symbol.contains("G2")){
//			Log.i(Mobile_HTML5_dynamic.dynamicCount);
//			Mobile_HTML5_dynamic.dynamicCount--;
//		}
//		if(symbol.contains("G1") || symbol.contains("G2")){
//			//added by goto 20161112 for dynamic foreach
////            if(Mobile_HTML5G3.G3){
////            	Mobile_HTML5G3.G3_while_i++;
////                //Log.i(Mobile_HTML5G3.G3_while_i);
////            }
//		}
		
		if(symbol.contains("G1") || symbol.contains("G2")){
	        if(Mobile_HTML5_dynamic.dynamicDisplay && Mobile_HTML5.gLevel<=1){
	    		Mobile_HTML5_dynamic.dyamicWhileCount0--;
	        }
	        if(Mobile_HTML5_dynamic.dynamicDisplay && Mobile_HTML5_dynamic.dyamicWhileCount0<1){
	        	return false;
	        }
		}
		return true;
	}
	public static boolean afterWhileProcess(String symbol, String tfeID, DecorateList decos, Mobile_HTML5Env html_env){
		Mobile_HTML5_dynamic.dyamicAfterWhileStringProcess(symbol, decos, html_env);
		
		if(!symbol.contains("G1") && !symbol.contains("G2")){
			Mobile_HTML5_dynamic.dynamicStringGetProcess(symbol, decos, html_env);//最終的には不要
			Mobile_HTML5_dynamic.dynamicProcess(tfeID, symbol, decos, html_env);//最終的には不要
		}
		
		Mobile_HTML5Function.func_null_count = 0;	//null()
		if(symbol.contains("G2")){
			Mobile_HTML5_form.G2 = false;
//			Mobile_HTML5_form.G2_dataQuantity = 0;
			Mobile_HTML5Function.G2_form_count = 0;
		}
		return true;
	}
	public static boolean postProcess(String symbol, String tfeID, DecorateList decos, Mobile_HTML5Env html_env){
//		//if(symbol.contains("G1") || symbol.contains("G2")){
//		if(symbol.contains("C1") || !symbol.contains("C2")){
		Mobile_HTML5_dynamic.dyamicPostStringProcess(symbol, decos, html_env);
//		}
		
		if(symbol.contains("G1") || symbol.contains("G2")){
			Mobile_HTML5_dynamic.dynamicProcess(symbol, tfeID, decos, html_env);
		}
		if(!symbol.contains("G1") && !symbol.contains("G2")){
			Mobile_HTML5_form.formStringGetProcess(symbol, decos, html_env);
			Mobile_HTML5_form.formProcess(symbol, decos, html_env);
		}
		
//		if(symbol.contains("G1") || symbol.contains("G2")){
//			Log.i(Mobile_HTML5_dynamic.dynamicCount);
//			Mobile_HTML5_dynamic.dynamicCount--;
//		}
		
		//Post-process (後処理)
		Mobile_HTML5_show.showCloseProcess(decos, html_env);
		Mobile_HTML5_dynamic.dynamicString = "";
		Mobile_HTML5_form.formString = "";
		return true;
	}

	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	
	//check query
	public static String checkQuery(String query) {
		//contains $session() or not
		//ex)　WHERE s_id = $session(id)	->	WHERE s_id = id
		//大文字小文字の区別なし：先頭に(?i)
		if(query.contains(" FROM ") && query.contains(" WHERE ")){
			if(query.indexOf(" FROM ") < query.indexOf(" WHERE ")){
				//TODO " and ' の外側かどうかチェック
				query = query.replaceAll("(?i)\\$\\s*session\\s*\\(\\s*([A-Za-z0-9]+)\\s*\\)", "$1");
			}
		}
		
		return query;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
	//get DIV width (C1,G1)
	public static String getDivWidth(String type, DecorateList decos, int numberOfColumns){
    	//20131002
		String divWidthStr = "";
		if(type.equals("C1"))
	    	if(decos.containsKey("width")){
	    		divWidthStr = decos.getStr("width");
	    	}else{
		    	float divWidth = (float)Math.floor((double)(100.0/numberOfColumns)* 1000) / 1000;
	        	divWidthStr = divWidth+"%";
	    	}
		else if(type.equals("G1")){
			float divWidth = (float)Math.floor((double)(100.0/numberOfColumns)* 1000) / 1000;
        	divWidthStr = divWidth+"%";
		}
		return divWidthStr;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	//return session_start string
	public static String getSessionStartString(){
		if(Start_Parse.sessionFlag){
			return "<?php\n" +
					"	session_start();\n" +
					//"	session_regenerate_id(TRUE);\n" +	//これがあると、phpファイルへのアクセスごとにセッションが切れる？
					"?>\n\n";
		}
		return "";
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
	
	//isNumber
	public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
