package supersql.codegenerator.TESTHTML;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Connector;
import supersql.codegenerator.Factory;
import supersql.codegenerator.Function;
import supersql.codegenerator.Grouper;
import supersql.codegenerator.IfCondition;
import supersql.codegenerator.Manager;
import supersql.codegenerator.TFE;

//Operator, Manager���������륯�饹

public class TESTHTMLFactory extends Factory {

	TESTHTMLEnv html_env;
	TESTHTMLEnv html_env2;

	@Override
	public void createLocalEnv() {
		html_env = new TESTHTMLEnv();
		html_env2 = new TESTHTMLEnv();
	}

	@Override
	public Manager createManager() {
		return new TESTHTMLManager(html_env,html_env2);
	}

	@Override
	public Connector createC0(Manager manager) {
		return new TESTHTMLC0(manager, html_env,html_env2);
	}

	@Override
	public Connector createC1(Manager manager) {
		return new TESTHTMLC1(manager, html_env,html_env2);
	}

	@Override
	public Connector createC2(Manager manager) {
		return new TESTHTMLC2(manager, html_env,html_env2);
	}

	@Override
	public Connector createC3(Manager manager) {
		//return new HTMLC1(manager, html_env);
		return new TESTHTMLC3(manager, html_env,html_env2);
	}

	@Override
	public Connector createC4(Manager manager) {
		return new TESTHTMLC1(manager, html_env,html_env2);
		//return new HTMLC4(manager);
	}

	@Override
	public Grouper createG0(Manager manager) {
		//return new HTMLG0(manager, html_env);
		return new TESTHTMLG1(manager, html_env,html_env2);
	}

	@Override
	public Grouper createG1(Manager manager) {
		return new TESTHTMLG1(manager, html_env,html_env2);
	}

	@Override
	public Grouper createG2(Manager manager) {
		return new TESTHTMLG2(manager, html_env,html_env2);
	}

	@Override
	public Grouper createG3(Manager manager) {
		return new TESTHTMLG3(manager, html_env,html_env2);

	}

	@Override
	public Grouper createG4(Manager manager) {
		return new TESTHTMLG1(manager, html_env,html_env2);
		//return new HTMLG4(manager, html_env);
	}

	@Override
	public Attribute createAttribute(Manager manager) {
		return new TESTHTMLAttribute(manager, html_env,html_env2);
	}

	@Override
	public Function createFunction(Manager manager) {
		return new TESTHTMLFunction(manager, html_env,html_env2);
	}

	@Override
	public Attribute createConditionalAttribute(Manager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IfCondition createIfCondition(Manager manager, Attribute condition,
			TFE thenTfe, TFE elseTfe) {
		// TODO Auto-generated method stub
		return null;
	}

}
