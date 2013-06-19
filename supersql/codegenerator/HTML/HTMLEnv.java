package supersql.codegenerator.HTML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Connector;
import supersql.codegenerator.DecorateList;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.LocalEnv;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.common.Utils;
import supersql.parser.SSQLparser;

public class HTMLEnv extends LocalEnv {
	private Document htmlEnv1;
	public Vector<String> writtenClassId;
	protected Connector connector;
	public Vector<String> notWrittenClassId = new Vector<String>();
	public int gLevel = 0;
	public String fileName;
	public String outFile;
	public String linkOutFile;
	public String nextBackFile = new String();
	public String outDir;
	public int countFile;
	public StringBuffer code;
	public StringBuffer css;
	protected static int IDCounter = 0; // add oka
	protected static int IDOld = 0; // add oka
	protected String charset = null; // added by goto 20120715
	private static boolean charsetFlg = false; // added by goto 20120715
	protected StringBuffer meta = new StringBuffer();
	protected StringBuffer div = new StringBuffer();
	protected StringBuffer title = new StringBuffer();
	protected StringBuffer titleClass = new StringBuffer();
	public StringBuffer cssFile = new StringBuffer();
	public String tableBorder = new String("1");
	public boolean embedFlag = false;
	public int embedCount = 0;
	public int haveClass = 0;
	
	// for ajax
	public String ajaxQuery = new String();
	public String ajaxCond = new String();
	public String ajaxtarget = new String();
	public int inEffect = 0;
	public int outEffect = 0;
	public boolean hasDispDiv = false;
	
	// for drag
	public StringBuffer script = new StringBuffer();
	public int scriptNum = 0;
	public boolean draggable = false;
	public String dragDivId = new String();

	// for panel
	public boolean isPanel = false;
	// tk end//////////////////////////////////////////////////////

	public StringBuffer header;
	public StringBuffer footer;
	public boolean foreachFlag;
	public boolean sinvokeFlag = false;
	public int linkFlag;
	public String linkUrl;

	// outline����Ϥ����ɤ����Υե饰��?
	protected boolean OutlineMode = false;
	private static boolean isFormItem;
	private static String formItemName;
	private static boolean selectFlg;
	private static String formValueString;
	private static boolean selectRepeat;

	// global form item number : t1,t2,t3...
	public static int formPartsNumber = 1;
	static String formPartsName = null;

	// global form number : 1,2,3...
	private static int formNumber = 1;
	private static String[] formDetail = new String[256];
	private static String IDUst = new String();
	private static String selected = "";
	public static String nameId = "";
	private static String checked = "";
	private static boolean search = false;
	public static int searchId = 0;
	public static String condName = "";
	public static String cond = "";
	
	public HTMLEnv() {
		// TODO Put the file name in the configuration
		File input = new File("template.html");
		try {
			this.htmlEnv1 = Jsoup.parse(input, "UTF-8", "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createHeader() {
		Attributes attributes = new Attributes();
		attributes.put("type", "text/css");
		Element style = new Element(Tag.valueOf("style"), "", attributes);

		if (GlobalEnv.isOpt()) {
			style.text("<!--\n.att { padding: 0px; margin : 0px;height : 100%; z-index: 2}\n"
					+ ".linkbutton {text-align:center; margin-top: 5px; padding:5px;}\n"
					+ ".embed { vertical-align : text-top; padding : 0px ; margin : 0px; border: 0px,0px,0px,0px; width: 100%;}"
					+ ".noborder { 	border-width : 0px; "
					+ "-top : -1px; padding-top : -1px;	"
					+ "-bottom : -1px;	padding-bottom : -1px;}\n-->\n"
					+ "</style>");
		}

		htmlEnv1.head().appendChild(style);

		Attributes meta_attributes = new Attributes();
		meta_attributes.put("http-equiv", "Content-Type");
		meta_attributes.put("content", "text-html");
		meta_attributes.put("charset", "UTF-8");
		Element meta = new Element(Tag.valueOf("meta"), "", meta_attributes);

		htmlEnv1.head().appendChild(meta);

		if (GlobalEnv.isAjax()) {
			String js = GlobalEnv.getJsDirectory();

			if (js != null) {
				if (js.endsWith("/"))
					js = js.substring(0, js.lastIndexOf("/"));
				htmlEnv1.head().appendChild(
						JsoupFactory.createJsElement(js + "/prototype.js"));
				htmlEnv1.head().appendChild(JsoupFactory.createJsElement(js + "/ajax.js"));
			} else {
				htmlEnv1.head()
						.appendChild(
								JsoupFactory.createJsElement("http://localhost:8080/tab/prototype.js"));
				htmlEnv1.head().appendChild(
						JsoupFactory.createJsElement("http://localhost:8080/tab/ajax.js"));
			}

			// Insertion of javascript files
			ArrayList<Element> elements = JsoupFactory.createJsElements("js/lightbox.js",
					"js/scriptaculous.js?load=effects", "js/prototype.js",
					"build/animation/animation.js",
					"build/container/container.js", "build/tabview/tabview.js",
					"build/element/element-beta.js", "prototype.js",
					"ssqlajax.js", "build/yahoo/yahoo-min.js",
					"build/event/event-min.js", "build/dom/dom-min.js",
					"build/dragdrop/dragdrop-min.js");

			for (Element element : elements) {
				htmlEnv1.head().appendChild(element);
			}

			// Insertion of css files
			elements = JsoupFactory.createStylesheetElements(
					"build/tabview/assets/border_tabs.css",
					"build/tabview/assets/tabview.css",
					"build/container/assets/container.css");
			for (Element element : elements) {
				htmlEnv1.head().appendChild(element);
			}
			elements = JsoupFactory.createStylesheetElements(new String[] {
					"css/lightbox.css", "screen" }, new String[] {
					"css/tabview-core.css", "screen" }, new String[] {
					"css/panel.css", "screen" });
			for (Element element : elements) {
				htmlEnv1.head().appendChild(element);
			}
			Attributes jsType = new Attributes();
			attributes.put("type", "text/javascript");
			Element element = new Element(Tag.valueOf("script"), "", jsType);
			element.text(script.toString());
			htmlEnv1.appendChild(element);
		} else {

		}

	}

	public void createSSQLForm() {
		if (Connector.loginFlag) {
			htmlEnv1.body().appendChild(createLoginForm());
		} else if (Connector.logoutFlag) {
			htmlEnv1.body().appendChild(createLogoutForm());
		} else if (Connector.insertFlag || Connector.deleteFlag
				|| Connector.updateFlag) {
			Element form = createInsertDeleteUpdateForm();
			if (Connector.insertFlag)
				form.appendChild(JsoupFactory.createInput("hidden", "sql_param", "insert"));
			if (Connector.deleteFlag)
				form.appendChild(JsoupFactory.createInput("hidden", "sql_param", "delete"));
			if (Connector.updateFlag)
				form.appendChild(JsoupFactory.createInput("hidden", "sql_param", "update"));

			form.appendChild(JsoupFactory.createInput("submit", "login", "Let's go!"));
			htmlEnv1.appendChild(form);
		}
	}
	
	public void createFooter(){
		if (Connector.updateFlag || Connector.insertFlag
				|| Connector.deleteFlag || Connector.loginFlag) {
			htmlEnv1.body().getElementsByTag("form").last().appendChild(JsoupFactory.createInput("submit", "login", "Let's go!"));
			Connector.updateFlag = false;
			Connector.insertFlag = false;
			Connector.deleteFlag = false;
			Connector.loginFlag = false;
		}

		if (Connector.logoutFlag) {
			Connector.logoutFlag = false;
		}

		fillHeadTag();
	}

	public void includeDecorationProperties(String classId, DecorateList decos) {
		haveClass = 0;
		// TODO refactor this part
		if (writtenClassId.contains(classId)) {
			haveClass = 1;
			Log.out("==> already created style");
			return;
		} else if (notWrittenClassId != null
				&& notWrittenClassId.contains(classId)) {
			Log.out("==> style is null. not created style");
			return;
		}

		if (decos.containsKey("class")) {
			cssclass.put(classId, decos.getStr("class"));
			Log.out("class =" + classId + decos.getStr("class"));
		}

		if (decos.containsKey("divalign"))
			div.append(" align=" + decos.getStr("divalign"));

		if (decos.containsKey("title")) {
			if (decos.contains("title_class")) {
				Attributes titleAttribute = new Attributes();
				titleAttribute.put("class", decos.getStr("title_class"));
				Element title = new Element(Tag.valueOf("title"), "",
						titleAttribute);
				title.html(decos.getStr("title"));
				htmlEnv1.head().appendChild(title);
			} else {
				Element title = new Element(Tag.valueOf("title"), "");
				title.html(decos.getStr("title"));
				htmlEnv1.appendChild(title);
			}

			// TODO something to put a h1 tag for the title
		}

		if (decos.containsKey("tableborder"))
			tableBorder = decos.getStr("tableborder");

		computeConditionalDecorations(decos, css);

		// TODO a lot of decorations should be added but in css file, we should
		// call another method here

		Attributes attributes = new Attributes();

		// added by goto 20120715 start
		if (decos.containsKey("charset"))
			charset = decos.getStr("charset");
		else if (!charsetFlg)
			charset = "EUC-JP"; // default charset = EUC-JP
		if (!charsetFlg && charset != null) {
			attributes.put("http-equiv", "Content-Type");
			attributes.put("content", "text/html");
			attributes.put("charset", charset);
			htmlEnv1.head().appendChild(
					new Element(Tag.valueOf("meta"), "", attributes));
			charsetFlg = true;
		}

		if (decos.containsKey("description")) {
			attributes = new Attributes();
			attributes.put("name", "Description");
			attributes.put("content", decos.getStr("description"));
			htmlEnv1.head().appendChild(
					new Element(Tag.valueOf("meta"), "", attributes));
		}
		if (decos.containsKey("keyword")) {
			attributes = new Attributes();
			attributes.put("name", "Keyword");
			attributes.put("content", decos.getStr("keyword"));
			htmlEnv1.head().appendChild(
					new Element(Tag.valueOf("meta"), "", attributes));
		}
		if (decos.containsKey("author")) {
			attributes = new Attributes();
			attributes.put("name", "Author");
			attributes.put("content", decos.getStr("author"));
			htmlEnv1.head().appendChild(
					new Element(Tag.valueOf("meta"), "", attributes));
		}
		if (decos.containsKey("pragma")) {
			attributes = new Attributes();
			attributes.put("name", "Pragma");
			attributes.put("content", decos.getStr("pragma"));
			htmlEnv1.head().appendChild(
					new Element(Tag.valueOf("meta"), "", attributes));
		}
		if (decos.containsKey("robot")) {
			attributes = new Attributes();
			attributes.put("name", "Robot");
			attributes.put("content", decos.getStr("robot"));
			htmlEnv1.head().appendChild(
					new Element(Tag.valueOf("meta"), "", attributes));
		}

		if ("".length() > 0) {
			// TODO
		} else {
			Log.out("==> style is null. not created style");
			notWrittenClassId.addElement(classId);
		}
	}
	
	public void fillHeadTag(){
		if (GlobalEnv.isAjax()) {
			String js = GlobalEnv.getJsDirectory();
			if (js != null) {
				if (js.endsWith("/"))
					js = js.substring(0, js.lastIndexOf("/"));
				htmlEnv1.head().appendChild(JsoupFactory.createJsElement(js + "/prototype.js"));
				htmlEnv1.head().appendChild(JsoupFactory.createJsElement(js+ "/ajax.js"));
			} else {
				htmlEnv1.head().appendChild(JsoupFactory.createJsElement("http://localhost:8080/tab/prototype.js"));
				htmlEnv1.head().appendChild(JsoupFactory.createJsElement("http://localhost:8080/tab/ajax.js"));
			}

			ArrayList<Element> javascripts = JsoupFactory.createJsElements("build/yahoo/yahoo-min.js", "build/event/event-min.js", "build/dom/dom-min.js",
					"build/dragdrop/dragdrop-min.js", "ssqlajax.js", "prototype.js", "build/element/element-beta.js", "build/tabview/tabview.js",
					"build/container/container.js", "build/animation/animation.js", "js/prototype.js", "js/scriptaculous.js?load=effects", "js/lightbox.js");
			
			for(Element e : javascripts){
				htmlEnv1.head().appendChild(e);
			}
			
			ArrayList<Element> stylesheets = JsoupFactory.createStylesheetElements("build/tabview/assets/border_tabs.css", "build/tabview/assets/tabview.css", "build/container/assets/container.css",
					"css/lightbox.css", "css/tabview-core.css", "css/panel.css");
			
			for(Element e : stylesheets){
				htmlEnv1.head().appendChild(e);
			}

			Element inlineJavascript = new Element(Tag.valueOf("script"), "");
			inlineJavascript.appendText(script.toString());
			htmlEnv1.head().appendChild(inlineJavascript);
			
		}

		if (GlobalEnv.getframeworklist() == null) {
			htmlEnv1.body().addClass("body");
			header.append("<BODY class=\"body\">\n");
			Element divElement = new Element(Tag.valueOf("div"), "");
			divElement.append(title.toString());
			//TODO
			//header.append("<div");
			//header.append(div);
			//header.append(titleClass);
			//header.append(">");
			header.append(title);
		}

		if (Connector.loginFlag) {
			Element form = new Element(Tag.valueOf("form"), "");
			form.attr("action", GlobalEnv.getFileDirectory() + "/servlet/supersql.form.Session").attr("method", "post").attr("name", "theForm");
			form.appendChild(JsoupFactory.createInput("hidden", "tableinfo", SSQLparser.get_from_info_st()));
			form.appendChild(JsoupFactory.createInput("hidden", "configfile", GlobalEnv.getconfigfile()));
			htmlEnv1.body().appendChild(form);
		}

		if (Connector.logoutFlag) {
			Element form = new Element(Tag.valueOf("form"), "");
			form.attr("action", GlobalEnv.getFileDirectory() + "/servlet/supersql.form.Session").attr("method", "post").attr("name", "theForm");
			form.appendChild(JsoupFactory.createInput("hidden", "configfile", GlobalEnv.getconfigfile()));
			htmlEnv1.body().appendChild(form);
		}

		if (Connector.insertFlag || Connector.deleteFlag
				|| Connector.updateFlag) {
			Element form = new Element(Tag.valueOf("form"), "").attr("action", "/servlet/supersql.form.Update").attr("method", "post").attr("name", "theForm");
			form.appendChild(JsoupFactory.createInput("hidden", "tableinfo", SSQLparser.get_from_info_st()));
			form.appendChild(JsoupFactory.createInput("hidden", "configfile", GlobalEnv.getconfigfile()));
			if (Connector.insertFlag)
				form.appendChild(JsoupFactory.createInput("hidden", "sql_param", "insert"));
			if (Connector.deleteFlag)
				form.appendChild(JsoupFactory.createInput("hidden", "sql_param", "delete"));
			if (Connector.updateFlag)
				form.appendChild(JsoupFactory.createInput("hidden", "sql_param", "update"));
		}
	}

	public void append_css_def_td(String classid, DecorateList decos) {
		haveClass = 0;
		Log.out("[HTML append_css_def_att] classid=" + classid);
		Log.out("decos = " + decos);

		// ��classid�Υ�����?�����Ȥ��������ꤷ�����Ȥ���?��
		if (writtenClassId.contains(classid)) {
			// ������ѤΥ�����?������
			haveClass = 1;
			Log.out("==> already created style");
			return;
		} else if (notWrittenClassId != null
				&& notWrittenClassId.contains(classid)) {
			Log.out("==> style is null. not created style");
			return;
		}

		Log.out("==> new style");
		Log.out("@@ creating style no " + classid);

		StringBuffer cssbuf = new StringBuffer();

		// tk
		// start////////////////////////////////////////////////////////////////
		StringBuffer metabuf = new StringBuffer();

		if (decos.containsKey("class")) {
			cssclass.put(classid, decos.getStr("class"));
			Log.out("class =" + classid + decos.getStr("class"));
		}

		if (decos.containsKey("cssfile")) {
			cssFile.delete(0, cssFile.length());
			if (GlobalEnv.isServlet()) {
				cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\""
						+ GlobalEnv.getFileDirectory()
						+ decos.getStr("cssfile") + "\">\n");
			} else {
				cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\""
						+ decos.getStr("cssfile") + "\">\n");
			}
		} else if (cssFile.length() == 0) {
			if (GlobalEnv.isServlet()) {
				cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\""
						+ GlobalEnv.getFileDirectory() + "/default.css \">\n");
			} else {
				if (Utils.getOs().contains("Windows")) {
					cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"default.css\">\n");
				} else {
					// itc
					if (GlobalEnv.isOpt())
						cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.db.ics.keio.ac.jp/ssqlcss/default_opt.css\">\n");
					else
						cssFile.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"http://www.db.ics.keio.ac.jp/ssqlcss/default.css\">\n");
				}
			}
		}

		if (decos.containsKey("divalign") && div.length() == 0)
			div.append(" align=" + decos.getStr("divalign"));

		if (decos.containsKey("title") && title.length() == 0)
			title.append(decos.getStr("title"));
		if (decos.containsKey("title_class"))
			titleClass.append(" class=\"" + decos.getStr("title_class") + "\"");
		if (decos.containsKey("tableborder"))// && tableborder.length() == 0)
			tableBorder = decos.getStr("tableborder");

		// tk end//////////////////////////////////////////////////////////////

		computeConditionalDecorations(decos, css);

		// ��??
		if (decos.containsKey("width")) {
			if (GlobalEnv.getframeworklist() == null)
				cssbuf.append(" width:" + decos.getStr("width") + ";");
			else
				cssbuf.append(" width:" + decos.getStr("width") + "px;");
			// } else {
			// cssbuf.append(" width:120;");
		}

		// ��??
		if (decos.containsKey("height")) {
			if (GlobalEnv.getframeworklist() == null)
				cssbuf.append(" height:" + decos.getStr("height") + ";");
			else
				cssbuf.append(" height:" + decos.getStr("height") + "px;");
		}

		// margin
		if (decos.containsKey("margin")) {
			cssbuf.append(" margin:" + decos.getStr("margin") + ";");
			// } else {
			// cssbuf.append(" padding:0.3em;");
		}

		// �ѥǥ��󥰡�;���
		if (decos.containsKey("padding")) {
			cssbuf.append(" padding:" + decos.getStr("padding") + ";");
			// } else {
			// cssbuf.append(" padding:0.3em;");
		}
		// padding
		if (decos.containsKey("padding-left")) {
			cssbuf.append(" padding-left:" + decos.getStr("padding-left") + ";");
		}
		if (decos.containsKey("padding-top")) {
			cssbuf.append(" padding-top:" + decos.getStr("padding-top") + ";");
		}
		if (decos.containsKey("padding-right")) {
			cssbuf.append(" padding-right:" + decos.getStr("padding-right")
					+ ";");
		}
		if (decos.containsKey("padding-bottom")) {
			cssbuf.append(" padding-bottom:" + decos.getStr("padding-bottom")
					+ ";");
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
			if (GlobalEnv.getframeworklist() == null)
				cssbuf.append(" font-size:" + decos.getStr("font-size") + ";");
			else
				cssbuf.append(" font-size:" + decos.getStr("font-size") + "px;");
		if (decos.containsKey("font size"))
			if (GlobalEnv.getframeworklist() == null)
				cssbuf.append(" font-size:" + decos.getStr("font size") + ";");
			else
				cssbuf.append(" font-size:" + decos.getStr("font size") + "px;");
		if (decos.containsKey("size"))
			if (GlobalEnv.getframeworklist() == null)
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

		if (decos.containsKey("border"))
			cssbuf.append(" border:" + decos.getStr("border") + ";");
		if (decos.containsKey("border-width"))
			cssbuf.append(" border-width:" + decos.getStr("border-width") + ";");
		if (decos.containsKey("border-color"))
			cssbuf.append(" border-color:" + decos.getStr("border-color") + ";");
		if (decos.containsKey("border-style"))
			cssbuf.append(" border-style:" + decos.getStr("border-style") + ";");
		if (decos.containsKey("border-collapse"))
			cssbuf.append(" border-collapse:" + decos.getStr("border-collapse")
					+ ";");

		// tk
		// start////////////////////////////////////////////////////////////////
		// added by goto 20120715 start
		if (decos.containsKey("charset"))
			charset = decos.getStr("charset");
		else if (!charsetFlg)
			charset = "EUC-JP"; // default charset = EUC-JP
		if (!charsetFlg && charset != null) {
			metabuf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset="
					+ charset + "\">");
			charsetFlg = true;
		}
		// if (decos.containsKey("charset")){
		// metabuf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset="
		// + decos.getStr("charset") + "\">");
		// charset=decos.getStr("charset");
		// charsetFlg=1;
		// }else if(charsetFlg!=1){
		// metabuf.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-JP\">");
		// charset="EUC-JP"; //default charset = EUC-JP
		// charsetFlg=1;
		// }
		// added by goto 20120715 end

		if (decos.containsKey("description"))
			metabuf.append("<meta name=\"Description\" content=\""
					+ decos.getStr("description") + "\">");
		if (decos.containsKey("keyword"))
			metabuf.append("<meta name=\"Keyword\" content=\""
					+ decos.getStr("keyword") + "\">");
		if (decos.containsKey("author"))
			metabuf.append("<meta name=\"Author\" content=\""
					+ decos.getStr("author") + "\">");
		if (decos.containsKey("pragma"))
			metabuf.append("<meta http-equiv=\"Pragma\" content=\""
					+ decos.getStr("pragma") + "\">");
		if (decos.containsKey("robot"))
			metabuf.append("<meta name=\"Robot\" content=\""
					+ decos.getStr("robot") + "\">");
		// tk
		// end///////////////////////////////////////////////////////////////////

		if (cssbuf.length() > 0) {
			haveClass = 1;
			// ����?�Υ�����?����
			css.append("." + classid + "{");

			css.append(cssbuf);
			// ��?�Υ�����?�Ĥ�
			css.append(" }\n");

			// ������?��?�Ѥߥ��饹��id����¸���Ƥ���
			writtenClassId.addElement(classid);
		} else {
			Log.out("==> style is null. not created style");
			notWrittenClassId.addElement(classid);
		}

        //tk start//////////////////////////////////////////////////////////
        if(metabuf.length() > 0)
        {
        	//meta.append(" ");		//commented out by goto 201303
            meta.append(metabuf);
         	meta.append("\n");

		}
		// tk end////////////////////////////////////////////////////////////

	}

	public void header_creation() {
		// tk start////////////////////////////////////////////////////
		header.append(meta);

		if (GlobalEnv.isAjax()) {
			String js = GlobalEnv.getJsDirectory();
			if (js != null) {
				if (js.endsWith("/"))
					js = js.substring(0, js.lastIndexOf("/"));

				header.append("<script src=\""
						+ js
						+ "/prototype.js\" type=\"text/javascript\"></script>\n");
				header.append("<script src=\"" + js
						+ "/ajax.js\" type=\"text/javascript\"></script>");

			} else {
				header.append("<script src=\"http://localhost:8080/tab/prototype.js\" type=\"text/javascript\"></script>\n");
				header.append("<script src=\"http://localhost:8080/tab/ajax.js\" type=\"text/javascript\"></script>");
			}

			header.append("<script type=\"text/javascript\" src=\"build/yahoo/yahoo-min.js\"></script>\n");
			header.append("<script type=\"text/javascript\" src=\"build/event/event-min.js\" ></script>\n");
			header.append("<script type=\"text/javascript\" src=\"build/dom/dom-min.js\"></script>\n");
			header.append("<script type=\"text/javascript\" src=\"build/dragdrop/dragdrop-min.js\" ></script>\n");
			header.append("<script type=\"text/javascript\" src=\"ssqlajax.js\" ></script>\n");
			header.append("<script type=\"text/javascript\" src=\"prototype.js\" ></script>\n");

			// for tab
			header.append("<script type=\"text/javascript\" src=\"build/element/element-beta.js\"></script>\n");
			header.append("<script type=\"text/javascript\" src=\"build/tabview/tabview.js\"></script>\n");

			// for panel
			header.append("<script type=\"text/javascript\" src=\"build/container/container.js\"></script>\n");

			// for animation
			header.append("<script type=\"text/javascript\" src=\"build/animation/animation.js\"></script>\n");

			// for lightbox
			header.append("<script type=\"text/javascript\" src=\"js/prototype.js\"></script>\n");
			header.append("<script type=\"text/javascript\" src=\"js/scriptaculous.js?load=effects\"></script>\n");
			header.append("<script type=\"text/javascript\" src=\"js/lightbox.js\"></script>\n");

			// for tab css
			header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"build/tabview/assets/border_tabs.css\">\n");
			header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"build/tabview/assets/tabview.css\">\n");

			// for panel css
			header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"build/container/assets/container.css\">\n");
			header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"build/container/assets/container.css\">\n");

			// for lightbox css
			header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/lightbox.css\"  media=\"screen\">\n");

			// for custom tab
			header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/tabview-core.css\"  media=\"screen\">\n");

			// for custom panel
			header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/panel.css\"  media=\"screen\">\n");

			header.append("<script type=\"text/javascript\">");
			header.append(script);
			header.append("</script>");

		}

		if (GlobalEnv.getframeworklist() == null) {
			header.append("</HEAD>\n");

			header.append("<BODY class=\"body\">\n");

			header.append("<div");
			header.append(div);
			header.append(titleClass);
			header.append(">");
			header.append(title);
			// tk end///////////////////////////////////////////////////////
			// chie//

			Log.out("--></style></head>");
			Log.out("<body>");
		}

		if (Connector.loginFlag) {
			header.append("<form action = \""
					+ GlobalEnv.getFileDirectory()
					+ "/servlet/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
			// header.append("<form action = \""+ GlobalEnv.getFileDirectory() +
			// "/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
			header.append("<input type=\"hidden\" name=\"tableinfo\" value=\""
					+ SSQLparser.get_from_info_st() + "\" >");
			header.append("<input type=\"hidden\" name=\"configfile\" value=\""
					+ GlobalEnv.getconfigfile() + "\" >");
		}

		if (Connector.logoutFlag) {
			header.append("<form action = \""
					+ GlobalEnv.getFileDirectory()
					+ "/servlet/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
			// header.append("<form action = \""+ GlobalEnv.getFileDirectory() +
			// "/supersql.form.Session\" method = \"post\" name=\"theForm\">\n");
			// header.append("<input type=\"hidden\" name=\"tableinfo\" value=\""
			// + SSQLparser.get_from_info_st() + "\" >");
			header.append("<input type=\"hidden\" name=\"configfile\" value=\""
					+ GlobalEnv.getconfigfile() + "\" >");
		}

		if (Connector.insertFlag || Connector.deleteFlag
				|| Connector.updateFlag) {
			header.append("<form action = \""
					+ GlobalEnv.getFileDirectory()
					+ "/servlet/supersql.form.Update\" method = \"post\" name=\"theForm\">\n");
			// header.append("<form action = \""+ GlobalEnv.getFileDirectory() +
			// "/supersql.form.Update\" method = \"post\" name=\"theForm\">\n");
			header.append("<input type=\"hidden\" name=\"tableinfo\" value=\""
					+ SSQLparser.get_from_info_st() + "\" >");
			header.append("<input type=\"hidden\" name=\"configfile\" value=\""
					+ GlobalEnv.getconfigfile() + "\" >");
			if (Connector.insertFlag)
				header.append("<input type=\"hidden\" name=\"sql_param\" value=\"insert\" >");
			if (Connector.deleteFlag)
				header.append("<input type=\"hidden\" name=\"sql_param\" value=\"delete\" >");
			if (Connector.updateFlag)
				header.append("<input type=\"hidden\" name=\"sql_param\" value=\"update\" >");
		}
	}
	
	public void getHeader() {
		int index = 0;
		if (GlobalEnv.getframeworklist() == null) {
			header.insert(index, "<HEAD>\n");
			header.insert(index, "<HTML>\n");
			Log.out("<HTML>");
			Log.out("<head>");
			header.append(cssFile);
			header.append("<STYLE TYPE=\"text/css\">\n");
			header.append("<!--\n");
			commonCSS();
			header.append(css);
			Log.out(css.toString());
			header.append("\n-->\n</STYLE>\n");
		}
	}

	protected void commonCSS() {
		if (!GlobalEnv.isOpt()) {
			header.append(".att { padding: 0px; margin : 0px;height : 100%; z-index: 2}\n");
			header.append(".linkbutton {text-align:center; margin-top: 5px; padding:5px;}\n");
			header.append(".embed { vertical-align : text-top; padding : 0px ; margin : 0px; border: 0px,0px,0px,0px; width: 100%;}");
			header.append(".noborder { 	border-width : 0px; "
					+ "margin-top : -1px; padding-top : -1px;	"
					+ "margin-bottom : -1px;	padding-bottom : -1px;}");
		}
	}

	public void getFooter() {
		if (Connector.updateFlag || Connector.insertFlag
				|| Connector.deleteFlag || Connector.loginFlag) {
			footer.append("<input type=\"submit\" name=\"login\" value=\"Let's go!\">");
			footer.append("</form>\n");
			Log.out("</form>");
			Connector.updateFlag = false;
			Connector.insertFlag = false;
			Connector.deleteFlag = false;
			Connector.loginFlag = false;
		}

		if (Connector.logoutFlag) {
			footer.append("</form>\n");
			Log.out("</form>");
			Connector.logoutFlag = false;
		}

		if (GlobalEnv.getframeworklist() == null) {
			footer.append("<BR><BR></BODY></HTML>\n");
			Log.out("</body></html>");
		}
		header_creation();
	}

	public void setOutlineMode() {
		OutlineMode = true;
	}

	public boolean isOutlineModeForJsoup(){
		if(OutlineMode){
			OutlineMode = false;
			return true;
		}
		return false;
	}
	
	public String getOutlineMode() {
		if (OutlineMode) {
			OutlineMode = false;
			return "";
		}
		// return " frame=void class=nest ";
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
		result = "TFE" + tfe.getId();
		return result;
	}

	/*** start oka ***/
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
		DataID = Integer.valueOf(
				(ClassID.substring(ClassID.length() - 3, ClassID.length())))
				.intValue();

		Log.out("ClassID=" + ClassID);
		Log.out("DataID=" + DataID);
		Log.out("ID_counter=" + IDCounter);

		if (DataID < IDOld) {
			IDCounter = DataID;
		} else {
			if (DataID != IDCounter && DataID > IDCounter) {
				DataID = IDCounter;
			}
		}
		IDCounter++;
		IDOld = DataID;
		return_value = String.valueOf(DataID);
		return return_value;
	}

	/******** form method ************/
	/********** 2009 chie **************/

	//
	public static void initAllFormFlg() {
		setFormItemFlg(false, null);
		setSelectFlg(false);
		setSelectRepeat(false);
		setFormValueString(null);
		setFormPartsName(null);
		setSelected("");
		setIDU("");
		formPartsNumber = 1;
		exchange_form_name = new String();
		formDetail = new String[256];
		formNumber = 1;
		nameId = "";
		search = false;
		searchId = 0;
		condName = "";
		cond = "";
	}

	// form tag is written : true
	public static void setFormItemFlg(boolean b, String s) {
		isFormItem = b;
		formItemName = s;
		return;
	}

	public static boolean getFormItemFlg() {
		return isFormItem;
	}

	public static String getFormItemName() {
		if (formItemName == null) {
			return "0";
		}
		return formItemName;
	}

	public static void setSelectFlg(boolean b) {
		selectFlg = b;
	}

	public static boolean getSelectFlg() {
		return selectFlg;
	}

	public static void setFormValueString(String s) {
		formValueString = s;
	}

	public static String getFormValueString() {
		return formValueString;
	}

	// select_repeat flag
	// not write "<tr><td>" between "<option>"s
	public static void setSelectRepeat(boolean b) {
		selectRepeat = b;
	}

	public static boolean getSelectRepeat() {
		return selectRepeat;
	}

	public static String getFormPartsName() {
		if (formPartsName == null) {
			return "t" + formPartsNumber;
		} else {
			return formPartsName;
		}
	}

	public static void incrementFormPartsNumber() {
		formPartsNumber++;
	}

	public static void setFormPartsName(String s) {
		formPartsName = s;
	}

	private static String exchange_form_name = new String();

	public static void exFormName() {
		String s = "t" + formPartsNumber + ":" + formPartsName + ":";
		if (exchange_form_name == null || exchange_form_name.isEmpty()) {
			exchange_form_name = ":" + s;
		} else {
			if (!exchange_form_name.contains(s))
				exchange_form_name += s;
		}
	}

	public static Element exFormNameCreateForJsoup(){
		if (exchange_form_name != null) {
			Element result = new Element(Tag.valueOf("input"), "");
			result.attr("type", "hidden");
			result.attr("name", "exchangeName");
			result.attr("value", exchange_form_name);
			return result;
		} else {
			return null;
		}
	}
	
	public static String exFormNameCreate() {
		String ret = new String();
		if (exchange_form_name != null) {
			ret = "<input type=\"hidden\" name=\"exchangeName\" value=\""
					+ exchange_form_name + "\" />";
			setFormDetail(ret);
			return ret;
		} else {
			return null;
		}
	}

	public static void incrementFormNumber() {
		formNumber++;
	}

	public static int getFormNumber() {
		// return formNumber 1,2,3...
		return formNumber;
	}

	public static String getFormName() {
		// return formNumber f1,f2,f3...
		return "f" + formNumber;
	}

	public static void setFormDetail(String s) {
		if (formDetail[formNumber] == null)
			formDetail[formNumber] = s;
		else
			formDetail[formNumber] += s;
	}

	public static String getFormDetail(int i) {
		return formDetail[i];
	}

	public static void setIDU(String s) {
		IDUst = s;
	}

	public static String getIDU() {
		return IDUst;
	}

	public static void setSelected(String s) {
		selected = s;
	}

	public static String getSelected() {
		return selected;
	}

	public static String getNameid() {
		if (nameId != null) {
			return nameId;
		} else {
			return "";
		}
	}

	public static void setChecked(String s) {
		System.out.println("checked:" + s);
		checked = s;
	}

	public static String getChecked() {
		return checked;
	}

	public static void setSearch(boolean b) {
		search = b;
		searchId = 0;
	}

	public static boolean getSearch() {
		return search;
	}

	public static void computeConditionalDecorations(DecorateList decos,
			StringBuffer css) {
		Object decorationKeys;
		Object decorationValue;
		String decorationKey;
		String condition;
		String className;
		for (Entry<String, Object> conditions : decos.getConditions()
				.entrySet()) {
			decorationKeys = conditions.getValue();
			condition = conditions.getKey();

			className = "C_" + decos.getClassesIds().get(condition);
			css.append("." + className + "{");

			if (decorationKeys instanceof String) {
				decorationKey = (String) decorationKeys;
				decorationValue = decos
						.getDecorationValueFromDecorationKeyAndCondition(
								decorationKey, condition);
				css.append(decorationKey + " : " + decorationValue + ";");
			} else {
				Iterator<String> decorationKeysIterator = ((ArrayList<String>) (decorationKeys))
						.iterator();
				while (decorationKeysIterator.hasNext()) {
					decorationKey = (String) decorationKeysIterator.next();
					decorationValue = decos
							.getDecorationValueFromDecorationKeyAndCondition(
									decorationKey, condition);
					css.append(decorationKey + " : " + decorationValue + ";");
				}
			}

			css.append("}");
		}
	}







	private Element createInsertDeleteUpdateForm() {
		Attributes formAttributes = new Attributes();
		formAttributes.put("action", GlobalEnv.getFileDirectory()
				+ "/servlet/supersql.form.Update");
		formAttributes.put("method", "post");
		formAttributes.put("name", "theForm");
		Element form = new Element(Tag.valueOf("form"), "", formAttributes);
	
		form.appendChild(JsoupFactory.createInput("hidden", "tableinfo",
				SSQLparser.get_from_info_st()));
		form.appendChild(JsoupFactory.createInput("hidden", "configfile",
				GlobalEnv.getconfigfile()));
	
		return form;
	
	}



	private Element createLogoutForm() {
		Attributes formAttributes = new Attributes();
		formAttributes.put("action", GlobalEnv.getFileDirectory()
				+ "/servlet/supersql.form.Session");
		formAttributes.put("method", "post");
		formAttributes.put("name", "logoutForm");
		Element form = new Element(Tag.valueOf("form"), "", formAttributes);
	
		Attributes inputAttributes = new Attributes();
		inputAttributes.put("type", "hidden");
		inputAttributes.put("name", "configfile");
		inputAttributes.put("value", GlobalEnv.getconfigfile());
		Element input = new Element(Tag.valueOf("input"), "", inputAttributes);
	
		form.appendChild(input);
		return form;
	}



	private Element createLoginForm() {
		Attributes formAttributes = new Attributes();
		formAttributes.put("action", GlobalEnv.getFileDirectory()
				+ "/servlet/supersql.form.Session");
		formAttributes.put("method", "post");
		formAttributes.put("name", "loginForm");
		Element form = new Element(Tag.valueOf("form"), "", formAttributes);
	
		Attribute hidden = new Attribute("type", "hidden");
		Tag input = Tag.valueOf("input");
	
		Attributes firstInputAttributes = new Attributes();
		firstInputAttributes.put(hidden);
		firstInputAttributes.put("name", "tableinfo");
		firstInputAttributes.put("value", SSQLparser.get_from_info_st());
		Element firstInput = new Element(input, "", firstInputAttributes);
	
		Attributes secondInputAttributes = new Attributes();
		secondInputAttributes.put(hidden);
		secondInputAttributes.put("name", "configfile");
		secondInputAttributes.put("value", GlobalEnv.getconfigfile());
		Element secondInput = new Element(input, "", secondInputAttributes);
	
		form.appendChild(firstInput);
		form.appendChild(secondInput);
		return form;
	}

	public Document getHtmlEnv1() {
		return htmlEnv1;
	}

}
