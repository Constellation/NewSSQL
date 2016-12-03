package supersql.codegenerator.VR;

import org.stringtemplate.v4.compiler.STParser.ifstat_return;

import com.ibm.db2.jcc.am.t;

import supersql.codegenerator.Connector;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class VRC2 extends Connector {

	private VREnv htmlEnv;
	private VREnv htmlEnv2;

	// 鐃緒申鐃藷ストラク鐃緒申
	public VRC2(Manager manager, VREnv henv, VREnv henv2) {
		this.htmlEnv = henv;
		this.htmlEnv2 = henv2;
	}

	@Override
	public String getSymbol() {
		return "HTMLC2";
	}

	// C2鐃緒申work鐃潤ソ鐃獣ワ申
	@Override
	public String work(ExtList data_info) {
		Log.out("------- C2 -------");
		Log.out("tfes.contain_itemnum=" + tfes.contain_itemnum());
		Log.out("tfessize=" + tfes.size());
		Log.out("countconnetitem=" + countconnectitem());

		this.setDataList(data_info);

		if (decos.containsKey("form")) {
			htmlEnv2.code
					.append("<form" + VREnv.getFormNumber() + "start />");
			if (decos.getStr("form").toLowerCase().equals("search")) {
				VREnv.setSearch(true);
			}
		}

		if (decos.containsKey("insert")) {
			VREnv.setIDU("insert");
		}
		if (decos.containsKey("update")) {
			VREnv.setIDU("update");
		}
		if (decos.containsKey("delete")) {
			VREnv.setIDU("delete");
		}

		// tk
		// start////////////////////////////////////////////////////////////////
		htmlEnv.append_css_def_td(VREnv.getClassID(this), this.decos);

//		if (!GlobalEnv.isOpt()) {
////			htmlEnv.code
////					.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
//			htmlEnv.code.append(htmlEnv.tableBorder + "\" ");
//			htmlEnv.code.append(htmlEnv.getOutlineMode());
//			if (htmlEnv.writtenClassId.contains(VREnv.getClassID(this))) {
//				htmlEnv.code.append(" class=\"");
//				htmlEnv.code.append(VREnv.getClassID(this));
//			}
//
//			if (decos.containsKey("class")) {
//				if (!htmlEnv.writtenClassId.contains(VREnv.getClassID(this))) {
//					htmlEnv.code.append(" class=\"");
//				} else {
//					htmlEnv.code.append(" ");
//				}
//				htmlEnv.code.append(decos.getStr("class") + "\" ");
//			} else if (htmlEnv.writtenClassId
//					.contains(VREnv.getClassID(this))) {
//				htmlEnv.code.append("\" ");
//			}
//			htmlEnv.code.append(">");
//		}
		if (GlobalEnv.isOpt()) {
			htmlEnv2.code.append("<tfe type=\"connect\" dimension=\"2\"");
			if (decos.containsKey("tablealign"))
				htmlEnv2.code.append(" align=\"" + decos.getStr("tablealign")
						+ "\"");
			if (decos.containsKey("tablevalign"))
				htmlEnv2.code.append(" valign=\"" + decos.getStr("tablevalign")
						+ "\"");
			if (decos.containsKey("height"))
				htmlEnv2.code.append(" height=\"" + decos.getStr("height")
						+ "\"");
			if (decos.containsKey("tabletype")) {
				htmlEnv2.code.append(" tabletype=\""
						+ decos.getStr("tabletype") + "\"");
				if (decos.containsKey("cellspacing")) {
					htmlEnv2.code.append(" cellspacing=\""
							+ decos.getStr("cellspacing") + "\"");
				}
				if (decos.containsKey("cellpadding")) {
					htmlEnv2.code.append(" cellpadding=\""
							+ decos.getStr("cellpadding") + "\"");
				}
				if (decos.containsKey("border")) {
					htmlEnv2.code.append(" border=\""
							+ decos.getStr("border").replace("\"", "") + "\"");
				}

				if (decos.containsKey("tableborder")) {
					htmlEnv2.code.append(" tableborder=\""
							+ decos.getStr("tableborder").replace("\"", "")
							+ "\"");
				}
			} else {
				if (decos.containsKey("border")) {
					htmlEnv2.code.append(" border=\""
							+ decos.getStr("border").replace("\"", "") + "\"");
				} else {
					htmlEnv2.code.append(" border=\""
							+ htmlEnv.tableBorder.replace("\"", "") + "\"");
				}
				if (decos.containsKey("tableborder")) {
					htmlEnv2.code.append(" tableborder=\""
							+ decos.getStr("tableborder").replace("\"", "")
							+ "\"");
				}
			}
			if (htmlEnv.writtenClassId.contains(VREnv.getClassID(this))) {
				htmlEnv2.code.append(" class=\"");
				htmlEnv2.code.append(VREnv.getClassID(this));
			}

			if (decos.containsKey("class")) {
				if (!htmlEnv.writtenClassId.contains(VREnv.getClassID(this))) {
					htmlEnv2.code.append(" class=\"");
				} else {
					htmlEnv2.code.append(" ");
				}
				htmlEnv2.code.append(decos.getStr("class"));
			} else if (htmlEnv.writtenClassId
					.contains(VREnv.getClassID(this))) {
				htmlEnv2.code.append("\" ");
			}

			if (decos.containsKey("form")) {
				htmlEnv2.code.append(" form=\"" + VREnv.getFormNumber()
						+ "\" ");
			}

			htmlEnv2.code.append(">");
		}
		/*
		 * if(decos.containsKey("outborder"))
		 * html_env.code.append(" noborder ");
		 */

		// html_env2.code.append(">");

		// System.out.println(html_env.code);

		// tk
		// end//////////////////////////////////////////////////////////////////

		// Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\">");

		int i = 0;

		if (decos.containsKey("form")) {
			htmlEnv.code.append(VRFunction.createForm(decos));
			VREnv.setFormItemFlg(true, null);
		}

		//System.out.println("<C2front>");
		while (this.hasMoreItems()) {
			
			if(htmlEnv.gLevel == 1){//////// kotani 16/10/04
				 
			}
			ITFE tfe = tfes.get(i);
			if(VRAttribute.genre.equals("")){//////////////////////////////////////////////////////////// kotani 16/10/04
				if(htmlEnv.gLevel == 0){
					//htmlEnv.code.append(VREnv.getClassID(tfe));
					if(VRAttribute.groupcount >= 1){
						//htmlEnv.code.append("<group2>\n");
					}
					VRAttribute.groupcount++;
					//System.out.println("groupcount2");
				}else{
	//				htmlEnv.code.append("<TD class=\"" + VREnv.getClassID(tfe) + " nest\">\n");
					htmlEnv.code.append("<category" + VREnv.getClassID(tfe) + " > \n");
				}
			}else{
				//htmlEnv.code.append("<TD class=\"" + VREnv.getClassID(tfe) + " nest\" name = \"" +VRAttribute.genre+ "\"> \n");
				htmlEnv.code.append("<category " + VREnv.getClassID(tfe) + " name = \"" +VRAttribute.genre+ "\"> \n");
//				VRAttribute.genrearray2.add("\"" + VRAttribute.genre + "\"");
//				if(VRAttribute.genrecount == 0){
//					VRAttribute.genrearray22.add(0);
//				}
//				VRAttribute.genrecount++;
				//System.out.println(VRAttribute.genrecount);
			}
			String classid = VREnv.getClassID(tfe);
			// Log.out("<TR><TD class=\"nest "
			// + HTMLEnv.getClassID(tfe) + " nest\"> decos:" + decos);

			this.worknextItem();

//			if (htmlEnv.notWrittenClassId.contains(classid)) {
//				htmlEnv.code.delete(htmlEnv.code.indexOf(classid),
//						htmlEnv.code.indexOf(classid) + classid.length() + 1);
//			}

			//htmlEnv.code.append("</TD>\n");////</TR>消した
			Log.out("</TD>");////</TR>消した

			i++;

		}

		if(VRAttribute.gjudge == 0){
			if(VRAttribute.billnum >= 2){
				for(int k=0;k<VRAttribute.billnum-1;k++){
					//VRAttribute.cjoinarray.add("C2");
				}
				VRAttribute.billnum = 0;
			}else{
				//VRAttribute.cjoinarray.add("C2");
			}
		}
		//System.out.println("</C2back>");
		
		htmlEnv2.code.append("</tfe>");
		// Log.out("</TABLE>");
		if (decos.containsKey("form")) {
			htmlEnv2.code.append("<form" + VREnv.getFormNumber() + "end />");
			htmlEnv.code.append(VREnv.exFormNameCreate());
			htmlEnv.code.append("</form>");
			VREnv.setFormItemFlg(false, null);
			VREnv.incrementFormNumber();
			if (decos.getStr("form").toLowerCase().equals("search"))
				VREnv.setSearch(false);
		}

//////////////ここら辺のcategory正直使ってない
//		htmlEnv.code.append("</category>\n"); //htmlEnv.code.append("</TABLE>\n")から変更
//		htmlEnv.code.append("</category>\n");//20160919 kotani add
		
		
//		if(!VRAttribute.gjudge){
////		System.out.println("c2_level="+htmlEnv.gLevel2);
//		//if(htmlEnv.gLevel2 == 0){
//			//VRAttribute.cjoinflag = 2;
//			VRAttribute.cjoinarray.add("C2");
//		//}
//		}

		Log.out("TFEId = " + VREnv.getClassID(this));
		// html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
		return null;

	}

}
