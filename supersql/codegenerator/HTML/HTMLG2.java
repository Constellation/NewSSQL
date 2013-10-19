package supersql.codegenerator.HTML;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.extendclass.ExtList;

public class HTMLG2 extends Grouper {

	private HTMLEnv html_env;

	public HTMLG2(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		this.html_env = henv;
		Dimension =2;
	}
	
	public Element createTableNode(ExtList<ExtList<String>> dataInfo){
		Element result = new Element(Tag.valueOf("table"), "");
		this.setDataList(dataInfo);
		nodeCreationPreProcess(result);
		while (this.hasMoreItems()) {
			html_env.gLevel++;
			HTMLUtils.propagateDeco(tfe, decos);
			result.appendElement("tr").appendElement("td").appendChild((Element) this.createNextItemNode());
			html_env.gLevel--;
		}
		nodeCreationPostProcess(result);
		return result;
	}
	
	@Override
	public Element createNode(ExtList<ExtList<String>> dataInfo) {
		if ((GlobalEnv.getLayout().equalsIgnoreCase("table") && !decos
				.containsKey("layout"))
				|| (decos.containsKey("layout") && decos.getStr("layout")
						.equalsIgnoreCase("table")))
    		return createTableNode(dataInfo);
		Element result = new Element(Tag.valueOf("div"), "");
		result.addClass("box").addClass("group2");
		this.setDataList(dataInfo);

		nodeCreationPreProcess(result);

		while (this.hasMoreItems()) {
			html_env.gLevel++;
			HTMLUtils.propagateDeco(tfe, decos);
			result.appendChild((Element) this.createNextItemNode());
			html_env.gLevel--;
		}
		nodeCreationPostProcess(result);
		
		return result;

	}
	
	private void nodeCreationPreProcess(Element result){
		if (decos.containsKey("layout")
				&& decos.getStr("layout").equalsIgnoreCase("standard")
				|| GlobalEnv.getLayout().equalsIgnoreCase("standard"))
    		result.addClass("vertical_display");
    	else
    		result.addClass("vertical");

		if (!GlobalEnv.isOpt()) {
			if (html_env.embedFlag)
				result.addClass("embed");

			if (html_env.writtenClassId.contains(HTMLEnv.getClassID(this))) {
				result.addClass(HTMLEnv.getClassID(this));
			}
			result.addClass("nest");

			if (!html_env.isOutlineMode()) {
				result.attr("frame", "void");
			}
		}
	}
	
	private void nodeCreationPostProcess(Element result){
		HTMLUtils.checkIfForm(result);
		

		if (HTMLEnv.getSelectRepeat()) {
			if (HTMLEnv.getSelectRepeat()) {
				HTMLEnv.setSelectRepeat(false);
				HTMLEnv.incrementFormPartsNumber();
			} else {
				HTMLEnv.incrementFormPartsNumber();
			}
		}
		HTMLUtils.processDecos(result, decos);
	}

	@Override
	public String getSymbol() {
		return "HTMLG2";
	}

}
