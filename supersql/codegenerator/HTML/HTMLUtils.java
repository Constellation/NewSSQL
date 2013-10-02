package supersql.codegenerator.HTML;

import java.util.Arrays;
import java.util.HashSet;

import org.jsoup.nodes.Element;

import supersql.codegenerator.DecorateList;
import supersql.codegenerator.TFE;

public class HTMLUtils {
	
	private static final HashSet<String> formDecos= new HashSet<String>(Arrays.asList(new String[] { "insert", "update", "delete" })) ;
	
	public static void propagateDeco(TFE tfe, DecorateList decos){
		for(String s : formDecos){
    		if(decos.containsKey(s))
        		tfe.addDeco(s, true);
    	}
	}
	
	public static Element checkIfForm(Element result){
		if(result.getElementsByTag("input").size() > 0){
        	result.getElementsByTag("form").tagName("div");
        	result.tagName("form");
        	result.getElementsByAttributeValue("type", "submit").remove();
        	result.appendChild(JsoupFactory.createInput("submit", "", "Let's go !"));
        }
		return result;
	}
}
