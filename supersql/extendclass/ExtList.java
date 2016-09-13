package supersql.extendclass;

import java.util.ArrayList;
import java.util.Collection;

public class ExtList<T> extends ArrayList<T> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	public ExtList() {
		super();
	}

	public ExtList(Collection<T> c) {
		super(c);
	}

	public ExtList<T> ExtsubList(int fromIndex, int toIndex) {
		return new ExtList<T>(this.subList(fromIndex, toIndex));
	}

	public int contain_itemnum() {
		return this.unnest().size();
	}

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
}