package supersql.codegenerator.HTML5;

import supersql.codegenerator.*;

//Operator, Manager���������륯�饹

public class HTML5Factory extends Factory {

	HTML5Env html5_env;
	HTML5Env html5_env2;

	@Override
	public void createLocalEnv() {
		html5_env = new HTML5Env();
		html5_env2 = new HTML5Env();
	}

	@Override
	public Manager createManager() {
		return new HTML5Manager(html5_env,html5_env2);
	}

	@Override
	public Connector createC0(Manager manager) {
		return new HTML5C0(manager, html5_env,html5_env2);
	}

	@Override
	public Connector createC1(Manager manager) {
		return new HTML5C1(manager, html5_env,html5_env2);
	}

	@Override
	public Connector createC2(Manager manager) {
		return new HTML5C2(manager, html5_env,html5_env2);
	}

	@Override
	public Connector createC3(Manager manager) {
		//return new HTML5C1(manager, html5_env);
		return new HTML5C3(manager, html5_env,html5_env2);
	}

	@Override
	public Connector createC4(Manager manager) {
		return new HTML5C1(manager, html5_env,html5_env2);
		//return new HTML5C4(manager);
	}

	@Override
	public Grouper createG0(Manager manager) {
		//return new HTML5G0(manager, html5_env);
		return new HTML5G1(manager, html5_env,html5_env2);
	}

	@Override
	public Grouper createG1(Manager manager) {
		return new HTML5G1(manager, html5_env,html5_env2);
	}

	@Override
	public Grouper createG2(Manager manager) {
		return new HTML5G2(manager, html5_env,html5_env2);
	}

	@Override
	public Grouper createG3(Manager manager) {
		return new HTML5G3(manager, html5_env,html5_env2);

	}

	@Override
	public Grouper createG4(Manager manager) {
		return new HTML5G1(manager, html5_env,html5_env2);
		//return new HTML5G4(manager, html5_env);
	}

	@Override
	public Attribute createAttribute(Manager manager) {
		return new HTML5Attribute(manager, html5_env,html5_env2);
	}

	@Override
	public Function createFunction(Manager manager) {
		return new HTML5Function(manager, html5_env,html5_env2);
	}

}