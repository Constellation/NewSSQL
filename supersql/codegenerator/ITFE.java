/* TFE abstract class */

package supersql.codegenerator;

import supersql.extendclass.ExtList;

/**
 *
 *
 *
 */
public interface ITFE {

	/**
	 *
	 * @param count
	 */
	void debugout(int count);

	/**
	 *
	 * @return
	 */
	ExtList<TFE> makesch();

	ExtList makele0();

	void work(ExtList data_info);

	int countconnectitem();

	void addDeco(String key, Object val);

	void setId(int id);
	int getId();

	//hanki start
	void setOrderBy(String order);
	void setAggregate(String aggregate);
	//hanki end

	//added by ria 20110913 start
	ExtList makeschImage();
	//added by ria 20110913 end

	void addDeco(String name, String value, String condition);
}
