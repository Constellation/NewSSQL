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

public class HTML5C3 extends Connector {

    Manager manager;

    HTML5Env html5_env;
    HTML5Env html5_env2;

    //���󥹥ȥ饯��
    public HTML5C3(Manager manager, HTML5Env henv, HTML5Env henv2) {
        this.manager = manager;
        this.html5_env = henv;
        this.html5_env2 = henv2;
    }

    //C3��work�᥽�å�
    @Override
	public void work(ExtList data_info) {
        int i = 0;
        String parentfile = html5_env.filename;
        String parentfile2 = html5_env2.filename;
        StringBuffer parentcode = new StringBuffer();
        StringBuffer parentcss = new StringBuffer();
        StringBuffer parentheader = new StringBuffer();
        StringBuffer parentfooter = new StringBuffer();
        StringBuffer parentcode2 = new StringBuffer();
        StringBuffer parentcss2 = new StringBuffer();
        StringBuffer parentheader2 = new StringBuffer();
        StringBuffer parentfooter2 = new StringBuffer();
        String linkfile = new String();
        TFE tfe[] = new TFE[tfeitems];
        int c3items = tfeitems;
        for (int j = 0; j < tfeitems - 1; j++) {
            tfe[j] = (TFE) tfes.get(j);
            if (j < tfeitems - 2 && tfe[j] instanceof HTML5G3) {
                System.err.println("Error: % after []% is not allowed");
                GlobalEnv.addErr("Error: % after []% is not allowed");
                //comment out by chie
                //System.exit(-1);
            }
        }
        boolean checknexttfe = tfe[0] instanceof HTML5C1
                || tfe[0] instanceof HTML5C2 || tfe[0] instanceof HTML5C3;
        Log.out("------- C3 -------");
        html5_env.countfile++;

        html5_env.linkurl = html5_env.linkoutfile
                + String.valueOf(html5_env.countfile) + ".html";
        html5_env.link_flag++;
        Log.out("linkflag =" + html5_env.link_flag);
        this.setDataList(data_info);

        this.worknextItem();
        html5_env.link_flag--;

        for (int k = 1; k < c3items; k++) {
            TFE intfe = (TFE) tfes.get(k);
            html5_env.filename = html5_env.outfile
                    + String.valueOf(html5_env.countfile) + ".html";
            html5_env2.filename = html5_env.outfile
            + String.valueOf(html5_env.countfile) + ".xml";
            boolean b = intfe instanceof Attribute
                    || intfe instanceof HTML5Function;
            if (intfe instanceof HTML5G3) {
                html5_env.countfile--;
                this.worknextItem();
            } else {
                parentcode = html5_env.code;
                parentcss = html5_env.css;
                parentheader = html5_env.header;
                parentfooter = html5_env.footer;
                html5_env.code = new StringBuffer();
                html5_env.header = new StringBuffer();
                html5_env.footer = new StringBuffer();

                parentcode2 = html5_env2.code;
                parentcss2 = html5_env2.css;
                parentheader2 = html5_env2.header;
                parentfooter2 = html5_env2.footer;
                html5_env2.code = new StringBuffer();
                html5_env2.header = new StringBuffer();
                html5_env2.footer = new StringBuffer();

                if (k < c3items - 1) {
                    html5_env.countfile++;
                    html5_env.linkurl = html5_env.linkoutfile
                            + String.valueOf(html5_env.countfile) + ".html";
                    html5_env.link_flag++;
                    Log.out("linkflag =" + html5_env.link_flag);
                }

                html5_env.setOutlineMode();
                this.worknextItem();

                if (k < c3items - 1) {
                    html5_env.link_flag--;
                }
                html5_env.getHeader();
                html5_env.getFooter();
                //html_env2.header.append("<?xml version=\"1.0\" encoding=\"Shift_JIS\"?><SSQL>");
                html5_env2.header.append("<?xml version=\"1.0\" encoding=\""+html5_env.getEncode()+"\"?><SSQL>");
                html5_env2.footer.append("</SSQL>");
                try {
                    PrintWriter pw = new PrintWriter(new BufferedWriter(
                            new FileWriter(html5_env.filename)));
                    pw.println(html5_env.header);
                    pw.println(html5_env.code);
                    pw.println(html5_env.footer);
                    pw.close();
                    //html5_env.header = new StringBuffer();
                    //html5_env.footer = new StringBuffer();
	                if(GlobalEnv.isOpt()){
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
                } catch (FileNotFoundException fe) {
                	fe.printStackTrace();
                    System.err.println("Error: specified outdirectory \""
                            + html5_env.outdir + "\" is not found");
                    GlobalEnv.addErr("Error: specified outdirectory \""
                            + html5_env.outdir + "\" is not found");
                    //comment out by chie
                    //System.exit(-1);
                } catch (IOException e) {
                    System.err.println("Error[HTML5C3]: File IO Error in HTML5C3");
                    e.printStackTrace();
                    GlobalEnv.addErr("Error[HTML5C3]: File IO Error in HTML5C3");
                    //comment out by chie
                    //System.exit(-1);
                }
                html5_env.code = parentcode;
                html5_env.css = parentcss;
                html5_env.header = parentheader;
                html5_env.footer = parentfooter;
                html5_env2.code = parentcode2;
                html5_env2.css = parentcss2;
                html5_env2.header = parentheader2;
                html5_env2.footer = parentfooter2;
            }
        }
        html5_env.filename = parentfile;
        html5_env2.filename = parentfile2;

        Log.out("TFEId = " + HTML5Env.getClassID(this));
        html5_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);

    }

    @Override
	public String getSymbol() {
        return "HTML5C3";
    }

}