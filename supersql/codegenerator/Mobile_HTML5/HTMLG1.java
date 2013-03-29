package supersql.codegenerator.Mobile_HTML5;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTMLG1 extends Grouper {

    Manager manager;

    HTMLEnv html_env;
    HTMLEnv html_env2;
    
    //20130309
    int gridInt = 0;
    String[] gridString = {"a","b","c","d","e"};
    static int ii =0, jj = 0, Count = 0;
    static boolean G1Flg=false;
    int pic_column = 3;		//1行ごとのカラム数指定 (Default: 3, range: 2〜5)
    
    static boolean tableFlg = false;		//20130314  table
    static boolean table0Flg = false;		//20130325  table0
    static boolean divFlg = false;			//20130326  div

    //���󥹥ȥ饯��
    public HTMLG1(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.manager = manager;
        this.html_env = henv;
        this.html_env2 = henv2;
  
    }

    //G1��work�᥽�å�
    @Override
	public void work(ExtList data_info) {
        Log.out("------- G1 -------");
        this.setDataList(data_info);
        
        //tk start///////////////////////////////////////////////////
        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        
        //20130309
        G1Flg=true;
        
        //20130325  table0
        if(decos.containsKey("table0"))	table0Flg = true;
        else							table0Flg = false;
    	//20130314  table
        //if(decos.containsKey("table") || !decos.containsKey("div") || table0Flg){
        if(decos.containsKey("table") || table0Flg){
    	//if(decos.containsKey("table") || HTMLC1.tableFlg || HTMLC2.tableFlg){
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
//        	//20130205
//        	html_env.code.append("<div id=\"fisheye\" class=\"fisheye\">\n" +
//        			"<div class=\"fisheyeContainter\">\n");
        	

        	//20130312 collapsible
        	if(decos.containsKey("collapse")){
            	html_env.code.append("<DIv data-role=\"collapsible\" data-content-theme=\"c\" style=\"padding: 0px 12px;\">\n");
            	
            	//header
            	if(!decos.getStr("collapse").equals(""))
            		html_env.code.append("	<h1>"+decos.getStr("collapse")+"</h1>\n");
            	else
            		html_env.code.append("<h1>Contents</h1>\n");
            }
//        	else{
            //20130309
//        	//uncommented
        	if(!tableFlg) 	html_env.code.append("	<DIV Class=\"ui-grid-a\">");
        	//html_env.code.append("	<DIV Class=\"ui-grid-a #"+HTMLEnv.uiGridCount+"\"");
            		//HTMLEnv.uiGridCount++;
            		//Log.info("ui-grid-"+HTMLEnv.uiGridCount);
        	
            //1行ごとのカラム数指定 (Default: 3, range: 2〜5)
            //int pic_column = 3;		
            if(decos.containsKey("column") && !tableFlg){
            	//Log.info("column:"+decos.getStr("column").replace("\"", ""));
            	pic_column = Integer.parseInt(decos.getStr("column").replace("\"", ""));
            	if(pic_column<2 || pic_column>5){	//範囲外のとき
            		Log.info("<<Warning>> column指定の範囲は、2〜5です。指定された「column="+pic_column+"」は使用できません。デフォルト値(3)を使用します。");
            		pic_column = 3;
            	}
            }
            
            //20130314  table
            if(tableFlg){
            	//added by goto 20130318  横スクロール
            	html_env.code.append("<div style=\"overflow:auto;\">\n");
            	//html_env.code.append("<div style=\"height:60px; width:0px; overflow:auto;\">\n");
            	
		        html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
		        //html_env.code.append(((!decos.containsKey("table0"))? html_env.tableborder : "0") + "\"");
        		if(table0Flg)	html_env.code.append("0" + "\"");	//20130325 table0
	        	else			html_env.code.append(html_env.tableborder + "\"");
//		        html_env.code.append(html_env.tableborder + "\"");
		        
		        html_env.code.append(" class=\"");
		
		        if(html_env.embedflag)
		        	html_env.code.append("embed ");
		
		        if(decos.containsKey("outborder"))
		        	html_env.code.append(" noborder ");
		        
		        if(decos.containsKey("class")){
		        	//class=menu�Ȃǂ̎w�肪��������t��
		        	html_env.code.append(" class=\"");
		        	html_env.code.append(decos.getStr("class") + " ");
		        }
		        if(html_env.haveClass == 1){
		        	//class=menu�Ȃǂ̎w�肪��������t��
		        	html_env.code.append(" class=\"");
		        	html_env.code.append(HTMLEnv.getClassID(this) + " ");
		        }
		        html_env.code.append("nest\"");
		
		        html_env.code.append(html_env.getOutlineMode());
		
		        html_env.code.append("><TR>");
            }
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
            
            //20130309
//            Count = ( ((gridInt>=jj)&&(!HTMLG1.G1Flg))? jj:gridInt );
            Count = ( ((gridInt>=jj)&&(HTMLG1.G1Flg))? jj:gridInt );
            //Count =  gridInt ;
            //Count =  jj ;
            
//            //20130312 collapsible
//        	if(decos.containsKey("collapse")){
//            	Log.info("★  [],2");
////            	html_env.code.append("	<DIV data-role=\"collapsible\">");
////            	html_env.code.append("	<h1>ヘッダ[],</h1>");
//
//            //20130309
//            //if(Count > 4 && Count%5==0){
//        	}else 
        	if(Count > pic_column-1 && Count%pic_column==0 && !tableFlg){
        		//uncommented
            	html_env.code.append("\n	</DIV>\n	<DIV Class=\"ui-grid-a\">");
        		//html_env.code.append("\n	</DIV>\n	<DIV Class=\"ui-grid-a #"+HTMLEnv.uiGridCount+"\"");
            		//HTMLEnv.uiGridCount++;
            		//Log.info("ui-grid2-"+HTMLEnv.uiGridCount);
            }
            
            //Log.info("★G1★"+gridInt+" "+ii+" "+jj+"  "+Count+"  "+Count%5+"	"+HTMLG1.G1Flg);
//            Count %= 5;
            //Log.info("	☆★"+gridInt+" "+ii+" "+jj+"  "+Count+"  "+Count%pic_column+"	"+HTMLG1.G1Flg);
            Count %= pic_column;
            
            //html_env.code.append("	<div>");
	        //html_env.code.append("	<div class=\"ui-block-a\">");

//            //20130312 collapsible
//        	if(decos.containsKey("collapse")){
//            	Log.info("★  [],3");
//    	        html_env.code.append("	<p>\n");
//        	}else{
        		//20130309
    	    if(!tableFlg)   html_env.code.append("	<div class=\"ui-block-"+gridString[Count]+" "+HTMLEnv.getClassID(tfe)+"\">\n");
    	    //20130314  table
    	    else{
	            html_env.code.append("<TD class=\""
	                    + HTMLEnv.getClassID(tfe) + " nest\">\n");       
    	    }
            String classid = HTMLEnv.getClassID(tfe);
            	
            Log.out("<TD class=\""
                    + HTMLEnv.getClassID(tfe) + " nest\">");

            
            this.worknextItem();
            
            //20130309
            //20130314  table
        	if(tableFlg){
	            if (html_env.not_written_classid.contains(classid)){
	            	html_env.code.delete(html_env.code.indexOf(classid),html_env.code.indexOf(classid)+classid.length()+1);
	            }
        	}
            
            html_env2.code.append("</tfe>");
            
            
//            //20130312 collapsible
//        	if(decos.containsKey("collapse")){
//            	
//            //20130309
////            if(Count>1/* && HTMLG1.G1Flg*/){
//        	}else 
            
        		
            //uncommented
            if(Count>1 && HTMLG1.G1Flg && !tableFlg){
            	String rep="ui-grid-"+gridString[Count-2];
            	
            	try{
	            	html_env.code.replace(
	            			html_env.code.lastIndexOf(rep), 
	            			html_env.code.lastIndexOf(rep)+9,
	            			"ui-grid-"+gridString[Count-1]);
	            	//Log.info("	G1 !!   rep = "+rep+"  TO  ui-grid-"+gridString[Count-1]+"	"+HTMLEnv.uiGridCount+" TO "+(++HTMLEnv.uiGridCount));
            	}catch(Exception e){ /*Log.info("G1 Catch exception.");*/ }
            }
            
//            //cpommented out 失敗作
//            if(Count>1 && HTMLG1.G1Flg){
//        		String rep="ui-grid-"+gridString[Count-2]+" #"+(HTMLEnv.uiGridCount-1);
//        		
//            	Log.info("!!	rep = "+rep+" TO "+"ui-grid-"+gridString[Count-1]+" #"+(HTMLEnv.uiGridCount));
//            	try{
//	            	html_env.code.replace(
//	            			html_env.code.lastIndexOf(rep), 
//	            			html_env.code.lastIndexOf(rep)+rep.length(),
//	            			"ui-grid-"+gridString[Count-1]+" #"+(HTMLEnv.uiGridCount++));
//	            	Log.info("	G1 !!   replaced !!");
//            	}catch(Exception e){ Log.info("G1 Catch exception."); }
//            	
//            }

            ii++;
            jj++;
            gridInt++;
            //HTMLEnv.uiGridCount++;
            

//            //20130312 collapsible
//        	if(decos.containsKey("collapse")){
//            	Log.info("★  [],5");
//    	        html_env.code.append("	</p>\n");
//        	}else{

            if(!tableFlg)	html_env.code.append("	</div>");	//20130309
        	else	        html_env.code.append("</TD>\n");    //20130314 table
        	
            Log.out("</TD>");

            i++;
            html_env.glevel--;
        }
        
        if(HTMLEnv.getFormItemFlg()){		
	        HTMLEnv.incrementFormPartsNumber();
		}

        //html_env2.code.append("</tfe>");
        
        if(!tableFlg)	html_env.code.append("	</DIV>");			//20130309
        else{
        	html_env.code.append("</TR></TABLE>\n");	//20130314  table
        	tableFlg = false;
        	table0Flg = false;		//20130325 table0
        	html_env.code.append("</div>\n");			//added by goto 20130318  横スクロール
        }
        
        if(divFlg)	divFlg = false;		//20130326  div
        
        
        G1Flg=false;
        Log.out("</TR></TABLE>");

        Log.out("TFEId = " + HTMLEnv.getClassID(this));
        //html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

    }

    @Override
	public String getSymbol() {
        return "HTMLG1";
    }

}