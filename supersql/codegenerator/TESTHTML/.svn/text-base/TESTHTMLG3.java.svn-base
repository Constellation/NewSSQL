/*
 * Created on 2004/07/25
 */
package supersql.codegenerator.TESTHTML;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class TESTHTMLG3 extends Grouper {

    Manager manager;

    TESTHTMLEnv html_env;
    TESTHTMLEnv html_env2;

    private String backfile = new String();

    private int countinstance = 0;

    //���󥹥ȥ饯��
    public TESTHTMLG3(Manager manager, TESTHTMLEnv henv, TESTHTMLEnv henv2) {
        this.manager = manager;
        this.html_env = henv;
        this.html_env2 = henv2;
    }

    //G3��work�᥽�å�
    @Override
	public void work(ExtList data_info) {
        String parentfile = html_env.filename;
        String parentnextbackfile = html_env.nextbackfile;
        StringBuffer parentcode = html_env.code;
        StringBuffer parentcss = html_env.css;
        StringBuffer parentheader = html_env.header;
        StringBuffer parentfooter = html_env.footer;
        String parentfile2 = html_env2.filename;
        String parentnextbackfile2 = html_env2.nextbackfile;
        StringBuffer parentcode2 = html_env2.code;
        StringBuffer parentcss2 = html_env2.css;
        StringBuffer parentheader2 = html_env2.header;
        StringBuffer parentfooter2 = html_env2.footer;
        int i = 0;
        Log.out("------- G3 -------");

        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        html_env2.css = new StringBuffer();
        html_env2.header = new StringBuffer();
        html_env2.footer = new StringBuffer();
        this.setDataList(data_info);
        while (this.hasMoreItems()) {
            html_env.glevel++;

            boolean b = tfe instanceof Attribute;
            html_env.code = new StringBuffer();
            html_env2.code = new StringBuffer();

            /*
             * ����Foreach func�Ǥʤ��?�����̤�G3
             */
            if (!html_env.foreach_flag) {
                backfile = html_env.nextbackfile;
                html_env.countfile++;
                countinstance++;
                html_env.filename = html_env.outfile
                        + String.valueOf(html_env.countfile) + ".html";
                html_env.nextbackfile = html_env.linkoutfile
                        + String.valueOf(html_env.countfile) + ".html";
            }

            html_env.setOutlineMode();
            this.worknextItem();

            if (!html_env.foreach_flag) {
                setLinkButton();
            }
            i++;
            html_env.glevel--;
            html_env.getHeader();
            html_env.getFooter();
            html_env2.header.append("<?xml version=\"1.0\" encoding=\""+html_env.getEncode()+"\"?><SSQL>");
            html_env2.footer.append("</SSQL>");

            try {
                PrintWriter pw = new PrintWriter(new BufferedWriter(
                        new FileWriter(html_env.filename)));
                pw.println(html_env.header);
                pw.println(html_env.code);
                pw.println(html_env.footer);
                pw.close();
                if(GlobalEnv.isOpt()){
	                html_env2.filename = html_env.filename.substring(0,html_env.filename.lastIndexOf(".html"))+".xml";
	                PrintWriter pw2 = new PrintWriter(new BufferedWriter(
	                        new FileWriter(html_env2.filename)));
	                pw2.println(html_env2.header);
	                pw2.println(html_env2.code);
	                pw2.println(html_env2.footer);
	                pw2.close();
	                TESTHTMLoptimizer xml = new TESTHTMLoptimizer();
	                String xml_str = xml.generateHtml(html_env2.filename);
	                pw = new PrintWriter(new BufferedWriter(new FileWriter(html_env.filename)));
					pw.println(html_env.header);
					pw.println(xml_str);
					StringBuffer footer = new StringBuffer("</div></body></html>");
					pw.println(footer);
					pw.close();
                }
                html_env.header = new StringBuffer();
                html_env.footer = new StringBuffer();
                html_env2.header = new StringBuffer();
                html_env2.footer = new StringBuffer();
            } catch (FileNotFoundException fe) {
                System.err.println("Error: specified outdirectory \""
                        + html_env.outdir + "\" is not found");
                GlobalEnv.addErr("Error: specified outdirectory \""
                        + html_env.outdir + "\" is not found");
                //comment out by chie
                //System.exit(-1);
            } catch (IOException e) {
                System.err.println("Error[HTMLG3]: File IO Error in HTMLG3");
                e.printStackTrace();
                GlobalEnv.addErr("Error[HTMLG3]: File IO Error in HTMLG3");
              //comment out by chie
                //System.exit(-1);
            }
        }

        html_env.filename = parentfile;
        html_env.code = parentcode;
        html_env.css = parentcss;
        html_env.header = parentheader;
        html_env.footer = parentfooter;
        html_env.nextbackfile = parentnextbackfile;
        html_env2.filename = parentfile2;
        html_env2.code = parentcode2;
        html_env2.css = parentcss2;
        html_env2.header = parentheader2;
        html_env2.footer = parentfooter2;
        html_env2.nextbackfile = parentnextbackfile2;

        Log.out("TFEId = " + TESTHTMLEnv.getClassID(this));
        html_env.append_css_def_td(TESTHTMLEnv.getClassID(this), this.decos);

    }

    private void setLinkButton() {
        String nextfile = new String();
        nextfile = html_env.linkoutfile
                + String.valueOf(html_env.countfile + 1) + ".html";
        html_env.code.append("<DIV class=\"linkbutton "
                + TESTHTMLEnv.getClassID(tfe) + "\">\n");
        if (countinstance > 1) {
            html_env.code.append("<A href=\"" + backfile + "\">");
            html_env.code.append("[back]");
            html_env.code.append("</A>\n");
        }
        if (this.hasMoreItems()) {
            html_env.code.append("<A href=\"" + nextfile + "\">");
            html_env.code.append("[next]");
            html_env.code.append("</A>\n");
        }
        html_env.code.append("</div>\n");

//        html_env.addLinkButtonCSS();

    }

    @Override
	public String getSymbol() {
        return "HTMLG3";
    }

}