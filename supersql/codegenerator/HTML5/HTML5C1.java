package supersql.codegenerator.HTML5;

import java.util.Vector;

import supersql.codegenerator.*;
import supersql.common.Log;
import supersql.extendclass.ExtList;

//tk
import supersql.common.GlobalEnv;

public class HTML5C1 extends Connector {

    Manager manager;

    HTML5Env html5_env;
    HTML5Env html5_env2;

    //���󥹥ȥ饯��
    public HTML5C1(Manager manager, HTML5Env henv, HTML5Env henv2) {
        this.manager = manager;
        this.html5_env = henv;
        this.html5_env2 = henv2;
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
        	html5_env2.code.append("<form"+HTML5Env.getFormNumber()+"start />");
        	if(decos.getStr("form").toLowerCase().equals("search"))
        		HTML5Env.setSearch(true);
        }

        if(decos.containsKey("insert")){
        	HTML5Env.setIDU("insert");
        }
        if(decos.containsKey("update")){
        	HTML5Env.setIDU("update");
        }
        if(decos.containsKey("delete")){
        	HTML5Env.setIDU("delete");
        }

        //tk start///////////////////////////////////////////////////////////////////////
        html5_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);

        if(!GlobalEnv.isOpt()){
        	html5_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
        	html5_env.code.append(html5_env.tableborder + "\"");
        	html5_env.code.append(html5_env.getOutlineMode());
        	/*
        if(decos.containsKey("outborder")){
        	html5_env.code.append(" noborder ");
        	html5_env2.code.append(" noborder ");
        }
        	 */
        	//classid������Ȥ��ˤ�������
        	if(html5_env.written_classid.contains(HTML5Env.getClassID(this))){
        		html5_env.code.append(" class=\"");
        		html5_env.code.append(HTML5Env.getClassID(this));
        	}

        	if(decos.containsKey("class")){
        		if(!html5_env.written_classid.contains(HTML5Env.getClassID(this))){
        			html5_env.code.append(" class=\"");
        		}else{
        			html5_env.code.append(" ");
        		}
        		html5_env.code.append(decos.getStr("class")+"\" ");
        	}else if(html5_env.written_classid.contains(HTML5Env.getClassID(this))){
        		html5_env.code.append("\" ");
        	}
        	html5_env.code.append("><TR>");
        }

        //xml
        if(GlobalEnv.isOpt()){
	        html5_env2.code.append("<tfe type=\"connect\" dimension =\"1\"");
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
	        	if(decos.containsKey("border")){
        			html5_env2.code.append(" border=\"" + decos.getStr("border").replace("\"", "") + "\"");
        		}
	        	if(decos.containsKey("tableborder")){
        			html5_env2.code.append(" tableborder=\"" + decos.getStr("tableborder").replace("\"", "") + "\"");
        		}
        	}else{
        		if(decos.containsKey("border")){
        			html5_env2.code.append(" border=\"" + decos.getStr("border").replace("\"", "") + "\"");
        		}else{
            		html5_env2.code.append(" border=\"" + html5_env.tableborder.replace("\"", "") +"\"");
        		}
	        	if(decos.containsKey("tableborder")){
        			html5_env2.code.append(" tableborder=\"" + decos.getStr("tableborder").replace("\"", "") + "\"");
        		}
        	}
	        if(html5_env.written_classid.contains(HTML5Env.getClassID(this))){
		        html5_env2.code.append(" class=\"");
		        html5_env2.code.append(HTML5Env.getClassID(this));
	        }
	        if(decos.containsKey("class")){
	        	if(!html5_env.written_classid.contains(HTML5Env.getClassID(this))){
	    	        html5_env2.code.append(" class=\"");
	            }else{
	    	        html5_env2.code.append(" ");
	            }
	        	html5_env2.code.append(decos.getStr("class")+"\" ");
	        }else if(html5_env.written_classid.contains(HTML5Env.getClassID(this))){
	        		html5_env2.code.append("\" ");
	        }

	        if(decos.containsKey("form")){
	        	html5_env2.code.append(" form=\""+ HTML5Env.getFormNumber() +"\" ");
	        }
	    	html5_env2.code.append(">");
        }

        //tk end////////////////////////////////////////////////////////////////////


        //Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\"><TR>");
        int i = 0;


        if(decos.containsKey("form")){
        	html5_env.code.append(HTML5Function.createForm(decos));
           	HTML5Env.setFormItemFlg(true,null);
        }


        while (this.hasMoreItems()) {
            TFE tfe = (TFE) tfes.get(i);
            html5_env.code.append("<TD class=\""
                   + HTML5Env.getClassID(tfe) + " nest\">\n");
            String classid = HTML5Env.getClassID(tfe);

            //Log.out("<TD class=\""
            //        + HTML5Env.getClassID(tfe) + " nest\"> decos : " + decos);
            this.worknextItem();

            if (html5_env.not_written_classid.contains(classid)){
            	html5_env.code.delete(html5_env.code.indexOf(classid),html5_env.code.indexOf(classid)+classid.length()+1);
            }

            html5_env.code.append("</TD>\n");
            //Log.out("</TD>");

            i++;
        }

        html5_env2.code.append("</tfe>");
        if(decos.containsKey("form")){
        	html5_env2.code.append("<form"+ HTML5Env.getFormNumber() +"end />");
        	Log.out("<form"+ HTML5Env.getFormNumber() +"end />");
           	html5_env.code.append(HTML5Env.exFormNameCreate());
           	html5_env.code.append("</form>");
           	HTML5Env.setFormItemFlg(false,null);
           	HTML5Env.incrementFormNumber();
           	if(decos.getStr("form").toLowerCase().equals("search"))
        		HTML5Env.setSearch(false);
        }

        html5_env.code.append("</TR></TABLE>\n");
        //Log.out("</TR></TABLE>");

        //Log.out("TFEId = " + HTML5Env.getClassID(this));
        //html_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);

    }

    public String getSymbol() {
        return "HTML5C1";
    }

}