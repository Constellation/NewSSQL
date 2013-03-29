package supersql.codegenerator.CSV;

import java.io.PrintWriter;
import java.util.Vector;

import supersql.codegenerator.DecorateList;
import supersql.codegenerator.LocalEnv;
import supersql.codegenerator.TFE;
import supersql.common.Log;
import supersql.common.GlobalEnv;

public class CSVEnv extends LocalEnv {
    String data;

    String pre_operator;

    Vector written_classid;

    Vector not_written_classid;

    int total_element = 0;

    int glevel = 0;

    String filename;

    String outfile;

    String linkoutfile;

    String nextbackfile = new String();

    String outdir;

    int countfile;

    PrintWriter writer;

    StringBuffer code;

    StringBuffer header;

    StringBuffer footer;

    public CSVEnv() {
    }

    public String getEncode(){
    	String osname = System.getProperty("os.name");
    	if(osname.indexOf("Windows")>=0){
        	return "Shift_JIS";
    	}else{
    		return "EUC_JP";
    	}
    }
    public void getHeader() {
   		int index = 0;
    }

    public void getFooter() {

    }

    // outlineを�?力するかど�?��のフラグ設�?
    boolean OutlineMode = false;

    public void setOutlineMode() {
        OutlineMode = true;
    }

    public String getOutlineMode() {
        if (OutlineMode) {
            OutlineMode = false;
            return "";
        }
        //return " frame=void class=nest ";
      return " frame=void ";
    }

    public String getOutlineModeAtt() {
        if (OutlineMode) {
            OutlineMode = false;
            return " outline";
        }
        return "";
    }

    public static String getClassID(TFE tfe) {
    	String result;

        result =  "TFE" + tfe.getId();
        	return result;
    }

}