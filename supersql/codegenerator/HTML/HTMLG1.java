package supersql.codegenerator.HTML;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTMLG1 extends Grouper {

	private HTMLEnv html_env;
	private HTMLEnv html_env2;

    //¥³¥ó¥¹¥È¥é¥¯¥¿
    public HTMLG1(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.html_env = henv;
        this.html_env2 = henv2;
  
    }
    
    @Override
    public Element createNode(ExtList data_info){
        this.setDataList(data_info);
        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        
        Element result = new Element(Tag.valueOf("table"), "");
        
        if(!GlobalEnv.isOpt()){
        	result.attr("cellSpacing", "0");
        	result.attr("cellPadding", "0");
        	result.attr("border", html_env.tableBorder);
	        
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

        Element tr = new Element(Tag.valueOf("tr"), "");
        
        while (this.hasMoreItems()) {
        	html_env.gLevel++;
            
        	Element td = new Element(Tag.valueOf("td"), "");
        	td.addClass(HTMLEnv.getClassID(tfe));
        	td.addClass("nest");
        	
            String classid = HTMLEnv.getClassID(tfe);
            	
            td.appendChild((Element)this.createNextItemNode());
            
            tr.appendChild(td);
            html_env.gLevel--;
        }
        
        if(HTMLEnv.getFormItemFlg()){		
	        HTMLEnv.incrementFormPartsNumber();
		}
        result.appendChild(tr);
        return result;

    }

    //G1¤Îwork¥á¥½¥Ã¥É
    @Override
	public void work(ExtList data_info) {
        Log.out("------- G1 -------");
        this.setDataList(data_info);
        
        //tk start///////////////////////////////////////////////////
        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        

        if(!GlobalEnv.isOpt()){
	        html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
	        html_env.code.append(html_env.tableBorder + "\"");
	        
	        html_env.code.append(" class=\"");
	
	        if(html_env.embedFlag)
	        	html_env.code.append("embed ");
	
	        if(decos.containsKey("outborder"))
	        	html_env.code.append(" noborder ");
	        
	        if(decos.containsKey("class")){
	        	//class=menu‚È‚Ç‚ÌŽw’è‚ª‚ ‚Á‚½‚ç•t‰Á
	        	html_env.code.append(decos.getStr("class") + " ");
	        }
	        if(html_env.haveClass == 1){
	        	//class=menu‚È‚Ç‚ÌŽw’è‚ª‚ ‚Á‚½‚ç•t‰Á
	        	html_env.code.append(HTMLEnv.getClassID(this) + " ");
	        }
	        html_env.code.append("nest\"");
	
	        html_env.code.append(html_env.getOutlineMode());
	
	        html_env.code.append("><TR>");
        }
        //tk end//////////////////////////////////////////////////////
        
        Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\"><TR>");

        while (this.hasMoreItems()) {
            html_env.gLevel++;
            
            if(GlobalEnv.isOpt()){
	            html_env2.code.append("<tfe type=\"repeat\" dimension=\"1\"");
	            
	            if(decos.containsKey("class")){
		        	//class=menu‚È‚Ç‚ÌŽw’è‚ª‚ ‚Á‚½‚ç•t‰Á
	            	html_env2.code.append(" class=\"");
		        	html_env2.code.append(decos.getStr("class") + " ");
		        }
	            if(html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
		        	//TFE10000ï¿½È‚Ç‚ÌŽwï¿½è‚ªï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½tï¿½ï¿½
	            	if(decos.containsKey("class")){
	            		html_env2.code.append(HTMLEnv.getClassID(this) + "\"");
	            	}else{
	            		html_env2.code.append(" class=\""
	            				+ HTMLEnv.getClassID(this) + "\"");
	            	}
	            }else if(decos.containsKey("class")){
	            	html_env2.code.append("\"");
	            }
	            
	            html_env2.code.append(" border=\"" + html_env.tableBorder + "\"");
	
	            if (decos.containsKey("tablealign") )
	            	html_env2.code.append(" align=\"" + decos.getStr("tablealign") +"\"");
	            if (decos.containsKey("tablevalign") )
	            	html_env2.code.append(" valign=\"" + decos.getStr("tablevalign") +"\"");
	            
	            if(decos.containsKey("tabletype")){
	            	html_env2.code.append(" tabletype=\"" + decos.getStr("tabletype") + "\"");
	            	if(decos.containsKey("cellspacing")){
	                	html_env2.code.append(" cellspacing=\"" + decos.getStr("cellspacing") + "\"");
	                }
	            	if(decos.containsKey("cellpadding")){
	                	html_env2.code.append(" cellpadding=\"" + decos.getStr("cellpadding") + "\"");
	                }
	            }
	            html_env2.code.append(">");
            }
            

            html_env.code.append("<TD class=\""
                    + HTMLEnv.getClassID(tfe) + " nest\">\n");            
            String classid = HTMLEnv.getClassID(tfe);
            	
            Log.out("<TD class=\""
                    + HTMLEnv.getClassID(tfe) + " nest\">");

            
            this.worknextItem();
            
            if (html_env.notWrittenClassId.contains(classid)){
            	html_env.code.delete(html_env.code.indexOf(classid),html_env.code.indexOf(classid)+classid.length()+1);
            }
            
            html_env2.code.append("</tfe>");

            html_env.code.append("</TD>\n");
            Log.out("</TD>");

            html_env.gLevel--;
        }
        
        if(HTMLEnv.getFormItemFlg()){		
	        HTMLEnv.incrementFormPartsNumber();
		}

        //html_env2.code.append("</tfe>");
        html_env.code.append("</TR></TABLE>\n");
        Log.out("</TR></TABLE>");

        Log.out("TFEId = " + HTMLEnv.getClassID(this));
        //html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

    }

    @Override
	public String getSymbol() {
        return "HTMLG1";
    }

}
