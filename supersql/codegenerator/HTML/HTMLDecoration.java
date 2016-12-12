package supersql.codegenerator.HTML;

import java.util.ArrayList;

import supersql.codegenerator.Connector;
import supersql.codegenerator.Decorator;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

//tk

public class HTMLDecoration extends Decorator {

	private HTMLEnv htmlEnv;
	private HTMLEnv htmlEnv2;
	
	public static ArrayList<StringBuffer> fronts = new ArrayList<StringBuffer>();
	public static ArrayList<StringBuffer> classes = new ArrayList<StringBuffer>();
	public static ArrayList<StringBuffer> styles = new ArrayList<StringBuffer>();
	public static ArrayList<StringBuffer> ends = new ArrayList<StringBuffer>();

	// ���󥹥ȥ饯��
	public HTMLDecoration(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		this.htmlEnv = henv;
		this.htmlEnv2 = henv2;
	}

	@Override
	public String getSymbol() {
		return "HTMLDecoration";
	}

	// Decoration��work�᥽�å�
	@Override
	public String work(ExtList data_info) {
		Log.out("------- Decoration -------");
		Log.out("tfes.contain_itemnum=" + tfes.contain_itemnum());
		Log.out("tfes.size=" + tfes.size());
		Log.out("countconnetitem=" + countconnectitem());
		
		StringBuffer Front = new StringBuffer();
		StringBuffer classname = new StringBuffer();
		StringBuffer Style = new StringBuffer();
		StringBuffer End = new StringBuffer();
		fronts.add(0, Front);
		classes.add(0, classname);
		styles.add(0, Style);
		ends.add(0, End);
		ArrayList<String> decoproperty = new ArrayList<String>();
		htmlEnv.decorationProperty.add(0, decoproperty);
		htmlEnv.decorationStartFlag.add(0, false);
		htmlEnv.decorationEndFlag.add(0, false);

		this.setDataList(data_info);
		
		// tk
		// start///////////////////////////////////////////////////////////////////////
//		htmlEnv.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
		
//		if (!GlobalEnv.isOpt()) {
//			htmlEnv.code
//					.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
//			htmlEnv.code.append(htmlEnv.tableBorder + "\"");
//			htmlEnv.code.append(htmlEnv.getOutlineMode());
//			/*
//			 * if(decos.containsKey("outborder")){
//			 * html_env.code.append(" noborder ");
//			 * html_env2.code.append(" noborder "); }
//			 */
//			// classid������Ȥ��ˤ�������
//			if (htmlEnv.writtenClassId.contains(HTMLEnv.getClassID(this))) {
//				htmlEnv.code.append(" class=\"");
//				htmlEnv.code.append(HTMLEnv.getClassID(this));
//			}
//
//			if (decos.containsKey("class")) {
//				if (!htmlEnv.writtenClassId.contains(HTMLEnv.getClassID(this))) {
//					htmlEnv.code.append(" class=\"");
//				} else {
//					htmlEnv.code.append(" ");
//				}
//				htmlEnv.code.append(decos.getStr("class") + "\" ");
//			} else if (htmlEnv.writtenClassId
//					.contains(HTMLEnv.getClassID(this))) {
//				htmlEnv.code.append("\" ");
//			}
//			htmlEnv.code.append("><TR>");
//		}

		// xml
//		if (GlobalEnv.isOpt()) {
//			htmlEnv2.code.append("<tfe type=\"connect\" dimension =\"1\"");
//			if (decos.containsKey("tablealign"))
//				htmlEnv2.code.append(" align=\"" + decos.getStr("tablealign")
//						+ "\"");
//			if (decos.containsKey("tablevalign"))
//				htmlEnv2.code.append(" valign=\"" + decos.getStr("tablevalign")
//						+ "\"");
//			if (decos.containsKey("tabletype")) {
//				htmlEnv2.code.append(" tabletype=\""
//						+ decos.getStr("tabletype") + "\"");
//				if (decos.containsKey("cellspacing")) {
//					htmlEnv2.code.append(" cellspacing=\""
//							+ decos.getStr("cellspacing") + "\"");
//				}
//				if (decos.containsKey("cellpadding")) {
//					htmlEnv2.code.append(" cellpadding=\""
//							+ decos.getStr("cellpadding") + "\"");
//				}
//				if (decos.containsKey("border")) {
//					htmlEnv2.code.append(" border=\""
//							+ decos.getStr("border").replace("\"", "") + "\"");
//				}
//				if (decos.containsKey("tableborder")) {
//					htmlEnv2.code.append(" tableborder=\""
//							+ decos.getStr("tableborder").replace("\"", "")
//							+ "\"");
//				}
//			} else {
//				if (decos.containsKey("border")) {
//					htmlEnv2.code.append(" border=\""
//							+ decos.getStr("border").replace("\"", "") + "\"");
//				} else {
//					htmlEnv2.code.append(" border=\""
//							+ htmlEnv.tableBorder.replace("\"", "") + "\"");
//				}
//				if (decos.containsKey("tableborder")) {
//					htmlEnv2.code.append(" tableborder=\""
//							+ decos.getStr("tableborder").replace("\"", "")
//							+ "\"");
//				}
//			}
//			if (htmlEnv.writtenClassId.contains(HTMLEnv.getClassID(this))) {
//				htmlEnv2.code.append(" class=\"");
//				htmlEnv2.code.append(HTMLEnv.getClassID(this));
//			}
//			if (decos.containsKey("class")) {
//				if (!htmlEnv.writtenClassId.contains(HTMLEnv.getClassID(this))) {
//					htmlEnv2.code.append(" class=\"");
//				} else {
//					htmlEnv2.code.append(" ");
//				}
//				htmlEnv2.code.append(decos.getStr("class") + "\" ");
//			} else if (htmlEnv.writtenClassId
//					.contains(HTMLEnv.getClassID(this))) {
//				htmlEnv2.code.append("\" ");
//			}
//
//			if (decos.containsKey("form")) {
//				htmlEnv2.code.append(" form=\"" + HTMLEnv.getFormNumber()
//						+ "\" ");
//			}
//			htmlEnv2.code.append(">");
//		}

		// tk
		// end////////////////////////////////////////////////////////////////////

		// Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\"><TR>");
		int i = 0;

		if (decos.containsKey("form")) {
			htmlEnv.code.append(HTMLFunction.createForm(decos));
			HTMLEnv.setFormItemFlg(true, null);
		}

		while (this.hasMoreItems()) {
			ITFE tfe = tfes.get(i);
			String classid = HTMLEnv.getClassID(tfe);

			htmlEnv.decorationStartFlag.set(0, true);
			
			this.worknextItem();

			htmlEnv.decorationEndFlag.set(0, true);

			i++;
		}

//		htmlEnv2.code.append("</tfe>");
//		if (decos.containsKey("form")) {
//			htmlEnv2.code.append("<form" + HTMLEnv.getFormNumber() + "end />");
//			Log.out("<form" + HTMLEnv.getFormNumber() + "end />");
//			htmlEnv.code.append(HTMLEnv.exFormNameCreate());
//			htmlEnv.code.append("</form>");
//			HTMLEnv.setFormItemFlg(false, null);
//			HTMLEnv.incrementFormNumber();
//			if (decos.getStr("form").toLowerCase().equals("search"))
//				HTMLEnv.setSearch(false);
//		}
//		htmlEnv.code.append("</TR></TABLE>\n");
		
		if (htmlEnv.decorationStartFlag.size() > 1) {
			ends.get(1).append(fronts.get(0));
			if (!styles.get(0).equals("")) {
				ends.get(1).append(" style=\"");
				ends.get(1).append(styles.get(0));
				ends.get(1).append("\"");
			}
			ends.get(1).append(classes.get(0));
			ends.get(1).append(ends.get(0));
		} else {
			htmlEnv.code.append(fronts.get(0));
			if (!styles.get(0).equals("")) {
				htmlEnv.code.append(" style=\"");
				htmlEnv.code.append(styles.get(0));
				htmlEnv.code.append("\"");
			}
			htmlEnv.code.append(classes.get(0));
			htmlEnv.code.append(ends.get(0));
		}
		
		fronts.remove(0);
		classes.remove(0);
		styles.remove(0);
		ends.remove(0);
		htmlEnv.decorationProperty.remove(0);
		htmlEnv.decorationStartFlag.remove(0);
		htmlEnv.decorationEndFlag.remove(0);
		
		Log.out("+++++++ Decoration +++++++");
		return null;
	}

}
