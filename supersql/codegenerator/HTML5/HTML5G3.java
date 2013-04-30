package supersql.codegenerator.HTML5;

import supersql.codegenerator.Manager;
import supersql.codegenerator.HTML.HTMLEnv;
import supersql.codegenerator.HTML.HTMLG3;

public class HTML5G3 extends HTMLG3 {

    HTML5Env html_env;
    HTML5Env html_env2;

    //���󥹥ȥ饯��
    public HTML5G3(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        super(manager, henv, henv2);
        this.html_env = (HTML5Env) henv;
        this.html_env2 = (HTML5Env) henv2;
    }

    @Override
	public String getSymbol() {
        return "HTML5G3";
    }

}
