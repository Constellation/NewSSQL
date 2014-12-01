package supersql.codegenerator.HTML_Flexbox;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.codegenerator.Mobile_HTML5.Mobile_HTML5Function;
import supersql.common.GlobalEnv;
import supersql.extendclass.ExtList;

public class HTML_FlexboxG2 extends Grouper {

	/** @deprecated use HTMLG2() instead **/
	public HTML_FlexboxG2(Manager manager, HTML_FlexboxEnv henv, HTML_FlexboxEnv henv2) {
		Dimension =2;
	}
	
	public HTML_FlexboxG2(){
		Dimension = 2;
	}
	
	public Element createTableNode(ExtList<ExtList<String>> dataInfo){
		Element result = new Element(Tag.valueOf("table"), "");
		this.setDataList(dataInfo);
		nodeCreationPreProcess(result);
		while (this.hasMoreItems()) {
			HTML_FlexboxEnv.gLevel++;
			HTML_FlexboxUtils.propagateDeco(tfe, decos);
			result.appendElement("tr").appendElement("td").appendChild((Element) this.createNextItemNode());
			HTML_FlexboxEnv.gLevel--;
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
			HTML_FlexboxFunction.glvl = HTML_FlexboxEnv.gLevel;	//added by goto 20130914  "SEQ_NUM"
			HTML_FlexboxEnv.gLevel++;
			HTML_FlexboxUtils.propagateDeco(tfe, decos);
			result.appendChild((Element) this.createNextItemNode());
			HTML_FlexboxEnv.gLevel--;
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
			if (HTML_FlexboxEnv.embedFlag)
				result.addClass("embed");

			if (HTML_FlexboxEnv.writtenClassId.contains(HTML_FlexboxEnv.getClassID(this))) {
				result.addClass(HTML_FlexboxEnv.getClassID(this));
			}
			result.addClass("nest");

			if (!HTML_FlexboxEnv.isOutlineMode()) {
				result.attr("frame", "void");
			}
		}
	}
	
	private void nodeCreationPostProcess(Element result){
		HTML_FlexboxUtils.checkIfForm(result);
		

		if (HTML_FlexboxEnv.getSelectRepeat()) {
			if (HTML_FlexboxEnv.getSelectRepeat()) {
				HTML_FlexboxEnv.setSelectRepeat(false);
				HTML_FlexboxEnv.incrementFormPartsNumber();
			} else {
				HTML_FlexboxEnv.incrementFormPartsNumber();
			}
		}
		HTML_FlexboxUtils.processDecos(result, decos);
		HTML_FlexboxFunction.Func_seq_num_initialization(HTML_FlexboxEnv.gLevel);	//added by goto 20130914  "SEQ_NUM"
	}

	@Override
	public String getSymbol() {
		return "HTMLG2";
	}

}
