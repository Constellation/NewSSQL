package supersql.codegenerator.HTML5;

import supersql.codegenerator.Manager;
import supersql.codegenerator.HTML.HTMLC2;
import supersql.codegenerator.HTML.HTMLEnv;


public class HTML5C2 extends HTMLC2 {

    HTML5Env html_env;
    HTML5Env html_env2;

    //���󥹥ȥ饯��
    public HTML5C2(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
    	super(manager,henv,henv2);
    	this.html_env = (HTML5Env) henv;
        this.html_env2 = (HTML5Env) henv2;
    }

    public String getSymbol() {
        return "HTML5C2";
    }

}
