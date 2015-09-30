package supersql.codegenerator.HTML5;

import java.util.Vector;

import org.jsoup.nodes.Document;

import supersql.codegenerator.DecorateList;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.Jscss;
import supersql.codegenerator.LocalEnv;
import supersql.common.GlobalEnv;
import supersql.common.Log;

public class HTML5Env extends LocalEnv {
	
	private Document html5Env;
	
	public StringBuffer code;
	public int countFile = 0; // C3, G3
	public static StringBuffer css;
	public String fileName;
	public StringBuffer footer;
	public int haveClass = 0;
	public StringBuffer header;
	public int linkFlag = 0; // C3, G3
	public String linkOutFile;
	public String linkUrl; // C3, G3
	public Vector<String> notWrittenClassId = new Vector<String>();
	public String outDir;
	public String outFile;
	public Vector<String> writtenClassId = new Vector<String>();
	
	public HTML5Env() {
		this.html5Env = new Document("");
		new Document("");
	}
	
	public void append_css_def_att(String classid, DecorateList decos) {
		Log.out("[HTML5 append_css_def_att] classid = " + classid);
		Log.out("decos = " + decos);
		
		haveClass = 0;
		if (writtenClassId.contains(classid)) {
			haveClass = 1;
			Log.out("==> already created css style");
			return;
		} else if (notWrittenClassId != null && notWrittenClassId.contains(classid)) {
			Log.out("==> css style is null. not created style");
			return;
		}
		Log.out("==> new style @@ creating style no " + classid);
		
		// css情報の書き込み
		StringBuffer cssbuf = new StringBuffer();
		
		// width
		if (decos.containsKey("width")) {
			cssbuf.append("\twidth: " + decos.getStr("width") + "px;\n");
		}
		
		if (cssbuf.length() > 0) { // css情報が1つ以上ある
			haveClass = 1;
			css.append("." + classid + "{\n");
			css.append(cssbuf);
			css.append("}\n");
			writtenClassId.addElement(classid);
		} else {
			Log.out("==> css style is null.");
			notWrittenClassId.addElement(classid);
		}
		Log.out("");
	}
	
	public static String commonCSS() { // デフォルトのcss付与
		// TODO
		String s = "";
		if (!GlobalEnv.isOpt()) {
			s += ".row {\n display: flex;\n flex-direction: row;\n}\n";
			s += ".col {\n display: flex;\n flex-direction: column;\n}\n";
			s += ".att {\n border: solid 1px;\n}\n";
		}
		return s;
	}
	
	public static String getClassID(ITFE tfe) {
		String result;
		
		// ここにC3, G3の何かが入る可能性
		
		result = "TFE" + tfe.getId();
		return result;
	}
	
	public void getHeader() { // ヘッダーの作成
		header.append("<html>\n");
		header.append("<head>\n");
		header_creation(); // ヘッダー情報の追加 cssなど
		header.append("</head>\n");
		header.append("<body>\n");
	}
	
	public void getFooter() { // フッダーの作成
		footer.append("</body>\n");
		footer.append("</html>\n");
	}
	
	public void header_creation() { // css等詳細ヘッダーの追加
		header.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		header.append("<!-- Genarated CSS -->\n");
		header.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + Jscss.getGenerateCssFileName(0) + "\">\n");
	}
}
