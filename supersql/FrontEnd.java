package supersql;

import supersql.codegenerator.CodeGenerator;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.dataconstructor.DataConstructor;
import supersql.parser.SSQLparser;

public class FrontEnd {

	public static void main(String[] args) {
		new FrontEnd(args);
	}

	public FrontEnd(String[] args) {

		execSuperSQL(args);

	}

	public void execSuperSQL(String[] args) {

		long start = System.currentTimeMillis();

		GlobalEnv.setGlobalEnv(args);

		// GlobalEnv.endnum = 30;
		Log.info("//Entering SuperSQL System//");

		SSQLparser parser = new SSQLparser();

		long afterparser = System.currentTimeMillis();
		long afterdc = 0;
		long aftercg = 0;

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
		Log.info("ExecTime: " + (end - start) + "msec");
		/*
		Log.info("パーザ時間：" + (afterparser - start) + "ミリ秒です。");
		Log.info("DC時間：" + (afterdc - afterparser) + "ミリ秒です。");
		Log.info("CG時間：" + (aftercg - afterdc) + "ミリ秒です。");
		*/
		if (GlobalEnv.getErrFlag() == 0)
			Log.info("// completed normally //");

		/*
		 * if(GlobalEnv.isNewEmbed() == 1) { Log.out("[delete tmp file]");
		 * ArrayList filelist = GlobalEnv.getEmbedFile(); //
		 * Log.out("filelistsize:"+filelist.size()); File file;
		 * if(filelist.size() != 0) { for(int i = 0; i < filelist.size() ; ++i) {
		 * file = new File(GlobalEnv.getEmbedTmp(), filelist.get(i).toString()); //
		 * Log.out("file name:"+filelist.get(i).toString()+" i:"+i);
		 * if(file.delete()) Log.out("file delete:"+filelist.get(i).toString()); } } }
		 */

		if (GlobalEnv.getErrFlag() != 0 && GlobalEnv.getOnlineFlag() == 0)
			System.exit(-1);
		else
			return;

	}

}