package supersql.codegenerator.HTML5;

import java.util.Vector;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTML5G2 extends Grouper {

    Manager manager;

    HTML5Env html5_env;
    HTML5Env html5_env2;

    //���󥹥ȥ饯��
    public HTML5G2(Manager manager, HTML5Env henv, HTML5Env henv2) {
        this.manager = manager;
        this.html5_env = henv;
        this.html5_env2 = henv2;

    }

    //G2��work�᥽�å�
    @Override
	public void work(ExtList data_info) {

        Vector vector_local = new Vector();

        Log.out("------- G2 -------");
        this.setDataList(data_info);
        if(HTML5Env.getSelectFlg())
        	data_info = (ExtList) data_info.get(0);

        //tk start////////////////////////////////////////////////////
        html5_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);

        if(!GlobalEnv.isOpt()){
	        html5_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
	        html5_env.code.append(html5_env.tableborder + "\" ");
	        Log.out("embed flag :" + html5_env.embedflag);
	        html5_env.code.append("class=\"");
	        if(html5_env.embedflag)
	        	html5_env.code.append(" embed ");

	        if(decos.containsKey("outborder"))
	        	html5_env.code.append(" noborder ");

	        if(decos.containsKey("class")){
	        	//class=menu�Ȃǂ̎w�肪��������t��
	        	html5_env.code.append(decos.getStr("class") + " ");
	        }
	        if(html5_env.written_classid.contains(HTML5Env.getClassID(this))){
	        	//TFE10000�Ȃǂ̎w�肪��������t��
	        	html5_env.code.append(HTML5Env.getClassID(this) + " ");
	        }
	        html5_env.code.append("nest\"");

	        html5_env.code.append(html5_env.getOutlineMode());

	        html5_env.code.append(">");
        }
        //tk end/////////////////////////////////////////////////////

        Log.out("<TABLE class=\""+HTML5Env.getClassID(this) + "\">");

        //html5_env2.code.append("<tfe type=\"connect\" dimension=\"2\" >");
        int i = 0;
        while (this.hasMoreItems()) {
            html5_env.glevel++;
            Log.out("selectFlg"+HTML5Env.getSelectFlg());
            Log.out("selectRepeatFlg"+HTML5Env.getSelectRepeat());
            Log.out("formItemFlg"+HTML5Env.getFormItemFlg());
            if( HTML5Env.getSelectRepeat() ){//if form_select
            		//null
            		//in case "select" repeat : not write "<TR><TD>" between "<option>"s
            }else{
	            html5_env.code.append("<TR><TD class=\""
	                    + HTML5Env.getClassID(tfe) + " nest\">\n");
	            Log.out("<TR><TD class=\""
	                    + HTML5Env.getClassID(tfe) + " nest\">");
            }
            String classid = HTML5Env.getClassID(tfe);


            if(GlobalEnv.isOpt() && !HTML5Env.getSelectRepeat()){
	            html5_env2.code.append("<tfe type=\"repeat\" dimension=\"2\"");
	            html5_env2.code.append(" border=\"" + html5_env.tableborder + "\"");

	            if (decos.containsKey("tablealign") )
	            	html5_env2.code.append(" align=\"" + decos.getStr("tablealign") +"\"");
	            if (decos.containsKey("tablevalign") )
	            	html5_env2.code.append(" valign=\"" + decos.getStr("tablevalign") +"\"");


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

            this.worknextItem();

            if (html5_env.not_written_classid.contains(classid) && html5_env.code.indexOf(classid) >= 0 ){
            	html5_env.code.delete(html5_env.code.indexOf(classid),html5_env.code.indexOf(classid)+classid.length()+1);
            }


            if(HTML5Env.getSelectRepeat()){

            }else{
                //chie
                html5_env2.code.append("</tfe>");
            	html5_env.code.append("</TD></TR>\n");
            	Log.out("</TD></TR>");
            }

            i++;
            html5_env.glevel--;

        }


        if(HTML5Env.getSelectRepeat()){
	        if(HTML5Env.getSelectRepeat()){
	        	//chie
	            html5_env2.code.append("</select></VALUE></tfe>");
	        	html5_env.code.append("</select></TD></TR>\n");
	        	Log.out("</TD></TR>");
	        	HTML5Env.setSelectRepeat(false);
	        	HTML5Env.incrementFormPartsNumber();
	        }else{
	        	HTML5Env.incrementFormPartsNumber();
	        }
		}

        //html5_env2.code.append("</tfe>");
        html5_env.code.append("</TABLE>\n");
        Log.out("</TABLE>");

        Log.out("TFEId = " + HTML5Env.getClassID(this));
        //html5_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

   }

    @Override
	public String getSymbol() {
        return "HTML5G2";
    }

}