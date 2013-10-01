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

	}

	@Override
	public Element createNode(ExtList<ExtList<String>> data_info) {
		Element result = new Element(Tag.valueOf("div"), "");
		result.addClass("vertical").addClass("box").addClass("group2");
		this.setDataList(data_info);
		// TODO, what is the select flag ? It seems that data_info is a
		// ExtList<ExtList<ExtList<String>>> when this flag is true
		// if(HTMLEnv.getSelectFlg())
		// data_info = data_info.get(0);

		html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

		if (!GlobalEnv.isOpt()) {
			if (html_env.embedFlag)
				result.addClass("embed");

			if (decos.containsKey("outborder"))
				result.addClass("noborder");

			if (decos.containsKey("class")) {
				result.addClass(html_env.tableBorder);
			}
			if (html_env.writtenClassId.contains(HTMLEnv.getClassID(this))) {
				result.addClass(HTMLEnv.getClassID(this));
			}
			result.addClass("nest");

			if (!html_env.isOutlineModeForJsoup()) {
				result.attr("frame", "void");
			}
		}

		while (this.hasMoreItems()) {
			html_env.gLevel++;
			HTMLEnv.getClassID(tfe);
			if (!HTMLEnv.getSelectRepeat()) {
				result.appendChild((Element) this.createNextItemNode());
			}
			html_env.gLevel--;

		}

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
