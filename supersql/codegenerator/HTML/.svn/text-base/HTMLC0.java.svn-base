package supersql.codegenerator.HTML;

import supersql.codegenerator.Connector;
import supersql.codegenerator.Manager;
import supersql.extendclass.ExtList;

//import common.Log;

public class HTMLC0 extends Connector {
	Manager manager;

	HTMLEnv html_env;
	HTMLEnv html_env2;

	//コンストラクタ
	public HTMLC0(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		this.manager = manager;
		this.html_env = henv;
		this.html_env2 = henv2;
	}

	//C2のworkメソッド
	@Override
	public void work(ExtList data_info) {

//		      Log.out("data_info =" +data_info);
		
		this.setDataList(data_info);
		

		 if(decos.containsKey("form")){
	           	html_env.code.append(HTMLFunction.createForm(decos));
	           	HTMLEnv.setFormItemFlg(true,null);
	        	html_env2.code.append("<form"+HTMLEnv.getFormNumber()+"start />");
	        	if(decos.getStr("form").toLowerCase().equals("search"))
	        		HTMLEnv.setSearch(true);
		 }	 
		
		while (this.hasMoreItems()) {
			this.worknextItem();
		}
		

        if(decos.containsKey("form")){
        	html_env2.code.append("<form"+ HTMLEnv.getFormNumber() +"end />");
        	html_env.code.append(HTMLEnv.exFormNameCreate());
           	html_env.code.append("</form>");
           	HTMLEnv.setFormItemFlg(false,null);
           	HTMLEnv.incrementFormNumber();
           	if(decos.getStr("form").toLowerCase().equals("search"))
        		HTMLEnv.setSearch(false);
        }

	}

	@Override
	public String getSymbol() {
		return "HTMLC0";
	}

}