/*
 * Created on 2004/07/25
 */
package supersql.codegenerator.HTML_Flexbox;

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

public class HTML_FlexboxG3 extends Grouper {

	private String backfile = new String();

    private int countinstance = 0;

	/** @deprecated use HTMLG3() instead **/
    public HTML_FlexboxG3(Manager manager, HTML_FlexboxEnv henv, HTML_FlexboxEnv henv2) {
        Dimension =3;
    }
    public HTML_FlexboxG3(){
    	Dimension = 3;
    }
    
    

    @Override
	public Element createNode(ExtList<ExtList<String>> data_info) {
    	String parentfile = HTML_FlexboxEnv.fileName;
        String parentnextbackfile = HTML_FlexboxEnv.nextBackFile;
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
            HTML_FlexboxEnv.gLevel++;

            if (!HTML_FlexboxEnv.foreachFlag) {
                backfile = HTML_FlexboxEnv.nextBackFile;
                HTML_FlexboxEnv.countFile++;
                countinstance++;
                HTML_FlexboxEnv.fileName = HTML_FlexboxEnv.outFile
                        + String.valueOf(HTML_FlexboxEnv.countFile) + ".html";
                HTML_FlexboxEnv.nextBackFile = HTML_FlexboxEnv.linkOutFile
                        + String.valueOf(HTML_FlexboxEnv.countFile) + ".html";
            }

            HTML_FlexboxEnv.setOutlineMode();
            toWrite.body().getElementById("ssql").appendChild((Element) this.createNextItemNode());

            if (!HTML_FlexboxEnv.foreachFlag) {
                String nextfile = new String();
                nextfile = HTML_FlexboxEnv.linkOutFile
                        + String.valueOf(HTML_FlexboxEnv.countFile + 1) + ".html";
                toWrite.body().getElementById("ssql").appendChild(new Element(Tag.valueOf("div"), "").addClass("linkbutton").addClass(HTML_FlexboxEnv.getClassID(tfe)));
                if (countinstance > 1) {
                	toWrite.body().getElementById("ssql").children().last().appendChild(JsoupFactory.createLink(backfile, "", "[back]"));
                }
                if (this.hasMoreItems()) {
                	toWrite.body().getElementById("ssql").children().last().appendChild(JsoupFactory.createLink(nextfile, "", "[next]"));
                }
                
            }
            HTML_FlexboxEnv.gLevel--;
            for(Element elt : HTML_FlexboxEnv.createHeader()){
            	toWrite.head().appendChild(elt);
            }
            try {
				Writer out = new BufferedWriter(new OutputStreamWriter(
					    new FileOutputStream(HTML_FlexboxEnv.fileName), "UTF-8"));
				out.write(toWrite.html());
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("*** IO Error while writing a file ***");
				throw new IllegalStateException();
			}
        }

        HTML_FlexboxEnv.fileName = parentfile;
        HTML_FlexboxEnv.nextBackFile = parentnextbackfile;
        return null;
    }

	@Override
	public String getSymbol() {
        return "HTMLG3";
    }

}
