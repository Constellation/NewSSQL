package supersql.codegenerator.TESTHTML;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Connector;
import supersql.codegenerator.Manager;
import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class TESTHTMLAttribute extends Attribute {

	Manager manager;

	TESTHTMLEnv html_env;
	TESTHTMLEnv html_env2;

	String[] formSql = {"","delete","update","insert","login","logout"};
	String[] formHtml = {"","submit","select","checkbox","radio","text","textarea","hidden"};
	int whichForm;

	Connector connector;	//add oka

	int loop_counter;		//add oka

	static String alias;	//add oka

	int colum_num;			//add oka


	//���󥹥ȥ饯��
	public TESTHTMLAttribute(Manager manager, TESTHTMLEnv henv, TESTHTMLEnv henv2) {
		super();
		this.manager = manager;
		this.html_env = henv;
		this.html_env2 = henv2;
	}

	//Attribute��work�᥽�å�
	public void work(ExtList data_info) {
		/*
        if(GlobalEnv.getSelectFlg())
        	data_info = (ExtList) data_info.get(0);
        	*/
		html_env.append_css_def_td(TESTHTMLEnv.getClassID(this), this.decos);

		if(GlobalEnv.isOpt()){
			work_opt(data_info);
		}else{
			if(TESTHTMLEnv.getFormItemFlg() && TESTHTMLEnv.getFormItemName().equals(formHtml[2])){

			}else{
				html_env.code.append("<table" + html_env.getOutlineModeAtt() + " ");
				html_env.code.append("class=\"att");
				//tk start/////////////////////////////////////////////////////////
				if(html_env.written_classid.contains(TESTHTMLEnv.getClassID(this))){
					//class���äƤ���Ȥ�(ex.TFE10000)�Τ߻���
					html_env.code.append(" " + TESTHTMLEnv.getClassID(this));
				}
				if(decos.containsKey("class")){
					//class����(ex.class=menu)������Ȥ�
					html_env.code.append(" " + decos.getStr("class"));
				}
				html_env.code.append("\"");
				html_env.code.append(">");
			}

			if(TESTHTMLEnv.getFormItemFlg()){

			}else{
				html_env.code.append("<tr><td>\n");
				Log.out("<table class=\"att\"><tr><td>");
			}

			if (html_env.link_flag > 0 || html_env.sinvoke_flag) {

				//tk start for draggable div///////////////////////////////////////
				if(html_env.draggable)
				{
					html_env.code.append("<div id=\""+html_env.dragdivid+"\" class=\"draggable\"");
					Log.out("<div id=\""+html_env.dragdivid+"\" ");
				}
				else{
					//tk end for draggable div/////////////////////////////////////////
					if(html_env.isPanel)
						html_env.code.append("<div id=\"container\">");

					html_env.code.append("<A href=\"" + html_env.linkurl + "\" ");

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
					html_env.code.append(" onClick =\"return panel('Panel','"+html_env.ajaxquery+"'," +
							"'"+html_env.dragdivid+"','"+html_env.ajaxcond+"')\"");
				}
				else if(GlobalEnv.isAjax() && !html_env.draggable)
				{
					String target = GlobalEnv.getAjaxTarget();
					if(target == null)
					{
						String query = html_env.ajaxquery;
						if(query.contains("/"))
						{
							target = query.substring(query.lastIndexOf("/")+1,query.indexOf(".sql"));
						}
						else
							target = query.substring(0,query.indexOf(".sql"));

						if(html_env.has_dispdiv)
						{
							target = html_env.ajaxtarget;
						}
						Log.out("a target:"+target);
					}
					html_env.code.append(" onClick =\"return loadFile('"+html_env.ajaxquery+"','"+target+
							"','"+html_env.ajaxcond+"',"+html_env.inEffect+","+html_env.outEffect+")\"");

				}


				html_env.code.append(">\n");
				//tk end////////////////////////////////////////////////////////////

				Log.out("<A href=\"" + html_env.linkurl + "\">");
			}

			//Log.out("data_info: "+this.getStr(data_info));


			createForm(data_info);


			if(whichForm == 0){ //normal process (not form)
				//***APPEND DATABASE VALUE***//
				Log.out(data_info);
				html_env.code.append(this.getStr(data_info));

				Log.out(this.getStr(data_info));
			}

			if (html_env.link_flag > 0 || html_env.sinvoke_flag) {
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

			if(TESTHTMLEnv.getFormItemFlg() && TESTHTMLEnv.getFormItemName().equals(formHtml[2])){

			}else{
				html_env.code.append("</td></tr></table>\n");
				Log.out("</td></tr></table>");
			}


			Log.out("TFEId = " + TESTHTMLEnv.getClassID(this));
			//html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);
		}

	}

	//optimizer
	public void work_opt(ExtList data_info){
		StringBuffer string_tmp = new StringBuffer();
		string_tmp.append("<VALUE");
		if(html_env.written_classid.contains(TESTHTMLEnv.getClassID(this))){
			//class���äƤ���Ȥ�(ex.TFE10000)�Τ߻���
			string_tmp.append(" class=\"");
			string_tmp.append(TESTHTMLEnv.getClassID(this));
		}

		if(decos.containsKey("class")){
			//class����(ex.class=menu)������Ȥ�
			if(!html_env.written_classid.contains(TESTHTMLEnv.getClassID(this))){
				string_tmp.append(" class=\"");
			}else{
				string_tmp.append(" ");
			}
			string_tmp.append(decos.getStr("class") + "\"");
		}else if(html_env.written_classid.contains(TESTHTMLEnv.getClassID(this))){
			string_tmp.append("\"");
		}

		if(decos.containsKey("update") || decos.containsKey("insert")||decos.containsKey("delete")||decos.containsKey("login")||decos.containsKey("logout") || TESTHTMLEnv.getFormItemFlg() ||
			(TESTHTMLEnv.getIDU()!= null && !TESTHTMLEnv.getIDU().isEmpty())){
			string_tmp.append(" type=\"form\"");
		}


		if(decos.containsKey("tabletype")){
			string_tmp.append(" tabletype=\"" + decos.getStr("tabletype") + "\"");
		}

		//link and sinvoke
		if (html_env.link_flag > 0 || html_env.sinvoke_flag) {
			string_tmp.append(" href=\"" + html_env.linkurl + "\" ");
			if(decos.containsKey("target")){
				string_tmp.append(" target=\"" + decos.getStr("target")+"\"");
			}
			if(decos.containsKey("class")){
				string_tmp.append(" aclass=\"" + decos.getStr("class") + "\"");
			}
		}

		string_tmp.append(">");


		if(TESTHTMLEnv.getFormItemFlg() && TESTHTMLEnv.getFormItemName().equals(formHtml[2]) && TESTHTMLEnv.getSelectRepeat()){

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
			if(s.contains("���"))
				s = s.replaceAll("���", "&#65374;");
			if(s.isEmpty())
				s = "��";
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

		if(TESTHTMLEnv.getFormItemFlg() && TESTHTMLEnv.getFormItemName().equals(formHtml[2])){
				//select
		}else{
		     html_env2.code.append("</VALUE>");
		     Log.out("</VALUE>");
		     if(TESTHTMLEnv.getFormItemFlg() && TESTHTMLEnv.getFormItemName().equals(formHtml[5])){
		    	 TESTHTMLEnv.incrementFormPartsNumber();
		     }
		}


	}



	/*
  //Attribute��work�᥽�å�
    public void work(ExtList data_info) {

        html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

        if(!GlobalEnv.isOpt()){
        	if(HTMLEnv.getFormItemFlg()){

            }else{
	        	html_env.code.append("<table" + html_env.getOutlineModeAtt() + " ");
	        	html_env.code.append("class=\"att");
	        	//tk start/////////////////////////////////////////////////////////
	        	if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
	        		//class���äƤ���Ȥ�(ex.TFE10000)�Τ߻���
	        		html_env.code.append(" " + HTMLEnv.getClassID(this));
	        	}
	        	if(decos.containsKey("class")){
	        		//class����(ex.class=menu)������Ȥ�
	        		html_env.code.append(" " + decos.getStr("class"));
	        	}
	        	html_env.code.append("\"");
	        	html_env.code.append(">");
            }
        }


        if(GlobalEnv.isOpt()){
        	html_env2.code.append("<VALUE");
        	if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
        		//class���äƤ���Ȥ�(ex.TFE10000)�Τ߻���
        		html_env2.code.append(" class=\"");
        		html_env2.code.append(HTMLEnv.getClassID(this));
        	}

        	if(decos.containsKey("class")){
        		//class����(ex.class=menu)������Ȥ�
        		if(!html_env.written_classid.contains(HTMLEnv.getClassID(this))){
        			html_env2.code.append(" class=\"");
        		}else{
        			html_env2.code.append(" ");
        		}
        		html_env2.code.append(decos.getStr("class") + "\"");
        	}else if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
        		html_env2.code.append("\"");
        	}

        	if(decos.containsKey("update") || decos.containsKey("insert")||decos.containsKey("delete")||decos.containsKey("login")){
        		html_env2.code.append(" type=\"form\"");
        	}


        	if(decos.containsKey("tabletype"))
        		html_env2.code.append(" tabletype=\"" + decos.getStr("tabletype") + "\"");

        }
        //tk end////////////////////////////////////////////////////////////

        if(HTMLEnv.getFormItemFlg()){

        }else{
	        html_env.code.append("<tr><td>\n");
	        Log.out("<table class=\"att\"><tr><td>");
        }

        if (html_env.link_flag > 0 || html_env.sinvoke_flag) {

        	//tk start for draggable div///////////////////////////////////////
        	if(html_env.draggable)
        	{
        		html_env.code.append("<div id=\""+html_env.dragdivid+"\" class=\"draggable\"");
        		Log.out("<div id=\""+html_env.dragdivid+"\" ");
        	}
        	else{
        	//tk end for draggable div/////////////////////////////////////////
        		if(html_env.isPanel)
        			html_env.code.append("<div id=\"container\">");

        		html_env.code.append("<A href=\"" + html_env.linkurl + "\" ");
        		html_env2.code.append(" href=\"" + html_env.linkurl + "\" ");

        	}
            //tk start//////////////////////////////////////////////////////////
            if(decos.containsKey("target")){
            	html_env.code.append(" target=\"" + decos.getStr("target")+"\"");
            	html_env2.code.append(" target=\"" + decos.getStr("target")+"\"");
            }
            if(decos.containsKey("class")){
            	html_env.code.append(" class=\"" + decos.getStr("class") + "\"");
            	html_env2.code.append(" aclass=\"" + decos.getStr("class") + "\"");
            }

            if(GlobalEnv.isAjax() && html_env.isPanel)
            {
            	html_env.code.append(" onClick =\"return panel('Panel','"+html_env.ajaxquery+"'," +
            			"'"+html_env.dragdivid+"','"+html_env.ajaxcond+"')\"");
            }
            else if(GlobalEnv.isAjax() && !html_env.draggable)
            {
            	String target = GlobalEnv.getAjaxTarget();
            	if(target == null)
            	{
            		String query = html_env.ajaxquery;
            		if(query.contains("/"))
            		{
            			target = query.substring(query.lastIndexOf("/")+1,query.indexOf(".sql"));
            		}
            		else
            			target = query.substring(0,query.indexOf(".sql"));

            		if(html_env.has_dispdiv)
            		{
            			target = html_env.ajaxtarget;
            		}
            		Log.out("a target:"+target);
            	}
            	html_env.code.append(" onClick =\"return loadFile('"+html_env.ajaxquery+"','"+target+
            			"','"+html_env.ajaxcond+"',"+html_env.inEffect+","+html_env.outEffect+")\"");

            }


            html_env.code.append(">\n");
            //tk end////////////////////////////////////////////////////////////

            Log.out("<A href=\"" + html_env.linkurl + "\">");
        }

        //Log.out("data_info: "+this.getStr(data_info));

        html_env2.code.append(">");

        String form = new String();
        if(decos.containsKey("update") || decos.containsKey("insert")|| decos.containsKey("login")){
        	String name = new String();
        	//Log.out(decos.containsKey("insert"));
        	//Log.out(decos.getStr("insert"));
        	//String DataID = HTMLEnv.getDataID(this);
        	if(decos.containsKey("update")){
        		name = decos.getStr("update");
        	}else if(decos.containsKey("insert")){
        		name = decos.getStr("insert");
        	}else if(decos.containsKey("login")){
        		name = decos.getStr("login");
        		if(decos.containsKey("att")){
        			html_env.code.append("<input type=\"hidden\" name=\"att\" value=\"" + decos.getStr("att") +"\" />");
                	html_env2.code.append("<input type=\"hidden\" name=\"att\" value=\"" + decos.getStr("att") +"\" />");
        		}
        	}

    		if(decos.containsKey("pwd")){
    			html_env.code.append("<input type=\"password\" name=\"" + name + "\" value=\"");
            	html_env2.code.append("<input type=\"password\" name=\"" + name + "\" value=\"");
    		}else{
    			html_env.code.append("<input type=\"text\" name=\"" + name + "\" value=\"");
        		html_env2.code.append("<input type=\"text\" name=\"" + name + "\" value=\"");
    		}
        	Log.out("<input type=\"text\" name=\"" + name + "\" value=\"");

        }else if(decos.containsKey("delete")){
    		String name = decos.getStr("delete");
        	html_env.code.append("<input type=\"checkbox\" name=\"" + name + "\" value=\"");
        	html_env2.code.append("<input type=\"checkbox\" name=\"" + name + "\" value=\"");
        	Log.out("<input type=\"checkbox\" name=\"" + name + "\" value=\"");
        }else if(HTMLEnv.getFormItemFlg()){
    		String name = decos.getStr("select");
    		form = inputFormItems(data_info,"select",name);
        	html_env.code.append(form);
        }

    	Log.out(GlobalEnv.getTuplesNum());
        //change      chie

        if(decos.containsKey("insert") || decos.containsKey("login") || !form.isEmpty()){

        }else{
        	//***APPEND DATABASE VALUE***
        	html_env.code.append(this.getStr(data_info));


            String s = this.getStr(data_info);
            if(s.contains("&"))
            	s = s.replace("&", "&amp;");
            if(s.contains("<"))
            	s = s.replaceAll("<", "&lt;");
            if(s.contains(">"))
            	s = s.replaceAll(">", "&gt;");
            if(s.contains("���"))
            	s = s.replaceAll("���", "&#65374;");
            html_env2.code.append(s);

        	Log.out(this.getStr(data_info));
        }

        if (html_env.link_flag > 0 || html_env.sinvoke_flag) {
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


        if(decos.containsKey("update") || decos.containsKey("insert")|| decos.containsKey("delete") || decos.containsKey("login")){
            html_env.code.append("\" />\n");
            html_env2.code.append("\" />");
            Log.out("\" \\>\n");
        }

        html_env2.code.append("</VALUE>");

        if(HTMLEnv.getFormItemFlg()){
            if(tuple_count == GlobalEnv.getTuplesNum()){
                closeFormItems("select");
            }
        }else{
        	html_env.code.append("</td></tr></table>\n");
            Log.out("</td></tr></table>");
        }


        Log.out("TFEId = " + HTMLEnv.getClassID(this));
        //html_env.append_css_def_td(HTMLEnv.getClassID(this), this.decos);

    }
	 */


	//static int tuple_count = 0;

	private void createForm(ExtList data_info){

		String form = new String();
		String name = new String();
		String inputFormString = new String();

		for(int i = 1; i < formSql.length ; i++ ){
			if(decos.containsKey(formSql[i]) || TESTHTMLEnv.getIDU().equals(formSql[i])){
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

		if(TESTHTMLEnv.getFormItemFlg()){
			for(int i = 1; i < formHtml.length ; i++ ){
				String real_value = TESTHTMLEnv.getFormValueString();
				if(TESTHTMLEnv.getFormItemName().equals(formHtml[i])){
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
		String formname = TESTHTMLEnv.getFormPartsName();;
		if(TESTHTMLEnv.getSearch()){
			ret += cond();
			formname = "value"+TESTHTMLEnv.form_parts_number;
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
			if(TESTHTMLEnv.getSelectRepeat() == false){
				ret += "<select name=\""+ formname +"\">";
				TESTHTMLEnv.setSelectRepeat(true);
			}
			if(TESTHTMLEnv.getSelected().length() != 0 && TESTHTMLEnv.getSelected().equals(real_value)){
				ret += "<option value=\"" + real_value + "\"" + size +" selected=\"selected\" >" + s + "</option>";
			}else{
				ret += "<option value=\"" + real_value + "\"" + size +" >" + s + "</option>";
			}
		}else if(itemType.equals(formHtml[3])){//checkbox
			String checked = "";
			if(TESTHTMLEnv.getChecked().length() != 0 && TESTHTMLEnv.getChecked().equals(real_value)){
				checked = " checked=\"checked\" ";
			}
			if(TESTHTMLEnv.nameId.length() != 0){
				ret += "<input type=\"checkbox\" name=\""+ formname + "[" + TESTHTMLEnv.nameId+ "]" + "\" value=\"" + real_value + "\"" + size + checked +" />";
				ret += s;
			}else{
				ret += "<input type=\"checkbox\" name=\""+ formname +"\" value=\"" + real_value + "\"" + size + checked +" />";
				ret += s;
			}
		}else if(itemType.equals(formHtml[4])){//radio
			String checked = "";
			if(TESTHTMLEnv.getChecked().length() != 0 && TESTHTMLEnv.getChecked().equals(real_value)){
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
		if(TESTHTMLEnv.form_parts_number != TESTHTMLEnv.searchid){
			TESTHTMLEnv.searchid = TESTHTMLEnv.form_parts_number;
			if(!TESTHTMLEnv.cond_name.isEmpty() && !TESTHTMLEnv.cond.isEmpty()){
				ret += "<input type=\"hidden\" name=\"cond_name"+ TESTHTMLEnv.form_parts_number +"\" value=\""+ TESTHTMLEnv.cond_name +"\" />";
				ret += "<input type=\"hidden\" name=\"cond"+ TESTHTMLEnv.form_parts_number +"\" value=\""+ TESTHTMLEnv.cond +"\" />";
				ret += "<input type=\"hidden\" name=\"value_type"+ TESTHTMLEnv.form_parts_number +"\" value=\"String\" />";
			}
		}
		return ret;
	}

}