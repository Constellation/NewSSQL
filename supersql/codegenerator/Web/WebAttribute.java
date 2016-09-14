package supersql.codegenerator.Web;

import java.io.File;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class WebAttribute extends Attribute {
	
	private WebEnv webEnv;
	private WebEnv webEnv2;
	
	public WebAttribute(Manager manager, WebEnv wEnv, WebEnv wEnv2) {
		super();
		this.webEnv = wEnv;
		this.webEnv2 = wEnv2;
	}
	
	@Override
	public String work(ExtList data_info) {
		
		// css情報書き込み
		webEnv.append_css_def_att(WebEnv.getClassID(this), this.decos);
		
		// HTMLコード書き込み
		if (webEnv.tableFlag) {
			webEnv.code.append("<td class=\"");
			webEnv.code.append(WebEnv.getClassID(this));
			webEnv.code.append(" att\">");
		} else if (webEnv.listUlFlag || webEnv.listOlFlag) {
			webEnv.code.append("<li class=\"");
			webEnv.code.append(WebEnv.getClassID(this));
			webEnv.code.append(" att\">");
		} else {
			webEnv.code.append("<div class=\"");
			webEnv.code.append(WebEnv.getClassID(this));
			webEnv.code.append(" att\">");
		}
		
		// C3, G3の場合 <a>
		if (webEnv.linkFlag > 0) {
			//TODO
			String fileDir = new File(webEnv.linkUrl).getAbsoluteFile().getParent();
			if (fileDir.length() < webEnv.linkUrl.length() && fileDir.equals(webEnv.linkUrl.substring(0, fileDir.length()))) {
				String relative_path = webEnv.linkUrl.substring(fileDir.length() + 1);
				webEnv.code.append("<a href=\"" + relative_path + "\">");
				Log.out("<a href=\"" + relative_path + "\">");
			} else {
				webEnv.code.append("<a href=\"" + webEnv.linkUrl + "\">");
				Log.out("<a href=\"" + webEnv.linkUrl + "\">");
			}
		}
		
		Log.out("data_info = " + data_info);
		String data = this.getStr(data_info);
		Log.out("data = " + data);
		data = data.replace("\\r\\n", "<br>");
		data = data.replace("\\r", "<br>");
		data = data.replace("\\n", "<br>");
		Log.out("replace data = " + data);
		// webEnv.code.append(this.getStr(data_info));
		webEnv.code.append(data);
		
		// C3, G3の場合 </a>
		if (webEnv.linkFlag > 0) {
			//TODO
			webEnv.code.append("</a>");
			Log.out("</a>");
		}
		
		if (webEnv.tableFlag) {
			webEnv.code.append("</td>\n");
		} else if (webEnv.listUlFlag || webEnv.listOlFlag) {
			webEnv.code.append("</li>\n");
		} else {
			webEnv.code.append("</div>\n");
		}
		
		return null;
	}
}
