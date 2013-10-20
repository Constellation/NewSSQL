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

	private String backfile = new String();

    private int countinstance = 0;

	/** @deprecated use HTMLG3() instead **/
    public HTMLG3(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
        Dimension =3;
    }
    public HTMLG3(){
    	Dimension = 3;
    }
    
    

    @Override
	public Element createNode(ExtList<ExtList<String>> data_info) {
    	String parentfile = HTMLEnv.fileName;
        String parentnextbackfile = HTMLEnv.nextBackFile;
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
            HTMLEnv.gLevel++;

            if (!HTMLEnv.foreachFlag) {
                backfile = HTMLEnv.nextBackFile;
                HTMLEnv.countFile++;
                countinstance++;
                HTMLEnv.fileName = HTMLEnv.outFile
                        + String.valueOf(HTMLEnv.countFile) + ".html";
                HTMLEnv.nextBackFile = HTMLEnv.linkOutFile
                        + String.valueOf(HTMLEnv.countFile) + ".html";
            }

            HTMLEnv.setOutlineMode();
            toWrite.body().getElementById("ssql").appendChild((Element) this.createNextItemNode());

            if (!HTMLEnv.foreachFlag) {
                String nextfile = new String();
                nextfile = HTMLEnv.linkOutFile
                        + String.valueOf(HTMLEnv.countFile + 1) + ".html";
                toWrite.body().getElementById("ssql").appendChild(new Element(Tag.valueOf("div"), "").addClass("linkbutton").addClass(HTMLEnv.getClassID(tfe)));
                if (countinstance > 1) {
                	toWrite.body().getElementById("ssql").children().last().appendChild(JsoupFactory.createLink(backfile, "", "[back]"));
                }
                if (this.hasMoreItems()) {
                	toWrite.body().getElementById("ssql").children().last().appendChild(JsoupFactory.createLink(nextfile, "", "[next]"));
                }
                
            }
            HTMLEnv.gLevel--;
            for(Element elt : HTMLEnv.createHeader()){
            	toWrite.head().appendChild(elt);
            }
            try {
				Writer out = new BufferedWriter(new OutputStreamWriter(
					    new FileOutputStream(HTMLEnv.fileName), "UTF-8"));
				out.write(toWrite.html());
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("*** IO Error while writing a file ***");
				throw new IllegalStateException();
			}
        }

        HTMLEnv.fileName = parentfile;
        HTMLEnv.nextBackFile = parentnextbackfile;
        return null;
    }

	@Override
	public String getSymbol() {
        return "HTMLG3";
    }

}
