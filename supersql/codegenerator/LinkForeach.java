//added by goto 20161019 for new foreach
package supersql.codegenerator;


public class LinkForeach {
	public final static String ID = "ssql_foreach";
	public final static String ID2 = "att";
	public final static StringBuffer C3contents = new StringBuffer();
	
	public LinkForeach() {

	}
	
	public static String getJS(String tfe){
		String r = "<script type=\"text/javascript\">\n" +
				   "<!--\n";
		if(tfe.equals("C3")){
			String bodyDivID = "ssql_body_contents";
			r += 	"var ssqlForeach_currentID = \"\";\n" +
					"$(function(){\n" +
					"	window.onload = function(){ ssqlForeach(); }\n" +
					"	window.onhashchange = function(){ ssqlForeach(); }\n" +
					"});\n" +
					"function ssqlForeach(){\n" +
					"	if (location.hash == \"\") {\n" +
					"		document.getElementById(ssqlForeach_currentID).style.display=\"none\";\n" +
					"		document.getElementById(\""+bodyDivID+"\").style.display=\"block\";\n" +
					"	}else{\n" +
					"		document.getElementById(\""+bodyDivID+"\").style.display=\"none\";\n" +
					"		var id = location.hash.substring(location.search.length+1);\n" +
					"		id = decodeURI(id);\n" +
					"		var elementID = document.getElementById(id);\n" +
					"		if(elementID)\n" +
					"			elementID.style.display=\"block\";\n" +
					"		else\n" +
					"			document.write(\"No Data Found : \"+id);\n" +
					"		\n" +
					"		ssqlForeach_currentID = id;\n";

		}else if(tfe.equals("G3")){
			r += 	"window.onload = function(){\n" +
					"	if(location.search.length<1){\n" +
					"		document.write(\"SuperSQL Foreach Page\");\n" +
					"	}else{\n" +
					"		var id = location.search.substring(1, location.search.length);\n" +
					"		id = id.substring(\""+ID2+"\".length+1);\n" +
					"		id = decodeURI(id);\n" +
					"		var elementID = document.getElementById(\""+ID+"_\"+id);\n" +
					"		if(elementID)\n" +
					"			elementID.style.display=\"block\";\n" +
					"		else\n" +
					"			document.write(\"No Data Found : \"+id);\n";
		}
		r += 	"	}\n" +
				"}\n" +
				"//-->" +
				"</script>\n";
		return r;
	}
	
	public static String getC3contents(){
		String r = "";
		if(!C3contents.toString().isEmpty()){
			r += "<!-- SuperSQL C3(%) Contents  Start -->";
			r += getJS("C3")+C3contents;
			r += "<!-- SuperSQL C3(%) Contents  End -->";
		}
		return r;
	}
}
