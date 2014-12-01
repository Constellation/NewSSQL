package supersql.codegenerator.HTML_Flexbox;

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

public class HTML_FlexboxManager extends Manager {

	private HTML_FlexboxEnv htmlEnv;
	private HTML_FlexboxEnv htmlEnv2;

	public HTML_FlexboxManager(HTML_FlexboxEnv henv, HTML_FlexboxEnv henv2) {
		this.htmlEnv = henv;
		this.htmlEnv2 = henv2;
	}

	@Override
	public void generateCode(ITFE tfe_info, ExtList data_info) {
		HTML_FlexboxEnv.initAllFormFlg();

		HTML_FlexboxEnv.countFile = 0;
		HTML_FlexboxEnv.code = new StringBuffer();
		HTML_FlexboxEnv.css = new StringBuffer();
		HTML_FlexboxEnv.header = new StringBuffer();
		HTML_FlexboxEnv.footer = new StringBuffer();
		HTML_FlexboxEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTML_FlexboxEnv.writtenClassId = new Vector();
		HTML_FlexboxEnv.notWrittenClassId = new Vector();
		Document result = HTML_FlexboxEnv.getHtmlEnv1();

		getOutfilename();
		result.setBaseUri(HTML_FlexboxEnv.outFile + ".html");

		if (tfe_info instanceof HTML_FlexboxG3) {
			tfe_info.createNode(data_info);
			createOutputFile(result);
			return;
		}

		HTML_FlexboxEnv.fileName = HTML_FlexboxEnv.outFile + ".html";

		HTML_FlexboxEnv.setOutlineMode();

		if (data_info.size() == 0
				&& !DataConstructor.SQL_string
						.equals("SELECT DISTINCT  FROM ;")
				&& !DataConstructor.SQL_string.equals("SELECT  FROM ;")) {
			Log.out("no data");
			return;
		} else
			result.body().getElementById("ssql")
					.appendChild((Element) tfe_info.createNode(data_info));

		HTML_FlexboxEnv.createHeader();
		try {
			if (GlobalEnv.cssout() != null) {
				PrintWriter pw3 = new PrintWriter(new BufferedWriter(
						new FileWriter(GlobalEnv.cssout())));
				pw3.println(HTML_FlexboxEnv.header);
				pw3.close();
			}

			HTML_FlexboxEnv.initAllFormFlg();
		} catch (FileNotFoundException fe) {
			fe.printStackTrace();
			System.err.println("Error: specified outdirectory \""
					+ HTML_FlexboxEnv.outDir + "\" is not found to write "
					+ HTML_FlexboxEnv.fileName);
			GlobalEnv.addErr("Error: specified outdirectory \""
					+ HTML_FlexboxEnv.outDir + "\" is not found to write "
					+ HTML_FlexboxEnv.fileName);
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
		HTML_FlexboxEnv.initAllFormFlg();

		HTML_FlexboxEnv.countFile = 0;
		HTML_FlexboxEnv.code = new StringBuffer();
		HTML_FlexboxEnv.css = new StringBuffer();
		HTML_FlexboxEnv.header = new StringBuffer();
		HTML_FlexboxEnv.footer = new StringBuffer();
		HTML_FlexboxEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTML_FlexboxEnv.writtenClassId = new Vector();
		HTML_FlexboxEnv.embedFlag = true;

		HTML_FlexboxEnv.countFile = 0;
		HTML_FlexboxEnv.code = new StringBuffer();
		HTML_FlexboxEnv.css = new StringBuffer();
		HTML_FlexboxEnv.header = new StringBuffer();
		HTML_FlexboxEnv.footer = new StringBuffer();
		String xml_str = null;
		StringBuffer returncode = new StringBuffer();
		// 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
		getOutfilename();

		Log.out("[HTMLManager:generateCode2]");

		// ?鐃瞬鰹申側鐃緒申G3鐃緒申??
		if (tfe_info instanceof HTML_FlexboxG3) {
			tfe_info.work(data_info);
			return HTML_FlexboxEnv.code;
		}
		// ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??
		HTML_FlexboxEnv.setOutlineMode();
		tfe_info.work(data_info);

		HTML_FlexboxEnv.header
				.append("<?xml version=\"1.0\" encoding=\"Shift_JIS\"?><SSQL>");
		HTML_FlexboxEnv.footer.append("</SSQL>");

		if (GlobalEnv.isOpt()) {
			int i = 0;
			while (HTML_FlexboxEnv.code.indexOf("&", i) != -1) {
				i = HTML_FlexboxEnv.code.indexOf("&", i);
				HTML_FlexboxEnv.code = HTML_FlexboxEnv.code.replace(i, i + 1, "&amp;");
				i++;
			}
			StringBuffer xml_string = new StringBuffer();
			xml_string.append(HTML_FlexboxEnv.header);
			xml_string.append(HTML_FlexboxEnv.code);
			xml_string.append(HTML_FlexboxEnv.footer);
			HTML_Flexboxoptimizer xml = new HTML_Flexboxoptimizer();
			// System.out.println(xml_string); //commented out by goto 20120620
			xml_str = xml.generateHtml(xml_string);
			returncode.append(xml_str);
		}
		HTML_FlexboxEnv.embedFlag = false;

		if (HTML_FlexboxEnv.script.length() >= 5) {
			StringBuffer result = new StringBuffer();

			result.append(HTML_FlexboxEnv.script);
			result.append("<end of script>\n");
			result.append(HTML_FlexboxEnv.code);

			return result;
		} else {
			if (GlobalEnv.isOpt())
				return returncode;
			else
				return HTML_FlexboxEnv.code;

		}
	}

	@Override
	public StringBuffer generateCodeNotuple(ITFE tfe_info) {
		Log.out("no data found");
		HTML_FlexboxEnv.code = new StringBuffer();
		HTML_FlexboxEnv.code.append("<div class=\"nodata\" >");
		HTML_FlexboxEnv.code.append("NO DATA FOUND");
		HTML_FlexboxEnv.code.append("</div>");

		return HTML_FlexboxEnv.code;
	}

	@Override
	public StringBuffer generateCode3(ITFE tfe_info, ExtList data_info) {
		HTML_FlexboxEnv.initAllFormFlg();

		HTML_FlexboxEnv.countFile = 0;
		HTML_FlexboxEnv.code = new StringBuffer();
		HTML_FlexboxEnv.css = new StringBuffer();
		HTML_FlexboxEnv.header = new StringBuffer();
		HTML_FlexboxEnv.footer = new StringBuffer();
		HTML_FlexboxEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTML_FlexboxEnv.writtenClassId = new Vector();
		HTML_FlexboxEnv.embedFlag = true;
		// 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
		getOutfilename();

		Log.out("[HTMLManager:generateCode]");

		// ?鐃瞬鰹申側鐃緒申G3鐃緒申??
		if (tfe_info instanceof HTML_FlexboxG3) {
			tfe_info.work(data_info);
			return HTML_FlexboxEnv.code;
		}
		// ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??

		HTML_FlexboxEnv.setOutlineMode();
		tfe_info.work(data_info);
		// html_env.getCSS();
		HTML_FlexboxEnv.embedFlag = false;
		Log.out("header : " + HTML_FlexboxEnv.header);
		return HTML_FlexboxEnv.css;
	}

	@Override
	public StringBuffer generateCode4(ITFE tfe_info, ExtList data_info) {
		HTML_FlexboxEnv.initAllFormFlg();
		HTML_FlexboxEnv.countFile = 0;
		HTML_FlexboxEnv.code = new StringBuffer();
		HTML_FlexboxEnv.css = new StringBuffer();
		HTML_FlexboxEnv.header = new StringBuffer();
		HTML_FlexboxEnv.footer = new StringBuffer();
		HTML_FlexboxEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTML_FlexboxEnv.writtenClassId = new Vector();

		HTML_FlexboxEnv.countFile = 0;
		HTML_FlexboxEnv.code = new StringBuffer();
		HTML_FlexboxEnv.css = new StringBuffer();
		HTML_FlexboxEnv.header = new StringBuffer();
		HTML_FlexboxEnv.footer = new StringBuffer();
		HTML_FlexboxEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTML_FlexboxEnv.writtenClassId = new Vector<String>();

		HTML_FlexboxEnv.createHTMLDocument();

		// 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
		getOutfilename();

		Log.out("[HTMLManager:generateCode]");

		// ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??
		HTML_FlexboxEnv.fileName = HTML_FlexboxEnv.outFile + ".html";
		HTML_FlexboxEnv.fileName = HTML_FlexboxEnv.outFile + ".xml";

		HTML_FlexboxEnv.setOutlineMode();
		tfe_info.work(data_info);

		HTML_FlexboxEnv.appendHeader();
		HTML_FlexboxEnv.embedFlag = false;
		Log.out("header : " + HTML_FlexboxEnv.header);

		StringBuffer headfoot = new StringBuffer(HTML_FlexboxEnv.header
				+ " ###split### " + HTML_FlexboxEnv.footer);

		return headfoot;
	}

	@Override
	public StringBuffer generateCssfile(ITFE tfe_info, ExtList data_info) {

		HTML_FlexboxEnv.countFile = 0;
		HTML_FlexboxEnv.code = new StringBuffer();
		HTML_FlexboxEnv.css = new StringBuffer();
		HTML_FlexboxEnv.header = new StringBuffer();
		HTML_FlexboxEnv.footer = new StringBuffer();
		HTML_FlexboxEnv.foreachFlag = GlobalEnv.getForeachFlag();
		HTML_FlexboxEnv.writtenClassId = new Vector();
		HTML_FlexboxEnv.embedFlag = true;
		// 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
		getOutfilename();

		Log.out("[HTMLManager:generateCode]");

		HTML_FlexboxEnv.setOutlineMode();
		tfe_info.work(data_info);
		HTML_FlexboxEnv.embedFlag = false;
		Log.out("header : " + HTML_FlexboxEnv.header);
		return HTML_FlexboxEnv.cssFile;
	}

	// tk
	// end///////////////////////////////////////////////////////////////////////////////

	protected void getOutfilename() {
		String file = GlobalEnv.getfilename();
		String outdir = GlobalEnv.getoutdirectory();
		String outfile = GlobalEnv.getoutfilename();
		HTML_FlexboxEnv.outDir = outdir;

		/*
		 * 鐃緒申鐃熟フワ申鐃緒申?(outfilename)鐃緒申鐃緒申鐃所さ?鐃銃わ申???
		 * html_env.outfile鐃緒申globalenv.outfilename鐃祝わ申?
		 * 鐃緒申?鐃淑鰹申鐃塾とわ申鐃熟ワ申鐃緒申?鐃春ワ申鐃緒申?鐃緒申名鐃緒申(filename)鐃祝わ申?
		 */
		if (GlobalEnv.getQuery() != null) {
			HTML_FlexboxEnv.outFile = "./fromquery";

		} else if (outfile == null) {
			if (file.toLowerCase().indexOf(".sql") > 0) {
				HTML_FlexboxEnv.outFile = file.substring(0,
						file.toLowerCase().indexOf(".sql"));
			} else if (file.toLowerCase().indexOf(".ssql") > 0) {
				HTML_FlexboxEnv.outFile = file.substring(0,
						file.toLowerCase().indexOf(".ssql"));
			}
		} else {
			HTML_FlexboxEnv.outFile = getOutfile(outfile);
		}

		if (HTML_FlexboxEnv.outFile.indexOf("/") > 0) {
			HTML_FlexboxEnv.linkOutFile = HTML_FlexboxEnv.outFile.substring(HTML_FlexboxEnv.outFile
					.lastIndexOf("/") + 1);
		} else {
			HTML_FlexboxEnv.linkOutFile = HTML_FlexboxEnv.outFile;
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
		String fileDir = new File(HTML_FlexboxEnv.outFile).getAbsoluteFile()
				.getParent();
		if (fileDir.length() < HTML_FlexboxEnv.outFile.length()
				&& fileDir
						.equals(HTML_FlexboxEnv.outFile.substring(0, fileDir.length())))
			HTML_FlexboxEnv.outFile = HTML_FlexboxEnv.outFile.substring(fileDir.length() + 1); // 鐃緒申鐃出パワ申鐃春ワ申鐃緒申鐃緒申名
		// added by goto 20120627 end

		String tmpqueryfile = new String();
		if (HTML_FlexboxEnv.outFile.indexOf("/") > 0) {
			if (outfile != null) {
				if (HTML_FlexboxEnv.outFile.startsWith(".")
						|| HTML_FlexboxEnv.outFile.startsWith("/")) {
					tmpqueryfile = HTML_FlexboxEnv.outFile.substring(HTML_FlexboxEnv.outFile
							.indexOf("/") + 1);
				}
			} else {
				tmpqueryfile = HTML_FlexboxEnv.outFile.substring(HTML_FlexboxEnv.outFile
						.lastIndexOf("/") + 1);
			}
		} else {
			tmpqueryfile = HTML_FlexboxEnv.outFile;
		}
		if (!outdir.endsWith("/")) {
			outdir = outdir.concat("/");
		}
		HTML_FlexboxEnv.outFile = outdir.concat(tmpqueryfile);
	}

	@Override
	public void finish() {

	}
}
