package supersql.codegenerator.HTML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Vector;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.common.Utils;
import supersql.dataconstructor.DataConstructor;
import supersql.extendclass.ExtList;

public class HTMLManager extends Manager{

    private HTMLEnv htmlEnv;
    private HTMLEnv htmlEnv2;

    public HTMLManager(HTMLEnv henv,HTMLEnv henv2) {
        this.htmlEnv = henv;
        this.htmlEnv2 = henv2;
    }
    
    @Override
    public Object generateCodeForJsoup(ITFE tfe_info, ExtList data_info){
    	HTMLEnv.initAllFormFlg();

        HTMLEnv.countFile = 0;
        htmlEnv.code = new StringBuffer();
        htmlEnv.css = new StringBuffer();
        htmlEnv.header = new StringBuffer();
        htmlEnv.footer = new StringBuffer();
        htmlEnv.foreachFlag = GlobalEnv.getForeachFlag();
        htmlEnv.writtenClassId = new Vector();
        htmlEnv.notWrittenClassId = new Vector();
        Document result = htmlEnv.getHtmlEnv1();
        
        getOutfilename();

        if (tfe_info instanceof HTMLG3) {
        	tfe_info.createNode(data_info);
        	return result;
        }

        htmlEnv.fileName = htmlEnv.outFile + ".html";

        htmlEnv.setOutlineMode();
        
        if(data_info.size() == 0
           	&& !DataConstructor.SQL_string.equals("SELECT DISTINCT  FROM ;")  && !DataConstructor.SQL_string.equals("SELECT  FROM ;"))
        {
        	Log.out("no data");
        	return new Document("").body().append("NO DATA FOUND");
        }
        else
        	result.body().appendChild((Element)tfe_info.createNode(data_info));

        htmlEnv.createHeader();
        htmlEnv.createFooter();
        try {
	        if(GlobalEnv.cssout()!=null){
	        	PrintWriter pw3 = new PrintWriter(new BufferedWriter(new FileWriter(
	        			GlobalEnv.cssout())));
	            pw3.println(htmlEnv.header);
	            pw3.close();
	        }

            HTMLEnv.initAllFormFlg();
        } catch (FileNotFoundException fe) {
        	fe.printStackTrace();
        	System.err.println("Error: specified outdirectory \""
                    + htmlEnv.outDir + "\" is not found to write " + htmlEnv.fileName );
        	GlobalEnv.addErr("Error: specified outdirectory \""
                    + htmlEnv.outDir + "\" is not found to write " + htmlEnv.fileName );
        } catch (IOException e) {
            System.err.println("Error[HTMLManager]: File IO Error in HTMLManager");
            e.printStackTrace();
           	GlobalEnv.addErr("Error[HTMLManager]: File IO Error in HTMLManager");
        }
        return result;
    }


    @Override
	public void generateCode(ITFE tfe_info, ExtList data_info) {

        HTMLEnv.initAllFormFlg();

        htmlEnv.countFile = 0;
        htmlEnv.code = new StringBuffer();
        htmlEnv.css = new StringBuffer();
        htmlEnv.header = new StringBuffer();
        htmlEnv.footer = new StringBuffer();
        htmlEnv.foreachFlag = GlobalEnv.getForeachFlag();
        htmlEnv.writtenClassId = new Vector();
        htmlEnv.notWrittenClassId = new Vector();
        htmlEnv2.countFile = 0;
        htmlEnv2.code = new StringBuffer();
        htmlEnv2.css = new StringBuffer();
        htmlEnv2.header = new StringBuffer();
        htmlEnv2.footer = new StringBuffer();
        htmlEnv2.foreachFlag = GlobalEnv.getForeachFlag();
        htmlEnv2.writtenClassId = new Vector<String>();
        HTMLEnv localenv = new HTMLEnv();

        /*** start oka ***/


        // 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");

        // ?鐃瞬鰹申側鐃緒申G3鐃緒申??
        if (tfe_info instanceof HTMLG3) {
            tfe_info.work(data_info);
            return;
        }

        // ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??]
        htmlEnv.fileName = htmlEnv.outFile + ".html";
        htmlEnv2.fileName = htmlEnv.outFile + ".xml";

        htmlEnv.setOutlineMode();

        if(data_info.size() == 0
            //added by goto 20130306  "FROM鐃淑わ申鐃緒申鐃緒申鐃緒申鐃出削申 3/3"
           	&& !DataConstructor.SQL_string.equals("SELECT DISTINCT  FROM ;")  && !DataConstructor.SQL_string.equals("SELECT  FROM ;"))
        {
        	Log.out("no data");
        	htmlEnv.code.append("<div class=\"nodata\" >");
        	htmlEnv.code.append("NO DATA FOUND");
        	htmlEnv.code.append("</div>");
        }
        else
        	tfe_info.work(data_info);

        htmlEnv.getHeader();
        htmlEnv.getFooter();
        htmlEnv2.header.append("<?xml version=\"1.0\" encoding=\""+Utils.getEncode()+"\"?><SSQL>");
        htmlEnv2.footer.append("</SSQL>");
        try {
        	if(!GlobalEnv.isOpt()){
        		//changed by goto 20120715 start
	        	//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
	            //        html_env.filename)));
        		PrintWriter pw;
	            if (htmlEnv.charset != null){
		        	pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
		        			new FileOutputStream(htmlEnv.fileName),htmlEnv.charset)));
		        	Log.info("File encoding: "+htmlEnv.charset);
	            }else
	            	pw = new PrintWriter(new BufferedWriter(new FileWriter(
	        	                    htmlEnv.fileName)));
	            //Log.info("File encoding: "+((html_env.charset!=null)? html_env.charset : "UTF-8"));
        		//changed by goto 20120715 end
	            	
	        	if(GlobalEnv.cssout()==null)
	        		pw.println(htmlEnv.header);
	            pw.println(htmlEnv.code);
	            pw.println(htmlEnv.footer);
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

	            htmlEnv2.fileName = htmlEnv.outFile + ".xml";
	            PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter(
	                    htmlEnv2.fileName)));
	            if(GlobalEnv.cssout()==null)
	            	pw2.println(htmlEnv2.header);
	            pw2.println(htmlEnv2.code);
	            pw2.println(htmlEnv2.footer);
	            pw2.close();
	            HTMLoptimizer xml = new HTMLoptimizer();
	            String xml_str =  xml.generateHtml(htmlEnv2.fileName);
	        	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
	                    htmlEnv.fileName)));
				pw.println(htmlEnv.header);
				pw.println(xml_str);
				//StringBuffer footer = new StringBuffer("</div></body></html>");
				pw.println(htmlEnv.footer);
				pw.close();
            }

	        if(GlobalEnv.cssout()!=null){
	        	PrintWriter pw3 = new PrintWriter(new BufferedWriter(new FileWriter(
	        			GlobalEnv.cssout())));
	            pw3.println(htmlEnv.header);
	            pw3.close();
	        }

            HTMLEnv.initAllFormFlg();
        } catch (FileNotFoundException fe) {
        	fe.printStackTrace();
        	System.err.println("Error: specified outdirectory \""
                    + htmlEnv.outDir + "\" is not found to write " + htmlEnv.fileName );
        	GlobalEnv.addErr("Error: specified outdirectory \""
                    + htmlEnv.outDir + "\" is not found to write " + htmlEnv.fileName );
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
		// TODO 鐃緒申動鐃緒申鐃緒申鐃緒申鐃曙た鐃潤ソ鐃獣ド￥申鐃緒申鐃緒申鐃緒申
		return 0;
	}


	private int indexOf(String string) {
		// TODO 鐃緒申動鐃緒申鐃緒申鐃緒申鐃曙た鐃潤ソ鐃獣ド￥申鐃緒申鐃緒申鐃緒申
		return 0;
	}


	//tk start///////////////////////////////////////////////////////////////////////
    @Override
	public StringBuffer generateCode2(ITFE tfe_info, ExtList data_info) {
    	HTMLEnv.initAllFormFlg();

        htmlEnv.countFile = 0;
        htmlEnv.code = new StringBuffer();
        htmlEnv.css = new StringBuffer();
        htmlEnv.header = new StringBuffer();
        htmlEnv.footer = new StringBuffer();
        htmlEnv.foreachFlag = GlobalEnv.getForeachFlag();
        htmlEnv.writtenClassId = new Vector();
        htmlEnv.embedFlag = true;


        htmlEnv2.countFile = 0;
        htmlEnv2.code = new StringBuffer();
        htmlEnv2.css = new StringBuffer();
        htmlEnv2.header = new StringBuffer();
        htmlEnv2.footer = new StringBuffer();
        String xml_str = null;
        StringBuffer returncode = new StringBuffer();
        // 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
        getOutfilename();

        Log.out("[HTMLManager:generateCode2]");

        // ?鐃瞬鰹申側鐃緒申G3鐃緒申??
        if (tfe_info instanceof HTMLG3) {
            tfe_info.work(data_info);
            return htmlEnv.code;
        }
        // ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??
        htmlEnv.setOutlineMode();
        tfe_info.work(data_info);

        htmlEnv2.header.append("<?xml version=\"1.0\" encoding=\"Shift_JIS\"?><SSQL>");
        htmlEnv2.footer.append("</SSQL>");


        if(GlobalEnv.isOpt()){
        	int i=0;
            while(htmlEnv2.code.indexOf("&",i) != -1){
            	i = htmlEnv2.code.indexOf("&",i);
            	htmlEnv2.code = htmlEnv2.code.replace(i,i+1, "&amp;");
            	i++;
            }
        	StringBuffer xml_string = new StringBuffer();
        	xml_string.append(htmlEnv2.header);
        	xml_string.append(htmlEnv2.code);
        	xml_string.append(htmlEnv2.footer);
        	HTMLoptimizer xml = new HTMLoptimizer();
        	//System.out.println(xml_string);		//commented out by goto 20120620
        	xml_str = xml.generateHtml(xml_string);
        	returncode.append(xml_str);
        }
        htmlEnv.embedFlag = false;

        if(htmlEnv.script.length() >= 5)
        {
        	StringBuffer result = new StringBuffer();

        	result.append(htmlEnv.script);
        	result.append("<end of script>\n");
        	result.append(htmlEnv.code);

        	return result;
        }
        else
        {
	        if(GlobalEnv.isOpt())
	        	return returncode;
	        else
	        	return htmlEnv.code;

        }
    }
    @Override
	public StringBuffer generateCodeNotuple(ITFE tfe_info) {
    		Log.out("no data found");
    	htmlEnv.code = new StringBuffer();
    	htmlEnv.code.append("<div class=\"nodata\" >");
    	htmlEnv.code.append("NO DATA FOUND");
    	htmlEnv.code.append("</div>");

    	return htmlEnv.code;
    }

    @Override
	public StringBuffer generateCode3(ITFE tfe_info, ExtList data_info) {
    	HTMLEnv.initAllFormFlg();

        htmlEnv.countFile = 0;
        htmlEnv.code = new StringBuffer();
        htmlEnv.css = new StringBuffer();
        htmlEnv.header = new StringBuffer();
        htmlEnv.footer = new StringBuffer();
        htmlEnv.foreachFlag = GlobalEnv.getForeachFlag();
        htmlEnv.writtenClassId = new Vector();
        htmlEnv.embedFlag = true;
        // 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");

        // ?鐃瞬鰹申側鐃緒申G3鐃緒申??
        if (tfe_info instanceof HTMLG3) {
            tfe_info.work(data_info);
            return htmlEnv.code;
        }
        // ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??


        htmlEnv.setOutlineMode();
        tfe_info.work(data_info);
//        html_env.getCSS();
        htmlEnv.embedFlag = false;
        Log.out("header : "+ htmlEnv.header);
        return htmlEnv.css;
    }

    @Override
	public StringBuffer generateCode4(ITFE tfe_info, ExtList data_info) {
    	HTMLEnv.initAllFormFlg();
        htmlEnv.countFile = 0;
        htmlEnv.code = new StringBuffer();
        htmlEnv.css = new StringBuffer();
        htmlEnv.header = new StringBuffer();
        htmlEnv.footer = new StringBuffer();
        htmlEnv.foreachFlag = GlobalEnv.getForeachFlag();
        htmlEnv.writtenClassId = new Vector();

        htmlEnv2.countFile = 0;
        htmlEnv2.code = new StringBuffer();
        htmlEnv2.css = new StringBuffer();
        htmlEnv2.header = new StringBuffer();
        htmlEnv2.footer = new StringBuffer();
        htmlEnv2.foreachFlag = GlobalEnv.getForeachFlag();
        htmlEnv2.writtenClassId = new Vector<String>();

        HTMLEnv localenv = new HTMLEnv();

        // 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");


        // ?鐃瞬鰹申側鐃緒申G3鐃叔なわ申??
        htmlEnv.fileName = htmlEnv.outFile + ".html";
        htmlEnv2.fileName = htmlEnv.outFile + ".xml";

        htmlEnv.setOutlineMode();
        tfe_info.work(data_info);

        htmlEnv.getHeader();
        htmlEnv.getFooter();
        htmlEnv.embedFlag = false;
        Log.out("header : "+ htmlEnv.header);

        StringBuffer headfoot = new StringBuffer(htmlEnv.header + " ###split### " + htmlEnv.footer);

        return headfoot;
    }
  @Override
public StringBuffer generateCssfile(ITFE tfe_info, ExtList data_info) {

        htmlEnv.countFile = 0;
        htmlEnv.code = new StringBuffer();
        htmlEnv.css = new StringBuffer();
        htmlEnv.header = new StringBuffer();
        htmlEnv.footer = new StringBuffer();
        htmlEnv.foreachFlag = GlobalEnv.getForeachFlag();
        htmlEnv.writtenClassId = new Vector();
        htmlEnv.embedFlag = true;
        // 鐃緒申鐃熟わ申?鐃春ワ申鐃緒申?名鐃緒申鐃緒申?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");

        htmlEnv.setOutlineMode();
        tfe_info.work(data_info);
        htmlEnv.embedFlag = false;
        Log.out("header : "+ htmlEnv.header);
        return htmlEnv.cssFile;
    }
    //tk end///////////////////////////////////////////////////////////////////////////////

    protected void getOutfilename() {
        String file = GlobalEnv.getfilename();
        String outdir = GlobalEnv.getoutdirectory();
        String outfile = GlobalEnv.getoutfilename();
        htmlEnv.outDir = outdir;

        /*
         * 鐃緒申鐃熟フワ申鐃緒申?(outfilename)鐃緒申鐃緒申鐃所さ?鐃銃わ申???
         * html_env.outfile鐃緒申globalenv.outfilename鐃祝わ申?
         * 鐃緒申?鐃淑鰹申鐃塾とわ申鐃熟ワ申鐃緒申?鐃春ワ申鐃緒申?鐃緒申名鐃緒申(filename)鐃祝わ申?
         */
        if (GlobalEnv.getQuery()!=null) {
        	htmlEnv.outFile = "./fromquery";

        }else if (outfile == null) {
        	if (file.toLowerCase().indexOf(".sql")>0) {
        		htmlEnv.outFile = file.substring(0, file.toLowerCase().indexOf(".sql"));
        	} else if (file.toLowerCase().indexOf(".ssql")>0) {
        		htmlEnv.outFile = file.substring(0, file.toLowerCase().indexOf(".ssql"));
        	}
        } else {
            htmlEnv.outFile = getOutfile(outfile);
        }

        if (htmlEnv.outFile.indexOf("/") > 0) {
            htmlEnv.linkOutFile = htmlEnv.outFile.substring(htmlEnv.outFile
                    .lastIndexOf("/") + 1);
        } else {
            htmlEnv.linkOutFile = htmlEnv.outFile;
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
         * 鐃緒申鐃緒申鐃緒申妊鐃�鐃緒申鐃緒申?(outdirectory)鐃緒申鐃緒申鐃所さ?鐃銃わ申???
         * outdirectory鐃緒申filename鐃緒申弔覆鐃緒申鐃緒申鐃塾わ申file鐃夙わ申?
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
		String fileDir = new File(htmlEnv.outFile).getAbsoluteFile().getParent();
		if(fileDir.length() < htmlEnv.outFile.length()
		&& fileDir.equals(htmlEnv.outFile.substring(0,fileDir.length())))
			htmlEnv.outFile = htmlEnv.outFile.substring(fileDir.length()+1);	//鐃緒申鐃出パワ申鐃春ワ申鐃緒申鐃緒申名
    	//added by goto 20120627 end
    	
        String tmpqueryfile = new String();
        if (htmlEnv.outFile.indexOf("/") > 0) {
            if (outfile != null) {
                if (htmlEnv.outFile.startsWith(".")
                        || htmlEnv.outFile.startsWith("/")) {
                    tmpqueryfile = htmlEnv.outFile.substring(htmlEnv.outFile
                            .indexOf("/") + 1);
                }
            } else {
                tmpqueryfile = htmlEnv.outFile.substring(htmlEnv.outFile
                        .lastIndexOf("/") + 1);
            }
        } else {
            tmpqueryfile = htmlEnv.outFile;
        }
        if (!outdir.endsWith("/")) {
            outdir = outdir.concat("/");
        }
        htmlEnv.outFile = outdir.concat(tmpqueryfile);
    }

    @Override
	public void finish() {

    }
}
