package supersql.codegenerator.HTML5;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;
import java.io.*;
import java.text.*;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;
//tk start///////////////////////////////////////
import supersql.codegenerator.CodeGenerator;
import supersql.dataconstructor.DataConstructor;
import supersql.parser.SSQLparser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;

//tk end//////////////////////////////////////////

//import common.Log;

public class HTML5Function extends Function {
//ishizaki st meterid
	static int meter_id=0; //ishizaki meter id
//ishizaki end
    Manager manager;

    HTML5Env html5_env;
    HTML5Env html5_env2;

    boolean embedflag = false;

    static String updateFile;

    public HTML5Function()
    {

    }
    //���󥹥ȥ饯��
    public HTML5Function(Manager manager, HTML5Env henv, HTML5Env henv2) {
        super();
        this.manager = manager;
        this.html5_env = henv;
        this.html5_env2 = henv2;
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
        }//ishizaki//
        else if (FuncName.equalsIgnoreCase("youtube")){
        	Func_youtube();
        } else if (FuncName.equalsIgnoreCase("movie")){
        	Func_moviefile();
        } else if (FuncName.equalsIgnoreCase("meter")){
        	Func_meter();
        }
        //ishizaki//
        //tk start//////////////////////////////////
        else if (FuncName.equalsIgnoreCase("embed")) {
        	Log.out("[enter embed]");
        	Func_embed(data_info);
        }
        //tk end////////////////////////////////////

        Log.out("TFEId = " + HTML5Env.getClassID(this));
        html5_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);

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



        //tk to make hyper link to image//////////////////////////////////////////////////////////////////////////////////
        if (html5_env.linkFlag > 0 || html5_env.sinvokeFlag) {
            html5_env.code.append("<A href=\"" + html5_env.linkUrl + "\" ");

            if(decos.containsKey("target"))
            	html5_env.code.append(" target=\"" + decos.getStr("target")+"\" ");
            if(decos.containsKey("class"))
            	html5_env.code.append(" class=\"" + decos.getStr("class") + "\" ");
            html5_env.code.append(">\n");

            Log.out("<A href=\"" + html5_env.linkUrl + "\">");
        }
        //tk/////////////////////////////////////////////////////////////////////////////////

        if(decos.containsKey("lightbox"))
        {
    		Date d1 = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
    		String today = sdf.format(d1);

        	html5_env.code.append("<a href=\"" + path+"/" + this.getAtt("default")
        			+"\" rel=\"lightbox[lb"+today+"]\">");

        	if(decos.getStr("lightbox").compareTo("root") == 0 || decos.getStr("lightbox").compareTo("thumb") == 0)
        	{
            	html5_env.code.append("<img class=\"" + HTML5Env.getClassID(this) +" ");

                if(decos.containsKey("class"))
                	html5_env.code.append(decos.getStr("class"));

                html5_env.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\" onLoad=\"initLightbox()\"/>");

        	}
        	html5_env.code.append("</a>");
        }
        else{
        	html5_env.code.append("<img class=\"" + HTML5Env.getClassID(this) +" ");
        	html5_env2.code.append("<VALUE type=\"img\" class=\"" + HTML5Env.getClassID(this) +" ");
        	if(decos.containsKey("class"))
        		html5_env.code.append(decos.getStr("class"));

            //System.out.println("out:path:"+this.getAtt("default"));
        	html5_env.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\"/>");
        	html5_env2.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\" ");
        	if(decos.containsKey("width")){
        		html5_env2.code.append("width=\"" + decos.getStr("width").replace("\"", "")+"\" " );
        	}
        	if(decos.containsKey("height")){
        		html5_env2.code.append("height=\"" + decos.getStr("height").replace("\"", "") +"\" " );
        	}
        	html5_env2.code.append(" ></VALUE>");
        }
        //tk  to make hyper link to image///////////////////////////////////////////////////////////////////////////////////
        if (html5_env.linkFlag > 0 || html5_env.sinvokeFlag) {
        	html5_env.code.append("</a>");
        }
        //tk///////////////////////////////////////////////////////////////////////////////////
        return;
    }

    private void Func_null() {
        return;
    }
////ishizaki st///////////////////////
    private void Func_youtube(){
    	/*
    	 * <object width="480" height="385"><param name="movie" value="http://www.youtube.com/v/f3Afu5CBZUA?fs=1&amp;hl=ja_JP"></param><param name="allowFullScreen" value="true"></param><param name="allowscriptaccess" value="always"></param><embed src="http://www.youtube.com/v/f3Afu5CBZUA?fs=1&amp;hl=ja_JP" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" width="480" height="385"></embed></object>
         */

        String path = this.getAtt("default");
/*        if (!path.startsWith("/")) {
            String basedir = GlobalEnv.getBaseDir();
            if (basedir != null && basedir != "") {
                path = GlobalEnv.getBaseDir() + "/" + path;
            }
        }

*/
 //       System.out.println("test" + path);
    	String a = "<object width=\"480\" height=\"385\">" +
    			"<param name=\"movie\" value=\"http://www.youtube.com/v/" +
    			path +
    			"?fs=1&amp;hl=ja_JP\"></param><param name=\"allowFullScreen\" value=\"true\">" +
    			"</param><param name=\"allowscriptaccess\" value=\"always\"></param><embed src=\"http://www.youtube.com/v/" +
    			path +
    			"?fs=1&amp;hl=ja_JP\" type=\"application/x-shockwave-flash\" " +
    			"allowscriptaccess=\"always\" allowfullscreen=\"true\" width=\"480\" height=\"385\">" +
    			"</embed></object>";
    	html5_env.code.append(a);
    	return;
    }

    private void Func_moviefile(){

        String path = this.getAtt("path", ".");
        if (!path.startsWith("/")) {
            String basedir = GlobalEnv.getBaseDir();
            if (basedir != null && basedir != "") {
                path = GlobalEnv.getBaseDir() + "/" + path;
            }
        }

       	html5_env.code.append("<video class=\"" + HTML5Env.getClassID(this) +"\" ");
       	if(decos.containsKey("class"))
    		html5_env.code.append(decos.getStr("class"));

    	html5_env.code.append(" \" src=\"" + path + "/" + this.getAtt("default")+"\"");
    	html5_env.code.append("autobuffer controls poster=\"http://www.db.ics.keio.ac.jp/ssql/img/ssqllogo.gif\">" +
    			"<p>Try this page in Safari 4! Or you can <a href=\"" +
    			path + "/" + this.getAtt("default")+"\"" +
    			">download the video</a> instead.</p>");

    	return;
    }
//ishizaki st(canvas使用版)///////////
    private void Func_meter(){
 /*   	<script type="text/javascript">addEvent(window,"load",function() {
			var layout = [
				200,				//width
				40,					//height
				170,					//m_width
				25,					//m_height
				100,				//max
				0,				//min
				30,				//low
				70				//high
				]
			var color = [
				"#FF0000",				//max_color
				"#00FFFF",				//low_color
				"#00FFFF",				//high_color
				"#00FF00",				//mid_color
				"#CCCCCC"				//bg_color
			]
			draw("meter2",layout,color,70);
			});</script>

<div><canvas width="200" height="40" id="meter2"></canvas></div>
*/

    	meter_id++;


       	html5_env.code.append("<script type=\"text/javascript\">addEvent(window,\"load\",function() { \nvar layout = [");
      	if(decos.containsKey("width"))
       		html5_env.code.append(decos.getStr("width"));
      	html5_env.code.append(",");
      	if(decos.containsKey("height"))
       		html5_env.code.append(decos.getStr("height"));
      	html5_env.code.append(",");
      	if(decos.containsKey("m_width"))
       		html5_env.code.append(decos.getStr("m_width"));
      	html5_env.code.append(",");
      	if(decos.containsKey("m_height"))
       		html5_env.code.append(decos.getStr("m_height"));
      	html5_env.code.append(",");
      	if(decos.containsKey("max"))
       		html5_env.code.append(decos.getStr("max"));
      	html5_env.code.append(",");
      	if(decos.containsKey("min"))
       		html5_env.code.append(decos.getStr("min"));
      	html5_env.code.append(",");
      	if(decos.containsKey("low"))
       		html5_env.code.append(decos.getStr("low"));
      	html5_env.code.append(",");
      	if(decos.containsKey("high"))
       		html5_env.code.append(decos.getStr("high"));
      	html5_env.code.append("] \nvar color = [");
      	if(decos.containsKey("max_color"))
       		html5_env.code.append(decos.getStr("max_color"));
      	html5_env.code.append(",");
      	if(decos.containsKey("low_color"))
       		html5_env.code.append(decos.getStr("low_color"));
      	html5_env.code.append(",");
      	if(decos.containsKey("high_color"))
       		html5_env.code.append(decos.getStr("high_color"));
      	html5_env.code.append(",");
      	if(decos.containsKey("mid_color"))
       		html5_env.code.append(decos.getStr("mid_color"));
      	html5_env.code.append(",");
      	if(decos.containsKey("bg_color"))
      		html5_env.code.append(decos.getStr("bg_color"));
      	html5_env.code.append("] \ndraw(\"meter"+meter_id+"\",layout,color,"+this.getAtt("default") +");});</script>");

      	html5_env.code.append("<div><canvas ");
    	if(decos.containsKey("width"))
       		html5_env.code.append("width=" + decos.getStr("width") + " ");
       	else
       		html5_env.code.append("width = 200 ");
    	if(decos.containsKey("height"))
       		html5_env.code.append("height=" + decos.getStr("height") + " ");
       	else
       		html5_env.code.append("height = 40 ");
     	html5_env.code.append("id=\"meter"+meter_id+"\"></canvas></div>");
    }
///ishizaki end///////////////////////
    //added by chie 2009 func form submit
    private void Func_submit() {
    	String form = new String();
    	boolean openFormInThis = false;

    	//submit only ----- no "@{form}"
    	if(!HTML5Env.getFormItemFlg() && !decos.containsKey("form")){
    		form = createForm();
        	openFormInThis = true;
    	}else if(decos.containsKey("form")){
    		form = createForm(decos);
        	openFormInThis = true;
    	}


		HTML5Env.setFormItemFlg(true,"submit");

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
    		HTML5Env.setFormItemFlg(false,null);
    		openFormInThis = false;
    	}else{
    		HTML5Env.setFormItemFlg(true,null);
    	}

        html5_env.code.append(form);
        html5_env2.code.append("<VALUE type=\"form\">"+form+"</VALUE>");
        return;
    }

  //added by chie 2009 func form select
    private void Func_select() {
        if(!this.getAtt("selected").equals("")){
        	HTML5Env.setSelected(this.getAtt("selected"));
        }

		Func_FormCommon("select");

        return;
    }
  //added by chie 2009 func form checkbox
    private void Func_checkbox() {
		Func_FormCommon("checkbox");

		if(!this.getAtt("checked").equals("")){
        	HTML5Env.setChecked(this.getAtt("checked"));
        }

        return;
    }
    //added by chie 2009 func form radio
    private void Func_radio() {

		if(!this.getAtt("checked").equals("")){
        	HTML5Env.setChecked(this.getAtt("checked"));
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

    	if(!HTML5Env.getFormItemFlg()){
    		form = createForm();
        	openFormInThis = true;
    	}

		HTML5Env.setFormItemFlg(true,s);

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
        	HTML5Env.setFormPartsName(this.getAtt("name"));
        	HTML5Env.exFormName();
        }else{
        	HTML5Env.setFormPartsName(null);
        }

        if(!this.getAtt("id").equals("")){
        	HTML5Env.nameId = this.getAtt("id");
        }

        if(!this.getAtt("cond_name").equals("")){
        	HTML5Env.condName = this.getAtt("cond_name");
        }
        if(!this.getAtt("cond").equals("")){
        	HTML5Env.cond = this.getAtt("cond");
        }


        html5_env.code.append(form);

        if(this.getArgs().get(0) instanceof FuncArg)
        {
        	//HTML5Env.setSelectFlg(true,(String)this.decos.get("select"));
        	HTML5Env.setFormValueString(att);
        	Log.out("ARGS are function");
        	FuncArg fa = (FuncArg) this.getArgs().get(0);
        	fa.workAtt();
        }
        else{
            this.workAtt("default");
        }

    	if(openFormInThis == true){
    		html5_env.code.append("</form>");
    		HTML5Env.setFormItemFlg(false,null);
        	openFormInThis = false;
    	}else{
    		HTML5Env.setFormItemFlg(true,null);
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
//ishizaki(ここから/servlet/super...を/superに訂正)(516を消して517追加)
    	//form += "<form method=\"POST\" action=\"" + path + "/servlet/supersql.form.FormServlet\"" +">";
       	form += "<form method=\"POST\" action=\"" + path + "/supersql.form.FormServlet\"" +">";

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

    	form = "<form method=\"POST\" action=\"" + path + "/supersql.form.FormServlet\" " + "name=\""+ HTML5Env.getFormName() + "\" " +">";


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
        HTML5Env.setFormDetail(form);
        return form;
    }

    //not use
    /*
    private void Func_session() {
    	System.out.println("aaaaaaaaa"+this.getClassName());
    	html5_env.code.append("b");
        html5_env2.code.append("<VALUE type=\"form\">b</VALUE>");
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
        html5_env.linkurl = this.getAtt("server_path", GlobalEnv
                .getInvokeServletPath())
                + "?"
                + this.getAtt("dbname", GlobalEnv.getdbname())
                + "+"
                + filename + "+" + this.getAtt("condition");
        */
        /*
        html5_env.linkurl = "http://localhost:8080/invoke/servlet/supersql.invoke.InvokeServlet2"
                + "?"
                + "config=http://localhost:8080/invoke/config.ssql"
                + "&"
                + "query=" + filename
                + "&"
                + "cond=" + this.getAtt("condition");
		*/
        //change chie
        html5_env.linkUrl = this.getAtt("server_path", GlobalEnv
                .getInvokeServletPath())
                + "?"
                + "config="+path+"/config.ssql"
                + "&"
                + "query=" + filename
                + "&"
                + "cond=" + this.getAtt("condition");
        // end tk//////////////////////////////////////////////////

        html5_env.linkFlag=1;
        this.workAtt("default");
        html5_env.linkFlag=0;

        return;
    }

    private void Func_foreach(ExtList data_info) throws UnsupportedEncodingException {
    	String att = new String();
    	String attkey;
    	for (int i = 0; i < this.countconnectitem(); i++) {
    		att = att + "_" + this.getAtt(Integer.toString(i));
    	}
        //String filename = html5_env.outfile + "_" + this.getAtt("default") + ".html";
    	att = URLEncoder.encode(att, "UTF-8");
    	String filename = html5_env.outFile + att + ".html";

        html5_env.fileName = filename;
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
			html5_env.code.append("<div id=\"myTab\" ");

			if(decos.containsKey("class"))
				html5_env.code.append("class=\""+decos.getStr("class")+"\"");

			html5_env.code.append(">\n");
			html5_env.code.append("<div id=\"mTab\" class=\"yui-navset\">\n");

			html5_env.code.append("</div></div>\n");

			html5_env.script.append("var mTab = new YAHOO.widget.TabView(\"mTab\");");
    		html5_env.script.append("new YAHOO.util.DDTarget(\"myTab\", \"myTab\");");

			return;
		}

        if(!is_hidden)
        {
        	html5_env.code.append("<table class=\"att " + html5_env.getOutlineModeAtt() + " ");

        	if(decos.containsKey("class"))
        		html5_env.code.append(decos.getStr("class"));
        	else
        		html5_env.code.append(HTML5Env.getClassID(this));

        	html5_env.code.append("\"");
        	html5_env.code.append("><tr><td>");
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
        	html5_env.script.append("new YAHOO.util.DDTarget(\""+divname+"\", \""+divname+"\");");
        }
        //ajax & decos contains status=hidden
        if(is_hidden && GlobalEnv.isAjax()){

			html5_env.code.append("<div id=\""+divname+"\" ");

			if(decos.containsKey("class"))
				html5_env.code.append("class=\""+decos.getStr("class")+ "\" ");

			html5_env.code.append("></div>");
			Log.out("<div id="+divname+"></div>");

			return;
        }
        // end ajax divname ////////////////////////////////////////////////

/*    	if(border.compareTo("1") == 0)
    	{}
    	else
    		html5_env.css.append(".embed { vertical-align : text-top; padding : 0px ; margin : 0px; border: 0px,0px,0px,0px; width: 100%;}");
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

    	html5_env.embedCount++;

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
                   			html5_env.code.append(line);
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
	    			parser = new SSQLparser(10000*(html5_env.embedCount+1));
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

					html5_env.code.append("<div id=\""+divname+"\" ");

					if(decos.containsKey("class"))
						html5_env.code.append("class=\""+decos.getStr("class")+ "\" ");

					html5_env.code.append(">");
//	    			html5_env.code.append("<br><a href=\"close.html\" class=\"bottom_close_"+divname+"\" onClick=\"return closeDiv('"+divname+"')\">close</a><br>");
					Log.out("<div id="+divname+">");
				}

				// ajax depends on decos status //////////////////////////////////////////
				boolean status_flag = false;

				//xml�����
				if(!is_hidden){
					html5_env2.code.append("<EMBED>");
					html5_env.code.append(returnedcode);
					html5_env2.code.append(returnedcode);
					html5_env2.code.append("</EMBED>");
				}

				if(GlobalEnv.isAjax())
					html5_env.code.append("</div>");
				// end ajax /////////////////////////////////////////////////////////////////

				if(html5_env.embedCount >= 1)
				{
					html5_env.css.append(codegenerator.generateCode3(parser,dc.getData()));
					html5_env.cssFile.append(codegenerator.generateCssfile(parser,dc.getData()));
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

			        	out.write(html5_env.header.toString());
			        	out.write(returnedcode.toString());
			        	out.write(html5_env.footer.toString());

			        	out.close();
						/*
						PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
			                    filename)));
			            Log.out("filename:"+filename);
			            pw.println(html5_env.header);
			            pw.println(returnedcode);
			            pw.println(html5_env.footer);
			            pw.close();
						 */
			        } catch (FileNotFoundException fe) {

			        	fe.printStackTrace();
			        	System.err.println("Error: specified embedtmp outdirectory \""
			                    + GlobalEnv.getEmbedTmp() + "\" is not found to write " + html5_env.fileName );

		                GlobalEnv.addErr("Error: specified embedtmp outdirectory \""
			                    + GlobalEnv.getEmbedTmp() + "\" is not found to write " + html5_env.fileName);
	                    //comment out by chie
			        	//System.exit(-1);
			        } catch (IOException e) {
			            System.err.println("Error[HTML5Manager]: File IO Error in HTML5Manager at embed");
			            e.printStackTrace();
			            GlobalEnv.addErr("Error[HTML5Manager]: File IO Error in HTML5Manager at embed");
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
            			String path = html5_env.outFile;
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
               			html5_env.header.append(line+"\n");
               	}
               	line = dis.readLine(); //read <body>

    			html5_env.code.append("<div id=\""+divname+"\" ");

    			if(decos.containsKey("class"))
    				html5_env.code.append("class=\""+decos.getStr("class")+ "\" ");

    			html5_env.code.append(">");


       			html5_env2.code.append("<EMBED>");
               	while(!line.equalsIgnoreCase("</body>"))
               	{
               		Log.out("line : "+line);
               		line = dis.readLine();
               		if(!line.equalsIgnoreCase("</body>")){
               			html5_env.code.append(line);
               	        if(line.contains("&"))
               	        	line = line.replace("&", "&amp;");
               			if(line.contains("<"));
               				line = line.replace("<", "&lt;");
               			if(line.contains(">"))
               		        line = line.replace(">", "&gt;");
               	        if(line.contains("���"))
               	        	line = line.replace("���", "&#65374;");
               			html5_env2.code.append(line);
               		}
               	}
       			html5_env2.code.append("</EMBED>");
//    			html_env.code.append("<br><a href=\"close.html\" class=\"bottom_close_"+divname+"\" onClick=\"return closeDiv('"+divname+"')\">close</a><br>");

               	html5_env.code.append("</div>");
                dis.close();

            } catch (MalformedURLException me) {
                System.out.println("MalformedURLException: " + me);
            } catch (IOException ioe) {
                System.out.println("HTML5FuncEmbed:IOException: " + ioe);
            }

    	}
    	if(!is_hidden)
    		html5_env.code.append("</td></tr></table>");

    	html5_env.embedCount += 1;
    }
    //tk end////////////////////////////////////////////////////////////////////////////

    private void Func_sinvoke(ExtList data_info) {
        String file = this.getAtt("file");
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
		try{
			if(file.toLowerCase().contains(".sql")){
				file = file.substring(0, file.indexOf(".sql"));
			}else if(file.toLowerCase().contains(".html")){
				file = file.substring(0, file.indexOf(".html"));
			}
		}catch(Exception e){
			GlobalEnv.addErr("Error[HTML5Function]: filename is invalid.");
			System.err.println("Error[HTML5Function]: filename is invalid.");
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
        html5_env.linkUrl = filename;
        html5_env.sinvokeFlag = true;


        //tk to make hyper link to image///////////////////////////////////////////////////
        //tk to ajax
        if(GlobalEnv.isAjax())
        {
        	html5_env.linkUrl =  file+".html";
        	html5_env.ajaxQuery = file+".sql";
//        	html5_env.ajaxatt = this.getAtt("att");
        	html5_env.ajaxCond = this.getAtt("ajaxcond")+"="+this.getAtt("att");

    		Date d2 = new Date();
    		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyymmddHHmmss");
    		String today2 = sdf2.format(d2);

        	html5_env.dragDivId = html5_env.ajaxQuery+"+"+html5_env.ajaxCond+"&"+today2;

        	if(decos.containsKey("in"))
        	{
        		String effect = decos.getStr("in");

        		if(effect.equalsIgnoreCase("blind"))
        			html5_env.inEffect = 1;
        		if(effect.equalsIgnoreCase("fade"))
        			html5_env.inEffect = 2;
        	}
        	if(decos.containsKey("out"))
        	{
        		String effect = decos.getStr("out");

        		if(effect.equalsIgnoreCase("blind"))
        			html5_env.outEffect = 1;
        		if(effect.equalsIgnoreCase("fade"))
        			html5_env.outEffect = 2;
        	}

        	if(decos.containsKey("panel"))
        	{
        		html5_env.isPanel = true;
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
            			html5_env.ajaxtarget = tmp2 + "_" + this.getAtt("att");
            		}
            		else
            			html5_env.ajaxtarget = dispdiv;
            	}
            	else
            	{
            		html5_env.ajaxtarget = dispdiv;
            	}
            	html5_env.hasDispDiv = true;
            	Log.out("html_env.ajaxtarget:"+html5_env.ajaxtarget);
        	}
        	else if(decos.containsKey("dragto"))
        	{
        		Log.out("draggable = ture");
        		html5_env.draggable = true;


        		//drag to
        		String value = decos.getStr("dragto");
    			String droptarget[] = new String[100];
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

        		String scriptname = "drop"+today + html5_env.scriptNum;
        		html5_env.script.append(scriptname+" = new DragDrop(\""+
        				html5_env.dragDivId+"\", \""+droptarget[0]+"\");\n");

        		Log.out(scriptname+" = new DragDrop(\""+
        				html5_env.dragDivId+"\", \""+droptarget[0]+"\");\n");

        		//for tab
        		html5_env.script.append(scriptname+".addToGroup(\"myTab\");\n");

        		for(int i = 1; i < targetnum ; ++i)
        		{
        			html5_env.script.append(scriptname+".addToGroup(\""+droptarget[i]+"\");\n");
        		}

        		html5_env.scriptNum++;
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

        html5_env.sinvokeFlag = false;
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
