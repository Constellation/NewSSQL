package supersql.codegenerator.HTML5;

import supersql.codegenerator.Manager;
import supersql.codegenerator.HTML.HTMLAttribute;
import supersql.codegenerator.HTML.HTMLEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class HTML5Attribute extends HTMLAttribute {

	private String[] formSql = {"","delete","update","insert","login","logout"};
	private String[] formHtml = {"","submit","select","checkbox","radio","text","textarea","hidden"};
	private int whichForm;

	//���󥹥ȥ饯��
	public HTML5Attribute(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		super(manager, henv, henv2);
	}
	
	public HTML5Attribute(Manager manager, HTML5Env henv, HTML5Env henv2, boolean b) {
		super(manager, henv, henv2, b);
	}

	@Override
	protected void createForm(ExtList data_info){

		new String();
		String name = new String();
		String inputFormString = new String();

		for(int i = 1; i < formSql.length ; i++ ){
			if(decos.containsKey(formSql[i]) || HTML5Env.getIDU().equals(formSql[i])){
				switch(i){
				case 1 : //delete
					if(decos.containsKey(formSql[i])){
						name = decos.getStr("delete");
					}else{
						name = decos.getStr("attributeName");
					}
					inputFormString += "<input type=\"checkbox\" name=\"" + name + "\" value=\"" + this.getStr(data_info) + "\" />";
					whichForm = i;
					break;
				case 2 : //update
					if(decos.containsKey(formSql[i])){
						name = decos.getStr("update");
					}else{
						name = decos.getStr("attributeName");
					}
					whichForm = i;
					break;
				case 3 : //insert
					if(decos.containsKey(formSql[i])){
						name = decos.getStr("insert");
					}else{
						name = decos.getStr("attributeName");
					}
					whichForm = i;
					break;
				case 4 : //login
					name = decos.getStr("login");
					if(decos.containsKey("att")){
						inputFormString += "<input type=\"hidden\" name=\"att\" value=\"" + decos.getStr("att") +"\" />";
					}
					whichForm = i;
					break;
				case 5 : //logout
					inputFormString += "<input type=\"hidden\" name=\"sqlfile\" value=\""+decos.getStr("linkfile").replace("\"", "")+"\" />";
					inputFormString += "<input type=\"submit\" name=\"logout\" value=\""+this.getStr(data_info)+"\" />";
					whichForm = i;
					break;
				}
			}
		}


		if( 1 < whichForm && whichForm < formSql.length-1 ){ //update,insert,login
			String s;
			if(whichForm < 3) {//update
				s = this.getStr(data_info);
			}else{//insert,login,logout
				s = "";
			}
			if(decos.containsKey("pwd")){
				inputFormString += "<input type=\"password\" name=\"" + name + "\" value=\"" + s + "\" />";
				if(decos.containsKey("md5")){
					inputFormString += "<input type=\"hidden\" name=\"" + name + ":pwd\" value=\"md5\" />";
				}
			}if(decos.containsKey("img")){
				inputFormString +="<input type=\"file\" name=\"" + name + "\" value=\"" + s + "\" >";
			}else{
				//ishizaki start (html5)
				if(s.isEmpty()){
					//inputFormString += "<input type=\"text\" name=\"" + name + "\" />";
					if(decos.containsKey("type")){
						if(decos.getStr("type").equals("tel"))
							inputFormString += "<input type=\"tel\" name=\"" + name + "\" pattern=\"\\d{2,4}-\\d{2,4}-\\d{4}\"/>";
						if(decos.getStr("type").equals("mail"))
							inputFormString += "<input type=\"email\" name=\"" + name +
							"\" pattern=\"[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+\"/>";
						if(decos.getStr("type").equals("age"))
							inputFormString += "<input type=\"text\" name=\"" + name + "\" pattern=\"\\d{1,3}\" >";
						if(decos.getStr("type").equals("url"))
							inputFormString += "<input type=\"url\" name=\"" + name + "\" >";
					}else
						inputFormString += "<input type=\"text\" name=\"" + name + "\" />";
				}else{
					//inputFormString += "<input type=\"text\" name=\"" + name + "\" value=\"" + s + "\" />";
					if(decos.containsKey("type")){
						if(decos.getStr("type").equals("tel")){
							inputFormString += "<input type=\"tel\" name=\"" + name + "\" pattern=\"\\d{2,4}-\\d{2,4}-\\d{4}\"/ value=\"" + s + "\">";
						}else if(decos.getStr("type").equals("mail")){
							inputFormString += "<input type=\"email\" name=\"" + name +
							"\" pattern=\"[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+\"/ value=\"" + s + "\">";
						}else if(decos.getStr("type").equals("age")){
							inputFormString += "<input type=\"text\" name=\"" + name + "\" pattern=\"\\d{1,3}\" value=\"" + s + "\">";
						}else if(decos.getStr("type").equals("url")){
							inputFormString += "<input type=\"url\" name=\"" + name + "\" value=\"" + s + "\">";
						}else
							inputFormString += "<input type=\"text\" name=\"" + name + "\" value=\"" + s + "\"/>";
					}else
							inputFormString += "<input type=\"text\" name=\"" + name + "\" value=\"" + s + "\"/>";
				}
				/*
				if(s.isEmpty()){
					inputFormString += "<input ref=\"" + name + "\"><label></label></input>";
				}else{
					inputFormString += "<input ref=\"" + name + "\"><label>" + s + "</label></input>";
				}
				*/
				//ishizaki end(html5)

			}

			//add constraint
			String constraint = new String();
			if(decos.containsKey("notnull")){//not null
				constraint = "notnull";
			}
			if(decos.containsKey("number")){//num or eng
				if(decos.containsKey("english")){
					if(constraint.isEmpty())
						constraint = "numeng";
					else
						constraint += ",numeng";
				}else{//number
					if(constraint.isEmpty())
						constraint = "number";
					else
						constraint += ",number";
				}
			}else if(decos.containsKey("english")){//eng
				if(constraint.isEmpty())
					constraint = "english";
				else
					constraint += ",english";
			}

			if(decos.containsKey("unique")){//unique
				if(constraint.isEmpty())
					constraint = "unique";
				else
					constraint += ",unique";
			}

			if(constraint != null && !constraint.isEmpty())
				inputFormString += "<input type=\"hidden\" name=\""+ name +":const\" value=\""+ constraint +"\" />";


			Log.out("pppppp"+decos.containsKey("pkey"));
			if(decos.containsKey("pkey") && whichForm == 2){//update
				if(!htmlEnv.code.toString().contains("<input type=\"hidden\" name=\"pkey\" value=\"" + name + "\" />"))
					inputFormString += "<input type=\"hidden\" name=\"pkey\" value=\"" + name + "\" />";
			}
		}

		htmlEnv.code.append(inputFormString);
		htmlEnv2.code.append(inputFormString);
		Log.out(inputFormString);

		inputFormString = new String();

		if(HTML5Env.getFormItemFlg()){
			for(int i = 1; i < formHtml.length ; i++ ){
				String real_value = HTML5Env.getFormValueString();
				if(HTML5Env.getFormItemName().equals(formHtml[i])){
					switch(i){
					case 1: //submit
						inputFormString = inputFormItems(data_info,formHtml[i],"");
						whichForm =  i + formSql.length;
						break;
					case 2: //select
						inputFormString = inputFormItems(data_info,formHtml[i],real_value);
						whichForm =  i + formSql.length;
						break;
					case 3: //checkbox
						inputFormString = inputFormItems(data_info,formHtml[i],real_value);
						whichForm =  i + formSql.length;
						break;
					case 4: //radio
						inputFormString = inputFormItems(data_info,formHtml[i],real_value);
						whichForm =  i + formSql.length;
						break;

					case 5: //input text
						inputFormString = inputFormItems(data_info,formHtml[i],real_value);
						whichForm =  i + formSql.length;
						break;

					case 6: //textarea
						inputFormString = inputFormItems(data_info,formHtml[i],real_value);
						whichForm =  i + formSql.length;
						break;

					case 7: //hidden
						inputFormString = inputFormItems(data_info,formHtml[i],real_value);
						whichForm =  i + formSql.length;
						break;
					}
				}
			}
		}

		htmlEnv.code.append(inputFormString);
		htmlEnv2.code.append(inputFormString);
		Log.out(inputFormString);


	}

	@Override
	protected String inputFormItems(ExtList data_info,String itemType,String real_value){
		String ret = "";
		String formname = HTML5Env.getFormPartsName();;
		if(HTML5Env.getSearch()){
			ret += cond();
			formname = "value"+HTML5Env.formPartsNumber;
		}
		String s = this.getStr(data_info);
		//tuple_count++;
		if(real_value.isEmpty()){
			real_value = s;
		}
		//sizeoption
		String size = new String();
		if(decos.containsKey("size")){
			size += " size=\""+ decos.getStr("size")+"\"";
		}
		if(decos.containsKey("height")){
			size += " height=\""+ decos.getStr("height")+"\"";
		}
		if(decos.containsKey("cols")){
			size += " cols=\""+ decos.getStr("cols")+"\"";
		}
		if(decos.containsKey("rows")){
			size += " rows=\""+ decos.getStr("rows")+"\"";
		}

		if(decos.containsKey("class")){
			size += " class=\""+ decos.getStr("class")+"\"";
		}

		if(itemType.equals(formHtml[1])){//submit

		}else if(itemType.equals(formHtml[2])){//select
			if(HTML5Env.getSelectRepeat() == false){
				ret += "<select name=\""+ formname +"\">";
				HTML5Env.setSelectRepeat(true);
			}
			if(HTML5Env.getSelected().length() != 0 && HTML5Env.getSelected().equals(real_value)){
				ret += "<option value=\"" + real_value + "\"" + size +" selected=\"selected\" >" + s + "</option>";
			}else{
				ret += "<option value=\"" + real_value + "\"" + size +" >" + s + "</option>";
			}
		}else if(itemType.equals(formHtml[3])){//checkbox
			String checked = "";
			if(HTML5Env.getChecked().length() != 0 && HTML5Env.getChecked().equals(real_value)){
				checked = " checked=\"checked\" ";
			}
			if(HTML5Env.nameId.length() != 0){
				ret += "<input type=\"checkbox\" name=\""+ formname + "[" + HTML5Env.nameId+ "]" + "\" value=\"" + real_value + "\"" + size + checked +" />";
				ret += s;
			}else{
				ret += "<input type=\"checkbox\" name=\""+ formname +"\" value=\"" + real_value + "\"" + size + checked +" />";
				ret += s;
			}
		}else if(itemType.equals(formHtml[4])){//radio
			String checked = "";
			if(HTML5Env.getChecked().length() != 0 && HTML5Env.getChecked().equals(real_value)){
				checked = " checked=\"checked\" ";
			}
			ret += "<input type=\"radio\" name=\""+ formname +"\" value=\"" + real_value + "\"" + size + checked + " />";
			ret += s;
		}else if(itemType.equals(formHtml[5])){//text
			if(decos.containsKey("pwd")){
				ret += "<input type=\"password\" name=\""+ formname +"\" value=\"" + real_value + "\"" + size +" />";
				if(decos.containsKey("md5")){
					ret += "<input type=\"hidden\" name=\"" + formname + ":pwd\" value=\"md5\" />";
				}
			}else{
				ret += "<input type=\"text\" name=\""+ formname +"\" value=\"" + real_value + "\"" + size +" />";
			}
		}else if(itemType.equals(formHtml[6])){//textarea
			ret += "<textarea name=\""+ formname + "\"" + size +">";
			if(s != null){
				ret += s;
			}
			ret += "</textarea>";
		}else if(itemType.equals(formHtml[7])){//text
			ret += "<input type=\"hidden\" name=\""+ formname +"\" value=\"" + real_value + "\"" + size +" />";
		}

		String constraint = new String();
		if(decos.containsKey("notnull")){
			constraint = "notnull";
		}
		if(decos.containsKey("number")){
			if(decos.containsKey("english")){//number or english
				if(constraint.isEmpty())
					constraint = "numeng";
				else
					constraint += ",numeng";
			}else{//number
				if(constraint.isEmpty())
					constraint = "number";
				else
					constraint += ",number";
			}
		}else if(decos.containsKey("english")){//english
			if(constraint.isEmpty())
				constraint = "english";
			else
				constraint += ",english";
		}
		if(decos.containsKey("unique")){//unique
			if(constraint.isEmpty())
				constraint = "unique";
			else
				constraint += ",unique";
		}

		if(constraint != null && !constraint.isEmpty())
			ret += "<input type=\"hidden\" name=\""+ formname +":const\" value=\""+ constraint +"\" />";


		return ret;
	}

}
