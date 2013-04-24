package supersql.codegenerator;

import supersql.extendclass.ExtList;

public class Operator extends TFE implements IOperator {

	int Dimension;
	protected ExtList data;
    protected int dindex;
    
	boolean order_flag;
	boolean aggregate_flag;
	String order;
    String aggregate;
    
	@Override
	public void debugout(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExtList<TFE> makesch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtList makele0() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countconnectitem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addDeco(String key, Object val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setOrderBy(String order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAggregate(String aggregate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExtList makeschImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDeco(String name, String value, String condition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void work(ExtList data_info) {
		// TODO Auto-generated method stub
		
	}

}
