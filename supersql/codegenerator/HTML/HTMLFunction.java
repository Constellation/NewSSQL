package supersql.codegenerator.HTML;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
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
	private static int meter_id = 0;
	private static String updateFile;
	static ArrayList<Integer> seq_num = new ArrayList<Integer>(); // 20130914
																	// "SEQ_NUM"
	static ArrayList<String> seq_num_ClassID = new ArrayList<String>(); // 20130914
																		// "SEQ_NUM"
	static ArrayList<Boolean> DESC_Flg = new ArrayList<Boolean>(); // 20130914
																	// "SEQ_NUM"

	public HTMLFunction() {

	}

	// 鐃緒申鐃藷ストラク鐃緒申
	public HTMLFunction(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		super();
		this.htmlEnv = henv;
		this.htmlEnv2 = henv2;
	}

	@Override
	public Node createNode(ExtList<ExtList<String>> data_info) {
		this.setDataList(data_info);
		String FuncName = this.getFuncName();
		if (FuncName.equalsIgnoreCase("imagefile")
				|| FuncName.equalsIgnoreCase("image")
				|| FuncName.equalsIgnoreCase("img")) {
			return FuncImagefileForJsoup();
		} else if (FuncName.equalsIgnoreCase("invoke")) {
			return FuncInvokeForJsoup();
		} else if (FuncName.equalsIgnoreCase("foreach")) {
			return FuncForeachForJsoup(data_info);
		} else if (FuncName.equalsIgnoreCase("sinvoke")
				|| FuncName.equalsIgnoreCase("link")) {
			return FuncSinvokeForJsoup(data_info);
		} else if (FuncName.equalsIgnoreCase("null")) {
			return FuncNullForJsoup();
		} else if (FuncName.equalsIgnoreCase("url")
				|| FuncName.equalsIgnoreCase("anchor")
				|| FuncName.equalsIgnoreCase("a")) {
			return FuncUrl(false);
		} else if (FuncName.equalsIgnoreCase("mail")) {
			return FuncUrl(true);
		} else if (FuncName.equalsIgnoreCase("object")) {
			return FuncObject("");
		} else if (FuncName.equalsIgnoreCase("seq_num")) {
			return FuncSeqNum();
		} else if (FuncName.equalsIgnoreCase("submit")) {
			return FuncSubmitForJsoup();
		} else if (FuncName.equalsIgnoreCase("select")) {
			return FuncSelectForJsoup();
		} else if (FuncName.equalsIgnoreCase("checkbox")) {
			return FuncCheckboxForJsoup();
		} else if (FuncName.equalsIgnoreCase("radio")) {
			return FuncRadioForJsoup();
		} else if (FuncName.equalsIgnoreCase("inputtext")) {
			return FuncInputtextForJsoup();
		} else if (FuncName.equalsIgnoreCase("textarea")) {
			return FuncTextareaForJsoup();
		} else if (FuncName.equalsIgnoreCase("hidden")) {
			return FuncHiddenForJsoup();
		} else if (FuncName.equalsIgnoreCase("session")) {
			// Func_session(); not use
			return new Element(Tag.valueOf(""), "");
		} else if (FuncName.equalsIgnoreCase("youtube")) {
			return FuncYoutube();
		} else if (FuncName.equalsIgnoreCase("movie")) {
			return FuncMovieFile();
		} else if (FuncName.equalsIgnoreCase("meter")) {
			return FuncMeter();
		}
		// added by goto 20130308 "url���"
		else if (FuncName.equalsIgnoreCase("url")
				|| FuncName.equalsIgnoreCase("anchor")
				|| FuncName.equalsIgnoreCase("a")) {
			return FuncUrl(false);
		}
		// added by goto 20130417 "mail"
		else if (FuncName.equalsIgnoreCase("mail")) {
			FuncUrl(true);
		}
		// tk start//////////////////////////////////
		else if (FuncName.equalsIgnoreCase("embed")) {
			Log.out("[enter embed]");
			return FuncEmbedForJsoup(data_info);
		}
		// tk end////////////////////////////////////
		Log.out("TFEId = " + HTMLEnv.getClassID(this));
		htmlEnv.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
		return null;
	}

	private Element FuncEmbedForJsoup(ExtList<ExtList<String>> data_info) {
		String file = this.getAtt("file");
		String where = this.getAtt("where");
		String att = this.getAtt("att");
		String att2 = this.getAtt("attString");
		String condition = new String();
		boolean is_hidden = false;
		Element result = null;

		if (decos.containsKey("status"))
			if (decos.getStr("status").compareTo("hidden") == 0)
				is_hidden = true;

		// for tab
		if (decos.containsKey("tab")) {
			result = new Element(Tag.valueOf("div"), "");
			result.attr("id", "myTab");
			if (decos.containsKey("class"))
				result.addClass(decos.getStr("class"));
			Element div = new Element(Tag.valueOf("div"), "")
					.attr("id", "mTab").addClass("yui-navset");
			result.appendChild(div);

			Element script = new Element(Tag.valueOf("script"), "");
			script.append("var mTab = new YAHOO.widget.TabView(\"mTab\");\new YAHOO.util.DDTarget(\"myTab\", \"myTab\");");
			result.appendChild(script);

			return result;
		}

		if (!is_hidden) {
			result = new Element(Tag.valueOf("table"), "").addClass("att")
					.addClass(htmlEnv.getOutlineModeAtt());

			if (decos.containsKey("class"))
				result.addClass(decos.getStr("class"));
			else
				result.addClass(HTMLEnv.getClassID(this));
			result.append("<tr><td></td></tr>");
			// htmlEnv.code.append("><tr><td>");
		}

		// for ajax div id
		// //////////////////////////////////////////////////////

		String divname = "";
		boolean has_divid = false;

		if (decos.containsKey("divid")) {
			has_divid = true;
			Log.out("embed contains decos with divid");
			String tmpdivid = decos.getStr("divid");
			String tmp;
			String ans;

			if (tmpdivid.contains("+")) {
				ans = tmpdivid.substring(0, tmpdivid.indexOf("+"));
				tmp = tmpdivid.substring(tmpdivid.indexOf("+") + 1,
						tmpdivid.length());

				if (tmp.compareTo("att") == 0) {
					tmp = att;
				}
				divname = ans + "_" + tmp;
				Log.out("ans :" + ans + " tmp:" + tmp + " divname:" + divname);
			} else {
				divname = decos.getStr("divid");
			}
		}
		Element script = null;
		if (GlobalEnv.isAjax() && decos.containsKey("droppable")) {
			script = new Element(Tag.valueOf("script"), "")
					.append("new YAHOO.util.DDTarget(\"" + divname + "\", \""
							+ divname + "\");");
		}
		// ajax & decos contains status=hidden
		if (is_hidden && GlobalEnv.isAjax()) {

			result = new Element(Tag.valueOf("div"), "").attr("id", divname);

			htmlEnv.code.append("<div id=\"" + divname + "\" ");
			if (script != null) {
				result.appendChild(script);
			}
			if (decos.containsKey("class"))
				htmlEnv.code.append("class=\"" + decos.getStr("class") + "\" ");

			htmlEnv.code.append("></div>");
			Log.out("<div id=" + divname + "></div>");

			return result;
		}
		if (att.compareTo("") != 0) {
			condition = condition + where + att;
		} else if (att2.compareTo("") != 0) {
			condition = condition + where + "'" + att2 + "'";
		}
		// store original config
		Hashtable tmphash = GlobalEnv.getEnv();

		String[] args;
		if (GlobalEnv.isAjax()) {
			if (condition.equals("")) {
				args = new String[3];
				args[0] = "-f";
				args[1] = file;
				args[2] = "-ajax";

			} else {
				args = new String[5];
				args[0] = "-f";
				args[1] = file;
				args[2] = "-cond";
				args[3] = condition;
				args[4] = "-ajax";
			}
		} else {
			if (GlobalEnv.isOpt()) {
				args = new String[5];
				args[0] = "-f";
				args[1] = file;
				args[2] = "-cond";
				args[3] = condition;
				args[4] = "-optimizer";
			} else {
				args = new String[4];
				args[0] = "-f";
				args[1] = file;
				args[2] = "-cond";
				args[3] = condition;
			}
		}

		htmlEnv.embedCount++;

		if (file.contains(".sql")) {

			String makedfilename = file.substring(file.lastIndexOf("\\") + 1,
					file.indexOf("."));

			if (att.compareTo("") != 0)
				makedfilename = makedfilename.concat("_" + att);
			if (att2.compareTo("") != 0)
				makedfilename = makedfilename.concat("_" + att2);

			makedfilename = makedfilename.concat(".html");

			Log.out("embed tmpfilename:" + makedfilename + " option:"
					+ GlobalEnv.getEmbedOption());

			File makedfile = new File(GlobalEnv.getEmbedTmp(), makedfilename);

			if (makedfile.exists() && GlobalEnv.isNewEmbed() == 1) {
				Log.out("[Enter new Embed]");
				Log.out("embed read tmp file");
				BufferedReader dis;
				String line = new String();
				try {
					dis = new BufferedReader(new FileReader(makedfile));

					try {
						while (!line.equalsIgnoreCase(" ")) {
							Log.out("line : " + line);
							line = dis.readLine();
							if (line != null)
								htmlEnv.code.append(line);
						}
					} catch (NullPointerException e) {
						Log.out("no more lines");
					}

					dis.close();
				} catch (IOException ioe) {
					System.out.println("IOException: " + ioe);
				}
			} else {
				Log.out("embed make file");

				GlobalEnv.setGlobalEnvEmbed(args);

				SSQLparser parser;
				if (file.contains("http")) {
					parser = new SSQLparser("online");
				} else {
					parser = new SSQLparser(10000 * (htmlEnv.embedCount + 1));
				}

				CodeGenerator codegenerator = parser.getcodegenerator();
				DataConstructor dc = new DataConstructor(parser);

				StringBuffer returnedcode = codegenerator.generateCode2(parser,
						dc.getData());

				// ajax add div
				// tag////////////////////////////////////////////////////////////////////
				if (GlobalEnv.isAjax()) {
					if (!has_divid) {
						// online file
						if (file.contains("/")) {
							divname = file.substring(file.lastIndexOf("/") + 1,
									file.indexOf(".sql"));
						}
						// ofline file
						else if (file.contains("\\")) {
							divname = file.substring(
									file.lastIndexOf("\\") + 1,
									file.indexOf(".sql"));
						}
						// only file name
						else {
							divname = file.substring(0, file.indexOf(".sql"));
						}
					}

					htmlEnv.code.append("<div id=\"" + divname + "\" ");

					if (decos.containsKey("class"))
						htmlEnv.code.append("class=\"" + decos.getStr("class")
								+ "\" ");

					htmlEnv.code.append(">");
					Log.out("<div id=" + divname + ">");
				}

				// xml�����
				if (!is_hidden) {
					htmlEnv2.code.append("<EMBED>");
					htmlEnv.code.append(returnedcode);
					htmlEnv2.code.append(returnedcode);
					htmlEnv2.code.append("</EMBED>");
				}

				if (GlobalEnv.isAjax())
					htmlEnv.code.append("</div>");
				// end ajax
				// /////////////////////////////////////////////////////////////////

				if (htmlEnv.embedCount >= 1) {
					htmlEnv.css.append(codegenerator.generateCode3(parser,
							dc.getData()));
					htmlEnv.cssFile.append(codegenerator.generateCssfile(
							parser, dc.getData()));
				}

				// restore original config
				GlobalEnv.setEnv(tmphash);

				// writing tmpfile
				Log.out("embed hogehoge:" + GlobalEnv.isNewEmbed());
				Log.out("enb:" + GlobalEnv.getEnv());

				if (GlobalEnv.isNewEmbed() == 1) {
					GlobalEnv.addEmbedFile(makedfilename);
					Log.out("embed start writing");
					String filename = GlobalEnv.getEmbedTmp();

					if (filename.endsWith("/") || filename.endsWith("\\"))
						filename = filename + makedfilename;
					else
						filename = filename + "/" + makedfilename;

					try {
						OutputStream fout = new FileOutputStream(filename);
						OutputStream bout = new BufferedOutputStream(fout);
						OutputStreamWriter out = new OutputStreamWriter(bout,
								"UTF-8");

						out.write(htmlEnv.header.toString());
						out.write(returnedcode.toString());
						out.write(htmlEnv.footer.toString());

						out.close();
					} catch (FileNotFoundException fe) {

						fe.printStackTrace();
						System.err
								.println("Error: specified embedtmp outdirectory \""
										+ GlobalEnv.getEmbedTmp()
										+ "\" is not found to write "
										+ htmlEnv.fileName);

						GlobalEnv
								.addErr("Error: specified embedtmp outdirectory \""
										+ GlobalEnv.getEmbedTmp()
										+ "\" is not found to write "
										+ htmlEnv.fileName);
					} catch (IOException e) {
						System.err
								.println("Error[HTMLManager]: File IO Error in HTMLManager at embed");
						e.printStackTrace();
						GlobalEnv
								.addErr("Error[HTMLManager]: File IO Error in HTMLManager at embed");
					}
				}

			}
		}
		// embed html file
		else if (file.contains(".html")) {
			String line = new String();

			if (decos.containsKey("divid"))
				divname = decos.getStr("divid");
			else if (file.contains("\\"))
				divname = file.substring(file.lastIndexOf("\\") + 1,
						file.indexOf(".html"));
			else if (file.contains("/"))
				divname = file.substring(file.lastIndexOf("/") + 1,
						file.indexOf(".html"));
			else
				divname = file.substring(0, file.indexOf(".html"));

			BufferedReader dis;
			try {
				if (file.contains("http://")) {
					URL fileurl = new URL(file);

					URLConnection fileurlConnection = fileurl.openConnection();
					dis = new BufferedReader(new InputStreamReader(
							fileurlConnection.getInputStream()));
				} else {
					try {
						Log.out("embed file (html):" + file);
						dis = new BufferedReader(new FileReader(new File(file)));
					} catch (IOException ioe) {
						String path = htmlEnv.outFile;
						if (path.contains("\\"))
							path = path
									.substring(0, path.lastIndexOf("\\") + 1);
						else if (path.contains("/"))
							path = path.substring(0, path.lastIndexOf("/") + 1);
						if (file.startsWith("./")) {
							file = file.substring(1, file.length());
						}
						Log.out("embed file (html):" + path + file);
						if (path.startsWith("http:")) {
							URL fileurl = new URL(path + file);
							URLConnection fileurlConnection = fileurl
									.openConnection();
							dis = new BufferedReader(new InputStreamReader(
									fileurlConnection.getInputStream()));
						} else {
							dis = new BufferedReader(new FileReader(new File(
									path + file)));

						}
					}
				}
				line = dis.readLine(); // read <BODY> and/or <HEAD>
				if (line.contains("<head>")) {
				} else {
					line = dis.readLine(); // read <HEAD>
				}

				while (!line.equalsIgnoreCase("</head>")) {
					line = dis.readLine();
					if (!line.equalsIgnoreCase("</head>"))
						htmlEnv.header.append(line + "\n");
				}
				line = dis.readLine(); // read <body>

				htmlEnv.code.append("<div id=\"" + divname + "\" ");

				if (decos.containsKey("class"))
					htmlEnv.code.append("class=\"" + decos.getStr("class")
							+ "\" ");

				htmlEnv.code.append(">");

				htmlEnv2.code.append("<EMBED>");
				while (!line.equalsIgnoreCase("</body>")) {
					Log.out("line : " + line);
					line = dis.readLine();
					if (!line.equalsIgnoreCase("</body>")) {
						htmlEnv.code.append(line);
						if (line.contains("&"))
							line = line.replace("&", "&amp;");
						if (line.contains("<"))
							;
						line = line.replace("<", "&lt;");
						if (line.contains(">"))
							line = line.replace(">", "&gt;");
						if (line.contains("���"))
							line = line.replace("���", "&#65374;");
						htmlEnv2.code.append(line);
					}
				}
				htmlEnv2.code.append("</EMBED>");

				htmlEnv.code.append("</div>");
				dis.close();

			} catch (MalformedURLException me) {
				System.out.println("MalformedURLException: " + me);
			} catch (IOException ioe) {
				System.out.println("HTMLFuncEmbed:IOException: " + ioe);
			}

		}
		if (!is_hidden)
			htmlEnv.code.append("</td></tr></table>");

		htmlEnv.embedCount += 1;
		return result;
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
		if (!this.getAtt("checked").equals("")) {
			HTMLEnv.setChecked(this.getAtt("checked"));
		}
		return FuncFormCommonForJsoup("radio");
	}

	private Element FuncCheckboxForJsoup() {
		Element result = FuncFormCommonForJsoup("checkbox");

		if (!this.getAtt("checked").equals("")) {
			HTMLEnv.setChecked(this.getAtt("checked"));
		}

		return result;
	}

	private Element FuncSelectForJsoup() {
		if (!this.getAtt("selected").equals("")) {
			HTMLEnv.setSelected(this.getAtt("selected"));
		}
		return FuncFormCommonForJsoup("select");
	}

	private Element FuncSubmitForJsoup() {
		Element result = new Element(Tag.valueOf("form"), "");
		boolean openFormInThis = false;

		// submit only ----- no "@{form}"
		if (!HTMLEnv.getFormItemFlg() && !decos.containsKey("form")) {
			result = createFormForJsoup();
			openFormInThis = true;
		} else if (decos.containsKey("form")) {
			result = createFormForJsoup(decos);
			openFormInThis = true;
		}

		HTMLEnv.setFormItemFlg(true, "submit");

		String value = "";
		if (!this.getAtt("default").equals(null)) {
			value = this.getAtt("default");
		}

		result.appendChild(JsoupFactory.createInput("submit", "", value));
		if (openFormInThis == true) {
			HTMLEnv.setFormItemFlg(false, null);
			openFormInThis = false;
		} else {
			HTMLEnv.setFormItemFlg(true, null);
		}

		return result;
	}

	private Element FuncNullForJsoup() {
		return new Element(Tag.valueOf("span"), "");
	}

	private Element FuncSinvokeForJsoup(ExtList<ExtList<String>> data_info) {
		Element result;
		String file = this.getAtt("file");
		String action = this.getAtt("action");
		int attNo = 1;
		String att = new String();
		while (!this.getAtt("att" + attNo).equals("")) {
			att = att + "_" + this.getAtt("att" + attNo);
			attNo++;
		}
		try {
			att = URLEncoder.encode(att, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (this.getAtt("action").equals("")) {
			try {
				if (file.toLowerCase().contains(".sql")) {
					file = file.substring(0, file.indexOf(".sql"));
				} else if (file.toLowerCase().contains(".html")) {
					file = file.substring(0, file.indexOf(".html"));
				}
			} catch (Exception e) {
				GlobalEnv.addErr("Error[" + getClassName()
						+ "]: filename is invalid.");
				System.err.println("Error[" + getClassName()
						+ "]: filename is invalid.");
			}

			String filename = new String();
			if (!this.getAtt("att").equals("")) {
				if (this.getAtt("att").toLowerCase().startsWith("http://"))
					filename = this.getAtt("att");
				else if (this.getAtt("att").toLowerCase().endsWith(".html"))
					filename = this.getAtt("att");
				else
					filename = file + "_" + this.getAtt("att") + ".html";
			} else {
				filename = file + att + ".html";
			}

			filename.replace("\\\\", "\\");
			htmlEnv.linkUrl = filename;
			htmlEnv.sinvokeFlag = true;

		} else {
			String filename = "";
			if (!this.getAtt("att").equals(""))
				filename = action + "/" + this.getAtt("att");
			else
				filename = action + att;

			filename.replace("\\\\", "\\");
			htmlEnv.linkUrl = filename;
			htmlEnv.sinvokeFlag = true;
		}

		if (GlobalEnv.isAjax()) {
			htmlEnv.linkUrl = file + ".html";
			htmlEnv.ajaxQuery = file + ".sql";
			htmlEnv.ajaxCond = this.getAtt("ajaxcond") + "="
					+ this.getAtt("att");

			Date d2 = new Date();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyymmddHHmmss");
			String today2 = sdf2.format(d2);

			htmlEnv.dragDivId = htmlEnv.ajaxQuery + "+" + htmlEnv.ajaxCond
					+ "&" + today2;

			if (decos.containsKey("in")) {
				String effect = decos.getStr("in");

				if (effect.equalsIgnoreCase("blind"))
					htmlEnv.inEffect = 1;
				if (effect.equalsIgnoreCase("fade"))
					htmlEnv.inEffect = 2;
			}
			if (decos.containsKey("out")) {
				String effect = decos.getStr("out");

				if (effect.equalsIgnoreCase("blind"))
					htmlEnv.outEffect = 1;
				if (effect.equalsIgnoreCase("fade"))
					htmlEnv.outEffect = 2;
			}

			if (decos.containsKey("panel")) {
				htmlEnv.isPanel = true;
			}
			if (decos.containsKey("dispdiv")) {
				String dispdiv = decos.getStr("dispdiv");
				if (dispdiv.contains("+")) {
					String tmp2 = dispdiv
							.substring(0, dispdiv.lastIndexOf("+"));
					String tmp3 = dispdiv.substring(
							dispdiv.lastIndexOf("+") + 1, dispdiv.length());

					if (tmp3.compareTo("att") == 0) {
						htmlEnv.ajaxtarget = tmp2 + "_" + this.getAtt("att");
					} else
						htmlEnv.ajaxtarget = dispdiv;
				} else {
					htmlEnv.ajaxtarget = dispdiv;
				}
				htmlEnv.hasDispDiv = true;
			} else if (decos.containsKey("dragto")) {
				htmlEnv.draggable = true;

				// drag to
				String value = decos.getStr("dragto");
				String[] droptarget = new String[100];
				int targetnum = 0;

				if (value.contains("+")) {
					while (true) {
						if (!value.contains("+")) {
							droptarget[targetnum] = value;
							targetnum++;
							break;
						}
						droptarget[targetnum] = value.substring(0,
								value.indexOf("+"));
						value = value.substring(value.indexOf("+") + 1,
								value.length());

						targetnum++;
					}
				} else
					droptarget[0] = value;

				// script 鐃緒申鐃緒申
				Date d1 = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
				String today = sdf.format(d1);

				String scriptname = "drop" + today + htmlEnv.scriptNum;
				htmlEnv.script.append(scriptname + " = new DragDrop(\""
						+ htmlEnv.dragDivId + "\", \"" + droptarget[0]
						+ "\");\n");

				// for tab
				htmlEnv.script.append(scriptname + ".addToGroup(\"myTab\");\n");

				for (int i = 1; i < targetnum; ++i) {
					htmlEnv.script.append(scriptname + ".addToGroup(\""
							+ droptarget[i] + "\");\n");
				}

				htmlEnv.scriptNum++;
			}
		}
		if (this.getArgs().get(0) instanceof FuncArg) {
			Log.out("ARGS are function");
			FuncArg fa = (FuncArg) this.getArgs().get(0);
			result = (Element) fa.createNodeAtt();
		} else
			result = (Element) this.createNodeAtt("default");
		// tk//////////////////////////////////////////////////

		htmlEnv.sinvokeFlag = false;
		return result;
	}

	// tk
	// end////////////////////////////////////////////////////////////////////////////

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

		String path = this.getAtt("path", ".");
		if (!GlobalEnv.getFileDirectory().equals(".")) {
			path = GlobalEnv.getFileDirectory();
		}
		String filename = this.getAtt("filename");
		if (!filename.startsWith("/") && (path != null)) {
			filename = path + "/" + filename;
		}

		htmlEnv.linkUrl = this.getAtt("server_path",
				GlobalEnv.getInvokeServletPath())
				+ "?"
				+ "config="
				+ path
				+ "/config.ssql"
				+ "&"
				+ "query="
				+ filename + "&" + "cond=" + this.getAtt("condition");

		htmlEnv.linkFlag = 1;
		Element result = (Element) this.createNodeAtt("default");
		htmlEnv.linkFlag = 0;

		return result;
	}

	private Element FuncImagefileForJsoup() {

		Element result = new Element(Tag.valueOf("a"), "");

		String path = this.getAtt("path", ".");
		if (!path.startsWith("/")) {
			String basedir = GlobalEnv.getBaseDir();
			if (basedir != null && basedir != "") {
				path = GlobalEnv.getBaseDir() + "/" + path;
			}
		}
		if (GlobalEnv.isServlet()) {
			path = GlobalEnv.getFileDirectory() + path;
		}

		// image//////////////////////////////////////////////////////////////////////////////////
		if (htmlEnv.linkFlag > 0 || htmlEnv.sinvokeFlag) {
			String fileDir = new File(htmlEnv.linkUrl).getAbsoluteFile()
					.getParent();

			if (fileDir.length() < htmlEnv.linkUrl.length()
					&& fileDir.equals(htmlEnv.linkUrl.substring(0,
							fileDir.length()))) {
				String relative_path = htmlEnv.linkUrl.substring(fileDir
						.length() + 1);
				result.attr("href", relative_path);
			} else
				result.attr("href", htmlEnv.linkUrl);

			// added by goto 20121222 end

			if (decos.containsKey("target"))
				result.attr("target", decos.getStr("target"));
			if (decos.containsKey("class"))
				result.addClass(decos.getStr("class"));
		}
		// tk/////////////////////////////////////////////////////////////////////////////////

		if (decos.containsKey("lightbox")) {
			Date d1 = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
			String today = sdf.format(d1);

			Element link = JsoupFactory.createLink(
					path + "/" + this.getAtt("default"), "", "");
			link.attr("rel", "lightbox[lb" + today + "]");
			result.appendChild(link);

			if (decos.getStr("lightbox").compareTo("root") == 0
					|| decos.getStr("lightbox").compareTo("thumb") == 0) {
				Element img = new Element(Tag.valueOf("img"), "")
						.addClass(HTMLEnv.getClassID(this));
				htmlEnv.code.append("<img class=\"" + HTMLEnv.getClassID(this)
						+ " ");

				if (decos.containsKey("class"))
					img.addClass(decos.getStr("class"));

				img.attr("src", path + "/" + this.getAtt("default")).attr(
						"onLoad", "initLightBox()");
				link.appendChild(img);
			}
		} else {
			Element img = new Element(Tag.valueOf("img"), "").addClass(HTMLEnv
					.getClassID(this));
			if (decos.containsKey("class"))
				img.addClass(decos.getStr("class"));

			// added 20130703
			if (this.getAtt("default").startsWith("http://")
					|| this.getAtt("default").startsWith("https://")) {
				img.attr("src", this.getAtt("default"));
			} else {
				img.attr("src", path + "/" + this.getAtt("default"));
			}
			result.appendChild(img);
		}
		return result;
	}

	
	private Element FuncUrl(boolean mailFncFlg){
		Element result = null ;
		
		FuncArg fa1 = (FuncArg) this.getArgs().get(0), fa2, fa3;
		String url, name, type;

		try { // 鐃緒申鐃�鐃緒申 or 3鐃縦の常申鐃�
			fa2 = (FuncArg) this.getArgs().get(1);
			url = ((mailFncFlg) ? ("mailto:") : ("")) + fa2.getStr();
			name = fa1.getStr();

			try { // 鐃緒申鐃�鐃縦の常申鐃�
				fa3 = (FuncArg) this.getArgs().get(2);
				type = fa3.getStr();

				// type=1 -> 文鐃緒申
				if (type.equals("1") || type.equals("text") || type.equals("")) {
					result = getTextAnchor(url, name);

					// url鐃旬ワ申鐃緒申(鐃叔ワ申鐃緒申鐃夙ップ￥申鐃緒申丱鐃緒申覿�申鐃�
				} else if (type.equals("3") || type.equals("button")
						|| type.equals("bt")) {
					result = JsoupFactory.createInput("button", "", name).attr("onClick", "location.href='" +url + "");
					result.addClass(className());

					// url鐃旬ワ申鐃緒申 width,height鐃緒申鐃緒申鐃緒申僚鐃緒申鐃�
					if (decos.containsKey("width")
							|| decos.containsKey("height")) {
						String style = "";
						if (decos.containsKey("width"))
							style += "WIDTH:"
									+ decos.getStr("width").replace("\"", "")
									+ "; ";
						if (decos.containsKey("height"))
							style += "HEIGHT:"
									+ decos.getStr("height").replace("\"", "")
									+ "; "; // 100; ";
						result.attr("style", style);
					}

					// type=3 -> url鐃緒申鐃緒申
				} else if (type.equals("2") || type.equals("image")
						|| type.equals("img")) {
					result = JsoupFactory.createLink(url, "", "", className());
					result.attr("data-transition", transition());
					if (decos.containsKey("prefetch") || decos.containsKey("pref"))
						result.attr("data-prefetch", "");
					
					Element img = new Element(Tag.valueOf("img"), "");

					// url鐃緒申鐃緒申 width,height鐃緒申鐃緒申鐃緒申僚鐃緒申鐃�
					if (decos.containsKey("width"))
						img.attr("width", decos.getStr("width").replace("\"", ""));
					else {
						// added by goto 20130312 "Default width: 100%"
						img.attr("width", "100%");
					}
					if (decos.containsKey("height"))
						img.attr("height", decos.getStr("height").replace("\"", "")); // 100;
					
					result.appendChild(img);
				}
				

			} catch (Exception e) { // 鐃緒申鐃�鐃縦の常申鐃� statement =
			}

		} catch (Exception e) { // 鐃緒申鐃�鐃縦の常申鐃�
			url = fa1.getStr();
			result = JsoupFactory.createLink(((mailFncFlg) ? ("mailto:") : ("")), "", url);
			result.attr("data-transition", transition());
			if (decos.containsKey("prefetch") || decos.containsKey("pref"))
				result.attr("data-prefetch", "");
		}

		// 鐃銃逸申鐃緒申鐃祝緒申鐃緒申鐃縮わ申HTML鐃祝書きわ申鐃緒申
		return result;
	}
	
	private Element getTextAnchor(String url, String name){
		// [ ]鐃叔囲わ申譴随申鐃淑�申鐃熟ワ申鐃術￥申鐃緒申鵐�砲鐃緒申鐃� //ex) a("[This] is anchor.","URL")
				String A = "";
				int a1 = 0, a2 = name.length() - 1;
				try {
					for (int i = 0; i < name.length(); i++) {
						if (i > 0 && name.charAt(i) == '['
								&& name.charAt(i - 1) != '\\')
							a1 = i;
						else if (i > 0 && name.charAt(i) == ']'
								&& name.charAt(i - 1) != '\\')
							a2 = i;
					}
					if (a1 == 0 && a2 == name.length() - 1)
						A = name.substring(a1, a2 + 1);
					else
						A = name.substring(a1 + 1, a2);
					A = A.replaceAll("\\\\\\[", "[").replaceAll("\\\\\\]", "]");
					name.substring(0, a1).replaceAll("\\\\\\[", "[")
							.replaceAll("\\\\\\]", "]");
					name.substring(a2 + 1).replaceAll("\\\\\\[", "[")
							.replaceAll("\\\\\\]", "]");
				} catch (Exception e) {
				}
				Element result = JsoupFactory.createLink(url, "", A, className()).attr("data-transition", transition());
				if (decos.containsKey("prefetch") || decos.containsKey("pref"))
					result.attr("data-prefetch", "");
				return result;
	}
	
	private String className() { // added 20130703
		if (decos.containsKey("class"))
			return decos.getStr("class");
		return "";
	}
	
	private String transition() {
		// 鐃緒申鐃緒申鐃緒申鐃旬ワ申鐃祝メー鐃緒申鐃緒申鐃�data-transition)鐃緒申鐃緒申鐃緒申僚鐃緒申鐃�
		// //鐃緒申鐃緒申鐃緒申鐃准￥申鐃緒申鐃舜わ申鐃緒申鐃旬にわ申鐃出縁申鐃緒申鐃銃わ申鐃淑わ申
		if (decos.containsKey("transition"))
			return decos.getStr("transition");
		if (decos.containsKey("trans"))
			return decos.getStr("trans");
		return "";
	}
	
	private Node FuncObject(String path){
		String classID = HTMLEnv.getClassID(this);
		Element result = null;

		if (path.equals("")) {
			try {
				path = ((FuncArg) this.getArgs().get(0)).getStr().trim();
			} catch (Exception e) {
			}
		}

		// 各引数毎に処理した結果をHTMLに書きこむ
		if (path.endsWith(".php")) { // .php file
			String phpCode = "";
			BufferedReader in;
			try {
				in = new BufferedReader(new InputStreamReader(
						new FileInputStream(path), "UTF-8"));
				String line = null;
				while (true) {
					line = in.readLine();
					if (line == null)
						break;
					else
						phpCode+= line + "\n";
				}
				in.close();
				return new TextNode(phpCode, "");
			} catch (Exception e) {
				System.err.println("<Warning> Can't open '" + path + "'.");
			}
		} else if (path.endsWith(".js")) // .js file
			result = JsoupFactory.createJsElement(path);
		else
			result = new Element(Tag.valueOf("object"), "").attr("data", path).addClass(classID).html("\n");
			// .html, .pdf, .swf, .gif, .mp4, etc.
		return result;
	}

	// added by goto 20130308 end

	
	private TextNode FuncSeqNum(){
		String classID = HTMLEnv.getClassID(this);
		int i;
		for (i = 0; i < seq_num_ClassID.size() + 1; i++) {
			try {
				if (classID.equals(seq_num_ClassID.get(i)))
					break;
			} catch (Exception e1) {
				seq_num_ClassID.add(i, classID);
				try {
					// 第一引数
					seq_num.add(i, Integer.parseInt(getValue(1)));
					// 第二引数
					if (getValue(2).toLowerCase().trim().equals("desc"))
						DESC_Flg.add(i, true);
					else
						DESC_Flg.add(i, false);
				} catch (Exception e2) {
					seq_num.add(i, 1); // default
					DESC_Flg.add(i, false); // default
				}
				break;
			}
		}

		// 各引数毎に処理した結果をHTMLに書きこむ
		TextNode result = new TextNode(""
				+ ((!DESC_Flg.get(i)) ? (seq_num.get(i)) : (seq_num.get(i))), "");
		if (!DESC_Flg.get(i))
			seq_num.set(i, seq_num.get(i) + 1);
		else
			seq_num.set(i, seq_num.get(i) - 1);
		return result;
	}
	
	private Element FuncFormCommonForJsoup(String s) {
		Element result = new Element(Tag.valueOf("div"), "");

		String form = new String();

		boolean openFormInThis = false;

		if (!HTMLEnv.getFormItemFlg()) {
			form = createForm(decos);
			openFormInThis = true;
		}

		HTMLEnv.setFormItemFlg(true, s);

		String att = new String();
		Integer attNo = 1;
		while (!this.getAtt("att" + attNo).equals("")) {
			if (attNo > 1)
				att += ",";
			att += this.getAtt("att" + attNo);
			Log.out("att:" + att + " attNo:" + attNo);
			attNo++;
		}
		if (attNo == 1 && !this.getAtt("att").equals("")) {
			att += this.getAtt("att");
			Log.out("att:" + att + " attNo:" + attNo);
		}

		if (!this.getAtt("name").equals("")) {
			HTMLEnv.setFormPartsName(this.getAtt("name"));
			HTMLEnv.exFormName();
		} else {
			HTMLEnv.setFormPartsName(null);
		}

		if (!this.getAtt("id").equals("")) {
			HTMLEnv.nameId = this.getAtt("id");
		}

		if (!this.getAtt("cond_name").equals("")) {
			HTMLEnv.condName = this.getAtt("cond_name");
		}
		if (!this.getAtt("cond").equals("")) {
			HTMLEnv.cond = this.getAtt("cond");
		}

		htmlEnv.code.append(form);

		if (this.getArgs().get(0) instanceof FuncArg) {
			// HTMLEnv.setSelectFlg(true,(String)this.decos.get("select"));
			HTMLEnv.setFormValueString(att);
			Log.out("ARGS are function");
			FuncArg fa = (FuncArg) this.getArgs().get(0);
			fa.workAtt();
		} else {
			this.workAtt("default");
		}

		if (openFormInThis == true) {
			htmlEnv.code.append("</form>");
			HTMLEnv.setFormItemFlg(false, null);
			openFormInThis = false;
		} else {
			HTMLEnv.setFormItemFlg(true, null);
		}
		return result;
	}

	private Element createFormForJsoup() {
		Element result = new Element(Tag.valueOf("form"), "");
		String path = new String();
		if (this.getAtt("path") != null && !this.getAtt("path").isEmpty()) {
			path = this.getAtt("path").replaceAll("\"", "");
		} else {
			path = ".";
		}

		result.attr("method", "POST").attr("action",
				path + "/servlet/supersql.form.FormServlet");
		result.appendChild(JsoupFactory.createInput("hidden", "configfile",
				path + "/config.ssql"));

		if (this.getAtt("link") != null && !this.getAtt("link").isEmpty()) {
			result.appendChild(JsoupFactory.createInput("hidden", "sqlfile",
					path + "/" + this.getAtt("link").replaceAll("\"", "")));
		} else if (this.getAtt("linkfile") != null
				&& !this.getAtt("linkfile").isEmpty()) {
			result.appendChild(JsoupFactory.createInput("hidden", "sqlfile",
					path + "/" + this.getAtt("linkfile").replaceAll("\"", "")));
		}

		if (this.getAtt("cond") != null && !this.getAtt("cond").isEmpty()) {
			if (!this.getAtt("cond").replaceAll("\"", "").isEmpty())
				result.appendChild(JsoupFactory.createInput("hidden", "cond1",
						this.getAtt("cond").replaceAll("\"", "")));
		}

		String att = new String();
		Integer attNo = 1;
		while (!this.getAtt("att" + attNo).equals("")) {
			if (attNo > 1)
				att += ",";
			att += this.getAtt("att" + attNo);
			attNo++;
			Log.out("att:" + att + " attNo:" + attNo);
		}

		if (attNo == 1 && !this.getAtt("att").equals("")) {
			att += this.getAtt("att");
			Log.out("att:" + att + " attNo:" + attNo);
		}

		if (this.getAtt("update") != null && !this.getAtt("update").isEmpty()) {
			result.appendChild(JsoupFactory.createInput("hidden", "updatefile",
					path + "/" + this.getAtt("update").replaceAll("\"", "")
							+ "(" + att + ")"));
		} else if (this.getAtt("updatefile") != null
				&& !this.getAtt("updatefile").isEmpty()) {
			result.appendChild(JsoupFactory.createInput("hidden", "updatefile",
					path + "/" + this.getAtt("updatefile").replaceAll("\"", "")
							+ "(" + att + ")"));
		}
		return result;
	}

	public static String createForm(DecorateList decos) {
		new String();
		String path = new String();
		String form = new String();
		// System.out.println(this.getAtt("label"));
		if (decos.containsKey("path")) {
			path = decos.getStr("path").replaceAll("\"", "");
		} else {
			path = ".";
		}

		form = "<form method=\"POST\" action=\"" + path
				+ "/supersql.form.FormServlet\" " + "name=\""
				+ HTMLEnv.getFormName() + "\" " + ">";

		form += "<input type=\"hidden\" name=\"configfile\" value=\""
				+ GlobalEnv.getFileDirectory() + "/config.ssql\" />";

		if (decos.containsKey("link")) {
			opt(decos.getStr("link"));
			form += "<input type=\"hidden\" name=\"sqlfile\" value=\"" + path
					+ "/" + decos.getStr("link").replaceAll("\"", "") + "\" />";
		}

		if (decos.containsKey("cond")) {
			form += "<input type=\"hidden\" name=\"cond1\" value=\""
					+ decos.getStr("cond").replaceAll("\"", "") + "\" />";
		}

		if (decos.containsKey("updatefile")) {
			String tmp = opt(decos.getStr("updatefile"));
			updateFile = "<input type=\"hidden\" name=\"updatefile\" value=\""
					+ path + "/" + tmp + "\" />";
			form += updateFile;
		}
		if (decos.containsKey("linkfile")) {
			opt(decos.getStr("linkfile"));
			form += "<input type=\"hidden\" name=\"linkfile\" value=\"" + path
					+ "/" + decos.getStr("linkfile").replaceAll("\"", "")
					+ "\" />";
		}
		if (decos.containsKey("cond")) {
			form += "<input type=\"hidden\" name=\"linkcond\" value=\""
					+ decos.getStr("cond").replaceAll("\"", "") + "\" />";
		}
		Log.out(form);
		HTMLEnv.setFormDetail(form);
		return form;
	}

	protected static Element createFormForJsoup(DecorateList decos) {
		Element result = new Element(Tag.valueOf("form"), "");
		String path = new String();
		if (decos.containsKey("path")) {
			path = decos.getStr("path").replaceAll("\"", "");
		} else {
			path = ".";
		}

		result.attr("method", "POST");
		result.attr("action", path + "/supersql.form.FormServlet");
		result.attr("name", HTMLEnv.getFormName());

		result.appendChild(JsoupFactory.createInput("hidden", "configFile",
				GlobalEnv.getFileDirectory() + "/config.ssql"));

		if (decos.containsKey("link")) {
			opt(decos.getStr("link"));
			result.appendChild(JsoupFactory.createInput("hidden", "sqlfile",
					path + "/" + decos.getStr("link").replaceAll("\"", "")));
		}

		if (decos.containsKey("cond")) {
			result.appendChild(JsoupFactory.createInput("hidden", "cond1", path
					+ "/" + decos.getStr("link").replaceAll("\"", "")));
		}

		if (decos.containsKey("updatefile")) {
			result.appendChild(JsoupFactory.createInput("hidden", "updateFile",
					path + "/" + opt(decos.getStr("updatefile"))));
		}
		if (decos.containsKey("linkfile")) {
			opt(decos.getStr("linkfile"));
			result.appendChild(JsoupFactory.createInput("hidden", "linkfile",
					path + "/" + decos.getStr("linkfile").replaceAll("\"", "")));
		}
		if (decos.containsKey("cond")) {
			result.appendChild(JsoupFactory.createInput("hidden", "linkcond",
					decos.getStr("cond").replaceAll("\"", "")));
		}
		return result;
	}

	// tk
	// end////////////////////////////////////////////////////////////////////////////

	public static String opt(String s) {
		if (s.contains("\"")) {
			s = s.replaceAll("\"", "");
		}
		if (s.startsWith("./")) {
			s = s.substring(2, s.length());
		}
		if (s.startsWith("/")) {
			s = s.substring(1, s.length());
		}
		return s;
	}
	
	private Element FuncYoutube(){
		String path = this.getAtt("default");
		Element object = new Element(Tag.valueOf("object"), "");
		object.attr("width", "400").attr("height", "385");
		String objectString = 
		"<param name=\"movie\" value=\"http://www.youtube.com/v/"
				+ path
				+ "?fs=1&amp;hl=ja_JP\"></param><param name=\"allowFullScreen\" value=\"true\">"
				+ "</param><param name=\"allowscriptaccess\" value=\"always\"></param><embed src=\"http://www.youtube.com/v/"
				+ path
				+ "?fs=1&amp;hl=ja_JP\" type=\"application/x-shockwave-flash\" "
				+ "allowscriptaccess=\"always\" allowfullscreen=\"true\" width=\"480\" height=\"385\">"
				+ "</embed>";
		object.html(objectString);
		return object;
	}

	private Element FuncMovieFile(){
		Element video = new Element(Tag.valueOf("video"), "");
		
		
		String path = this.getAtt("path", ".");
		if (!path.startsWith("/")) {
			String basedir = GlobalEnv.getBaseDir();
			if (basedir != null && basedir != "") {
				path = GlobalEnv.getBaseDir() + "/" + path;
			}
		}
		
		video.addClass(HTMLEnv.getClassID(this));

		if (decos.containsKey("class"))
			video.addClass(decos.getStr("class"));

		video.attr("src", path + "/" + this.getAtt("default"));
		video.attr("autobuffer", "");
		video.attr("controls", "");
		Element p = new Element(Tag.valueOf("p"),"");
		p.append("Try this page in Safari 4! Or you can ");
		p.appendChild(JsoupFactory.createLink(path + "/" + this.getAtt("default"), "", "download the video"));
		p.append(" instead");
		video.appendChild(p);
		return video;
	}

	private Element FuncMeter() {
		meter_id++;
		Element result = new Element(Tag.valueOf("div"), "");
		Element script = new Element(Tag.valueOf("script"), "").attr("type",
				"text/javascript");
		String scriptString = "addEvent(window,\"load\",function() { \nvar layout = [";

		if (decos.containsKey("width"))
			scriptString += decos.getStr("width");
		scriptString += ",";
		if (decos.containsKey("height"))
			scriptString += decos.getStr("height");
		scriptString += ",";
		if (decos.containsKey("m_width"))
			scriptString += decos.getStr("m_width");
		scriptString += ",";
		if (decos.containsKey("m_height"))
			scriptString += decos.getStr("m_height");
		scriptString += ",";
		if (decos.containsKey("max"))
			scriptString += decos.getStr("max");
		scriptString += ",";
		if (decos.containsKey("min"))
			scriptString += decos.getStr("min");
		scriptString += ",";
		if (decos.containsKey("low"))
			scriptString += decos.getStr("low");
		scriptString += ",";
		if (decos.containsKey("high"))
			scriptString += decos.getStr("high");
		scriptString += ",";
		if (decos.containsKey("max_color"))
			scriptString += decos.getStr("max_color");
		scriptString += ",";
		if (decos.containsKey("low_color"))
			scriptString += decos.getStr("low_color");
		scriptString += ",";
		if (decos.containsKey("high_color"))
			scriptString += decos.getStr("high_color");
		scriptString += ",";
		if (decos.containsKey("mid_color"))
			scriptString += decos.getStr("mid_color");
		scriptString += ",";
		if (decos.containsKey("bg_color"))
			scriptString += decos.getStr("bg_color");
		scriptString += "] \ndraw(\"meter" + meter_id + "\",layout,color,"
				+ this.getAtt("default") + ");});";

		script.text(scriptString);
		
		Element div = new Element(Tag.valueOf("div"), "");
		Element canvas = new Element(Tag.valueOf("canvas"), "");
		if (decos.containsKey("width"))
			canvas.attr("width",decos.getStr("width"));
		else
			canvas.attr("width", "200");
		if (decos.containsKey("height"))
			canvas.attr("height", decos.getStr("height"));
		else
			canvas.attr("height,", "40");
		div.appendChild(canvas);
		result.appendChild(script);
		result.appendChild(div);
		return result;
	}

	// 20130920
	private String getValue(int x) {
		try {
			String str = ((FuncArg) this.getArgs().get(x - 1)).getStr(); // 第x引数
			if (!str.equals(""))
				return str;
			else
				return "";
		} catch (Exception e) {
			return "";
		}
	}
}
