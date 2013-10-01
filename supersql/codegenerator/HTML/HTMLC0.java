package supersql.codegenerator.HTML;

import java.util.Iterator;

import org.jsoup.nodes.Element;

import supersql.codegenerator.Connector;
import supersql.codegenerator.Manager;
import supersql.codegenerator.TFE;
import supersql.extendclass.ExtList;


public class HTMLC0 extends Connector {
	public HTMLC0(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		Dimension = 0;
	}

	@Override
	public Element createNode(ExtList<ExtList<String>> data_info){
		if(!checkOperands()){
			System.err.println("Argument error for the + operator, only attributes are accepted as operands for this connector.");
			throw new IllegalArgumentException();
		}
		this.setDataList(data_info);
		Element result = (Element)this.createNextItemNode(data_info);
		
		while (this.hasMoreItems()) {
			String toAppend = ((Element)this.createNextItemNode(data_info)).html();
			result.append(toAppend);
		}

       return result;
	}
	
	public boolean checkOperands(){
		Iterator<TFE> it = tfes.iterator();
		while(it.hasNext()){
			if(!(it.next() instanceof HTMLAttribute))
				return false;
		}
		return true;
	}
	
	@Override
	public String getSymbol() {
		return "HTMLC0";
	}

}