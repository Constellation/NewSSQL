package supersql.codegenerator.PDF;

import supersql.codegenerator.*;
import supersql.extendclass.ExtList;

public class PDFC4 extends Connector {

	Manager manager;

	PDFEnv pdf_env;

	//コンストラクタ
	public PDFC4(Manager manager, PDFEnv pdf_env) {
		this.manager = manager;
		this.pdf_env = pdf_env;
	}

	//C1のworkメソッド
	@Override
	public void work(ExtList data_info) {
	}

	/*
	 * public void createSchema(List table, List le, List le1, List le2, List
	 * le3){ }
	 */

	@Override
	public String toString() {
		return "C1";
	}

}