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

	// public class FrontEnd_ implements FrontEndService {

	public static SSQLparser parser;
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

		parser = new SSQLparser();
		
		if (GlobalEnv.isCheckquery()) {
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
				DataConstructor dc = new DataConstructor(parser);
				afterdc = System.currentTimeMillis();

				if (GlobalEnv.getErrFlag() == 0) {
					codegenerator.generateCode(parser, dc.getData());
					aftercg = System.currentTimeMillis();
				}
			}
		}

		long end = System.currentTimeMillis();
		Log.info("Parsing Time : " + (afterparser - start) + "msec");
		Log.info("Data construction Time : " + (afterdc - afterparser) + "msec");
		Log.info("Code generation Time : " + (aftercg - afterdc) + "msec");
		Log.info("ExecTime: " + (end - start) + "msec");
		
//		// eHTML評価用の出力
//		Log.ehtmlInfo("Parsing Time : " + (afterparser - start) + "msec<br>");
//		Log.ehtmlInfo("Data construction Time : " + (afterdc - afterparser) + "msec<br>");
//		Log.ehtmlInfo("Code generation Time : " + (aftercg - afterdc) + "msec<br>");
//		Log.ehtmlInfo("ExecTime: " + (end - start) + "msec<br>");

		GlobalEnv.queryInfo += GlobalEnv.getusername() + " | "
				+ GlobalEnv.queryName + " | ";
		if (GlobalEnv.getErrFlag() == 0) {
			Log.info("// completed normally //");
			LogInfo.logInfo(true);
			TFEmatcher.output(); // halken TFEmatcher
		} else
			LogError.logErr();

		if (GlobalEnv.getErrFlag() != 0 && GlobalEnv.getOnlineFlag() == 0)
			System.exit(-1);
		// return TFEmatcher.TFEList; // 20141107 halken check needs
		else
			return;
		// return TFEmatcher.TFEList;
	}

}