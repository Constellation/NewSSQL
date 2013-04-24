package supersql.codegenerator.XML;

import supersql.codegenerator.*;
import supersql.codegenerator.XML.XMLEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;
import supersql.parser.TFEparser;

public class XMLC0 extends Connector {

    Manager manager;

    public static XMLEnv xml_env;
    XMLEnv xml_env2;

    public static int attflag = 0;
    public static int parent_attflag = 0;
    public static int tagclose_flag = 0;
    public static int decos_tag_flag = 0;
    public static int XMLC0_passflag = 0;

    TFEparser tfeps;

    public XMLC0(Manager manager, XMLEnv xenv, XMLEnv xenv2) {
        this.manager = manager;
        this.xml_env = xenv;
        this.xml_env2 = xenv2;
    }

    public void work(ExtList data_info) {
    	Log.out("------------- XMLC0 -------------");

    	XMLC0_passflag++;

        this.setDataList(data_info);

        int i = 0;

        String tag = null;

	    if(decos.containsKey("tag")){

        	tag = decos.getStr("tag");

        	if(tag.equals("")){
        		tag = "null";
        	}

	        xml_env.code.append("<" + tag);
		    parent_attflag = 1;
		    decos_tag_flag = 1;
	   }

	    else{
	    	decos_tag_flag = 0;
	    }

	   	 while(this.hasMoreItems()) {

		    ITFE tfe = (ITFE)tfes.get(i);

		    this.worknextItem_GENERATEXML();
		}


	   	if(tagclose_flag == 0){

	   		if(XMLAttribute.absent_on_null_flag != 1){

		   		if(XMLFunction.function_close != 1){
		   			xml_env.code.append(">");
		   		}

		   		if(XMLAttribute.no_close_tag_flag == 0){
		   			xml_env.code.append(XMLAttribute.tag_value);
		   			xml_env.code.append("</" + XMLAttribute.tag + ">");
		   		}
	   		}

        	XMLAttribute.absent_on_null_flag = 0;

	   	}

	   	XMLFunction.function_close = 0;
	   	tagclose_flag++;

	   	if(decos.containsKey("tag")){
	   		xml_env.code.append("</" + tag + ">");
	   	}

	   	Log.out("C0 tag(end) : " + tag);
	   	Log.out("TFEId = " + XMLEnv.getClassID(this));

    }

    public String getSymbol() {
        return "XMLC0";
    }

}