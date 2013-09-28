package supersql.codegenerator.HTML;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Connector;
import supersql.codegenerator.Manager;
import supersql.extendclass.ExtList;


// The Connector 0 is the interrogation point.
public class HTMLC0 extends Connector {
	private HTMLEnv htmlEnv;
	private HTMLEnv htmlEnv2;

	public HTMLC0(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		this.htmlEnv = henv;
		this.htmlEnv2 = henv2;
	}

	@Override
	public Element createNode(ExtList data_info){
		this.setDataList(data_info);
		Element result = new Element(Tag.valueOf("div"), ""); 
		
		 if(decos.containsKey("form")){
			result.appendChild(HTMLFunction.createFormForJsoup(decos));
           	HTMLEnv.setFormItemFlg(true,null);
        	if(decos.getStr("form").toLowerCase().equals("search"))
        		HTMLEnv.setSearch(true);
		 }	 
		
		while (this.hasMoreItems()) {
			result.appendChild((Element)this.createNextItemNode(data_info));
		}
		

       if(decos.containsKey("form")){
    	   result.appendChild(HTMLEnv.exFormNameCreateForJsoup());
    	   HTMLEnv.setFormItemFlg(false,null);
    	   HTMLEnv.incrementFormNumber();
    	   if(decos.getStr("form").toLowerCase().equals("search"))
    		   HTMLEnv.setSearch(false);
       }
       
       return result;
	}
	
	@Override
	public String getSymbol() {
		return "HTMLC0";
	}

}