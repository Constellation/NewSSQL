/*
 * Created on 2004/07/25
 */
package supersql.codegenerator.HTML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.extendclass.ExtList;

public class HTMLG3 extends Grouper {

	private HTMLEnv html_env;
	private String backfile = new String();

    private int countinstance = 0;

    //���󥹥ȥ饯��
    public HTMLG3(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.html_env = henv;
        Dimension =3;
    }
    
    

    @Override
	public Element createNode(ExtList<ExtList<String>> data_info) {
    	String parentfile = html_env.fileName;
        String parentnextbackfile = html_env.nextBackFile;
        StringBuffer parentcode = html_env.code;
        StringBuffer parentcss = html_env.css;
        StringBuffer parentheader = html_env.header;
        StringBuffer parentfooter = html_env.footer;
        html_env.css = new StringBuffer();
        html_env.header = new StringBuffer();
        html_env.footer = new StringBuffer();
        this.setDataList(data_info);
        File input = new File("template.html");
        Document template;
		try {
			template = Jsoup.parse(input, "UTF-8", "");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("*** Error while parsing the template file ***");
			throw new IllegalStateException();
		}
        while (this.hasMoreItems()) {
        	Document toWrite = template.clone();
            html_env.gLevel++;

            html_env.code = new StringBuffer();

            if (!html_env.foreachFlag) {
                backfile = html_env.nextBackFile;
                HTMLEnv.countFile++;
                countinstance++;
                html_env.fileName = html_env.outFile
                        + String.valueOf(HTMLEnv.countFile) + ".html";
                html_env.nextBackFile = html_env.linkOutFile
                        + String.valueOf(HTMLEnv.countFile) + ".html";
            }

            html_env.setOutlineMode();
            toWrite.body().getElementById("ssql").appendChild((Element) this.createNextItemNode());

            if (!html_env.foreachFlag) {
                String nextfile = new String();
                nextfile = html_env.linkOutFile
                        + String.valueOf(HTMLEnv.countFile + 1) + ".html";
                toWrite.body().getElementById("ssql").appendChild(new Element(Tag.valueOf("div"), "").addClass("linkbutton").addClass(HTMLEnv.getClassID(tfe)));
                if (countinstance > 1) {
                	toWrite.body().getElementById("ssql").children().last().appendChild(JsoupFactory.createLink(backfile, "", "[back]"));
                }
                if (this.hasMoreItems()) {
                	toWrite.body().getElementById("ssql").children().last().appendChild(JsoupFactory.createLink(nextfile, "", "[next]"));
                }
                
            }
            html_env.gLevel--;
            for(Element elt : html_env.createHeader()){
            	toWrite.head().appendChild(elt);
            }
            try {
				Writer out = new BufferedWriter(new OutputStreamWriter(
					    new FileOutputStream(html_env.fileName), "UTF-8"));
				out.write(toWrite.html());
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("*** IO Error while writing a file ***");
				throw new IllegalStateException();
			}
        }

        html_env.fileName = parentfile;
        html_env.code = parentcode;
        html_env.css = parentcss;
        html_env.header = parentheader;
        html_env.footer = parentfooter;
        html_env.nextBackFile = parentnextbackfile;
        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
        return null;
    }

	@Override
	public String getSymbol() {
        return "HTMLG3";
    }

}
