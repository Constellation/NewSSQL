package supersql.codegenerator;

/**
 * Operator, Manager を生成するクラス
 */
public class Factory implements IFactory {

	private LocalEnv env;
	private LocalEnv env2;
	
	@Override
	public Manager createManager() {
		return null;
	}

	@Override
	public void createLocalEnv() {
	}

	@Override
	public Connector createC0(Manager manager) {
		return null;
	}

	@Override
	public Connector createC1(Manager manager) {
		return null;
	}

	@Override
	public Connector createC2(Manager manager) {
		return null;
	}

	@Override
	public Connector createC3(Manager manager) {
		return null;
	}

	@Override
	public Connector createC4(Manager manager) {
		return null;
	}

	@Override
	public Grouper createG0(Manager manager) {
		return null;
	}

	@Override
	public Grouper createG1(Manager manager) {
		return null;
	}

	@Override
	public Grouper createG2(Manager manager) {
		return null;
	}

	@Override
	public Grouper createG3(Manager manager) {
		return null;
	}

	@Override
	public Grouper createG4(Manager manager) {
		return null;
	}

	@Override
	public Attribute createAttribute(Manager manager) {
		return null;
	}

	@Override
	public Function createFunction(Manager manager) {
		return null;
	}

	@Override
	public Attribute createConditionalAttribute(Manager manager) {
		return null;
	}

	@Override
	public IfCondition createIfCondition(Manager manager, Attribute condition,
			TFE thenTfe, TFE elseTfe) {
		return null;
	}

	public LocalEnv getEnv() {
		return env;
	}

	public void setEnv(LocalEnv env) {
		this.env = env;
	}

	public LocalEnv getEnv2() {
		return env2;
	}

	public void setEnv2(LocalEnv env2) {
		this.env2 = env2;
	}
}
