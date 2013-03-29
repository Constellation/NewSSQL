/*
 * Created on 2004/07/25
 */
package supersql.codegenerator.HTML5;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import supersql.codegenerator.*;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTML5G3 extends Grouper {

    Manager manager;

    HTML5Env html5_env;
    HTML5Env html5_env2;

    private String backfile = new String();

    private int countinstance = 0;

    //���󥹥ȥ饯��
    public HTML5G3(Manager manager, HTML5Env henv, HTML5Env henv2) {
        this.manager = manager;
        this.html5_env = henv;
        this.html5_env2 = henv2;
    }

    //G3��work�᥽�å�
    @Override
	public void work(ExtList data_info) {
        String parentfile = html5_env.filename;
        String parentnextbackfile = html5_env.nextbackfile;
        StringBuffer parentcode = html5_env.code;
        StringBuffer parentcss = html5_env.css;
        StringBuffer parentheader = html5_env.header;
        StringBuffer parentfooter = html5_env.footer;
        String parentfile2 = html5_env2.filename;
        String parentnextbackfile2 = html5_env2.nextbackfile;
        StringBuffer parentcode2 = html5_env2.code;
        StringBuffer parentcss2 = html5_env2.css;
        StringBuffer parentheader2 = html5_env2.header;
        StringBuffer parentfooter2 = html5_env2.footer;
        int i = 0;
        Log.out("------- G3 -------");

        html5_env.css = new StringBuffer();
        html5_env.header = new StringBuffer();
        html5_env.footer = new StringBuffer();
        html5_env2.css = new StringBuffer();
        html5_env2.header = new StringBuffer();
        html5_env2.footer = new StringBuffer();
        this.setDataList(data_info);
        while (this.hasMoreItems()) {
            html5_env.glevel++;

            boolean b = tfe instanceof Attribute;
            html5_env.code = new StringBuffer();
            html5_env2.code = new StringBuffer();

            /*
             * ����Foreach func�Ǥʤ��?�����̤�G3
             */
            if (!html5_env.foreach_flag) {
                backfile = html5_env.nextbackfile;
                html5_env.countfile++;
                countinstance++;
                html5_env.filename = html5_env.outfile
                        + String.valueOf(html5_env.countfile) + ".html";
                html5_env.nextbackfile = html5_env.linkoutfile
                        + String.valueOf(html5_env.countfile) + ".html";
            }

            html5_env.setOutlineMode();
            this.worknextItem();

            if (!html5_env.foreach_flag) {
                setLinkButton();
            }
            i++;
            html5_env.glevel--;
            html5_env.getHeader();
            html5_env.getFooter();
            html5_env2.header.append("<?xml version=\"1.0\" encoding=\""+html5_env.getEncode()+"\"?><SSQL>");
            html5_env2.footer.append("</SSQL>");

            try {
                PrintWriter pw = new PrintWriter(new BufferedWriter(
                        new FileWriter(html5_env.filename)));
                pw.println(html5_env.header);
                pw.println(html5_env.code);
                pw.println(html5_env.footer);
                pw.close();
                if(GlobalEnv.isOpt()){
	                html5_env2.filename = html5_env.filename.substring(0,html5_env.filename.lastIndexOf(".html"))+".xml";
	                PrintWriter pw2 = new PrintWriter(new BufferedWriter(
	                        new FileWriter(html5_env2.filename)));
	                pw2.println(html5_env2.header);
	                pw2.println(html5_env2.code);
	                pw2.println(html5_env2.footer);
	                pw2.close();
	                HTML5optimizer xml = new HTML5optimizer();
	                String xml_str = xml.generateHtml(html5_env2.filename);
	                pw = new PrintWriter(new BufferedWriter(new FileWriter(html5_env.filename)));
					pw.println(html5_env.header);
					pw.println(xml_str);
					StringBuffer footer = new StringBuffer("</div></body></html>");
					pw.println(footer);
					pw.close();
                }
                html5_env.header = new StringBuffer();
                html5_env.footer = new StringBuffer();
                html5_env2.header = new StringBuffer();
                html5_env2.footer = new StringBuffer();
            } catch (FileNotFoundException fe) {
                System.err.println("Error: specified outdirectory \""
                        + html5_env.outdir + "\" is not found");
                GlobalEnv.addErr("Error: specified outdirectory \""
                        + html5_env.outdir + "\" is not found");
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

        html5_env.filename = parentfile;
        html5_env.code = parentcode;
        html5_env.css = parentcss;
        html5_env.header = parentheader;
        html5_env.footer = parentfooter;
        html5_env.nextbackfile = parentnextbackfile;
        html5_env2.filename = parentfile2;
        html5_env2.code = parentcode2;
        html5_env2.css = parentcss2;
        html5_env2.header = parentheader2;
        html5_env2.footer = parentfooter2;
        html5_env2.nextbackfile = parentnextbackfile2;

        Log.out("TFEId = " + HTML5Env.getClassID(this));
        html5_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);

    }

    private void setLinkButton() {
        String nextfile = new String();
        nextfile = html5_env.linkoutfile
                + String.valueOf(html5_env.countfile + 1) + ".html";
        html5_env.code.append("<DIV class=\"linkbutton "
                + HTML5Env.getClassID(tfe) + "\">\n");
        if (countinstance > 1) {
            html5_env.code.append("<A href=\"" + backfile + "\">");
            html5_env.code.append("[back]");
            html5_env.code.append("</A>\n");
        }
        if (this.hasMoreItems()) {
            html5_env.code.append("<A href=\"" + nextfile + "\">");
            html5_env.code.append("[next]");
            html5_env.code.append("</A>\n");
        }
        html5_env.code.append("</div>\n");

//        html5_env.addLinkButtonCSS();

    }

    @Override
	public String getSymbol() {
        return "HTML5G3";
    }

}