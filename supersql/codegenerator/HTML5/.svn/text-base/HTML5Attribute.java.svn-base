package supersql.codegenerator.HTML5;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Connector;
import supersql.codegenerator.Manager;
import supersql.common.Log;
import supersql.extendclass.ExtList;
import supersql.common.GlobalEnv;

public class HTML5Attribute extends Attribute {

	Manager manager;

	HTML5Env html5_env;
	HTML5Env html5_env2;

	String[] formSql = {"","delete","update","insert","login","logout"};
	String[] formHtml = {"","submit","select","checkbox","radio","text","textarea","hidden"};
	int whichForm;

	Connector connector;	//add oka

	int loop_counter;		//add oka

	static String alias;	//add oka

	int colum_num;			//add oka


	//���󥹥ȥ饯��
	public HTML5Attribute(Manager manager, HTML5Env henv, HTML5Env henv2) {
		super();
		this.manager = manager;
		this.html5_env = henv;
		this.html5_env2 = henv2;
	}

	//Attribute��work�᥽�å�
	public void work(ExtList data_info) {
		/*
        if(GlobalEnv.getSelectFlg())
        	data_info = (ExtList) data_info.get(0);
        	*/
		html5_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);

		if(GlobalEnv.isOpt()){
			work_opt(data_info);
		}else{
			if(HTML5Env.getFormItemFlg() && HTML5Env.getFormItemName().equals(formHtml[2])){

			}else{
				html5_env.code.append("<table" + html5_env.getOutlineModeAtt() + " ");
				html5_env.code.append("class=\"att");
				//tk start/////////////////////////////////////////////////////////
				if(html5_env.written_classid.contains(HTML5Env.getClassID(this))){
					//class���äƤ���Ȥ�(ex.TFE10000)�Τ߻���
					html5_env.code.append(" " + HTML5Env.getClassID(this));
				}
				if(decos.containsKey("class")){
					//class����(ex.class=menu)������Ȥ�
					html5_env.code.append(" " + decos.getStr("class"));
				}
				html5_env.code.append("\"");
				html5_env.code.append(">");
			}

			if(HTML5Env.getFormItemFlg()){

			}else{
				html5_env.code.append("<tr><td>\n");
				Log.out("<table class=\"att\"><tr><td>");
			}

			if (html5_env.link_flag > 0 || html5_env.sinvoke_flag) {

				//tk start for draggable div///////////////////////////////////////
				if(html5_env.draggable)
				{
					html5_env.code.append("<div id=\""+html5_env.dragdivid+"\" class=\"draggable\"");
					Log.out("<div id=\""+html5_env.dragdivid+"\" ");
				}
				else{
					//tk end for draggable div/////////////////////////////////////////
					if(html5_env.isPanel)
						html5_env.code.append("<div id=\"container\">");

					html5_env.code.append("<A href=\"" + html5_env.linkurl + "\" ");

				}
				//tk start//////////////////////////////////////////////////////////
				if(decos.containsKey("target")){
					html5_env.code.append(" target=\"" + decos.getStr("target")+"\"");
				}
				if(decos.containsKey("class")){
					html5_env.code.append(" class=\"" + decos.getStr("class") + "\"");
				}

				if(GlobalEnv.isAjax() && html5_env.isPanel)
				{
					html5_env.code.append(" onClick =\"return panel('Panel','"+html5_env.ajaxquery+"'," +
							"'"+html5_env.dragdivid+"','"+html5_env.ajaxcond+"')\"");
				}
				else if(GlobalEnv.isAjax() && !html5_env.draggable)
				{
					String target = GlobalEnv.getAjaxTarget();
					if(target == null)
					{
						String query = html5_env.ajaxquery;
						if(query.contains("/"))
						{
							target = query.substring(query.lastIndexOf("/")+1,query.indexOf(".sql"));
						}
						else
							target = query.substring(0,query.indexOf(".sql"));

						if(html5_env.has_dispdiv)
						{
							target = html5_env.ajaxtarget;
						}
						Log.out("a target:"+target);
					}
					html5_env.code.append(" onClick =\"return loadFile('"+html5_env.ajaxquery+"','"+target+
							"','"+html5_env.ajaxcond+"',"+html5_env.inEffect+","+html5_env.outEffect+")\"");

				}


				html5_env.code.append(">\n");
				//tk end////////////////////////////////////////////////////////////

				Log.out("<A href=\"" + html5_env.linkurl + "\">");
			}

			//Log.out("data_info: "+this.getStr(data_info));


			createForm(data_info);


			if(whichForm == 0){ //normal process (not form)
				//***APPEND DATABASE VALUE***//
				Log.out(data_info);
				html5_env.code.append(this.getStr(data_info));

				Log.out(this.getStr(data_info));
			}

			if (html5_env.link_flag > 0 || html5_env.sinvoke_flag) {
				if(html5_env.draggable)
					html5_env.code.append("</div>\n");
				else
				{
					html5_env.code.append("</A>\n");

					if(html5_env.isPanel)
						html5_env.code.append("</div>\n");
				}
				Log.out("</A>");
			}

			/*
			if(whichForm > 0){
				html5_env.code.append("\" />\n");
				Log.out("\" \\>\n");
			}
			*/



			//Log.out("tuple: " + tuple_count + "/"+GlobalEnv.getTuplesNum() );

			if(HTML5Env.getFormItemFlg() && HTML5Env.getFormItemName().equals(formHtml[2])){

			}else{
				html5_env.code.append("</td></tr></table>\n");
				Log.out("</td></tr></table>");
			}


			Log.out("TFEId = " + HTML5Env.getClassID(this));
			//html5_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);
		}

	}

	//optimizer
	public void work_opt(ExtList data_info){
		StringBuffer string_tmp = new StringBuffer();
		string_tmp.append("<VALUE");
		if(html5_env.written_classid.contains(HTML5Env.getClassID(this))){
			//class���äƤ���Ȥ�(ex.TFE10000)�Τ߻���
			string_tmp.append(" class=\"");
			string_tmp.append(HTML5Env.getClassID(this));
		}

		if(decos.containsKey("class")){
			//class����(ex.class=menu)������Ȥ�
			if(!html5_env.written_classid.contains(HTML5Env.getClassID(this))){
				string_tmp.append(" class=\"");
			}else{
				string_tmp.append(" ");
			}
			string_tmp.append(decos.getStr("class") + "\"");
		}else if(html5_env.written_classid.contains(HTML5Env.getClassID(this))){
			string_tmp.append("\"");
		}

		if(decos.containsKey("update") || decos.containsKey("insert")||decos.containsKey("delete")||decos.containsKey("login")||decos.containsKey("logout") || HTML5Env.getFormItemFlg() ||
			(HTML5Env.getIDU()!= null && !HTML5Env.getIDU().isEmpty())){
			string_tmp.append(" type=\"form\"");
		}


		if(decos.containsKey("tabletype")){
			string_tmp.append(" tabletype=\"" + decos.getStr("tabletype") + "\"");
		}

		//link and sinvoke
		if (html5_env.link_flag > 0 || html5_env.sinvoke_flag) {
			string_tmp.append(" href=\"" + html5_env.linkurl + "\" ");
			if(decos.containsKey("target")){
				string_tmp.append(" target=\"" + decos.getStr("target")+"\"");
			}
			if(decos.containsKey("class")){
				string_tmp.append(" aclass=\"" + decos.getStr("class") + "\"");
			}
		}

		string_tmp.append(">");


		if(HTML5Env.getFormItemFlg() && HTML5Env.getFormItemName().equals(formHtml[2]) && HTML5Env.getSelectRepeat()){

		}else{
			html5_env2.code.append(string_tmp);
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
			html5_env2.code.append(s);
			Log.out(this.getStr(data_info));
		}

		/*
		if(decos.containsKey("update") || decos.containsKey("insert")|| decos.containsKey("delete") || decos.containsKey("login")){
			html5_env2.code.append("\" />");
			Log.out("\" \\>\n");
		}
		*/

		//Log.out("tuple: " + tuple_count + "/"+GlobalEnv.getTuplesNum() );

		if(HTML5Env.getFormItemFlg() && HTML5Env.getFormItemName().equals(formHtml[2])){
				//select
		}else{
		     html5_env2.code.append("</VALUE>");
		     Log.out("</VALUE>");
		     if(HTML5Env.getFormItemFlg() && HTML5Env.getFormItemName().equals(formHtml[5])){
		    	 HTML5Env.incrementFormPartsNumber();
		     }
		}


	}



	/*
  //Attribute��work�᥽�å�
    public void work(ExtList data_info) {

        html5_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);

        if(!GlobalEnv.isOpt()){
        	if(HTMLEnv.getFormItemFlg()){

            }else{
	        	html5_env.code.append("<table" + html5_env.getOutlineModeAtt() + " ");
	        	html5_env.code.append("class=\"att");
	        	//tk start/////////////////////////////////////////////////////////
	        	if(html5_env.written_classid.contains(HTML5Env.getClassID(this))){
	        		//class���äƤ���Ȥ�(ex.TFE10000)�Τ߻���
	        		html5_env.code.append(" " + HTML5Env.getClassID(this));
	        	}
	        	if(decos.containsKey("class")){
	        		//class����(ex.class=menu)������Ȥ�
	        		html_env.code.append(" " + decos.getStr("class"));
	        	}
	        	html5_env.code.append("\"");
	        	html5_env.code.append(">");
            }
        }


        if(GlobalEnv.isOpt()){
        	html5_env2.code.append("<VALUE");
        	if(html5_env.written_classid.contains(HTML5Env.getClassID(this))){
        		//class���äƤ���Ȥ�(ex.TFE10000)�Τ߻���
        		html5_env2.code.append(" class=\"");
        		html5_env2.code.append(HTMLEnv.getClassID(this));
        	}

        	if(decos.containsKey("class")){
        		//class����(ex.class=menu)������Ȥ�
        		if(!html5_env.written_classid.contains(HTML5Env.getClassID(this))){
        			html5_env2.code.append(" class=\"");
        		}else{
        			html5_env2.code.append(" ");
        		}
        		html_env2.code.append(decos.getStr("class") + "\"");
        	}else if(html_env.written_classid.contains(HTMLEnv.getClassID(this))){
        		html5_env2.code.append("\"");
        	}

        	if(decos.containsKey("update") || decos.containsKey("insert")||decos.containsKey("delete")||decos.containsKey("login")){
        		html5_env2.code.append(" type=\"form\"");
        	}


        	if(decos.containsKey("tabletype"))
        		html5_env2.code.append(" tabletype=\"" + decos.getStr("tabletype") + "\"");

        }
        //tk end////////////////////////////////////////////////////////////

        if(HTML5Env.getFormItemFlg()){

        }else{
	        html5_env.code.append("<tr><td>\n");
	        Log.out("<table class=\"att\"><tr><td>");
        }

        if (html5_env.link_flag > 0 || html5_env.sinvoke_flag) {

        	//tk start for draggable div///////////////////////////////////////
        	if(html5_env.draggable)
        	{
        		html5_env.code.append("<div id=\""+html5_env.dragdivid+"\" class=\"draggable\"");
        		Log.out("<div id=\""+html5_env.dragdivid+"\" ");
        	}
        	else{
        	//tk end for draggable div/////////////////////////////////////////
        		if(html5_env.isPanel)
        			html5_env.code.append("<div id=\"container\">");

        		html5_env.code.append("<A href=\"" + html5_env.linkurl + "\" ");
        		html5_env2.code.append(" href=\"" + html5_env.linkurl + "\" ");

        	}
            //tk start//////////////////////////////////////////////////////////
            if(decos.containsKey("target")){
            	html5_env.code.append(" target=\"" + decos.getStr("target")+"\"");
            	html5_env2.code.append(" target=\"" + decos.getStr("target")+"\"");
            }
            if(decos.containsKey("class")){
            	html5_env.code.append(" class=\"" + decos.getStr("class") + "\"");
            	html5_env2.code.append(" aclass=\"" + decos.getStr("class") + "\"");
            }

            if(GlobalEnv.isAjax() && html_env.isPanel)
            {
            	html5_env.code.append(" onClick =\"return panel('Panel','"+html5_env.ajaxquery+"'," +
            			"'"+html5_env.dragdivid+"','"+html5_env.ajaxcond+"')\"");
            }
            else if(GlobalEnv.isAjax() && !html_env.draggable)
            {
            	String target = GlobalEnv.getAjaxTarget();
            	if(target == null)
            	{
            		String query = html5_env.ajaxquery;
            		if(query.contains("/"))
            		{
            			target = query.substring(query.lastIndexOf("/")+1,query.indexOf(".sql"));
            		}
            		else
            			target = query.substring(0,query.indexOf(".sql"));

            		if(html5_env.has_dispdiv)
            		{
            			target = html5_env.ajaxtarget;
            		}
            		Log.out("a target:"+target);
            	}
            	html5_env.code.append(" onClick =\"return loadFile('"+html5_env.ajaxquery+"','"+target+
            			"','"+html5_env.ajaxcond+"',"+html5_env.inEffect+","+html5_env.outEffect+")\"");

            }


            html5_env.code.append(">\n");
            //tk end////////////////////////////////////////////////////////////

            Log.out("<A href=\"" + html5_env.linkurl + "\">");
        }

        //Log.out("data_info: "+this.getStr(data_info));

        html5_env2.code.append(">");

        String form = new String();
        if(decos.containsKey("update") || decos.containsKey("insert")|| decos.containsKey("login")){
        	String name = new String();
        	//Log.out(decos.containsKey("insert"));
        	//Log.out(decos.getStr("insert"));
        	//String DataID = HTML5Env.getDataID(this);
        	if(decos.containsKey("update")){
        		name = decos.getStr("update");
        	}else if(decos.containsKey("insert")){
        		name = decos.getStr("insert");
        	}else if(decos.containsKey("login")){
        		name = decos.getStr("login");
        		if(decos.containsKey("att")){
        			html5_env.code.append("<input type=\"hidden\" name=\"att\" value=\"" + decos.getStr("att") +"\" />");
                	html5_env2.code.append("<input type=\"hidden\" name=\"att\" value=\"" + decos.getStr("att") +"\" />");
        		}
        	}

    		if(decos.containsKey("pwd")){
    			html5_env.code.append("<input type=\"password\" name=\"" + name + "\" value=\"");
            	html5_env2.code.append("<input type=\"password\" name=\"" + name + "\" value=\"");
    		}else{
    			html5_env.code.append("<input type=\"text\" name=\"" + name + "\" value=\"");
        		html5_env2.code.append("<input type=\"text\" name=\"" + name + "\" value=\"");
    		}
        	Log.out("<input type=\"text\" name=\"" + name + "\" value=\"");

        }else if(decos.containsKey("delete")){
    		String name = decos.getStr("delete");
        	html5_env.code.append("<input type=\"checkbox\" name=\"" + name + "\" value=\"");
        	html5_env2.code.append("<input type=\"checkbox\" name=\"" + name + "\" value=\"");
        	Log.out("<input type=\"checkbox\" name=\"" + name + "\" value=\"");
        }else if(HTML5Env.getFormItemFlg()){
    		String name = decos.getStr("select");
    		form = inputFormItems(data_info,"select",name);
        	html5_env.code.append(form);
        }

    	Log.out(GlobalEnv.getTuplesNum());
        //change      chie

        if(decos.containsKey("insert") || decos.containsKey("login") || !form.isEmpty()){

        }else{
        	//***APPEND DATABASE VALUE***
        	html5_env.code.append(this.getStr(data_info));


            String s = this.getStr(data_info);
            if(s.contains("&"))
            	s = s.replace("&", "&amp;");
            if(s.contains("<"))
            	s = s.replaceAll("<", "&lt;");
            if(s.contains(">"))
            	s = s.replaceAll(">", "&gt;");
            if(s.contains("���"))
            	s = s.replaceAll("���", "&#65374;");
            html5_env2.code.append(s);

        	Log.out(this.getStr(data_info));
        }

        if (html5_env.link_flag > 0 || html5_env.sinvoke_flag) {
        	if(html5_env.draggable)
        		html5_env.code.append("</div>\n");
        	else
        	{
        		html5_env.code.append("</A>\n");

        		if(html5_env.isPanel)
        			html5_env.code.append("</div>\n");
        	}
            Log.out("</A>");
        }


        if(decos.containsKey("update") || decos.containsKey("insert")|| decos.containsKey("delete") || decos.containsKey("login")){
            html5_env.code.append("\" />\n");
            html5_env2.code.append("\" />");
            Log.out("\" \\>\n");
        }

        html5_env2.code.append("</VALUE>");

        if(HTML5Env.getFormItemFlg()){
            if(tuple_count == GlobalEnv.getTuplesNum()){
                closeFormItems("select");
            }
        }else{
        	html5_env.code.append("</td></tr></table>\n");
            Log.out("</td></tr></table>");
        }


        Log.out("TFEId = " + HTML5Env.getClassID(this));
        //html5_env.append_css_def_td(HTML5Env.getClassID(this), this.decos);

    }
	 */


	//static int tuple_count = 0;

	private void createForm(ExtList data_info){

		String form = new String();
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
				if(!html5_env.code.toString().contains("<input type=\"hidden\" name=\"pkey\" value=\"" + name + "\" />"))
					inputFormString += "<input type=\"hidden\" name=\"pkey\" value=\"" + name + "\" />";
			}
		}

		html5_env.code.append(inputFormString);
		html5_env2.code.append(inputFormString);
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

		html5_env.code.append(inputFormString);
		html5_env2.code.append(inputFormString);
		Log.out(inputFormString);


	}

/*
	private String closeFormItems(String itemType){
		String ret = new String();
		tuple_count = 0;
		if(itemType.equals("select")){
			HTML5Env.setSelectRepeat(false);
			ret = "</select>";
		}
		HTML5Env.incrementFormName();
		return ret;
	}
	*/

	private String inputFormItems(ExtList data_info,String itemType,String real_value){
		String ret = "";
		String formname = HTML5Env.getFormPartsName();;
		if(HTML5Env.getSearch()){
			ret += cond();
			formname = "value"+HTML5Env.form_parts_number;
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

	private String cond(){
		String ret = "";
		if(HTML5Env.form_parts_number != HTML5Env.searchid){
			HTML5Env.searchid = HTML5Env.form_parts_number;
			if(!HTML5Env.cond_name.isEmpty() && !HTML5Env.cond.isEmpty()){
				ret += "<input type=\"hidden\" name=\"cond_name"+ HTML5Env.form_parts_number +"\" value=\""+ HTML5Env.cond_name +"\" />";
				ret += "<input type=\"hidden\" name=\"cond"+ HTML5Env.form_parts_number +"\" value=\""+ HTML5Env.cond +"\" />";
				ret += "<input type=\"hidden\" name=\"value_type"+ HTML5Env.form_parts_number +"\" value=\"String\" />";
			}
		}
		return ret;
	}

}