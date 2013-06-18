package supersql.codegenerator;

import supersql.extendclass.ExtList;

public abstract class Operator extends TFE implements IOperator {

	int Dimension;
	protected ExtList data;
    protected int dindex;
    
    public Operator() {
    	super();
    }

	@Override
	public abstract void work(ExtList<ExtList<String>> data_info);

}
