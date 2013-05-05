package supersql.codegenerator.CSV;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class CSVManager extends Manager{

    private CSVEnv csvEnv;
    public CSVManager(CSVEnv xenv, CSVEnv xenv2) {
        this.csvEnv = xenv;
    }


    public void generateCode(ITFE tfe_info, ExtList data_info) {

        csvEnv.countfile = 0;
        csvEnv.code = new StringBuffer();

        csvEnv.header = new StringBuffer();
        csvEnv.footer = new StringBuffer();

        getOutfilename();

        Log.out("[CSVManager:generateCode]");


        csvEnv.filename = csvEnv.outfile + ".csv"; //�??�?��

        csvEnv.setOutlineMode();

        if(data_info.size() == 0)
        {
        	Log.out("no data");
        	csvEnv.code.append("NO DATA FOUND");
        }
        else
        	tfe_info.work(data_info);
        try {
        	if(!GlobalEnv.isOpt()){
	        	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
	                    csvEnv.filename)));

	            pw.println(csvEnv.header);
	            pw.println(csvEnv.code);
	            pw.println(csvEnv.footer);
	            pw.close();
        	}
        } catch (FileNotFoundException fe) {
        	fe.printStackTrace();
        	System.err.println("Error: specified outdirectory \""
                    + csvEnv.outdir + "\" is not found to write " + csvEnv.filename );
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
        csvEnv.outdir = outdir;

        /*
         * 出力ファイル(outfilename)が指定されて�?��場�?
         * csv_env.outfileをglobalenv.outfilenameにする
         * それ以外�?とき�?クエリファイルの名前(filename)にする
         */
        if (outfile == null) {
        	if (file.indexOf(".sql")>0) {
        		csvEnv.outfile = file.substring(0, file.indexOf(".sql"));
        	} else if (file.indexOf(".ssql")>0) {
        		csvEnv.outfile = file.substring(0, file.indexOf(".ssql"));
        	}
        } else {
            csvEnv.outfile = getOutfile(outfile);
        }

        if (csvEnv.outfile.indexOf("/") > 0) {
            csvEnv.linkoutfile = csvEnv.outfile.substring(csvEnv.outfile
                    .lastIndexOf("/") + 1);
        } else {
            csvEnv.linkoutfile = csvEnv.outfile;
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
        if (csvEnv.outfile.indexOf("/") > 0) {
            if (outfile != null) {
                if (csvEnv.outfile.startsWith(".")
                        || csvEnv.outfile.startsWith("/")) {
                    tmpqueryfile = csvEnv.outfile.substring(csvEnv.outfile
                            .indexOf("/") + 1);
                }
            } else {
                tmpqueryfile = csvEnv.outfile.substring(csvEnv.outfile
                        .lastIndexOf("/") + 1);
            }
        } else {
            tmpqueryfile = csvEnv.outfile;
        }
        if (!outdir.endsWith("/")) {
            outdir = outdir.concat("/");
        }
        csvEnv.outfile = outdir.concat(tmpqueryfile);
    }

    public void finish() {

    }
}
