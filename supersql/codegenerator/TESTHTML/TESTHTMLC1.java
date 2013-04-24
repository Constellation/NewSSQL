package supersql.codegenerator.TESTHTML;

import java.util.Vector;

import supersql.codegenerator.*;
import supersql.common.Log;
import supersql.extendclass.ExtList;

//tk
import supersql.common.GlobalEnv;

public class TESTHTMLC1 extends Connector {

    Manager manager;

    TESTHTMLEnv html_env;
    TESTHTMLEnv html_env2;

    //���󥹥ȥ饯��
    public TESTHTMLC1(Manager manager, TESTHTMLEnv henv, TESTHTMLEnv henv2) {
        this.manager = manager;
        this.html_env = henv;
        this.html_env2 = henv2;
    }

    //C1��work�᥽�å�
    public void work(ExtList data_info) {

    	Vector vector_local = new Vector();
        Log.out("------- C1 -------");
        Log.out("tfes.contain_itemnum=" + tfes.contain_itemnum());
        Log.out("tfes.size=" + tfes.size());
        Log.out("countconnetitem=" + countconnectitem());
        this.setDataList(data_info);

        
        if(decos.containsKey("form")){
        	html_env2.code.append("<form"+TESTHTMLEnv.getFormNumber()+"start />");
        	if(decos.getStr("form").toLowerCase().equals("search"))
        		TESTHTMLEnv.setSearch(true);
        }	     

        if(decos.containsKey("insert")){
        	TESTHTMLEnv.setIDU("insert");
        }	
        if(decos.containsKey("update")){
        	TESTHTMLEnv.setIDU("update");
        }
        if(decos.containsKey("delete")){
        	TESTHTMLEnv.setIDU("delete");
        }
        
        //tk start///////////////////////////////////////////////////////////////////////
        html_env.append_css_def_td(TESTHTMLEnv.getClassID(this), this.decos);

        if(!GlobalEnv.isOpt()){
        	html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
        	html_env.code.append(html_env.tableborder + "\"");
        	html_env.code.append(html_env.getOutlineMode());
        	/*
        if(decos.containsKey("outborder")){
        	html_env.code.append(" noborder ");
        	html_env2.code.append(" noborder ");
        }
        	 */        
        	//classid������Ȥ��ˤ�������
        	if(html_env.written_classid.contains(TESTHTMLEnv.getClassID(this))){
        		html_env.code.append(" class=\"");
        		html_env.code.append(TESTHTMLEnv.getClassID(this));
        	}

        	if(decos.containsKey("class")){
        		if(!html_env.written_classid.contains(TESTHTMLEnv.getClassID(this))){
        			html_env.code.append(" class=\"");
        		}else{
        			html_env.code.append(" ");
        		}
        		html_env.code.append(decos.getStr("class")+"\" ");
        	}else if(html_env.written_classid.contains(TESTHTMLEnv.getClassID(this))){
        		html_env.code.append("\" ");
        	}
        	html_env.code.append("><TR>");
        }

        //xml
        if(GlobalEnv.isOpt()){
	        html_env2.code.append("<tfe type=\"connect\" dimension =\"1\"");
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
            		html_env2.code.append(" border=\"" + html_env.tableborder.replace("\"", "") +"\"");
        		}
	        	if(decos.containsKey("tableborder")){
        			html_env2.code.append(" tableborder=\"" + decos.getStr("tableborder").replace("\"", "") + "\"");
        		}
        	}
	        if(html_env.written_classid.contains(TESTHTMLEnv.getClassID(this))){
		        html_env2.code.append(" class=\"");
		        html_env2.code.append(TESTHTMLEnv.getClassID(this));
	        }
	        if(decos.containsKey("class")){
	        	if(!html_env.written_classid.contains(TESTHTMLEnv.getClassID(this))){
	    	        html_env2.code.append(" class=\"");
	            }else{
	    	        html_env2.code.append(" ");
	            }
	        	html_env2.code.append(decos.getStr("class")+"\" ");
	        }else if(html_env.written_classid.contains(TESTHTMLEnv.getClassID(this))){
	        		html_env2.code.append("\" "); 
	        }
	        
	        if(decos.containsKey("form")){
	        	html_env2.code.append(" form=\""+ TESTHTMLEnv.getFormNumber() +"\" ");
	        }	        
	    	html_env2.code.append(">"); 
        }
        
        //tk end////////////////////////////////////////////////////////////////////
      
      
        //Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\"><TR>");
        int i = 0;
        

        if(decos.containsKey("form")){
        	html_env.code.append(TESTHTMLFunction.createForm(decos));
           	TESTHTMLEnv.setFormItemFlg(true,null);
        }
        
        
        while (this.hasMoreItems()) {
            ITFE tfe = (ITFE) tfes.get(i);
            html_env.code.append("<TD class=\""
                   + TESTHTMLEnv.getClassID(tfe) + " nest\">\n");
            String classid = TESTHTMLEnv.getClassID(tfe);
            
            //Log.out("<TD class=\""
            //        + HTMLEnv.getClassID(tfe) + " nest\"> decos : " + decos);
            this.worknextItem();
            
            if (html_env.not_written_classid.contains(classid)){
            	html_env.code.delete(html_env.code.indexOf(classid),html_env.code.indexOf(classid)+classid.length()+1);
            }
            
            html_env.code.append("</TD>\n");
            //Log.out("</TD>");

            i++;
        }

        html_env2.code.append("</tfe>");
        if(decos.containsKey("form")){
        	html_env2.code.append("<form"+ TESTHTMLEnv.getFormNumber() +"end />");
        	Log.out("<form"+ TESTHTMLEnv.getFormNumber() +"end />");
           	html_env.code.append(TESTHTMLEnv.exFormNameCreate());
           	html_env.code.append("</form>");
           	TESTHTMLEnv.setFormItemFlg(false,null);
           	TESTHTMLEnv.incrementFormNumber();
           	if(decos.getStr("form").toLowerCase().equals("search"))
        		TESTHTMLEnv.setSearch(false);
        }
        
        html_env.code.append("</TR></TABLE>\n");
        //Log.out("</TR></TABLE>");

        //Log.out("TFEId = " + HTMLEnv.getClassID(this));
        //html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

    }

    public String getSymbol() {
        return "HTMLC1";
    }

}