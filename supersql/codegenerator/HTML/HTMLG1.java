package supersql.codegenerator.HTML;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.extendclass.ExtList;

public class HTMLG1 extends Grouper {

	private HTMLEnv html_env;

	public HTMLG1(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		this.html_env = henv;
		Dimension = 1;
	}

	public Element createTableNode(ExtList<ExtList<String>> dataInfo) {
		this.setDataList(dataInfo);

		Element result = new Element(Tag.valueOf("table"), "");
		Element tr = result.appendElement("tr");

		nodeCreationPreProcess(result);

		while (this.hasMoreItems()) {
			html_env.gLevel++;
			HTMLUtils.propagateDeco(tfe, decos);
			tr.appendElement("td").appendChild(
					(Element) this.createNextItemNode());
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
		this.setDataList(dataInfo);

		Element result = new Element(Tag.valueOf("div"), "");
		result.attr("class", "box group1");
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

	private void nodeCreationPreProcess(Element result) {
		if (decos.containsKey("layout")
				&& decos.getStr("layout").equalsIgnoreCase("standard")
				|| GlobalEnv.getLayout().equalsIgnoreCase("standard"))
			result.addClass("horizontal_display");
		else
			result.addClass("horizontal");
		if (!GlobalEnv.isOpt()) {

			if (html_env.embedFlag)
				result.addClass("embed");

			if (decos.containsKey("class")) {
				result.addClass(decos.getStr("class"));
			}
			if (html_env.haveClass == 1) {
				result.addClass(HTMLEnv.getClassID(this));
			}
			result.addClass("nest");
		}
	}

	private void nodeCreationPostProcess(Element result) {
		if (result.getElementsByTag("input").size() > 0) {
			result.getElementsByTag("form").removeClass("form").tagName("div");
			result.tagName("form");
			result.getElementsByAttributeValue("type", "submit").remove();
			result.attr("class", "form horizontal box");
			result = new Element(Tag.valueOf("div"), "").attr("class",
					"group1 vertical box").appendChild(result);
			result.appendChild(JsoupFactory.createInput("submit", "",
					"Let's go !"));
		}

		if (HTMLEnv.getFormItemFlg()) {
			HTMLEnv.incrementFormPartsNumber();
		}
		HTMLUtils.processDecos(result, decos);
	}

	@Override
	public String getSymbol() {
		return "HTMLG1";
	}

}
