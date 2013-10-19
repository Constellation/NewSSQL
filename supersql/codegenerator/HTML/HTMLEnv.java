package supersql.codegenerator.HTML;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

import supersql.codegenerator.Connector;
import supersql.codegenerator.DecorateList;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.LocalEnv;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.parser.SSQLparser;

public class HTMLEnv extends LocalEnv {
	private static Document htmlDocument;
	public Vector<String> writtenClassId;
	protected Connector connector;
	public Vector<String> notWrittenClassId = new Vector<String>();
	public int gLevel = 0;
	public String fileName;
	public String outFile;
	public String linkOutFile;
	public String nextBackFile = new String();
	public String outDir;
	public static int countFile;
	public StringBuffer code;
	public StringBuffer css;
	protected static int IDCounter = 0; // add oka
	protected static int IDOld = 0; // add oka
	protected StringBuffer meta = new StringBuffer();
	protected StringBuffer div = new StringBuffer();
	protected StringBuffer title = new StringBuffer();
	protected StringBuffer titleClass = new StringBuffer();
	public StringBuffer cssFile = new StringBuffer();
	public StringBuffer jsFile = new StringBuffer(); // added by goto 20130703
	public StringBuffer cssjsFile = new StringBuffer(); // added by goto
														// 20130703
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
	public int linkFlag;
	public String linkUrl;

	// outline鐃緒申鐃緒申呂鐃緒申鐃緒申匹鐃緒申鐃緒申離侫薀逸申鐃�
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

	public static String bg = ""; // added by goto 20130311 "background"

	public HTMLEnv() {
		// TODO Put the file name in the configuration
		File input = new File("template.html");
		try {
			htmlDocument = Jsoup.parse(input, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Elements createHeader() {
		Attributes attributes = new Attributes();
		attributes.put("type", "text/css");
		Element style = new Element(Tag.valueOf("style"), "", attributes);
		Elements headElements = new Elements();

		if (GlobalEnv.isOpt()) {
			style.text("<!--\n.att { padding: 0px; margin : 0px;height : 100%; z-index: 2}\n"
					+ ".linkbutton {text-align:center; margin-top: 5px; padding:5px;}\n"
					+ ".embed { vertical-align : text-top; padding : 0px ; margin : 0px; border: 0px,0px,0px,0px; width: 100%;}"
					+ ".noborder { 	border-width : 0px; "
					+ "-top : -1px; padding-top : -1px;	"
					+ "-bottom : -1px;	padding-bottom : -1px;}\n-->\n"
					+ "</style>");
		}

		headElements.add(style);

		Attributes meta_attributes = new Attributes();
		meta_attributes.put("http-equiv", "Content-Type");
		meta_attributes.put("content", "text-html");
		meta_attributes.put("charset", "UTF-8");
		Element meta = new Element(Tag.valueOf("meta"), "", meta_attributes);

		headElements.add(meta);

		if (GlobalEnv.isAjax()) {
			String js = GlobalEnv.getJsDirectory();

			if (js != null) {
				if (js.endsWith("/"))
					js = js.substring(0, js.lastIndexOf("/"));
				headElements.add(JsoupFactory.createJsElement(js
						+ "/prototype.js"));
				headElements.add(JsoupFactory.createJsElement(js + "/ajax.js"));
			} else {
				headElements
						.add(JsoupFactory
								.createJsElement("http://localhost:8080/tab/prototype.js"));
				headElements.add(JsoupFactory
						.createJsElement("http://localhost:8080/tab/ajax.js"));
			}

			// Insertion of javascript files
			ArrayList<Element> elements = JsoupFactory.createJsElements(
					"js/lightbox.js", "js/scriptaculous.js?load=effects",
					"js/prototype.js", "build/animation/animation.js",
					"build/container/container.js", "build/tabview/tabview.js",
					"build/element/element-beta.js", "prototype.js",
					"ssqlajax.js", "build/yahoo/yahoo-min.js",
					"build/event/event-min.js", "build/dom/dom-min.js",
					"build/dragdrop/dragdrop-min.js");

			headElements.addAll(elements);

			// Insertion of css files
			elements = JsoupFactory.createStylesheetElements(
					"build/tabview/assets/border_tabs.css",
					"build/tabview/assets/tabview.css",
					"build/container/assets/container.css");
			headElements.addAll(elements);
			elements = JsoupFactory.createStylesheetElements(new String[] {
					"css/lightbox.css", "screen" }, new String[] {
					"css/tabview-core.css", "screen" }, new String[] {
					"css/panel.css", "screen" });

			headElements.addAll(elements);

			Attributes jsType = new Attributes();
			attributes.put("type", "text/javascript");
			Element element = new Element(Tag.valueOf("script"), "", jsType);
			element.text(script.toString());
			headElements.add(element);
		}
		ArrayList<Element> boxStylesheets = JsoupFactory
				.createStylesheetElements("styles/box.css", "styles/div.css",
						"styles/reset.css");

		for (Element elt : headElements) {
			htmlDocument.head().appendChild(elt);
		}
		for (Element elt : boxStylesheets) {
			htmlDocument.head().appendChild(elt);
		}
		return headElements;
	}

	public void createSSQLForm() {
		if (Connector.loginFlag) {
			htmlDocument.body().getElementById("ssql")
					.appendChild(createLoginForm());
		} else if (Connector.logoutFlag) {
			htmlDocument.body().getElementById("ssql")
					.appendChild(createLogoutForm());
		} else if (Connector.insertFlag || Connector.deleteFlag
				|| Connector.updateFlag) {
			Element form = createInsertDeleteUpdateForm();
			if (Connector.insertFlag)
				form.appendChild(JsoupFactory.createInput("hidden",
						"sql_param", "insert"));
			if (Connector.deleteFlag)
				form.appendChild(JsoupFactory.createInput("hidden",
						"sql_param", "delete"));
			if (Connector.updateFlag)
				form.appendChild(JsoupFactory.createInput("hidden",
						"sql_param", "update"));

			form.appendChild(JsoupFactory.createInput("submit", "login",
					"Let's go!"));
			htmlDocument.appendChild(form);
		}
	}

	public void createFooter() {
		fillHeadTag();
	}

	public void fillHeadTag() {
		if (GlobalEnv.isAjax()) {
			String js = GlobalEnv.getJsDirectory();
			if (js.endsWith("/"))
				js = js.substring(0, js.lastIndexOf("/"));
			htmlDocument.head().appendChild(
					JsoupFactory.createJsElement(js + "/prototype.js"));
			htmlDocument.head().appendChild(
					JsoupFactory.createJsElement(js + "/ajax.js"));

			ArrayList<Element> javascripts = JsoupFactory.createJsElements(
					"build/yahoo/yahoo-min.js", "build/event/event-min.js",
					"build/dom/dom-min.js", "build/dragdrop/dragdrop-min.js",
					"ssqlajax.js", "prototype.js",
					"build/element/element-beta.js",
					"build/tabview/tabview.js", "build/container/container.js",
					"build/animation/animation.js", "js/prototype.js",
					"js/scriptaculous.js?load=effects", "js/lightbox.js");

			for (Element e : javascripts) {
				htmlDocument.head().appendChild(e);
			}

			ArrayList<Element> stylesheets = JsoupFactory
					.createStylesheetElements(
							"build/tabview/assets/border_tabs.css",
							"build/tabview/assets/tabview.css",
							"build/container/assets/container.css",
							"css/lightbox.css", "css/tabview-core.css",
							"css/panel.css");

			for (Element e : stylesheets) {
				htmlDocument.head().appendChild(e);
			}

			Element inlineJavascript = new Element(Tag.valueOf("script"), "");
			inlineJavascript.appendText(script.toString());
			htmlDocument.head().appendChild(inlineJavascript);

		}

		if (GlobalEnv.getframeworklist() == null) {
			htmlDocument.body().getElementById("ssql").addClass("body");
			header.append("<BODY class=\"body\">\n");
			Element divElement = new Element(Tag.valueOf("div"), "");
			divElement.append(title.toString());
			// TODO
			header.append(title);
		}

		if (Connector.loginFlag) {
			Element form = new Element(Tag.valueOf("form"), "");
			form.attr(
					"action",
					GlobalEnv.getFileDirectory()
							+ "/servlet/supersql.form.Session")
					.attr("method", "post").attr("name", "theForm");
			form.appendChild(JsoupFactory.createInput("hidden", "tableinfo",
					SSQLparser.get_from_info_st()));
			form.appendChild(JsoupFactory.createInput("hidden", "configfile",
					GlobalEnv.getconfigfile()));
			htmlDocument.body().getElementById("ssql").appendChild(form);
		}

		if (Connector.logoutFlag) {
			Element form = new Element(Tag.valueOf("form"), "");
			form.attr(
					"action",
					GlobalEnv.getFileDirectory()
							+ "/servlet/supersql.form.Session")
					.attr("method", "post").attr("name", "theForm");
			form.appendChild(JsoupFactory.createInput("hidden", "configfile",
					GlobalEnv.getconfigfile()));
			htmlDocument.body().getElementById("ssql").appendChild(form);
		}

		if (Connector.insertFlag || Connector.deleteFlag
				|| Connector.updateFlag) {
			Element form = new Element(Tag.valueOf("form"), "")
					.attr("action", "/servlet/supersql.form.Update")
					.attr("method", "post").attr("name", "theForm");
			form.appendChild(JsoupFactory.createInput("hidden", "tableinfo",
					SSQLparser.get_from_info_st()));
			form.appendChild(JsoupFactory.createInput("hidden", "configfile",
					GlobalEnv.getconfigfile()));
			if (Connector.insertFlag)
				form.appendChild(JsoupFactory.createInput("hidden",
						"sql_param", "insert"));
			if (Connector.deleteFlag)
				form.appendChild(JsoupFactory.createInput("hidden",
						"sql_param", "delete"));
			if (Connector.updateFlag)
				form.appendChild(JsoupFactory.createInput("hidden",
						"sql_param", "update"));
		}
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
			// added by goto 20130311 "background"
			if (!bg.equals("")) {
				header.append("<style type=\"text/css\">");
				header.append("<!-- body { background-image: url(" + bg
						+ "); } -->");
				header.append("</style>\n");
			}

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
			header.append("<meta name=\"GENERATOR\" content=\" SuperSQL (Generate HTML) \">\n"); // Generator
			header.append(cssjsFile); // added by goto 20130703
			header.append(cssFile);
			header.append(jsFile); // added by goto 20130703
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

	public boolean isOutlineMode() {
		if (OutlineMode) {
			OutlineMode = false;
			return true;
		}
		return false;
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

	public static Element exFormNameCreateForJsoup() {
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
		return htmlDocument;
	}

	public static void setCharset(String charset) {
		htmlDocument.head().getElementsByAttribute("charset")
				.attr("charset", charset);
	}

	public static void addCssStylesheet(String string) {
		htmlDocument.head().appendChild(
				JsoupFactory.createStylesheetElement(string));
	}

	public static void addJsFile(String string) {
		htmlDocument.head().appendChild(JsoupFactory.createJsElement(string));
	}

	public static void setTitle(String string) {
		htmlDocument.head().getElementsByTag("title").html(string);
	}

	public static void addMeta(String name, String content) {
		htmlDocument.head().appendElement("meta").attr("name", name)
				.attr("content", content);
	}

	public static void setBackground(String str) {
		htmlDocument.head().appendElement("style").attr("type", "text/css")
				.html("body {background-image: " + str + ";}");
	}

	public static void addStyle(String str) {
		htmlDocument.head().appendElement("style").attr("type", "text/css")
				.html(str);
	}

}
