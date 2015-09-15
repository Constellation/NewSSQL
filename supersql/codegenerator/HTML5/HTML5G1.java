package supersql.codegenerator.HTML5;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTML5G1 extends Grouper {
	private HTML5Env html5Env;
	private HTML5Env html5Env2;
	
	public HTML5G1(Manager manager, HTML5Env hEnv, HTML5Env hEnv2) {
		this.html5Env = hEnv;
		this.html5Env2 = hEnv2;
	}
	
	@Override
	public String work(ExtList data_info) {
		Log.out("------- G1 -------");
		
		// connector カウント初期化
		this.setDataList(data_info);
		
		// cssの情報を取得
		html5Env.append_css_def_att(HTML5Env.getClassID(this), this.decos);
		
		// htmlコード書き込み
		if (!GlobalEnv.isOpt()) {
			html5Env.code.append("<div class=\"");
			html5Env.code.append(HTML5Env.getClassID(this));
			html5Env.code.append(" row\">\n");
		}
		
		// 子要素に書き込み
		while (this.hasMoreItems()) {
			String classid = HTML5Env.getClassID(tfe);
			
			this.worknextItem();
		}
		
		html5Env.code.append("</div>");
		
		return null;
	}
	
}
