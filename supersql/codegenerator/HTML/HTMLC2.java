package supersql.codegenerator.HTML;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Connector;
import supersql.codegenerator.ITFE;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.extendclass.ExtList;

public class HTMLC2 extends Connector {

	private HTMLEnv htmlEnv;

	public HTMLC2(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		this.htmlEnv = henv;
		Dimension = 2;
	}

	public Element createTableNode(ExtList<ExtList<String>> dataInfo) {
		this.setDataList(dataInfo);

		if (decos.containsKey("insert"))
			return createForm(dataInfo, 0);
		if (decos.containsKey("delete"))
			return createForm(dataInfo, 1);
		if (decos.containsKey("update"))
			return createForm(dataInfo, 2);

		Element result = new Element(Tag.valueOf("table"), "");
		nodeCreationPreProcesss(result);
		int i = 0;
		while (this.hasMoreItems()) {
			ITFE tfe = (ITFE) tfes.get(i);
			result.addClass(HTMLEnv.getClassID(tfe)).addClass("nest");
			HTMLEnv.getClassID(tfe);

			result.appendElement("tr").appendElement("td")
					.appendChild((Element) this.createNextItemNode(dataInfo));

			i++;
		}
		
		return result;
	}
	
	private void nodeCreationPreProcesss(Element result){
		if (decos.containsKey("layout")
				&& decos.getStr("layout").equalsIgnoreCase("standard")
				|| GlobalEnv.getLayout().equalsIgnoreCase("standard"))
    		result.addClass("vertical_display");
    	else
    		result.addClass("vertical");

		if (!GlobalEnv.isOpt()) {
			if (!HTMLEnv.isOutlineMode()) {
				result.attr("frame", "void");
			}
				result.attr("class", HTMLEnv.getClassID(this));

			if (decos.containsKey("class")) {
				result.attr("class",
						result.attr("class") + " " + decos.getStr("class"));
			}
		}
		HTMLUtils.processDecos(result, decos);
	}

	@Override
	public Element createNode(ExtList<ExtList<String>> dataInfo) {
		if ((GlobalEnv.getLayout().equalsIgnoreCase("table") && !decos
				.containsKey("layout"))
				|| (decos.containsKey("layout") && decos.getStr("layout")
						.equalsIgnoreCase("table")))
    		return createTableNode(dataInfo);
		this.setDataList(dataInfo);

		if (decos.containsKey("insert"))
			return createForm(dataInfo, 0);
		if (decos.containsKey("delete"))
			return createForm(dataInfo, 1);
		if (decos.containsKey("update"))
			return createForm(dataInfo, 2);

		Element result = new Element(Tag.valueOf("div"), "");
		result.addClass("con2").addClass("box");
		nodeCreationPreProcesss(result);
		int i = 0;

		while (this.hasMoreItems()) {
			ITFE tfe = (ITFE) tfes.get(i);
			result.addClass(HTMLEnv.getClassID(tfe)).addClass("nest");

			HTMLEnv.getClassID(tfe);

			result.appendChild((Element) this.createNextItemNode(dataInfo));

			i++;
		}

		return result;
	}

	private Element createForm(ExtList<ExtList<String>> dataInfo, int type) {
		String inputType;
		String submitText;
		String inputValue;
		String formContentClass;
		String formContentElementsClass;
		if (type == 0) {
			inputType = "text";
			inputValue = "";
			submitText = "insert";
			formContentClass = "vertical con2";
			formContentElementsClass = "horizontal";
		} else if (type == 1) {
			inputType = "checkbox";
			inputValue = "1";
			submitText = "delete";
			formContentClass = "vertical con2";
			formContentElementsClass = "horizontal";
		} else if (type == 2) {
			inputType = "text";
			inputValue = null;
			submitText = "update";
			formContentClass = "vertical con2";
			formContentElementsClass = "horizontal";
		} else {
			throw new IllegalArgumentException();
		}
		return JsoupFactory.createForm(this, inputType, submitText, inputValue,
				formContentClass, formContentElementsClass);

	}

	public String getSymbol() {
		return "HTMLC2";
	}

}
