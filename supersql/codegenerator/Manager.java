package supersql.codegenerator;

import supersql.extendclass.ExtList;

/**
 * ?�ݥ��饹Manager�������������ˤ����äƤζ��̤ʵ�ǽ��ޤȤ᤿�� ����?�������������������󥹥��󥹰ܹԡ����?��
 */
public abstract class Manager {
	/*
	 * ɬ�פʤ�Х����ȥ����Ȥ򳰤� = ��?�� =
	 * 
	 * //����? public void preProcess(TFE tfe_info, ExtList data_info, LocalEnv
	 * localenv ){ }
	 * 
	 * //���饹?�������� public void createSchema(TFE tfe_info, ExtList data_info,
	 * LocalEnv localenv ){ }
	 *  
	 */
	public DecorateList decos = new DecorateList();
	public void setDeco(DecorateList d) {
		decos = d;
	}

	public void addDeco(String key, Object val) {
		decos.put(key, val);
	}
	
	//���󥹥��󥹰ܹԥ�?����������
	public void generateCode(ITFE tfe_info, ExtList data_info) {
	}
	
	public StringBuffer generateCode2(ITFE tfe_info, ExtList data_info) {
		StringBuffer code = new StringBuffer();
		return code;
	}
	
	//return css code for embed function & form
	public StringBuffer generateCode3(ITFE tfe_info, ExtList data_info) {
		StringBuffer css = new StringBuffer();
		return css;
	}
	
	//return header code for form
	public StringBuffer generateCode4(ITFE tfe_info, ExtList data_info) {
		StringBuffer header = new StringBuffer();
		return header;
}
	public StringBuffer generateCodeNotuple(ITFE tfe_info) {
		StringBuffer code = new StringBuffer();
		return code;
	}

	//return cssfile for embed function
	public StringBuffer generateCssfile(ITFE tfe_info, ExtList data_info) {
		StringBuffer cssfile = new StringBuffer();
		return cssfile;
	}
	
	/*
	 * ɬ�פʤ�Х����ȥ����Ȥ򳰤� = ��?�� =
	 * 
	 * //���󥹥��󥹰ܹԥ�?���������� public void generateCode2(TFE tfe_info, ExtList
	 * data_info){ }
	 * 
	 *  
	 */

	//���?
	public abstract void finish();

	public void generateCodeForJsoup(ITFE tfe_info, ExtList data_info) {
	}

}

