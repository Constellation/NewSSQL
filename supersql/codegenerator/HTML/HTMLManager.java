package supersql.codegenerator.HTML;

import java.io.*;
import java.util.Vector;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.common.Utils;
import supersql.dataconstructor.DataConstructor;
import supersql.extendclass.ExtList;

public class HTMLManager extends Manager{

    //メンバ
    HTMLEnv html_env;
    HTMLEnv html_env2;

    //コンストラクタ
    public HTMLManager(HTMLEnv henv,HTMLEnv henv2) {
        this.html_env = henv;
        this.html_env2 = henv2;
    }


    @Override
	public void generateCode(TFE tfe_info, ExtList data_info) {

        HTMLEnv.initAllFormFlg();

        html_env.countFile = 0;
        html_env.code = new StringBuffer();
        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        html_env.foreachFlag = GlobalEnv.getForeachFlag();
        html_env.writtenClassId = new Vector();
        html_env.notWrittenClassId = new Vector();
        html_env2.countFile = 0;
        html_env2.code = new StringBuffer();
        html_env2.css = new StringBuffer();
        html_env2.header = new StringBuffer();
        html_env2.footer = new StringBuffer();
        html_env2.foreachFlag = GlobalEnv.getForeachFlag();
        html_env2.writtenClassId = new Vector<String>();
        HTMLEnv localenv = new HTMLEnv();

        /*** start oka ***/


        // 出力す?ファイ?名の設?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");

        // ?番外側がG3の??
        if (tfe_info instanceof HTMLG3) {
            tfe_info.work(data_info);
            return;
        }

        // ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??]
        html_env.fileName = html_env.outFile + ".html";
        html_env2.fileName = html_env.outFile + ".xml";

        html_env.setOutlineMode();

        if(data_info.size() == 0
            //added by goto 20130306  "FROMなしクエリ対策 3/3"
           	&& !DataConstructor.SQL_string.equals("SELECT DISTINCT  FROM ;"))
        {
        	Log.out("no data");
        	html_env.code.append("<div class=\"nodata\" >");
        	html_env.code.append("NO DATA FOUND");
        	html_env.code.append("</div>");
        }
        else
        	tfe_info.work(data_info);

        html_env.getHeader();
        html_env.getFooter();
        html_env2.header.append("<?xml version=\"1.0\" encoding=\""+Utils.getEncode()+"\"?><SSQL>");
        html_env2.footer.append("</SSQL>");
        try {
        	if(!GlobalEnv.isOpt()){
        		//changed by goto 20120715 start
	        	//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
	            //        html_env.filename)));
        		PrintWriter pw;
	            if (html_env.charset != null){
		        	pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
		        			new FileOutputStream(html_env.fileName),html_env.charset)));
		        	Log.info("File encoding: "+html_env.charset);
	            }else
	            	pw = new PrintWriter(new BufferedWriter(new FileWriter(
	        	                    html_env.fileName)));
	            //Log.info("File encoding: "+((html_env.charset!=null)? html_env.charset : "UTF-8"));
        		//changed by goto 20120715 end
	            	
	        	if(GlobalEnv.cssout()==null)
	        		pw.println(html_env.header);
	            pw.println(html_env.code);
	            pw.println(html_env.footer);
	            pw.close();
        	}
            //xml
	        if(GlobalEnv.isOpt()){

            	/*
            	int i=0;
	            while(html_env2.code.indexOf("&",i) != -1){
	            	i = html_env2.code.indexOf("&",i);
	            	html_env2.code = html_env2.code.replace(i,i+1, "&amp;");
	            	i++;
	            }
	            */

	            html_env2.fileName = html_env.outFile + ".xml";
	            PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter(
	                    html_env2.fileName)));
	            if(GlobalEnv.cssout()==null)
	            	pw2.println(html_env2.header);
	            pw2.println(html_env2.code);
	            pw2.println(html_env2.footer);
	            pw2.close();
	            HTMLoptimizer xml = new HTMLoptimizer();
	            String xml_str =  xml.generateHtml(html_env2.fileName);
	        	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
	                    html_env.fileName)));
				pw.println(html_env.header);
				pw.println(xml_str);
				//StringBuffer footer = new StringBuffer("</div></body></html>");
				pw.println(html_env.footer);
				pw.close();
            }

	        if(GlobalEnv.cssout()!=null){
	        	PrintWriter pw3 = new PrintWriter(new BufferedWriter(new FileWriter(
	        			GlobalEnv.cssout())));
	            pw3.println(html_env.header);
	            pw3.close();
	        }

            HTMLEnv.initAllFormFlg();
        } catch (FileNotFoundException fe) {
        	fe.printStackTrace();
        	System.err.println("Error: specified outdirectory \""
                    + html_env.outDir + "\" is not found to write " + html_env.fileName );
        	GlobalEnv.addErr("Error: specified outdirectory \""
                    + html_env.outDir + "\" is not found to write " + html_env.fileName );
        	//comment out by chie
        	//System.exit(-1);
        } catch (IOException e) {
            System.err.println("Error[HTMLManager]: File IO Error in HTMLManager");
            e.printStackTrace();
           	GlobalEnv.addErr("Error[HTMLManager]: File IO Error in HTMLManager");
            //comment out by chie
        	//System.exit(-1);
        }

    }

    private int lastIndexOf(String string) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}


	private int indexOf(String string) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}


	//tk start///////////////////////////////////////////////////////////////////////
    @Override
	public StringBuffer generateCode2(TFE tfe_info, ExtList data_info) {
    	HTMLEnv.initAllFormFlg();

        html_env.countFile = 0;
        html_env.code = new StringBuffer();
        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        html_env.foreachFlag = GlobalEnv.getForeachFlag();
        html_env.writtenClassId = new Vector();
        html_env.embedFlag = true;


        html_env2.countFile = 0;
        html_env2.code = new StringBuffer();
        html_env2.css = new StringBuffer();
        html_env2.header = new StringBuffer();
        html_env2.footer = new StringBuffer();
        String xml_str = null;
        StringBuffer returncode = new StringBuffer();
        // 出力す?ファイ?名の設?
        getOutfilename();

        Log.out("[HTMLManager:generateCode2]");

        // ?番外側がG3の??
        if (tfe_info instanceof HTMLG3) {
            tfe_info.work(data_info);
            return html_env.code;
        }
        // ?番外側がG3でない??
        html_env.setOutlineMode();
        tfe_info.work(data_info);

        html_env2.header.append("<?xml version=\"1.0\" encoding=\"Shift_JIS\"?><SSQL>");
        html_env2.footer.append("</SSQL>");


        if(GlobalEnv.isOpt()){
        	int i=0;
            while(html_env2.code.indexOf("&",i) != -1){
            	i = html_env2.code.indexOf("&",i);
            	html_env2.code = html_env2.code.replace(i,i+1, "&amp;");
            	i++;
            }
        	StringBuffer xml_string = new StringBuffer();
        	xml_string.append(html_env2.header);
        	xml_string.append(html_env2.code);
        	xml_string.append(html_env2.footer);
        	HTMLoptimizer xml = new HTMLoptimizer();
        	//System.out.println(xml_string);		//commented out by goto 20120620
        	xml_str = xml.generateHtml(xml_string);
        	returncode.append(xml_str);
        }
        html_env.embedFlag = false;

        if(html_env.script.length() >= 5)
        {
        	StringBuffer result = new StringBuffer();

        	result.append(html_env.script);
        	result.append("<end of script>\n");
        	result.append(html_env.code);

        	return result;
        }
        else
        {
	        if(GlobalEnv.isOpt())
	        	return returncode;
	        else
	        	return html_env.code;

        }
    }
    @Override
	public StringBuffer generateCodeNotuple(TFE tfe_info) {
    		Log.out("no data found");
    	html_env.code = new StringBuffer();
    	html_env.code.append("<div class=\"nodata\" >");
    	html_env.code.append("NO DATA FOUND");
    	html_env.code.append("</div>");

    	return html_env.code;
    }

    @Override
	public StringBuffer generateCode3(TFE tfe_info, ExtList data_info) {
    	HTMLEnv.initAllFormFlg();

        html_env.countFile = 0;
        html_env.code = new StringBuffer();
        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        html_env.foreachFlag = GlobalEnv.getForeachFlag();
        html_env.writtenClassId = new Vector();
        html_env.embedFlag = true;
        // 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");

        // ?番外側がG3の??
        if (tfe_info instanceof HTMLG3) {
            tfe_info.work(data_info);
            return html_env.code;
        }
        // ?番外側がG3でない??


        html_env.setOutlineMode();
        tfe_info.work(data_info);
//        html_env.getCSS();
        html_env.embedFlag = false;
        Log.out("header : "+ html_env.header);
        return html_env.css;
    }

    @Override
	public StringBuffer generateCode4(TFE tfe_info, ExtList data_info) {
    	HTMLEnv.initAllFormFlg();
        html_env.countFile = 0;
        html_env.code = new StringBuffer();
        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        html_env.foreachFlag = GlobalEnv.getForeachFlag();
        html_env.writtenClassId = new Vector();

        html_env2.countFile = 0;
        html_env2.code = new StringBuffer();
        html_env2.css = new StringBuffer();
        html_env2.header = new StringBuffer();
        html_env2.footer = new StringBuffer();
        html_env2.foreachFlag = GlobalEnv.getForeachFlag();
        html_env2.writtenClassId = new Vector<String>();

        HTMLEnv localenv = new HTMLEnv();

        // 出力す?ファイ?名の設?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");


        // ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??
        html_env.fileName = html_env.outFile + ".html";
        html_env2.fileName = html_env.outFile + ".xml";

        html_env.setOutlineMode();
        tfe_info.work(data_info);

        html_env.getHeader();
        html_env.getFooter();
        html_env.embedFlag = false;
        Log.out("header : "+ html_env.header);

        StringBuffer headfoot = new StringBuffer(html_env.header + " ###split### " + html_env.footer);

        return headfoot;
    }
  @Override
public StringBuffer generateCssfile(TFE tfe_info, ExtList data_info) {

        html_env.countFile = 0;
        html_env.code = new StringBuffer();
        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        html_env.foreachFlag = GlobalEnv.getForeachFlag();
        html_env.writtenClassId = new Vector();
        html_env.embedFlag = true;
        // 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");

        html_env.setOutlineMode();
        tfe_info.work(data_info);
        html_env.embedFlag = false;
        Log.out("header : "+ html_env.header);
        return html_env.cssFile;
    }
    //tk end///////////////////////////////////////////////////////////////////////////////

    protected void getOutfilename() {
        String file = GlobalEnv.getfilename();
        String outdir = GlobalEnv.getoutdirectory();
        String outfile = GlobalEnv.getoutfilename();
        html_env.outDir = outdir;

        /*
         * 出力ファイ?(outfilename)が指定さ?てい???
         * html_env.outfileをglobalenv.outfilenameにす?
         * そ?以外のときはクエ?ファイ?の名前(filename)にす?
         */
        if (GlobalEnv.getQuery()!=null) {
        	html_env.outFile = "./fromquery";

        }else if (outfile == null) {
        	if (file.toLowerCase().indexOf(".sql")>0) {
        		html_env.outFile = file.substring(0, file.toLowerCase().indexOf(".sql"));
        	} else if (file.toLowerCase().indexOf(".ssql")>0) {
        		html_env.outFile = file.substring(0, file.toLowerCase().indexOf(".ssql"));
        	}
        } else {
            html_env.outFile = getOutfile(outfile);
        }

        if (html_env.outFile.indexOf("/") > 0) {
            html_env.linkOutFile = html_env.outFile.substring(html_env.outFile
                    .lastIndexOf("/") + 1);
        } else {
            html_env.linkOutFile = html_env.outFile;
        }
/*
        //tk start
        if(html_env.outfile.lastIndexOf("\\") != -1)
        {
        	html_env.outfile = html_env.outfile.substring(html_env.outfile.lastIndexOf("\\"));
        	Log.out("outfile log:"+html_env.outfile);
        }
        //tk end
  */
        /*
         * 出力先ディ?クト?(outdirectory)が指定さ?てい???
         * outdirectoryとfilenameをつなげたものをfileとす?
         */
 
        
        
        if (outdir != null) {
            connectOutdir(outdir, outfile);
        }
    }

    private String getOutfile(String outfile) {
        String out = new String();
        if (outfile.indexOf(".html") > 0) {
            out = outfile.substring(0, outfile.indexOf(".html"));
        } else {
            out = outfile;
        }
        return out;
    }

    private void connectOutdir(String outdir, String outfile) {
    	//added by goto 20120627 start
		String fileDir = new File(html_env.outFile).getAbsoluteFile().getParent();
		if(fileDir.length() < html_env.outFile.length()
		&& fileDir.equals(html_env.outFile.substring(0,fileDir.length())))
			html_env.outFile = html_env.outFile.substring(fileDir.length()+1);	//鐃緒申鐃出パワ申鐃春ワ申鐃緒申鐃緒申名
    	//added by goto 20120627 end
    	
        String tmpqueryfile = new String();
        if (html_env.outFile.indexOf("/") > 0) {
            if (outfile != null) {
                if (html_env.outFile.startsWith(".")
                        || html_env.outFile.startsWith("/")) {
                    tmpqueryfile = html_env.outFile.substring(html_env.outFile
                            .indexOf("/") + 1);
                }
            } else {
                tmpqueryfile = html_env.outFile.substring(html_env.outFile
                        .lastIndexOf("/") + 1);
            }
        } else {
            tmpqueryfile = html_env.outFile;
        }
        if (!outdir.endsWith("/")) {
            outdir = outdir.concat("/");
        }
        html_env.outFile = outdir.concat(tmpqueryfile);
    }

    @Override
	public void finish() {

    }
}
