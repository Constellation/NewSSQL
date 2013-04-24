package supersql.codegenerator.HTML;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Connector;
import supersql.codegenerator.Factory;
import supersql.codegenerator.Function;
import supersql.codegenerator.Grouper;
import supersql.codegenerator.IfCondition;
import supersql.codegenerator.Manager;
import supersql.codegenerator.ITFE;

//Operator, Managerを生成するクラス

public class HTMLFactory extends Factory {

	HTMLEnv html_env;
	HTMLEnv html_env2;

	@Override
	public void createLocalEnv() {
		html_env = new HTMLEnv();
		html_env2 = new HTMLEnv();
	}

	@Override
	public Manager createManager() {
		return new HTMLManager(html_env,html_env2);
	}

	@Override
	public Connector createC0(Manager manager) {
		return new HTMLC0(manager, html_env,html_env2);
	}

	@Override
	public Connector createC1(Manager manager) {
		return new HTMLC1(manager, html_env,html_env2);
	}

	@Override
	public Connector createC2(Manager manager) {
		return new HTMLC2(manager, html_env,html_env2);
	}

	@Override
	public Connector createC3(Manager manager) {
		//return new HTMLC1(manager, html_env);
		return new HTMLC3(manager, html_env,html_env2);
	}

	@Override
	public Connector createC4(Manager manager) {
		return new HTMLC1(manager, html_env,html_env2);
		//return new HTMLC4(manager);
	}

	@Override
	public Grouper createG0(Manager manager) {
		//return new HTMLG0(manager, html_env);
		return new HTMLG1(manager, html_env,html_env2);
	}

	@Override
	public Grouper createG1(Manager manager) {
		return new HTMLG1(manager, html_env,html_env2);
	}

	@Override
	public Grouper createG2(Manager manager) {
		return new HTMLG2(manager, html_env,html_env2);
	}

	@Override
	public Grouper createG3(Manager manager) {
		return new HTMLG3(manager, html_env,html_env2);

	}

	@Override
	public Grouper createG4(Manager manager) {
		return new HTMLG1(manager, html_env,html_env2);
		//return new HTMLG4(manager, html_env);
	}

	@Override
	public Attribute createAttribute(Manager manager) {
		return new HTMLAttribute(manager, html_env,html_env2);
	}

	@Override
	public Function createFunction(Manager manager) {
		return new HTMLFunction(manager, html_env,html_env2);
	}

	@Override
	public Attribute createConditionalAttribute(Manager manager) {
		return new HTMLAttribute(manager, html_env, html_env2, true);
	}

	@Override
	public IfCondition createIfCondition(Manager manager, supersql.codegenerator.Attribute condition, ITFE thenTfe, ITFE elseTfe) {
		return new HTMLIfCondition(manager, html_env, html_env2, condition, thenTfe, elseTfe);
	}

}
