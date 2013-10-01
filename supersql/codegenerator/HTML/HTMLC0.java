package supersql.codegenerator.HTML;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Connector;
import supersql.codegenerator.Manager;
import supersql.extendclass.ExtList;


public class HTMLC0 extends Connector {
	public HTMLC0(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
	}

	@Override
	public TextNode createNode(ExtList<ExtList<String>> data_info){
		this.setDataList(data_info);
		TextNode result = new TextNode("", ""); 
		
		while (this.hasMoreItems()) {
			result.after((Element)this.createNextItemNode(data_info));
		}

       return result;
	}
	
	@Override
	public String getSymbol() {
		return "HTMLC0";
	}

}