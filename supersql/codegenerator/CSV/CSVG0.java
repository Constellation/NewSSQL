package supersql.codegenerator.CSV;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class CSVG0 extends Grouper {

    Manager manager;

    CSVEnv csv_env;
    CSVEnv csv_env2;

    public static String attribute;

    //コンストラクタ
    public CSVG0(Manager manager, CSVEnv xenv, CSVEnv xenv2) {
        this.manager = manager;
        this.csv_env = xenv;
        this.csv_env2 = xenv2;
    }

    //G0のworkメソ�?��
    public void work(ExtList data_info) {
        Log.out("------- G0 -------");
        this.setDataList(data_info);

        int i = 0;

        while (this.hasMoreItems()) {
        	csv_env.glevel++;

        	String classid = CSVEnv.getClassID(tfe);

        	this.worknextItem();

		    i++;

		    csv_env.glevel--;
        }

        Log.out("TFEId = " + CSVEnv.getClassID(this));
    }

    public String getSymbol() {
        return "CSVG0";
    }

}