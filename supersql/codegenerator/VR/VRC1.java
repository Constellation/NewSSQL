package supersql.codegenerator.VR;

import org.stringtemplate.v4.compiler.STParser.ifstat_return;

import supersql.codegenerator.Connector;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

//tk

public class VRC1 extends Connector {

	private VREnv unityEnv;
	private VREnv unityEnv2;

	// ���󥹥ȥ饯��
	public VRC1(Manager manager, VREnv henv, VREnv henv2) {
		this.unityEnv = henv;
		this.unityEnv2 = henv2;
	}

	@Override
	public String getSymbol() {
		return "HTMLC1";
	}

	// C1��work�᥽�å�
	@Override
	public String work(ExtList data_info) {
//		System.out.println("c1_level="+htmlEnv.gLevel);
//		if(htmlEnv.gLevel == 0){
//			//VRAttribute.cjoinflag = 1;
//			VRAttribute.cjoinarray.add("C1");
//			Log.info("C1");
//		}



		Log.out("------- C1 -------");
		Log.out("tfes.contain_itemnum=" + tfes.contain_itemnum());
		Log.out("tfes.size=" + tfes.size());
		Log.out("countconnetitem=" + countconnectitem());
		this.setDataList(data_info);

		if (decos.containsKey("form")) {
			unityEnv2.code
					.append("<form" + VREnv.getFormNumber() + "start />");
			if (decos.getStr("form").toLowerCase().equals("search"))
				VREnv.setSearch(true);
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
		// start///////////////////////////////////////////////////////////////////////
		unityEnv.append_css_def_td(VREnv.getClassID(this), this.decos);

//		if (!GlobalEnv.isOpt()) {
////			htmlEnv.code
////					.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
////		htmlEnv.code.append(htmlEnv.tableBorder + "\"");
////			htmlEnv.code.append(htmlEnv.getOutlineMode());
//			/*
//			 * if(decos.containsKey("outborder")){
//			 * html_env.code.append(" noborder ");
//			 * html_env2.code.append(" noborder "); }
//			 */
//			// classid������Ȥ��ˤ�������
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
//			htmlEnv.code.append("><TR>");
//		}

		// xml
		if (GlobalEnv.isOpt()) {
			unityEnv2.code.append("<tfe type=\"connect\" dimension =\"1\"");
			if (decos.containsKey("tablealign"))
				unityEnv2.code.append(" align=\"" + decos.getStr("tablealign")
						+ "\"");
			if (decos.containsKey("tablevalign"))
				unityEnv2.code.append(" valign=\"" + decos.getStr("tablevalign")
						+ "\"");
			if (decos.containsKey("tabletype")) {
				unityEnv2.code.append(" tabletype=\""
						+ decos.getStr("tabletype") + "\"");
				if (decos.containsKey("cellspacing")) {
					unityEnv2.code.append(" cellspacing=\""
							+ decos.getStr("cellspacing") + "\"");
				}
				if (decos.containsKey("cellpadding")) {
					unityEnv2.code.append(" cellpadding=\""
							+ decos.getStr("cellpadding") + "\"");
				}
				if (decos.containsKey("border")) {
					unityEnv2.code.append(" border=\""
							+ decos.getStr("border").replace("\"", "") + "\"");
				}
				if (decos.containsKey("tableborder")) {
					unityEnv2.code.append(" tableborder=\""
							+ decos.getStr("tableborder").replace("\"", "")
							+ "\"");
				}
			} else {
				if (decos.containsKey("border")) {
					unityEnv2.code.append(" border=\""
							+ decos.getStr("border").replace("\"", "") + "\"");
				} else {
					unityEnv2.code.append(" border=\""
							+ unityEnv.tableBorder.replace("\"", "") + "\"");
				}
				if (decos.containsKey("tableborder")) {
					unityEnv2.code.append(" tableborder=\""
							+ decos.getStr("tableborder").replace("\"", "")
							+ "\"");
				}
			}
			if (unityEnv.writtenClassId.contains(VREnv.getClassID(this))) {
				unityEnv2.code.append(" class=\"");
				unityEnv2.code.append(VREnv.getClassID(this));
			}
			if (decos.containsKey("class")) {
				if (!unityEnv.writtenClassId.contains(VREnv.getClassID(this))) {
					unityEnv2.code.append(" class=\"");
				} else {
					unityEnv2.code.append(" ");
				}
				unityEnv2.code.append(decos.getStr("class") + "\" ");
			} else if (unityEnv.writtenClassId
					.contains(VREnv.getClassID(this))) {
				unityEnv2.code.append("\" ");
			}

			if (decos.containsKey("form")) {
				unityEnv2.code.append(" form=\"" + VREnv.getFormNumber()
						+ "\" ");
			}
			unityEnv2.code.append(">");
		}

		// tk
		// end////////////////////////////////////////////////////////////////////

		// Log.out("<TABLE class=\""+HTMLEnv.getClassID(this) + "\"><TR>");
		int i = 0;

		if (decos.containsKey("form")) {
			unityEnv.code.append(VRFunction.createForm(decos));
			VREnv.setFormItemFlg(true, null);
		}
		
		while (this.hasMoreItems()) {
			//System.out.println("html_env.gLevel2="+htmlEnv.gLevel2);
			if(unityEnv.gLevel == 1){//////// kotani 16/10/04

			}
			ITFE tfe = tfes.get(i);
			if(VRAttribute.genre.equals("")){//////////////////////////////////////////////////////////// kotani 16/10/04
				if(unityEnv.gLevel == 0){
					//htmlEnv.code.append(VREnv.getClassID(tfe));
					if(VRAttribute.groupcount >= 1){
						//htmlEnv.code.append("<group1>\n");
					}
					VRAttribute.groupcount++;
					//System.out.println(VRAttribute.groupcount);
					//System.out.println("groupcount1");
				}else{
	//				htmlEnv.code.append("<TD class=\"" + VREnv.getClassID(tfe) + " nest\">\n");
					if(unityEnv.gLevel < 2){
						unityEnv.code.append("<category" + VREnv.getClassID(tfe) + " > \n");
					}
				}
			}else{
				//htmlEnv.code.append("<TD class=\"" + VREnv.getClassID(tfe) + " nest\" name = \"" +VRAttribute.genre+ "\"> \n");
				unityEnv.code.append("<category " + VREnv.getClassID(tfe) + " name = \"" +VRAttribute.genre+ "\"> \n");
				VRAttribute.genrearray2.add("\"" + VRAttribute.genre + "\"");
				if(VRAttribute.genrecount == 0){
					VRAttribute.genrearray22.add(0);
				}
				VRAttribute.genrecount++;
				//System.out.println(VRAttribute.genrecount);
			}
			String classid = VREnv.getClassID(tfe);

			// Log.out("<TD class=\""
			// + HTMLEnv.getClassID(tfe) + " nest\"> decos : " + decos);
			this.worknextItem();

//			Log.info("test:"+htmlEnv.code+":kotani:"+htmlEnv.code.indexOf(classid));
//			Log.info(classid);
			if (unityEnv.notWrittenClassId.contains(classid)) {
				if(unityEnv.code.indexOf(classid)>=0){
					unityEnv.code.delete(unityEnv.code.indexOf(classid),unityEnv.code.indexOf(classid) + classid.length() + 1);
				}
			}

			i++;
		}

		if(VRAttribute.gjudge == 0){
			if(VRAttribute.billnum >= 2){
				for(int k=0;k<VRAttribute.billnum-1;k++){
					//VRAttribute.cjoinarray.add("C1");
				}
				VRAttribute.billnum = 0;
			}else{
				//VRAttribute.cjoinarray.add("C1");
			}
		}

		


		unityEnv2.code.append("</tfe>");
		if (decos.containsKey("form")) {
			unityEnv2.code.append("<form" + VREnv.getFormNumber() + "end />");
			Log.out("<form" + VREnv.getFormNumber() + "end />");
			unityEnv.code.append(VREnv.exFormNameCreate());
			unityEnv.code.append("</form>");
			VREnv.setFormItemFlg(false, null);
			VREnv.incrementFormNumber();
			if (decos.getStr("form").toLowerCase().equals("search"))
				VREnv.setSearch(false);
		}

		if(unityEnv.gLevel == 1){
			unityEnv.code.append("</category>\n"); //htmlEnv.code.append("</TABLE>\n")から変更
			unityEnv.code.append("</category>\n");//20160919 kotani add
		}



////		System.out.println("gjudge="+VRAttribute.gjudge);
////		if(!VRAttribute.gjudge){
//		//System.out.println("c1_level="+htmlEnv.gLevel2);
//		if(htmlEnv.gLevel2 == 0){
//			//VRAttribute.cjoinflag = 1;
//			VRAttribute.cjoinarray.add("C1");
//		//}
//		}


		// Log.out("TFEId = " + HTMLEnv.getClassID(this));
		// html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
		return null;
	}

}
