package supersql.codegenerator.VR;

import supersql.codegenerator.Connector;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class VRC3 extends Connector {

	private VREnv VREnv;
	private VREnv VREnv2;

	// ・ウ・�ケ・ネ・鬣ッ・ソ
	public VRC3(Manager manager, VREnv henv, VREnv henv2) {
		this.VREnv = henv;
		this.VREnv2 = henv2;
	}

	@Override
	public String getSymbol() {
		return "HTMLC3";
	}

	// C3、ホwork・皈ス・テ・ノ
	@Override
	public String work(ExtList data_info) {
		
		String parentfile = VREnv.fileName;
//		String parentfile2 = VREnv2.fileName;
		StringBuffer parentcode = new StringBuffer();
		StringBuffer parentcss = new StringBuffer();
		StringBuffer parentheader = new StringBuffer();
		StringBuffer parentfooter = new StringBuffer();
/*		
		new String();
		ITFE[] tfe = new ITFE[tfeItems];
		int c3items = tfeItems;
		for (int j = 0; j < tfeItems - 1; j++) {
			tfe[j] = tfes.get(j);
			if (j < tfeItems - 2 && tfe[j] instanceof VRG3) {
				Log.err("Error: % after []% is not allowed");
				GlobalEnv.addErr("Error: % after []% is not allowed");
			}
		}
		Log.out("------- C3 -------");
		VREnv.countFile++;
		
		String foreachID = String.valueOf(VREnv.countFile);
		
		VREnv.linkFlag++;
		Log.out("linkflag =" + VREnv.linkFlag);
		Log.out("c3items = " + c3items);
		this.setDataList(data_info);

		this.worknextItem();
		VREnv.linkFlag--;
		
		for (int k = 1; k < c3items; k++) {
			ITFE intfe = tfes.get(k);
			if (intfe instanceof VRG3) {
				VREnv.countFile--;
				this.worknextItem();
			} else {
				parentcode = VREnv.code;
				parentcss = VREnv.css;
				parentheader = VREnv.header;
				parentfooter = VREnv.footer;
				VREnv.code = new StringBuffer();
				VREnv.header = new StringBuffer();
				VREnv.footer = new StringBuffer();

				if (k < c3items - 1) {
					VREnv.countFile++;
					VREnv.linkUrl = VREnv.linkOutFile
							+ String.valueOf(VREnv.countFile) + ".html";
					VREnv.linkFlag++;
					Log.out("linkflag =" + VREnv.linkFlag);
				}

				VREnv.setOutlineMode();
				this.worknextItem();
				

				if (k < c3items - 1) {
					VREnv.linkFlag--;
				}
				
				VREnv.code = parentcode;
				VREnv.css = parentcss;
				VREnv.header = parentheader;
				VREnv.footer = parentfooter;
			}
		}
		VREnv.fileName = parentfile;*/
		
		////////C2から

		this.setDataList(data_info);

		if (decos.containsKey("form")) {
			VREnv2.code
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
		VREnv.append_css_def_td(VREnv.getClassID(this), this.decos);
		
		
		
		
		int i = 0;

		if (decos.containsKey("form")) {
			VREnv.code.append(VRFunction.createForm(decos));
			VREnv.setFormItemFlg(true, null);
		}
		
		//System.out.println("<C3front>");

		while (this.hasMoreItems()) {
			if(VREnv.gLevel == 1){//////// kotani 16/10/04
				 
			}
			ITFE tfe = tfes.get(i);//////////////ここら辺のcategory正直使ってない
			if(VRAttribute.genre.equals("")){//////////////////////////////////////////////////////////// kotani 16/10/04
				if(VREnv.gLevel == 0){
					//VREnv.code.append(VREnv.getClassID(tfe));
					if(VRAttribute.groupcount >= 1){
						//VREnv.code.append("<group3>\n");
					}
					VRAttribute.groupcount++;
					//System.out.println("groupcount3");
				}else{
	//				VREnv.code.append("<TD class=\"" + VREnv.getClassID(tfe) + " nest\">\n");
					VREnv.code.append("<category" + VREnv.getClassID(tfe) + " > \n");
				}
			}else{
				//VREnv.code.append("<TD class=\"" + VREnv.getClassID(tfe) + " nest\" name = \"" +VRAttribute.genre+ "\"> \n");
				VREnv.code.append("<category " + VREnv.getClassID(tfe) + " name = \"" +VRAttribute.genre+ "\"> \n");

			}
			String classid = VREnv.getClassID(tfe);

			this.worknextItem();

			Log.out("</TD>");////</TR>消した

			i++;

		}
		
		if(VRAttribute.gjudge == 0){
			if(VRAttribute.billnum >= 2){
				for(int k=0;k<VRAttribute.billnum-1;k++){
					//VRAttribute.cjoinarray.add("C3");
				}
				VRAttribute.billnum = 0;
			}else{
				//VRAttribute.cjoinarray.add("C3");
			}
		}
		//System.out.println("</C3back>");
		
//		if(!VRAttribute.gjudge){
////		System.out.println("c3_level="+VREnv.gLevel2);
////		if(VREnv.gLevel2 == 0){
//			//VRAttribute.cjoinflag = 2;
//			VRAttribute.cjoinarray.add("C3");
//		//}
//		}
		
		Log.out("TFEId = " + VREnv.getClassID(this));
		VREnv.append_css_def_td(VREnv.getClassID(this), this.decos);
		return null;

	}

}
