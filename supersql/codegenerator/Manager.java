package supersql.codegenerator;

import supersql.codegenerator.ITFE;

public abstract class Manager {
	//インスタンス移行プ?前ラムの生成
//	public void generateCode(ITFE tfe_info, ExtList data_info) {
//	}
//	
//	public StringBuffer generateCode2(ITFE tfe_info, ExtList data_info) {
//		StringBuffer code = new StringBuffer();
//		return code;
//	}
//	
//	//return css code for embed function & form
//	public StringBuffer generateCode3(ITFE tfe_info, ExtList data_info) {
//		StringBuffer css = new StringBuffer();
//		return css;
//	}
//	
//	//return header code for form
//	public StringBuffer generateCode4(ITFE tfe_info, ExtList data_info) {
//		StringBuffer header = new StringBuffer();
//		return header;
//}
//	public StringBuffer generateCodeNotuple(ITFE tfe_info) {
//		StringBuffer code = new StringBuffer();
//		return code;
//	}
//
//	//return cssfile for embed function
//	public StringBuffer generateCssfile(ITFE tfe_info, ExtList data_info) {
//		StringBuffer cssfile = new StringBuffer();
//		return cssfile;
//	}
	
	/*
	 * 必要ならばコメントアウトを外す = 要?談 =
	 * 
	 * //インスタンス移行プ?前ラムの生成 public void generateCode2(TFE tfe_info, ExtList
	 * data_info){ }
	 * 
	 *  
	 */

	//後処?
	public abstract void finish();
}
