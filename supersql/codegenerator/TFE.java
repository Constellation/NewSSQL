package supersql.codegenerator;

import supersql.extendclass.ExtList;

public class TFE implements ITFE {

	int id; // SchemaID
	boolean order_flag;
	boolean aggregate_flag;
	String order;
	String aggregate;    
	public DecorateList decos;

	public TFE() {
		order_flag = false;
		aggregate_flag = false;
		decos = new DecorateList();
	}
	
	@Override
	public void debugout(int count) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ExtList<Integer> makesch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExtList makele0() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void work(ExtList<ExtList<String>> data_info) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int countconnectitem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setOrderBy(String order) {
		order_flag = true;
		this.order = new String();
		this.order = order;
	}

	@Override
	public void setAggregate(String aggregate) {
		aggregate_flag = true;
		this.aggregate = new String();
		this.aggregate = aggregate;
	}


	@Override
	public ExtList makeschImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDeco(String key, Object val) {
		decos.put(key, val);
	}
	
	@Override
	public void addDeco(String name, String value, String condition) {
		decos.put(name, value,condition);
	}

	@Override
	public void setDeco(DecorateList d) {
		decos = d;
	}

}
