package supersql.codegenerator.HTML;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTMLG1 extends Grouper {

	private HTMLEnv html_env;
	private HTMLEnv html_env2;
	boolean retFlag = false;	// 20140602_masato pagenationフラグ
	boolean pageFlag = false;	// 20140602_masato pagenationフラグ

	// ���󥹥ȥ饯��
	public HTMLG1(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		this.html_env = henv;
		this.html_env2 = henv2;

	}

	@Override
	public String getSymbol() {
		return "HTMLG1";
	}

	// G1��work�᥽�å�
	@Override
	public String work(ExtList data_info) {
		Log.out("------- G1 -------");
		this.setDataList(data_info);
		// tk start///////////////////////////////////////////////////
		html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

		// 20140526_masato
		int count = 0;		// 20140526_masato
		int count2 = 0;		// 20140526_masato
		int i = 0;			// 20140526_masato
		int j = 0;			// 20140526_masato
		if (decos.containsKey("column")) {
			i = Integer.parseInt(decos.getStr("column"));
			retFlag = true;
		}
		if (decos.containsKey("column") && decos.containsKey("row")) {
			i = Integer.parseInt(decos.getStr("column"));
			j = Integer.parseInt(decos.getStr("row"));
			pageFlag = true;
			retFlag = false;
		}
		
		// 20140602_masato
		if(pageFlag){
			html_env.code.append("<div id=\"res\"></div>\n" + 
			"<div id=\"Pagination\" class=\"pagination\"></div>\n" + 
	        "<!-- Container element for all the Elements that are to be paginated -->\n" + 
	        "<div id=\"hiddenresult\" style=\"display:none;\">\n" + 
	        "<div class=\"result\">\n");
		}
		
		if (!GlobalEnv.isOpt()) {
			html_env.code
					.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
			html_env.code.append(html_env.tableBorder + "\"");

			html_env.code.append(" class=\"");

			if (html_env.embedFlag)
				html_env.code.append("embed ");

			if (decos.containsKey("outborder"))
				html_env.code.append(" noborder ");

			if (decos.containsKey("class")) {
				// class=menu�Ȃǂ̎w�肪��������t��
				html_env.code.append(decos.getStr("class") + " ");
			}
			if (html_env.haveClass == 1) {
				// class=menu�Ȃǂ̎w�肪��������t��
				html_env.code.append(HTMLEnv.getClassID(this) + " ");
			}
			html_env.code.append("nest\"");

			html_env.code.append(html_env.getOutlineMode());

			html_env.code.append("><TR>");
		}
		// tk end//////////////////////////////////////////////////////
		
		Log.out("<TABLE class=\"" + HTMLEnv.getClassID(this) + "\"><TR>");
		

		while (this.hasMoreItems()) {
			html_env.gLevel++;
			count++;

			if (GlobalEnv.isOpt()) {
				html_env2.code.append("<tfe type=\"repeat\" dimension=\"1\"");

				if (decos.containsKey("class")) {
					// class=menu�Ȃǂ̎w�肪��������t��
					html_env2.code.append(" class=\"");
					html_env2.code.append(decos.getStr("class") + " ");
				}
				if (html_env.writtenClassId.contains(HTMLEnv.getClassID(this))) {
					// TFE10000�Ȃǂ̎w�肪��������t��
					if (decos.containsKey("class")) {
						html_env2.code.append(HTMLEnv.getClassID(this) + "\"");
					} else {
						html_env2.code.append(" class=\""
								+ HTMLEnv.getClassID(this) + "\"");
					}
				} else if (decos.containsKey("class")) {
					html_env2.code.append("\"");
				}

				html_env2.code.append(" border=\"" + html_env.tableBorder
						+ "\"");

				if (decos.containsKey("tablealign"))
					html_env2.code.append(" align=\""
							+ decos.getStr("tablealign") + "\"");
				if (decos.containsKey("tablevalign"))
					html_env2.code.append(" valign=\""
							+ decos.getStr("tablevalign") + "\"");

				if (decos.containsKey("tabletype")) {
					html_env2.code.append(" tabletype=\""
							+ decos.getStr("tabletype") + "\"");
					if (decos.containsKey("cellspacing")) {
						html_env2.code.append(" cellspacing=\""
								+ decos.getStr("cellspacing") + "\"");
					}
					if (decos.containsKey("cellpadding")) {
						html_env2.code.append(" cellpadding=\""
								+ decos.getStr("cellpadding") + "\"");
					}
				}
				html_env2.code.append(">");
			}

			
			html_env.code.append("<TD class=\"" + HTMLEnv.getClassID(tfe)
					+ " nest\">\n");
			String classid = HTMLEnv.getClassID(tfe);

			Log.out("<TD class=\"" + HTMLEnv.getClassID(tfe) + " nest\">");

			this.worknextItem();

			if (html_env.notWrittenClassId.contains(classid)) {
				html_env.code.delete(html_env.code.indexOf(classid),
						html_env.code.indexOf(classid) + classid.length() + 1);
			}

			html_env2.code.append("</tfe>");

			html_env.code.append("</TD>\n");
			Log.out("</TD>");
			if(retFlag){
				if((count % i) == 0){					// 20140526_masato
					html_env.code.append("</TR>\n");
					html_env.code.append("<TR>\n");
					count2++;
				}
			}
			
			if(pageFlag){
				if((count % i) == 0){					// 20140526_masato
					count2++;
					html_env.code.append("</TR>\n");
					
					if(count2 % j == 0 && this.hasMoreItems()){
						html_env.code.append("</TABLE>\n"
								+ "</div>\n<div class = \"result\">");
						html_env.code
								.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
						html_env.code.append(html_env.tableBorder + "\"");

						html_env.code.append(" class=\"");

						if (html_env.embedFlag)
							html_env.code.append("embed ");

						if (decos.containsKey("outborder"))
							html_env.code.append(" noborder ");

						if (decos.containsKey("class")) {
							// class=menu�Ȃǂ̎w�肪��������t��
							html_env.code.append(decos.getStr("class") + " ");
						}
						if (html_env.haveClass == 1) {
							// class=menu�Ȃǂ̎w�肪��������t��
							html_env.code
									.append(HTMLEnv.getClassID(this) + " ");
						}
						html_env.code.append("nest\"");

						// masato_20140602 なんじゃこりゃ？
//						html_env.code.append(html_env.getOutlineMode());

						html_env.code.append(">");
					}

					html_env.code.append("<TR>\n");
				}
			}
			html_env.gLevel--;
		}

		if (HTMLEnv.getFormItemFlg()) {
			HTMLEnv.incrementFormPartsNumber();
		}

		// html_env2.code.append("</tfe>");
		html_env.code.append("</TR></TABLE>\n");
		if(pageFlag){
			html_env.code.append("</div>\n");
			html_env.code.append("</div>\n");
			html_env.code.append("</div>\n");
		}
		Log.out("</TR></TABLE>");

		Log.out("TFEId = " + HTMLEnv.getClassID(this));
		// html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
		return null;

	}

}
