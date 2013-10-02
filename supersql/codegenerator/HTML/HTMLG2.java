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

	@Override
	public Element createNode(ExtList<ExtList<String>> data_info) {
		Element result = new Element(Tag.valueOf("div"), "");
		result.addClass("vertical").addClass("box").addClass("group2");
		this.setDataList(data_info);

		html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

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

		while (this.hasMoreItems()) {
			html_env.gLevel++;
			HTMLUtils.propagateDeco(tfe, decos);
			result.appendChild((Element) this.createNextItemNode());
			html_env.gLevel--;

		}
		HTMLUtils.checkIfForm(result);
		

		if (HTMLEnv.getSelectRepeat()) {
			if (HTMLEnv.getSelectRepeat()) {
				HTMLEnv.setSelectRepeat(false);
				HTMLEnv.incrementFormPartsNumber();
			} else {
				HTMLEnv.incrementFormPartsNumber();
			}
		}
		return result;

	}

	@Override
	public String getSymbol() {
		return "HTMLG2";
	}

}
