package supersql.codegenerator.VR;

import java.io.File;
import java.util.ArrayList;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

//added by goto

public class VRAttribute extends Attribute {

	private String[] formHtml = { "", "submit", "select", "checkbox", "radio",
			"text", "textarea", "hidden" };
	private String[] formSql = { "", "delete", "update", "insert", "login",
			"logout" };

	private VREnv htmlEnv;
	private VREnv htmlEnv2;
	private int whichForm;
	
	public static String genre = "";///////////kotani
	//public static boolean exhflag = false;//////展示物について、G1通ったらtrueになる////exhflagとfloorflagはC#ファイルを添付するためのフラグ
	public static ArrayList<Integer> exharray = new ArrayList<Integer>();///1ビルにつき、categoryの数だけ同じ数字が入る
	//public static int floorflag = 0;////////////フロアについて
	public static ArrayList<Integer> floorarray = new ArrayList<Integer>();
	public static String sgenre = "";//////////フロアのタイトル出すため
	public static ArrayList<String> genrearray2 = new ArrayList<String>();///カテゴリーごとのタイトルだす、Red,Whiteとか
	public static ArrayList<Integer> genrearray22 = new ArrayList<Integer>();//0,2,6ってgroupごとのカテゴリーの数を累積で入れていく
	public static int genrecount = 0;
	public static int gjoinflag = 0;///////////今使ってない
	public static int cjoinflag = 0;/////今使ってない
	public static int groupcount = 0;
	public static int groupcount1 = 0;
	public static int grouptag = 0;
	public static ArrayList<String> cjoinarray = new ArrayList<String>();////博物館同士を結合させる時分岐に使う
	public static int gjudge = 0;
	public static int billnum = 0;
	public static int seq = 0;
	public static ArrayList<String> elearray = new ArrayList<String>();

	// 鐃緒申鐃藷ストラク鐃緒申
	public VRAttribute(Manager manager, VREnv henv, VREnv henv2) {
		super();
		this.htmlEnv = henv;
		this.htmlEnv2 = henv2;
	}

	public VRAttribute(Manager manager, VREnv henv, VREnv henv2, boolean b) {
		super(b);
		this.htmlEnv = henv;
		this.htmlEnv2 = henv2;
	}

	private <T> String computeStringForDecoration(ExtList<T> data_info) {
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

	private String cond() {
		String ret = "";
		if (VREnv.formPartsNumber != VREnv.searchId) {
			VREnv.searchId = VREnv.formPartsNumber;
			if (!VREnv.condName.isEmpty() && !VREnv.cond.isEmpty()) {
				ret += "<input type=\"hidden\" name=\"cond_name"
						+ VREnv.formPartsNumber + "\" value=\""
						+ VREnv.condName + "\" />";
				ret += "<input type=\"hidden\" name=\"cond"
						+ VREnv.formPartsNumber + "\" value=\""
						+ VREnv.cond + "\" />";
				ret += "<input type=\"hidden\" name=\"value_type"
						+ VREnv.formPartsNumber + "\" value=\"String\" />";
			}
		}
		return ret;
	}

	private void createForm(ExtList data_info) {

		String name = new String();
		String inputFormString = new String();

		for (int i = 1; i < formSql.length; i++) {
			if (decos.containsKey(formSql[i])
					|| VREnv.getIDU().equals(formSql[i])) {
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

			} else {
				if (s.isEmpty()) {
					inputFormString += "<input type=\"text\" name=\"" + name
							+ "\" />";
				} else {
					inputFormString += "<input type=\"text\" name=\"" + name
							+ "\" value=\"" + s + "\" />";
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

			if (constraint != null && !constraint.isEmpty())
				inputFormString += "<input type=\"hidden\" name=\"" + name
						+ ":const\" value=\"" + constraint + "\" />";

			Log.out("pppppp" + decos.containsKey("pkey"));
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

		if (VREnv.getFormItemFlg()) {
			for (int i = 1; i < formHtml.length; i++) {
				String real_value = VREnv.getFormValueString();
				if (VREnv.getFormItemName().equals(formHtml[i])) {
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

	/*
	 * private String closeFormItems(String itemType){ String ret = new
	 * String(); tuple_count = 0; if(itemType.equals("select")){
	 * HTMLEnv.setSelectRepeat(false); ret = "</select>"; }
	 * HTMLEnv.incrementFormName(); return ret; }
	 */

	private String inputFormItems(ExtList data_info, String itemType,
			String real_value) {
		String ret = "";
		String formname = VREnv.getFormPartsName();
		;
		if (VREnv.getSearch()) {
			ret += cond();
			formname = "value" + VREnv.formPartsNumber;
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
			if (VREnv.getSelectRepeat() == false) {
				ret += "<select name=\"" + formname + "\">";
				VREnv.setSelectRepeat(true);
			}
			if (VREnv.getSelected().length() != 0
					&& VREnv.getSelected().equals(real_value)) {
				ret += "<option value=\"" + real_value + "\"" + size
						+ " selected=\"selected\" >" + s + "</option>";
			} else {
				ret += "<option value=\"" + real_value + "\"" + size + " >" + s
						+ "</option>";
			}
		} else if (itemType.equals(formHtml[3])) {// checkbox
			String checked = "";
			if (VREnv.getChecked().length() != 0
					&& VREnv.getChecked().equals(real_value)) {
				checked = " checked=\"checked\" ";
			}
			if (VREnv.nameId.length() != 0) {
				ret += "<input type=\"checkbox\" name=\"" + formname + "["
						+ VREnv.nameId + "]" + "\" value=\"" + real_value
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
			if (VREnv.getChecked().length() != 0
					&& VREnv.getChecked().equals(real_value)) {
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

	// Attribute鐃緒申work鐃潤ソ鐃獣ワ申
	@Override
	
	public String work(ExtList data_info) {
		
		/*
		 * if(GlobalEnv.getSelectFlg()) data_info = (ExtList) data_info.get(0);
		 */
		htmlEnv.append_css_def_td(VREnv.getClassID(this), this.decos);

		if (GlobalEnv.isOpt()) {
			work_opt(data_info);
		} else {
			if (VREnv.getFormItemFlg() && VREnv.getFormItemName().equals(formHtml[2])) {

			} else {
				
				if(htmlEnv.gLevel <= 1){//////// kotani 16/10/04////////タグのレベルが１(1個目のcategoryが０で、二個目のcategiryは１)だったら、ジャンルの名前持ってくる
					genre = this.getStr(data_info);////////////////////////////////////////////// kotani 16/10/04
					
				}else{
								//htmlEnv.code.append((seq)+" "+"<element" + htmlEnv.getOutlineModeAtt()+ "");
								//htmlEnv.code.append(this.getStr(data_info));
								try{//n2 kotani
									String s = elearray.get(seq);
									//elearray.set(seq, s+" "+seq+this.getStr(data_info)+"\n");////ここでelemenntたす、上のelementは消す
									elearray.set(seq, s+" "+"<element>"+this.getStr(data_info)+"</element>\n");
								}catch(Exception e){
									//elearray.add(seq, seq+this.getStr(data_info)+"\n");		
									elearray.add(seq, " <element>"+this.getStr(data_info)+"</element>\n");		
								}
								seq++;
								
					//htmlEnv.code.append("class=\"att"); elementタグにするため消した
								
				// tk
				// start/////////////////////////////////////////////////////////
				if (htmlEnv.writtenClassId.contains(VREnv.getClassID(this))) {
					// class鐃緒申鐃獣てわ申鐃緒申箸鐃x.TFE10000)�Τ߻���
					htmlEnv.code.append(" " + VREnv.getClassID(this));
				}
				if (decos.containsKey("class")) {
					// class����(ex.class=menu)������Ȥ�
					htmlEnv.code.append(" " + decos.getStr("class"));// added by masato 20140711　属性が一つのときにclassを指定しても機能しなかった問題を解決
				}
				if (decos.getConditions().size() > 0) {
					htmlEnv.code.append(" "
							+ computeStringForDecoration(data_info));
				}
				
				//htmlEnv.code.append("\"");elementタグにするため消した
				//htmlEnv.code.append(">");\\\\\element change
				}
			
			}
	
			if (VREnv.getFormItemFlg()) {

			} else {
				//htmlEnv.code.append("<tr><td>\n");
				//Log.out("<table class=\"att\"><tr><td>");
			}
			
		if(htmlEnv.gLevel == 1){////////////////////////////////////////////////////////////////////// kotani 16/10/04
				
			}else{
			
			if (htmlEnv.linkFlag > 0 || htmlEnv.sinvokeFlag) {

				// tk start for draggable
				// div///////////////////////////////////////
				if (htmlEnv.draggable) {
					htmlEnv.code.append("<div id=\"" + htmlEnv.dragDivId
							+ "\" class=\"draggable\"");
					Log.out("<div id=\"" + htmlEnv.dragDivId + "\" ");
				} else {
					// tk end for draggable
					// div/////////////////////////////////////////
					if (htmlEnv.isPanel)
						htmlEnv.code.append("<div id=\"container\">");

					// added by goto 20120614 start
					// [%Ϣ���
					// ������2�Ĥ����꤬���ä����ᡢhref�λ�������Хѥ���������Хѥ������פ��ѹ�
					// 1.���Хѥ�����Firefox�Ǥϥ����
					// ������ʤ�
					// 2.ITC�μ½��Ķ��Ǥϥ����
					// ������ʤ�
					String fileDir = new File(htmlEnv.linkUrl)
							.getAbsoluteFile().getParent();
					if (fileDir.length() < htmlEnv.linkUrl.length()
							&& fileDir.equals(htmlEnv.linkUrl.substring(0,
									fileDir.length()))) {
						String relative_path = htmlEnv.linkUrl
								.substring(fileDir.length() + 1);
						htmlEnv.code.append("<A href=\"" + relative_path
								+ "\" ");
					} else
						htmlEnv.code.append("<A href=\"" + htmlEnv.linkUrl
								+ "\" ");

					// html_env.code.append("<A href=\"" + html_env.linkurl +
					// "\" ");
					// added by goto 20120614 end

				}
				// tk
				// start//////////////////////////////////////////////////////////
				if (decos.containsKey("target")) {
					htmlEnv.code.append(" target=\"" + decos.getStr("target")
							+ "\"");
				}
				if (decos.containsKey("class")) {
					htmlEnv.code.append(" class=\"" + decos.getStr("class")
							+ "\"");
				}

				if (GlobalEnv.isAjax() && htmlEnv.isPanel) {
					htmlEnv.code.append(" onClick =\"return panel('Panel','"
							+ htmlEnv.ajaxQuery + "'," + "'"
							+ htmlEnv.dragDivId + "','" + htmlEnv.ajaxCond
							+ "')\"");
				} else if (GlobalEnv.isAjax() && !htmlEnv.draggable) {
					String target = GlobalEnv.getAjaxTarget();
					if (target == null) {
						String query = htmlEnv.ajaxQuery;
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

						if (htmlEnv.hasDispDiv) {
							target = htmlEnv.ajaxtarget;
						}
						Log.out("a target:" + target);
					}
					htmlEnv.code.append(" onClick =\"return loadFile('"
							+ htmlEnv.ajaxQuery + "','" + target + "','"
							+ htmlEnv.ajaxCond + "'," + htmlEnv.inEffect + ","
							+ htmlEnv.outEffect + ")\"");

				}
				if(htmlEnv.gLevel == 1){//////// kotani 16/10/04
					
				}else{
				//htmlEnv.code.append(">\n");
				}
				// tk
				// end////////////////////////////////////////////////////////////

				Log.out("<A href=\"" + htmlEnv.linkUrl + "\">");
			}
			}

			// Log.out("data_info: "+this.getStr(data_info));
		
		
		if(htmlEnv.gLevel == 1){/////////////////////////////////////////////////////////// kotani 16/10/04
			
		}else{
			createForm(data_info);

			if (whichForm == 0) { // normal process (not form)
				// ***APPEND DATABASE VALUE***//
				Log.out(data_info);
				
				Log.out(this.getStr(data_info));
			}
		}

//			if (htmlEnv.linkFlag > 0 || htmlEnv.sinvokeFlag) { 20160918 kotani
//				if (htmlEnv.draggable)
//					htmlEnv.code.append("</div>\n");
//				else {
//					htmlEnv.code.append("</A>\n");
//
//					if (htmlEnv.isPanel)
//						htmlEnv.code.append("</div>\n");
//				}
//				Log.out("</A>");
//			}

			/*
			 * if(whichForm > 0){ html_env.code.append("\" />\n");
			 * Log.out("\" \\>\n"); }
			 */

			// Log.out("tuple: " + tuple_count + "/"+GlobalEnv.getTuplesNum() );

			if (VREnv.getFormItemFlg()
					&& VREnv.getFormItemName().equals(formHtml[2])) {

			} else {
				if(htmlEnv.gLevel == 1){//////////////////////////////////////////////////////////// kotani 16/10/04
					
				}else{
				//htmlEnv.code.append("</element>\n");//</td></tr></table>消した。</table>だけ残した→elementにした element change
//				Log.out("</td></tr></table>");
				}
			}

			Log.out("TFEId = " + VREnv.getClassID(this));
			// html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
			}
		
		return null;
		
	
	}
	

	// optimizer
	public void work_opt(ExtList data_info) {
		StringBuffer string_tmp = new StringBuffer();
		string_tmp.append("<VALUE");
		if (htmlEnv.writtenClassId.contains(VREnv.getClassID(this))) {
			// class���äƤ���Ȥ�
			// ex.TFE10000)�Τ߻���
			string_tmp.append(" class=\"");
			//string_tmp.append(VREnv.getClassID(this));
		}

		if (decos.containsKey("class")) {
			// class����(ex.class=menu)������Ȥ�
			if (!htmlEnv.writtenClassId.contains(VREnv.getClassID(this))) {
				string_tmp.append(" class=\"");
			} else {
				string_tmp.append(" ");
			}
			string_tmp.append(decos.getStr("class") + "\"");
		} else if (htmlEnv.writtenClassId.contains(VREnv.getClassID(this))) {
			string_tmp.append("\"");
		}

		if (decos.containsKey("update") || decos.containsKey("insert")
				|| decos.containsKey("delete") || decos.containsKey("login")
				|| decos.containsKey("logout") || VREnv.getFormItemFlg()
				|| (VREnv.getIDU() != null && !VREnv.getIDU().isEmpty())) {
			string_tmp.append(" type=\"form\"");
		}

		if (decos.containsKey("tabletype")) {
			string_tmp.append(" tabletype=\"" + decos.getStr("tabletype")
					+ "\"");
		}

		// link and sinvoke
		if (htmlEnv.linkFlag > 0 || htmlEnv.sinvokeFlag) {
			string_tmp.append(" href=\"" + htmlEnv.linkUrl + "\" ");
			if (decos.containsKey("target")) {
				string_tmp.append(" target=\"" + decos.getStr("target") + "\"");
			}
			if (decos.containsKey("class")) {
				string_tmp.append("class=\"" + decos.getStr("class") + "\"");
			}
		}

		string_tmp.append(">");

		if (VREnv.getFormItemFlg()
				&& VREnv.getFormItemName().equals(formHtml[2])
				&& VREnv.getSelectRepeat()) {

		} else {
			htmlEnv2.code.append(string_tmp);
			Log.out(string_tmp);
		}

		createForm(data_info);

		if (whichForm == 0) {
			// ***APPEND DATABASE VALUE***//
			String s = this.getStr(data_info);
			if (s.contains("&"))
				s = s.replace("&", "&amp;");
			if (s.contains("<"))
				s = s.replaceAll("<", "&lt;");
			if (s.contains(">"))
				s = s.replaceAll(">", "&gt;");
			if (s.contains("���"))
				s = s.replaceAll("���", "&#65374;");
			if (s.isEmpty())
				s = "��";
			htmlEnv2.code.append(s);
			Log.out(this.getStr(data_info));
		}

		/*
		 * if(decos.containsKey("update") || decos.containsKey("insert")||
		 * decos.containsKey("delete") || decos.containsKey("login")){
		 * html_env2.code.append("\" />"); Log.out("\" \\>\n"); }
		 */

		// Log.out("tuple: " + tuple_count + "/"+GlobalEnv.getTuplesNum() );

		if (VREnv.getFormItemFlg()
				&& VREnv.getFormItemName().equals(formHtml[2])) {
			// select
		} else {
			htmlEnv2.code.append("</VALUE>");
			Log.out("</VALUE>");
			if (VREnv.getFormItemFlg()
					&& VREnv.getFormItemName().equals(formHtml[5])) {
				VREnv.incrementFormPartsNumber();
			}
		}

	}

}
