package supersql.codegenerator;

/**
 * Operator, Manager ���������륯�饹
 */
public abstract class Factory {

	/**
	 * Manager ���������륯�饹
	 */
	public abstract Manager createManager();

	public abstract void createLocalEnv();

	/**
	 * C0�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Connector createC0(Manager manager);

	/**
	 * C1�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Connector createC1(Manager manager);

	/**
	 * C2�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Connector createC2(Manager manager);

	/**
	 * C3�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Connector createC3(Manager manager);

	/**
	 * C4�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Connector createC4(Manager manager);

	/**
	 * G0�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Grouper createG0(Manager manager);

	/**
	 * G1�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Grouper createG1(Manager manager);

	/**
	 * G2�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Grouper createG2(Manager manager);

	/**
	 * G3�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Grouper createG3(Manager manager);

	/**
	 * G4�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Grouper createG4(Manager manager);

	/**
	 * Attribute�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Attribute createAttribute(Manager manager);

	/**
	 * Function�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	public abstract Function createFunction(Manager manager);

	public abstract Attribute createConditionalAttribute(Manager manager);

	public abstract IfCondition createIfCondition(Manager manager, Attribute condition,
			ITFE thenTfe, ITFE elseTfe);
}
