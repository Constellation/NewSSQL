package supersql.codegenerator.TESTHTML;

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

public class TESTHTMLFunction extends Function {

    Manager manager;

    TESTHTMLEnv html_env;
    TESTHTMLEnv html_env2;

    boolean embedflag = false;

    static String updateFile;

    public TESTHTMLFunction()
    {

    }
    //���󥹥ȥ饯��
    public TESTHTMLFunction(Manager manager, TESTHTMLEnv henv, TESTHTMLEnv henv2) {
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

        Log.out("TFEId = " + TESTHTMLEnv.getClassID(this));
        html_env.append_css_def_td(TESTHTMLEnv.getClassID(this), this.decos);

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
        if (html_env.link_flag > 0 || html_env.sinvoke_flag) {
            html_env.code.append("<A href=\"" + html_env.linkurl + "\" ");

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
            	html_env.code.append("<img class=\"" + TESTHTMLEnv.getClassID(this) +" ");

                if(decos.containsKey("class"))
                	html_env.code.append(decos.getStr("class"));

                html_env.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\" onLoad=\"initLightbox()\"/>");

        	}
        	html_env.code.append("</a>");
        }
        else{
        	html_env.code.append("<img class=\"" + TESTHTMLEnv.getClassID(this) +" ");
        	html_env2.code.append("<VALUE type=\"img\" class=\"" + TESTHTMLEnv.getClassID(this) +" ");
        	if(decos.containsKey("class"))
        		html_env.code.append(decos.getStr("class"));

            //System.out.println("out:path:"+this.getAtt("default"));
        	html_env.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\"/>");
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

        return;
    }

    private void Func_null() {
        return;
    }

    //added by chie 2009 func form submit
    private void Func_submit() {
    	String form = new String();
    	boolean openFormInThis = false;

    	//submit only ----- no "@{form}"
    	if(!TESTHTMLEnv.getFormItemFlg() && !decos.containsKey("form")){
    		form = createForm();
        	openFormInThis = true;
    	}else if(decos.containsKey("form")){
    		form = createForm(decos);
        	openFormInThis = true;
    	}


		TESTHTMLEnv.setFormItemFlg(true,"submit");

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
    		TESTHTMLEnv.setFormItemFlg(false,null);
    		openFormInThis = false;
    	}else{
    		TESTHTMLEnv.setFormItemFlg(true,null);
    	}

        html_env.code.append(form);
        html_env2.code.append("<VALUE type=\"form\">"+form+"</VALUE>");
        return;
    }

  //added by chie 2009 func form select
    private void Func_select() {
        if(!this.getAtt("selected").equals("")){
        	TESTHTMLEnv.setSelected(this.getAtt("selected"));
        }

		Func_FormCommon("select");

        return;
    }
  //added by chie 2009 func form checkbox
    private void Func_checkbox() {
		Func_FormCommon("checkbox");

		if(!this.getAtt("checked").equals("")){
        	TESTHTMLEnv.setChecked(this.getAtt("checked"));
        }

        return;
    }
    //added by chie 2009 func form radio
    private void Func_radio() {

		if(!this.getAtt("checked").equals("")){
        	TESTHTMLEnv.setChecked(this.getAtt("checked"));
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

    	if(!TESTHTMLEnv.getFormItemFlg()){
    		form = createForm();
        	openFormInThis = true;
    	}

		TESTHTMLEnv.setFormItemFlg(true,s);

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
        	TESTHTMLEnv.setFormPartsName(this.getAtt("name"));
        	TESTHTMLEnv.exFormName();
        }else{
        	TESTHTMLEnv.setFormPartsName(null);
        }

        if(!this.getAtt("id").equals("")){
        	TESTHTMLEnv.nameId = this.getAtt("id");
        }

        if(!this.getAtt("cond_name").equals("")){
        	TESTHTMLEnv.cond_name = this.getAtt("cond_name");
        }
        if(!this.getAtt("cond").equals("")){
        	TESTHTMLEnv.cond = this.getAtt("cond");
        }


        html_env.code.append(form);

        if(this.getArgs().get(0) instanceof FuncArg)
        {
        	//HTMLEnv.setSelectFlg(true,(String)this.decos.get("select"));
        	TESTHTMLEnv.setFormValueString(att);
        	Log.out("ARGS are function");
        	FuncArg fa = (FuncArg) this.getArgs().get(0);
        	fa.workAtt();
        }
        else{
            this.workAtt("default");
        }

    	if(openFormInThis == true){
    		html_env.code.append("</form>");
    		TESTHTMLEnv.setFormItemFlg(false,null);
        	openFormInThis = false;
    	}else{
    		TESTHTMLEnv.setFormItemFlg(true,null);
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

    	form = "<form method=\"POST\" action=\"" + path + "/supersql.form.FormServlet\" " + "name=\""+ TESTHTMLEnv.getFormName() + "\" " +">";


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
        TESTHTMLEnv.setFormDetail(form);
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
        		html_env.code.append(TESTHTMLEnv.getClassID(this));

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