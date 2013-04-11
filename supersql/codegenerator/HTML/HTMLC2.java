package supersql.codegenerator.HTML;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;


public class HTMLC2 extends Connector {

    Manager manager;

    HTMLEnv html_env;
    HTMLEnv html_env2;

    //ï¿½ï¿½ï¿½ó¥¹¥È¥é¥¯ï¿½ï¿½
    public HTMLC2(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.manager = manager;
        this.html_env = henv;
        this.html_env2 = henv2;
    }

    //C2¤Îwork¥á¥½¥Ã¥É
    public void work(ExtList data_info) {
        Log.out("------- C2 -------");
        Log.out("tfes.contain_itemnum=" + tfes.contain_itemnum());
        Log.out("tfessize=" + tfes.size());
        Log.out("countconnetitem=" + countconnectitem());
        
        this.setDataList(data_info);

        if(decos.containsKey("form")){
        	html_env2.code.append("<form"+HTMLEnv.getFormNumber()+"start />");
        	if(decos.getStr("form").toLowerCase().equals("search")){
        		HTMLEnv.setSearch(true);
        	}
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

        //tk start////////////////////////////////////////////////////////////////
        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        
        if(!GlobalEnv.isOpt()){
        	html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
        	html_env.code.append(html_env.tableBorder+ "\" ");
        	html_env.code.append(html_env.getOutlineMode());
        	if(html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
        		html_env.code.append(" class=\"");
        		html_env.code.append(HTMLEnv.getClassID(this));
        	}

        	if(decos.containsKey("class")){
        		if(!html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
        			html_env.code.append(" class=\"");
        		}else{
        			html_env.code.append(" ");
        		}
        		html_env.code.append(decos.getStr("class") + "\" ");   	
        	}else if(html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
        		html_env.code.append("\" ");
        	}
        	html_env.code.append(">");
        }
        if(GlobalEnv.isOpt()){
            html_env2.code.append("<tfe type=\"connect\" dimension=\"2\"");
        	if (decos.containsKey("tablealign") )
        		html_env2.code.append(" align=\"" + decos.getStr("tablealign") +"\"");
        	if (decos.containsKey("tablevalign") )
        		html_env2.code.append(" valign=\"" + decos.getStr("tablevalign") +"\"");
        	if (decos.containsKey("height") )
        		html_env2.code.append(" height=\"" + decos.getStr("height") +"\"");
        	if(decos.containsKey("tabletype")){
        		html_env2.code.append(" tabletype=\"" + decos.getStr("tabletype") + "\"");
        		if(decos.containsKey("cellspacing")){
        			html_env2.code.append(" cellspacing=\"" + decos.getStr("cellspacing") + "\"");
        		}
        		if(decos.containsKey("cellpadding")){
        			html_env2.code.append(" cellpadding=\"" + decos.getStr("cellpadding") + "\"");
        		}
        		if(decos.containsKey("border")){
        			html_env2.code.append(" border=\"" + decos.getStr("border").replace("\"", "") + "\"");
        		}

	        	if(decos.containsKey("tableborder")){
        			html_env2.code.append(" tableborder=\"" + decos.getStr("tableborder").replace("\"", "") + "\"");
        		}
        	}else{
        		if(decos.containsKey("border")){
        			html_env2.code.append(" border=\"" + decos.getStr("border").replace("\"", "") + "\"");
        		}else{
            		html_env2.code.append(" border=\"" + html_env.tableBorder.replace("\"", "") +"\"");
        		}
	        	if(decos.containsKey("tableborder")){
        			html_env2.code.append(" tableborder=\"" + decos.getStr("tableborder").replace("\"", "") + "\"");
        		}
        	}
        	if(html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
        		html_env2.code.append(" class=\"");
        		html_env2.code.append(HTMLEnv.getClassID(this));
        	}

        	if(decos.containsKey("class")){
        		if(!html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
        			html_env2.code.append(" class=\"");
        		}else{
        			html_env2.code.append(" ");
        		}
        		html_env2.code.append(decos.getStr("class"));        	
        	}else if(html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
        		html_env2.code.append("\" ");
        	}
        	

	        if(decos.containsKey("form")){
	        	html_env2.code.append(" form=\""+ HTMLEnv.getFormNumber() +"\" ");
	        }	        
	        
        	html_env2.code.append(">");
        }
        /*
        if(decos.containsKey("outborder"))
        	html_env.code.append(" noborder ");
        	*/
       
        
        //html_env2.code.append(">");
        
        //System.out.println(html_env.code);
                
        //tk end//////////////////////////////////////////////////////////////////
        
//        Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\">");

        int i = 0;
        
    	if(decos.containsKey("form")){
           	html_env.code.append(HTMLFunction.createForm(decos));
           	HTMLEnv.setFormItemFlg(true,null);
        }
    	
        while (this.hasMoreItems()) {
            TFE tfe = (TFE) tfes.get(i);

        	   html_env.code.append("<TR><TD class=\""
                   + HTMLEnv.getClassID(tfe) + " nest\">\n");
        	   String classid = HTMLEnv.getClassID(tfe);
            //Log.out("<TR><TD class=\"nest "
            //        + HTMLEnv.getClassID(tfe) + " nest\"> decos:" + decos);
        	

            this.worknextItem();

            if (html_env.notWrittenClassId.contains(classid)){
            	html_env.code.delete(html_env.code.indexOf(classid),html_env.code.indexOf(classid)+classid.length()+1);
            }
            
            html_env.code.append("</TD></TR>\n");
           //Log.out("</TD></TR>");

            i++;

        }

        html_env2.code.append("</tfe>");
        //Log.out("</TABLE>");
        if(decos.containsKey("form")){
        	html_env2.code.append("<form"+ HTMLEnv.getFormNumber() +"end />");
        	html_env.code.append(HTMLEnv.exFormNameCreate());
           	html_env.code.append("</form>");
           	HTMLEnv.setFormItemFlg(false,null);
           	HTMLEnv.incrementFormNumber();
           	if(decos.getStr("form").toLowerCase().equals("search"))
        		HTMLEnv.setSearch(false);
        }

        html_env.code.append("</TABLE>\n");

        Log.out("TFEId = " + HTMLEnv.getClassID(this));
        //html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

    }

    public String getSymbol() {
        return "HTMLC2";
    }

}
