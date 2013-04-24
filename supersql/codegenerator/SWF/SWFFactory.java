/*
 * Created on 2004/11/26 by mai
*/
package supersql.codegenerator.SWF;

import supersql.codegenerator.*;

public class SWFFactory extends Factory {
	SWFEnv swf_env;

	@Override
	public void createLocalEnv() {
		swf_env = new SWFEnv();
	}

	@Override
	public Manager createManager() {
		return new SWFManager(swf_env);
	}

	@Override
	public Connector createC0(Manager manager) {
		//return new PDFC0(manager, pdf_env);
		return new SWFC1(manager, swf_env);
	}

	@Override
	public Connector createC1(Manager manager) {
		return new SWFC1(manager, swf_env);
	}

	@Override
	public Connector createC2(Manager manager) {
		return new SWFC2(manager, swf_env);
	}

	@Override
	public Connector createC3(Manager manager) {
		return new SWFC3(manager, swf_env);
	}

	@Override
	public Connector createC4(Manager manager) {
		return new SWFC4(manager, swf_env);
	}

	@Override
	public Grouper createG0(Manager manager) {
		//return new PDFG0(manager, pdf_env);
		return new SWFG1(manager, swf_env);
	}

	@Override
	public Grouper createG1(Manager manager) {
		return new SWFG1(manager, swf_env);
	}

	@Override
	public Grouper createG2(Manager manager) {
		return new SWFG2(manager, swf_env);
	}

	@Override
	public Grouper createG3(Manager manager) {
		return new SWFG3(manager, swf_env);
	}

	@Override
	public Grouper createG4(Manager manager) {
		return new SWFG4(manager, swf_env);
	}

	@Override
	public Attribute createAttribute(Manager manager) {
		return new SWFAttribute(manager, swf_env);
	}

	@Override
	public Function createFunction(Manager manager) {
		return new SWFFunction(manager, swf_env);
	}

	@Override
	public Attribute createConditionalAttribute(Manager manager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IfCondition createIfCondition(Manager manager, Attribute condition,
			ITFE thenTfe, ITFE elseTfe) {
		// TODO Auto-generated method stub
		return null;
	}
}
