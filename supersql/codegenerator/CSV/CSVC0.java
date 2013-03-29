package supersql.codegenerator.CSV;

import java.util.Vector;
import supersql.codegenerator.*;
import supersql.codegenerator.CSV.CSVEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

//ryuryu
import supersql.parser.TFEparser;

public class CSVC0 extends Connector {

    Manager manager;

    CSVEnv csv_env;
    CSVEnv csv_env2;

    TFEparser tfeps;  //ryuryu

    //„Ç≥„É≥„Çπ„Éà„É©„ÇØ„Çø
    public CSVC0(Manager manager, CSVEnv xenv, CSVEnv xenv2) {
        this.manager = manager;
        this.csv_env = xenv;
        this.csv_env2 = xenv2;
    }

    //C0„ÅÆwork„É°„ÇΩ„É?Éâ
    public void work(ExtList data_info) {

    	Vector vector_local = new Vector();

    	Log.out("------- C0 -------");
        Log.out("tfes.contain_itemnum=" + tfes.contain_itemnum());
        Log.out("tfes.size=" + tfes.size());
        Log.out("countconnetitem=" + countconnectitem());

        this.setDataList(data_info);

        int i = 0;

        String att;

        //„É??„Çø„Éô„?„ÇπÂ±ûÊ?„ÇíCSV„Éï„Ç°„Ç§„É´„Å´ÊòéË®?
       //if(decos.containsKey("att")){
        //	att = decos.getStr("att");
        	//csv_env.code.append(att + "\n");
        //}

	    //end///////////////////////////////////////////////////////

	   	 while(this.hasMoreItems()) {

		    TFE tfe = (TFE)tfes.get(i);

		    String classid = CSVEnv.getClassID(tfe);

		    this.worknextItem(); //Âø??È†?õÆ
		}

	     csv_env.code.append("\n");
	   	 Log.out("TFEId = " + CSVEnv.getClassID(this));
	}

    public String getSymbol() {
        return "CSVC0";
    }

}