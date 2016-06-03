package supersql;

import supersql.codegenerator.CodeGenerator;
import supersql.common.*;
import supersql.dataconstructor.DataConstructor;
import supersql.parser.Start_Parse;

public class FrontEnd {
//public class FrontEnd_ implements FrontEndService {
	//Test comment 
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

		Start_Parse parsertree = new Start_Parse(); //read file & parse query
		
		if (GlobalEnv.isCheckquery()){
			if (GlobalEnv.getErrFlag() == 0)
				Log.info("// Parser completed normally //");
			return;
		}

		long afterparser = System.currentTimeMillis();
		long afterdc = 0;
		long aftercg = 0;

		if (GlobalEnv.getErrFlag() == 0) {
			CodeGenerator codegenerator = parsertree.getcodegenerator();
			if (GlobalEnv.getErrFlag() == 0) {
				codegenerator.CodeGenerator(parsertree);

				DataConstructor dc = new DataConstructor(parsertree);
				afterdc = System.currentTimeMillis();

				if (GlobalEnv.getErrFlag() == 0) {
					codegenerator.generateCode(parsertree, dc.getData());
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
//			TFEmatcher.output();	//halken TFEmatcher
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
