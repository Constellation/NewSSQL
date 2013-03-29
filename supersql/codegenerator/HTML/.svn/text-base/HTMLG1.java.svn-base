package supersql.codegenerator.HTML;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTMLG1 extends Grouper {

    Manager manager;

    HTMLEnv html_env;
    HTMLEnv html_env2;

    //･ｳ･ｹ･ﾈ･鬣ｯ･ｿ
    public HTMLG1(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.manager = manager;
        this.html_env = henv;
        this.html_env2 = henv2;
  
    }

    //G1､ﾎwork･皈ｽ･ﾃ･ﾉ
    @Override
	public void work(ExtList data_info) {
        Log.out("------- G1 -------");
        this.setDataList(data_info);
        
        //tk start///////////////////////////////////////////////////
        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        

        if(!GlobalEnv.isOpt()){
	        html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
	        html_env.code.append(html_env.tableborder + "\"");
	        
	        html_env.code.append(" class=\"");
	
	        if(html_env.embedflag)
	        	html_env.code.append("embed ");
	
	        if(decos.containsKey("outborder"))
	        	html_env.code.append(" noborder ");
	        
	        if(decos.containsKey("class")){
	        	//class=menuなどの指定があったら付加
	        	html_env.code.append(decos.getStr("class") + " ");
	        }
	        if(html_env.haveClass == 1){
	        	//class=menuなどの指定があったら付加
	        	html_env.code.append(HTMLEnv.getClassID(this) + " ");
	        }
	        html_env.code.append("nest\"");
	
	        html_env.code.append(html_env.getOutlineMode());
	
	        html_env.code.append("><TR>");
        }
        //tk end//////////////////////////////////////////////////////
        
        Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\"><TR>");

        //html_env2.code.append("<tfe type=\"connect\" dimension=\"1\" >");
        int i = 0;
        while (this.hasMoreItems()) {
            html_env.glevel++;
            
            if(GlobalEnv.isOpt()){
	            html_env2.code.append("<tfe type=\"repeat\" dimension=\"1\"");
	            
	            if(decos.containsKey("class")){
		        	//class=menuなどの指定があったら付加
	            	html_env2.code.append(" class=\"");
		        	html_env2.code.append(decos.getStr("class") + " ");
		        }
	            if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
		        	//TFE10000などの指定があったら付加
	            	if(decos.containsKey("class")){
	            		html_env2.code.append(HTMLEnv.getClassID(this) + "\"");
	            	}else{
	            		html_env2.code.append(" class=\""
	            				+ HTMLEnv.getClassID(this) + "\"");
	            	}
	            }else if(decos.containsKey("class")){
	            	html_env2.code.append("\"");
	            }
	            
	            html_env2.code.append(" border=\"" + html_env.tableborder + "\"");
	
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
            
            if (html_env.not_written_classid.contains(classid)){
            	html_env.code.delete(html_env.code.indexOf(classid),html_env.code.indexOf(classid)+classid.length()+1);
            }
            
            html_env2.code.append("</tfe>");

            html_env.code.append("</TD>\n");
            Log.out("</TD>");

            i++;
            html_env.glevel--;
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