package supersql.codegenerator.HTML5;

import supersql.codegenerator.Manager;
import supersql.codegenerator.HTML.HTMLEnv;
import supersql.codegenerator.HTML.HTMLG2;

public class HTML5G2 extends HTMLG2 {
	//���󥹥ȥ饯��
    public HTML5G2(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
    	super(manager, henv, henv2);
    }

    @Override
	public String getSymbol() {
        return "HTML5G2";
    }

}
