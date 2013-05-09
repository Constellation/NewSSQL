package supersql.codegenerator.HTML;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Connector;
import supersql.codegenerator.Factory;
import supersql.codegenerator.Function;
import supersql.codegenerator.Grouper;
import supersql.codegenerator.IfCondition;
import supersql.codegenerator.Manager;
import supersql.codegenerator.TFE;

//Operator, Managerを生成するクラス

public class HTMLFactory extends Factory {

	@Override
	public void createLocalEnv() {
		setEnv(new HTMLEnv());
		setEnv2(new HTMLEnv());
	}

	@Override
	public Manager createManager() {
		return new HTMLManager((HTMLEnv) getEnv(),(HTMLEnv) getEnv2());
	}

	@Override
	public Connector createC0(Manager manager) {
		return new HTMLC0(manager,(HTMLEnv)  getEnv(),(HTMLEnv) getEnv2());
	}

	@Override
	public Connector createC1(Manager manager) {
		return new HTMLC1(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2());
	}

	@Override
	public Connector createC2(Manager manager) {
		return new HTMLC2(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2());
	}

	@Override
	public Connector createC3(Manager manager) {
		return new HTMLC3(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2());
	}

	@Override
	public Connector createC4(Manager manager) {
		return new HTMLC1(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2());
	}

	@Override
	public Grouper createG0(Manager manager) {
		return new HTMLG1(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2());
	}

	@Override
	public Grouper createG1(Manager manager) {
		return new HTMLG1(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2());
	}

	@Override
	public Grouper createG2(Manager manager) {
		return new HTMLG2(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2());
	}

	@Override
	public Grouper createG3(Manager manager) {
		return new HTMLG3(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2());

	}

	@Override
	public Grouper createG4(Manager manager) {
		return new HTMLG1(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2());
		//return new HTMLG4(manager, html_env);
	}

	@Override
	public Attribute createAttribute(Manager manager) {
		return new HTMLAttribute(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2());
	}

	@Override
	public Function createFunction(Manager manager) {
		return new HTMLFunction(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2());
	}

	@Override
	public Attribute createConditionalAttribute(Manager manager) {
		return new HTMLAttribute(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2(), true);
	}

	@Override
	public IfCondition createIfCondition(Manager manager, supersql.codegenerator.Attribute condition, TFE thenTfe, TFE elseTfe) {
		return new HTMLIfCondition(manager,(HTMLEnv) getEnv(),(HTMLEnv) getEnv2(), condition, thenTfe, elseTfe);
	}

}
