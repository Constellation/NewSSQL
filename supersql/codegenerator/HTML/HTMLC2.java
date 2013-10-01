package supersql.codegenerator.HTML;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Connector;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.extendclass.ExtList;


public class HTMLC2 extends Connector {

	private HTMLEnv htmlEnv;
	public HTMLC2(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.htmlEnv = henv;
        Dimension =2;
    }

    @Override
    public Element createNode(ExtList<ExtList<String>> data_info){
    	Element result = new Element(Tag.valueOf("div"), "");
    	result.addClass("vertical").addClass("con2").addClass("box");
    	this.setDataList(data_info);

        if(decos.containsKey("form") && decos.getStr("form").toLowerCase().equals("search")){
    		HTMLEnv.setSearch(true);
        }	
        
        if(decos.containsKey("insert")){
        	HTMLEnv.setIDU("insert");
        }
        if(decos.containsKey("update")){
        	HTMLEnv.setIDU("update");
        }
        if(decos.containsKey("delete")){
        	HTMLEnv.setIDU("delete");
        }

        htmlEnv.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        
        if(!GlobalEnv.isOpt()){
        	if(!htmlEnv.isOutlineModeForJsoup()){
        		result.attr("frame", "void");
        	}
        	if(htmlEnv.writtenClassId.contains(HTMLEnv.getClassID(this))){
        		result.attr("class", HTMLEnv.getClassID(this));
        	}

        	if(decos.containsKey("class")){
        		result.attr("class", result.attr("class") + " " + decos.getStr("class"));
        	}
        }

        int i = 0;
        
    	if(decos.containsKey("form")){
    		result.appendChild(HTMLFunction.createForm(decos));
           	HTMLEnv.setFormItemFlg(true,null);
        }
    	
        while (this.hasMoreItems()) {
            ITFE tfe = (ITFE) tfes.get(i);
            result.addClass(HTMLEnv.getClassID(tfe)).addClass("nest");
            
        	HTMLEnv.getClassID(tfe);

            result.appendChild((Element)this.createNextItemNode(data_info));

            i++;
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
    
    public String getSymbol() {
        return "HTMLC2";
    }

}
