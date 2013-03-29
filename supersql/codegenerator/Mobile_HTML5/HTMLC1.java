package supersql.codegenerator.Mobile_HTML5;

import java.util.Vector;

import supersql.codegenerator.*;
import supersql.common.Log;
import supersql.extendclass.ExtList;

//tk
import supersql.common.GlobalEnv;

public class HTMLC1 extends Connector {

    Manager manager;

    HTMLEnv html_env;
    HTMLEnv html_env2;
    
    //20130309
    int gridInt = 0;
    String[] gridString = {"a","b","c","d","e"};
    static int ii =0, jj = 0, Count = 0;
    //static String buf = "";
    
    static boolean tableFlg = false;		//20130314  table
    static boolean table0Flg = false;		//20130325  table0
    static boolean divFlg = false;			//20130326  div

    //���󥹥ȥ饯��
    public HTMLC1(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.manager = manager;
        this.html_env = henv;
        this.html_env2 = henv2;
    }

    //C1��work�᥽�å�
    public void work(ExtList data_info) {

//    	Vector vector_local = new Vector();
        Log.out("------- C1 -------");
        Log.out("tfes.contain_itemnum=" + tfes.contain_itemnum());
        Log.out("tfes.size=" + tfes.size());
        Log.out("countconnetitem=" + countconnectitem());
        this.setDataList(data_info);

        
        if(decos.containsKey("form")){
        	html_env2.code.append("<form"+HTMLEnv.getFormNumber()+"start />");
        	if(decos.getStr("form").toLowerCase().equals("search"))
        		HTMLEnv.setSearch(true);
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
        
        //tk start///////////////////////////////////////////////////////////////////////
        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        
        //20130325  table0
        if(decos.containsKey("table0"))	table0Flg = true;
        else							table0Flg = false;
    	//20130314  table
        //Log.info("	"+HTMLC1.tableFlg+" "+HTMLC2.tableFlg+" "+HTMLG1.tableFlg);
        //if(decos.containsKey("table") || !decos.containsKey("div") || table0Flg || HTMLC2.tableFlg || HTMLG1.tableFlg || HTMLG2.tableFlg){
    	if(decos.containsKey("table") || table0Flg || HTMLC2.tableFlg || HTMLG1.tableFlg || HTMLG2.tableFlg){
//    		Log.info("C1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//    		Log.info("C1 tableFlg = true !!");
    		tableFlg = true;
    	}else	tableFlg = false;
    	
    	//20130326  div
    	if(decos.containsKey("div")){
    		divFlg = true;
    		tableFlg = false;
    	}else divFlg = false;

        if(!GlobalEnv.isOpt()){
//        	//changed by goto 20130309  border=0
//        	html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\"");
        	
        	//20130312 collapsible
        	if(decos.containsKey("collapse")){
            	html_env.code.append("<DIv data-role=\"collapsible\" data-content-theme=\"c\" style=\"padding: 0px 12px;\">\n");
            	
            	//header
            	if(!decos.getStr("collapse").equals(""))
            		html_env.code.append("	<h1>"+decos.getStr("collapse")+"</h1>\n");
            	else
            		html_env.code.append("<h1>Contents</h1>\n");
            }
        	//20130309
//        	if(!HTMLG1.G1Flg && !tableFlg)	html_env.code.append("<DIV Class=\"ui-grid-a\"");
        	//if((!HTMLG1.G1Flg && !tableFlg) || divFlg){		//20130326  div
        	if(!HTMLG1.G1Flg && !tableFlg){
        		html_env.code.append("<DIV Class=\"ui-grid-a #"+HTMLEnv.uiGridCount+"\"");
        		HTMLEnv.uiGridCount++;
        		//Log.info("ui-grid-a #"+HTMLEnv.uiGridCount+"	"+"<DIV Class=\"ui-grid-a #"+HTMLEnv.uiGridCount+"\"");
        	}
        	
        	
        	//20130314  table
        	if(tableFlg){
        		html_env.code.append("<TABLE width=\"100%\" align=\"center\" cellSpacing=\"0\" cellPadding=\"0\" border=\"");
	        	//html_env.code.append("<TABLE width=\"95%\" align=\"center\" cellSpacing=\"0\" cellPadding=\"0\" border=\"");
        		//html_env.code.append(((!table0Flg)? html_env.tableborder : "0") + "\"");
	        	if(table0Flg || HTMLC2.table0Flg || HTMLG1.table0Flg || HTMLG2.table0Flg)
	        		html_env.code.append("0" + "\"");	//20130325 table0
	        	else	html_env.code.append(html_env.tableborder + "\"");
//	        	html_env.code.append(html_env.tableborder + "\"");
	        	html_env.code.append(html_env.getOutlineMode());
        	}
        	/*
        if(decos.containsKey("outborder")){
        	html_env.code.append(" noborder ");
        	html_env2.code.append(" noborder ");
        }
        	 */        
        	//classid������Ȥ��ˤ�������
        	if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
        		html_env.code.append(" class=\"");
        		html_env.code.append(HTMLEnv.getClassID(this));
        	}

        	if(decos.containsKey("class")){
        		if(!html_env.written_classid.contains(HTMLEnv.getClassID(this))){
        			html_env.code.append(" class=\"");
        		}else{
        			html_env.code.append(" ");
        		}
        		html_env.code.append(decos.getStr("class")+"\" ");
        	}else if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
        		html_env.code.append("\" ");
        	}
        	//if((!HTMLG1.G1Flg && !tableFlg) || divFlg)		html_env.code.append(">");		//20130326  div	//20130309	
        	if(!HTMLG1.G1Flg && !tableFlg)	html_env.code.append(">");		//20130309

        	if(tableFlg)	html_env.code.append("><TR>");		//20130314  table
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
	        if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
		        html_env2.code.append(" class=\"");
		        html_env2.code.append(HTMLEnv.getClassID(this));
	        }
	        if(decos.containsKey("class")){
	        	if(!html_env.written_classid.contains(HTMLEnv.getClassID(this))){
	    	        html_env2.code.append(" class=\"");
	            }else{
	    	        html_env2.code.append(" ");
	            }
	        	html_env2.code.append(decos.getStr("class")+"\" ");
	        }else if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
	        		html_env2.code.append("\" "); 
	        }
	        
	        if(decos.containsKey("form")){
	        	html_env2.code.append(" form=\""+ HTMLEnv.getFormNumber() +"\" ");
	        }	        
	    	html_env2.code.append(">"); 
        }
        
        //tk end////////////////////////////////////////////////////////////////////
      
      
        //Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\"><TR>");
        
        int i = 0;
        
        if(decos.containsKey("form")){
        	html_env.code.append(HTMLFunction.createForm(decos));
           	HTMLEnv.setFormItemFlg(true,null);
        }
        
        
        while (this.hasMoreItems()) {
            TFE tfe = (TFE) tfes.get(i);
            
            //20130309
            Count = ( ((gridInt>=jj)&&(!HTMLG1.G1Flg))? jj:gridInt );
//            Log.info("☆C1☆"+gridInt+" "+ii+" "+jj+"  "+Count+"  "+Count%5+"	"+HTMLG1.G1Flg+"	"+
//            ((!HTMLC3.C3Flg)?"":HTMLC3.C3Flg));
            Count %= 5;
            //gridInt %= 5;
            //html_env.code.append("\n<div class=\"ui-block-"+gridString[gridInt]+"\">\n");	//20130309
           	//if((!HTMLG1.G1Flg && !tableFlg) || divFlg)		//20130326  div
            if(!HTMLG1.G1Flg && !tableFlg)
            	html_env.code.append("\n<div class=\"ui-block-"+gridString[Count]+" "+HTMLEnv.getClassID(tfe)+"\">\n");	//20130309

            //20130314  table
        	if(tableFlg){
        		html_env.code.append("<TD align=\"center\" valign=\"middle\" class=\""
        				+ HTMLEnv.getClassID(tfe) + " nest\">\n");
        	}
            String classid = HTMLEnv.getClassID(tfe);
            
            //Log.out("<TD class=\""
            //        + HTMLEnv.getClassID(tfe) + " nest\"> decos : " + decos);
//x            html_env.code.append("	<Table border=1 align=center valign=middle text-align=center><tr><td>\n");
            this.worknextItem();
//x            html_env.code.append("	</td></tr></Table>\n");

            //20130309
        	//if((Count>1 && !HTMLG1.G1Flg && !tableFlg) || (Count>1 && divFlg)){		//20130326  div
            if(Count>1 && !HTMLG1.G1Flg && !tableFlg){
//            	String rep="ui-grid-"+gridString[Count-2];
        		String rep="ui-grid-"+gridString[Count-2]+" #"+(HTMLEnv.uiGridCount-1);
        		
            	//Log.info("rep = "+rep+" TO "+"ui-grid-"+gridString[Count-1]+" #"+(HTMLEnv.uiGridCount));
            	try{
	            	html_env.code.replace(
	            			html_env.code.lastIndexOf(rep), 
	            			html_env.code.lastIndexOf(rep)+rep.length(),
	            			"ui-grid-"+gridString[Count-1]+" #"+(HTMLEnv.uiGridCount++));
	            	//Log.info("	C1 !   replaced !!");
//		            Log.info("	C1 !   rep = "+rep+"  TO  ui-grid-"+gridString[Count-1]+"	"+HTMLEnv.uiGridCount+" TO "+(++HTMLEnv.uiGridCount));
            	}catch(Exception e){ /*Log.info("C1 Catch exception.");*/ }
            }
            ii++;
            jj++;
            gridInt++;
            //HTMLEnv.uiGridCount++;
            
            //TODO: 20130309  HTMLEnvで「class="ui-grid-〜#HTMLEnv.uiGridCount"」の「#以下」を削除
            
            //20130309
            //20130314  table
        	if(tableFlg){
	            if (html_env.not_written_classid.contains(classid)){
	            	html_env.code.delete(html_env.code.indexOf(classid),html_env.code.indexOf(classid)+classid.length()+1);
	            }
        	}
            
            if(!HTMLG1.G1Flg && !tableFlg)	html_env.code.append("</div>\n");	//20130309

        	if(tableFlg)	html_env.code.append("</TD>\n");					//20130314  table
            //Log.out("</TD>");

            i++;
        }

        html_env2.code.append("</tfe>");
        if(decos.containsKey("form")){
        	html_env2.code.append("<form"+ HTMLEnv.getFormNumber() +"end />");
        	Log.out("<form"+ HTMLEnv.getFormNumber() +"end />");
           	html_env.code.append(HTMLEnv.exFormNameCreate());
           	html_env.code.append("</form>");
           	HTMLEnv.setFormItemFlg(false,null);
           	HTMLEnv.incrementFormNumber();
           	if(decos.getStr("form").toLowerCase().equals("search"))
        		HTMLEnv.setSearch(false);
        }
        
        //20130309
        if(!HTMLG1.G1Flg && !tableFlg)	html_env.code.append("</DIV>\n");			//20130309
        
        //20130312 collapsible
    	if(decos.containsKey("collapse")){
        	html_env.code.append("</DIv>");
        }
    	
//    	//20130313 header
//    	if(decos.containsKey("head")){
//    		html_env.code.append("</div>\n");
//    	}
        
        jj=0;
        
        //20130314  table
      	if(tableFlg){
      		html_env.code.append("</TR></TABLE>\n");	//20130309
      		tableFlg = false;
      		table0Flg = false;			//20130325 table0
      	}
      	
      	if(divFlg)	divFlg = false;		//20130326  div
      	
        //Log.out("</TR></TABLE>");

        //Log.out("TFEId = " + HTMLEnv.getClassID(this));
        //html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        //↑必要？不要？？ -> 不要
    }

    public String getSymbol() {
        return "HTMLC1";
    }

}