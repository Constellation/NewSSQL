/* TFE abstract class */

package supersql.codegenerator;

import supersql.extendclass.ExtList;

public interface TFE {
	public void debugout(int count);

	public ExtList makesch();

	public ExtList makele0();

	public void work(ExtList data_info);

	public int countconnectitem();

	public void addDeco(String key, Object val);

	public void setId(int id);
	public int getId();

	//hanki start
	public void setOrderBy(String order);
	public void setAggregate(String aggregate);
	//hanki end

	//added by ria 20110913 start
	public ExtList makeschImage();
	//added by ria 20110913 end

	public void addDeco(String name, String value, String condition);
}
