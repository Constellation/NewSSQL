package supersql.codegenerator.HTML5;

import supersql.codegenerator.Connector;
import supersql.codegenerator.Manager;
import supersql.extendclass.ExtList;

//import common.Log;

public class HTML5C0 extends Connector {
	Manager manager;

	HTML5Env html5_env;
	HTML5Env html5_env2;

	//���󥹥ȥ饯��
	public HTML5C0(Manager manager, HTML5Env henv, HTML5Env henv2) {
		this.manager = manager;
		this.html5_env = henv;
		this.html5_env2 = henv2;
	}

	//C2��work�᥽�å�
	@Override
	public void work(ExtList data_info) {

//		      Log.out("data_info =" +data_info);

		this.setDataList(data_info);


		 if(decos.containsKey("form")){
	           	html5_env.code.append(HTML5Function.createForm(decos));
	           	HTML5Env.setFormItemFlg(true,null);
	        	html5_env2.code.append("<form"+HTML5Env.getFormNumber()+"start />");
	        	if(decos.getStr("form").toLowerCase().equals("search"))
	        		HTML5Env.setSearch(true);
		 }

		while (this.hasMoreItems()) {
			this.worknextItem();
		}


        if(decos.containsKey("form")){
        	html5_env2.code.append("<form"+ HTML5Env.getFormNumber() +"end />");
        	html5_env.code.append(HTML5Env.exFormNameCreate());
           	html5_env.code.append("</form>");
           	HTML5Env.setFormItemFlg(false,null);
           	HTML5Env.incrementFormNumber();
           	if(decos.getStr("form").toLowerCase().equals("search"))
        		HTML5Env.setSearch(false);
        }

	}

	@Override
	public String getSymbol() {
		return "HTML5C0";
	}

}