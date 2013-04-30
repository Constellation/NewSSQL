package supersql.codegenerator.XML;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Manager;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class XMLAttribute extends Attribute {

    Manager manager;

    XMLEnv xml_env;
    XMLEnv xml_env2;

	public static String tag;
	public static String tag_value;

	public static String att;
	public static String att_value;

	public static String parent_att;
	public static String parent_att_value;

	public static int flag = 0;
	public static int tagcount;

	public static int no_close_tag_flag;
	public static int absent_on_null_flag;


    public XMLAttribute(Manager manager, XMLEnv xenv, XMLEnv xenv2) {
        super();
        this.manager = manager;
        this.xml_env = xenv;
        this.xml_env2 = xenv2;
    }

    public void work(ExtList data_info){
    	Log.out("[ XMLAttribute ]");

    	XMLFunction.function_close = 0;

    	if(XMLC0.XMLC0_passflag == 0){
	    	if(decos.containsKey("tag")){
	        	tag = decos.getStr("tag");

	        	if(tag.equals("")){
	        		tag = "null";
	        	}

		        xml_env.code.append("<" + tag + ">");
		        xml_env.code.append(data_info.get(0).toString().substring(4));
		        xml_env.code.append("</" + tag + ">");
		   }
    	}

    	XMLC0.tagclose_flag = 0;


    	if(XMLC0.parent_attflag == 1){
	    	tagcount = 0;

	    	if(decos.containsKey("parent_att")){
	    		parent_att = decos.getStr("parent_att");

				if(parent_att.equals("")){
					parent_att = this.toString();
					if(parent_att.contains(".")){
						parent_att = parent_att.substring(parent_att.indexOf(".") + 1);
					}
				}

				parent_att_value = this.getStr(data_info);

				XMLFunction.Func_replace(parent_att_value);

				 if(parent_att_value.equals("")){
					if(decos.toString().toUpperCase().contains("EMPTY_ON_NULL")){
						xml_env.code.append(" " + parent_att + "=\"" + parent_att_value + "\"");
			    	}
					else if(decos.toString().toUpperCase().contains("ABSENT_ON_NULL")){

						absent_on_null_flag = 1;
					}
			    	else if(decos.toString().toUpperCase().contains("NULL_ON_NULL")){
						xml_env.code.append(" " + parent_att + "=\"" + "NULL" + "\"");
					}
		    		else{
						xml_env.code.append(" " + parent_att + "=\"" + parent_att_value + "\"");
		    		}
		    	}

				else{
					xml_env.code.append(" " + parent_att + "=\"" + parent_att_value + "\"");
				}
	    	}

	    	else{
				xml_env.code.append(">");
				XMLC0.parent_attflag = 2;
	    	}
	    }


    	if(XMLC0.parent_attflag == 2){

	    	if(decos.containsKey("tag")){
	    		no_close_tag_flag = 0;

				if(absent_on_null_flag != 1){
		    		if(tagcount >= 1){
		    			if(XMLC0.decos_tag_flag == 1){
		    				xml_env.code.append(">" + tag_value + "</" + tag + ">");
		    			}
		    		}
				}
				absent_on_null_flag = 0;

				tagcount++;

				tag = decos.getStr("tag");

				if(tag.equals("")){
					tag = this.toString();
					if(tag.contains(".")){
						tag = tag.substring(tag.indexOf(".") + 1);
					}
				}

				tag_value = this.getStr(data_info);
				XMLFunction.Func_replace(tag_value);

				if(tag_value.equals("")){
					if(decos.toString().toUpperCase().contains("EMPTY_ON_NULL")){
						xml_env.code.append("<" + tag);
					}
					else if(decos.toString().toUpperCase().contains("ABSENT_ON_NULL")){
						absent_on_null_flag = 1;
		    		}
		    		else if(decos.toString().toUpperCase().contains("NULL_ON_NULL")){
		    			tag_value = "NULL";
		    			xml_env.code.append("<" + tag);
		    		}
			    	else{
			    		xml_env.code.append("<" + tag);
			    	}
				 }

				else{
					xml_env.code.append("<" + tag);
				}

	    	}


	    	else if(decos.containsKey("att")){
	    		no_close_tag_flag = 0;
	    		att = decos.getStr("att");

				if(att.equals("")){
					att = this.toString();
					if(att.contains(".")){
						att = att.substring(att.indexOf(".") + 1);
					}
				}

				att_value = this.getStr(data_info);
				XMLFunction.Func_replace(att_value);

				if(att_value.equals("")){
					if(decos.toString().toUpperCase().contains("EMPTY_ON_NULL")){
						xml_env.code.append(" " + att + "=\"" + att_value + "\"");
			    	}
					else if(decos.toString().toUpperCase().contains("ABSENT_ON_NULL")){
						absent_on_null_flag = 1;
					}
				    else if(decos.toString().toUpperCase().contains("NULL_ON_NULL")){
						xml_env.code.append(" " + att + "=\"" + "NULL" + "\"");
					}
			    	else{
						xml_env.code.append(" " + att + "=\"" + att_value + "\"");
			    	}
			    }

				else{
					xml_env.code.append(" " + att + "=\"" + att_value + "\"");
				}
	    	}

	    	else if(decos.containsKey("notag")){
	    		no_close_tag_flag = 1;

	    		if(absent_on_null_flag != 1){
					if(tagcount >= 1){
		    			xml_env.code.append(">" + tag_value + "</" + tag + ">");
		    		}
	    		}
	    		absent_on_null_flag = 0;

				tagcount = 0;

				tag_value = this.getStr(data_info);
			    XMLFunction.Func_replace(tag_value);

				 if(tag_value.equals("")){
		    		if(decos.toString().toUpperCase().contains("NULL_ON_NULL")){
		    			tag_value = "NULL";
		    			xml_env.code.append(tag_value);
		    			xml_env.code.append("\n");
		    		}
				 }
				 else{
					 xml_env.code.append(tag_value);
					 xml_env.code.append("\n");
				 }
			}


			else{
				if(!decos.containsKey("parent_att")){

					no_close_tag_flag = 0;

					if(absent_on_null_flag != 1){
						if(tagcount >= 1){
			    			xml_env.code.append(">" + tag_value + "</" + tag + ">");
			    		}
					}
					absent_on_null_flag = 0;

					tagcount++;

					tag = this.toString();
					if(tag.contains(".")){
						tag = tag.substring(tag.indexOf(".") + 1);
					}

					tag_value = this.getStr(data_info);

					XMLFunction.Func_replace(tag_value);

					 if(tag_value.equals("")){
						if(decos.toString().toUpperCase().contains("EMPTY_ON_NULL")){
							xml_env.code.append("<" + tag);
						}
						else if(decos.toString().toUpperCase().contains("ABSENT_ON_NULL")){
							absent_on_null_flag = 1;
			    		}
			    		else if(decos.toString().toUpperCase().contains("NULL_ON_NULL")){
			    			tag_value = "NULL";
			    			xml_env.code.append("<" + tag);
			    		}
				    	else{
				    		xml_env.code.append("<" + tag);
				    	}
					 }

					else{
						xml_env.code.append("<" + tag);
					}
				}
			}
		}

    }
}