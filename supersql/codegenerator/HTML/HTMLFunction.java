package supersql.codegenerator.HTML;

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

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

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

public class HTMLFunction extends Function {

	private HTMLEnv htmlEnv;
	private HTMLEnv htmlEnv2;

	protected static String updateFile;

    public HTMLFunction()
    {

    }
    //コンストラクタ
    public HTMLFunction(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        super();
        this.htmlEnv = henv;
        this.htmlEnv2 = henv2;
    }
    
    

    @Override
	public Element createNode(ExtList<ExtList<String>> data_info) {
    	this.setDataList(data_info);
    	String FuncName = this.getFuncName();
    	if (FuncName.equalsIgnoreCase("imagefile")) {
            return FuncImagefileForJsoup();
        } else if (FuncName.equalsIgnoreCase("invoke")) {
            return FuncInvokeForJsoup();
        } else if (FuncName.equalsIgnoreCase("foreach")) {
            return FuncForeachForJsoup(data_info);
        } else if (FuncName.equalsIgnoreCase("sinvoke") || FuncName.equalsIgnoreCase("link")) {
            return FuncSinvokeForJsoup(data_info);
        } else if (FuncName.equalsIgnoreCase("null")) {
            return FuncNullForJsoup();
        }
        else if (FuncName.equalsIgnoreCase("submit")) {
            return FuncSubmitForJsoup();
        }
        else if (FuncName.equalsIgnoreCase("select")) {
            return FuncSelectForJsoup();
        }
        else if (FuncName.equalsIgnoreCase("checkbox")) {
            return FuncCheckboxForJsoup();
        }
        else if (FuncName.equalsIgnoreCase("radio")) {
            return FuncRadioForJsoup();
        }
        else if (FuncName.equalsIgnoreCase("inputtext")) {
            return FuncInputtextForJsoup();
        }
        else if (FuncName.equalsIgnoreCase("textarea")) {
            return FuncTextareaForJsoup();
        }
        else if (FuncName.equalsIgnoreCase("hidden")) {
            return FuncHiddenForJsoup();
        }
        else if (FuncName.equalsIgnoreCase("session")) {
            //Func_session(); not use
        	return new Element(Tag.valueOf(""), "");
        }
        //tk start//////////////////////////////////
        else if (FuncName.equalsIgnoreCase("embed")) {
        	Log.out("[enter embed]");
        	return FuncEmbedForJsoup(data_info);
        }
        //tk end////////////////////////////////////
        Log.out("TFEId = " + HTMLEnv.getClassID(this));
        htmlEnv.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        return null;
	}
	//Functionのworkメソッド
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
//        // for practice
//        else if(FuncName.equalsIgnoreCase("button")){
//        	Func_button();
//        }
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
        htmlEnv.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
    }

    private Element FuncEmbedForJsoup(ExtList<ExtList<String>> data_info) {
		// TODO Auto-generated method stub
		return null;
	}
	private Element FuncHiddenForJsoup() {
		return FuncFormCommonForJsoup("hidden");
	}
	private Element FuncTextareaForJsoup() {
		return FuncFormCommonForJsoup("textarea");
	}
	private Element FuncInputtextForJsoup() {
		return FuncFormCommonForJsoup("text");
	}
	private Element FuncRadioForJsoup() {
		if(!this.getAtt("checked").equals("")){
        	HTMLEnv.setChecked(this.getAtt("checked"));
        }
        return FuncFormCommonForJsoup("radio");
	}
	private Element FuncCheckboxForJsoup() {
		Element result = FuncFormCommonForJsoup("checkbox");

		if(!this.getAtt("checked").equals("")){
        	HTMLEnv.setChecked(this.getAtt("checked"));
        }

        return result;
	}

	private Element FuncSelectForJsoup() {
        if(!this.getAtt("selected").equals("")){
        	HTMLEnv.setSelected(this.getAtt("selected"));
        }
        return FuncFormCommonForJsoup("select");
	}
	
	private Element FuncSubmitForJsoup() {
		Element result = new Element(Tag.valueOf("form"), "");
    	boolean openFormInThis = false;

    	//submit only ----- no "@{form}"
    	if(!HTMLEnv.getFormItemFlg() && !decos.containsKey("form")){
    		result = createFormForJsoup();
        	openFormInThis = true;
    	}else if(decos.containsKey("form")){
    		result = createFormForJsoup(decos);
        	openFormInThis = true;
    	}


		HTMLEnv.setFormItemFlg(true,"submit");

    	String value = "";
    	if(!this.getAtt("default").equals(null)){
        	value = this.getAtt("default");
        }

    	result.appendChild(JsoupFactory.createInput("submit", "", value));
    	if(openFormInThis == true){
    		HTMLEnv.setFormItemFlg(false,null);
    		openFormInThis = false;
    	}else{
    		HTMLEnv.setFormItemFlg(true,null);
    	}

        return result;
	}
	private Element FuncNullForJsoup() {
		return new Element(Tag.valueOf("span"), "");
	}
	private Element FuncSinvokeForJsoup(ExtList<ExtList<String>> data_info) {
		// TODO Auto-generated method stub
		return null;
	}
	private Element FuncForeachForJsoup(ExtList<ExtList<String>> data_info) {
		String att = new String();
    	for (int i = 0; i < this.countconnectitem(); i++) {
    		att = att + "_" + this.getAtt(Integer.toString(i));
    	}
    	try {
			att = URLEncoder.encode(att, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	String filename = htmlEnv.outFile + att + ".html";

        htmlEnv.fileName = filename;
		return null;
	}
	private Element FuncInvokeForJsoup() {
		// TODO Auto-generated method stub
		return null;
	}
	private Element FuncImagefileForJsoup() {
		// TODO Auto-generated method stub
		return null;
	}
	protected void Func_imagefile() {

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
        if (htmlEnv.linkFlag > 0 || htmlEnv.sinvokeFlag) {
			//added by goto 20121222 start
        	//以下は、-fのファイル名指定が絶対パスになっている場合の処理(?)
			//[%連結子] hrefの指定を絶対パスから「相対パス形式」へ変更
			//20120622の修正だと、「-f フルパスファイル名」を用いている場合、相対パス形式にならない
			String fileDir = new File(htmlEnv.linkUrl).getAbsoluteFile().getParent();
			
			if(fileDir.length() < htmlEnv.linkUrl.length()
			&& fileDir.equals(htmlEnv.linkUrl.substring(0,fileDir.length()))){
				String relative_path = htmlEnv.linkUrl.substring(fileDir.length()+1);
				htmlEnv.code.append("<A href=\"" + relative_path + "\" ");
			}else
				htmlEnv.code.append("<A href=\"" + htmlEnv.linkUrl + "\" ");
			
            //html_env.code.append("<A href=\"" + html_env.linkurl + "\" ");
			//added by goto 20121222 end

            if(decos.containsKey("target"))
            	htmlEnv.code.append(" target=\"" + decos.getStr("target")+"\" ");
            if(decos.containsKey("class"))
            	htmlEnv.code.append(" class=\"" + decos.getStr("class") + "\" ");
            htmlEnv.code.append(">\n");

            Log.out("<A href=\"" + htmlEnv.linkUrl + "\">");
        }
        //tk/////////////////////////////////////////////////////////////////////////////////


        
        if(decos.containsKey("lightbox"))
        {
    		Date d1 = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
    		String today = sdf.format(d1);

        	htmlEnv.code.append("<a href=\"" + path+"/" + this.getAtt("default")
        			+"\" rel=\"lightbox[lb"+today+"]\">");

        	if(decos.getStr("lightbox").compareTo("root") == 0 || decos.getStr("lightbox").compareTo("thumb") == 0)
        	{
            	htmlEnv.code.append("<img class=\"" + HTMLEnv.getClassID(this) +" ");

                if(decos.containsKey("class"))
                	htmlEnv.code.append(decos.getStr("class"));

                htmlEnv.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\" onLoad=\"initLightbox()\"/>");

        	}
        	htmlEnv.code.append("</a>");
        }
        else{
        	htmlEnv.code.append("<img class=\"" + HTMLEnv.getClassID(this) +" ");
        	htmlEnv2.code.append("<VALUE type=\"img\" class=\"" + HTMLEnv.getClassID(this) +" ");
        	if(decos.containsKey("class"))
        		htmlEnv.code.append(decos.getStr("class"));

            //System.out.println("out:path:"+this.getAtt("default"));
        	htmlEnv.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\"/>");
        	htmlEnv2.code.append(" \" src=\"" + path + "/" + this.getAtt("default") + "\" ");
        	if(decos.containsKey("width")){
        		htmlEnv2.code.append("width=\"" + decos.getStr("width").replace("\"", "")+"\" " );
        	}
        	if(decos.containsKey("height")){
        		htmlEnv2.code.append("height=\"" + decos.getStr("height").replace("\"", "") +"\" " );
        	}
        	htmlEnv2.code.append(" ></VALUE>");
        }
        //tk  to make hyper link to image///////////////////////////////////////////////////////////////////////////////////
        if (htmlEnv.linkFlag > 0 || htmlEnv.sinvokeFlag) {
        	htmlEnv.code.append("</a>");
        }
        //tk///////////////////////////////////////////////////////////////////////////////////
        return;
    }

//    // for practice 2012/02/09
//    private void Func_button() {
//    	String statement ="";
//    	String button_media = this.getArgs().get(0).toString();
//    	if (button_media.equals("\"goback\"")){
//    		// 戻るボタンを生成する
//			statement = "<form><INPUT type=\"button\" onClick='history.back();' value=\"戻る\"></form>";
//    	}else if(button_media.equals("\"bookmark\"")){
//    		// ここにブックマーク処理を記述する
//    	}else if(button_media.equals("\"facebook\"")){
//    		// facebookのいいね！ボタンの処理を記述する
//    	}else{
//    		// 特に指定がなければ戻るボタンにする
//    		statement = "<form><INPUT type=\"button\" onClick='history.back();' value=\"戻る\"></form>";
//    	}
//    	// 各引数毎に処理した結果をHTMLに書きこむ
//    	html_env.code.append(statement);
//    	return;
//    }

    protected void Func_null() {
        return;
    }

    //added by chie 2009 func form submit
    protected void Func_submit() {
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

        htmlEnv.code.append(form);
        htmlEnv2.code.append("<VALUE type=\"form\">"+form+"</VALUE>");
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
    
    private Element FuncFormCommonForJsoup(String s){
    	Element result = new Element(Tag.valueOf("div"),  "");
    	
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
        	HTMLEnv.condName = this.getAtt("cond_name");
        }
        if(!this.getAtt("cond").equals("")){
        	HTMLEnv.cond = this.getAtt("cond");
        }


        htmlEnv.code.append(form);

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
    		htmlEnv.code.append("</form>");
    		HTMLEnv.setFormItemFlg(false,null);
        	openFormInThis = false;
    	}else{
    		HTMLEnv.setFormItemFlg(true,null);
    	}
        return result;
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
        	HTMLEnv.condName = this.getAtt("cond_name");
        }
        if(!this.getAtt("cond").equals("")){
        	HTMLEnv.cond = this.getAtt("cond");
        }


        htmlEnv.code.append(form);

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
    		htmlEnv.code.append("</form>");
    		HTMLEnv.setFormItemFlg(false,null);
        	openFormInThis = false;
    	}else{
    		HTMLEnv.setFormItemFlg(true,null);
    	}
        return;
    }

    
    private Element createFormForJsoup(){
    	Element result = new Element(Tag.valueOf("form"), "");
    	String path = new String();
    	if(this.getAtt("path") != null &&  !this.getAtt("path").isEmpty()){
    		 path =  this.getAtt("path").replaceAll("\"", "");
    	}else{
    		path = ".";
    	}
    	
    	result.attr("method", "POST").attr("action", path+"/servlet/supersql.form.FormServlet");
    	result.appendChild(JsoupFactory.createInput("hidden", "configfile", path+"/config.ssql"));

        if(this.getAtt("link") != null && !this.getAtt("link").isEmpty()){
        	result.appendChild(JsoupFactory.createInput("hidden", "sqlfile",path + "/" + this.getAtt("link").replaceAll("\"", "")));
        }else if(this.getAtt("linkfile") != null && !this.getAtt("linkfile").isEmpty()){
        	result.appendChild(JsoupFactory.createInput("hidden", "sqlfile", path + "/" + this.getAtt("linkfile").replaceAll("\"", "")));
        }

        if(this.getAtt("cond")!= null && !this.getAtt("cond").isEmpty()){
        	if(!this.getAtt("cond").replaceAll("\"", "").isEmpty())
        		result.appendChild(JsoupFactory.createInput("hidden", "cond1", this.getAtt("cond").replaceAll("\"", "")));
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
        	result.appendChild(JsoupFactory.createInput("hidden", "updatefile", path + "/" +this.getAtt("update").replaceAll("\"", "")+"(" + att + ")"));
        }else if(this.getAtt("updatefile")!=null && !this.getAtt("updatefile").isEmpty()){
        	result.appendChild(JsoupFactory.createInput("hidden", "updatefile", path + "/" +this.getAtt("updatefile").replaceAll("\"", "")+"(" + att + ")"));
        }
        return result;
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
    
    public static Element createFormForJsoup(DecorateList decos){
    	Element result = new Element(Tag.valueOf("form"), "");
    	String path = new String();
    	if(decos.containsKey("path")){
    		path =  decos.getStr("path").replaceAll("\"", "");
    	}else{
    		path = ".";
    	}
    	
    	result.attr("method", "POST");
    	result.attr("action", path + "/supersql.form.FormServlet");
    	result.attr("name", HTMLEnv.getFormName());
    	
    	result.appendChild(createHiddenInput("configFile", GlobalEnv.getFileDirectory() + "/config.ssql"));
    	
        if(decos.containsKey("link")){
        	opt(decos.getStr("link"));
        	result.appendChild(createHiddenInput("sqlfile", path + "/" + decos.getStr("link").replaceAll("\"", "")));
        }

        if(decos.containsKey("cond")){
        	result.appendChild(createHiddenInput("cond1", path + "/" + decos.getStr("link").replaceAll("\"", "")));
        }

        
        if(decos.containsKey("updatefile")){
        	result.appendChild(createHiddenInput("updateFile", path + "/" + opt(decos.getStr("updatefile"))));
        }
        if(decos.containsKey("linkfile")){
        	opt(decos.getStr("linkfile"));
        	result.appendChild(createHiddenInput("linkfile", path + "/" + decos.getStr("linkfile").replaceAll("\"", "")));
        }
        if(decos.containsKey("cond")){
        	result.appendChild(createHiddenInput("linkcond", decos.getStr("cond").replaceAll("\"", "")));
        }
        return result;
    }

    public static String createForm(DecorateList decos) {
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
        	opt(decos.getStr("link"));
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
        	opt(decos.getStr("linkfile"));
        	form += "<input type=\"hidden\" name=\"linkfile\" value=\"" + path + "/" +decos.getStr("linkfile").replaceAll("\"", "")+"\" />";
        }
        if(decos.containsKey("cond")){
        	form += "<input type=\"hidden\" name=\"linkcond\" value=\"" + decos.getStr("cond").replaceAll("\"", "")+"\" />";
        }
        Log.out(form);
        HTMLEnv.setFormDetail(form);
        return form;
    }

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
        htmlEnv.linkUrl = this.getAtt("server_path", GlobalEnv
                .getInvokeServletPath())
                + "?"
                + "config="+path+"/config.ssql"
                + "&"
                + "query=" + filename
                + "&"
                + "cond=" + this.getAtt("condition");
        // end tk//////////////////////////////////////////////////

        htmlEnv.linkFlag=1;
        this.workAtt("default");
        htmlEnv.linkFlag=0;

        return;
    }

    private void Func_foreach(ExtList data_info) throws UnsupportedEncodingException {
    	String att = new String();
    	for (int i = 0; i < this.countconnectitem(); i++) {
    		att = att + "_" + this.getAtt(Integer.toString(i));
    	}
        //String filename = html_env.outfile + "_" + this.getAtt("default") + ".html";
    	att = URLEncoder.encode(att, "UTF-8");
    	String filename = htmlEnv.outFile + att + ".html";

        htmlEnv.fileName = filename;
        //System.out.println(filename);
        return;
    }

    //tk start//////////////////////////////////////////////////////////////////////////////
    private void Func_embed(ExtList data_info){
    	String file = this.getAtt("file");
    	String where = this.getAtt("where");
    	String att = this.getAtt("att");
    	this.getAtt("border");
    	String att2 = this.getAtt("attString");
    	String condition = new String();
    	this.getAtt("defcond");


    	Log.out("function embed");
		Log.out("isNewEmbed:"+GlobalEnv.isNewEmbed());

		boolean is_hidden = false;

		if(decos.containsKey("status"))
        	if(decos.getStr("status").compareTo("hidden") == 0)
        		is_hidden = true;

		//for tab
		if(decos.containsKey("tab"))
		{
			htmlEnv.code.append("<div id=\"myTab\" ");

			if(decos.containsKey("class"))
				htmlEnv.code.append("class=\""+decos.getStr("class")+"\"");

			htmlEnv.code.append(">\n");
			htmlEnv.code.append("<div id=\"mTab\" class=\"yui-navset\">\n");

			htmlEnv.code.append("</div></div>\n");

			htmlEnv.script.append("var mTab = new YAHOO.widget.TabView(\"mTab\");");
    		htmlEnv.script.append("new YAHOO.util.DDTarget(\"myTab\", \"myTab\");");

			return;
		}

        if(!is_hidden)
        {
        	htmlEnv.code.append("<table class=\"att " + htmlEnv.getOutlineModeAtt() + " ");

        	if(decos.containsKey("class"))
        		htmlEnv.code.append(decos.getStr("class"));
        	else
        		htmlEnv.code.append(HTMLEnv.getClassID(this));

        	htmlEnv.code.append("\"");
        	htmlEnv.code.append("><tr><td>");
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
        	htmlEnv.script.append("new YAHOO.util.DDTarget(\""+divname+"\", \""+divname+"\");");
        }
        //ajax & decos contains status=hidden
        if(is_hidden && GlobalEnv.isAjax()){

			htmlEnv.code.append("<div id=\""+divname+"\" ");

			if(decos.containsKey("class"))
				htmlEnv.code.append("class=\""+decos.getStr("class")+ "\" ");

			htmlEnv.code.append("></div>");
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

    	htmlEnv.embedCount++;

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
                   			htmlEnv.code.append(line);
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
	    			parser = new SSQLparser(10000*(htmlEnv.embedCount+1));
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

					htmlEnv.code.append("<div id=\""+divname+"\" ");

					if(decos.containsKey("class"))
						htmlEnv.code.append("class=\""+decos.getStr("class")+ "\" ");

					htmlEnv.code.append(">");
//	    			html_env.code.append("<br><a href=\"close.html\" class=\"bottom_close_"+divname+"\" onClick=\"return closeDiv('"+divname+"')\">close</a><br>");
					Log.out("<div id="+divname+">");
				}

				//xmlを出力
				if(!is_hidden){
					htmlEnv2.code.append("<EMBED>");
					htmlEnv.code.append(returnedcode);
					htmlEnv2.code.append(returnedcode);
					htmlEnv2.code.append("</EMBED>");
				}

				if(GlobalEnv.isAjax())
					htmlEnv.code.append("</div>");
				// end ajax /////////////////////////////////////////////////////////////////

				if(htmlEnv.embedCount >= 1)
				{
					htmlEnv.css.append(codegenerator.generateCode3(parser,dc.getData()));
					htmlEnv.cssFile.append(codegenerator.generateCssfile(parser,dc.getData()));
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

			        	out.write(htmlEnv.header.toString());
			        	out.write(returnedcode.toString());
			        	out.write(htmlEnv.footer.toString());

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
			                    + GlobalEnv.getEmbedTmp() + "\" is not found to write " + htmlEnv.fileName );

		                GlobalEnv.addErr("Error: specified embedtmp outdirectory \""
			                    + GlobalEnv.getEmbedTmp() + "\" is not found to write " + htmlEnv.fileName);
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
            			String path = htmlEnv.outFile;
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
               			htmlEnv.header.append(line+"\n");
               	}
               	line = dis.readLine(); //read <body>

    			htmlEnv.code.append("<div id=\""+divname+"\" ");

    			if(decos.containsKey("class"))
    				htmlEnv.code.append("class=\""+decos.getStr("class")+ "\" ");

    			htmlEnv.code.append(">");


       			htmlEnv2.code.append("<EMBED>");
               	while(!line.equalsIgnoreCase("</body>"))
               	{
               		Log.out("line : "+line);
               		line = dis.readLine();
               		if(!line.equalsIgnoreCase("</body>")){
               			htmlEnv.code.append(line);
               	        if(line.contains("&"))
               	        	line = line.replace("&", "&amp;");
               			if(line.contains("<"));
               				line = line.replace("<", "&lt;");
               			if(line.contains(">"))
               		        line = line.replace(">", "&gt;");
               	        if(line.contains("~"))
               	        	line = line.replace("~", "&#65374;");
               			htmlEnv2.code.append(line);
               		}
               	}
       			htmlEnv2.code.append("</EMBED>");
//    			html_env.code.append("<br><a href=\"close.html\" class=\"bottom_close_"+divname+"\" onClick=\"return closeDiv('"+divname+"')\">close</a><br>");

               	htmlEnv.code.append("</div>");
                dis.close();

            } catch (MalformedURLException me) {
                System.out.println("MalformedURLException: " + me);
            } catch (IOException ioe) {
                System.out.println("HTMLFuncEmbed:IOException: " + ioe);
            }

    	}
    	if(!is_hidden)
    		htmlEnv.code.append("</td></tr></table>");

    	htmlEnv.embedCount += 1;
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
        htmlEnv.linkUrl = filename;
        htmlEnv.sinvokeFlag = true;

		}else{
			String filename = new String();
	        if(!this.getAtt("att").equals(""))
	        	filename = action + "/" + this.getAtt("att");
	        else
	        	filename = action + att;

	        filename.replace("\\\\","\\");
	        htmlEnv.linkUrl = filename;
	        htmlEnv.sinvokeFlag = true;
		}

        //tk to make hyper link to image///////////////////////////////////////////////////
        //tk to ajax
        if(GlobalEnv.isAjax())
        {
        	htmlEnv.linkUrl =  file+".html";
        	htmlEnv.ajaxQuery = file+".sql";
//        	html_env.ajaxatt = this.getAtt("att");
        	htmlEnv.ajaxCond = this.getAtt("ajaxcond")+"="+this.getAtt("att");

    		Date d2 = new Date();
    		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyymmddHHmmss");
    		String today2 = sdf2.format(d2);

        	htmlEnv.dragDivId = htmlEnv.ajaxQuery+"+"+htmlEnv.ajaxCond+"&"+today2;

        	if(decos.containsKey("in"))
        	{
        		String effect = decos.getStr("in");

        		if(effect.equalsIgnoreCase("blind"))
        			htmlEnv.inEffect = 1;
        		if(effect.equalsIgnoreCase("fade"))
        			htmlEnv.inEffect = 2;
        	}
        	if(decos.containsKey("out"))
        	{
        		String effect = decos.getStr("out");

        		if(effect.equalsIgnoreCase("blind"))
        			htmlEnv.outEffect = 1;
        		if(effect.equalsIgnoreCase("fade"))
        			htmlEnv.outEffect = 2;
        	}

        	if(decos.containsKey("panel"))
        	{
        		htmlEnv.isPanel = true;
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
            			htmlEnv.ajaxtarget = tmp2 + "_" + this.getAtt("att");
            		}
            		else
            			htmlEnv.ajaxtarget = dispdiv;
            	}
            	else
            	{
            		htmlEnv.ajaxtarget = dispdiv;
            	}
            	htmlEnv.hasDispDiv = true;
            	Log.out("html_env.ajaxtarget:"+htmlEnv.ajaxtarget);
        	}
        	else if(decos.containsKey("dragto"))
        	{
        		Log.out("draggable = ture");
        		htmlEnv.draggable = true;


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


        		//script 生成
        		Date d1 = new Date();
        		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
        		String today = sdf.format(d1);

        		String scriptname = "drop"+today + htmlEnv.scriptNum;
        		htmlEnv.script.append(scriptname+" = new DragDrop(\""+
        				htmlEnv.dragDivId+"\", \""+droptarget[0]+"\");\n");

        		Log.out(scriptname+" = new DragDrop(\""+
        				htmlEnv.dragDivId+"\", \""+droptarget[0]+"\");\n");

        		//for tab
        		htmlEnv.script.append(scriptname+".addToGroup(\"myTab\");\n");

        		for(int i = 1; i < targetnum ; ++i)
        		{
        			htmlEnv.script.append(scriptname+".addToGroup(\""+droptarget[i]+"\");\n");
        		}

        		htmlEnv.scriptNum++;
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

        htmlEnv.sinvokeFlag = false;
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
    
    private static Element createHiddenInput(String name, String value){
    	Element result = new Element(Tag.valueOf("input"), "");
    	result.attr("name", name);
    	result.attr("type", "hidden");
    	result.attr("value", value);
    	return result;
    }

}
