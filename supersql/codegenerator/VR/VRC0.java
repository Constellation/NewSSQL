package supersql.codegenerator.VR;

import supersql.codegenerator.Connector;
import supersql.codegenerator.Manager;
import supersql.extendclass.ExtList;

//import common.Log;

public class VRC0 extends Connector {
	private VREnv htmlEnv;
	private VREnv htmlEnv2;

	// 鐃緒申鐃藷ストラク鐃緒申
	public VRC0(Manager manager, VREnv henv, VREnv henv2) {
		this.htmlEnv = henv;
		this.htmlEnv2 = henv2;
	}

	@Override
	public String getSymbol() {
		return "HTMLC0";
	}

	// C2鐃緒申work鐃潤ソ鐃獣ワ申
	@Override
	public String work(ExtList data_info) {

		// Log.out("data_info =" +data_info);

		this.setDataList(data_info);

		if (decos.containsKey("form")) {
			htmlEnv.code.append(VRFunction.createForm(decos));
			VREnv.setFormItemFlg(true, null);
			htmlEnv2.code
					.append("<form" + VREnv.getFormNumber() + "start />");
			if (decos.getStr("form").toLowerCase().equals("search"))
				VREnv.setSearch(true);
		}

		while (this.hasMoreItems()) {
			this.worknextItem();
		}

		if (decos.containsKey("form")) {
			htmlEnv2.code.append("<form" + VREnv.getFormNumber() + "end />");
			htmlEnv.code.append(VREnv.exFormNameCreate());
			htmlEnv.code.append("</form>");
			VREnv.setFormItemFlg(false, null);
			VREnv.incrementFormNumber();
			if (decos.getStr("form").toLowerCase().equals("search"))
				VREnv.setSearch(false);
		}
		return null;
	}

}