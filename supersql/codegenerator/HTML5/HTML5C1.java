package supersql.codegenerator.HTML5;

import java.util.Vector;

import supersql.codegenerator.*;
import supersql.codegenerator.HTML.HTMLC1;
import supersql.codegenerator.HTML.HTMLEnv;

public class HTML5C1 extends HTMLC1 {

    HTML5Env html_env;
    HTML5Env html_env2;


    public HTML5C1(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		super(manager, henv, henv2);
		this.html_env = (HTML5Env) henv;
		this.html_env2 = (HTML5Env) henv2;
	}

    public String getSymbol() {
        return "HTML5C1";
    }

}
