package supersql.codegenerator.Mobile_HTML5;

import java.util.Vector;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTMLG2 extends Grouper {

    Manager manager;

    HTMLEnv html_env;
    HTMLEnv html_env2;
    
    //20130309
    //int gridInt = 0;
    //String[] gridString = {"a","b","c","d","e"};
    //static int ii =0, jj = 0;
    //static String buf = "";
    
    static boolean tableFlg = false;		//20130314  table
    static boolean table0Flg = false;		//20130325  table0
    static boolean divFlg = false;			//20130326  div

    //���󥹥ȥ饯��
    public HTMLG2(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.manager = manager;
        this.html_env = henv;
        this.html_env2 = henv2;

    }

    //G2��work�᥽�å�
    @Override
	public void work(ExtList data_info) {

        Vector vector_local = new Vector();
 
        Log.out("------- G2 -------");
        this.setDataList(data_info);
        if(HTMLEnv.getSelectFlg())
        	data_info = (ExtList) data_info.get(0);

        //tk start////////////////////////////////////////////////////
        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        
        //20130325  table0
        if(decos.containsKey("table0"))	table0Flg = true;
        else							table0Flg = false;
    	//20130314  table
        //if(decos.containsKey("table") || !decos.containsKey("div") || table0Flg){
        if(decos.containsKey("table") || table0Flg){
    		tableFlg = true;
    	}else	tableFlg = false;
        
        //20130326  div
    	if(decos.containsKey("div")){
    		divFlg = true;
    		tableFlg = false;
    	}else divFlg = false;
        
        if(!GlobalEnv.isOpt()){
        	//20130309
        	//20130314  table
        	if(tableFlg){
		        html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
	        	//html_env.code.append( ((!decos.containsKey("table0"))? html_env.tableborder : "0") + "\" ");
	        	if(table0Flg)	html_env.code.append("0" + "\"");	//20130325 table0
	        	else			html_env.code.append(html_env.tableborder + "\"");
//		        html_env.code.append(html_env.tableborder + "\" ");
		        Log.out("embed flag :" + html_env.embedflag);        
//		        html_env.code.append(" class=\"");
		        if(html_env.embedflag)
		        	html_env.code.append(" embed ");
		        
		        if(decos.containsKey("outborder"))
		        	html_env.code.append(" noborder ");
		        
		        if(decos.containsKey("class")){
		        	//class=menu�Ȃǂ̎w�肪��������t��
		        	html_env.code.append(" class=\"");
		        	html_env.code.append(decos.getStr("class") + " ");
		        }
		        if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
		        	//TFE10000�Ȃǂ̎w�肪��������t��
		        	html_env.code.append(" class=\"");
		        	html_env.code.append(HTMLEnv.getClassID(this) + " ");
		        }
	//	        html_env.code.append("nest\"");
	//	        
	//	        html_env.code.append(html_env.getOutlineMode());
		 
		        html_env.code.append(">\n");		//added '\n' 20130110
        	}
        }
        //tk end/////////////////////////////////////////////////////
        
        Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\">");

        //html_env2.code.append("<tfe type=\"connect\" dimension=\"2\" >");
        int i = 0;
        while (this.hasMoreItems()) {
            html_env.glevel++;
            Log.out("selectFlg"+HTMLEnv.getSelectFlg());
            Log.out("selectRepeatFlg"+HTMLEnv.getSelectRepeat());
            Log.out("formItemFlg"+HTMLEnv.getFormItemFlg());
            if( HTMLEnv.getSelectRepeat() ){//if form_select
            		//null
            		//in case "select" repeat : not write "<TR><TD>" between "<option>"s
            }else{
            	//20130309
            	//gridInt %= 5;
            	//html_env.code.append("\n	<div class=\"ui-block-"+gridString[gridInt]+"\">\n");
            	if(!tableFlg)	html_env.code.append("\n	<div class=\""+HTMLEnv.getClassID(tfe)+" \">\n");	//20130309  div
                //20130314  table
            	else{
		            html_env.code.append("<TR><TD class=\""
		                    + HTMLEnv.getClassID(tfe) + " nest\">\n");
            	}
	            Log.out("<TR><TD class=\""
	                    + HTMLEnv.getClassID(tfe) + " nest\">");
            }
            String classid = HTMLEnv.getClassID(tfe);

            
            if(GlobalEnv.isOpt() && !HTMLEnv.getSelectRepeat()){
	            html_env2.code.append("<tfe type=\"repeat\" dimension=\"2\"");
	            html_env2.code.append(" border=\"" + html_env.tableborder + "\"");
	
	            if (decos.containsKey("tablealign") )
	            	html_env2.code.append(" align=\"" + decos.getStr("tablealign") +"\"");
	            if (decos.containsKey("tablevalign") )
	            	html_env2.code.append(" valign=\"" + decos.getStr("tablevalign") +"\"");
	            

	            if(decos.containsKey("class")){
		        	//class=menu�Ȃǂ̎w�肪��������t��
	            	html_env2.code.append(" class=\"");
		        	html_env2.code.append(decos.getStr("class") + " ");
		        }
	            if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
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
            
            if (html_env.not_written_classid.contains(classid) && html_env.code.indexOf(classid) >= 0 ){
            	html_env.code.delete(html_env.code.indexOf(classid),html_env.code.indexOf(classid)+classid.length()+1);
            }
            
            
            if(HTMLEnv.getSelectRepeat()){
            	
            }else{	 
                //chie
                html_env2.code.append("</tfe>");
                //added by goto 20130110 start
                if(HTMLFunction.slideshowFlg==true){
                	html_env.code.append("</ul>\n</div>\n");
                }
                //added by goto 20130110 end
                if(!tableFlg)	html_env.code.append("	</div>\n");		//20130309  div
                else	html_env.code.append("</TD></TR>\n");			//20130314  table
            	Log.out("</TD></TR>");
            }
      
            i++;
            html_env.glevel--;

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
        //20130314  table
        if(tableFlg){
        	html_env.code.append("</TABLE>\n");		//20130309
        	tableFlg = false;
        	table0Flg = false;		//20130325 table0
        }
        Log.out("</TABLE>");
        
        if(divFlg)	divFlg = false;		//20130326  div

        Log.out("TFEId = " + HTMLEnv.getClassID(this));
        //html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        
   }

    @Override
	public String getSymbol() {
        return "HTMLG2";
    }

}