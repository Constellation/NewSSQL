package supersql.codegenerator.HTML;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.extendclass.ExtList;

public class HTMLG1 extends Grouper {

	private HTMLEnv html_env;
	public HTMLG1(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.html_env = henv;
        Dimension = 1;
    }
    
    @Override
    public Element createNode(ExtList<ExtList<String>> data_info){
        this.setDataList(data_info);
        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        
        Element result = new Element(Tag.valueOf("div"), "");
        result.addClass("horizontal").addClass("box").addClass("group1");
        
        if(!GlobalEnv.isOpt()){
	        
	        if(html_env.embedFlag)
	        	result.addClass("embed");
	
	        if(decos.containsKey("outborder"))
	        	result.addClass("noborder");
	        
	        if(decos.containsKey("class")){
	        	result.addClass(decos.getStr("class"));
	        }
	        if(html_env.haveClass == 1){
	        	result.addClass(HTMLEnv.getClassID(this));
	        }
        	result.addClass("nest");
        	
        	if(!html_env.isOutlineModeForJsoup()){
        		result.attr("frame", "void");
        	}
        }

        while (this.hasMoreItems()) {
        	html_env.gLevel++;
            
            HTMLEnv.getClassID(tfe);
            	
            result.appendChild((Element)this.createNextItemNode());
            
            html_env.gLevel--;
        }
        
        if(HTMLEnv.getFormItemFlg()){		
	        HTMLEnv.incrementFormPartsNumber();
		}
        return result;

    }

    @Override
	public String getSymbol() {
        return "HTMLG1";
    }

}
