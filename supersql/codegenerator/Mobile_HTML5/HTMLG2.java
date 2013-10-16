package supersql.codegenerator.Mobile_HTML5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Vector;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;
import supersql.parser.SSQLparser;

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
    
    //added by goto 20130413  "row Prev/Next"
    int j = 1;
    int row = 1;		//1ページごとの行数指定 (Default: 1, range: 1〜)
    int rowNum = 0;
    static int rowFileNum = 1;
    boolean rowFlg = false;
    StringBuffer codeBuf = new StringBuffer();
    static String tableStartTag = "";

    static String tableDivHeader = "";			//20131001 tableDivHeader
    static String tableDivHeader_codeBuf = "";	//20131001 tableDivHeader
    static int tableDivHeader_Count1 = 0;		//20131001 tableDivHeader
    static int tableDivHeader_Count2 = 0;		//20131001 tableDivHeader
    
//    static int codeCount = 0;	//対策
//    static StringBuffer[] codeArray = new StringBuffer[100];	//対策
//    
//	static String parentfile = null;
//    static String parentnextbackfile = null;
//    static StringBuffer parentcode = null;
//    static StringBuffer parentcss = null;
//    static StringBuffer parentheader = null;
//    static StringBuffer parentfooter = null;
    

    //���󥹥ȥ饯��
    public HTMLG2(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.manager = manager;
        this.html_env = henv;
        this.html_env2 = henv2;

    }

    //G2��work�᥽�å�
    @Override
	public void work(ExtList data_info) {
    	//20131001 tableDivHeader
    	HTMLG2.tableDivHeader = "";	
    	HTMLG2.tableDivHeader_codeBuf = "";
    	HTMLG2.tableDivHeader_Count1 = 0;
    	HTMLG2.tableDivHeader_Count2 = 0;
    	
        //G2Flg = true;
        int panelFlg = 0;	//20130503  Panel
    	
    	//added by goto 20130413  "row Prev/Next"
    	//1ページごとの行数指定 (Default: 1, range: 1〜)
    	String parentfile = null;
        String parentnextbackfile = null;
        StringBuffer parentcode = null;
        StringBuffer parentcss = null;
        StringBuffer parentheader = null;
        StringBuffer parentfooter = null;
        if(decos.containsKey("row")){
        	row = Integer.parseInt(decos.getStr("row").replace("\"", ""));
        	if(row<1){	//範囲外のとき
        		Log.err("<<Warning>> row指定の範囲は、1〜です。指定された「row="+row+"」は使用できません。");
        	}else{
            	parentfile = html_env.filename;
                parentnextbackfile = html_env.nextbackfile;
                parentcode = html_env.code;
                parentcss = html_env.css;
                parentheader = html_env.header;
                parentfooter = html_env.footer;
    	        html_env.css = new StringBuffer();
    	        html_env.header = new StringBuffer();
    	        html_env.footer = new StringBuffer();
//            	//decos.remove("row");	//対策
            	rowFlg = true;
        	}
        }

//        Vector vector_local = new Vector();
 
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
//        if(decos.containsKey("table") || table0Flg){
        if(decos.containsKey("table") || table0Flg || HTMLC1.tableFlg || HTMLC2.tableFlg || HTMLG1.tableFlg){
    		tableFlg = true;
    	}//else	tableFlg = false;
        
        //20130326  div
   		//if(decos.containsKey("div") || HTMLC1.divFlg || HTMLC2.divFlg || HTMLG1.divFlg || HTMLG2.divFlg){
        if(decos.containsKey("div")){
    		divFlg = true;
    		tableFlg = false;
    	}//else divFlg = false;
        
        //20130529
        if(decos.containsKey("dynamic")){
        	if(!HTMLEnv.dynamicFlg)	HTMLEnv.staticBuf = html_env.code;
        	HTMLEnv.dynamicFlg = true;
        	Log.i("※G2 HTMLEnv.staticBuf: "+HTMLEnv.staticBuf);
        }
        
        //20130914  "text"
//      	Log.e("	decosC2 = "+decos);
        if(decos.containsKey("text")){
//        	Log.e("	G2 in!");
        	HTMLFunction.textFlg2 = true;
        }
        
        if(!GlobalEnv.isOpt()){
        	//20130503  Panel
    	    panelFlg = HTMLC1.panelProcess1(decos, html_env);
        	
        	//20130330 tab
        	//tab1
        	if(decos.containsKey("tab1")){
            	html_env.code.append("<div data-role=\"content\"> <div id=\"tabs\">\n<ul>\n");
            	html_env.code.append("	<li><a href=\"#tabs-"+HTMLEnv.tabCount+"\">");
            	if(!decos.getStr("tab1").equals(""))	html_env.code.append(decos.getStr("tab1"));
            	else          							html_env.code.append("tab1");
            	html_env.code.append("</a></li>\n");
            	html_env.code.append("</ul>\n<div id=\"tabs-"+HTMLEnv.tabCount+"\">\n");
//            	HTMLEnv.tabFlg = true;
            }
        	//tab2〜tab15
//        	else if(HTMLEnv.tabFlg){
        	else{
        		int i=2;
        		while(i<=HTMLEnv.maxTab){		//HTMLEnv.maxTab=15
        			//Log.info("i="+i+" !!");
        			if(decos.containsKey("tab"+i) || (i==2 && decos.containsKey("tab"))){
    	        		//replace: </ul>の前に<li>〜</li>を付加
    	        		String a = "</ul>";
    	        		String b = "	<li><a href=\"#tabs-"+HTMLEnv.tabCount+"\">";
    	        		if(decos.containsKey("tab"+i))
	    	        		if(!decos.getStr("tab"+i).equals(""))	b += decos.getStr("tab"+i);
	    	            	else				            		b += "tab"+i;
    	        		else
    	        			if(!decos.getStr("tab").equals(""))		b += decos.getStr("tab");
	    	            	else				            		b += "tab";
    	            	b += "</a></li>\n";
    	            	HTMLManager.replaceCode(html_env, a, b+a);
    	            	
    	            	//replace: 最後の</div></div></div>カット
    	        		HTMLManager.replaceCode(html_env, "</div></div></div>", "");
    	        		
    	        		//replace: 不要な「<div class=〜」をカット
    	        		HTMLManager.replaceCode(html_env, "<div class=\""+HTMLEnv.getClassID(this)+" \">", "");
    	        		
    	            	html_env.code.append("<div id=\"tabs-"+HTMLEnv.tabCount+"\">\n");
    	            	break;
    	        	}
        			i++;
//        			if(i>HTMLEnv.maxTab)	HTMLEnv.tabFlg =false;
        		}
        	}
        	
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
        	//20130314  table
        	if(tableFlg){
        		if(row>1 && tableFlg)	HTMLG2.tableStartTag = HTMLC1.getTableStartTag(html_env, decos, this);
            	else					html_env.code.append(HTMLC1.getTableStartTag(html_env, decos, this)+"\n");
        	}
        }
        //tk end/////////////////////////////////////////////////////
//        Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\">");

        //html_env2.code.append("<tfe type=\"connect\" dimension=\"2\" >");
        int i = 0;
        while (this.hasMoreItems()) {
        	//[重要] For [ [], ]!        	
        	HTMLG1.jj = 0;
        	HTMLG1.gridInt = 0;
        	
            if(decos.containsKey("table0") || HTMLC1.table0Flg || HTMLC2.table0Flg || HTMLG1.table0Flg)	table0Flg = true;
            if(decos.containsKey("table") || HTMLC1.tableFlg || HTMLC2.tableFlg || HTMLG1.tableFlg || table0Flg)	tableFlg=true;
            //if(decos.containsKey("div") || HTMLC1.divFlg || HTMLC2.divFlg || HTMLG1.divFlg || HTMLG2.divFlg){
        	if(decos.containsKey("div")){
        		divFlg = true;
        		tableFlg = false;
        	}
        	
            html_env.glevel++;
            
            //added by goto 20130413  "row Prev/Next"
            if(rowFlg){
            	html_env.code = new StringBuffer();
                html_env.countfile++;
                html_env.filename = html_env.outfile + "_row" + rowFileNum + "_" + j + ".html";
                html_env.nextbackfile = html_env.linkoutfile + "_row" + rowFileNum + "_" + j + ".html";
                html_env.setOutlineMode();
            }
            
            Log.out("selectFlg"+HTMLEnv.getSelectFlg());
            Log.out("selectRepeatFlg"+HTMLEnv.getSelectRepeat());
            Log.out("formItemFlg"+HTMLEnv.getFormItemFlg());
            if( HTMLEnv.getSelectRepeat() ){//if form_select
            		//null
            		//in case "select" repeat : not write "<TR><TD>" between "<option>"s
            }else{
                //20130312 collapsible
    	      	if(decos.containsKey("collapse"))
    	          	html_env.code.append("<p>\n");
            	
            	//20130309
            	//gridInt %= 5;
            	//html_env.code.append("\n	<div class=\"ui-block-"+gridString[gridInt]+"\">\n");
            	if(!tableFlg)	html_env.code.append("\n	<div class=\""+HTMLEnv.getClassID(tfe)+" \">\n");	//20130309  div
                //20130314  table
            	else{
		            html_env.code.append("<TR><TD class=\"" + HTMLEnv.getClassID(tfe) + " nest\">\n");
            	}
	            Log.out("<TR><TD class=\"" + HTMLEnv.getClassID(tfe) + " nest\">");
            }
            String classid = HTMLEnv.getClassID(tfe);

            
//            //おそらくxml
//            if(GlobalEnv.isOpt() && !HTMLEnv.getSelectRepeat()){
//	            html_env2.code.append("<tfe type=\"repeat\" dimension=\"2\"");
//	            html_env2.code.append(" border=\"" + html_env.tableborder + "\"");
//	
//	            if (decos.containsKey("tablealign") )
//	            	html_env2.code.append(" align=\"" + decos.getStr("tablealign") +"\"");
//	            if (decos.containsKey("tablevalign") )
//	            	html_env2.code.append(" valign=\"" + decos.getStr("tablevalign") +"\"");
//	            
//
//	            if(decos.containsKey("class")){
//		        	//class=menu�Ȃǂ̎w�肪��������t��
//	            	html_env2.code.append(" class=\"");
//		        	html_env2.code.append(decos.getStr("class") + " ");
//		        }
//	            if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
//		        	//TFE10000�Ȃǂ̎w�肪��������t��
//	            	if(decos.containsKey("class")){
//	            		html_env2.code.append(HTMLEnv.getClassID(this) + "\"");
//	            	}else{
//	            		html_env2.code.append(" class=\""
//	            				+ HTMLEnv.getClassID(this) + "\"");
//	            	}
//	            }else if(decos.containsKey("class")){
//	            	html_env2.code.append("\"");
//	            }
//	            
//	            if(decos.containsKey("tabletype")){
//	            	html_env2.code.append(" tabletype=\"" + decos.getStr("tabletype") + "\"");
//	            	if(decos.containsKey("cellspacing")){
//	                	html_env2.code.append(" cellspacing=\"" + decos.getStr("cellspacing") + "\"");
//	                }
//	            	if(decos.containsKey("cellpadding")){
//	                	html_env2.code.append(" cellpadding=\"" + decos.getStr("cellpadding") + "\"");
//	                }
//	            }
//	            html_env2.code.append(">");
//            }
            
    	    //Log.info("tfeG2 : " + tfe);
            //Log.info("tfe : " + this.tfes);
            //Log.info("tfe : " + this.tfeItems);

            
	      	if(HTMLEnv.dynamicFlg){	//20130529 dynamic
	      		//☆★
	      		Log.info("★★G2-1 tfe : " + tfe);
	    		//☆★            Log.info("G2 tfe : " + tfe);
	            //☆★            Log.info("G2 tfes : " + this.tfes);
	            //☆★            Log.info("G2 tfeItems : " + this.tfeItems);
	      	}

            this.worknextItem();
            if(decos.containsKey("table0") || HTMLC1.table0Flg || HTMLC2.table0Flg || HTMLG1.table0Flg)	table0Flg = true;
            if(decos.containsKey("table") || HTMLC1.tableFlg || HTMLC2.tableFlg || HTMLG1.tableFlg || table0Flg)	tableFlg=true;
            //if(decos.containsKey("div") || HTMLC1.divFlg || HTMLC2.divFlg || HTMLG1.divFlg || HTMLG2.divFlg){
        	if(decos.containsKey("div")){
        		divFlg = true;
        		tableFlg = false;
        	}
        	
            //20130529
            if(decos.containsKey("dynamic"))	HTMLEnv.dynamicFlg = true;
            
            
            if(HTMLEnv.dynamicFlg){	//20130529 dynamic
	      		//☆★
	      		Log.info("★★G2-2 tfe : " + tfe);
	    		//☆★            Log.info("G2 tfe : " + tfe);
	            //☆★            Log.info("G2 tfes : " + this.tfes);
	            //☆★            Log.info("G2 tfeItems : " + this.tfeItems);
	      	}
            
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
//                if(!tableFlg)	html_env.code.append("	</div>\n");		//20130309  div
                if(!tableFlg){
                	if(!HTMLFunction.textFlg2){
                		html_env.code.append("	</div>\n");		//20130309  div	//20130914  "text"
                	}
                }else	html_env.code.append("</TD></TR>\n");			//20130314  table
                Log.out("</TD></TR>");
//                if(HTMLFunction.textFlg){					//20130914  "text"
//    	      		Log.e("G2 text!");
//    	      		html_env.code.append(HTMLFunction.text);
//    	      		HTMLFunction.text = "";
//    	      		HTMLFunction.textFlg = false;
//    	      	}
                
                //20130312 collapsible
    	      	if(decos.containsKey("collapse"))
    	          	html_env.code.append("</p>\n");
            }
            
            
            i++;
            html_env.glevel--;
            
            HTMLG2.tableDivHeader_Count1++;	//20131001 tableDivHeader
            
            //added by goto 20130413  "row Prev/Next"
            if(rowFlg){
            	codeBuf.append(html_env.code);
            	if((rowNum+1)%row==0){
	                createHTMLfile_ForPrevNext(html_env, codeBuf);
	                j++;
	                codeBuf = new StringBuffer();
                }
                rowNum++;
            }
        }	// /while
        
////        Log.e("HTMLG2.tableDivHeader_codeBuf = \n"+HTMLG2.tableDivHeader_codeBuf);	//20131001 tableDivHeader
////        Log.i("\nHTMLG2.tableDivHeader = \n"+HTMLG2.tableDivHeader);	//20131001 tableDivHeader
//        Log.i("\n==============================\n");	//20131001 tableDivHeader
////        Log.i("\nHTMLG2.tableDivHeader = \n"+HTMLG2.tableDivHeader.replace(HTMLG2.tableDivHeader_codeBuf, ""));	//20131001 tableDivHeader
//        if(!HTMLG2.tableDivHeader.equals("")){
////        	HTMLG2.tableDivHeader = HTMLG2.tableDivHeader.replace(HTMLG2.tableDivHeader_codeBuf, "");//20131001 tableDivHeader
//        	Log.i(HTMLG2.tableDivHeader);	//20131001 tableDivHeader
//        }
//        Log.i("\n==============================\n");	//20131001 tableDivHeader
        
        
        //added by goto 20130413  "row Prev/Next"
        if(rowFlg){
        	if(rowNum%row!=0){	//最後の child HTML を create
	            createHTMLfile_ForPrevNext(html_env, codeBuf);
        	}
        	//ファイル名・コード等をparent HTMLのものへ戻す
        	html_env.filename = parentfile;
        	html_env.code = parentcode;
            html_env.css = parentcss;
            html_env.header = parentheader;
            html_env.footer = parentfooter;
            html_env.nextbackfile = parentnextbackfile;
            Log.out("TFEId = " + HTMLEnv.getClassID(this));
            html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

            int first = 1, last = ((rowNum%row!=0)? (rowNum/row+1):(rowNum/row));
            PrevNextProcess(html_env, rowNum, row, first, last, 1);
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
        	if(!(row>1 && tableFlg))	html_env.code.append("</TABLE>\n");		//20130309
        	tableFlg = false;
        	table0Flg = false;		//20130325 table0
        }
        Log.out("</TABLE>");
        
        //20130312 collapsible
      	if(decos.containsKey("collapse")){
          	html_env.code.append("</DIv>");
        }
      	
    	//20130330 tab
//    	if(HTMLEnv.tabFlg){
    		int a=1;
	    	while(a<=HTMLEnv.maxTab){
	    		//Log.info("a="+a);
	    		if(decos.containsKey("tab"+a) || (a==1 && decos.containsKey("tab"))){
		    		html_env.code.append("</div></div></div>\n");
		    		HTMLEnv.tabCount++;
		    		break;
		    	}
		    	a++;
	    	}
//    	}
	    	
    	//20130503  Panel
    	HTMLC1.panelProcess2(decos, html_env, panelFlg);
        
        if(divFlg)	divFlg = false;		//20130326  div
        
        if(HTMLEnv.dynamicFlg)	HTMLEnv.dynamicFlg = false;		//20130529 dynamic

        //added by goto 20130413  "row Prev/Next"
        if(rowFlg){
        	rowFileNum++;
        	rowFlg = false;
        	tableStartTag = "";
        }
        
        //20130914  "text"
        if(HTMLFunction.textFlg2){
        	HTMLFunction.textFlg2 = false;
        }
        
        //added by goto 20130914  "SEQ_NUM"
        HTMLFunction.Func_seq_num_initialization();
        
        Log.out("TFEId = " + HTMLEnv.getClassID(this));
        //html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        //G2Flg = false;
    }
    
    //added by goto 20130413  "row Prev/Next"
    public static void createHTMLfile_ForPrevNext(HTMLEnv html_env, StringBuffer codeBuf){
    	html_env.getHeader(2);
        html_env.getFooter(2);
        //Log.info(html_env.filename);
    	
        try {
    		PrintWriter pw;
            if (html_env.charset != null)
	        	pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
	        			new FileOutputStream(html_env.filename),html_env.charset)));
            else
            	pw = new PrintWriter(new BufferedWriter(new FileWriter(
        	                    html_env.filename)));
//            //added by goto 20130508  "Login&Logout"
//            //Logputボタンをカット
//            if(SSQLparser.sessionFlag){
//            	int x = html_env.header.indexOf("<!-- Logout start -->");
//            	int y = html_env.header.lastIndexOf("<!-- Logout end -->");
//            	pw.println(html_env.header.delete(x,y));
//            }else	pw.println(html_env.header);
        	pw.println(html_env.header);
        	pw.println(HTMLG2.tableDivHeader);	//20131001 tableDivHeader
        	if(!tableStartTag.equals("")){
        		pw.println(tableStartTag+"\n"+codeBuf);
        		if(tableStartTag.endsWith("<TR>"))	pw.println("</TR>");
        		pw.println("</TABLE>\n");
        	}else{
        		pw.println(codeBuf);
        	}
//            //delete: 最後の<BR><BR>カット
//            int a = html_env.footer.lastIndexOf("<BR><BR>");
//            int b = a+"<BR><BR>".length();
//            //Log.info(html_env.footer.delete(html_env.footer.indexOf("<BR><BR>"),html_env.footer.lastIndexOf("<BR><BR>")));
//            //Log.info(html_env.footer.delete(a,b));
//            try { pw.println(html_env.footer.delete(a,b)); } catch (Exception e) { }
            pw.println(html_env.footer);
            pw.close();
            html_env.header = new StringBuffer();
            html_env.footer = new StringBuffer();
        } catch (Exception e) { }
    }
    
    //added by goto 20130413  "row Prev/Next"
    public static void PrevNextProcess(HTMLEnv html_env, int rowNum, int row, int first, int last, int column){
        //parent HTMLへ<iframe>等を埋め込む
        String divID="rowDiv"+rowFileNum+"-";
        String iframeName ="rowIframe"+rowFileNum;
        String HTMLfilename=html_env.filename.substring(0,html_env.filename.indexOf(".html"));
		//added by goto 20130417 start
		//HTMLfilenameを絶対パスから「相対パス形式」へ変更
		String fileDir = new File(HTMLfilename).getAbsoluteFile().getParent();
		if(fileDir.length() < HTMLfilename.length()
		&& fileDir.equals(HTMLfilename.substring(0,fileDir.length()))){
			HTMLfilename = HTMLfilename.substring(fileDir.length()+1);
		}
		//added by goto 20130417 end
        HTMLfilename = HTMLfilename+"_row"+rowFileNum+"_";
        html_env.code.append(
        		"	<script type=\"text/javascript\">\n" +
        		"		$(document).ready(function(){\n" +
        		"			rowIframePrevNext("+first+", "+last+", '"+divID+"', '"+iframeName+"', '"+HTMLfilename+"', '"+row+"', '"+rowNum+"', '"+column+"');\n" +
        		"		});\n" +
        		"	</script>\n" +
        		"	<hr>\n" +
        		"	<div id=\""+divID+"1\"></div>\n" +
        		"	<hr>\n" +
        		"	<iframe src=\""+HTMLfilename+"1.html\" id=\"rowIframeAutoHeight"+rowFileNum+"\" name=\""+iframeName+"\" style=\"border:0; width:90%; overflow:hidden;\">\n" +
        		"	</iframe>\n" +
        		"	<script type=\"text/javascript\">\n" +
        		"	    $('#rowIframeAutoHeight"+rowFileNum+"').iframeAutoHeight();\n" +
//        		"	    jQuery('#iframe_autoheight"+rowFileNum+"').iframeAutoHeight();\n" +
//        		"	    jQuery('[id=iframe_autoheight"+rowFileNum+"]').iframeAutoHeight();\n" +
        		"	</script>\n" +
        		"	<hr>\n" +
        		"	<div id=\""+divID+"2\"></div>\n" +
        		"	<hr>\n");
    }
    
    //20131001 tableDivHeader
    //for C1, C2
    public static StringBuffer createAndCutTableDivHeader(HTMLEnv html_env) {
//    	if(HTMLG2.tableDivHeader_Count1==1){
		if(HTMLG2.tableDivHeader_Count1<1){
    		//create tableDivHeader
      		HTMLG2.tableDivHeader = html_env.code.toString().replace(HTMLG2.tableDivHeader_codeBuf, "");
//      		HTMLG2.tableDivHeader = "<div>"+html_env.code.toString().replace(HTMLG2.tableDivHeader_codeBuf, "");
    	}
//    	if(HTMLG2.tableDivHeader_Count1>1){
    	//Log.e("a="+html_env.code);
    	//Log.e("b="+HTMLG2.tableDivHeader_codeBuf);
    	//cut tableDivHeader
  		return new StringBuffer(html_env.code.replace(HTMLG2.tableDivHeader_codeBuf.length(), 
  				html_env.code.length(), ""));
//    	}
//  		return new StringBuffer(html_env.code.toString());
    }

    @Override
	public String getSymbol() {
        return "HTMLG2";
    }

}