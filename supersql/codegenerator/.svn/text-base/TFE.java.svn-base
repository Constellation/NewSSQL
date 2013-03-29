/* TFE abstract class */

package supersql.codegenerator;

import supersql.extendclass.ExtList;

public abstract interface TFE {
	public abstract void debugout(int count);

	public abstract ExtList makesch();

	public abstract ExtList makele0();

	public abstract void work(ExtList data_info);

	public abstract int countconnectitem();

	public abstract void addDeco(String key, Object val);

	public abstract void setId(int id);
	public abstract int getId();
	
	//hanki start
	public abstract void setOrderBy(String order);
	public abstract void setAggregate(String aggregate);
	//hanki end
	
	//added by ria 20110913 start
	public abstract ExtList makeschImage();
	//added by ria 20110913 end
}