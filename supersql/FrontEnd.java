package supersql;

import supersql.codegenerator.CodeGenerator;
import supersql.common.*;
import supersql.dataconstructor.DataConstructor;
import supersql.parser.Start_Parse;

public class FrontEnd {

	public static Start_Parse parser;
	public static long start = 0;
	public static long afterparser = 0;
	public static long afterdc;
	public static long aftercg;
	public static long aftersql;

	public static void main(String[] args) {
		new FrontEnd(args);
	}

	public FrontEnd(String[] args) {
		execSuperSQL(args);
	}

	public void execSuperSQL(String[] args) {

		start = System.currentTimeMillis();

		GlobalEnv.setGlobalEnv(args);

		Log.info("//Entering SuperSQL System//");

		parser = new Start_Parse(); //read file & parse query

		if (GlobalEnv.isCheckquery()){
			if (GlobalEnv.getErrFlag() == 0)
				Log.info("// Parser completed normally //");
			return;
		}

		afterparser = System.currentTimeMillis();
		afterdc = 0;
		aftercg = 0;
		aftersql = 0;

		if (GlobalEnv.getErrFlag() == 0) {
			CodeGenerator codegenerator = parser.getcodegenerator();
			if (GlobalEnv.getErrFlag() == 0) {
				codegenerator.CodeGenerator(parser);

				DataConstructor dc = new DataConstructor(parser);
				afterdc = System.currentTimeMillis();

				if (GlobalEnv.getErrFlag() == 0) {
					codegenerator.generateCode(parser, dc.getData());
					aftercg = System.currentTimeMillis();
				}
			}
		}

		long end = System.currentTimeMillis();
//		Log.info("Parsing Time : " + (afterparser - start) + "msec");
//		Log.info("Data construction Time : "+ (afterdc - afterparser) + "msec");
//		Log.info("Code generation Time : " + (aftercg - afterdc) + "msec");
		Log.info("ExecTime: " + (end - start) + "msec");

		// eHTML
//		Log.ehtmlInfo("Parsing Time : " + (afterparser - start) + "msec<br>");
//		Log.ehtmlInfo("Data construction Time : " + (afterdc - afterparser) + "msec<br>");
//		Log.ehtmlInfo("Code generation Time : " + (aftercg - afterdc) + "msec<br>");
//		Log.ehtmlInfo("ExecTime: " + (end - start) + "msec<br>");

		GlobalEnv.queryInfo += GlobalEnv.getusername() + " | " + GlobalEnv.queryName +  " | ";
		if (GlobalEnv.getErrFlag() == 0){
			//161119 yhac
			Ssedit.sseditInfo();

			Log.info("// completed normally //");

			//1203 yhac commentout
			LogInfo.logInfo(true);

//			TFEmatcher.output();	//halken TFEmatcher
		} else {
			//1203 yhac commentout
			LogError.logErr();

			//161109 yhac
			if (GlobalEnv.isSsedit_autocorrect()) {
				Ssedit.sseditInfo();
			}
		}

		if (GlobalEnv.getErrFlag() != 0 && GlobalEnv.getOnlineFlag() == 0)
			System.exit(-1);
//			return TFEmatcher.TFEList; // 20141107 halken check needs
		else
			return;
//			return TFEmatcher.TFEList;
	}

}
