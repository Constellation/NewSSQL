package supersql.codegenerator.XML;

import supersql.codegenerator.*;



public class XMLFactory extends Factory {

	XMLEnv xml_env;
	XMLEnv xml_env2;

	public void createLocalEnv() {
		xml_env = new XMLEnv();
		xml_env2 = new XMLEnv();
	}

	public Manager createManager() {
		return new XMLManager(xml_env, xml_env2);
	}

	public Connector createC0(Manager manager) {
		return new XMLC0(manager, xml_env, xml_env2);
	}

	public Connector createC1(Manager manager) {
		return new XMLC0(manager, xml_env, xml_env2);
	}

	public Connector createC2(Manager manager) {
		return new XMLC0(manager, xml_env, xml_env2);
	}

	public Connector createC3(Manager manager) {
		return new XMLC0(manager, xml_env, xml_env2);
	}

	public Connector createC4(Manager manager) {
		return new XMLC0(manager, xml_env, xml_env2);
	}

	public Grouper createG0(Manager manager) {
		return new XMLG0(manager, xml_env, xml_env2);
	}

	public Grouper createG1(Manager manager) {
		return new XMLG0(manager, xml_env, xml_env2);
	}

	public Grouper createG2(Manager manager) {
		return new XMLG0(manager, xml_env, xml_env2);
	}

	public Grouper createG3(Manager manager) {
		return new XMLG0(manager, xml_env, xml_env2);
	}

	public Grouper createG4(Manager manager) {
		return new XMLG0(manager, xml_env, xml_env2);
	}

	public Attribute createAttribute(Manager manager) {
		return new XMLAttribute(manager, xml_env, xml_env2);
	}

	public Function createFunction(Manager manager) {
		return new XMLFunction(manager, xml_env, xml_env2);
	}

}