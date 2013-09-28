package supersql.codegenerator.HTML;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Connector;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;
//tk

public class HTMLC1 extends Connector {

    private HTMLEnv htmlEnv;
    private HTMLEnv htmlEnv2;

    //コンストラクタ
    public HTMLC1(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.htmlEnv = henv;
        this.htmlEnv2 = henv2;
    }

    @Override
    public Element createNode(ExtList dataInfo){
    	this.setDataList(dataInfo);
    	Element result = new Element(Tag.valueOf("div"), "");
    	result.addClass("con1").addClass("horizontal").addClass("box");
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
        	
        	if(htmlEnv.writtenClassId.contains(HTMLEnv.getClassID(this))){
        		result.addClass(HTMLEnv.getClassID(this));
        	}

        	if(decos.containsKey("class")){
        		result.addClass(decos.getStr("class"));
        	}
        }
        int i = 0;

        if(decos.containsKey("form")){
        	result.appendChild(HTMLFunction.createFormForJsoup(decos));
           	HTMLEnv.setFormItemFlg(true,null);
        }
        
        
        while (this.hasMoreItems()) {
        	Element td = new Element(Tag.valueOf("td"), "");
            ITFE tfe = (ITFE) tfes.get(i);
            td.attr("class", HTMLEnv.getClassID(tfe) + " nest");
            String classid = HTMLEnv.getClassID(tfe);
            
            result.appendChild((Element)this.createNextItemNode(dataInfo));
            i++;
        }

        if(decos.containsKey("form")){
        	Element exForm = HTMLEnv.exFormNameCreateForJsoup();
        	if(exForm != null){
        		result.appendChild(exForm);
        	}
           	HTMLEnv.setFormItemFlg(false,null);
           	HTMLEnv.incrementFormNumber();
           	if(decos.getStr("form").toLowerCase().equals("search"))
        		HTMLEnv.setSearch(false);
        }
        
		return result;
    }
    
    public String getSymbol() {
        return "HTMLC1";
    }

}
