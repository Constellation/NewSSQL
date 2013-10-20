package supersql.codegenerator.HTML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Vector;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.dataconstructor.DataConstructor;
import supersql.extendclass.ExtList;

public class HTMLManager extends Manager {

	private HTMLEnv htmlEnv;
	private HTMLEnv htmlEnv2;

	public HTMLManager(HTMLEnv henv, HTMLEnv henv2) {
		this.htmlEnv = henv;
		this.htmlEnv2 = henv2;
	}

	@Override
	public void generateCode(ITFE tfe_info, ExtList data_info) {
		HTMLEnv.initAllFormFlg();

		HTMLEnv.countFile = 0;
		HTMLEnv.code = new StringBuffer();
		HTMLEnv.css = new StringBuffer();
		HTMLEnv.header = new StringBuffer();
		HTMLEnv.footer = new StringBuffer();
		HTMLEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTMLEnv.writtenClassId = new Vector();
		HTMLEnv.notWrittenClassId = new Vector();
		Document result = HTMLEnv.getHtmlEnv1();

		getOutfilename();
		result.setBaseUri(HTMLEnv.outFile + ".html");

		if (tfe_info instanceof HTMLG3) {
			tfe_info.createNode(data_info);
			createOutputFile(result);
			return;
		}

		HTMLEnv.fileName = HTMLEnv.outFile + ".html";

		HTMLEnv.setOutlineMode();

		if (data_info.size() == 0
				&& !DataConstructor.SQL_string
						.equals("SELECT DISTINCT  FROM ;")
				&& !DataConstructor.SQL_string.equals("SELECT  FROM ;")) {
			Log.out("no data");
			return;
		} else
			result.body().getElementById("ssql")
					.appendChild((Element) tfe_info.createNode(data_info));

		HTMLEnv.createHeader();
		try {
			if (GlobalEnv.cssout() != null) {
				PrintWriter pw3 = new PrintWriter(new BufferedWriter(
						new FileWriter(GlobalEnv.cssout())));
				pw3.println(HTMLEnv.header);
				pw3.close();
			}

			HTMLEnv.initAllFormFlg();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
			System.err.println("Error: specified outdirectory \""
					+ HTMLEnv.outDir + "\" is not found to write "
					+ HTMLEnv.fileName);
			GlobalEnv.addErr("Error: specified outdirectory \""
					+ HTMLEnv.outDir + "\" is not found to write "
					+ HTMLEnv.fileName);
		} catch (IOException e) {
			System.err
					.println("Error[HTMLManager]: File IO Error in HTMLManager");
			e.printStackTrace();
			GlobalEnv
					.addErr("Error[HTMLManager]: File IO Error in HTMLManager");
		}
		createOutputFile(result);
	}

	private void createOutputFile(Element document) {
		if (document != null) {
			try {
				String filename = document.baseUri();
				Writer out = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(filename), "UTF-8"));
				out.write(document.html());
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private int lastIndexOf(String string) {
		// TODO 鐃緒申動鐃緒申鐃緒申鐃緒申鐃曙た鐃潤ソ鐃獣ド￥申鐃緒申鐃緒申鐃緒申
		return 0;
	}

	private int indexOf(String string) {
		// TODO 鐃緒申動鐃緒申鐃緒申鐃緒申鐃曙た鐃潤ソ鐃獣ド￥申鐃緒申鐃緒申鐃緒申
		return 0;
	}

	// tk
	// start///////////////////////////////////////////////////////////////////////
	@Override
	public StringBuffer generateCode2(ITFE tfe_info, ExtList data_info) {
		HTMLEnv.initAllFormFlg();

		HTMLEnv.countFile = 0;
		HTMLEnv.code = new StringBuffer();
		HTMLEnv.css = new StringBuffer();
		HTMLEnv.header = new StringBuffer();
		HTMLEnv.footer = new StringBuffer();
		HTMLEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTMLEnv.writtenClassId = new Vector();
		HTMLEnv.embedFlag = true;

		HTMLEnv.countFile = 0;
		HTMLEnv.code = new StringBuffer();
		HTMLEnv.css = new StringBuffer();
		HTMLEnv.header = new StringBuffer();
		HTMLEnv.footer = new StringBuffer();
		String xml_str = null;
		StringBuffer returncode = new StringBuffer();
		// 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
		getOutfilename();

		Log.out("[HTMLManager:generateCode2]");

		// ?鐃瞬鰹申側鐃緒申G3鐃緒申??
		if (tfe_info instanceof HTMLG3) {
			tfe_info.work(data_info);
			return HTMLEnv.code;
		}
		// ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??
		HTMLEnv.setOutlineMode();
		tfe_info.work(data_info);

		HTMLEnv.header
				.append("<?xml version=\"1.0\" encoding=\"Shift_JIS\"?><SSQL>");
		HTMLEnv.footer.append("</SSQL>");

		if (GlobalEnv.isOpt()) {
			int i = 0;
			while (HTMLEnv.code.indexOf("&", i) != -1) {
				i = HTMLEnv.code.indexOf("&", i);
				HTMLEnv.code = HTMLEnv.code.replace(i, i + 1, "&amp;");
				i++;
			}
			StringBuffer xml_string = new StringBuffer();
			xml_string.append(HTMLEnv.header);
			xml_string.append(HTMLEnv.code);
			xml_string.append(HTMLEnv.footer);
			HTMLoptimizer xml = new HTMLoptimizer();
			// System.out.println(xml_string); //commented out by goto 20120620
			xml_str = xml.generateHtml(xml_string);
			returncode.append(xml_str);
		}
		HTMLEnv.embedFlag = false;

		if (HTMLEnv.script.length() >= 5) {
			StringBuffer result = new StringBuffer();

			result.append(HTMLEnv.script);
			result.append("<end of script>\n");
			result.append(HTMLEnv.code);

			return result;
		} else {
			if (GlobalEnv.isOpt())
				return returncode;
			else
				return HTMLEnv.code;

		}
	}

	@Override
	public StringBuffer generateCodeNotuple(ITFE tfe_info) {
		Log.out("no data found");
		HTMLEnv.code = new StringBuffer();
		HTMLEnv.code.append("<div class=\"nodata\" >");
		HTMLEnv.code.append("NO DATA FOUND");
		HTMLEnv.code.append("</div>");

		return HTMLEnv.code;
	}

	@Override
	public StringBuffer generateCode3(ITFE tfe_info, ExtList data_info) {
		HTMLEnv.initAllFormFlg();

		HTMLEnv.countFile = 0;
		HTMLEnv.code = new StringBuffer();
		HTMLEnv.css = new StringBuffer();
		HTMLEnv.header = new StringBuffer();
		HTMLEnv.footer = new StringBuffer();
		HTMLEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTMLEnv.writtenClassId = new Vector();
		HTMLEnv.embedFlag = true;
		// 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
		getOutfilename();

		Log.out("[HTMLManager:generateCode]");

		// ?鐃瞬鰹申側鐃緒申G3鐃緒申??
		if (tfe_info instanceof HTMLG3) {
			tfe_info.work(data_info);
			return HTMLEnv.code;
		}
		// ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??

		HTMLEnv.setOutlineMode();
		tfe_info.work(data_info);
		// html_env.getCSS();
		HTMLEnv.embedFlag = false;
		Log.out("header : " + HTMLEnv.header);
		return HTMLEnv.css;
	}

	@Override
	public StringBuffer generateCode4(ITFE tfe_info, ExtList data_info) {
		HTMLEnv.initAllFormFlg();
		HTMLEnv.countFile = 0;
		HTMLEnv.code = new StringBuffer();
		HTMLEnv.css = new StringBuffer();
		HTMLEnv.header = new StringBuffer();
		HTMLEnv.footer = new StringBuffer();
		HTMLEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTMLEnv.writtenClassId = new Vector();

		HTMLEnv.countFile = 0;
		HTMLEnv.code = new StringBuffer();
		HTMLEnv.css = new StringBuffer();
		HTMLEnv.header = new StringBuffer();
		HTMLEnv.footer = new StringBuffer();
		HTMLEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTMLEnv.writtenClassId = new Vector<String>();

		HTMLEnv localenv = new HTMLEnv();

		// 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
		getOutfilename();

		Log.out("[HTMLManager:generateCode]");

		// ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??
		HTMLEnv.fileName = HTMLEnv.outFile + ".html";
		HTMLEnv.fileName = HTMLEnv.outFile + ".xml";

		HTMLEnv.setOutlineMode();
		tfe_info.work(data_info);

		HTMLEnv.appendHeader();
		HTMLEnv.embedFlag = false;
		Log.out("header : " + HTMLEnv.header);

		StringBuffer headfoot = new StringBuffer(HTMLEnv.header
				+ " ###split### " + HTMLEnv.footer);

		return headfoot;
	}

	@Override
	public StringBuffer generateCssfile(ITFE tfe_info, ExtList data_info) {

		HTMLEnv.countFile = 0;
		HTMLEnv.code = new StringBuffer();
		HTMLEnv.css = new StringBuffer();
		HTMLEnv.header = new StringBuffer();
		HTMLEnv.footer = new StringBuffer();
		HTMLEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTMLEnv.writtenClassId = new Vector();
		HTMLEnv.embedFlag = true;
		// 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
		getOutfilename();

		Log.out("[HTMLManager:generateCode]");

		HTMLEnv.setOutlineMode();
		tfe_info.work(data_info);
		HTMLEnv.embedFlag = false;
		Log.out("header : " + HTMLEnv.header);
		return HTMLEnv.cssFile;
	}

	// tk
	// end///////////////////////////////////////////////////////////////////////////////

	protected void getOutfilename() {
		String file = GlobalEnv.getfilename();
		String outdir = GlobalEnv.getoutdirectory();
		String outfile = GlobalEnv.getoutfilename();
		HTMLEnv.outDir = outdir;

		/*
		 * 鐃緒申鐃熟フワ申鐃緒申?(outfilename)鐃緒申鐃緒申鐃所さ?鐃銃わ申???
		 * html_env.outfile鐃緒申globalenv.outfilename鐃祝わ申?
		 * 鐃緒申?鐃淑鰹申鐃塾とわ申鐃熟ワ申鐃緒申?鐃春ワ申鐃緒申?鐃緒申名鐃緒申(filename)鐃祝わ申?
		 */
		if (GlobalEnv.getQuery() != null) {
			HTMLEnv.outFile = "./fromquery";

		} else if (outfile == null) {
			if (file.toLowerCase().indexOf(".sql") > 0) {
				HTMLEnv.outFile = file.substring(0,
						file.toLowerCase().indexOf(".sql"));
			} else if (file.toLowerCase().indexOf(".ssql") > 0) {
				HTMLEnv.outFile = file.substring(0,
						file.toLowerCase().indexOf(".ssql"));
			}
		} else {
			HTMLEnv.outFile = getOutfile(outfile);
		}

		if (HTMLEnv.outFile.indexOf("/") > 0) {
			HTMLEnv.linkOutFile = HTMLEnv.outFile.substring(HTMLEnv.outFile
					.lastIndexOf("/") + 1);
		} else {
			HTMLEnv.linkOutFile = HTMLEnv.outFile;
		}
		/*
		 * //tk start if(html_env.outfile.lastIndexOf("\\") != -1) {
		 * html_env.outfile =
		 * html_env.outfile.substring(html_env.outfile.lastIndexOf("\\"));
		 * Log.out("outfile log:"+html_env.outfile); } //tk end
		 */
		/*
		 * 鐃緒申鐃緒申鐃緒申妊鐃�鐃緒申鐃緒申?(outdirectory)鐃緒申鐃緒申鐃所さ?鐃銃わ申???
		 * outdirectory鐃緒申filename鐃緒申弔覆鐃緒申鐃緒申鐃塾わ申file鐃夙わ申?
		 */

		if (outdir != null) {
			connectOutdir(outdir, outfile);
		}
	}

	private String getOutfile(String outfile) {
		String out = new String();
		if (outfile.indexOf(".html") > 0) {
			out = outfile.substring(0, outfile.indexOf(".html"));
		} else {
			out = outfile;
		}
		return out;
	}

	private void connectOutdir(String outdir, String outfile) {
		// added by goto 20120627 start
		String fileDir = new File(HTMLEnv.outFile).getAbsoluteFile()
				.getParent();
		if (fileDir.length() < HTMLEnv.outFile.length()
				&& fileDir
						.equals(HTMLEnv.outFile.substring(0, fileDir.length())))
			HTMLEnv.outFile = HTMLEnv.outFile.substring(fileDir.length() + 1); // 鐃緒申鐃出パワ申鐃春ワ申鐃緒申鐃緒申名
		// added by goto 20120627 end

		String tmpqueryfile = new String();
		if (HTMLEnv.outFile.indexOf("/") > 0) {
			if (outfile != null) {
				if (HTMLEnv.outFile.startsWith(".")
						|| HTMLEnv.outFile.startsWith("/")) {
					tmpqueryfile = HTMLEnv.outFile.substring(HTMLEnv.outFile
							.indexOf("/") + 1);
				}
			} else {
				tmpqueryfile = HTMLEnv.outFile.substring(HTMLEnv.outFile
						.lastIndexOf("/") + 1);
			}
		} else {
			tmpqueryfile = HTMLEnv.outFile;
		}
		if (!outdir.endsWith("/")) {
			outdir = outdir.concat("/");
		}
		HTMLEnv.outFile = outdir.concat(tmpqueryfile);
	}

	@Override
	public void finish() {

	}
}
