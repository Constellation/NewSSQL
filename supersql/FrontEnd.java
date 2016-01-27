package supersql;

import supersql.codegenerator.CodeGenerator;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.common.LogError;
import supersql.common.LogInfo;
import supersql.dataconstructor.DataConstructor;
import supersql.parser.SSQLparser;
import supersql.parser.TFEmatcher;

public class FrontEnd {
//public class FrontEnd_ implements FrontEndService { // TODO

	public static void main(String[] args) {
		new FrontEnd(args);
	}

	public FrontEnd(String[] args) {
		execSuperSQL(args);
	}

	public void execSuperSQL(String[] args) {

		long start = System.currentTimeMillis();
		
		GlobalEnv.setGlobalEnv(args);

		Log.info("//Entering SuperSQL System//");

		Log.out("$$$$$ SSQLparser start $$$$$");
		SSQLparser parser = new SSQLparser();
		Log.out("%%%%% SSQLparser end %%%%%");
		
		if (GlobalEnv.isCheckquery()){
			if (GlobalEnv.getErrFlag() == 0)
				Log.info("// Parser completed normally //");
			return;
		}

		long afterparser = System.currentTimeMillis();
		long afterdc = 0;
		long aftercg = 0;

		if (GlobalEnv.getErrFlag() == 0) {
			Log.out("$$$$$ codegenerator start $$$$$");
			CodeGenerator codegenerator = parser.getcodegenerator();
			Log.out("%%%%% codegenerator end %%%%%");

			if (GlobalEnv.getErrFlag() == 0) {
				Log.out("$$$$$ DataConstructor start $$$$$");
				DataConstructor dc = new DataConstructor(parser);
				Log.out("%%%%% DataConstructor end %%%%%");
				afterdc = System.currentTimeMillis();

				if (GlobalEnv.getErrFlag() == 0) {
					Log.out("$$$$$ generateCode start $$$$$");
					codegenerator.generateCode(parser, dc.getData());
					Log.out("%%%%% generateCode end %%%%%");
					aftercg = System.currentTimeMillis();
				}
			}
		}

		long end = System.currentTimeMillis();
		Log.info("Parsing Time : " + (afterparser - start) + "msec");
		Log.info("Data construction Time : "+ (afterdc - afterparser) + "msec");
		Log.info("Code generation Time : " + (aftercg - afterdc) + "msec");
		Log.info("ExecTime: " + (end - start) + "msec");
		
		GlobalEnv.queryInfo += GlobalEnv.getusername() + " | " + GlobalEnv.queryName +  " | ";
		if (GlobalEnv.getErrFlag() == 0){
			Log.info("// completed normally //");
			LogInfo.logInfo(true);
			TFEmatcher.output();	//halken TFEmatcher
		} else 
			LogError.logErr();
		
		if (GlobalEnv.getErrFlag() != 0 && GlobalEnv.getOnlineFlag() == 0)
			System.exit(-1);
//			return TFEmatcher.TFEList; // 20141107 halken check needs		
		else
			return;
//			return TFEmatcher.TFEList;
	}
	
}