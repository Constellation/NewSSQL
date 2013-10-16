package supersql.codegenerator.HTML;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.codegenerator.Mobile_HTML5.HTMLFunction;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTMLG2 extends Grouper {

	private HTMLEnv html_env;
	private HTMLEnv html_env2;

    public HTMLG2(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.html_env = henv;
        this.html_env2 = henv2;

    }
    
    @Override
    public Element createNode(ExtList data_info){
    	Element result = new Element(Tag.valueOf("div"), "");
    	result.addClass("vertical").addClass("box").addClass("group2");
        this.setDataList(data_info);
        if(HTMLEnv.getSelectFlg())
        	data_info = (ExtList) data_info.get(0);

        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        
        if(!GlobalEnv.isOpt()){
	        if(html_env.embedFlag)
	        	result.addClass("embed");
	        
	        if(decos.containsKey("outborder"))
	        	result.addClass("noborder");
	        
	        if(decos.containsKey("class")){
	        	result.addClass(html_env.tableBorder);
	        }
	        if(html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
	        	result.addClass(HTMLEnv.getClassID(this));
	        }
	        result.addClass("nest");

	        if(!html_env.isOutlineModeForJsoup()){
	        	result.attr("frame", "void");
	        }
        }
        
        while (this.hasMoreItems()) {
            html_env.gLevel++;
            String classid = HTMLEnv.getClassID(tfe);
            if(!HTMLEnv.getSelectRepeat()){
            	result.appendChild((Element) this.createNextItemNode());
            }
            html_env.gLevel--;
            
        }

        
        if(HTMLEnv.getSelectRepeat()){		
	        if(HTMLEnv.getSelectRepeat()){
	        	HTMLEnv.setSelectRepeat(false);
	        	HTMLEnv.incrementFormPartsNumber();
	        }else{
	        	HTMLEnv.incrementFormPartsNumber();
	        }
		}
        return result;
    	
    }

    //G2��work�᥽�å�
    @Override
	public void work(ExtList data_info) {

        Log.out("------- G2 -------");
        this.setDataList(data_info);
        if(HTMLEnv.getSelectFlg())
        	data_info = (ExtList) data_info.get(0);

        //tk start////////////////////////////////////////////////////
        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        
        if(!GlobalEnv.isOpt()){
	        html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
	        html_env.code.append(html_env.tableBorder + "\" ");
	        Log.out("embed flag :" + html_env.embedFlag);        
	        html_env.code.append("class=\"");
	        if(html_env.embedFlag)
	        	html_env.code.append(" embed ");
	        
	        if(decos.containsKey("outborder"))
	        	html_env.code.append(" noborder ");
	        
	        if(decos.containsKey("class")){
	        	//class=menu�Ȃǂ̎w�肪��������t��
	        	html_env.code.append(decos.getStr("class") + " ");
	        }
	        if(html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
	        	//TFE10000�Ȃǂ̎w�肪��������t��
	        	html_env.code.append(HTMLEnv.getClassID(this) + " ");
	        }
	        html_env.code.append("nest\"");
	        
	        html_env.code.append(html_env.getOutlineMode());
	 
	        html_env.code.append(">");
        }
        //tk end/////////////////////////////////////////////////////
        
        Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\">");

        while (this.hasMoreItems()) {
            html_env.gLevel++;
            Log.out("selectFlg"+HTMLEnv.getSelectFlg());
            Log.out("selectRepeatFlg"+HTMLEnv.getSelectRepeat());
            Log.out("formItemFlg"+HTMLEnv.getFormItemFlg());
            if( HTMLEnv.getSelectRepeat() ){//if form_select
            		//null
            		//in case "select" repeat : not write "<TR><TD>" between "<option>"s
            }else{
	            html_env.code.append("<TR><TD class=\""
	                    + HTMLEnv.getClassID(tfe) + " nest\">\n");
	            Log.out("<TR><TD class=\""
	                    + HTMLEnv.getClassID(tfe) + " nest\">");
            }
            String classid = HTMLEnv.getClassID(tfe);

            
            if(GlobalEnv.isOpt() && !HTMLEnv.getSelectRepeat()){
	            html_env2.code.append("<tfe type=\"repeat\" dimension=\"2\"");
	            html_env2.code.append(" border=\"" + html_env.tableBorder + "\"");
	
	            if (decos.containsKey("tablealign") )
	            	html_env2.code.append(" align=\"" + decos.getStr("tablealign") +"\"");
	            if (decos.containsKey("tablevalign") )
	            	html_env2.code.append(" valign=\"" + decos.getStr("tablevalign") +"\"");
	            

	            if(decos.containsKey("class")){
		        	//class=menu�Ȃǂ̎w�肪��������t��
	            	html_env2.code.append(" class=\"");
		        	html_env2.code.append(decos.getStr("class") + " ");
		        }
	            if(html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
		        	//TFE10000�Ȃǂ̎w�肪��������t��
	            	if(decos.containsKey("class")){
	            		html_env2.code.append(HTMLEnv.getClassID(this) + "\"");
	            	}else{
	            		html_env2.code.append(" class=\""
	            				+ HTMLEnv.getClassID(this) + "\"");
	            	}
	            }else if(decos.containsKey("class")){
	            	html_env2.code.append("\"");
	            }
	            
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

            this.worknextItem();
            
            if (html_env.notWrittenClassId.contains(classid) && html_env.code.indexOf(classid) >= 0 ){
            	html_env.code.delete(html_env.code.indexOf(classid),html_env.code.indexOf(classid)+classid.length()+1);
            }
            
            
            if(HTMLEnv.getSelectRepeat()){
            	
            }else{	 
                //chie
                html_env2.code.append("</tfe>");
            	html_env.code.append("</TD></TR>\n");
            	Log.out("</TD></TR>");
            }
      
            html_env.gLevel--;

        }

        
        if(HTMLEnv.getSelectRepeat()){		
	        if(HTMLEnv.getSelectRepeat()){
	        	//chie
	            html_env2.code.append("</select></VALUE></tfe>");
	        	html_env.code.append("</select></TD></TR>\n");
	        	Log.out("</TD></TR>");
	        	HTMLEnv.setSelectRepeat(false);
	        	HTMLEnv.incrementFormPartsNumber();
	        }else{
	        	HTMLEnv.incrementFormPartsNumber();
	        }
		}

        //html_env2.code.append("</tfe>");
        html_env.code.append("</TABLE>\n");
        Log.out("</TABLE>");
        
        supersql.codegenerator.HTML.HTMLFunction.Func_seq_num_initialization();	//added by goto 20130914  "SEQ_NUM"

        Log.out("TFEId = " + HTMLEnv.getClassID(this));
        //html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        
   }

    @Override
	public String getSymbol() {
        return "HTMLG2";
    }

}
