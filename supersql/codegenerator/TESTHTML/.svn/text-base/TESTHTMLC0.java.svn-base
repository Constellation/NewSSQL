package supersql.codegenerator.TESTHTML;

import supersql.codegenerator.Connector;
import supersql.codegenerator.Manager;
import supersql.extendclass.ExtList;

//import common.Log;

public class TESTHTMLC0 extends Connector {
	Manager manager;

	TESTHTMLEnv html_env;
	TESTHTMLEnv html_env2;

	//���󥹥ȥ饯��
	public TESTHTMLC0(Manager manager, TESTHTMLEnv henv, TESTHTMLEnv henv2) {
		this.manager = manager;
		this.html_env = henv;
		this.html_env2 = henv2;
	}

	//C2��work�᥽�å�
	@Override
	public void work(ExtList data_info) {

//		      Log.out("data_info =" +data_info);
		
		this.setDataList(data_info);
		

		 if(decos.containsKey("form")){
	           	html_env.code.append(TESTHTMLFunction.createForm(decos));
	           	TESTHTMLEnv.setFormItemFlg(true,null);
	        	html_env2.code.append("<form"+TESTHTMLEnv.getFormNumber()+"start />");
	        	if(decos.getStr("form").toLowerCase().equals("search"))
	        		TESTHTMLEnv.setSearch(true);
		 }	 
		
		while (this.hasMoreItems()) {
			this.worknextItem();
		}
		

        if(decos.containsKey("form")){
        	html_env2.code.append("<form"+ TESTHTMLEnv.getFormNumber() +"end />");
        	html_env.code.append(TESTHTMLEnv.exFormNameCreate());
           	html_env.code.append("</form>");
           	TESTHTMLEnv.setFormItemFlg(false,null);
           	TESTHTMLEnv.incrementFormNumber();
           	if(decos.getStr("form").toLowerCase().equals("search"))
        		TESTHTMLEnv.setSearch(false);
        }

	}

	@Override
	public String getSymbol() {
		return "HTMLC0";
	}

}