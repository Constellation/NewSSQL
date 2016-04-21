package supersql.codegenerator.HTML5;

import supersql.codegenerator.Connector;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTML5C2 extends Connector{
	private HTML5Env html5Env;
	private HTML5Env html5Env2;
	
	public HTML5C2(Manager manager, HTML5Env hEnv, HTML5Env hEnv2) {
		this.html5Env = hEnv;
		this.html5Env2 = hEnv2;
	}
	
	@Override
	public String work(ExtList data_info) {
		Log.out("------- C2 -------");
		Log.out("tfes.contain_itemnum = " + tfes.contain_itemnum());
		Log.out("tfes.size = " + tfes.size());
		Log.out("countconnectitem = " + countconnectitem());
		
		// connector カウント初期化
		this.setDataList(data_info);
		
		// 親要素がtable状態なのかcheck
		boolean table_event = false;
		if (html5Env.tableFlag) {
			table_event = true;
		}
		// 親要素がborder状態なのかcheck
		boolean border_event = false;
		if (html5Env.borderFlag) {
			border_event = true;
		}
		// 親要素がlist-ul状態なのかcheck
		boolean listul_event = false;
		if (html5Env.listUlFlag) {
			listul_event = true;
		}
		// 親要素がlist-ol状態なのかcheck
		boolean listol_event = false;
		if (html5Env.listOlFlag) {
			listol_event = true;
		}
		
		// cssの情報を取得
		html5Env.append_css_def_att(HTML5Env.getClassID(this), this.decos);
		
		// htmlコード書き込み
		if (!GlobalEnv.isOpt()) {
			if (table_event) {
				html5Env.code.append("<td>\n");
			} else if (listul_event || listol_event) {
				html5Env.code.append("<li>\n");
			} else {
				html5Env.code.append("<div class=\"");
				html5Env.code.append(HTML5Env.getClassID(this));
				html5Env.code.append(" col\">\n");
			}
			if (html5Env.tableFlag) { // table
				html5Env.code.append("<table class=\"");
				html5Env.code.append(HTML5Env.getClassID(this));
				html5Env.code.append(" col\">\n");
			} else if (html5Env.listUlFlag) { // list-ul
				html5Env.code.append("<ul class=\"");
				html5Env.code.append(HTML5Env.getClassID(this));
				html5Env.code.append(" col\">\n");
			} else if (html5Env.listOlFlag) { // list-ol
				html5Env.code.append("<ol class=\"");
				html5Env.code.append(HTML5Env.getClassID(this));
				html5Env.code.append(" col\">\n");
			}
		}
		
		// 子要素に書き込み
		int i = 0;
		while (this.hasMoreItems()) {
			ITFE tfe = tfes.get(i);
			String classid = HTML5Env.getClassID(tfe);
			
			if (html5Env.tableFlag) {
				html5Env.code.append("<tr>\n");
			}
			
			this.worknextItem();
			
			if (html5Env.tableFlag) {
				html5Env.code.append("</tr>\n");
			}
			
			i++;
		}
		
		if (html5Env.borderFlag && !border_event) {
			html5Env.borderFlag = false;
			Log.out("****** border off ******");
		}
		
		if (html5Env.tableFlag) {
			html5Env.code.append("</table>\n");
			if (!table_event) {
				html5Env.tableFlag = false;
				Log.out("********table end********");
			}
		} else if (html5Env.listUlFlag) {
			html5Env.code.append("</ul>\n");
			if (!listul_event) {
				html5Env.listUlFlag = false;
				Log.out("********list end********");
			}
		} else if (html5Env.listOlFlag) {
			html5Env.code.append("</ol>\n");
			if (!listol_event) {
				html5Env.listOlFlag = false;
				Log.out("********list end********");
			}
		}
		
		if (table_event) {
			html5Env.code.append("</td>\n");
		} else if (listul_event || listol_event) {
			html5Env.code.append("</li>\n");
		} else {
			html5Env.code.append("</div>\n");
		}
		
		Log.out("+++++++ C2 +++++++");
		return null;
	}
}
