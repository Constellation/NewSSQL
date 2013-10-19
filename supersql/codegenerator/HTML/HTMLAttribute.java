package supersql.codegenerator.HTML;

import java.io.File;

import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTMLAttribute extends Attribute {

	protected HTMLEnv htmlEnv;
	protected HTMLEnv htmlEnv2;

	protected String[] formSql = { "", "delete", "update", "insert", "login",
			"logout" };
	protected String[] formHtml = { "", "submit", "select", "checkbox",
			"radio", "text", "textarea", "hidden" };
	protected int whichForm;

	// ���󥹥ȥ饯��
	public HTMLAttribute(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		super();
		this.htmlEnv = henv;
		this.htmlEnv2 = henv2;
	}

	public HTMLAttribute(Manager manager, HTMLEnv henv, HTMLEnv henv2, boolean b) {
		super(b);
		this.htmlEnv = henv;
		this.htmlEnv2 = henv2;
	}

	@Override
	public Element createNode(ExtList data_info) {
		Element result = new Element(Tag.valueOf("span"), "");
		result.addClass("box");
		htmlEnv.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

		if (!(HTMLEnv.getFormItemFlg() && HTMLEnv.getFormItemName().equals(
				formHtml[2]))) {
			result.addClass("att");
			if (htmlEnv.writtenClassId.contains(HTMLEnv.getClassID(this))) {
				result.addClass(HTMLEnv.getClassID(this));
			}
			if (decos.containsKey("class")) {
				result.addClass(decos.getStr("class"));
			}
			if (decos.getConditions().size() > 0) {
				result.addClass(computeStringForDecoration(data_info));
			}
		}
		Element div = new Element(Tag.valueOf("div"), "");
		Element a = new Element(Tag.valueOf("a"), "");

		if (htmlEnv.linkFlag > 0) {

			// tk start for draggable div///////////////////////////////////////
			if (htmlEnv.draggable) {
				div.addClass("draggable").attr("id", htmlEnv.dragDivId);
				htmlEnv.code.append("<div id=\"" + htmlEnv.dragDivId
						+ "\" class=\"draggable\"");
				Log.out("<div id=\"" + htmlEnv.dragDivId + "\" ");
			} else {
				// tk end for draggable
				// div/////////////////////////////////////////
				if (htmlEnv.isPanel)
					div.attr("id", "container");

				String fileDir = new File(htmlEnv.linkUrl).getAbsoluteFile()
						.getParent();
				if (fileDir.length() < htmlEnv.linkUrl.length()
						&& fileDir.equals(htmlEnv.linkUrl.substring(0,
								fileDir.length()))) {
					String relative_path = htmlEnv.linkUrl.substring(fileDir
							.length() + 1);
					a = new Element(Tag.valueOf("a"), "").attr("href",
							relative_path);
				} else
					a = new Element(Tag.valueOf("a"), "").attr("href",
							htmlEnv.linkUrl);
			}
			if (decos.containsKey("target")) {
				a.attr("target", decos.getStr("target"));
			}
			if (decos.containsKey("class")) {
				a.addClass(decos.getStr("class"));
			}

			if (GlobalEnv.isAjax() && htmlEnv.isPanel) {
				a.attr("onClick", "return panel('Panel','" + htmlEnv.ajaxQuery
						+ "'," + "'" + htmlEnv.dragDivId + "','"
						+ htmlEnv.ajaxCond + "')");
			} else if (GlobalEnv.isAjax() && !htmlEnv.draggable) {
				String target = GlobalEnv.getAjaxTarget();
				if (target == null) {
					String query = htmlEnv.ajaxQuery;
					if (query.contains("/")) {
						target = query.substring(query.lastIndexOf("/") + 1,
								query.indexOf(".sql"));
					} else
						target = query.substring(0, query.indexOf(".sql"));

					if (htmlEnv.hasDispDiv) {
						target = htmlEnv.ajaxtarget;
					}
				}
				a.attr("onClick", "return loadFile('" + htmlEnv.ajaxQuery
						+ "','" + target + "','" + htmlEnv.ajaxCond + "',"
						+ htmlEnv.inEffect + "," + htmlEnv.outEffect + ")");
			}
		}

		// ***APPEND DATABASE VALUE***//
		String elementText = this.getStr(data_info);
		elementText = elementText.replace(" ", "&#160;");
		result.html(elementText);

		if (htmlEnv.linkFlag > 0) {
			if (htmlEnv.draggable)
				result.appendChild(div);
			else {
				a.html(this.getStr(data_info));
				a.addClass("box");
				if (htmlEnv.isPanel)
					a.appendChild(div);
				return a;
			}
		}
		decos.remove("attributeName");
		HTMLUtils.processDecos(result, decos);
		return result;
	}

	protected void createForm(ExtList data_info) {

		String name = new String();
		String inputFormString = new String();

		for (int i = 1; i < formSql.length; i++) {
			if (decos.containsKey(formSql[i])
					|| HTMLEnv.getIDU().equals(formSql[i])) {
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
				/*
				 * if(s.isEmpty()){ inputFormString += "<input ref=\"" + name +
				 * "\"><label></label></input>"; }else{ inputFormString +=
				 * "<input ref=\"" + name + "\"><label>" + s +
				 * "</label></input>"; }
				 */
				// ishizaki end(html5)

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

			if (constraint != null && !constraint.isEmpty())
				inputFormString += "<input type=\"hidden\" name=\"" + name
						+ ":const\" value=\"" + constraint + "\" />";

			if (decos.containsKey("pkey") && whichForm == 2) {// update
				if (!htmlEnv.code.toString().contains(
						"<input type=\"hidden\" name=\"pkey\" value=\"" + name
								+ "\" />"))
					inputFormString += "<input type=\"hidden\" name=\"pkey\" value=\""
							+ name + "\" />";
			}
		}

		htmlEnv.code.append(inputFormString);
		htmlEnv2.code.append(inputFormString);
		Log.out(inputFormString);

		inputFormString = new String();

		if (HTMLEnv.getFormItemFlg()) {
			for (int i = 1; i < formHtml.length; i++) {
				String real_value = HTMLEnv.getFormValueString();
				if (HTMLEnv.getFormItemName().equals(formHtml[i])) {
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

		htmlEnv.code.append(inputFormString);
		htmlEnv2.code.append(inputFormString);
		Log.out(inputFormString);

	}

	protected String inputFormItems(ExtList data_info, String itemType,
			String real_value) {
		String ret = "";
		String formname = HTMLEnv.getFormPartsName();
		;
		if (HTMLEnv.getSearch()) {
			ret += cond();
			formname = "value" + HTMLEnv.formPartsNumber;
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
			if (HTMLEnv.getSelectRepeat() == false) {
				ret += "<select name=\"" + formname + "\">";
				HTMLEnv.setSelectRepeat(true);
			}
			if (HTMLEnv.getSelected().length() != 0
					&& HTMLEnv.getSelected().equals(real_value)) {
				ret += "<option value=\"" + real_value + "\"" + size
						+ " selected=\"selected\" >" + s + "</option>";
			} else {
				ret += "<option value=\"" + real_value + "\"" + size + " >" + s
						+ "</option>";
			}
		} else if (itemType.equals(formHtml[3])) {// checkbox
			String checked = "";
			if (HTMLEnv.getChecked().length() != 0
					&& HTMLEnv.getChecked().equals(real_value)) {
				checked = " checked=\"checked\" ";
			}
			if (HTMLEnv.nameId.length() != 0) {
				ret += "<input type=\"checkbox\" name=\"" + formname + "["
						+ HTMLEnv.nameId + "]" + "\" value=\"" + real_value
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
			if (HTMLEnv.getChecked().length() != 0
					&& HTMLEnv.getChecked().equals(real_value)) {
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
		if (HTMLEnv.formPartsNumber != HTMLEnv.searchId) {
			HTMLEnv.searchId = HTMLEnv.formPartsNumber;
			if (!HTMLEnv.condName.isEmpty() && !HTMLEnv.cond.isEmpty()) {
				ret += "<input type=\"hidden\" name=\"cond_name"
						+ HTMLEnv.formPartsNumber + "\" value=\""
						+ HTMLEnv.condName + "\" />";
				ret += "<input type=\"hidden\" name=\"cond"
						+ HTMLEnv.formPartsNumber + "\" value=\""
						+ HTMLEnv.cond + "\" />";
				ret += "<input type=\"hidden\" name=\"value_type"
						+ HTMLEnv.formPartsNumber + "\" value=\"String\" />";
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

}
