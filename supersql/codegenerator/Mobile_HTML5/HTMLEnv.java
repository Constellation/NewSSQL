package supersql.codegenerator.Mobile_HTML5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Vector;

import supersql.codegenerator.Connector;
import supersql.codegenerator.DecorateList;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.LocalEnv;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.parser.SSQLparser;

public class HTMLEnv extends LocalEnv {
    String data;

    String pre_operator;

    Vector written_classid;

    Connector connector;
    
    String title = "";		//added by goto 20130411  "title"
    String bg = "";			//added by goto 20130311  "background"
    int maxWidth = 350;		//added by goto 20130512  "max-width"	Default:350


    //Vector not_written_classid;
    Vector<String> not_written_classid= new Vector();

    int total_element = 0;

    int glevel = 0;

    String filename;

    String outfile;

    String linkoutfile;

    String nextbackfile = new String();

    String outdir;

    int countfile;

    PrintWriter writer;

    StringBuffer code;

    StringBuffer css;

	static int ID_counter=0;	//add oka

	static int ID_old=0;		//add oka
	
	String charset=null;					//added by goto 20120715
	static boolean charsetFlg=false;		//added by goto 20120715
	
    //tk start///////////////////////////////////////////////////
    StringBuffer meta = new StringBuffer();
    StringBuffer div = new StringBuffer();
    //StringBuffer title = new StringBuffer();		//disuse
    StringBuffer titleclass = new StringBuffer();
    StringBuffer cssfile = new StringBuffer();
    String tableborder=new String("1");
    boolean embedflag = false;
    int embedcount = 0;

    int haveClass = 0;

    //for ajax
    String ajaxquery = new String();
    String ajaxcond = new String();
    String ajaxatt = new String();
    String ajaxtarget = new String();
    int inEffect = 0;
    int outEffect = 0;
    boolean has_dispdiv = false;

    //for drag
    StringBuffer script = new StringBuffer();
    int scriptnum = 0;
    boolean draggable = false;
    String dragdivid = new String();

    //for panel
    boolean isPanel = false;
    //tk end//////////////////////////////////////////////////////

    StringBuffer header;

    StringBuffer footer;

    //20130503  Panel
    StringBuffer code1;
    StringBuffer code2;
    StringBuffer panel = new StringBuffer();
    int panelCount = 1;

    boolean foreach_flag;

    boolean sinvoke_flag = false;

    int link_flag;

    String linkurl;
    
    static int uiGridCount = 0;		//20130314  C1 ui-Grid用
    static int uiGridCount2 = 0;	//20130314  G1 ui-Grid用
    //static boolean tableFlg = false;		//20130314  table
    
    static int tabCount = 1;			//20130330  tab用
    //static boolean tabFlg = false;		//20130330  tab用
    static int maxTab = 15;				//20130330  tab用
    

    // ��?�Ѥ�CSS CLASS����?��?
    private String KeisenMode = "";

    public HTMLEnv() {
    }

    public String getEncode(){
    	if(getOs().contains("Windows")){
        	return "Shift_JIS";
    	}else{
    		return "EUC_JP";
    	}
    }

    public String getOs(){
    	String osname = System.getProperty("os.name");
    	return osname;
    }

    public void getHeader(int headerFlag) {		//[headerFlag] 1:通常、2:Prev/Next
   		int index = 0;
   		if(GlobalEnv.getframeworklist() == null){
	        header.insert(index,"<HEAD>\n");
	        header.insert(index,"<HTML>\n");
	        Log.out("<HTML>");
	        Log.out("<head>");
	        
	        //added by goto 20130508  "Login&Logout"
	        if(SSQLparser.sessionFlag)	header.insert(index,"<?php\n	session_start();\n?>\n");
	        
	        //Generator
	        header.append("<meta name=\"Generator\" content=\" SuperSQL (Generate Mobile_HTML5) \">\n");
	        
	        //added by goto 20120629
	        //header.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
	        
	        //changed by goto 20120622 start
	        //Log.out("<style type=text/css><!--");
   		}
        /*commonCSS();
        header.append(css);
        Log.out(css.toString());

        if(GlobalEnv.getframeworklist() == null)
        	header.append("--></STYLE>");*/
   		//changed by goto 20120622 end

        //tk start////////////////////////////////////////////////////
        header.append(meta);

        if(GlobalEnv.isAjax())
        {
        	String js = GlobalEnv.getJsDirectory();
        	if(js != null)
        	{
        		if(js.endsWith("/"))
        			js = js.substring(0,js.lastIndexOf("/"));

	        	header.append("<script src=\""+js+"/prototype.js\" type=\"text/javascript\"></script>\n");
	        	header.append("<script src=\""+js+"/ajax.js\" type=\"text/javascript\"></script>");

        	}
        	else
        	{
	        	header.append("<script src=\"http://localhost:8080/tab/prototype.js\" type=\"text/javascript\"></script>\n");
	        	header.append("<script src=\"http://localhost:8080/tab/ajax.js\" type=\"text/javascript\"></script>");
        	}

            header.append("<script type=\"text/javascript\" src=\"build/yahoo/yahoo-min.js\"></script>\n");
            header.append("<script type=\"text/javascript\" src=\"build/event/event-min.js\" ></script>\n");
            header.append("<script type=\"text/javascript\" src=\"build/dom/dom-min.js\"></script>\n");
            header.append("<script type=\"text/javascript\" src=\"build/dragdrop/dragdrop-min.js\" ></script>\n");
            header.append("<script type=\"text/javascript\" src=\"ssqlajax.js\" ></script>\n");
            header.append("<script type=\"text/javascript\" src=\"prototype.js\" ></script>\n");

            //for tab
            header.append("<script type=\"text/javascript\" src=\"build/element/element-beta.js\"></script>\n");
            header.append("<script type=\"text/javascript\" src=\"build/tabview/tabview.js\"></script>\n");

            //for panel
            header.append("<script type=\"text/javascript\" src=\"build/container/container.js\"></script>\n");

            //for animation
            header.append("<script type=\"text/javascript\" src=\"build/animation/animation.js\"></script>\n");

            //for lightbox
            header.append("<script type=\"text/javascript\" src=\"js/prototype.js\"></script>\n");
            header.append("<script type=\"text/javascript\" src=\"js/scriptaculous.js?load=effects\"></script>\n");
            header.append("<script type=\"text/javascript\" src=\"js/lightbox.js\"></script>\n");

            //for tab css
            header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"build/tabview/assets/border_tabs.css\">\n");
            header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"build/tabview/assets/tabview.css\">\n");

            //for panel css
            header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"build/container/assets/container.css\">\n");
            header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"build/container/assets/container.css\">\n");

            //for lightbox css
            header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/lightbox.css\"  media=\"screen\">\n");

            //for custom tab
            header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/tabview-core.css\"  media=\"screen\">\n");

            //for custom panel
            header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/panel.css\"  media=\"screen\">\n");

            header.append("<script type=\"text/javascript\">");
            header.append(script);
            header.append("</script>");
        }

        if(GlobalEnv.getframeworklist() == null){
            //added by goto 20130411  "title"
	        if (!title.equals(""))
	        	header.append("<title>"+title+"</title>\n");
	        
            //added by goto 20121217 start
        	header.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n");
        	
        	header.append(cssfile);
	        header.append("<STYLE TYPE=\"text/css\">\n");
	        header.append("<!--\n");
	        commonCSS();
	        header.append(css);
	        Log.out(css.toString());
	        header.append("\n-->\n</STYLE>\n");

	        header.append("<link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css\"/>\n");
            header.append("<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.css\"/>\n");
            //header.append("<link rel=\"stylesheet\" href="css/custom.css\"/>\n");
            //20130206
            //※※　要注意　※※　 jquery.jsより先にjquerymobile.jsをインポートすると、ボタン等の表示がうまくいかなくなる!!
            header.append("<script src=\"http://code.jquery.com/jquery-1.7.1.min.js\"></script>\n");
            header.append("<script src=\"http://code.jquery.com/ui/1.9.2/jquery-ui.min.js\"></script>\n");
            header.append("<script src=\"http://code.jquery.com/mobile/1.3.1/jquery.mobile-1.3.1.min.js\"></script>\n");
            //header.append("<script src=\"js/config.js\"></script>\n");

            //added by goto 20130110 start
            //for slideshow
            //header.append("<link href=\"js/photoswipe/photoswipe.css\" type=\"text/css\" rel=\"stylesheet\" />\n");
            //header.append("<link href=\"js/photoswipe/jquery-mobile.css\" type=\"text/css\" rel=\"stylesheet\" />\n");
       		//header.append("<script src=\"js/photoswipe/klass.min.js\"></script>\n");
       		//header.append("<script src=\"js/photoswipe/code.photoswipe.jquery-3.0.4.min.js\"></script>\n");
            header.append("<link href=\"http://www.db.ics.keio.ac.jp/ssqlcss/photoswipe/photoswipe.css\" type=\"text/css\" rel=\"stylesheet\" />\n");
            header.append("<link href=\"http://www.db.ics.keio.ac.jp/ssqljscss/photoswipe/jquery-mobile.css\" type=\"text/css\" rel=\"stylesheet\" />\n");
    		header.append("<script src=\"http://www.db.ics.keio.ac.jp/ssqljscss/photoswipe/klass.min.js\"></script>\n");
    		header.append("<script src=\"http://www.db.ics.keio.ac.jp/ssqljscss/photoswipe/code.photoswipe.jquery-3.0.4.min.js\"></script>\n");
            //added by goto 20130110 end
       		
    		//added by goto 20130413  "row Prev/Next"
//    		header.append("<script src=\"js/jquery.iframe-auto-height.plugin.js\"></script>\n");
//    		header.append("<script src=\"js/script2.js\"></script>\n");
    		header.append("<script src=\"http://www.db.ics.keio.ac.jp/ssqljscss/jquery.iframe-auto-height.plugin.js\"></script>\n");
    		header.append("<script src=\"http://www.db.ics.keio.ac.jp/ssqljscss/script2.js\"></script>\n");

    		
    		//added by goto 20130512  "max-width"
			header.append("<script type=\"text/javascript\"> var windowWidthThreshold = "+maxWidth+" </script>\n");
    		
    		header.append("<script src=\"js/script1.js\"></script>\n");
            //added by goto 20121217 end
            
            header.append("\n");
            
            //added by goto 20130311  "background"
	        if (!bg.equals("")){
	        	header.append("<style type=\"text/css\">");
	            header.append("<!-- .ui-page{ background: transparent url("+bg+") } -->");
	          	header.append("</style>\n");
	        }
	        
            //20130309  "div"
            header.append("<style type=\"text/css\">");
            header.append("<!-- div{ text-align:center; float:center; vertical-align:middle; } -->");
            //20130315	"長い文字が...と省略されるのを防ぐ (*:全てのタイプに適用) "
            header.append("<!-- * { white-space: normal; } -->");
          	header.append("</style>\n");

	        //added by goto 20130512  "Tableのセンタリング（画面横幅の大きいデバイスで見ると効果が分かる）"
//          	header.append("<style type=\"text/css\"><!-- table{ margin:auto; } --></style>\n");
            
            //20130206
            //下記は2013.02のSSQL教育で使用
            //※※　要注意　※※ generate mobileでは、ボタン等の表示に干渉してしまうため使用しない方が良い!!
//            header.append("<link href=\"http://www.db.ics.keio.ac.jp/ssqljscss/jquery-ui/css/ui-lightness/jquery-ui-1.9.2.custom.min.css\" type=\"text/css\" rel=\"stylesheet\" />\n");
//            header.append("<script src=\"http://code.jquery.com/jquery-1.7.1.min.js\"></script>\n");
//            header.append("<script src=\"http://www.db.ics.keio.ac.jp/ssqljscss/jquery-ui/js/jquery-ui-1.9.2.custom.min.js\" type=\"text/javascript\"></script>\n");
//            header.append("<script type=\"text/javascript\">\n");
//            header.append("$(function() {\n");
//            header.append("	$(\"[id=bounce]\").click(function() {\n");
//            header.append("		$(this).effect(\"bounce\", '', 1500);\n");
//         	  header.append("	});\n");
//            header.append("});\n");
//         	  header.append("</script>\n");
//            header.append("\n");
            
            
//            //20130205
              //下記は未完成
//            header.append("<script type=\"text/javascript\" src=\"interface.js\"></script>\n");
//            header.append("<script type=\"text/javascript\">" +
//            		"$(function(){" +
//            		"	$('#fisheye').Fisheye({" +
////            		"	$('[id=fisheye]').Fisheye({" +
//            		"		maxWidth: 80," +
//            		"		items: 'a'," +
//            		"		itemsText: 'span'," +
//            		"		container: '.fisheyeContainter'," +
//            		"		itemWidth: 80," +
//            		"		proximity: 90," +
//            		"		halign : 'center'" +
//            		"	})" +
//            		"})" +
//            		"</script>\n");
//            header.append("<style type=\"text/css\" media=\"all\">" +
//            		"#fisheye{" +
//            		"	margin-top:200px;" +
//            		"}" +
//            		".fisheye{" +
//            		"	text-align: center;" +
//            		"	height: 200px;" +
//            		"	position: relative;" +
//            		"}a.fisheyeItem{" +
//            		"	text-align: center;" +
//            		"	color: #000;" +
//            		"	font-weight: bold;" +
//            		"	text-decoration: none;" +
//            		"	width: 40px;" +
//            		"	position: absolute;" +
//            		"	display: block;" +
//            		"	top: 0;" +
//            		"}" +
//            		".fisheyeItem img{border: none;	margin: 0 auto 5px auto;	width: 100%;}" +
//            		".fisheyeItem span{	display: none;	positon: absolute;}" +
//            		".fisheyeContainter{height: 200px;	width: 700px;	position: absolute;}" +
//            		"</style>\n");
            

            
          	if(headerFlag==1){		//通常時のみ（Prev/Nextでは行わない）
	            //added by goto 20121222 start, changed by goto 20130110
	            //js/script1.jsの生成・書き込み
	            // TODO: 下記の場所を他へ変更（下記だと複数回生成・書き込みが行われる）
	            // TODO: -outdir?時の処理（下記は、出力先が.sqlファイル格納場所に限定）
	//            System.out.println("GlobalEnv.getfilename()="+GlobalEnv.getfilename());
	            String fileName=GlobalEnv.getfilename();
	            String fileDir = "";
	            if(fileName.contains("/")){
	            	//TODO: filename.substring(ファイル名)へ変更
	            	fileDir = fileName.substring(0,fileName.lastIndexOf("/"));
	            }else{
	            	//TODO: fileNameのカレントディレクトリの絶対パスを取得
	            	//fileDir = fileNameのカレントディレクトリの絶対パス
	            }
	            //		下記は、linkを使うときのみ有効 (commentted out by goto 20130110)
	            //      String fileDir = new File(linkurl).getAbsoluteFile().getParent();	//htm_env.~をcut
	//            System.out.println("fileDir= "+fileDir);
	//            String relative_path = linkurl.substring(fileDir.length()+1);
	            // 書き込むファイルの名前
	            //String outputFileName = "/Applications/XAMPP/htdocs/ssql/js/c2.js";
	            String outputFileName = fileDir + "/js/script1.js";
	//            System.out.println("outputFileName="+outputFileName);
	            // ファイルオブジェクトの生成
	            File outputFile = new File(outputFileName);
	            
	            File dir = outputFile.getParentFile();  
	            if (!dir.exists()) {
	                dir.mkdirs();   //make folders
	            }
	
	            try {
	              // 出力ストリームの生成
	//              FileOutputStream fos = new FileOutputStream(outputFile);
	//              OutputStreamWriter osw = new OutputStreamWriter(fos);
	//              PrintWriter pw = new PrintWriter(osw);
	              
	    	  		PrintWriter pw;
	    	        if (charset != null){
	    	        	pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
	    	        			new FileOutputStream(outputFile),charset)));
	    	        	//Log.info("File encoding: "+html_env.charset);
	    	        }else
	    	        	pw = new PrintWriter(new BufferedWriter(new FileWriter(
	    	        			outputFile)));
	              
	              	// ファイルへの書き込み
	    	        //画面サイズに応じて表示widthを変更		//added by goto 20130512
	    	        pw.println("\n/** 画面サイズに応じて表示widthを変更 **/\n" +
	    	        		"/** 画面width > 閾値 のとき、widthを固定して表示をセンタリング **/\n" +
	    	        		"//閾値(windowWidthThreshold)は、HTMLファイルの<head>で指定\n" +
	    	        		//"var windowWidthThreshold = 500; 	//閾値\n" +
	    	        		"//初期load時\n" +
	    	        		"$(document).ready(function(){\n" +
	    	        		"	if( $(window).width() > windowWidthThreshold ){\n" +
	    	        		"		//$(\"table\").css(\"width\",\"auto\");\n" +
	    	        		"		$(\"#header1\").css(\"width\",windowWidthThreshold).css(\"margin\",\"auto\");\n" +
	    	        		"		$(\"#content1\").css(\"width\",windowWidthThreshold).css(\"margin\",\"auto\");\n" +
	    	        		"		$(\"#footer1\").css(\"width\",windowWidthThreshold).css(\"margin\",\"auto\");\n" +
	    	        		"		$(\"#LOGINpanel1\").css(\"width\",windowWidthThreshold).css(\"margin\",\"auto\");\n" +
	    	        		"		$(\"#LOGOUTpanel1\").css(\"width\",windowWidthThreshold).css(\"margin\",\"auto\");\n" +
	    	        		"	}\n" +
	    	        		"});\n" +
	    	        		"//画面サイズが変更されたとき\n" +
	    	        		"window.onresize = function() {\n" +
	    	        		"	if( $(window).width() > windowWidthThreshold ){\n" +
	    	        		"    	//$(\"table\").css(\"width\",\"auto\");\n" +
	    	        		"		$(\"#header1\").css(\"width\",windowWidthThreshold).css(\"margin\",\"auto\");\n" +
	    	        		"		$(\"#content1\").css(\"width\",windowWidthThreshold).css(\"margin\",\"auto\");\n" +
	    	        		"		$(\"#footer1\").css(\"width\",windowWidthThreshold).css(\"margin\",\"auto\");\n" +
	    	        		"		$(\"#LOGINpanel1\").css(\"width\",windowWidthThreshold).css(\"margin\",\"auto\");\n" +
	    	        		"		$(\"#LOGOUTpanel1\").css(\"width\",windowWidthThreshold).css(\"margin\",\"auto\");\n" +
	    	        		"	}else{\n" +
	    	        		"		//$(\"table\").css(\"width\",\"100%\");\n" +
	    	        		"		$(\"#header1\").css(\"width\",\"100%\");\n" +
	    	        		"		$(\"#content1\").css(\"width\",\"100%\");\n" +
	    	        		"		$(\"#footer1\").css(\"width\",\"100%\");\n" +
	    	        		"		$(\"#LOGINpanel1\").css(\"width\",\"100%\");\n" +
	    	        		"		$(\"#LOGOUTpanel1\").css(\"width\",\"100%\");\n" +
	    	        		"	}\n" +
	    	        		"}\n\n");
	    	        //twitter
	              	pw.println("$(document).on(\"pagebeforecreate\",'[data-role=page]',function(e){\n" +
	              			"  $.ajaxSetup({cache : true});\n" +
	              			"  $.getScript('http://platform.twitter.com/widgets.js');\n" +
	              			"  $.ajaxSetup({cache : false});\n" +
	              			"});\n\n");
	              	//facebook
	              	pw.println("$(document).on('pageshow', '[data-role=page]', function(e) {\n" +
	              			"  var src = '//www.facebook.com/plugins/like.php?href=';\n" +
	              			"  src += encodeURIComponent(location.href);\n" +
	              			"  src += '&send=false&layout=button_count&width=200&show_faces=true&action=like&colorscheme=light&height=21';\n" +
	              			"  $('.like-btn').attr('src', src);\n" +
	              			"});\n\n");
	              	//bookmark
	              	pw.println("function addBookmark(title,url) {\n" +
	              			"	//IE\n" +
	              			"	if(navigator.userAgent.indexOf(\"MSIE\") > -1){\n" +
							"		window.external.AddFavorite(url, title);\n" +
							"	}\n" +
							"	//Firefox\n" +
							"	else if(navigator.userAgent.indexOf(\"Firefox\") > -1){\n" +
							"		window.sidebar.addPanel(title, url, \"\");\n" +
							"	}\n" +
							"	//Opera\n" +
							"	else if(navigator.userAgent.indexOf(\"Opera\") > -1){\n" +
							"		document.write('<div style=\"text-align:center\"><a href=\"'+url+'\" rel=\"sidebar\" title=\"'+title+'\">ブックマークに追加</a></div><br>');\n" +
							"	}\n" +
							"	//Netscape\n" +
							"	else if(navigator.userAgent.indexOf(\"Netscape\") > -1){\n" +
							"		document.write('<div style=\"text-align:center\"><input type=\"button\" value=\"ブックマークに追加\"');\n" +
							"		document.write(' onclick=\"window.sidebar.addPanel(\\''+title+'\\',\\''+url+'\\',\\'\\');\"></div><br>');\n" +
							"	}\n" +
							"	else{\n" +
							"    	alert(\"このブラウザへのお気に入り追加ボタンは、Chrome/Safari等には対応しておりません。\\nChrome/Safariの場合、CtrlキーとDキーを同時に押してください。\\nその他の場合はご自身のブラウザからお気に入りへ追加下さい。\");\n" +
							"  	}\n" +
							"}\n");
	              	//added by goto 20130110
	              	//slideshow
	              	pw.println("$(document).on('pageshow', '#p-gallery', function(e){\n" +
	              			"	var currentPage = $(e.target);\n" +
	              			"	photoSwipeInstance = $(\"ul.gallery a\", e.target).photoSwipe({},  currentPage.attr('id'));\n" +
	              			"}).on('pagehide', '#p-gallery', function(e){\n" +
	              			"	var currentPage = $(e.target),\n" +
	              			"	photoSwipeInstance = window.Code.PhotoSwipe.getInstance(currentPage.attr('id'));\n" +
	              			"	if (typeof photoSwipeInstance != \"undefined\" && photoSwipeInstance != null) {\n" +
	              			"		window.Code.PhotoSwipe.detatch(photoSwipeInstance);\n" +
	              			"	}\n" +
	              			"});\n");
	              	
	              	//added by goto 20130330
	              	//tab
	              	pw.println("$(document).ready(function() {\n" +
	              			"	$( \"[id=tabs]\" ).tabs();\n" +
	//              			"	$( \"#tabs\" ).tabs();\n" +
	              			"});\n");
	              	
	//              	//added by goto 20130503
	//              	//panel
	//              	pw.println("$(document).on('click',\"button.open\",function(){\n" +
	//              			"	$(\"[id=ssqlpanel]\").panel(\"open\")\n" +
	//      					"}).on('click',\"button.close\",function(){\n" +
	//						"	$(\"[id=ssqlpanel]\").panel(\"close\")\n" +
	//						"});\n");
	              
	              	// 後始末
	              	pw.close();
	            // エラーがあった場合は、スタックトレースを出力
	            } catch(Exception e) {
	            	e.printStackTrace();
	            }
	            //added by goto 20121222 end
          	}//通常のみの処理（jsファイル作成）end
        	
	        header.append("</HEAD>\n");

	        //header.append("<BODY class=\"body\">\n");
	        header.append("<BODY>\n");
	        header.append("<!-- data-role=page start -->\n<div data-role=\"page\">\n\n");
	        
	        //added by goto 20130508  "Login&Logout" start
	        //ログイン・ログアウト・新規登録
	        if(SSQLparser.sessionFlag){
	        	String s = SSQLparser.sessionString;
	        	//Log.i("s:" + s);
	        	String DB = GlobalEnv.getdbname();										//DB
	        	String c1str = "ID:";													//ID string
	        	String c1 = s.substring(s.indexOf("(")+1,s.indexOf(",")).trim();		//ID column
	        	if(c1.contains(":")){
	        		c1str = c1.substring(0,c1.lastIndexOf(":")+1);
	        		c1 = c1.substring(c1.lastIndexOf(":")+1).trim();
	        	}
	        	String c2str = "Password";												//PW string
	        	String c2 = s.substring(s.indexOf(",")+1,s.lastIndexOf(",")).trim();	//PW column
	        	if(c2.contains(":")){
	        		c2str = c2.substring(0,c2.lastIndexOf(":"));
	        		c2 = c2.substring(c2.lastIndexOf(":")+1).trim();
	        	}
	        	String from = s.substring(s.lastIndexOf(",")+1,s.indexOf(")")).trim();	//FROM
	        	String DBMS = GlobalEnv.getdbms();										//DBMS
	        	//Log.i(c1str+c1+"   "+c2str+c2+"   from:"+from+"   DB:"+DB+"	DBMS:"+DBMS);
	        	
	        	//sqlite3 php
	        	if(DBMS.equals("sqlite3")){
	        		header.append("\n" +
	        				"<!-- \"Login & Logout\" start -->\n" +
	        				"<?php\n" +
	        				"//最初にログイン中かどうか判定\n" +
	        				"if($_SESSION[id] != \"\"){\n" +
	        				"?>\n" +
	        				"	<script type=\"text/javascript\">\n" +
	        				"	$(document).ready(function(){\n" +
	        				"		$('#login1').attr('checked', 'checked');	//load時\n" +
	        				"		$('#LOGINpanel1').hide();\n" +
	        				"	});\n" +
	        				"	</script>\n" +
	        				"<?php\n" +
	        				"	display_html();								//display_html\n" +
	        				"}else{\n" +
	        				"?>\n" +
	        				"	<script type=\"text/javascript\">\n" +
	        				"	$(document).ready(function(){\n" +
	        				"		$('#LOGOUTpanel1').hide();\n" +
	        				"	});\n" +
	        				"	</script>\n" +
	        				"<?php\n" +
	        				"}\n" +
	        				"?>\n" +
	        				"\n" +
	        				"<!-- Login & Registration start -->\n" +
	        				"<!-- Login Panel start -->\n" +
	        				"<br>\n" +
	        				"<div id=\"LOGINpanel1\" style=\"background-color:whitesmoke; width:100%; border-radius:20px; border:5px gray solid;\" data-role=\"none\">\n" +
	        				"<div style=\"color:lightgray; font-size:30; background-color:black; border-radius:15px 15px 0px 0px;\" id=\"loginTitle1\">Log in</div>\n" +
	        				"<br>\n" +
	        				"<form method=\"post\" action=\"\" target=\"login_ifr1\">\n" +
	        				"<div>\n" +
	        				"	<div style=\"font-size:20;\">"+c1str+"&nbsp;&nbsp;</div>\n" +
	        				"	<input type=\"text\" name=\"id\" style=\"width:100%;\" data-mini=\"true\">\n" +
	        				"	<fieldset data-role=\"controlgroup\" data-type=\"horizontal\" data-mini=\"true\">\n" +
	        				"		<input type=\"radio\" name=\"choose\" id=\"login1\" value=\"login1\" checked=\"checked\">\n" +
	        				"	    <label for=\"login1\">I have an account</label>\n" +
	        				"		<input type=\"radio\" name=\"choose\" id=\"signup1\">\n" +
	        				"		<label for=\"signup1\"> I am new!</label>\n" +
	        				"	</fieldset>\n" +
	        				"</div>\n" +
	        				"<div id=\"login_block\">\n" +
	        				"	<div style=\"font-size:20;\">"+c2str+":&nbsp;&nbsp;&nbsp;</div>\n" +
	        				"	<input type=\"password\" name=\"password\" id=\"password\" style=\"width:100%;\" data-mini=\"true\">\n" +
	        				"	<input type=\"submit\" value=\" Login \" name=\"sqlite3_login1\" id=\"sqlite3_login1\" data-mini=\"false\" data-inline=\"false\">\n" +
	        				"</div>\n" +
	        				"<div id=\"signup_block\" style=\"display:none\" data-role=\"none\">\n" +
	        				"	<div style=\"font-size:20;\">Choose "+c2str+":&nbsp;&nbsp;</div>\n" +
	        				"	<input type=\"password\" name=\"newpassword\" id=\"newpassword\" style=\"width:100%;\" data-mini=\"true\">\n" +
	        				"	<div style=\"font-size:20;\">Reinput "+c2str+":&nbsp;&nbsp;</div>\n" +
	        				"	<input type=\"password\" name=\"re_newpassword\" id=\"re_newpassword\" style=\"width:100%;\" data-mini=\"true\">\n" +
	        				"	<input type=\"submit\" value=\" Signup \" name=\"sqlite3_login1\" id=\"sqlite3_login1\" data-mini=\"false\" data-inline=\"false\">\n" +
	        				"</div>\n" +
	        				"</form>\n" +
	        				"\n" +
	        				"<iframe name=\"login_ifr1\" style=\"display:none;\"></iframe>\n" +
	        				"<p id=\"Login_text1\"  data-role=\"none\"><!-- ここに表示 --></p>\n" +
	        				"<br>\n" +
	        				"</div>\n" +
	        				"<!-- Login Panel end -->\n" +
	        				"\n" +
	        				"<?php\n" +
	        				"//Login or Registration\n" +
	        				"if($_POST['sqlite3_login1']){\n" +
	        				"	//ユーザ定義\n" +
	        				"	$sqlite3_DB = '"+DB+"';\n" +
	        				"	$sqlite3_id = '"+c1+"';\n" +
	        				"	$sqlite3_pw = '"+c2+"';\n" +
	        				"	$sqlite3_table = '"+from+"';\n" +
	        				"\n" +
	        				"	$id = $_POST['id'];\n" +
	        				"	$pw = $_POST['password'];\n" +
	        				"	$newpw = $_POST['newpassword'];\n" +
	        				"	$re_newpw = $_POST['re_newpassword'];\n" +
	        				"\n" +
	        				"	if($pw && $id){\n" +
	        				"		//Login\n" +
	        				"   		$db = new SQLite3($sqlite3_DB);\n" +
	        				"		$sql = \"SELECT \".$sqlite3_id.\",\".$sqlite3_pw.\" FROM \".$sqlite3_table.\" where \".$sqlite3_id.\"='\".$id.\"' and \".$sqlite3_pw.\"='\".$pw.\"'\";\n" +
	        				"	    $result = $db->query($sql);\n" +
	        				"	    $i = 0;\n" +
	        				"	    while($res = $result->fetchArray(SQLITE3_ASSOC)){\n" +
	        				"	          $i++;\n" +
	        				"	          if($i==1)	break;\n" +
	        				"	    }\n" +
	        				"	    if($i == 0)	p('<font color=#ff0000>Login failed.</font>');	//Login failed.\n" +
	        				"	    else{\n" +
	        				"	    	//Login success.\n" +
	        				"	    	$_SESSION[id] = $id;\n" +
	        				"			echo '<script type=\"text/javascript\">window.parent.$(\\'#Login_text1\\').text(\"\");</script>';\n" +
	        				"			echo '<script type=\"text/javascript\">window.parent.history.go(0);</script>';	//reload\n" +
	        				"	    }\n" +
	        				"	}else if($newpw && $re_newpw && $id){\n" +
	        				"		//check (pw==re_pw)?\n" +
	        				"		if($newpw != $re_newpw){\n" +
	        				"			p('<font color=#ff0000>Please input the same "+c2str+".</font>');	//PW is not equal\n" +
	        				"		}else{\n" +
	        				
	        				"			//check & registration\n" +
	        				"			$db = new SQLite3($sqlite3_DB);\n" +
	        				"			\n" +
	        				"			//check\n" +
	        				"			$sql1 = \"SELECT \".$sqlite3_id.\" FROM \".$sqlite3_table.\" where \".$sqlite3_id.\"='\".$id.\"'\";\n" +
	        				"		    $result1 = $db->query($sql1);\n" +
	        				"		    $i=0;\n" +
	        				"		    while($res = $result1->fetchArray(SQLITE3_ASSOC)){\n" +
	        				"	   	       $i++;\n" +
	        				"	   	       if($i==1)	break;\n" +
	        				"		    }\n" +
	        				"		    if($i > 0)	p('<font color=#ff0000>\\\''.$id.'\\\' has been already registered.</font>');	//already registered.\n" +
	        				"		    else{\n" +
	        				"	   	       //registration\n" +
	        				"	   	       $sql2 = \"INSERT INTO \".$sqlite3_table.\" (\".$sqlite3_id.\", \".$sqlite3_pw.\") VALUES ('\".$id.\"','\".$newpw.\"')\";\n" +
	        				"	   	       try{\n" +
	        				"					$result2 = $db->exec($sql2);\n" +
	        				"					p('<font color=gold>Registration Success!!</font>');\n" +
	        				"	   	       }catch(Exception $e){\n" +
	        				"					p('<font color=#ff0000>Registration failed.</font>'.$e->getMessage());\n" +
	        				"	   	       }\n" +
	        				"		    }\n" +
	        				
	        				"		}\n" +
	        				"	}else{\n" +
	        				"		p('<font color=#ff0000>Please input form.</font>');\n" +
	        				"	}\n" +
	        				"	unset($db);\n" +
	        				"}\n" +
	        				"function p($str){\n" +
	        				"	//親ウインドウのJavaScript関数（テキストエリアへ書き込み）を呼び出す\n" +
	        				"	echo '<script type=\"text/javascript\">window.parent.Login_echo1(\"'.$str.'\");</script>';\n" +
	        				"}\n" +
	        				"?>\n" +
	        				"\n" +
	        				"<script type=\"text/javascript\">\n" +
	        				"$(document).ready(function(){\n" +
	        				"	//アカウントあり or 新規登録 クリック時の処理\n" +
	        				"	$('#signup1').click(function(){\n" +
	        				"		$('#loginTitle1').text('Sign up');\n" +
	        				"		$('#password').val('');\n" +
	        				"		$('#login_block').hide();\n" +
	        				"		$('#signup_block').show();\n" +
	        				"		Login_echo1(\"\");\n" +
	        				"	});\n" +
	        				"	$('#login1').click(function(){\n" +
	        				"		$('#loginTitle1').text('Log in');\n" +
	        				"		$('#newpassword').val('');\n" +
	        				"		$('#re_newpassword').val('');\n" +
	        				"		$('#signup_block').hide();\n" +
	        				"		$('#login_block').show();\n" +
	        				"		Login_echo1(\"\");\n" +
	        				"	});\n" +
	        				"});\n" +
	        				"\n" +
	        				"//テキストエリアへ書き込み\n" +
	        				"function Login_echo1(str){\n" +
	        				"  var textArea = document.getElementById(\"Login_text1\");\n" +
	        				"  textArea.innerHTML = \"<h2>\" + str + \"</h2>\";\n" +
	        				"}\n" +
	        				"</script>\n" +
	        				"<!-- Login & Registration end -->\n" +
	        				"\n" +
	        				"\n");
	        				
    				//ログアウトボタンの付加
	        		if(headerFlag==1)		//通常時のみ（Prev/Nextでは行わない）
    				header.append(
	        				"<!-- Logout start -->\n" +
	        				"<form method=\"post\" action=\"\" target=\"logout_ifr1\" id=\"LOGOUTpanel1\" name=\"LOGOUTpanel1\">\n" +
	        				"<input type=\"submit\" value=\" Logout \" name=\"sqlite3_logout1\" data-mini=\"false\" data-inline=\"false\">\n" +
	        				"<input type=\"hidden\" value=\" Logout \" name=\"sqlite3_logout1\">\n" +
	        				"</form>\n" +
	        				"<iframe name=\"logout_ifr1\" style=\"display:none;\"></iframe>\n" +
	        				"\n" +
	        				"<?php\n" +
	        				"if($_POST['sqlite3_logout1']){\n" +
	        				"	//ログアウト処理\n" +
	        				"	//セッション変数を全て解除\n" +
	        				"	$_SESSION = array();\n" +
	        				"	//セッションを切断するにはセッションクッキーも削除\n" +
	        				"	//Note: セッション情報だけでなくセッションを破壊\n" +
	        				"	if (isset($_COOKIE[session_name()])) {\n" +
	        				"    	setcookie(session_name(), '', time()-42000, '/');\n" +
	        				"	}\n" +
	        				"	session_destroy();\n" +
	        				"	echo '<script type=\"text/javascript\">window.parent.history.go(0);</script>';	//reload\n" +
	        				"}\n" +
	        				"?>\n" +
	        				"<!-- Logout end -->\n");
	        				
					header.append(
	        				"<!-- \"Login & Logout\" end -->\n" +
	        				"\n" +
	        				"\n" +
	        				"<?php\n" +
	        				"//<!-- display_html start -->\n" +
	        				"function display_html(){\n" +
	        				"	if($_SESSION[id] != \"\"){\n" +
	        				"		echo <<<EOF\n" +
	        				"		\n");
	        	}
	        	//else if(DBMS.equals("postgresql")){
	        	//	;
	        	//}
	        }
	        //added by goto 20130508  "Login&Logout" end
	        
	        if(headerFlag==1){		//通常時のみ（Prev/Nextでは行わない）
		        if(HTMLFunction.headerString != ""){		//data-role="header"
		        	header.append("\n<!-- data-role=header start -->\n"
						+HTMLFunction.headerString+"<!-- data-role=header end -->\n\n\n");
		        }
	        }
	        //data-role="content"
	        header.append("<!-- data-role=content start -->\n<div data-role=\"content\" style=\"padding:0\" id=\"content1\">\n");

	        //commented out by goto  201203
//	        header.append("<div");
//	        header.append(div);
//	        header.append(titleclass);
//	        header.append(">");
	        //header.append(title);		//disuse
	        //tk end///////////////////////////////////////////////////////
	        //chie//

	        Log.out("--></style></head>");
	        Log.out("<body>");
        }

        if(Connector.loginFlag ){
        	header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/servlet/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
        	//header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
        	header.append("<input type=\"hidden\" name=\"tableinfo\" value=\"" + SSQLparser.get_from_info_st() + "\" >");
        	header.append("<input type=\"hidden\" name=\"configfile\" value=\"" + GlobalEnv.getconfigfile() + "\" >");
        }

        if(Connector.logoutFlag ){
        	header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/servlet/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
        	//header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
        	//header.append("<input type=\"hidden\" name=\"tableinfo\" value=\"" + SSQLparser.get_from_info_st() + "\" >");
        	header.append("<input type=\"hidden\" name=\"configfile\" value=\"" + GlobalEnv.getconfigfile() + "\" >");
        }


        if(Connector.insertFlag || Connector.deleteFlag || Connector.updateFlag){
        	header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/servlet/supersql.form.Update\" method = \"post\" name=\"theForm\">\n");
        	//header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/supersql.form.Update\" method = \"post\" name=\"theForm\">\n");
        	header.append("<input type=\"hidden\" name=\"tableinfo\" value=\"" + SSQLparser.get_from_info_st() + "\" >");
        	header.append("<input type=\"hidden\" name=\"configfile\" value=\"" + GlobalEnv.getconfigfile() + "\" >");
        	if(Connector.insertFlag)
        		header.append("<input type=\"hidden\" name=\"sql_param\" value=\"insert\" >");
        	if(Connector.deleteFlag)
        		header.append("<input type=\"hidden\" name=\"sql_param\" value=\"delete\" >");
        	if(Connector.updateFlag)
            	header.append("<input type=\"hidden\" name=\"sql_param\" value=\"update\" >");
        }

    }

    private void commonCSS() {
        //        header.append("TABLE {border-collapse:collapse; table-layout:fixed; border:none; height:100%;}\n");


    	//tk modified
    	//header.append(".nest { height:100%;z-index: 1}\n");
        //header.append(".nest { position : relative ; top ; 5px ; }");
    	//header.append(".nest {top : 5px ;}");

    	//comment out 200805 chie
    	//header.append(".nest {top : 5px ; vertical-align : top;}");

    	//        header.append(".outline { border: 2px solid gray; height:auto;}\n");
      	//        header.append("TD { padding: 0;}\n");
        //        header.append("TD.tate { border-top: 2px solid gray;}\n");
        //        header.append("TD.top { border-top: none;}\n");
        //        header.append("TD.yoko { border-left: 2px solid gray;}\n");
        //        header.append("TD.left { border-left: none;}\n");
        //tk//
    	if(!GlobalEnv.isOpt()){
        header.append(".att { padding: 0px; margin : 0px;height : 100%; z-index: 2}\n");
        header.append(".linkbutton {text-align:center; margin-top: 5px; padding:5px;}\n");
        header.append(".embed { vertical-align : text-top; padding : 0px ; margin : 0px; border: 0px,0px,0px,0px; width: 100%; }\n");
        header.append(".noborder { border-width : 0px; " +
        		"margin-top : -1px; padding-top : -1px; " +
        		"margin-bottom : -1px; padding-bottom : -1px; }\n");
    	}
    }

    public void getFooter(int footerFlag) {		//[headerFlag] 1:通常、2:Prev/Next
    	if(Connector.updateFlag || Connector.insertFlag|| Connector.deleteFlag || Connector.loginFlag ){
	    	footer.append("<input type=\"submit\" name=\"login\" value=\"Let's go!\">");
	    	footer.append("</form>\n");
	    	Log.out("</form>");
        	Connector.updateFlag = false;
        	Connector.insertFlag = false;
        	Connector.deleteFlag = false;
        	Connector.loginFlag = false;
    	}

    	if(Connector.logoutFlag ){
	    	footer.append("</form>\n");
	    	Log.out("</form>");
        	Connector.logoutFlag = false;
    	}

    	if(GlobalEnv.getframeworklist() == null){
    		footer.append("</div><!-- Close <div data-role=\"content\"> -->\n<!-- data-role=content end -->\n");		//Close <div data-role="content">
    		//data-role="footer"
    		if(HTMLFunction.footerString != "" && footerFlag==1)	//通常時のみ（Prev/Nextでは行わない）
    			footer.append("\n\n<!-- data-role=footer start -->\n"+HTMLFunction.footerString+"<!-- data-role=footer end -->\n\n");
    		if(panel.length() != 0)															//20130503  Panel
    			footer.append("\n<!-- Panel start -->\n"+panel+"\n<!-- Panel end -->\n\n");	//Add panel contents.	
    		//added by goto 20130508  "Login&Logout"
    		if(SSQLparser.sessionFlag){
    			footer.append("\n" +
    					"EOF;\n" +
    					"	}//end if\n" +
    					"}//end function\n" +
    					"//<!-- display_html end -->\n" +
    					"?>\n");
    		}//else
    		if(footerFlag==1)		//通常時のみ（Prev/Nextでは行わない）
    			footer.append("\n<BR><BR>\n");
    		footer.append("</div><!-- Close <div data-role=\"page\"> -->\n<!-- data-role=page end -->\n");			//Close <div data-role="page">
    		footer.append("\n</BODY>\n</HTML>\n");
	        Log.out("</body></html>");
    	}
    }

    public void append_css_def_td(String classid, DecorateList decos) {
    	haveClass=0;
    	Log.out("[HTML append_css_def_att] classid=" + classid);
        Log.out("decos = " + decos);

        //��classid�Υ�����?�����Ȥ��������ꤷ�����Ȥ���?��
        if (written_classid.contains(classid)) {
            // �����?�ѤΥ�����?������
        	haveClass=1;
            Log.out("==> already created style");
            return;
        }else if(not_written_classid != null && not_written_classid.contains(classid)){
        	Log.out("==> style is null. not created style");
            return;
        }

        Log.out("==> new style");
        Log.out("@@ creating style no " + classid);

        StringBuffer cssbuf = new StringBuffer();

        //tk start////////////////////////////////////////////////////////////////
        StringBuffer metabuf = new StringBuffer();

        if (decos.containsKey("class")){
        	cssclass.put(classid,decos.getStr("class"));
        	Log.out("class =" + classid + decos.getStr("class"));
        }


        if(decos.containsKey("cssfile")){
        	cssfile.delete(0,cssfile.length());
        	if(GlobalEnv.isServlet()){
            	cssfile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + GlobalEnv.getFileDirectory() + decos.getStr("cssfile") + "\">\n");
            }else{
            	cssfile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + decos.getStr("cssfile") + "\">\n");
            }
        }else if(cssfile.length() == 0){
        	if(GlobalEnv.isServlet()){
            	cssfile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + GlobalEnv.getFileDirectory() +"/default.css \">\n");
            }else{
            	if(getOs().contains("Windows")){
            		cssfile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"default.css\">\n");
            	}else{
            		//commented out by goto 201303
//            		//itc
//            		if(GlobalEnv.isOpt())
//            			cssfile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.db.ics.keio.ac.jp/ssqljscss/default_opt.css\">\n");
//            		else
//            			cssfile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.db.ics.keio.ac.jp/ssqljscss/default.css\">\n");
            	}
            }
        }

        if (decos.containsKey("divalign") && div.length() == 0)
        	div.append(" align=" +decos.getStr("divalign"));

        //if (decos.containsKey("title") && title.length() == 0)	//disuse
        //	title.append(decos.getStr("title"));
        if (decos.containsKey("title_class"))
        	titleclass.append(" class=\""+decos.getStr("title_class")+"\"");
        if (decos.containsKey("tableborder") )//&& tableborder.length() == 0)
        	tableborder = decos.getStr("tableborder");

        //tk end//////////////////////////////////////////////////////////////

        // ��??
        if (decos.containsKey("width")) {
        	if(GlobalEnv.getframeworklist() == null)
        		cssbuf.append(" width:" + decos.getStr("width") + ";");
        	else
        		cssbuf.append(" width:" + decos.getStr("width") + "px;");
            //        } else {
            //            cssbuf.append(" width:120;");
        }

        // ��??
        if (decos.containsKey("height")){
        	if(GlobalEnv.getframeworklist() == null)
        		cssbuf.append(" height:" + decos.getStr("height") + ";");
        	else
        		cssbuf.append(" height:" + decos.getStr("height") + "px;");
        }


     // margin
        if (decos.containsKey("margin")) {
            cssbuf.append(" margin:" + decos.getStr("margin") + ";");
            //        } else {
            //            cssbuf.append(" padding:0.3em;");
        }

        // �ѥǥ��󥰡�;���
        if (decos.containsKey("padding")) {
            cssbuf.append(" padding:" + decos.getStr("padding") + ";");
            //        } else {
            //            cssbuf.append(" padding:0.3em;");
        }
        //padding
        if (decos.containsKey("padding-left")) {
            cssbuf.append(" padding-left:" + decos.getStr("padding-left") + ";");
        }
        if (decos.containsKey("padding-top")) {
            cssbuf.append(" padding-top:" + decos.getStr("padding-top") + ";");
        }
        if (decos.containsKey("padding-right")) {
            cssbuf.append(" padding-right:" + decos.getStr("padding-right") + ";");
        }
        if (decos.containsKey("padding-bottom")) {
            cssbuf.append(" padding-bottom:" + decos.getStr("padding-bottom") + ";");
        }

        // ������
        if (decos.containsKey("align"))
            cssbuf.append(" text-align:" + decos.getStr("align") + ";");

        // �İ���
        if (decos.containsKey("valign"))
            cssbuf.append(" vertical-align:" + decos.getStr("valign") + ";");

        // �طʿ�
        if (decos.containsKey("background-color"))
            cssbuf.append(" background-color:"
                    + decos.getStr("background-color") + ";");
        if (decos.containsKey("bgcolor"))
            cssbuf.append(" background-color:" + decos.getStr("bgcolor") + ";");

        // ʸ��
        if (decos.containsKey("color"))
            cssbuf.append(" color:" + decos.getStr("color") + ";");
        if (decos.containsKey("font-color"))
            cssbuf.append(" color:" + decos.getStr("font-color") + ";");
        if (decos.containsKey("font color"))
            cssbuf.append(" color:" + decos.getStr("font color") + ";");

        // ʸ����
        if (decos.containsKey("font-size"))
        	if(GlobalEnv.getframeworklist() == null)
        		cssbuf.append(" font-size:" + decos.getStr("font-size") + ";");
        	else
        		cssbuf.append(" font-size:" + decos.getStr("font-size") + "px;");
        if (decos.containsKey("font size"))
        	if(GlobalEnv.getframeworklist() == null)
        		cssbuf.append(" font-size:" + decos.getStr("font size") + ";");
        	else
        		cssbuf.append(" font-size:" + decos.getStr("font size") + "px;");
        if (decos.containsKey("size"))
        	if(GlobalEnv.getframeworklist() == null)
        		cssbuf.append(" font-size:" + decos.getStr("size") + ";");
        	else
        		cssbuf.append(" font-size:" + decos.getStr("size") + "px;");

        // ʸ�������
        if (decos.containsKey("font-weight"))
            cssbuf.append(" font-weight:" + decos.getStr("font-weight") + ";");

        // ʸ����?
        if (decos.containsKey("font-style"))
            cssbuf.append(" font-style:" + decos.getStr("font-style") + ";");
        if (decos.containsKey("font-family"))
            cssbuf.append(" font-family:" + decos.getStr("font-family") + ";");

        if(decos.containsKey("border"))
        	cssbuf.append(" border:" + decos.getStr("border")+";");
        if(decos.containsKey("border-width"))
        	cssbuf.append(" border-width:" + decos.getStr("border-width")+";");
        if(decos.containsKey("border-color"))
        	cssbuf.append(" border-color:" + decos.getStr("border-color")+";");
        if(decos.containsKey("border-style"))
        	cssbuf.append(" border-style:" + decos.getStr("border-style")+";");
        if(decos.containsKey("border-collapse"))
        	cssbuf.append(" border-collapse:" + decos.getStr("border-collapse")+";");

        //tk start////////////////////////////////////////////////////////////////
        //added by goto 20120715 start
//      if (decos.containsKey("charset"))
//      metabuf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + decos.getStr("charset") + "\">");
////      else
////       	metabuf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-jp\">");
        if (decos.containsKey("charset"))
            charset=decos.getStr("charset");
        else if(!charsetFlg)
        		charset="UTF-8";		//default charset = UTF-8
        if(!charsetFlg && charset!=null){
        	//changed by goto 20130110 start
        	//metabuf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + charset + "\">");
        	metabuf.append("<meta charset=\"" + charset + "\">");
        	//changed by goto 20130110 end
        	charsetFlg=true;
        }
//        if (decos.containsKey("charset")){
//            metabuf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + decos.getStr("charset") + "\">");
//            charset=decos.getStr("charset");
//            charsetFlg=1;
//        }else if(charsetFlg!=1){
//        		metabuf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-JP\">");
//        		charset="EUC-JP";		//default charset = EUC-JP
//        		charsetFlg=1;
//      	}
        //added by goto 20120715 end
        
        //added by goto 20130501  "style"
        if (decos.containsKey("style")){
        	String style = decos.getStr("style");
        	cssbuf.append(" " + style);
        	if(!style.matches(".*;\\s*$"))	cssbuf.append(";");	//最後に";"が無かった場合
        }
        
        //added by goto 20130411  "title"
        if (decos.containsKey("title"))
        	title = decos.getStr("title");
        
        //added by goto 20130311  "background"
        if (decos.containsKey("background"))
        	bg = decos.getStr("background");
        
        //added by goto 20130512  "max-width"
        try{
	        if (decos.containsKey("max-width"))
	        	maxWidth = Integer.parseInt(decos.getStr("max-width"));
	        else if (decos.containsKey("maxwidth"))
	        	maxWidth = Integer.parseInt(decos.getStr("maxwidth"));
        }catch(Exception e){ /*数値以外*/ }
        
        if (decos.containsKey("description"))
            metabuf.append("\n<meta name=\"Description\" content=\"" + decos.getStr("description") + "\">");
        if (decos.containsKey("keyword"))
            metabuf.append("\n<meta name=\"Keyword\" content=\"" + decos.getStr("keyword") + "\">");
        if (decos.containsKey("author"))
        	metabuf.append("\n<meta name=\"Author\" content=\"" + decos.getStr("author") + "\">");
        if (decos.containsKey("copyright"))
        	metabuf.append("\n<meta name=\"Copyright\" content=\"" + decos.getStr("copyright") + "\">");
        if (decos.containsKey("pragma"))
            metabuf.append("\n<meta http-equiv=\"Pragma\" content=\"" + decos.getStr("pragma") + "\">");
        if (decos.containsKey("robot"))
            metabuf.append("\n<meta name=\"Robot\" content=\"" + decos.getStr("robot") + "\">");
        //tk end///////////////////////////////////////////////////////////////////

        if (cssbuf.length() > 0) {
        	haveClass = 1;
            //����?�Υ�����?����
            css.append("." + classid + "{");

            css.append(cssbuf);
            //��?�Υ�����?�Ĥ�
            css.append(" }\n");

            //������?��?�Ѥߥ��饹��id����¸���Ƥ���
            written_classid.addElement(classid);
        }else{
        	Log.out("==> style is null. not created style");
        	not_written_classid.addElement(classid);
        }

        //tk start//////////////////////////////////////////////////////////
        if(metabuf.length() > 0)
        {
            //meta.append(" ");		//commented out by goto 201303
            meta.append(metabuf);
         	meta.append("\n");

        }
       //tk end////////////////////////////////////////////////////////////


    }

    // outline����Ϥ�?���ɤ����Υե饰��?
    boolean OutlineMode = false;

    public void setOutlineMode() {
        OutlineMode = true;
    }

    public String getOutlineMode() {
        if (OutlineMode) {
            OutlineMode = false;
            return "";
        }
//        return " frame=void class=nest ";
      return " frame=void ";
    }

    public String getOutlineModeAtt() {
        if (OutlineMode) {
            OutlineMode = false;
            return " outline";
        }
        return "";
    }

    public static String getClassID(ITFE tfe) {
    	String result;
        if (tfe instanceof HTMLC3) {
            result = getClassID(((ITFE) ((HTMLC3) tfe).tfes.get(0)));
            return result;
        }
        if (tfe instanceof HTMLG3) {
            result = getClassID(((ITFE) ((HTMLG3) tfe).tfe));
            	return result;
        }
        result =  "TFE" + tfe.getId();
        	return result;
    }

    /***start oka***/
    public static String getDataID(ITFE tfe) {
    	String ClassID;
    	int DataID = 0;
    	String return_value;

        if (tfe instanceof HTMLC3) {
            return getClassID(((ITFE) ((HTMLC3) tfe).tfes.get(0)));
        }
        if (tfe instanceof HTMLG3) {
            return getClassID(((ITFE) ((HTMLG3) tfe).tfe));
        }
        ClassID = String.valueOf(tfe.getId());
        DataID = Integer.valueOf((ClassID.substring(ClassID.length()-3,ClassID.length()))).intValue();

        Log.out("ClassID="+ClassID);
        Log.out("DataID="+DataID);
        Log.out("ID_counter="+ID_counter);

        if(DataID < ID_old){
        	ID_counter = DataID;
        }
        else{
        	if(DataID != ID_counter && DataID > ID_counter){
        		DataID = ID_counter;
        	}
        }
        ID_counter++;
        ID_old = DataID;
        return_value = String.valueOf(DataID);
        return return_value;
    }


    /********  form method  ************/
    /********** 2009 chie **************/

    //
    public static void initAllFormFlg(){
    	setFormItemFlg(false,null);
    	setSelectFlg(false);
    	setSelectRepeat(false);
    	setFormValueString(null);
    	setFormPartsName(null);
    	setSelected("");
    	setIDU("");
    	form_parts_number = 1;
    	exchange_form_name = new String();
    	form_detail = new String[256];
    	form_number = 1;
    	nameId = "";
    	search = false;
    	searchid = 0;
    	cond_name="";
    	cond ="";
    }


    static boolean isFormItem;
    static String formItemName;
    //form tag is written : true
    public static void setFormItemFlg(boolean b,String s){
    	isFormItem = b;
    	formItemName = s;
    	return;
    }

    public static boolean getFormItemFlg(){
        return isFormItem;
    }

    public static String getFormItemName(){
    	if(formItemName == null){
    		return "0";
    	}
    	return formItemName;
    }

	static boolean select_flg;
	//function select flg -> in func_select true

	//set and get select_flg
	public static void setSelectFlg(boolean b){
		select_flg = b;
	}

	public static boolean getSelectFlg(){
		return select_flg;
	}


	static String formValueString;
	public static void setFormValueString(String s){
		formValueString = s;
	}
	public static String getFormValueString(){
		return formValueString;
	}



	static boolean select_repeat;
	//select_repeat flag
	//not write "<tr><td>" between "<option>"s
	//set and get select_repeat
	public static void setSelectRepeat(boolean b){
		select_repeat = b;
	}
	public static boolean getSelectRepeat(){
		return select_repeat;
	}

	//global form item number : t1,t2,t3...
	static int form_parts_number = 1;
	static String form_parts_name = null;
	public static String getFormPartsName(){
		if(form_parts_name == null){
			return "t"+form_parts_number;
		}else{
			return form_parts_name;
		}
	}
	public static void incrementFormPartsNumber(){
		form_parts_number++;
	}


	public static void setFormPartsName(String s){
		form_parts_name = s;
	}

	private static String exchange_form_name = new String();
	public static void exFormName(){
		String s = "t" + form_parts_number + ":" + form_parts_name +":";
		if(exchange_form_name == null || exchange_form_name.isEmpty()){
			exchange_form_name = ":"+s;
		}else{
			if(!exchange_form_name.contains(s))
				exchange_form_name += s;
		}
	}
	public static String exFormNameCreate(){
		String ret = new String();
		if(exchange_form_name != null){
			ret = "<input type=\"hidden\" name=\"exchangeName\" value=\""+exchange_form_name+"\" />";
			setFormDetail(ret);
			return ret;
		}else{
			return null;
		}
	}



	//global form number : 1,2,3...
	static int form_number = 1;
	public static void incrementFormNumber(){
		form_number++;
	}

	public static int getFormNumber(){
		//return formNumber 1,2,3...
		return form_number;
	}
	public static String getFormName(){
		//return formNumber f1,f2,f3...
		return "f"+form_number;
	}

	static String[] form_detail = new String[256];
	public static void setFormDetail(String s){
		if(form_detail[form_number] == null)
			form_detail[form_number] = s;
		else
			form_detail[form_number] += s;
	}
	public static String getFormDetail(int i){
		return form_detail[i];
	}

	static String IDUst = new String();
	public static void setIDU(String s){
		IDUst = s;
	}

	public static String getIDU(){
		return IDUst;
	}

	static String selected = "";

	public static void setSelected(String s){
		selected = s;
	}
	public static String getSelected(){
		return selected;
	}

	static String nameId = "";
	public static String getNameid(){
		if(nameId != null){
			return nameId;
		}else{
			return "";
		}
	}

	static String checked = "";

	public static void setChecked(String s){
		System.out.println("checked:"+s);
		checked = s;
	}
	public static String getChecked(){
		return checked;
	}

	static boolean search = false;
	static int searchid = 0;
	static String cond_name = "";
	static String cond = "";

	public static void setSearch(boolean b){
		search = b;
		searchid = 0;
	}
	public static boolean getSearch(){
		return search;
	}

}