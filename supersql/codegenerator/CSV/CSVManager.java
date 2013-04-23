package supersql.codegenerator.CSV;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import supersql.codegenerator.Manager;
import supersql.codegenerator.TFE;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class CSVManager extends Manager{

    //メン�?
    CSVEnv csv_env;
    CSVEnv csv_env2;

    //コンストラクタ
    public CSVManager(CSVEnv xenv, CSVEnv xenv2) {
        this.csv_env = xenv;
        this.csv_env2 = xenv2;
    }


    public void generateCode(TFE tfe_info, ExtList data_info) {

        csv_env.countfile = 0;
        csv_env.code = new StringBuffer();

        csv_env.header = new StringBuffer();
        csv_env.footer = new StringBuffer();

        CSVEnv localenv = new CSVEnv();

        //出力する大本のファイル名�?設�?
        getOutfilename();

        Log.out("[CSVManager:generateCode]");


        csv_env.filename = csv_env.outfile + ".csv"; //�??�?��

        csv_env.setOutlineMode();

        if(data_info.size() == 0)
        {
        	Log.out("no data");
        	csv_env.code.append("NO DATA FOUND");
        }
        else
        	tfe_info.work(data_info);

        csv_env.getHeader();

        csv_env.getFooter();

        try {
        	if(!GlobalEnv.isOpt()){
	        	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
	                    csv_env.filename)));

	            pw.println(csv_env.header);
	            pw.println(csv_env.code);
	            pw.println(csv_env.footer);
	            pw.close();
        	}
        } catch (FileNotFoundException fe) {
        	fe.printStackTrace();
        	System.err.println("Error: specified outdirectory \""
                    + csv_env.outdir + "\" is not found to write " + csv_env.filename );
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Error[CSVManager]: File IO Error in CSVManager");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private void getOutfilename() {
        String file = GlobalEnv.getfilename();
        String outdir = GlobalEnv.getoutdirectory();
        String outfile = GlobalEnv.getoutfilename();
        csv_env.outdir = outdir;

        /*
         * 出力ファイル(outfilename)が指定されて�?��場�?
         * csv_env.outfileをglobalenv.outfilenameにする
         * それ以外�?とき�?クエリファイルの名前(filename)にする
         */
        if (outfile == null) {
        	if (file.indexOf(".sql")>0) {
        		csv_env.outfile = file.substring(0, file.indexOf(".sql"));
        	} else if (file.indexOf(".ssql")>0) {
        		csv_env.outfile = file.substring(0, file.indexOf(".ssql"));
        	}
        } else {
            csv_env.outfile = getOutfile(outfile);
        }

        if (csv_env.outfile.indexOf("/") > 0) {
            csv_env.linkoutfile = csv_env.outfile.substring(csv_env.outfile
                    .lastIndexOf("/") + 1);
        } else {
            csv_env.linkoutfile = csv_env.outfile;
        }

        /*
         * 出力�?�?��レクトリ(outdirectory)が指定されて�?��場�?
         * outdirectoryとfilenameをつなげたも�?をfileとする
         */
        if (outdir != null) {
            connectOutdir(outdir, outfile);
        }
    }

    private String getOutfile(String outfile) {
        String out = new String();
        if (outfile.indexOf(".csv") > 0) {
            out = outfile.substring(0, outfile.indexOf(".csv"));
        } else {
            out = outfile;
        }
        return out;
    }

    private void connectOutdir(String outdir, String outfile) {
        String tmpqueryfile = new String();
        if (csv_env.outfile.indexOf("/") > 0) {
            if (outfile != null) {
                if (csv_env.outfile.startsWith(".")
                        || csv_env.outfile.startsWith("/")) {
                    tmpqueryfile = csv_env.outfile.substring(csv_env.outfile
                            .indexOf("/") + 1);
                }
            } else {
                tmpqueryfile = csv_env.outfile.substring(csv_env.outfile
                        .lastIndexOf("/") + 1);
            }
        } else {
            tmpqueryfile = csv_env.outfile;
        }
        if (!outdir.endsWith("/")) {
            outdir = outdir.concat("/");
        }
        csv_env.outfile = outdir.concat(tmpqueryfile);
    }

    public void finish() {

    }
}
