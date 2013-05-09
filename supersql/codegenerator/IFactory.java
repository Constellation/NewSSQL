package supersql.codegenerator;

public interface IFactory {

	/**
	 * Manager を生成するクラス
	 */
	Manager createManager();

	void createLocalEnv();

	/**
	 * C0の下位クラスインスタンスを生成するクラス
	 */
	Connector createC0(Manager manager);

	/**
	 * C1の下位クラスインスタンスを生成するクラス
	 */
	Connector createC1(Manager manager);

	/**
	 * C2の下位クラスインスタンスを生成するクラス
	 */
	Connector createC2(Manager manager);

	/**
	 * C3の下位クラスインスタンスを生成するクラス
	 */
	Connector createC3(Manager manager);

	/**
	 * C4の下位クラスインスタンスを生成するクラス
	 */
	Connector createC4(Manager manager);

	/**
	 * G0の下位クラスインスタンスを生成するクラス
	 */
	Grouper createG0(Manager manager);

	/**
	 * G1の下位クラスインスタンスを生成するクラス
	 */
	Grouper createG1(Manager manager);

	/**
	 * G2の下位クラスインスタンスを生成するクラス
	 */
	Grouper createG2(Manager manager);

	/**
	 * G3の下位クラスインスタンスを生成するクラス
	 */
	Grouper createG3(Manager manager);

	/**
	 * G4の下位クラスインスタンスを生成するクラス
	 */
	Grouper createG4(Manager manager);

	/**
	 * Attributeの下位クラスインスタンスを生成するクラス
	 */
	Attribute createAttribute(Manager manager);

	/**
	 * Functionの下位クラスインスタンスを生成するクラス
	 */
	Function createFunction(Manager manager);

	Attribute createConditionalAttribute(Manager manager);

	IfCondition createIfCondition(Manager manager,
			Attribute condition, TFE thenTfe, TFE elseTfe);

}