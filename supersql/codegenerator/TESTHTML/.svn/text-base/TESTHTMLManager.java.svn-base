package supersql.codegenerator.TESTHTML;

import java.io.*;
import java.util.Vector;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class TESTHTMLManager extends Manager{

    //����
    TESTHTMLEnv html_env;
    TESTHTMLEnv html_env2;
    
    //���󥹥ȥ饯��
    public TESTHTMLManager(TESTHTMLEnv henv,TESTHTMLEnv henv2) {
        this.html_env = henv;
        this.html_env2 = henv2;
    }


    @Override
	public void generateCode(TFE tfe_info, ExtList data_info) {

        TESTHTMLEnv.initAllFormFlg();

        html_env.countfile = 0;
        html_env.code = new StringBuffer();
        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        html_env.foreach_flag = GlobalEnv.getForeachFlag();
        html_env.written_classid = new Vector();
        html_env.not_written_classid = new Vector();
        html_env2.countfile = 0;
        html_env2.code = new StringBuffer();
        html_env2.css = new StringBuffer();
        html_env2.header = new StringBuffer();
        html_env2.footer = new StringBuffer();
        html_env2.foreach_flag = GlobalEnv.getForeachFlag();
        html_env2.written_classid = new Vector<String>();
        TESTHTMLEnv localenv = new TESTHTMLEnv();
        
        /*** start oka ***/


        // ���Ϥ�?�ե���?̾����?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");
        
        // ?�ֳ�¦��G3��??
        if (tfe_info instanceof TESTHTMLG3) {
            tfe_info.work(data_info);
            return;
        }

        // ?�ֳ�¦��G3�Ǥʤ�??]
        html_env.filename = html_env.outfile + ".html";
        html_env2.filename = html_env.outfile + ".xml";
    	
        html_env.setOutlineMode();
        
        if(data_info.size() == 0)
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
        html_env2.header.append("<?xml version=\"1.0\" encoding=\""+html_env.getEncode()+"\"?><SSQL>");
        html_env2.footer.append("</SSQL>");
        try {
        	if(!GlobalEnv.isOpt()){
	        	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
	                    html_env.filename)));	            
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
	            
	            html_env2.filename = html_env.outfile + ".xml";
	            PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter(
	                    html_env2.filename)));
	            pw2.println(html_env2.header);
	            pw2.println(html_env2.code);
	            pw2.println(html_env2.footer);
	            pw2.close();
	            TESTHTMLoptimizer xml = new TESTHTMLoptimizer();
	            String xml_str =  xml.generateHtml(html_env2.filename); 
	        	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(
	                    html_env.filename)));
				pw.println(html_env.header);
				pw.println(xml_str);
				//StringBuffer footer = new StringBuffer("</div></body></html>");
				pw.println(html_env.footer);
				pw.close();
            }
            TESTHTMLEnv.initAllFormFlg();
        } catch (FileNotFoundException fe) {
        	fe.printStackTrace();
        	System.err.println("Error: specified outdirectory \""
                    + html_env.outdir + "\" is not found to write " + html_env.filename );
        	GlobalEnv.addErr("Error: specified outdirectory \""
                    + html_env.outdir + "\" is not found to write " + html_env.filename );
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

    //tk start///////////////////////////////////////////////////////////////////////
    @Override
	public StringBuffer generateCode2(TFE tfe_info, ExtList data_info) {
    	TESTHTMLEnv.initAllFormFlg();
    	
        html_env.countfile = 0;
        html_env.code = new StringBuffer();
        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        html_env.foreach_flag = GlobalEnv.getForeachFlag();
        html_env.written_classid = new Vector();
        html_env.embedflag = true;


        html_env2.countfile = 0;
        html_env2.code = new StringBuffer();
        html_env2.css = new StringBuffer();
        html_env2.header = new StringBuffer();
        html_env2.footer = new StringBuffer();
        String xml_str = null;
        StringBuffer returncode = new StringBuffer();
        // ���Ϥ�?�ե���?̾����?
        getOutfilename();
        
        Log.out("[HTMLManager:generateCode2]");
        
        // ?�ֳ�¦��G3��??
        if (tfe_info instanceof TESTHTMLG3) {
            tfe_info.work(data_info);
            return html_env.code;
        }
        // ?�ֳ�¦��G3�Ǥʤ�??
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
        	TESTHTMLoptimizer xml = new TESTHTMLoptimizer();
        	System.out.println(xml_string);
        	xml_str = xml.generateHtml(xml_string);   
        	returncode.append(xml_str);
        }
        html_env.embedflag = false;
        
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
    	TESTHTMLEnv.initAllFormFlg();
    	
        html_env.countfile = 0;
        html_env.code = new StringBuffer();
        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        html_env.foreach_flag = GlobalEnv.getForeachFlag();
        html_env.written_classid = new Vector();
        html_env.embedflag = true;
        // ���Ϥ�?�ե���?̾����?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");

        // ?�ֳ�¦��G3��??
        if (tfe_info instanceof TESTHTMLG3) {
            tfe_info.work(data_info);
            return html_env.code;
        }
        // ?�ֳ�¦��G3�Ǥʤ�??

        
        html_env.setOutlineMode();
        tfe_info.work(data_info);
//        html_env.getCSS();
        html_env.embedflag = false;
        Log.out("header : "+ html_env.header);
        return html_env.css;
    }
    
    @Override
	public StringBuffer generateCode4(TFE tfe_info, ExtList data_info) {
    	TESTHTMLEnv.initAllFormFlg();
        html_env.countfile = 0;
        html_env.code = new StringBuffer();
        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        html_env.foreach_flag = GlobalEnv.getForeachFlag();
        html_env.written_classid = new Vector();
        
        html_env2.countfile = 0;
        html_env2.code = new StringBuffer();
        html_env2.css = new StringBuffer();
        html_env2.header = new StringBuffer();
        html_env2.footer = new StringBuffer();
        html_env2.foreach_flag = GlobalEnv.getForeachFlag();
        html_env2.written_classid = new Vector<String>();
        
        TESTHTMLEnv localenv = new TESTHTMLEnv();

        // ���Ϥ�?�ե���?̾����?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");


        // ?�ֳ�¦��G3�Ǥʤ�??
        html_env.filename = html_env.outfile + ".html";
        html_env2.filename = html_env.outfile + ".xml";
        
        html_env.setOutlineMode();
        tfe_info.work(data_info);

        html_env.getHeader();
        html_env.getFooter();
        html_env.embedflag = false;
        Log.out("header : "+ html_env.header);
        
        StringBuffer headfoot = new StringBuffer(html_env.header + " ###split### " + html_env.footer);
        
        return headfoot;
    }  
  @Override
public StringBuffer generateCssfile(TFE tfe_info, ExtList data_info) {
    	
        html_env.countfile = 0;
        html_env.code = new StringBuffer();
        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        html_env.foreach_flag = GlobalEnv.getForeachFlag();
        html_env.written_classid = new Vector();
        html_env.embedflag = true;
        // ���Ϥ�?�ե���?̾����?
        getOutfilename();

        Log.out("[HTMLManager:generateCode]");
        
        html_env.setOutlineMode();
        tfe_info.work(data_info);
        html_env.embedflag = false;
        Log.out("header : "+ html_env.header);
        return html_env.cssfile;
    }
    //tk end///////////////////////////////////////////////////////////////////////////////
    
    private void getOutfilename() {
        String file = GlobalEnv.getfilename();
        String outdir = GlobalEnv.getoutdirectory();
        String outfile = GlobalEnv.getoutfilename();
        html_env.outdir = outdir;

        /*
         * ���ϥե���?(outfilename)�����ꤵ?�Ƥ�???
         * html_env.outfile��globalenv.outfilename�ˤ�?
         * ��?�ʳ��ΤȤ��ϥ���?�ե���?��̾��(filename)�ˤ�?
         */
        if (outfile == null) {
        	if (file.toLowerCase().indexOf(".sql")>0) {
        		html_env.outfile = file.substring(0, file.toLowerCase().indexOf(".sql"));
        	} else if (file.toLowerCase().indexOf(".ssql")>0) {
        		html_env.outfile = file.substring(0, file.toLowerCase().indexOf(".ssql"));
        	}
        } else {
            html_env.outfile = getOutfile(outfile);
        }

        if (html_env.outfile.indexOf("/") > 0) {
            html_env.linkoutfile = html_env.outfile.substring(html_env.outfile
                    .lastIndexOf("/") + 1);
        } else {
            html_env.linkoutfile = html_env.outfile;
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
         * ������ǥ�?����?(outdirectory)�����ꤵ?�Ƥ�???
         * outdirectory��filename��Ĥʤ�����Τ�file�Ȥ�?
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
        String tmpqueryfile = new String();
        if (html_env.outfile.indexOf("/") > 0) {
            if (outfile != null) {
                if (html_env.outfile.startsWith(".")
                        || html_env.outfile.startsWith("/")) {
                    tmpqueryfile = html_env.outfile.substring(html_env.outfile
                            .indexOf("/") + 1);
                }
            } else {
                tmpqueryfile = html_env.outfile.substring(html_env.outfile
                        .lastIndexOf("/") + 1);
            }
        } else {
            tmpqueryfile = html_env.outfile;
        }
        if (!outdir.endsWith("/")) {
            outdir = outdir.concat("/");
        }
        html_env.outfile = outdir.concat(tmpqueryfile);
    }

    @Override
	public void finish() {

    }
}