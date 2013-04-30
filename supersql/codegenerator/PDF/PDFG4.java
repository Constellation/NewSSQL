package supersql.codegenerator.PDF;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.extendclass.ExtList;

public class PDFG4 extends Grouper {

	Manager manager;

	PDFEnv pdf_env;

	//コンストラクタ
	public PDFG4(Manager manager, PDFEnv pdf_env) {
		this.manager = manager;
		this.pdf_env = pdf_env;
	}

	@Override
	public void work(ExtList data_info) {
	}

	/*
	 * public void createSchema(List table, List le, List le1, List le2, List
	 * le3){ }
	 */

	@Override
	public String toString() {
		return "G1";
	}
}