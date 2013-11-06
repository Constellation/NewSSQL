package supersql.codegenerator.Mobile_HTML5;

import supersql.codegenerator.DecorateList;
import supersql.common.Log;

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
				decos.containsKey("autoshow-each") || decos.containsKey("auto-show-each")){
			String autoshow = "";
			String autoshowEach = "0";
    		if(decos.containsKey("autoshow"))		autoshow = decos.getStr("autoshow").replaceAll("px", "").replaceAll(";", "");
    		else if(decos.containsKey("auto-show"))	autoshow = decos.getStr("auto-show").replaceAll("px", "").replaceAll(";", "");
    		if(decos.containsKey("autoshow-each"))			autoshowEach = decos.getStr("autoshow-each").replaceAll("px", "").replaceAll(";", "");
    		else if(decos.containsKey("auto-show-each"))	autoshowEach = decos.getStr("auto-show-each").replaceAll("px", "").replaceAll(";", "");
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
	private static boolean showCloseProcess(DecorateList decos, Mobile_HTML5Env html_env){
		if(decos.containsKey("show") || decos.containsKey("show-each") ||
		   decos.containsKey("autoshow") || decos.containsKey("autoshow-each")||
		   decos.containsKey("auto-show") || decos.containsKey("auto-show-each")){
        //if(symbol.equals(showSymbol) && showFlg){
        	html_env.code.append("</DIV><!-- End of Show More -->\n");
        	//showFlg = false;
        	return true;
        }
		return false;
	}
	
	
}
