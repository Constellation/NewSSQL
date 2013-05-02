package supersql.codegenerator.CSV;

import supersql.codegenerator.Function;
import supersql.codegenerator.Manager;
import supersql.common.Log;
import supersql.extendclass.ExtList;

//import common.Log;

public class CSVFunction extends Function {

    Manager manager;

    CSVEnv xml_env;
    CSVEnv xml_env2;

    boolean embedflag = false;

    public CSVFunction()
    {

    }

    //コンストラクタ
    public CSVFunction(Manager manager, CSVEnv xenv, CSVEnv xenv2) {
        super();
        this.manager = manager;
        this.xml_env = xenv;
        this.xml_env2 = xenv2;
    }

    //Functionのworkメソ�?��
    public void work(ExtList data_info) {
        this.setDataList(data_info);

        String FuncName = this.getFuncName();

        Log.out("TFEId = " + CSVEnv.getClassID(this));
    }

    //NULL関数
    private void Func_null() {
        return;
    }

	//tag値の置換（実体参照?�関数  add by ryuryu
    public static String Func_replace(String s){
	    if(s.contains("&"))
	    	s = s.replace("&", "&amp;");
	    if(s.contains("<"))
	    	s = s.replace("<", "&lt;");
	    if(s.contains(">"))
	    	s = s.replace(">", "&gt;");

	    return s;
    }

  //attribute値の置換（実体参照?�関数  add by ryuryu
    public static String Func_att_replace(String s){
    	if(s.contains("'"))
	    	s = s.replace("'", "&apos;");
	    if(s.contains("\""))
	    	s = s.replace("\"", "&quot;");

	    return s;
    }

}