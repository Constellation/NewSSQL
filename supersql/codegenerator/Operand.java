package supersql.codegenerator;

import supersql.extendclass.ExtList;

public abstract class Operand extends TFE implements IOperand {

	public Operand() {
		super();
	}

	@Override
	public abstract void work(ExtList<ExtList<String>> data_info);
}
