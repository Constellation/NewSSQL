/* TFE abstract class */

package supersql.codegenerator;

import supersql.extendclass.ExtList;

public abstract interface Operand extends TFE {

	public void work(ExtList data_info);

}