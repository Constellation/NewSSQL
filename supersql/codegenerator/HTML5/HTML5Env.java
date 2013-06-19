package supersql.codegenerator.HTML5;

import supersql.codegenerator.Connector;
import supersql.codegenerator.DecorateList;
import supersql.codegenerator.HTML.HTMLEnv;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.common.Utils;
import supersql.parser.SSQLparser;

public class HTML5Env extends HTMLEnv {

    public HTML5Env() {
    	super();
    }


    public void getHeader() {
   		int index = 0;
        header.insert(index,"<HEAD>\n");
        header.insert(index,"<HTML>\n");
        header.insert(index,"<!doctype html>\n");
        Log.out("<!docutype html>");
        Log.out("<HTML>");
        Log.out("<head>");
    	header.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
    	header.append("<meta http-equiv=\"Content-Language\" content=\"ja\" />");
    	header.append("<meta http-equiv=\"Content-Style-Type\" content=\"text/css\" />");
    	header.append("<meta http-equiv=\"Content-Script-Type\" content=\"text/javascript\" />");
    	header.append("<script type=\"text/javascript\" src=\"http://primera.db.ics.keio.ac.jp/ishizaki/ssql_meter.js\"></script>");

        Log.out("<style type=text/css><!--");

        header.append(cssFile);
        //style��head�˽񤭹���
        header.append("<STYLE TYPE=text/css><!--\n");
        commonCSS();
        header.append(css);
        Log.out(css.toString());

        header.append("--></STYLE>");

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


        header.append("</HEAD>\n");

        header.append("<BODY class=\"body\">\n");

        header.append("<div");
        header.append(div);
        header.append(titleClass);
        header.append(">");
        header.append(title);
        //tk end///////////////////////////////////////////////////////
        //chie//

        Log.out("--></style></head>");
        Log.out("<body>");
//ishizaki start(ここから/servlet/super...を/superに訂正)(225,231,238)
        if(Connector.loginFlag ){
        	//header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/servlet/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
        	header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
        	header.append("<input type=\"hidden\" name=\"tableinfo\" value=\"" + SSQLparser.get_from_info_st() + "\" >");
        	header.append("<input type=\"hidden\" name=\"configfile\" value=\"" + GlobalEnv.getconfigfile() + "\" >");
        }

        if(Connector.logoutFlag ){
        	//header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/servlet/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
        	header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
        	//header.append("<input type=\"hidden\" name=\"tableinfo\" value=\"" + SSQLparser.get_from_info_st() + "\" >");
        	header.append("<input type=\"hidden\" name=\"configfile\" value=\"" + GlobalEnv.getconfigfile() + "\" >");
        }


        if(Connector.insertFlag || Connector.deleteFlag || Connector.updateFlag){
        	//???header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/servlet/supersql.form.Update\" method = \"post\" name=\"theForm\">\n");
        	header.append("<form action = \""+ GlobalEnv.getFileDirectory() + "/supersql.form.Update\" method = \"post\" name=\"theForm\">\n");
        	header.append("<input type=\"hidden\" name=\"tableinfo\" value=\"" + SSQLparser.get_from_info_st() + "\" >");
        	header.append("<input type=\"hidden\" name=\"configfile\" value=\"" + GlobalEnv.getconfigfile() + "\" >");

        	if(Connector.insertFlag)
        		header.append("<input type=\"hidden\" name=\"sql_param\" value=\"insert\" >");
        	if(Connector.deleteFlag)
        		header.append("<input type=\"hidden\" name=\"sql_param\" value=\"delete\" >");
        	if(Connector.updateFlag)
            	header.append("<input type=\"hidden\" name=\"sql_param\" value=\"update\" >");

/*/ishizaki st (XForms)
        	header.append("<submission action=\""+ GlobalEnv.getFileDirectory() + "/supersql.form.Update\" method = \"form-data-post\" id=\"theForm\">\n");
        	header.append("<instance><data xmlns=\"\"><tableinfo>" + SSQLparser.get_from_info_st() + "</tableinfo></data></instance>");
        	header.append("<instance><data xmlns=\"\"><configfile>"+ GlobalEnv.getconfigfile() + "</configfile></data></instance>");
        	if(connector.insert_flag)
        		header.append("<instance><data xmlns=\"\"><sql_param>insert</sql_param></data></instance>");
        	if(connector.delete_flag)
        		header.append("<instance><data xmlns=\"\"><sql_param>delete</sql_param></data></instance>");
        	if(connector.update_flag)
        		header.append("<instance><data xmlns=\"\"><sql_param>update</sql_param></data></instance>");
//ishizaki end(XForms)
*/        }

    }
//ishizaki st
    public void getFooter() {
    	if(Connector.updateFlag || Connector.insertFlag|| Connector.deleteFlag || Connector.loginFlag ){

	    	footer.append("<input type=\"submit\" name=\"login\" value=\"Let's go!\">");
	    	footer.append("</form>\n");

    		//footer.append("<submit submission=\"theForm\"><label>Let's go</label></submit>");

	    	Log.out("</form>");
        	Connector.updateFlag = false;
        	Connector.insertFlag = false;
        	Connector.deleteFlag = false;
        	Connector.loginFlag = false;
    	}
//ishizaki end

    	if(Connector.logoutFlag ){
	    	footer.append("</form>\n");
	    	Log.out("</form>");
        	Connector.logoutFlag = false;
    	}

        footer.append("<BR><BR></BODY></HTML>\n");
        Log.out("</body></html>");
        header_creation();
    }

    public void append_css_def_td(String classid, DecorateList decos) {
    	haveClass=0;
    	Log.out("[HTML append_css_def_att] classid=" + classid);
        Log.out("decos = " + decos);

        //��classid�Υ�����?�����Ȥ��������ꤷ�����Ȥ���?��
        if (writtenClassId.contains(classid)) {
            // �����?�ѤΥ�����?������
        	haveClass=1;
            Log.out("==> already created style");
            return;
        }else if(notWrittenClassId != null && notWrittenClassId.contains(classid)){
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
        	cssFile.delete(0,cssFile.length());
        	if(GlobalEnv.isServlet()){
            	cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + GlobalEnv.getFileDirectory() + decos.getStr("cssfile") + "\">\n");
            }else{
            	cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + decos.getStr("cssfile") + "\">\n");
            }
        }else if(cssFile.length() == 0){
        	if(GlobalEnv.isServlet()){
            	cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + GlobalEnv.getFileDirectory() +"/default.css \">\n");
            }else{
            	if(Utils.getOs().contains("Windows")){
            		cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"default.css\">\n");
            	}else{
            		//itc
            		if(GlobalEnv.isOpt())
            			cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.db.ics.keio.ac.jp/ssqlcss/default_opt.css\">\n");
            		else
            			cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.db.ics.keio.ac.jp/ssqlcss/default.css\">\n");
            	}
            }
        }

        if (decos.containsKey("divalign") && div.length() == 0)
        	div.append(" align=" +decos.getStr("divalign"));

        if (decos.containsKey("title") && title.length() == 0)
        	title.append(decos.getStr("title"));
        if (decos.containsKey("title_class"))
        	titleClass.append(" class=\""+decos.getStr("title_class")+"\"");
        if (decos.containsKey("tableborder") )//&& tableborder.length() == 0)
        	tableBorder = decos.getStr("tableborder");

        //tk end//////////////////////////////////////////////////////////////
        
        computeConditionalDecorations(decos, css);

        // ��??
        if (decos.containsKey("width")) {
            cssbuf.append(" width:" + decos.getStr("width") + ";");
            //        } else {
            //            cssbuf.append(" width:120;");
        }

        // ��??
        if (decos.containsKey("height"))
            cssbuf.append(" height:" + decos.getStr("height") + ";");


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
            cssbuf.append(" font-size:" + decos.getStr("font-size") + ";");
        if (decos.containsKey("font size"))
            cssbuf.append(" font-size:" + decos.getStr("font size") + ";");
        if (decos.containsKey("size"))
            cssbuf.append(" font-size:" + decos.getStr("size") + ";");

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
        if (decos.containsKey("charset"))
            metabuf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=" + decos.getStr("charset") + "\">");
 //      else
 //       	metabuf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=euc-jp\">");

        if (decos.containsKey("description"))
            metabuf.append("<meta name=\"Description\" content=\"" + decos.getStr("description") + "\">");
        if (decos.containsKey("keyword"))
            metabuf.append("<meta name=\"Keyword\" content=\"" + decos.getStr("keyword") + "\">");
        if (decos.containsKey("author"))
            metabuf.append("<meta name=\"Author\" content=\"" + decos.getStr("author") + "\">");
        if (decos.containsKey("pragma"))
            metabuf.append("<meta http-equiv=\"Pragma\" content=\"" + decos.getStr("pragma") + "\">");
        if (decos.containsKey("robot"))
            metabuf.append("<meta name=\"Robot\" content=\"" + decos.getStr("robot") + "\">");
        //tk end///////////////////////////////////////////////////////////////////

        if (cssbuf.length() > 0) {
        	haveClass = 1;
            //����?�Υ�����?����
            css.append("." + classid + "{");

            css.append(cssbuf);
            //��?�Υ�����?�Ĥ�
            css.append(" }\n");

            //������?��?�Ѥߥ��饹��id����¸���Ƥ���
            writtenClassId.addElement(classid);
        }else{
        	Log.out("==> style is null. not created style");
        	notWrittenClassId.addElement(classid);
        }

        //tk start//////////////////////////////////////////////////////////
        if(metabuf.length() > 0)
        {
            meta.append(" ");
            meta.append(metabuf);
         	meta.append("\n");

        }
       //tk end////////////////////////////////////////////////////////////


    }

}
