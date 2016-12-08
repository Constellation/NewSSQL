package supersql.codegenerator.VR;

import org.stringtemplate.v4.compiler.STParser.ifstat_return;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class VRG2 extends Grouper {

	private VREnv html_env;
	private VREnv html_env2;
	boolean retFlag = false;	// 20140611_masato pagenationフラグ
	boolean pageFlag = false;	// 20140611_masato pagenationフラグ
//	int counter = 0;
	
	// ���󥹥ȥ饯��
	public VRG2(Manager manager, VREnv henv, VREnv henv2) {
		this.html_env = henv;
		this.html_env2 = henv2;

	}

	@Override
	public String getSymbol() {
		return "HTMLG2";
	}

	// G2��work�᥽�å�
	@Override
	public String work(ExtList data_info) {

		Log.out("------- G2 -------");
		this.setDataList(data_info);
		if (VREnv.getSelectFlg())
			data_info = (ExtList) data_info.get(0);

		// tk start////////////////////////////////////////////////////
		html_env.append_css_def_td(VREnv.getClassID(this), this.decos);

		boolean flag = false; 	// 20140528_masato
		int count = 0;			// 20140526_masato
		int count2 = 0;			// 20140611_masato
		int i = 0;				// 20140526_masato
		int j = 0;				// 20140611_masato
		
		
		if(decos.containsKey("row") && decos.containsKey("column")){ //20160918 kotani
//			html_env.code.append("<div id=\"res\"></div>\n" + 
//					"<div id=\"Pagination\" class=\"pagination\"></div>\n" + 
//			        "<!-- Container element for all the Elements that are to be paginated -->\n" + 
//			        "<div id=\"hiddenresult\" style=\"display:none;\">\n" + 
//			        "<div class=\"result\">\n");
		}
		
		// 20140528_masato
//		if(decos.containsKey("row")){
//			retFlag = true;
//			i = Integer.parseInt(decos.getStr("row"));
//			html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
//			html_env.code.append(html_env.tableBorder + "\" ");
//			html_env.code.append("class=\"");
//			html_env.code.append("nest\"");
//			html_env.code.append(html_env.getOutlineMode());
//			html_env.code.append(">");
//			html_env.code.append("<TR><TD class=\""	+ VREnv.getClassID(tfe) + " nest\">\n");
//		}
		
		if(decos.containsKey("row") && decos.containsKey("column")){
			retFlag = false;
			pageFlag = true;
			i = Integer.parseInt(decos.getStr("row"));
			j = Integer.parseInt(decos.getStr("column"));
		}
		
		// 20140613_masato && j != 1を追加　→　[tfe]!3%とかのとき
	/*	if (!GlobalEnv.isOpt()) {
			html_env.code
					.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
			html_env.code.append(html_env.tableBorder + "\" ");
			Log.out("embed flag :" + html_env.embedFlag);
			html_env.code.append("class=\"");
			if (html_env.embedFlag)
				html_env.code.append(" embed ");

			if (decos.containsKey("outborder"))
				html_env.code.append(" noborder ");

			if (decos.containsKey("class")) {
				// class=menu�Ȃǂ̎w�肪��������t��
				html_env.code.append(decos.getStr("class") + " ");
			}
			if (html_env.writtenClassId.contains(VREnv.getClassID(this))) {
				// TFE10000�Ȃǂ̎w�肪��������t��
				// TODO 20140619_masato bgcolorとか
				html_env.code.append(VREnv.getClassID(this) + " ");
			}
			html_env.code.append("nest\"");

			html_env.code.append(html_env.getOutlineMode());

			html_env.code.append(">");
		}*/
		// tk end/////////////////////////////////////////////////////
		
		Log.out("<TABLE class=\"" + VREnv.getClassID(this) + "\">");
		
		//html_env.code.append("a="+html_env.gLevel);
		if(html_env.gLevel == 0){
			//VRAttribute.floorflag = 2;
			VRAttribute.floorarray.add(2);
		}
		if(html_env.gLevel == 1){
			//VRAttribute.exhflag = true;
			VRAttribute.exharray.add(2);////////G2の時はまだ使ってない
			//System.out.println("yeahhhhhh2");
		}
		
		//System.out.println("<G2front>");
		VRAttribute.gjudge++;
		
		while (this.hasMoreItems()) {
			//html_env.code.append("b="+html_env.gLevel);
			VRAttribute.genre = "";
			
			// 20140528_masato
			count++;
			VRAttribute.seq = 0;///n2 kotani
			
			html_env.gLevel++;
			Log.out("selectFlg" + VREnv.getSelectFlg());
			Log.out("selectRepeatFlg" + VREnv.getSelectRepeat());
			Log.out("formItemFlg" + VREnv.getFormItemFlg());
			//html_env.code.append("c="+html_env.gLevel);
			//html_env.code.append(html_env.gLevel);
			
			if (VREnv.getSelectRepeat()) {// if form_select
				// null
				// in case "select" repeat : not write "<TR><TD>" between
				// "<option>"s
			} else {
				// 20140613_masato
//				if(i != 0 && counter % i != 0 && j != 1){
//					
//				} else {
//					html_env.code.append("<TR><TD class=\""
//							+ VREnv.getClassID(tfe) + " nest\">\n");
//					Log.out("<TR><TD class=\"" + VREnv.getClassID(tfe)
//							+ " nest\">");
//				}
				
//				counter++;
			}
			String classid = VREnv.getClassID(tfe);

			if (GlobalEnv.isOpt() && !VREnv.getSelectRepeat()) {
				html_env2.code.append("<tfe type=\"repeat\" dimension=\"2\"");
				html_env2.code.append(" border=\"" + html_env.tableBorder
						+ "\"");

				if (decos.containsKey("tablealign"))
					html_env2.code.append(" align=\""
							+ decos.getStr("tablealign") + "\"");
				if (decos.containsKey("tablevalign"))
					html_env2.code.append(" valign=\""
							+ decos.getStr("tablevalign") + "\"");

				if (decos.containsKey("class")) {
					// class=menu�Ȃǂ̎w�肪��������t��
					html_env2.code.append(" class=\"");
					html_env2.code.append(decos.getStr("class") + " ");
				}
				if (html_env.writtenClassId.contains(VREnv.getClassID(this))) {
					// TFE10000�Ȃǂ̎w�肪��������t��
					if (decos.containsKey("class")) {
						html_env2.code.append(VREnv.getClassID(this) + "\"");
					} else {
						html_env2.code.append(" class=\""
								+ VREnv.getClassID(this) + "\"");
					}
				} else if (decos.containsKey("class")) {
					html_env2.code.append("\"");
				}

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

			this.worknextItem();

			if (html_env.notWrittenClassId.contains(classid)
					&& html_env.code.indexOf(classid) >= 0) {
				html_env.code.delete(html_env.code.indexOf(classid),
						html_env.code.indexOf(classid) + classid.length() + 1);
			}

			if (VREnv.getSelectRepeat()) {

			} else {
				// chie
				html_env2.code.append("</tfe>");
//				if(i != 0 && counter % i != 0 && j != 1){
//					
//				} else {
//					html_env.code.append("</TD>\n");////</TR>消した
//					Log.out("</TD>");////</TR>消した
//				}
			}
			
			// 20140528_masato
//			if(retFlag){
//				if(i != 0){
//					if(count % i == 0){
//						html_env.code.append("</TABLE></TD>");
//						if(!this.hasMoreItems()){
//							flag = true;
//							html_env.code.append("</TR>");
//						} else {
//							html_env.code.append("<TD>\n");
//							html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
//							html_env.code.append(html_env.tableBorder + "\" ");
//							html_env.code.append("class=\"");
//							html_env.code.append("nest\"");
//							html_env.code.append(html_env.getOutlineMode());
//							html_env.code.append(">");		
//						}
//					}
//				}
//			}
			
//			if(pageFlag){
//				if(count % i == 0){
//					count2++;
 //					if(counter % i != 0 && j != 1){
//						
//					} else {
//						html_env.code.append("</TABLE></TD>");
//					}
//					if(!this.hasMoreItems()){
//						flag = true;
//						html_env.code.append("</TR>");
//					}
//					if(count2 % j == 0 && this.hasMoreItems()){
//						
//						html_env.code.append("</TR></TABLE>");
//						html_env.code.append("</div>\n");
//						html_env.code.append("<div class=\"result\">\n");
//						html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
//						html_env.code.append(html_env.tableBorder + "\" ");
//						html_env.code.append("class=\"");
//						html_env.code.append("nest\"");
//						html_env.code.append(">");
//						html_env.code.append("<TR><TD class=\""	+ VREnv.getClassID(tfe) + " nest\">\n");
//						// 20140613_masato
//						if(counter % i != 0 && j != 1){
//							
//						} else {
//							html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
//							html_env.code.append(html_env.tableBorder + "\" ");
//							html_env.code.append("class=\"");
//							html_env.code.append("nest\"");
//							html_env.code.append(html_env.getOutlineMode());
//							html_env.code.append(">");
//						}
//					} else {
//						html_env.code.append("<TD>\n");
//						html_env.code.append("<TABLE cellSpacing=\"0\" cellPadding=\"0\" border=\"");
//						html_env.code.append(html_env.tableBorder + "\" ");
//						html_env.code.append("class=\"");
//						html_env.code.append("nest\"");
//						html_env.code.append(html_env.getOutlineMode());	
//						html_env.code.append(">");
//					}
//				}
//			}
			
			html_env.gLevel--;

		}
		
		for(int l=0; l<VRAttribute.elearray.size();l++){///n2 kotani
			//System.out.println("keio= "+" " +l+" " + VRAttribute.elearray.get(l));
			html_env.code.append("<n2 seq=\""+l+"\">\n" );
			//System.out.println("yoo="+VRAttribute.elearray.get(l));
			html_env.code.append(VRAttribute.elearray.get(l));
			html_env.code.append("</n2>\n" );			
		}
		VRAttribute.elearray.clear();//初期化
		VRAttribute.seq = 0;//初期化

		if(VRAttribute.gjudge==1){
			VRAttribute.billnum++;
		}
		VRAttribute.gjudge--;
		//System.out.println("</G2back>");

		if (VREnv.getSelectRepeat()) {
			if (VREnv.getSelectRepeat()) {
				// chie
//				html_env2.code.append("</select></VALUE></tfe>");
//				html_env.code.append("</select></TD>\n");////</TR>消した
//				Log.out("</TD>");////</TR>消した
				VREnv.setSelectRepeat(false);
				VREnv.incrementFormPartsNumber();
			} else {
				VREnv.incrementFormPartsNumber();
			}
		}

		// html_env2.code.append("</tfe>");
		// 20140528_masato
//		if(flag){
//			html_env.code.append("</TABLE>\n");
//		}
//		html_env.code.append("</TR></TABLE>\n");
//		Log.out("</TABLE>");

		if(html_env.gLevel == 0){
			//VRAttribute.gjoinflag = 2;
			html_env.code.append("</group>\n");
			VRAttribute.grouptag++;
				html_env.code.append("<group>\n");
			VRAttribute.genrearray22.add(VRAttribute.genrecount);
//			new VRManager(html_env, html_env2).xmlcreate();
//			VRManager.i++;
			
		}
		
		
		Log.out("TFEId = " + VREnv.getClassID(this));
		
		// html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
		return null;

	
	}
		

}
