package supersql.codegenerator.Mobile_HTML5;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import supersql.codegenerator.CodeGenerator;
import supersql.codegenerator.DecorateList;
import supersql.codegenerator.FuncArg;
import supersql.codegenerator.Function;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.dataconstructor.DataConstructor;
import supersql.extendclass.ExtList;
import supersql.parser.SSQLparser;
//tk start///////////////////////////////////////

//tk end//////////////////////////////////////////

//import common.Log;

public class HTMLFunction extends Function {

    Manager manager;

    HTMLEnv html_env;
    HTMLEnv html_env2;

    boolean embedflag = false;

    static boolean slideshowFlg = false;	//added by goto 20130110
    int slideshowNum = 0;					//added by goto 20130110
    
    static int popCount = 1;	//added by goto 20130313  "popup"
    
    static String updateFile;

    public HTMLFunction()
    {

    }
    //���󥹥ȥ饯��
    public HTMLFunction(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        super();
        this.manager = manager;
        this.html_env = henv;
        this.html_env2 = henv2;
    }

    //Function��work�᥽�å�
    public void work(ExtList data_info) {
        this.setDataList(data_info);
        //    	Log.out("FuncName= " + this.getFuncName());
        //    	Log.out("filename= " + this.getAtt("filename"));
        //    	Log.out("condition= " + this.getAtt("condition"));

        String FuncName = this.getFuncName();

        if (FuncName.equalsIgnoreCase("imagefile")) {
            Func_imagefile();
        } else if (FuncName.equalsIgnoreCase("invoke")) {
            Func_invoke();
        } else if (FuncName.equalsIgnoreCase("foreach")) {
            try {
				Func_foreach(data_info);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
        } else if (FuncName.equalsIgnoreCase("sinvoke") || FuncName.equalsIgnoreCase("link")) {
            Func_sinvoke(data_info);
        } else if (FuncName.equalsIgnoreCase("null")) {
            Func_null();
        }
        //added by goto 20121217
        else if(FuncName.equalsIgnoreCase("button")){
        	Func_button();
        }
        //added by goto 20130308  "urlリンク"
        else if(FuncName.equalsIgnoreCase("url") || FuncName.equalsIgnoreCase("anchor") || FuncName.equalsIgnoreCase("a")){
        	Func_url(false);
        }
        //added by goto 20130417  "mail"
        else if(FuncName.equalsIgnoreCase("mail")){
        	Func_url(true);
        }
        //added by goto 20130312  "line"
        else if(FuncName.equalsIgnoreCase("line")){
        	Func_line();
        }
        //added by goto 20130325  "dline"
        else if(FuncName.equalsIgnoreCase("dline")){
        	Func_dline();
        }
        //added by goto 20130313  "header"
        else if(FuncName.equalsIgnoreCase("header")){
        	Func_header();
        }
        //added by goto 20130313  "footer"
        else if(FuncName.equalsIgnoreCase("footer")){
        	Func_footer();
        }
        //added by goto 20130313  "popup"
        else if(FuncName.equalsIgnoreCase("pop") || FuncName.equalsIgnoreCase("popup")){
        	Func_pop();
        }
        //chie
        else if (FuncName.equalsIgnoreCase("submit")) {
            Func_submit();
        }
        else if (FuncName.equalsIgnoreCase("select")) {
            Func_select();
        }
        else if (FuncName.equalsIgnoreCase("checkbox")) {
            Func_checkbox();
        }
        else if (FuncName.equalsIgnoreCase("radio")) {
            Func_radio();
        }
        else if (FuncName.equalsIgnoreCase("inputtext")) {
            Func_inputtext();
        }
        else if (FuncName.equalsIgnoreCase("textarea")) {
            Func_textarea();
        }
        else if (FuncName.equalsIgnoreCase("hidden")) {
            Func_hidden();
        }
        else if (FuncName.equalsIgnoreCase("session")) {
            //Func_session(); not use
        }
        //tk start//////////////////////////////////
        else if (FuncName.equalsIgnoreCase("embed")) {
        	Log.out("[enter embed]");
        	Func_embed(data_info);
        }
        //tk end////////////////////////////////////

        Log.out("TFEId = " + HTMLEnv.getClassID(this));
        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

    }

    private void Func_imagefile() {

        /*
         * ImageFile function : <td> <img src="${imgpath}/"+att /> </td>
         */

        String path = this.getAtt("path", ".");
        if (!path.startsWith("/")) {
            String basedir = GlobalEnv.getBaseDir();
            if (basedir != null && basedir != "") {
                path = GlobalEnv.getBaseDir() + "/" + path;
            }
        }
        if(GlobalEnv.isServlet()){
        	path = GlobalEnv.getFileDirectory() + path;
        }
    	//System.out.println(GlobalEnv.isServlet());

        //added by goto 20130110 start
        String type = this.getAtt("type", ".");
        //System.out.println("type="+type);
        //if(type.matches("\\."))	type=null;

        //added by goto 20130110 end

        //tk to make hyper link to image//////////////////////////////////////////////////////////////////////////////////
        if (html_env.link_flag > 0 || html_env.sinvoke_flag) {
			//added by goto 20121222 start
        	//以下は、-fのファイル名指定が絶対パスになっている場合の処理(?)
			//[%連結子] hrefの指定を絶対パスから「相対パス形式」へ変更
			//20120622の修正だと、「-f フルパスファイル名」を用いている場合、相対パス形式にならない
			String fileDir = new File(html_env.linkurl).getAbsoluteFile().getParent();
			
			if(fileDir.length() < html_env.linkurl.length()
			&& fileDir.equals(html_env.linkurl.substring(0,fileDir.length()))){
				String relative_path = html_env.linkurl.substring(fileDir.length()+1);
				html_env.code.append("<A href=\"" + relative_path + "\" ");
			}else
				html_env.code.append("<A href=\"" + html_env.linkurl + "\" ");
			
            //html_env.code.append("<A href=\"" + html_env.linkurl + "\" ");
			//added by goto 20121222 end
			
	        //added by goto 20121217 start
	        //画面遷移アニメーション (data-transition)
			//for 'hyperlink of image file'
			//transition = fade, slide, pop, slideup, slidedown, flip
	        if (decos.containsKey("transition")){
	            html_env.code.append("data-transition=\"" + decos.getStr("transition") + "\" ");
	            //System.out.println(decos.getStr("transition"));
	        }
	        //added by goto 20121217 end
	        
        	
            if(decos.containsKey("target"))
            	html_env.code.append(" target=\"" + decos.getStr("target")+"\" ");
            if(decos.containsKey("class"))
            	html_env.code.append(" class=\"" + decos.getStr("class") + "\" ");
            html_env.code.append(">\n");

            Log.out("<A href=\"" + html_env.linkurl + "\">");
        }
        //tk/////////////////////////////////////////////////////////////////////////////////

        if(decos.containsKey("lightbox"))
        {
    		Date d1 = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
    		String today = sdf.format(d1);

        	html_env.code.append("<a href=\"" + path+"/" + this.getAtt("default")
        			+"\" rel=\"lightbox[lb"+today+"]\">");

        	if(decos.getStr("lightbox").compareTo("root") == 0 || decos.getStr("lightbox").compareTo("thumb") == 0)
        	{
            	html_env.code.append("<img class=\"" + HTMLEnv.getClassID(this) +" ");

                if(decos.containsKey("class"))
                	html_env.code.append(decos.getStr("class"));

                html_env.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\" onLoad=\"initLightbox()\"/>");

        	}
        	html_env.code.append("</a>");
        }
        else{
        	//added by goto 20121217 start
        	//html_env.code.append("<img class=\"" + HTMLEnv.getClassID(this) +" ");
        	if(type.matches(".") || type.matches("normal")){					//type==null
        		//20130206
        		//defaultは下記の1行のみ
        		//html_env.code.append("<img class=\"" + HTMLEnv.getClassID(this) +" ");
        		
//        		//20130206
        		if (decos.containsKey("effect") && decos.getStr("effect").matches("bound")){
	                //String display_type = decos.getStr("display-type");//.replace("\"", "") +"\" " );
	                //this.getAtt("display-type", "null");
	                Log.info("bound!");
	                //System.out.println("type="+type);
	                html_env.code.append("<div id=\"bounce\" class=\"ui-widget-content ui-corner-all\">" +
	                		"<img class=\"" + HTMLEnv.getClassID(this) +" ");
        		}else{
                	html_env.code.append("<img class=\"" + HTMLEnv.getClassID(this) +" ");
                }
        		
    	        //added by goto 20130312  "Default width: 100%"
    	        if(!decos.containsKey("width")){
            		html_env.code.append("\" width=\"100% " );
    	        }
        		
//        		//20130205
//        		if (decos.containsKey("display-type") && decos.getStr("display-type").matches("fisheye")){
//	                //String display_type = decos.getStr("display-type");//.replace("\"", "") +"\" " );
//	                //this.getAtt("display-type", "null");
//	                Log.info("fisheye!");
//	                //System.out.println("type="+type);
//	                html_env.code.append("<div id=\"fisheye\" class=\"fisheye\">\n" +
//        			"<div class=\"fisheyeContainter\">" +
//	                		"<a href=\"#\" class=\"fisheyeItem\"><img class=\"" + HTMLEnv.getClassID(this) +" ");
//        		}else{
//               // if(display_type.matches("null") || !display_type.matches("fisheye")){	//display_type=null;
//                	html_env.code.append("<img class=\"" + HTMLEnv.getClassID(this) +" ");
//                }
        	}
//        	else if(type=="slideshow"){	//type==slideshow
//        		html_env.code.append("<a href="
//        		
//        		
//        	}
        	
        	html_env2.code.append("<VALUE type=\"img\" class=\"" + HTMLEnv.getClassID(this) +" ");
        	if(decos.containsKey("class"))
        		html_env.code.append(decos.getStr("class"));

            //System.out.println("out:path:"+this.getAtt("default"));
        	
        	//added by goto 20121217 start
        	//html_env.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\"/>");
        	if(type.matches(".") || type.matches("normal")){					//type==null
        		html_env.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\"/>");
        		
        		//20130206
        		if (decos.containsKey("effect") && decos.getStr("effect").matches("bound"))
            		html_env.code.append("</div>");
            		
        		
//        		//20130205
//        		html_env.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\"/>" +
//        				"<span>"+this.getAtt("default")+"</span></a></div></div>");
        	}else if(type.matches("slideshow")){	//type==slideshow
        		//System.out.println("slideshowFlg="+slideshowFlg+"  lio="+html_env.code.lastIndexOf("</TD"));
        		//tableタグの削除
        		if(slideshowFlg!=true){
        			//html_env.code.substring(0,html_env.code.lastIndexOf("<TABLE"));
        			html_env.code.append("<div data-role=\"page\" data-add-back-btn=\"true\" id=\"p-gallery\">\n");
        			html_env.code.append("<ul id=\"Gallery\" class=\"gallery\">\n");
        			slideshowFlg=true;
        		}else
        			//html_env.code.delete(html_env.code.lastIndexOf("</TD>"),html_env.code.length());
        			html_env.code.delete(html_env.code.lastIndexOf("</ul>"),html_env.code.length());
        		
        		slideshowNum++;
        		
        		//column : 列数(<li>のwidthで指定)
                String column = this.getAtt("column", "null");
                if(column.matches("null")){	//column==null
                	column = "3";			//default
                }
//        		Log.info(column);
    			int li_width = 100/Integer.parseInt(column);
        		html_env.code.append(
        				"<li style=\"width:"+li_width+"%;\"><a href=\""+path+"/"+this.getAtt("default")+"\" rel=\"external\">" +
        				"<img src=\"" + path + "/" + this.getAtt("default") + "\" class=\"" + HTMLEnv.getClassID(this) +"\" alt=\""+slideshowNum+"\" /></a></li>\n");
        		
//        		//column : 列数(<li>のwidthで指定)
//                String column = this.getAtt("column", ".");
//                if(type.matches(".")){	//column==null
//            		html_env.code.append(
//            				"<li><a href=\""+path+"/"+this.getAtt("default")+"\" rel=\"external\">" +
//            				//"<li><a href=\""+path+"/"+this.getAtt("default")+"\" class=\"" + HTMLEnv.getClassID(this) +"\" rel=\"external\">" +
//            				//"<img src=\"" + path + "/" + this.getAtt("default") + "\" alt=\""+slideshowNum+"\" /></a></li>\n");
//            				//"<img src=\"" + path + "/" + this.getAtt("default") + "\" alt=\""+slideshowNum+"\" /></a></li>\n");
//            				//"<img src=\"" + path + "/" + this.getAtt("default") + "\" height=100 alt=\""+slideshowNum+"\" /></a></li>\n");
//            				"<img src=\"" + path + "/" + this.getAtt("default") + "\" class=\"" + HTMLEnv.getClassID(this) +"\" alt=\""+slideshowNum+"\" /></a></li>\n");
//            				//"<img src=\"" + path + "/" + this.getAtt("default") + "\" /*alt=\"num\"*/ />");
//        		}else{
//        			Log.info(column);
//        			int li_width = 100/Integer.parseInt(column);
//	        		html_env.code.append(
//	        				"<li style=\"width:"+li_width+"%;\"><a href=\""+path+"/"+this.getAtt("default")+"\" rel=\"external\">" +
//	        				"<img src=\"" + path + "/" + this.getAtt("default") + "\" class=\"" + HTMLEnv.getClassID(this) +"\" alt=\""+slideshowNum+"\" /></a></li>\n");
//        		}
        	}
        	html_env2.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\" ");
        	if(decos.containsKey("width")){
        		html_env2.code.append("width=\"" + decos.getStr("width").replace("\"", "")+"\" " );
        	}
        	if(decos.containsKey("height")){
        		html_env2.code.append("height=\"" + decos.getStr("height").replace("\"", "") +"\" " );
        	}
        	html_env2.code.append(" ></VALUE>");
        }
        //tk  to make hyper link to image///////////////////////////////////////////////////////////////////////////////////
        if (html_env.link_flag > 0 || html_env.sinvoke_flag) {
        	html_env.code.append("</a>");
        }
        //tk///////////////////////////////////////////////////////////////////////////////////
        return;
    }

    //added by goto 20121217 start 		    // for practice 2012/02/09 を改良
    private void Func_button() {
    	String statement = "";
//    	Hashtable ArgHash = new Hashtable();
//    	String button_media = this.getArgs().get(0).toString();
////    	String button_media = this.getAtt("bname");
//    	FuncArg fa = (FuncArg) this.getArgs().get(0);		//ArgHash.get("bname");
////    	System.out.println("button_media: "+button_media.getStr());
//    	System.out.println("fa.getStr(): "+fa.getStr());
    	FuncArg fa = (FuncArg) this.getArgs().get(0);
    	String button_media = fa.getStr();
    	//System.out.println("button_media: "+button_media);

    	if (button_media.equals("back")){				//ex. button("back")
    		// 戻るボタンの生成
			statement = "<input type=\"button\" onClick='history.back();' value=\"戻る\">";
    	}else if(button_media.equals("bookmark")){		//ex. button("bookmark")
    		// ブックマーク処理
    		statement = "<input type=\"button\" value=\"お気に入りに登録\" data-icon=\"star\" onClick=\"addBookmark(document.title, location.href);\">";
    	}else if(button_media.equals("facebook")){		//ex. button("facebook")
    		// facebookのいいね！ボタンの処理
//    		statement = "<iframe class=\"like-btn\" scrolling=\"no\" frameborder=\"0\" style=\"border:none; overflow:hidden; width:200px; height:21px;\" allowTransparency=\"true\"></iframe>";
//    		statement = "<table height=36><tr valign=\"middle\"><td><iframe class=\"like-btn\" scrolling=\"no\" frameborder=\"0\" style=\"border:none; overflow:hidden; width:200px; height:21px;\" allowTransparency=\"true\"></iframe></td></tr></table>";
    		statement = "<table data-inline=\"true\"><tr valign=\"middle\"><td><iframe class=\"like-btn\" scrolling=\"no\" frameborder=\"0\" style=\"border:none; overflow:hidden; width:200px; height:21px;\" allowTransparency=\"true\"></iframe></td></tr></table>";
    		//statement = "<iframe class=\"like-btn\" scrolling=\"no\" frameborder=\"0\" style=\"border:none; overflow:hidden; width:200px; height:21px;\" allowTransparency=\"true\"></iframe>";
    	}else if(button_media.equals("twitter")){		//ex. button("twitter")
    		// twitterボタンの処理
//    		statement = "<a href=\"https://twitter.com/share\" class=\"twitter-share-button\" data-text=\"Twitter\" data-lang=\"ja\" data-size=\"small\">Tweet</a>";
    		statement = "<table data-inline=\"true\"><tr valign=\"middle\"><td><a href=\"https://twitter.com/share\" class=\"twitter-share-button\" data-text=\"Twitter\" data-lang=\"ja\" data-size=\"small\" target=\"_blank\">Tweet</a></td></tr></table>";
    		//statement = "<a href=\"https://twitter.com/share\" class=\"twitter-share-button\" data-text=\"Twitter\" data-lang=\"ja\" data-size=\"small\">Tweet</a>";
    	}else if(button_media.equals("sns")){		//ex. button("sns")
    		statement += "<DIV class=\"ui-grid-a\">\n<div class=\"ui-block-a\">";
//    		statement += "<iframe class=\"like-btn\" scrolling=\"no\" frameborder=\"0\" style=\"border:none; overflow:hidden; width:200px; height:21px;\" allowTransparency=\"true\"></iframe>\n";
    		statement += "<table><tr valign=\"middle\"><td><iframe class=\"like-btn\" scrolling=\"no\" frameborder=\"0\" style=\"border:none; overflow:hidden; width:200px; height:21px;\" allowTransparency=\"true\"></iframe></td></tr></table>\n";
    		statement += "</div>\n<div class=\"ui-block-b\">\n";
//    		statement += "<a href=\"https://twitter.com/share\" class=\"twitter-share-button\" data-text=\"Twitter\" data-lang=\"ja\" data-size=\"small\">Tweet</a></td></tr></table>\n";
    		statement += "<table><tr valign=\"middle\"><td><a href=\"https://twitter.com/share\" class=\"twitter-share-button\" data-text=\"Twitter\" data-lang=\"ja\" data-size=\"small\" target=\"_blank\">Tweet</a></td></tr></table>\n";
    		statement += "</div>\n</DIV>\n";
    	}
		
    	// 各引数毎に処理した結果をHTMLに書きこむ
    	html_env.code.append(statement);
    	return;
    }
    //added by goto 20121217 end
    
    //added by goto 20130308 start  "urlリンク"  url(),anchor(),a()
    /** url関数: url( name/button-name/button-url, url, type(bt/button/img/image) )
     *          @{ width=~, height=~, transition=~ } 
    /*    url("title", "detail/imgURL", int type), anchor(), a()    */
    /*    <type:1> url(リンク元の名前, リンク先URL) <=> url(リンク元の名前, リンク先URL, 1)    */
    /*    <type:2> url(画像URL, リンク先URL, 2)    	   	*/
    /*    <type:3> url(ボタンの名前, リンク先URL, 3)        	*/
    /*    mail()でも使用							        */
    private void Func_url(boolean mailFncFlg) {
    	String statement = "";
    	FuncArg fa1 = (FuncArg) this.getArgs().get(0), fa2, fa3;
    	String url, name, type;
    	
    	try{					//引数2つ or 3つの場合
    		fa2 = (FuncArg) this.getArgs().get(1);
    		url = ((mailFncFlg)?("mailto:"):("")) + fa2.getStr();
    		name = fa1.getStr();
        	
        	try{						//引数3つの場合
        		fa3 = (FuncArg) this.getArgs().get(2);
        		type = fa3.getStr();
        		
        		//type=1 -> 文字
        		if(type.equals("1") || type.equals("text") || type.equals("")){
        			statement = "<a href=\""+url+"\""+transition()+prefetch()+" target=\"_blank\">"+name+"</a>";
        		
        		//type=2 -> urlモバイルボタン
        		}else if(type.equals("3") || type.equals("button") || type.equals("bt")){
            		statement = "<a href=\""+url+"\" data-role=\"button\""+transition()+prefetch()+" target=\"_blank\">"+name+"</a>";

            	//urlボタン(デスクトップ・モバイル共通)
            	}else if(type.equals("dbutton") || type.equals("dbt")){
            		statement = "<input type=\"button\" value=\""+name+"\" onClick=\"location.href='"+url+"'\"";
            		
            		//urlボタン width,height指定時の処理
            		if(decos.containsKey("width") || decos.containsKey("height")){
            			statement += " style=\"";
            			if(decos.containsKey("width"))	statement += "WIDTH:"+decos.getStr("width").replace("\"", "")+"; ";
            			if(decos.containsKey("height"))	statement += "HEIGHT:"+decos.getStr("height").replace("\"", "")+"; ";	//100; ";
            			statement += "\"";
                	}
            		statement += ">";
            	
            	//type=3 -> url画像
            	}else if(type.equals("2") || type.equals("image") || type.equals("img")){
            		statement = "<a href=\""+url+"\""+transition()+prefetch()+" target=\"_blank\"><img src=\""+name+"\"";
    		        
        			//url画像 width,height指定時の処理
            		if(decos.containsKey("width"))	statement += " width="+decos.getStr("width").replace("\"", "");
            		else{
            	        //added by goto 20130312  "Default width: 100%"
            			statement += " width=\"100%\"";
            		}
        			if(decos.containsKey("height"))	statement += " height="+decos.getStr("height").replace("\"", "");	//100; ";
        			statement += "></a>";
            	}
        		
        	}catch(Exception e){		//引数2つの場合
        		statement = "<a href=\""+url+"\""+transition()+prefetch()+" target=\"_blank\">"+name+"</a>";
        	}
        	
    	}catch(Exception e){	//引数1つの場合
    		url = fa1.getStr();
    		statement = "<a href=\""+((mailFncFlg)?("mailto:"):("")) + url+"\""+transition()+prefetch()+" target=\"_blank\">"+url+"</a>";
    	}
    	
    	// 各引数毎に処理した結果をHTMLに書きこむ
    	html_env.code.append(statement);
    	return;
    }
    
    private String transition() {
    	//画面遷移アニメーション(data-transition)指定時の処理
    	//※外部ページへの遷移には対応していない
    	if (decos.containsKey("transition"))
    		return " data-transition=\"" + decos.getStr("transition") + "\"";
    	if (decos.containsKey("trans"))
    		return " data-transition=\"" + decos.getStr("trans") + "\"";
		return "";
    }
    
    private String prefetch() {
    	//遷移先ページプリフェッチ(data-prefetch)指定時の処理
    	//※外部ページへの遷移に使用してはいけない決まりがある
    	if (decos.containsKey("prefetch") || decos.containsKey("pref"))
    		return " data-prefetch";
		return "";
    }
    //added by goto 20130308 end
    
    //added by goto 20130312 start  "line"
    /*  line(color, size)  */
    private void Func_line() {
    	String statement = "\n<hr";
    	try{
    		//color
    		FuncArg fa1 = (FuncArg) this.getArgs().get(0);
    		if(!fa1.getStr().equals(""))
    			statement += " color=\""+fa1.getStr()+"\"";
    		//size
    		FuncArg fa2 = (FuncArg) this.getArgs().get(1);
    		statement += " size=\""+fa2.getStr()+"\"";
    	}catch(Exception e){
    		statement += " size=\"1\"";
    	}
    	statement += ">\n";
		
    	// 各引数毎に処理した結果をHTMLに書きこむ
    	html_env.code.append(statement);
    	return;
    }
    //added by goto 20130312 end

    //added by goto 20130325 start  "dline"	dotted line(点線)
    /*  dline(color, size)  */
    private void Func_dline() {
    	//ex. <hr style="border-top: 1px dotted black;">
    	String statement = "\n<hr style=\"border-top: ";
    	String color = "";
    	try{
    		//color
    		FuncArg fa1 = (FuncArg) this.getArgs().get(0);
    		if(!fa1.getStr().equals(""))	color = fa1.getStr();
    		else							color = "black";
    		//size
    		FuncArg fa2 = (FuncArg) this.getArgs().get(1);
    		statement += fa2.getStr();
    	}catch(Exception e){
    		statement += "1";
    	}
    	statement += "px dotted "+color+"\">\n";
		
    	// 各引数毎に処理した結果をHTMLに書きこむ
    	html_env.code.append(statement);
    	return;
    }
    //added by goto 20130325 end
    
    //added by goto 20130313 start  "header"
    /*	header("title")	*/
    private void Func_header() {
    	//TODO: 第2引数で画像のURL,リンク先等
    	
    	String statement = "";
    	try{
    		//title
    		FuncArg fa1 = (FuncArg) this.getArgs().get(0);
    		if(!fa1.getStr().equals(""))
    			statement = fa1.getStr();
    		else	return;
    	}catch(Exception e){ return; }
		
    	html_env.code.append("<div data-role=\"header\" data-position=\"fixed\" style=\"padding: 11px 0px;\">\n");
    	html_env.code.append("<a href=\"\" data-rel=\"back\" data-role=\"button\" data-icon=\"back\" data-mini=\"true\">Back</a>\n");
    	html_env.code.append("\n");
    	html_env.code.append("<div class=\"ui-btn-right\">\n");
    	html_env.code.append("	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\"><tr><td>\n");
    	html_env.code.append("		<a href=\"index.html\" data-role=\"button\" data-icon=\"home\" data-iconpos=\"notext\" data-mini=\"true\"></a>\n");
    	html_env.code.append("	</td><td>\n");
    	html_env.code.append("		<form style=\"display:inline;\">\n");
    	html_env.code.append("			<input type=\"button\" data-icon=\"forward\" data-iconpos=\"notext\" data-mini=\"true\" onClick=\"history.forward()\" >\n");
    	html_env.code.append("		</form>\n");
    	html_env.code.append("	</td><td>\n");
    	html_env.code.append("		<a href=\"#popupMenu\" data-rel=\"popup\" data-role=\"button\" data-icon=\"grid\" data-iconpos=\"notext\" data-mini=\"true\"></a>\n");
    	html_env.code.append("		<div data-role=\"popup\" id=\"popupMenu\" data-transition=\"slidedown\" style=\"width:95%;\" data-overlay-theme=\"a\">\n");
    	html_env.code.append("			<a href=\"#\" data-rel=\"back\" data-role=\"button\" data-theme=\"a\" data-icon=\"delete\" data-iconpos=\"notext\" class=\"ui-btn-right\">Close</a>\n");
    	html_env.code.append("			<ul data-role=\"listview\" data-inset=\"true\" style=\"min-width:210px;\" data-theme=\"d\">\n");
    	html_env.code.append("				<li data-role=\"divider\" data-theme=\"a\">Menu</li>\n");
    	html_env.code.append("				<li><a href=\"login.html\">Log in</a></li>\n");
    	html_env.code.append("				<li><a href=\"options.html\">Options</a></li>\n");
    	html_env.code.append("				<li><a href=\"https://www.google.com/\">Search</a></li>\n");
    	html_env.code.append("			</ul>\n");
    	html_env.code.append("		</div>\n");
    	html_env.code.append("	</td></tr></table>\n");
    	html_env.code.append("</div>\n\n");
    	
    	html_env.code.append("<div>"+statement+"</div>\n");
    	html_env.code.append("</div>\n");
    	return;
    }
    //added by goto 20130313 end
    
    //added by goto 20130313 start  "footer"
    /*	footer("title")	*/
    private void Func_footer() {
    	String statement = "";
    	try{
    		//title
    		FuncArg fa1 = (FuncArg) this.getArgs().get(0);
    		if(!fa1.getStr().equals(""))
    			statement = fa1.getStr();
    		else	return;
    	}catch(Exception e){ return; }
		
    	html_env.code.append("<div data-role=\"footer\" data-position=\"fixed\" style=\"padding: 11px 0px;\">\n");
    	html_env.code.append(statement+"\n");
    	html_env.code.append("</div>\n");
    	return;
    }
    //added by goto 20130313 end
    
    
    //added by goto 20130313 start  "popup"
    /*	pop("title","detail/imgURL",int type), popup()	*/
    /*	<type:1> pop("title","detail") <=> pop("title","detail",1)	*/
    /*	<type:2> pop("title","image URL",2)		*/
    private void Func_pop() {
    	FuncArg fa1 = (FuncArg) this.getArgs().get(0), fa2, fa3;
    	String title, detailORurl, type;
    	int type1Flg = 0; //type1(文字)フラグ
    	
//    	Log.info("popCount = "+popCount);
    	try{					//引数2つ or 3つの場合
    		fa2 = (FuncArg) this.getArgs().get(1);
    		detailORurl = fa2.getStr();
    		title = fa1.getStr();
        	
        	try{						//引数3つの場合
        		fa3 = (FuncArg) this.getArgs().get(2);
        		type = fa3.getStr();
        		
        		//type=1 -> 文字
        		if(type.equals("1") || type.equals("text") || type.equals("")){
        			type1Flg = 1;
        			
        		//type=2 -> imageFile
        		}else if(type.equals("2") || type.equals("image") || type.equals("img")){
        			html_env.code.append("	<a href=\"#popup"+popCount+"\" data-rel=\"popup\" data-role=\"button\" data-icon=\"arrow-r\" data-inline=\"true\" class=\"ui-li-inside\">"+( (!title.equals(""))? title : "Photo" )+"</a>\n");
        	    	//TODO: data-transition  transition()使用可能
        			html_env.code.append("	<div data-role=\"popup\" id=\"popup"+popCount+"\" data-transition=\"pop\" style=\"width:95%;\" data-overlay-theme=\"a\">\n");
        	    	html_env.code.append("		<a href=\"#\" data-rel=\"back\" data-role=\"button\" data-theme=\"a\" data-icon=\"delete\" data-iconpos=\"notext\" class=\"ui-btn-right\">Close</a>\n");
        	    	html_env.code.append("		<img src=\""+detailORurl+"\"");
    		        
        			//type=2 width,height指定時の処理
            		if(decos.containsKey("width"))
            			html_env.code.append(" width="+decos.getStr("width").replace("\"", ""));
            		else{
            	        //added by goto 20130312  "Default width: 100%"
            			html_env.code.append(" width=\"100%\"");
            		}
        			if(decos.containsKey("height"))
        				html_env.code.append(" height="+decos.getStr("height").replace("\"", ""));
        			
        			html_env.code.append(">\n");
        			
        			//画像下部にtitleを付加
        			if(!title.equals(""))	html_env.code.append("		<p style=\"margin:0px;\">"+title+"</p>\n");
        			
        	    	html_env.code.append("	</div>\n");
        		}

        	}catch(Exception e){		//引数2つの場合
        		type1Flg = 1;	//type=1 -> 文字
        	}
        	
        	//type=1 -> 文字
    		if(type1Flg == 1){
    			html_env.code.append("	<a href=\"#popup"+popCount+"\" data-rel=\"popup\" data-role=\"button\" data-icon=\"arrow-r\" data-inline=\"true\">"+( (!title.equals(""))? title : "Open" )+"</a>\n");
    	    	//TODO: data-transition  transition()使用可能
    			html_env.code.append("	<div data-role=\"popup\" id=\"popup"+popCount+"\" data-transition=\"slideup\" style=\"width:95%;\" data-overlay-theme=\"a\">\n");
    	    	html_env.code.append("		<a href=\"#\" data-rel=\"back\" data-role=\"button\" data-theme=\"a\" data-icon=\"delete\" data-iconpos=\"notext\" class=\"ui-btn-right\">Close</a>\n");
    	    	html_env.code.append("		<p>"+detailORurl+"</p>\n");
    	    	html_env.code.append("	</div>\n");
    		}

    	}catch(Exception e){	//引数1つの場合
    		Log.info("<Warning> pop関数の引数が不足しています。 ex. pop(title, Detail/URL, typeValue)");
    		return;
    	}
    	
    	popCount++;
    	return;
    }
    //added by goto 20130313 end
    
    private void Func_null() {
        return;
    }
    
    

    //added by chie 2009 func form submit
    private void Func_submit() {
    	String form = new String();
    	boolean openFormInThis = false;

    	//submit only ----- no "@{form}"
    	if(!HTMLEnv.getFormItemFlg() && !decos.containsKey("form")){
    		form = createForm();
        	openFormInThis = true;
    	}else if(decos.containsKey("form")){
    		form = createForm(decos);
        	openFormInThis = true;
    	}


		HTMLEnv.setFormItemFlg(true,"submit");

    	String value = new String();
    	if(!this.getAtt("value").equals(null)){
        	value = "value=\"" + this.getAtt("value") + "\"";
        }


    	String option = new String();
    	if(!this.getAtt("default").equals(null)){
        	option += "value=\"" + this.getAtt("default") + "\"";
        }

        form += "<input type=\"submit\" " + option + " />";

    	if(openFormInThis == true){
    		form += "</form>";
    		HTMLEnv.setFormItemFlg(false,null);
    		openFormInThis = false;
    	}else{
    		HTMLEnv.setFormItemFlg(true,null);
    	}

        html_env.code.append(form);
        html_env2.code.append("<VALUE type=\"form\">"+form+"</VALUE>");
        return;
    }

  //added by chie 2009 func form select
    private void Func_select() {
        if(!this.getAtt("selected").equals("")){
        	HTMLEnv.setSelected(this.getAtt("selected"));
        }

		Func_FormCommon("select");

        return;
    }
  //added by chie 2009 func form checkbox
    private void Func_checkbox() {
		Func_FormCommon("checkbox");

		if(!this.getAtt("checked").equals("")){
        	HTMLEnv.setChecked(this.getAtt("checked"));
        }

        return;
    }
    //added by chie 2009 func form radio
    private void Func_radio() {

		if(!this.getAtt("checked").equals("")){
        	HTMLEnv.setChecked(this.getAtt("checked"));
        }

		Func_FormCommon("radio");

        return;
    }
    //added by chie 2009 func form inputtext
    private void Func_inputtext() {
		Func_FormCommon("text");
        return;
    }
    //added by chie 2009 func form textarea
    private void Func_textarea() {
		Func_FormCommon("textarea");
        return;
    }

  //added by chie 2009 func form hidden
    private void Func_hidden() {
		Func_FormCommon("hidden");
        return;
    }

    private void Func_FormCommon(String s){
    	String form = new String();

    	boolean openFormInThis = false;

    	if(!HTMLEnv.getFormItemFlg()){
    		form = createForm();
        	openFormInThis = true;
    	}

		HTMLEnv.setFormItemFlg(true,s);

        String att = new String();
        Integer attNo = 1;
        while (!this.getAtt("att"+attNo).equals("")){
        	if(attNo > 1)
        		att += ",";
        	att += this.getAtt("att"+attNo);
        	Log.out("att:" + att + " attNo:" + attNo);
        	attNo ++;
        }
        if(attNo == 1 && !this.getAtt("att").equals("")){
        	att += this.getAtt("att");
        	Log.out("att:" + att + " attNo:" + attNo);
        }

        if(!this.getAtt("name").equals("")){
        	HTMLEnv.setFormPartsName(this.getAtt("name"));
        	HTMLEnv.exFormName();
        }else{
        	HTMLEnv.setFormPartsName(null);
        }

        if(!this.getAtt("id").equals("")){
        	HTMLEnv.nameId = this.getAtt("id");
        }

        if(!this.getAtt("cond_name").equals("")){
        	HTMLEnv.cond_name = this.getAtt("cond_name");
        }
        if(!this.getAtt("cond").equals("")){
        	HTMLEnv.cond = this.getAtt("cond");
        }


        html_env.code.append(form);

        if(this.getArgs().get(0) instanceof FuncArg)
        {
        	//HTMLEnv.setSelectFlg(true,(String)this.decos.get("select"));
        	HTMLEnv.setFormValueString(att);
        	Log.out("ARGS are function");
        	FuncArg fa = (FuncArg) this.getArgs().get(0);
        	fa.workAtt();
        }
        else{
            this.workAtt("default");
        }

    	if(openFormInThis == true){
    		html_env.code.append("</form>");
    		HTMLEnv.setFormItemFlg(false,null);
        	openFormInThis = false;
    	}else{
    		HTMLEnv.setFormItemFlg(true,null);
    	}
        return;
    }


    private String createForm() {
    	String path = new String();
    	String form = new String();
    	if(this.getAtt("path") != null &&  !this.getAtt("path").isEmpty()){
    		 path =  this.getAtt("path").replaceAll("\"", "");
    	}else{
    		path = ".";
    	}

    	form += "<form method=\"POST\" action=\"" + path + "/servlet/supersql.form.FormServlet\"" +">";

    	form += "<input type=\"hidden\" name=\"configfile\" value=\"" +
		path + "/config.ssql\" />";

        if(this.getAtt("link") != null && !this.getAtt("link").isEmpty()){
        	form += "<input type=\"hidden\" name=\"sqlfile\" value=\"" + path + "/" + this.getAtt("link").replaceAll("\"", "") + "\" />";
        }else if(this.getAtt("linkfile") != null && !this.getAtt("linkfile").isEmpty()){
        	form += "<input type=\"hidden\" name=\"sqlfile\" value=\"" + path + "/" + this.getAtt("linkfile").replaceAll("\"", "") + "\" />";
        }
    	/*
        if(!this.getAtt("default").equals(null)){
        	form += "<input type=\"hidden\" name=\"value1\" value=\""+this.getAtt("default").replaceAll("\"", "")+"\" />";
        }
        */

        if(this.getAtt("cond")!= null && !this.getAtt("cond").isEmpty()){
        	if(!this.getAtt("cond").replaceAll("\"", "").isEmpty())
        		form += "<input type=\"hidden\" name=\"cond1\" value=\""+this.getAtt("cond").replaceAll("\"", "")+"\" />";
        }

        String att = new String();
        Integer attNo = 1;
        while (!this.getAtt("att"+attNo).equals("")){
        	if(attNo > 1)
        		att += ",";
        	att += this.getAtt("att"+attNo);
        	attNo ++;
        	Log.out("att:" + att + " attNo:" + attNo);
        }

        if(attNo == 1 && !this.getAtt("att").equals("")){
        	att += this.getAtt("att");
        	Log.out("att:" + att + " attNo:" + attNo);
        }

        if(this.getAtt("update")!=null && !this.getAtt("update").isEmpty()){
        	form += "<input type=\"hidden\" name=\"updatefile\" value=\"" + path + "/" +this.getAtt("update").replaceAll("\"", "")+"(" + att + ")\" />";
        }else if(this.getAtt("updatefile")!=null && !this.getAtt("updatefile").isEmpty()){
        	form += "<input type=\"hidden\" name=\"updatefile\" value=\"" + path + "/" +this.getAtt("updatefile").replaceAll("\"", "")+"(" + att + ")\" />";
        }


        Log.out(form);
        return form;
    }

    public static String createForm(DecorateList decos) {
    	String option = new String();
    	String path = new String();
    	String form = new String();
    	//System.out.println(this.getAtt("label"));
    	if(decos.containsKey("path")){
    		path =  decos.getStr("path").replaceAll("\"", "");
    	}else{
    		path = ".";
    	}

    	form = "<form method=\"POST\" action=\"" + path + "/supersql.form.FormServlet\" " + "name=\""+ HTMLEnv.getFormName() + "\" " +">";


    	form += "<input type=\"hidden\" name=\"configfile\" value=\"" +
		GlobalEnv.getFileDirectory() + "/config.ssql\" />";

        if(decos.containsKey("link")){
        	String tmp = opt(decos.getStr("link"));
        	form += "<input type=\"hidden\" name=\"sqlfile\" value=\"" + path + "/" + decos.getStr("link").replaceAll("\"", "") + "\" />";
        }

        if(decos.containsKey("cond")){
        	form += "<input type=\"hidden\" name=\"cond1\" value=\""+decos.getStr("cond").replaceAll("\"", "")+"\" />";
        }


        if(decos.containsKey("updatefile")){
        	String tmp = opt(decos.getStr("updatefile"));
        	updateFile = "<input type=\"hidden\" name=\"updatefile\" value=\"" + path + "/" +tmp+"\" />";
        	form += updateFile;
        }
        if(decos.containsKey("linkfile")){
        	String tmp = opt(decos.getStr("linkfile"));
        	form += "<input type=\"hidden\" name=\"linkfile\" value=\"" + path + "/" +decos.getStr("linkfile").replaceAll("\"", "")+"\" />";
        }
        if(decos.containsKey("cond")){
        	form += "<input type=\"hidden\" name=\"linkcond\" value=\"" + decos.getStr("cond").replaceAll("\"", "")+"\" />";
        }
        Log.out(form);
        HTMLEnv.setFormDetail(form);
        return form;
    }

    //not use
    /*
    private void Func_session() {
    	System.out.println("aaaaaaaaa"+this.getClassName());
    	html_env.code.append("b");
        html_env2.code.append("<VALUE type=\"form\">b</VALUE>");
    	return;
    }
    */

    private void Func_invoke() {

        /*
         * Invoke function : <td> <a
         * href="${server_path}/supersql.invoke.InvokeServlet?
         * ${dbname}+${query_filename}+${added_condition}"> TFE </a> </td>
         */

    	String path = this.getAtt("path", ".");
    	if(!GlobalEnv.getFileDirectory().equals(".")){
    		path = GlobalEnv.getFileDirectory();
    	}
        String filename = this.getAtt("filename");
        if (!filename.startsWith("/") && (path != null)) {
            filename = path + "/" + filename;
        }



        Log.out("invoke filename:"+filename);


        //start tk/////////////////////////////////
        /*
        html_env.linkurl = this.getAtt("server_path", GlobalEnv
                .getInvokeServletPath())
                + "?"
                + this.getAtt("dbname", GlobalEnv.getdbname())
                + "+"
                + filename + "+" + this.getAtt("condition");
        */
        /*
        html_env.linkurl = "http://localhost:8080/invoke/servlet/supersql.invoke.InvokeServlet2"
                + "?"
                + "config=http://localhost:8080/invoke/config.ssql"
                + "&"
                + "query=" + filename
                + "&"
                + "cond=" + this.getAtt("condition");
		*/
        //change chie
        html_env.linkurl = this.getAtt("server_path", GlobalEnv
                .getInvokeServletPath())
                + "?"
                + "config="+path+"/config.ssql"
                + "&"
                + "query=" + filename
                + "&"
                + "cond=" + this.getAtt("condition");
        // end tk//////////////////////////////////////////////////

        html_env.link_flag=1;
        this.workAtt("default");
        html_env.link_flag=0;

        return;
    }

    private void Func_foreach(ExtList data_info) throws UnsupportedEncodingException {
    	String att = new String();
    	String attkey;
    	for (int i = 0; i < this.countconnectitem(); i++) {
    		att = att + "_" + this.getAtt(Integer.toString(i));
    	}
        //String filename = html_env.outfile + "_" + this.getAtt("default") + ".html";
    	att = URLEncoder.encode(att, "UTF-8");
    	String filename = html_env.outfile + att + ".html";

        html_env.filename = filename;
        //System.out.println(filename);
        return;
    }

    //tk start//////////////////////////////////////////////////////////////////////////////
    private void Func_embed(ExtList data_info){
    	String file = this.getAtt("file");
    	String where = this.getAtt("where");
    	String att = this.getAtt("att");
    	String border = this.getAtt("border");
    	String att2 = this.getAtt("attString");
    	String condition = new String();
    	String defcond = this.getAtt("defcond");


    	Log.out("function embed");
		Log.out("isNewEmbed:"+GlobalEnv.isNewEmbed());

		boolean is_hidden = false;

		if(decos.containsKey("status"))
        	if(decos.getStr("status").compareTo("hidden") == 0)
        		is_hidden = true;

		//for tab
		if(decos.containsKey("tab"))
		{
			html_env.code.append("<div id=\"myTab\" ");

			if(decos.containsKey("class"))
				html_env.code.append("class=\""+decos.getStr("class")+"\"");

			html_env.code.append(">\n");
			html_env.code.append("<div id=\"mTab\" class=\"yui-navset\">\n");

			html_env.code.append("</div></div>\n");

			html_env.script.append("var mTab = new YAHOO.widget.TabView(\"mTab\");");
    		html_env.script.append("new YAHOO.util.DDTarget(\"myTab\", \"myTab\");");

			return;
		}

        if(!is_hidden)
        {
        	html_env.code.append("<table class=\"att " + html_env.getOutlineModeAtt() + " ");

        	if(decos.containsKey("class"))
        		html_env.code.append(decos.getStr("class"));
        	else
        		html_env.code.append(HTMLEnv.getClassID(this));

        	html_env.code.append("\"");
        	html_env.code.append("><tr><td>");
        }

        // for ajax div id //////////////////////////////////////////////////////

        String divname = new String();
        boolean has_divid = false;

        if(decos.containsKey("divid"))
		{
			has_divid = true;
			Log.out("embed contains decos with divid");
			String tmpdivid = decos.getStr("divid");
			String tmp;
			String ans;

			if(tmpdivid.contains("+"))
			{
				ans = tmpdivid.substring(0,tmpdivid.indexOf("+"));
				tmp = tmpdivid.substring(tmpdivid.indexOf("+")+1,tmpdivid.length());

				if(tmp.compareTo("att") == 0)
				{
					tmp = att;
				}
				divname = ans + "_" + tmp;
				Log.out("ans :"+ans+" tmp:"+tmp+" divname:"+divname);
			}
			else{
				divname = decos.getStr("divid");
			}
		}/*else
		{
			//online file
			if(file.contains("/"))
			{
				divname = file.substring(file.lastIndexOf("/")+1,file.indexOf(".sql"));
			}
			//ofline file
			else if(file.contains("\\"))
			{
				Log.out(" // index"+file.indexOf(".sql"));
				divname = file.substring(file.lastIndexOf("\\")+1,file.indexOf(".sql"));
			}
			//only file name
			else
			{
				divname = file.substring(0,file.indexOf(".sql"));
			}

		}
        */
        if(GlobalEnv.isAjax() && decos.containsKey("droppable"))
        {
        	html_env.script.append("new YAHOO.util.DDTarget(\""+divname+"\", \""+divname+"\");");
        }
        //ajax & decos contains status=hidden
        if(is_hidden && GlobalEnv.isAjax()){

			html_env.code.append("<div id=\""+divname+"\" ");

			if(decos.containsKey("class"))
				html_env.code.append("class=\""+decos.getStr("class")+ "\" ");

			html_env.code.append("></div>");
			Log.out("<div id="+divname+"></div>");

			return;
        }
        // end ajax divname ////////////////////////////////////////////////

/*    	if(border.compareTo("1") == 0)
    	{}
    	else
    		html_env.css.append(".embed { vertical-align : text-top; padding : 0px ; margin : 0px; border: 0px,0px,0px,0px; width: 100%;}");
 */
    	if(att.compareTo("") != 0 ){
    		condition = condition + where+att;
    	}
    	else if(att2.compareTo("") != 0){
    		condition = condition + where+"'"+att2+"'";
    	}
    	//store original config
    	Hashtable tmphash = GlobalEnv.getEnv();

    	//set new config for embed
//    	String[] args = {"-f",file,"-cond",condition,"-debug"};
//    	Log.out("cond:"+condition);
    	String[] args;
    	if(GlobalEnv.isAjax())
    	{
    		if(condition.equals(""))
    		{
    	   		args = new String[3];
        		args[0] = "-f";
        		args[1] = file;
        		args[2] = "-ajax";
//        		args[3] = "-debug";

    		}
    		else
    		{
    	   		args = new String[5];
        		args[0] = "-f";
        		args[1] = file;
        		args[2] = "-cond";
       			args[3] = condition;
        		args[4] = "-ajax";
//        		args[5] = "-debug";
    		}
    	}
    	else
    	{
    		if(GlobalEnv.isOpt()){
    			args = new String[5];
	    		args[0] = "-f";
	    		args[1] = file;
	    		args[2] = "-cond";
	    		args[3] = condition;
	    		args[4] = "-optimizer";
	//    		args[5] = "-debug";
    		}else{
	    		args = new String[4];
	    		args[0] = "-f";
	    		args[1] = file;
	    		args[2] = "-cond";
	    		args[3] = condition;
	//    		args[4] = "-debug";
    		}
    	}

    	html_env.embedcount++;

    	if(file.contains(".sql"))
    	{

    		String makedfilename = file.substring(file.lastIndexOf("\\")+1, file.indexOf("."));

    		if(att.compareTo("") != 0)
    			makedfilename = makedfilename.concat("_"+att);
    		if(att2.compareTo("") != 0)
    			makedfilename = makedfilename.concat("_"+att2);

    		makedfilename= makedfilename.concat(".html");

    		Log.out("embed tmpfilename:"+makedfilename+" option:"+GlobalEnv.getEmbedOption());

    		File makedfile = new File(GlobalEnv.getEmbedTmp(), makedfilename);

    		if(makedfile.exists() && GlobalEnv.isNewEmbed() == 1)
    		{
    			Log.out("[Enter new Embed]");
    			Log.out("embed read tmp file");
    			BufferedReader dis;
    			String line = new String();
    			try{
    				dis = new BufferedReader(new FileReader(makedfile));

               		try{
               			while(!line.equalsIgnoreCase(" "))
                   	{
                   		Log.out("line : "+line);
                   		line = dis.readLine();
                   		if(line != null)
                   			html_env.code.append(line);
                   	}
               		}catch(NullPointerException e)
               		{
               			Log.out("no more lines");
               		}

                    dis.close();
    			}
    			catch (IOException ioe) {
                     System.out.println("IOException: " + ioe);
                }
    		}
    		else
    		{
    			Log.out("embed make file");

    			GlobalEnv.setGlobalEnvEmbed(args);


    			SSQLparser parser;
    			if(file.contains("http"))
    			{
    				parser = new SSQLparser("online");
    			}
    			else
    			{
	    			parser = new SSQLparser(10000*(html_env.embedcount+1));
	    		}

	    		CodeGenerator codegenerator = parser.getcodegenerator();
				DataConstructor dc = new DataConstructor(parser);
				StringBuffer returnedcode = codegenerator.generateCode2(parser,dc.getData());

				//ajax add div tag////////////////////////////////////////////////////////////////////
				if(GlobalEnv.isAjax())
				{
					if(!has_divid)
					{
						//online file
						if(file.contains("/"))
						{
							divname = file.substring(file.lastIndexOf("/")+1,file.indexOf(".sql"));
						}
						//ofline file
						else if(file.contains("\\"))
						{
							divname = file.substring(file.lastIndexOf("\\")+1,file.indexOf(".sql"));
						}
						//only file name
						else
						{
							divname = file.substring(0,file.indexOf(".sql"));
						}
					}

					html_env.code.append("<div id=\""+divname+"\" ");

					if(decos.containsKey("class"))
						html_env.code.append("class=\""+decos.getStr("class")+ "\" ");

					html_env.code.append(">");
//	    			html_env.code.append("<br><a href=\"close.html\" class=\"bottom_close_"+divname+"\" onClick=\"return closeDiv('"+divname+"')\">close</a><br>");
					Log.out("<div id="+divname+">");
				}

				// ajax depends on decos status //////////////////////////////////////////
				boolean status_flag = false;

				//xml�����
				if(!is_hidden){
					html_env2.code.append("<EMBED>");
					html_env.code.append(returnedcode);
					html_env2.code.append(returnedcode);
					html_env2.code.append("</EMBED>");
				}

				if(GlobalEnv.isAjax())
					html_env.code.append("</div>");
				// end ajax /////////////////////////////////////////////////////////////////

				if(html_env.embedcount >= 1)
				{
					html_env.css.append(codegenerator.generateCode3(parser,dc.getData()));
					html_env.cssfile.append(codegenerator.generateCssfile(parser,dc.getData()));
				}

				//restore original config
				GlobalEnv.setEnv(tmphash);

				//writing tmpfile
				Log.out("embed hogehoge:"+GlobalEnv.isNewEmbed());
				Log.out("enb:"+GlobalEnv.getEnv());

				if(GlobalEnv.isNewEmbed() == 1)
				{
					GlobalEnv.addEmbedFile(makedfilename);
					Log.out("embed start writing");
					String filename = GlobalEnv.getEmbedTmp();

					if(filename.endsWith("/") || filename.endsWith("\\"))
						filename = filename + makedfilename;
					else
						filename = filename + "/" + makedfilename;

					try {
						OutputStream fout = new FileOutputStream(filename);
			        	OutputStream bout = new BufferedOutputStream(fout);
			        	OutputStreamWriter out = new OutputStreamWriter(bout,"UTF-8");

			        	out.write(html_env.header.toString());
			        	out.write(returnedcode.toString());
			        	out.write(html_env.footer.toString());

			        	out.close();
						/*
						PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
			                    filename)));
			            Log.out("filename:"+filename);
			            pw.println(html_env.header);
			            pw.println(returnedcode);
			            pw.println(html_env.footer);
			            pw.close();
						 */
			        } catch (FileNotFoundException fe) {

			        	fe.printStackTrace();
			        	System.err.println("Error: specified embedtmp outdirectory \""
			                    + GlobalEnv.getEmbedTmp() + "\" is not found to write " + html_env.filename );

		                GlobalEnv.addErr("Error: specified embedtmp outdirectory \""
			                    + GlobalEnv.getEmbedTmp() + "\" is not found to write " + html_env.filename);
	                    //comment out by chie
			        	//System.exit(-1);
			        } catch (IOException e) {
			            System.err.println("Error[HTMLManager]: File IO Error in HTMLManager at embed");
			            e.printStackTrace();
			            GlobalEnv.addErr("Error[HTMLManager]: File IO Error in HTMLManager at embed");
			            //comment out by chie
			            //System.exit(-1);
			        }
				}

    		}
    	}
    	//embed html file
    	else if(file.contains(".html"))
    	{
            String line = new String();

            if(decos.containsKey("divid"))
            	divname = decos.getStr("divid");
            else if(file.contains("\\"))
            	divname = file.substring(file.lastIndexOf("\\")+1,file.indexOf(".html"));
            else if(file.contains("/"))
            	divname = file.substring(file.lastIndexOf("/")+1,file.indexOf(".html"));
            else
            	divname = file.substring(0,file.indexOf(".html"));

            BufferedReader dis;
            try {
            	if(file.contains("http://"))
            	{
            		URL fileurl = new URL(file);

            		URLConnection fileurlConnection = fileurl.openConnection();
            		dis = new BufferedReader(new InputStreamReader(fileurlConnection.getInputStream()));
            	}
            	else{
            		try{
            			Log.out("embed file (html):"+file);
            			dis = new BufferedReader(new FileReader(new File(file)));
            		}catch(IOException ioe){
            			String path = html_env.outfile;
            			if(path.contains("\\"))
            				path = path.substring(0,path.lastIndexOf("\\")+1);
            			else if(path.contains("/"))
            				path = path.substring(0,path.lastIndexOf("/")+1);
            			if(file.startsWith("./")){
            				file = file.substring(1,file.length());
            			}
            			Log.out("embed file (html):"+path+file);
	            			if(path.startsWith("http:")){
	            				URL fileurl = new URL(path + file);
	                    		URLConnection fileurlConnection = fileurl.openConnection();
	            				dis = new BufferedReader(new InputStreamReader(fileurlConnection.getInputStream()));
	            			}else{
	                			dis = new BufferedReader(new FileReader(new File(path+file)));

	            			}
            		}
            	}
               /* DataInputStream dis = new
                DataInputStream(fileurlConnection.getInputStream());*/
                line = dis.readLine(); //read <BODY> and/or <HEAD>
                if(line.contains("<head>"))
                {
                }
                else
                {
                	line = dis.readLine(); //read <HEAD>
                }


               	while(!line.equalsIgnoreCase("</head>"))
               	{
               		line = dis.readLine();
               		if(!line.equalsIgnoreCase("</head>"))
               			html_env.header.append(line+"\n");
               	}
               	line = dis.readLine(); //read <body>

    			html_env.code.append("<div id=\""+divname+"\" ");

    			if(decos.containsKey("class"))
    				html_env.code.append("class=\""+decos.getStr("class")+ "\" ");

    			html_env.code.append(">");


       			html_env2.code.append("<EMBED>");
               	while(!line.equalsIgnoreCase("</body>"))
               	{
               		Log.out("line : "+line);
               		line = dis.readLine();
               		if(!line.equalsIgnoreCase("</body>")){
               			html_env.code.append(line);
               	        if(line.contains("&"))
               	        	line = line.replace("&", "&amp;");
               			if(line.contains("<"));
               				line = line.replace("<", "&lt;");
               			if(line.contains(">"))
               		        line = line.replace(">", "&gt;");
               	        if(line.contains("���"))
               	        	line = line.replace("���", "&#65374;");
               			html_env2.code.append(line);
               		}
               	}
       			html_env2.code.append("</EMBED>");
//    			html_env.code.append("<br><a href=\"close.html\" class=\"bottom_close_"+divname+"\" onClick=\"return closeDiv('"+divname+"')\">close</a><br>");

               	html_env.code.append("</div>");
                dis.close();

            } catch (MalformedURLException me) {
                System.out.println("MalformedURLException: " + me);
            } catch (IOException ioe) {
                System.out.println("HTMLFuncEmbed:IOException: " + ioe);
            }

    	}
    	if(!is_hidden)
    		html_env.code.append("</td></tr></table>");

    	html_env.embedcount += 1;
    }
    //tk end////////////////////////////////////////////////////////////////////////////

    private void Func_sinvoke(ExtList data_info) {
        String file = this.getAtt("file");
        String action = this.getAtt("action");
        int attNo = 1;
        String att = new String();
        Log.out("sinvoke file 3: "+file);

        //tk start/////////////////////////////////////////////////////////////
        /*
        if (file.indexOf("/") > 0) {
            file = file.substring(file.lastIndexOf("/") + 1);
        }
*/
        //tk end//////////////////////////////////////////////////////////////
      	Log.out("1 att:" + att + " attNo:" + attNo + " att1:" + this.getAtt("att1"));

        while (!this.getAtt("att"+attNo).equals("")){
        	att = att + "_" + this.getAtt("att"+attNo);
        	attNo ++;
        	Log.out("att:" + att + " attNo:" + attNo);
        	//System.out.println(att);
        }
    	try {
			att = URLEncoder.encode(att, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(this.getAtt("action").equals("")){
		try{
			if(file.toLowerCase().contains(".sql")){
				file = file.substring(0, file.indexOf(".sql"));
			}else if(file.toLowerCase().contains(".html")){
				file = file.substring(0, file.indexOf(".html"));
			}
		}catch(Exception e){
			GlobalEnv.addErr("Error[HTMLFunction]: filename is invalid.");
			System.err.println("Error[HTMLFunction]: filename is invalid.");
		}

        String filename = new String();
        if(!this.getAtt("att").equals("")){
        	if(this.getAtt("att").toLowerCase().startsWith("http://"))
            	filename = this.getAtt("att");
        	else if(this.getAtt("att").toLowerCase().endsWith(".html"))
            	filename = this.getAtt("att");
            else
            	filename = file + "_" + this.getAtt("att") + ".html";
        }else{
        	filename = file + att + ".html";
        }

        filename.replace("\\\\","\\");
        html_env.linkurl = filename;
        html_env.sinvoke_flag = true;

		}else{
			String filename = new String();
	        if(!this.getAtt("att").equals(""))
	        	filename = action + "/" + this.getAtt("att");
	        else
	        	filename = action + att;

	        filename.replace("\\\\","\\");
	        html_env.linkurl = filename;
	        html_env.sinvoke_flag = true;
		}

        //tk to make hyper link to image///////////////////////////////////////////////////
        //tk to ajax
        if(GlobalEnv.isAjax())
        {
        	html_env.linkurl =  file+".html";
        	html_env.ajaxquery = file+".sql";
//        	html_env.ajaxatt = this.getAtt("att");
        	html_env.ajaxcond = this.getAtt("ajaxcond")+"="+this.getAtt("att");

    		Date d2 = new Date();
    		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyymmddHHmmss");
    		String today2 = sdf2.format(d2);

        	html_env.dragdivid = html_env.ajaxquery+"+"+html_env.ajaxcond+"&"+today2;

        	if(decos.containsKey("in"))
        	{
        		String effect = decos.getStr("in");

        		if(effect.equalsIgnoreCase("blind"))
        			html_env.inEffect = 1;
        		if(effect.equalsIgnoreCase("fade"))
        			html_env.inEffect = 2;
        	}
        	if(decos.containsKey("out"))
        	{
        		String effect = decos.getStr("out");

        		if(effect.equalsIgnoreCase("blind"))
        			html_env.outEffect = 1;
        		if(effect.equalsIgnoreCase("fade"))
        			html_env.outEffect = 2;
        	}

        	if(decos.containsKey("panel"))
        	{
        		html_env.isPanel = true;
        	}
        	if(decos.containsKey("dispdiv"))
        	{
            	String dispdiv = decos.getStr("dispdiv");
            	if(dispdiv.contains("+"))
            	{
            		String tmp2 = dispdiv.substring(0,dispdiv.lastIndexOf("+"));
            		String tmp3 = dispdiv.substring(dispdiv.lastIndexOf("+")+1,dispdiv.length());

            		if(tmp3.compareTo("att") == 0)
            		{
            			html_env.ajaxtarget = tmp2 + "_" + this.getAtt("att");
            		}
            		else
            			html_env.ajaxtarget = dispdiv;
            	}
            	else
            	{
            		html_env.ajaxtarget = dispdiv;
            	}
            	html_env.has_dispdiv = true;
            	Log.out("html_env.ajaxtarget:"+html_env.ajaxtarget);
        	}
        	else if(decos.containsKey("dragto"))
        	{
        		Log.out("draggable = ture");
        		html_env.draggable = true;


        		//drag to
        		String value = decos.getStr("dragto");
    			String[] droptarget = new String[100];
    			int targetnum = 0;

        		if(value.contains("+"))
        		{
        			while(true)
        			{
        				if(!value.contains("+"))
        				{
        					droptarget[targetnum] = value;
        					targetnum++;
        					break;
        				}
        				droptarget[targetnum] = value.substring(0,value.indexOf("+"));
        				value = value.substring(value.indexOf("+")+1,value.length());

        				targetnum++;
        			}
        		}else
        			droptarget[0] = value;


        		//script ����
        		Date d1 = new Date();
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
        		String today = sdf.format(d1);

        		String scriptname = "drop"+today + html_env.scriptnum;
        		html_env.script.append(scriptname+" = new DragDrop(\""+
        				html_env.dragdivid+"\", \""+droptarget[0]+"\");\n");

        		Log.out(scriptname+" = new DragDrop(\""+
        				html_env.dragdivid+"\", \""+droptarget[0]+"\");\n");

        		//for tab
        		html_env.script.append(scriptname+".addToGroup(\"myTab\");\n");

        		for(int i = 1; i < targetnum ; ++i)
        		{
        			html_env.script.append(scriptname+".addToGroup(\""+droptarget[i]+"\");\n");
        		}

        		html_env.scriptnum++;
        	}
        }
        if(this.getArgs().get(0) instanceof FuncArg)
        {
        	Log.out("ARGS are function");
        	FuncArg fa = (FuncArg) this.getArgs().get(0);
        	fa.workAtt();
        }
        else
            this.workAtt("default");
        //tk//////////////////////////////////////////////////

        html_env.sinvoke_flag = false;
        return;
    }

    public static String opt(String s){
    	if(s.contains("\"")){
    		s = s.replaceAll("\"","");
    	}
    	if(s.startsWith("./")){
    		s = s.substring(2,s.length());
    	}
    	if(s.startsWith("/")){
    		s = s.substring(1,s.length());
    	}
    	return s;
    }

}