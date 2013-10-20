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

import supersql.codegenerator.Connector;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.extendclass.ExtList;

public class HTMLC3 extends Connector {

	private HTMLEnv htmlEnv;
	public HTMLC3(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        this.htmlEnv = henv;
        Dimension =3;
    }
	
    public Element createNode(ExtList<ExtList<String>> dataInfo){
    	Element result = new Element(Tag.valueOf("div"), "");
    	result.addClass("con3").addClass("box");
    	
    	File input = new File("template.html");
    	Document toWrite = new Document("");
		try {
			toWrite = Jsoup.parse(input, "UTF-8", "");
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Error while creating HTML document from template.");
			throw new IllegalStateException();
		}
    	
    	String parentfile = HTMLEnv.fileName;
        StringBuffer parentcode = new StringBuffer();
        StringBuffer parentcss = new StringBuffer();
        StringBuffer parentheader = new StringBuffer();
        StringBuffer parentfooter = new StringBuffer();
        ITFE[] tfe = new ITFE[tfeItems];
        int c3items = tfeItems;
        for (int j = 0; j < tfeItems - 1; j++) {
            tfe[j] = (ITFE) tfes.get(j);
            if (j < tfeItems - 2 && tfe[j] instanceof HTMLG3) {
                System.err.println("Error: % after []% is not allowed");
                GlobalEnv.addErr("Error: % after []% is not allowed");
            }
        }
        HTMLEnv.countFile++;

        HTMLEnv.linkUrl = HTMLEnv.linkOutFile
                + String.valueOf(HTMLEnv.countFile) + ".html";
        HTMLEnv.linkFlag++;
        this.setDataList(dataInfo);

        result.appendChild((Element) this.createNextItemNode(dataInfo));
        HTMLEnv.linkFlag--;

        for (int k = 1; k < c3items; k++) {
            ITFE intfe = (ITFE) tfes.get(k);
            HTMLEnv.fileName = HTMLEnv.outFile
                    + String.valueOf(HTMLEnv.countFile) + ".html";
            if (intfe instanceof HTMLG3) {
                HTMLEnv.countFile--;
                toWrite.body().getElementById("ssql").appendChild((Element) this.createNextItemNode(dataInfo));
            } else {
                parentcss = HTMLEnv.css;
                parentheader = HTMLEnv.header;
                parentfooter = HTMLEnv.footer;
                HTMLEnv.header = new StringBuffer();
                HTMLEnv.footer = new StringBuffer();

                if (k < c3items - 1) {
                    HTMLEnv.countFile++;
                    HTMLEnv.linkUrl = HTMLEnv.linkOutFile
                            + String.valueOf(HTMLEnv.countFile) + ".html";
                    HTMLEnv.linkFlag++;
                }

                HTMLEnv.setOutlineMode();
                toWrite.body().getElementById("ssql").appendChild((Element) this.createNextItemNode(dataInfo));

                if (k < c3items - 1) {
                    HTMLEnv.linkFlag--;
                }
                toWrite.head().children().addAll(HTMLEnv.createHeader());
                HTMLEnv.css = parentcss;
                HTMLEnv.header = parentheader;
                HTMLEnv.footer = parentfooter;
            }
            
            // Writing the file
            try {
            	Writer out = new BufferedWriter(new OutputStreamWriter(
            			new FileOutputStream(HTMLEnv.fileName), "UTF-8"));
            	out.write(toWrite.html());
            	out.close();
            } catch (IOException e) {
            	e.printStackTrace();
            	System.err.println("Error while writing the HTML file.");
            	throw new IllegalStateException();
            }
        }

        // TODO
        HTMLEnv.fileName = parentfile;

        HTMLUtils.processDecos(result, decos);
        return result;
    }

    @Override
	public String getSymbol() {
        return "HTMLC3";
    }

}
