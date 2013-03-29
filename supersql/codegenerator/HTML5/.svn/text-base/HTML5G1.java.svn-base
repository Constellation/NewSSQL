package supersql.codegenerator.HTML5;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTML5G1 extends Grouper {

    Manager manager;

    HTML5Env html5_env;
    HTML5Env html5_env2;

    //���󥹥ȥ饯��
    public HTML5G1(Manager manager, HTML5Env henv, HTML5Env henv2) {
        this.manager = manager;
        this.html5_env = henv;
        this.html5_env2 = henv2;
  
    }

    //G1��work�᥽�å�
    @Override
	public void work(ExtList data_info) {
        Log.out("------- G1 -------");
        this.setDataList(data_info);
        
        //tk start///////////////////////////////////////////////////
        html5_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);
        

        if(!GlobalEnv.isOpt()){
	        html5_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
	        html5_env.code.append(html5_env.tableborder + "\"");
	        
	        html5_env.code.append(" class=\"");
	
	        if(html5_env.embedflag)
	        	html5_env.code.append("embed ");
	
	        if(decos.containsKey("outborder"))
	        	html5_env.code.append(" noborder ");
	        
	        if(decos.containsKey("class")){
	        	//class=menu�Ȃǂ̎w�肪��������t��
	        	html5_env.code.append(decos.getStr("class") + " ");
	        }
	        if(html5_env.haveClass == 1){
	        	//class=menu�Ȃǂ̎w�肪��������t��
	        	html5_env.code.append(HTML5Env.getClassID(this) + " ");
	        }
	        html5_env.code.append("nest\"");
	
	        html5_env.code.append(html5_env.getOutlineMode());
	
	        html5_env.code.append("><TR>");
        }
        //tk end//////////////////////////////////////////////////////
        
        Log.out("<TABLE class=\""+HTML5Env.getClassID(this) + "\"><TR>");

        //html5_env2.code.append("<tfe type=\"connect\" dimension=\"1\" >");
        int i = 0;
        while (this.hasMoreItems()) {
            html5_env.glevel++;
            
            if(GlobalEnv.isOpt()){
	            html5_env2.code.append("<tfe type=\"repeat\" dimension=\"1\"");
	            
	            if(decos.containsKey("class")){
		        	//class=menu�Ȃǂ̎w�肪��������t��
	            	html5_env2.code.append(" class=\"");
		        	html5_env2.code.append(decos.getStr("class") + " ");
		        }
	            if(html5_env.written_classid.contains(HTML5Env.getClassID(this))){
		        	//TFE10000�Ȃǂ̎w�肪��������t��
	            	if(decos.containsKey("class")){
	            		html5_env2.code.append(HTML5Env.getClassID(this) + "\"");
	            	}else{
	            		html5_env2.code.append(" class=\""
	            				+ HTML5Env.getClassID(this) + "\"");
	            	}
	            }else if(decos.containsKey("class")){
	            	html5_env2.code.append("\"");
	            }
	            
	            html5_env2.code.append(" border=\"" + html5_env.tableborder + "\"");
	
	            if (decos.containsKey("tablealign") )
	            	html5_env2.code.append(" align=\"" + decos.getStr("tablealign") +"\"");
	            if (decos.containsKey("tablevalign") )
	            	html5_env2.code.append(" valign=\"" + decos.getStr("tablevalign") +"\"");
	            
	            if(decos.containsKey("tabletype")){
	            	html5_env2.code.append(" tabletype=\"" + decos.getStr("tabletype") + "\"");
	            	if(decos.containsKey("cellspacing")){
	                	html5_env2.code.append(" cellspacing=\"" + decos.getStr("cellspacing") + "\"");
	                }
	            	if(decos.containsKey("cellpadding")){
	                	html5_env2.code.append(" cellpadding=\"" + decos.getStr("cellpadding") + "\"");
	                }
	            }
	            html5_env2.code.append(">");
            }
            

            html5_env.code.append("<TD class=\""
                    + HTML5Env.getClassID(tfe) + " nest\">\n");            
            String classid = HTML5Env.getClassID(tfe);
            	
            Log.out("<TD class=\""
                    + HTML5Env.getClassID(tfe) + " nest\">");

            
            this.worknextItem();
            
            if (html5_env.not_written_classid.contains(classid)){
            	html5_env.code.delete(html5_env.code.indexOf(classid),html5_env.code.indexOf(classid)+classid.length()+1);
            }
            
            html5_env2.code.append("</tfe>");

            html5_env.code.append("</TD>\n");
            Log.out("</TD>");

            i++;
            html5_env.glevel--;
        }
        
        if(HTML5Env.getFormItemFlg()){		
	        HTML5Env.incrementFormPartsNumber();
		}

        //html5_env2.code.append("</tfe>");
        html5_env.code.append("</TR></TABLE>\n");
        Log.out("</TR></TABLE>");

        Log.out("TFEId = " + HTML5Env.getClassID(this));
        //html5_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);

    }

    @Override
	public String getSymbol() {
        return "HTML5G1";
    }

}