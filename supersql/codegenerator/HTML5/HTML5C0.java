	package supersql.codegenerator.HTML5;

import supersql.codegenerator.Manager;
import supersql.codegenerator.HTML.HTMLC0;
import supersql.codegenerator.HTML.HTMLEnv;

//import common.Log;

public class HTML5C0 extends HTMLC0 {
	HTML5Env html_env;
	HTML5Env html_env2;

	//���󥹥ȥ饯��
	public HTML5C0(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		super(manager, henv, henv2);
		this.html_env = (HTML5Env) henv;
		this.html_env2 = (HTML5Env) henv2;
	}

	@Override
	public String getSymbol() {
		return "HTML5C0";
	}

}
