package supersql.codegenerator;

public interface IFactory {

	/**
	 * Manager ���������륯�饹
	 */
	Manager createManager();

	void createLocalEnv();

	/**
	 * C0�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Connector createC0(Manager manager);

	/**
	 * C1�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Connector createC1(Manager manager);

	/**
	 * C2�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Connector createC2(Manager manager);

	/**
	 * C3�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Connector createC3(Manager manager);

	/**
	 * C4�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Connector createC4(Manager manager);

	/**
	 * G0�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Grouper createG0(Manager manager);

	/**
	 * G1�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Grouper createG1(Manager manager);

	/**
	 * G2�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Grouper createG2(Manager manager);

	/**
	 * G3�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Grouper createG3(Manager manager);

	/**
	 * G4�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Grouper createG4(Manager manager);

	/**
	 * Attribute�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Attribute createAttribute(Manager manager);

	/**
	 * Function�β��̥��饹���󥹥��󥹤��������륯�饹
	 */
	Function createFunction(Manager manager);

	Attribute createConditionalAttribute(Manager manager);

	IfCondition createIfCondition(Manager manager,
			Attribute condition, TFE thenTfe, TFE elseTfe);

}