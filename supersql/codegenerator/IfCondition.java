package supersql.codegenerator;

import supersql.extendclass.ExtList;

public class IfCondition implements ITFE {

	protected Attribute condition;
	protected ITFE thenTfe;
	protected ITFE elseTfe;
	public DecorateList decos = new DecorateList();
    int id; // SchemaID


	public IfCondition(Attribute condition, ITFE thenTfe, ITFE elseTfe) {
		super();
		this.condition = condition;
		this.thenTfe = thenTfe;
		this.elseTfe = elseTfe;
	}

	public void debugout(int count) {
		Debug dbgout = new Debug();
		dbgout.prt(count, "<IfCondition type=" + getSymbol() + " thenTfe="
				+ thenTfe + " elseTfe=" + elseTfe + " condition=" + condition.toString() + ">");

		dbgout.prt(count, "</IfCondition>");
	}

	private String getSymbol() {
		return "HTMLIfCondition";
	}

	public ExtList makesch() {
		ExtList outsch = new ExtList();
		outsch.addAll(condition.makesch());
		outsch.addAll(thenTfe.makesch());
		outsch.addAll(elseTfe.makesch());
		return outsch;
	}

	public ExtList makele0() {
		ExtList le0 = new ExtList();

		le0.add(this.getSymbol());
		le0.addAll(condition.makele0());
		le0.addAll(thenTfe.makele0());
		le0.addAll(elseTfe.makele0());

		return le0;
	}

	public void work(ExtList data_info) {
	}

	public int countconnectitem() {
		// TODO Auto-generated method stub
		if(elseTfe != null)
			return 3;
		else
			return 2;
	}

	public void addDeco(String key, Object val) {
		// TODO Auto-generated method stub
		decos.put(key, val);
	}

	public void setId(int id) {
		// TODO Auto-generated method stub
		this.id =id;  
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setOrderBy(String order) {
		// TODO Auto-generated method stub
		
	}

	public void setAggregate(String aggregate) {
		// TODO Auto-generated method stub

	}

	public ExtList makeschImage() {
		// TODO Auto-generated method stub
		ExtList outsch = new ExtList();
		outsch.addAll(condition.makeschImage());
		outsch.addAll(thenTfe.makeschImage());
		outsch.addAll(elseTfe.makeschImage());
		return outsch;
	}

	public void addDeco(String name, String value, String condition) {
		// TODO Auto-generated method stub
		decos.put(name, value, condition);
	}

	public Attribute getCondition() {
		return condition;
	}

	public ITFE getThenTfe() {
		return thenTfe;
	}

	public ITFE getElseTfe() {
		return elseTfe;
	}

	@Override
	public String toString() {
		if(elseTfe == null)
			return "if " + condition + " then "+ thenTfe;
		else
			return "if " + condition + " then "+ thenTfe + " else "+elseTfe;
	}
	
	

}
