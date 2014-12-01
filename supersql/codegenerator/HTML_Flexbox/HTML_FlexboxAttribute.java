package supersql.codegenerator.HTML_Flexbox;

import java.io.File;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.extendclass.ExtList;

public class HTML_FlexboxAttribute extends Attribute {

	protected String[] formSql = { "", "delete", "update", "insert", "login",
			"logout" };
	protected String[] formHtml = { "", "submit", "select", "checkbox",
			"radio", "text", "textarea", "hidden" };
	protected int whichForm;

	/** @deprecated use HTMLAttribute() instead **/
	public HTML_FlexboxAttribute(Manager manager, HTML_FlexboxEnv henv, HTML_FlexboxEnv henv2) {
		super();
	}
	
	public HTML_FlexboxAttribute(){
		super();
	}
	public HTML_FlexboxAttribute(boolean b){
		super(b);
	}
	
	/** @deprecated use HTMLC2() instead **/
	public HTML_FlexboxAttribute(Manager manager, HTML_FlexboxEnv henv, HTML_FlexboxEnv henv2, boolean b) {
		super(b);
	}

	public Element createTableNode(ExtList data_info){
		Element result = new Element(Tag.valueOf("td"), "");
		//***APPEND DATABASE VALUE***//
		String elementText = this.getStr(data_info);
		elementText = elementText.replace(" ", "&#160;");
		result.html(elementText);
		return result;
	}
	
	@Override
	public Element createNode(ExtList data_info) {
		Element result = new Element(Tag.valueOf("span"), "");
		result.addClass("box");
		
		if (!(HTML_FlexboxEnv.getFormItemFlg() && HTML_FlexboxEnv.getFormItemName().equals(
				formHtml[2]))) {
			result.addClass("att");
			result.addClass(HTML_FlexboxEnv.getClassID(this));
			if (decos.getConditions().size() > 0) {
				result.addClass(computeStringForDecoration(data_info));
			}
		}
		if(decos.containsKey("logout"))
			return createLogoutForm(result, data_info);
		if(decos.containsKey("input")){
			if(decos.containsKey("pwd"))
				return JsoupFactory.createInput("password", decos.getStr("attributeName"), "");
			return JsoupFactory.createInput("text", decos.getStr("attributeName"), "");
		}
		Element div = new Element(Tag.valueOf("div"), "");
		Element a = new Element(Tag.valueOf("a"), "");

		if (HTML_FlexboxEnv.linkFlag > 0) {

			// tk start for draggable div///////////////////////////////////////
			if (HTML_FlexboxEnv.draggable) {
				div.addClass("draggable").attr("id", HTML_FlexboxEnv.dragDivId);
			} else {
				// tk end for draggable
				// div/////////////////////////////////////////
				if (HTML_FlexboxEnv.isPanel)
					div.attr("id", "container");

				String fileDir = new File(HTML_FlexboxEnv.linkUrl).getAbsoluteFile()
						.getParent();
				if (fileDir.length() < HTML_FlexboxEnv.linkUrl.length()
						&& fileDir.equals(HTML_FlexboxEnv.linkUrl.substring(0,
								fileDir.length()))) {
					String relative_path = HTML_FlexboxEnv.linkUrl.substring(fileDir
							.length() + 1);
					a = new Element(Tag.valueOf("a"), "").attr("href",
							relative_path);
				} else
					a = new Element(Tag.valueOf("a"), "").attr("href",
							HTML_FlexboxEnv.linkUrl);
			}

			if (GlobalEnv.isAjax() && HTML_FlexboxEnv.isPanel) {
				a.attr("onClick", "return panel('Panel','" + HTML_FlexboxEnv.ajaxQuery
						+ "'," + "'" + HTML_FlexboxEnv.dragDivId + "','"
						+ HTML_FlexboxEnv.ajaxCond + "')");
			} else if (GlobalEnv.isAjax() && !HTML_FlexboxEnv.draggable) {
				String target = GlobalEnv.getAjaxTarget();
				if (target == null) {
					String query = HTML_FlexboxEnv.ajaxQuery;
					if (query.indexOf(".sql")>0) {
						if (query.contains("/")) {
							target = query.substring(query.lastIndexOf("/") + 1,
									query.indexOf(".sql"));
						} else{
							target = query.substring(0, query.indexOf(".sql"));
						}
		        	} else if (query.indexOf(".ssql")>0) {
		        		if (query.contains("/")) {
							target = query.substring(query.lastIndexOf("/") + 1,
									query.indexOf(".ssql"));
						} else{
							target = query.substring(0, query.indexOf(".ssql"));
						}
		        	}

					if (HTML_FlexboxEnv.hasDispDiv) {
						target = HTML_FlexboxEnv.ajaxtarget;
					}
				}
				a.attr("onClick", "return loadFile('" + HTML_FlexboxEnv.ajaxQuery
						+ "','" + target + "','" + HTML_FlexboxEnv.ajaxCond + "',"
						+ HTML_FlexboxEnv.inEffect + "," + HTML_FlexboxEnv.outEffect + ")");
			}
		}

		// ***APPEND DATABASE VALUE***//
		String elementText = this.getStr(data_info);
		elementText = elementText.replace(" ", "&#160;");
		result.html(elementText);

		if (HTML_FlexboxEnv.linkFlag > 0) {
			if (HTML_FlexboxEnv.draggable)
				result.appendChild(div);
			else {
				a.html(this.getStr(data_info));
				a.addClass("box");
				if (HTML_FlexboxEnv.isPanel)
					a.appendChild(div);
				return a;
			}
		}
		decos.remove("attributeName");
		HTML_FlexboxUtils.processDecos(result, decos);
		return result;
	}

	protected void createForm(ExtList data_info) {

		String name = new String();
		String inputFormString = new String();

		for (int i = 1; i < formSql.length; i++) {
			if (decos.containsKey(formSql[i])
					|| HTML_FlexboxEnv.getIDU().equals(formSql[i])) {
				switch (i) {
				case 1: // delete
					if (decos.containsKey(formSql[i])) {
						name = decos.getStr("delete");
					} else {
						name = decos.getStr("attributeName");
					}
					inputFormString += "<input type=\"checkbox\" name=\""
							+ name + "\" value=\"" + this.getStr(data_info)
							+ "\" />";
					whichForm = i;
					break;
				case 2: // update
					if (decos.containsKey(formSql[i])) {
						name = decos.getStr("update");
					} else {
						name = decos.getStr("attributeName");
					}
					whichForm = i;
					break;
				case 3: // insert
					if (decos.containsKey(formSql[i])) {
						name = decos.getStr("insert");
					} else {
						name = decos.getStr("attributeName");
					}
					whichForm = i;
					break;
				case 4: // login
					name = decos.getStr("login");
					if (decos.containsKey("att")) {
						inputFormString += "<input type=\"hidden\" name=\"att\" value=\""
								+ decos.getStr("att") + "\" />";
					}
					whichForm = i;
					break;
				case 5: // logout
					inputFormString += "<input type=\"hidden\" name=\"sqlfile\" value=\""
							+ decos.getStr("linkfile").replace("\"", "")
							+ "\" />";
					inputFormString += "<input type=\"submit\" name=\"logout\" value=\""
							+ this.getStr(data_info) + "\" />";
					whichForm = i;
					break;
				}
			}
		}

		if (1 < whichForm && whichForm < formSql.length - 1) { // update,insert,login
			String s;
			if (whichForm < 3) {// update
				s = this.getStr(data_info);
			} else {// insert,login,logout
				s = "";
			}
			if (decos.containsKey("pwd")) {
				inputFormString += "<input type=\"password\" name=\"" + name
						+ "\" value=\"" + s + "\" />";
				if (decos.containsKey("md5")) {
					inputFormString += "<input type=\"hidden\" name=\"" + name
							+ ":pwd\" value=\"md5\" />";
				}
			}
			if (decos.containsKey("img")) {
				inputFormString += "<input type=\"file\" name=\"" + name
						+ "\" value=\"" + s + "\" >";
			} else {
				// ishizaki start (html5)
				if (s.isEmpty()) {
					// inputFormString += "<input type=\"text\" name=\"" + name
					// + "\" />";
					if (decos.containsKey("type")) {
						if (decos.getStr("type").equals("tel"))
							inputFormString += "<input type=\"tel\" name=\""
									+ name
									+ "\" pattern=\"\\d{2,4}-\\d{2,4}-\\d{4}\"/>";
						if (decos.getStr("type").equals("mail"))
							inputFormString += "<input type=\"email\" name=\""
									+ name
									+ "\" pattern=\"[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+\"/>";
						if (decos.getStr("type").equals("age"))
							inputFormString += "<input type=\"text\" name=\""
									+ name + "\" pattern=\"\\d{1,3}\" >";
						if (decos.getStr("type").equals("url"))
							inputFormString += "<input type=\"url\" name=\""
									+ name + "\" >";
					} else
						inputFormString += "<input type=\"text\" name=\""
								+ name + "\" />";
				} else {
					// inputFormString += "<input type=\"text\" name=\"" + name
					// + "\" value=\"" + s + "\" />";
					if (decos.containsKey("type")) {
						if (decos.getStr("type").equals("tel")) {
							inputFormString += "<input type=\"tel\" name=\""
									+ name
									+ "\" pattern=\"\\d{2,4}-\\d{2,4}-\\d{4}\"/ value=\""
									+ s + "\">";
						} else if (decos.getStr("type").equals("mail")) {
							inputFormString += "<input type=\"email\" name=\""
									+ name
									+ "\" pattern=\"[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+\"/ value=\""
									+ s + "\">";
						} else if (decos.getStr("type").equals("age")) {
							inputFormString += "<input type=\"text\" name=\""
									+ name + "\" pattern=\"\\d{1,3}\" value=\""
									+ s + "\">";
						} else if (decos.getStr("type").equals("url")) {
							inputFormString += "<input type=\"url\" name=\""
									+ name + "\" value=\"" + s + "\">";
						} else
							inputFormString += "<input type=\"text\" name=\""
									+ name + "\" value=\"" + s + "\"/>";
					} else
						inputFormString += "<input type=\"text\" name=\""
								+ name + "\" value=\"" + s + "\"/>";
				}
			}

			// add constraint
			String constraint = new String();
			if (decos.containsKey("notnull")) {// not null
				constraint = "notnull";
			}
			if (decos.containsKey("number")) {// num or eng
				if (decos.containsKey("english")) {
					if (constraint.isEmpty())
						constraint = "numeng";
					else
						constraint += ",numeng";
				} else {// number
					if (constraint.isEmpty())
						constraint = "number";
					else
						constraint += ",number";
				}
			} else if (decos.containsKey("english")) {// eng
				if (constraint.isEmpty())
					constraint = "english";
				else
					constraint += ",english";
			}

			if (decos.containsKey("unique")) {// unique
				if (constraint.isEmpty())
					constraint = "unique";
				else
					constraint += ",unique";
			}

		}

		inputFormString = new String();

		if (HTML_FlexboxEnv.getFormItemFlg()) {
			for (int i = 1; i < formHtml.length; i++) {
				String real_value = HTML_FlexboxEnv.getFormValueString();
				if (HTML_FlexboxEnv.getFormItemName().equals(formHtml[i])) {
					switch (i) {
					case 1: // submit
						inputFormString = inputFormItems(data_info,
								formHtml[i], "");
						whichForm = i + formSql.length;
						break;
					case 2: // select
						inputFormString = inputFormItems(data_info,
								formHtml[i], real_value);
						whichForm = i + formSql.length;
						break;
					case 3: // checkbox
						inputFormString = inputFormItems(data_info,
								formHtml[i], real_value);
						whichForm = i + formSql.length;
						break;
					case 4: // radio
						inputFormString = inputFormItems(data_info,
								formHtml[i], real_value);
						whichForm = i + formSql.length;
						break;

					case 5: // input text
						inputFormString = inputFormItems(data_info,
								formHtml[i], real_value);
						whichForm = i + formSql.length;
						break;

					case 6: // textarea
						inputFormString = inputFormItems(data_info,
								formHtml[i], real_value);
						whichForm = i + formSql.length;
						break;

					case 7: // hidden
						inputFormString = inputFormItems(data_info,
								formHtml[i], real_value);
						whichForm = i + formSql.length;
						break;
					}
				}
			}
		}

	}

	protected String inputFormItems(ExtList data_info, String itemType,
			String real_value) {
		String ret = "";
		String formname = HTML_FlexboxEnv.getFormPartsName();
		;
		if (HTML_FlexboxEnv.getSearch()) {
			ret += cond();
			formname = "value" + HTML_FlexboxEnv.formPartsNumber;
		}
		String s = this.getStr(data_info);
		// tuple_count++;
		if (real_value.isEmpty()) {
			real_value = s;
		}
		// sizeoption
		String size = new String();
		if (decos.containsKey("size")) {
			size += " size=\"" + decos.getStr("size") + "\"";
		}
		if (decos.containsKey("height")) {
			size += " height=\"" + decos.getStr("height") + "\"";
		}
		if (decos.containsKey("cols")) {
			size += " cols=\"" + decos.getStr("cols") + "\"";
		}
		if (decos.containsKey("rows")) {
			size += " rows=\"" + decos.getStr("rows") + "\"";
		}

		if (decos.containsKey("class")) {
			size += " class=\"" + decos.getStr("class") + "\"";
		}

		if (itemType.equals(formHtml[1])) {// submit

		} else if (itemType.equals(formHtml[2])) {// select
			if (HTML_FlexboxEnv.getSelectRepeat() == false) {
				ret += "<select name=\"" + formname + "\">";
				HTML_FlexboxEnv.setSelectRepeat(true);
			}
			if (HTML_FlexboxEnv.getSelected().length() != 0
					&& HTML_FlexboxEnv.getSelected().equals(real_value)) {
				ret += "<option value=\"" + real_value + "\"" + size
						+ " selected=\"selected\" >" + s + "</option>";
			} else {
				ret += "<option value=\"" + real_value + "\"" + size + " >" + s
						+ "</option>";
			}
		} else if (itemType.equals(formHtml[3])) {// checkbox
			String checked = "";
			if (HTML_FlexboxEnv.getChecked().length() != 0
					&& HTML_FlexboxEnv.getChecked().equals(real_value)) {
				checked = " checked=\"checked\" ";
			}
			if (HTML_FlexboxEnv.nameId.length() != 0) {
				ret += "<input type=\"checkbox\" name=\"" + formname + "["
						+ HTML_FlexboxEnv.nameId + "]" + "\" value=\"" + real_value
						+ "\"" + size + checked + " />";
				ret += s;
			} else {
				ret += "<input type=\"checkbox\" name=\"" + formname
						+ "\" value=\"" + real_value + "\"" + size + checked
						+ " />";
				ret += s;
			}
		} else if (itemType.equals(formHtml[4])) {// radio
			String checked = "";
			if (HTML_FlexboxEnv.getChecked().length() != 0
					&& HTML_FlexboxEnv.getChecked().equals(real_value)) {
				checked = " checked=\"checked\" ";
			}
			ret += "<input type=\"radio\" name=\"" + formname + "\" value=\""
					+ real_value + "\"" + size + checked + " />";
			ret += s;
		} else if (itemType.equals(formHtml[5])) {// text
			if (decos.containsKey("pwd")) {
				ret += "<input type=\"password\" name=\"" + formname
						+ "\" value=\"" + real_value + "\"" + size + " />";
				if (decos.containsKey("md5")) {
					ret += "<input type=\"hidden\" name=\"" + formname
							+ ":pwd\" value=\"md5\" />";
				}
			} else {
				ret += "<input type=\"text\" name=\"" + formname
						+ "\" value=\"" + real_value + "\"" + size + " />";
			}
		} else if (itemType.equals(formHtml[6])) {// textarea
			ret += "<textarea name=\"" + formname + "\"" + size + ">";
			if (s != null) {
				ret += s;
			}
			ret += "</textarea>";
		} else if (itemType.equals(formHtml[7])) {// text
			ret += "<input type=\"hidden\" name=\"" + formname + "\" value=\""
					+ real_value + "\"" + size + " />";
		}

		String constraint = new String();
		if (decos.containsKey("notnull")) {
			constraint = "notnull";
		}
		if (decos.containsKey("number")) {
			if (decos.containsKey("english")) {// number or english
				if (constraint.isEmpty())
					constraint = "numeng";
				else
					constraint += ",numeng";
			} else {// number
				if (constraint.isEmpty())
					constraint = "number";
				else
					constraint += ",number";
			}
		} else if (decos.containsKey("english")) {// english
			if (constraint.isEmpty())
				constraint = "english";
			else
				constraint += ",english";
		}
		if (decos.containsKey("unique")) {// unique
			if (constraint.isEmpty())
				constraint = "unique";
			else
				constraint += ",unique";
		}

		if (constraint != null && !constraint.isEmpty())
			ret += "<input type=\"hidden\" name=\"" + formname
					+ ":const\" value=\"" + constraint + "\" />";

		return ret;
	}

	protected String cond() {
		String ret = "";
		if (HTML_FlexboxEnv.formPartsNumber != HTML_FlexboxEnv.searchId) {
			HTML_FlexboxEnv.searchId = HTML_FlexboxEnv.formPartsNumber;
			if (!HTML_FlexboxEnv.condName.isEmpty() && !HTML_FlexboxEnv.cond.isEmpty()) {
				ret += "<input type=\"hidden\" name=\"cond_name"
						+ HTML_FlexboxEnv.formPartsNumber + "\" value=\""
						+ HTML_FlexboxEnv.condName + "\" />";
				ret += "<input type=\"hidden\" name=\"cond"
						+ HTML_FlexboxEnv.formPartsNumber + "\" value=\""
						+ HTML_FlexboxEnv.cond + "\" />";
				ret += "<input type=\"hidden\" name=\"value_type"
						+ HTML_FlexboxEnv.formPartsNumber + "\" value=\"String\" />";
			}
		}
		return ret;
	}

	protected <T> String computeStringForDecoration(ExtList<T> data_info) {
		String classNames = "";
		for (int i = 1; i < this.AttNames.size(); i++) {
			if (((data_info.get(i))).toString().equals("t")) {
				if (decos.getClassesIds().get(AttNames.get(i)) != null)
					classNames += " C_"
							+ decos.getClassesIds().get(AttNames.get(i));
			} else {
				if (decos.getClassesIds().get("!" + AttNames.get(i)) != null)
					classNames += " C_"
							+ decos.getClassesIds().get("!" + AttNames.get(i));
			}
		}
		return classNames;
	}
	
	private Element createLogoutForm(Element result, ExtList data_info){
		result = JsoupFactory.createSessionForm(result, "logout");
		result.appendChild(JsoupFactory.createInput("submit", "commit", this.getStr(data_info)));
		return result;
	}

}
