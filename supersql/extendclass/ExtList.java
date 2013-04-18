package supersql.extendclass;

import java.util.ArrayList;
import java.util.Collection;

public class ExtList<T> extends ArrayList<T> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/* ArrayListと同様にStringを扱うことができるように拡張 */
	boolean isStr = false;
	String str = "";

	public ExtList () {
		super();
	}

	public ExtList(Collection<T> c) {
		super(c);
	}

	public ExtList(String s) {
		isStr = true;
		str = s;
	}

	public ExtList<T> ExtsubList(int fromIndex, int toIndex) {
		return new ExtList<T>(this.subList(fromIndex, toIndex));
	}

	public String getStr() {
		if (isStr)
			return str;
		return null;
	}

	@Override
	public String toString() {
		if (isStr)
			return "Ext:" + str;
		return super.toString();
	}

	public int contain_itemnum() {
		return this.unnest().size();
	}

	@SuppressWarnings("unchecked")
	public ExtList<T> unnest() {
		ExtList<T> list = new ExtList<T>();
		for (int i = 0; i < this.size(); i++) {
			T o = this.get(i);
			if (o instanceof ExtList) {
					list.addAll(((ExtList<T>) o).unnest());
			} else {
				list.add((T) o);
			}
		}
		return list;
	}

	public boolean isStr() {
		return isStr;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ExtList) {
			if (((ExtList<?>) o).isStr()) {
				return this.getStr().equals(((ExtList<?>) o).getStr());
			} else {
				for (int i = 0; i < this.size(); i++) {
					if (!(((ExtList<?>) (this.get(i)))
							.equals(((ExtList<?>) o).get(i)))) {
						return false;
					}
				}
				return true;
			}
		}

		return false;

	}

	public String camma_list() {
		if (isStr) {
			return str;
		} else {
			String buf = "";
			for (int i = 0; i < this.size(); i++) {
				if (i > 0) {
					buf.concat(",");
				}
				buf.concat(this.get(i).toString());
			}
			return buf;
		}

	}

}