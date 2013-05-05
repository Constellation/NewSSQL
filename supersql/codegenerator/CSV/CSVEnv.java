package supersql.codegenerator.CSV;

import supersql.codegenerator.ITFE;
import supersql.codegenerator.LocalEnv;

public class CSVEnv extends LocalEnv {
	protected int glevel = 0;

	protected String filename;

	protected String outfile;

	protected String linkoutfile;

	protected String outdir;

	protected int countfile;

	protected StringBuffer code;

	protected StringBuffer header;

	protected StringBuffer footer;

	boolean OutlineMode = false;

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

    public static String getClassID(ITFE tfe) {
    	String result;

        result =  "TFE" + tfe.getId();
        	return result;
    }

}