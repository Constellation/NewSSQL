package supersql.codegenerator;

/**
 * Operator, Manager を生成するクラス
 */
public abstract class Factory {

	/**
	 * Manager を生成するクラス
	 */
	public abstract Manager createManager();

	public abstract void createLocalEnv();

	/**
	 * C0の下位クラスインスタンスを生成するクラス
	 */
	public abstract Connector createC0(Manager manager);

	/**
	 * C1の下位クラスインスタンスを生成するクラス
	 */
	public abstract Connector createC1(Manager manager);

	/**
	 * C2の下位クラスインスタンスを生成するクラス
	 */
	public abstract Connector createC2(Manager manager);

	/**
	 * C3の下位クラスインスタンスを生成するクラス
	 */
	public abstract Connector createC3(Manager manager);

	/**
	 * C4の下位クラスインスタンスを生成するクラス
	 */
	public abstract Connector createC4(Manager manager);

	/**
	 * G0の下位クラスインスタンスを生成するクラス
	 */
	public abstract Grouper createG0(Manager manager);

	/**
	 * G1の下位クラスインスタンスを生成するクラス
	 */
	public abstract Grouper createG1(Manager manager);

	/**
	 * G2の下位クラスインスタンスを生成するクラス
	 */
	public abstract Grouper createG2(Manager manager);

	/**
	 * G3の下位クラスインスタンスを生成するクラス
	 */
	public abstract Grouper createG3(Manager manager);

	/**
	 * G4の下位クラスインスタンスを生成するクラス
	 */
	public abstract Grouper createG4(Manager manager);

	/**
	 * Attributeの下位クラスインスタンスを生成するクラス
	 */
	public abstract Attribute createAttribute(Manager manager);

	/**
	 * Functionの下位クラスインスタンスを生成するクラス
	 */
	public abstract Function createFunction(Manager manager);

	public abstract Attribute createConditionalAttribute(Manager manager);

	public abstract IfCondition createIfCondition(Manager manager, Attribute condition,
			ITFE thenTfe, ITFE elseTfe);
}
