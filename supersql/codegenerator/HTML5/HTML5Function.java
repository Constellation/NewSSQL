package supersql.codegenerator.HTML5;

import java.io.UnsupportedEncodingException;

import supersql.codegenerator.DecorateList;
import supersql.codegenerator.Manager;
import supersql.codegenerator.HTML.HTMLFunction;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTML5Function extends HTMLFunction {
	private static int meter_id=0;
	private static String updateFile;

    public HTML5Function()
    {

    }
    public HTML5Function(Manager manager, HTML5Env henv, HTML5Env henv2) {
        super(manager, henv, henv2);
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
        htmlEnv.append_css_def_td(HTML5Env.getClassID(this), this.decos);
    }
    
    private void Func_youtube(){
    	/*
    	 * <object width="480" height="385"><param name="movie" value="http://www.youtube.com/v/f3Afu5CBZUA?fs=1&amp;hl=ja_JP"></param><param name="allowFullScreen" value="true"></param><param name="allowscriptaccess" value="always"></param><embed src="http://www.youtube.com/v/f3Afu5CBZUA?fs=1&amp;hl=ja_JP" type="application/x-shockwave-flash" allowscriptaccess="always" allowfullscreen="true" width="480" height="385"></embed></object>
         */

        String path = this.getAtt("default");
    	String a = "<object width=\"480\" height=\"385\">" +
    			"<param name=\"movie\" value=\"http://www.youtube.com/v/" +
    			path +
    			"?fs=1&amp;hl=ja_JP\"></param><param name=\"allowFullScreen\" value=\"true\">" +
    			"</param><param name=\"allowscriptaccess\" value=\"always\"></param><embed src=\"http://www.youtube.com/v/" +
    			path +
    			"?fs=1&amp;hl=ja_JP\" type=\"application/x-shockwave-flash\" " +
    			"allowscriptaccess=\"always\" allowfullscreen=\"true\" width=\"480\" height=\"385\">" +
    			"</embed></object>";
    	htmlEnv.code.append(a);
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

       	htmlEnv.code.append("<video class=\"" + HTML5Env.getClassID(this) +"\" ");
       	if(decos.containsKey("class"))
    		htmlEnv.code.append(decos.getStr("class"));

    	htmlEnv.code.append(" \" src=\"" + path + "/" + this.getAtt("default")+"\"");
    	htmlEnv.code.append("autobuffer controls poster=\"http://www.db.ics.keio.ac.jp/ssql/img/ssqllogo.gif\">" +
    			"<p>Try this page in Safari 4! Or you can <a href=\"" +
    			path + "/" + this.getAtt("default")+"\"" +
    			">download the video</a> instead.</p>");

    	return;
    }
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


       	htmlEnv.code.append("<script type=\"text/javascript\">addEvent(window,\"load\",function() { \nvar layout = [");
      	if(decos.containsKey("width"))
       		htmlEnv.code.append(decos.getStr("width"));
      	htmlEnv.code.append(",");
      	if(decos.containsKey("height"))
       		htmlEnv.code.append(decos.getStr("height"));
      	htmlEnv.code.append(",");
      	if(decos.containsKey("m_width"))
       		htmlEnv.code.append(decos.getStr("m_width"));
      	htmlEnv.code.append(",");
      	if(decos.containsKey("m_height"))
       		htmlEnv.code.append(decos.getStr("m_height"));
      	htmlEnv.code.append(",");
      	if(decos.containsKey("max"))
       		htmlEnv.code.append(decos.getStr("max"));
      	htmlEnv.code.append(",");
      	if(decos.containsKey("min"))
       		htmlEnv.code.append(decos.getStr("min"));
      	htmlEnv.code.append(",");
      	if(decos.containsKey("low"))
       		htmlEnv.code.append(decos.getStr("low"));
      	htmlEnv.code.append(",");
      	if(decos.containsKey("high"))
       		htmlEnv.code.append(decos.getStr("high"));
      	htmlEnv.code.append("] \nvar color = [");
      	if(decos.containsKey("max_color"))
       		htmlEnv.code.append(decos.getStr("max_color"));
      	htmlEnv.code.append(",");
      	if(decos.containsKey("low_color"))
       		htmlEnv.code.append(decos.getStr("low_color"));
      	htmlEnv.code.append(",");
      	if(decos.containsKey("high_color"))
       		htmlEnv.code.append(decos.getStr("high_color"));
      	htmlEnv.code.append(",");
      	if(decos.containsKey("mid_color"))
       		htmlEnv.code.append(decos.getStr("mid_color"));
      	htmlEnv.code.append(",");
      	if(decos.containsKey("bg_color"))
      		htmlEnv.code.append(decos.getStr("bg_color"));
      	htmlEnv.code.append("] \ndraw(\"meter"+meter_id+"\",layout,color,"+this.getAtt("default") +");});</script>");

      	htmlEnv.code.append("<div><canvas ");
    	if(decos.containsKey("width"))
       		htmlEnv.code.append("width=" + decos.getStr("width") + " ");
       	else
       		htmlEnv.code.append("width = 200 ");
    	if(decos.containsKey("height"))
       		htmlEnv.code.append("height=" + decos.getStr("height") + " ");
       	else
       		htmlEnv.code.append("height = 40 ");
     	htmlEnv.code.append("id=\"meter"+meter_id+"\"></canvas></div>");
    }

    public static String createForm(DecorateList decos) {
    	new String();
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
        HTML5Env.setFormDetail(form);
        return form;
    }

}
