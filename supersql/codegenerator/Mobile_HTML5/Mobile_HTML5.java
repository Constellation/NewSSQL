package supersql.codegenerator.Mobile_HTML5;

import supersql.codegenerator.DecorateList;

public class Mobile_HTML5 {
	
	public static boolean preProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
		//Pre-process (前処理)
		showProcess(decos, html_env);
		return true;
	}
	public static boolean postProcess(String symbol, DecorateList decos, Mobile_HTML5Env html_env){
		//Post-process (後処理)
		showCloseProcess(decos, html_env);
		return true;
	}
	
	
	//20131106 show
	static int show_count = 0;		
	//static boolean showFlg = false;
	//static String showSymbol = "";	//important variable
	private static boolean showProcess(DecorateList decos, Mobile_HTML5Env html_env){
		if(decos.containsKey("show") || decos.containsKey("show-each")){
			//showSymbol = symbol;
    		String show = "";
			String showEach = "0";
    		if(decos.containsKey("show"))		show = decos.getStr("show").replaceAll("px", "").replaceAll(";", "");
    		if(decos.containsKey("show-each"))	showEach = decos.getStr("show-each").replaceAll("px", "").replaceAll(";", "");
    		//Log.e(show+"  "+showEach);
    		if(show.isEmpty())	show=showEach;
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
		return false;
	}
	private static boolean showCloseProcess(DecorateList decos, Mobile_HTML5Env html_env){
		if(decos.containsKey("show") || decos.containsKey("show-each")){
        //if(symbol.equals(showSymbol) && showFlg){
        	html_env.code.append("</DIV><!-- End of Show More -->\n");
        	//showFlg = false;
        	return true;
        }
		return false;
	}
	
	
}
