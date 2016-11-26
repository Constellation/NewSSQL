package supersql.codegenerator.VR;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Connector;
import supersql.codegenerator.Factory;
import supersql.codegenerator.Function;
import supersql.codegenerator.Grouper;
import supersql.codegenerator.IfCondition;
import supersql.codegenerator.Manager;
import supersql.codegenerator.TFE;
import supersql.common.Log;

//Operator, Manager鐃緒申鐃緒申鐃緒申鐃緒申鐃暑ク鐃初ス

public class VRFactory extends Factory {

	private VREnv htmlEnv;
	private VREnv htmlEnv2;

	@Override
	public Attribute createAttribute(Manager manager) {
		return new VRAttribute(manager, htmlEnv, htmlEnv2);
	}

	@Override
	public Connector createC0(Manager manager) {
		return new VRC0(manager, htmlEnv, htmlEnv2);
	}

	@Override
	public Connector createC1(Manager manager) {
		return new VRC1(manager, htmlEnv, htmlEnv2);
	}

	@Override
	public Connector createC2(Manager manager) {
		return new VRC2(manager, htmlEnv, htmlEnv2);
	}

	@Override
	public Connector createC3(Manager manager) {
		// return new HTMLC1(manager, html_env);
		return new VRC3(manager, htmlEnv, htmlEnv2);
	}

	@Override
	public Connector createC4(Manager manager) {
		return new VRC1(manager, htmlEnv, htmlEnv2);
		// return new HTMLC4(manager);
	}


	@Override
	public Grouper createG1(Manager manager) {
		return new VRG1(manager, htmlEnv, htmlEnv2);
	}

	@Override
	public Grouper createG2(Manager manager) {
		return new VRG2(manager, htmlEnv, htmlEnv2);
	}

	@Override
	public Grouper createG3(Manager manager) {
		return new VRG3(manager, htmlEnv, htmlEnv2);

	}

	@Override
	public Grouper createG4(Manager manager) {
		return new VRG1(manager, htmlEnv, htmlEnv2);
		// return new HTMLG4(manager, html_env);
	}

	@Override
	public Function createFunction(Manager manager) {
		return new VRFunction(manager, htmlEnv, htmlEnv2);
	}
	
	@Override
	public IfCondition createIfCondition(Manager manager, Attribute condition,
			TFE thenTfe, TFE elseTfe) {
		return new VRIfCondition(manager, htmlEnv, htmlEnv2, condition, thenTfe, elseTfe);
	}
	
	@Override
	public void createLocalEnv() {
		htmlEnv = new VREnv();
		htmlEnv2 = new VREnv();
	}

	@Override
	public Manager createManager() {
		return new VRManager(htmlEnv, htmlEnv2);
	}

}
