package supersql.codegenerator;

import supersql.extendclass.ExtList;

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
	ExtList<Integer> makesch();

	ExtList makele0();

	String work(ExtList<ExtList<String>> data_info);
	Object createNode(ExtList<ExtList<String>> data_info);

	int countconnectitem();

	void addDeco(String key, Object val);
	void setDeco(DecorateList d);
	
	void setId(int id);
	int getId();

	void setOrderBy(String order);
	void setAggregate(String aggregate);

	ExtList makeschImage();

	void addDeco(String name, String value, String condition);
}
