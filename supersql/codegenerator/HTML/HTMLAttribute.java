package supersql.codegenerator.HTML;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Connector;
import supersql.codegenerator.Manager;
import supersql.common.Log;
import supersql.extendclass.ExtList;
import supersql.common.GlobalEnv;
import java.io.File;				//added by goto

public class HTMLAttribute extends Attribute {

	Manager manager;

	HTMLEnv html_env;
	HTMLEnv html_env2;

	String[] formSql = {"","delete","update","insert","login","logout"};
	String[] formHtml = {"","submit","select","checkbox","radio","text","textarea","hidden"};
	int whichForm;

	Connector connector;	//add oka

	int loop_counter;		//add oka

	static String alias;	//add oka

	int colum_num;			//add oka
	

	//¥³¥ó¥¹¥È¥é¥¯¥¿
	public HTMLAttribute(Manager manager, HTMLEnv henv, HTMLEnv henv2) {
		super();
		this.manager = manager;
		this.html_env = henv;
		this.html_env2 = henv2;
	}
	
	public HTMLAttribute(Manager manager, HTMLEnv henv, HTMLEnv henv2, boolean b) {
		super(b);
		this.manager = manager;
		this.html_env = henv;
		this.html_env2 = henv2;
	}
	//Attributeï¿½ï¿½workï¿½á¥½ï¿½Ã¥ï¿½
	public void work(ExtList data_info) {
		/*
        if(GlobalEnv.getSelectFlg())
        	data_info = (ExtList) data_info.get(0);
        	*/
		html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

		if(GlobalEnv.isOpt()){
			work_opt(data_info);
		}else{
			if(HTMLEnv.getFormItemFlg() && HTMLEnv.getFormItemName().equals(formHtml[2])){

			}else{
				html_env.code.append("<table" + html_env.getOutlineModeAtt() + " ");
				html_env.code.append("class=\"att");
				//tk start/////////////////////////////////////////////////////////
				if(html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
					//classï¿½ï¿½ï¿½Ã¤Æ¤ï¿½ï¿½ï¿½È¤ï¿ex.TFE10000)ï¿½Î¤ß»ï¿½ï¿½ï¿½ 
					html_env.code.append(" " + HTMLEnv.getClassID(this));
				}
				if(decos.containsKey("class")){ 
					//classï¿½ï¿½ï¿½ï¿½(ex.class=menu)ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½È¤ï¿					html_env.code.append(" " + decos.getStr("class"));    	
				}
				if(decos.getConditions().size() > 0){
					html_env.code.append(" "+computeStringForDecoration(data_info));
				}
				html_env.code.append("\"");
				html_env.code.append(">");
			}

			if(HTMLEnv.getFormItemFlg()){

			}else{
				html_env.code.append("<tr><td>\n");
				Log.out("<table class=\"att\"><tr><td>");
			}

			if (html_env.linkFlag > 0 || html_env.sinvokeFlag) {

				//tk start for draggable div///////////////////////////////////////
				if(html_env.draggable)
				{	
					html_env.code.append("<div id=\""+html_env.dragDivId+"\" class=\"draggable\"");
					Log.out("<div id=\""+html_env.dragDivId+"\" ");
				}	
				else{
					//tk end for draggable div/////////////////////////////////////////
					if(html_env.isPanel)
						html_env.code.append("<div id=\"container\">");

					//added by goto 20120614 start
					//[%Ï¢ï¿½ï¿½ï¿
					//ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½2ï¿½Ä¤ï¿½ï¿½ï¿½ï¿½ê¤¬ï¿½ï¿½ï¿½Ã¤ï¿½ï¿½ï¿½ï¿½á¡¢hrefï¿½Î»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ð¥Ñ¥ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ð¥Ñ¥ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½×¤ï¿½ï¿½Ñ¹ï¿½
					//1.ï¿½ï¿½ï¿½Ð¥Ñ¥ï¿½ï¿½ï¿½ï¿½ï¿½Firefoxï¿½Ç¤Ï¥ï¿½ï¿½ï¿½è¤
					//¿½ï¿½ï¿½ï¿½ï¿½Ê¤ï¿
					//2.ITCï¿½Î¼Â½ï¿½ï¿½Ä¶ï¿½ï¿½Ç¤Ï¥ï¿½ï¿½ï¿½è¤
					//¿½ï¿½ï¿½ï¿½ï¿½Ê¤ï¿		
					String fileDir = new File(html_env.linkUrl).getAbsoluteFile().getParent();
					if(fileDir.length() < html_env.linkUrl.length()
					&& fileDir.equals(html_env.linkUrl.substring(0,fileDir.length()))){
						String relative_path = html_env.linkUrl.substring(fileDir.length()+1);
						html_env.code.append("<A href=\"" + relative_path + "\" ");
					}else
						html_env.code.append("<A href=\"" + html_env.linkUrl + "\" ");
					
					//html_env.code.append("<A href=\"" + html_env.linkurl + "\" ");
					//added by goto 20120614 end
					
				}
				//tk start//////////////////////////////////////////////////////////
				if(decos.containsKey("target")){
					html_env.code.append(" target=\"" + decos.getStr("target")+"\"");
				}
				if(decos.containsKey("class")){
					html_env.code.append(" class=\"" + decos.getStr("class") + "\"");
				}

				if(GlobalEnv.isAjax() && html_env.isPanel)
				{
					html_env.code.append(" onClick =\"return panel('Panel','"+html_env.ajaxQuery+"'," +
							"'"+html_env.dragDivId+"','"+html_env.ajaxCond+"')\"");
				}
				else if(GlobalEnv.isAjax() && !html_env.draggable)
				{
					String target = GlobalEnv.getAjaxTarget();
					if(target == null)
					{
						String query = html_env.ajaxQuery;
						if(query.contains("/"))
						{
							target = query.substring(query.lastIndexOf("/")+1,query.indexOf(".sql"));
						}
						else
							target = query.substring(0,query.indexOf(".sql"));

						if(html_env.hasDispDiv)
						{
							target = html_env.ajaxtarget;
						}
						Log.out("a target:"+target);
					}
					html_env.code.append(" onClick =\"return loadFile('"+html_env.ajaxQuery+"','"+target+
							"','"+html_env.ajaxCond+"',"+html_env.inEffect+","+html_env.outEffect+")\"");

				}


				html_env.code.append(">\n");
				//tk end////////////////////////////////////////////////////////////

				Log.out("<A href=\"" + html_env.linkUrl + "\">");
			}

			//Log.out("data_info: "+this.getStr(data_info));

			createForm(data_info);
			

			if(whichForm == 0){ //normal process (not form)
				//***APPEND DATABASE VALUE***//
				Log.out(data_info);
				html_env.code.append(this.getStr(data_info));

				Log.out(this.getStr(data_info));
			}

			if (html_env.linkFlag > 0 || html_env.sinvokeFlag) {
				if(html_env.draggable)
					html_env.code.append("</div>\n");
				else
				{
					html_env.code.append("</A>\n");

					if(html_env.isPanel)
						html_env.code.append("</div>\n");
				}
				Log.out("</A>");
			}

			/*
			if(whichForm > 0){
				html_env.code.append("\" />\n");
				Log.out("\" \\>\n");
			}
			*/
			


			//Log.out("tuple: " + tuple_count + "/"+GlobalEnv.getTuplesNum() );
			
			if(HTMLEnv.getFormItemFlg() && HTMLEnv.getFormItemName().equals(formHtml[2])){
				
			}else{
				html_env.code.append("</td></tr></table>\n");
				Log.out("</td></tr></table>");
			}


			Log.out("TFEId = " + HTMLEnv.getClassID(this));
			//html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
		}

	}

	//optimizer
	public void work_opt(ExtList data_info){
		StringBuffer string_tmp = new StringBuffer();
		string_tmp.append("<VALUE");
		if(html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
			//classï¿½ï¿½ï¿½Ã¤Æ¤ï¿½ï¿½ï¿½È¤ï¿
			//ex.TFE10000)ï¿½Î¤ß»ï¿½ï¿½ï¿½ 
			string_tmp.append(" class=\"");
			string_tmp.append(HTMLEnv.getClassID(this));
		}

		if(decos.containsKey("class")){ 
			//classï¿½ï¿½ï¿½ï¿½(ex.class=menu)ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½È¤ï¿
			if(!html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){
				string_tmp.append(" class=\"");
			}else{
				string_tmp.append(" ");
			}
			string_tmp.append(decos.getStr("class") + "\"");
		}else if(html_env.writtenClassId.contains(HTMLEnv.getClassID(this))){ 
			string_tmp.append("\"");
		}

		if(decos.containsKey("update") || decos.containsKey("insert")||decos.containsKey("delete")||decos.containsKey("login")||decos.containsKey("logout") || HTMLEnv.getFormItemFlg() ||
			(HTMLEnv.getIDU()!= null && !HTMLEnv.getIDU().isEmpty())){
			string_tmp.append(" type=\"form\"");
		}


		if(decos.containsKey("tabletype")){
			string_tmp.append(" tabletype=\"" + decos.getStr("tabletype") + "\"");
		}

		//link and sinvoke
		if (html_env.linkFlag > 0 || html_env.sinvokeFlag) {
			string_tmp.append(" href=\"" + html_env.linkUrl + "\" ");
			if(decos.containsKey("target")){
				string_tmp.append(" target=\"" + decos.getStr("target")+"\"");
			}
			if(decos.containsKey("class")){
				string_tmp.append(" aclass=\"" + decos.getStr("class") + "\"");
			}
		}

		string_tmp.append(">");
		
		
		if(HTMLEnv.getFormItemFlg() && HTMLEnv.getFormItemName().equals(formHtml[2]) && HTMLEnv.getSelectRepeat()){

		}else{
			html_env2.code.append(string_tmp);
			Log.out(string_tmp); 
		}

		createForm(data_info);
		

		if(whichForm == 0){
			//***APPEND DATABASE VALUE***//
			String s = this.getStr(data_info);
			if(s.contains("&"))
				s = s.replace("&", "&amp;");
			if(s.contains("<"))
				s = s.replaceAll("<", "&lt;");
			if(s.contains(">"))
				s = s.replaceAll(">", "&gt;");
			if(s.contains("¢·"))
				s = s.replaceAll("¢·", "&#65374;");
			if(s.isEmpty())
				s = "¡¡";
			html_env2.code.append(s);            
			Log.out(this.getStr(data_info));
		}

		/*
		if(decos.containsKey("update") || decos.containsKey("insert")|| decos.containsKey("delete") || decos.containsKey("login")){
			html_env2.code.append("\" />");
			Log.out("\" \\>\n");
		}
		*/
		
		//Log.out("tuple: " + tuple_count + "/"+GlobalEnv.getTuplesNum() );
		
		if(HTMLEnv.getFormItemFlg() && HTMLEnv.getFormItemName().equals(formHtml[2])){
				//select
		}else{
		     html_env2.code.append("</VALUE>");
		     Log.out("</VALUE>");
		     if(HTMLEnv.getFormItemFlg() && HTMLEnv.getFormItemName().equals(formHtml[5])){
		    	 HTMLEnv.incrementFormPartsNumber();
		     }
		}
		
		
	}
	
	private void createForm(ExtList data_info){

		String form = new String();
		String name = new String();		
		String inputFormString = new String();
		
		for(int i = 1; i < formSql.length ; i++ ){
			if(decos.containsKey(formSql[i]) || HTMLEnv.getIDU().equals(formSql[i])){
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
			
			}else{
				if(s.isEmpty()){
					inputFormString += "<input type=\"text\" name=\"" + name + "\" />";					
				}else{
					inputFormString += "<input type=\"text\" name=\"" + name + "\" value=\"" + s + "\" />";
				}
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
				if(!html_env.code.toString().contains("<input type=\"hidden\" name=\"pkey\" value=\"" + name + "\" />"))
					inputFormString += "<input type=\"hidden\" name=\"pkey\" value=\"" + name + "\" />";
			}
		}
		
		html_env.code.append(inputFormString);
		html_env2.code.append(inputFormString);
		Log.out(inputFormString);
		
		inputFormString = new String();
		
		if(HTMLEnv.getFormItemFlg()){
			for(int i = 1; i < formHtml.length ; i++ ){
				String real_value = HTMLEnv.getFormValueString();
				if(HTMLEnv.getFormItemName().equals(formHtml[i])){
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

		html_env.code.append(inputFormString);
		html_env2.code.append(inputFormString);
		Log.out(inputFormString);
		
		
	}
	
/*
	private String closeFormItems(String itemType){
		String ret = new String();
		tuple_count = 0;
		if(itemType.equals("select")){
			HTMLEnv.setSelectRepeat(false);
			ret = "</select>";
		}
		HTMLEnv.incrementFormName();
		return ret;
	}
	*/

	private String inputFormItems(ExtList data_info,String itemType,String real_value){
		String ret = "";
		String formname = HTMLEnv.getFormPartsName();;
		if(HTMLEnv.getSearch()){
			ret += cond();
			formname = "value"+HTMLEnv.formPartsNumber;
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
			if(HTMLEnv.getSelectRepeat() == false){
				ret += "<select name=\""+ formname +"\">";
				HTMLEnv.setSelectRepeat(true);
			}
			if(HTMLEnv.getSelected().length() != 0 && HTMLEnv.getSelected().equals(real_value)){
				ret += "<option value=\"" + real_value + "\"" + size +" selected=\"selected\" >" + s + "</option>";
			}else{
				ret += "<option value=\"" + real_value + "\"" + size +" >" + s + "</option>";
			}
		}else if(itemType.equals(formHtml[3])){//checkbox
			String checked = "";
			if(HTMLEnv.getChecked().length() != 0 && HTMLEnv.getChecked().equals(real_value)){
				checked = " checked=\"checked\" ";
			}
			if(HTMLEnv.nameId.length() != 0){
				ret += "<input type=\"checkbox\" name=\""+ formname + "[" + HTMLEnv.nameId+ "]" + "\" value=\"" + real_value + "\"" + size + checked +" />";
				ret += s;
			}else{
				ret += "<input type=\"checkbox\" name=\""+ formname +"\" value=\"" + real_value + "\"" + size + checked +" />";
				ret += s;
			}
		}else if(itemType.equals(formHtml[4])){//radio
			String checked = "";
			if(HTMLEnv.getChecked().length() != 0 && HTMLEnv.getChecked().equals(real_value)){
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
	
	private String cond(){
		String ret = "";
		if(HTMLEnv.formPartsNumber != HTMLEnv.searchId){
			HTMLEnv.searchId = HTMLEnv.formPartsNumber;
			if(!HTMLEnv.condName.isEmpty() && !HTMLEnv.cond.isEmpty()){
				ret += "<input type=\"hidden\" name=\"cond_name"+ HTMLEnv.formPartsNumber +"\" value=\""+ HTMLEnv.condName +"\" />";
				ret += "<input type=\"hidden\" name=\"cond"+ HTMLEnv.formPartsNumber +"\" value=\""+ HTMLEnv.cond +"\" />";
				ret += "<input type=\"hidden\" name=\"value_type"+ HTMLEnv.formPartsNumber +"\" value=\"String\" />";
			}
		}
		return ret;
	}

	private String computeStringForDecoration(ExtList data_info) {
		String classNames = "";
		for(int i = 1; i < this.AttNames.size(); i++){
			if(((ExtList)(data_info.get(i))).getStr().equals("t")){
				if(decos.getClassesIds().get(AttNames.get(i)) != null)
					classNames += " C_" + decos.getClassesIds().get(AttNames.get(i));
			}
			else{
				if(decos.getClassesIds().get("!"+AttNames.get(i)) != null)
					classNames += " C_"+decos.getClassesIds().get("!"+AttNames.get(i));
			}
		}
		return classNames;
	}
	
}
