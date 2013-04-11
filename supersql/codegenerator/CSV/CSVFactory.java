package supersql.codegenerator.CSV;

import supersql.codegenerator.*;
import supersql.codegenerator.XML.XMLG0;


//Operator, Managerを生成するクラス

public class CSVFactory extends Factory {

	CSVEnv csv_env;
	CSVEnv csv_env2;

	public void createLocalEnv() {
		csv_env = new CSVEnv();
		csv_env2 = new CSVEnv();
	}

	public Manager createManager() {
		return new CSVManager(csv_env, csv_env2);
	}

	//無次元SuperSQL
	public Connector createC0(Manager manager) {
		return new CSVC0(manager, csv_env, csv_env2);
	}

	public Connector createC1(Manager manager) {
		return new CSVC0(manager, csv_env, csv_env2);
	}

	public Connector createC2(Manager manager) {
		return new CSVC0(manager, csv_env, csv_env2);
	}

	public Connector createC3(Manager manager) {
		return new CSVC0(manager, csv_env, csv_env2);
	}

	public Connector createC4(Manager manager) {
		return new CSVC0(manager, csv_env, csv_env2);
	}

	//無次元SuperSQL
	public Grouper createG0(Manager manager) {
		return new CSVG0(manager, csv_env, csv_env2);
	}

	public Grouper createG1(Manager manager) {
		return new CSVG0(manager, csv_env, csv_env2);
	}

	public Grouper createG2(Manager manager) {
		return new CSVG0(manager, csv_env, csv_env2);
	}

	public Grouper createG3(Manager manager) {
		return new CSVG0(manager, csv_env, csv_env2);
	}

	public Grouper createG4(Manager manager) {
		return new CSVG0(manager, csv_env, csv_env2);
	}

	public Attribute createAttribute(Manager manager) {
		return new CSVAttribute(manager, csv_env, csv_env2);
	}

	public Function createFunction(Manager manager) {
		return new CSVFunction(manager, csv_env, csv_env2);
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
