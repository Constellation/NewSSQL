package supersql.codegenerator.XML;

import supersql.codegenerator.Grouper;
import supersql.codegenerator.Manager;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class XMLG0 extends Grouper {

    Manager manager;

    XMLEnv xml_env;
    XMLEnv xml_env2;


    public XMLG0(Manager manager, XMLEnv xenv, XMLEnv xenv2) {
        this.manager = manager;
        this.xml_env = xenv;
        this.xml_env2 = xenv2;
    }

    @Override
	public void work(ExtList data_info) {
        Log.out("************* XMLG0 *************");
        this.setDataList(data_info);

        String tag;

        String grouper_att0 = null;
        String grouper_att_value0 = null;

        String grouper_att = null;
        String grouper_att_value = null;

        int Grouper_flag = 0;

        if(decos.containsKey("tag")){
		       tag = decos.getStr("tag");

		       if(tag.equals("")){
		    	   tag = "null";
		       }

		       xml_env.code.append("<" + tag);
		       Grouper_flag = 1;
        }


        else{
     	   tag = "null";
     	   Grouper_flag = 0;
        }


       if(decos.containsKey("root_att") && decos.containsKey("value")){

		   	if(decos.containsKey("root_att")){
		   		grouper_att0 = decos.getStr("root_att");
		   		XMLFunction.Func_att_replace(grouper_att0);
		   	}


		   	if(decos.containsKey("value")){
		   		grouper_att_value0 = decos.getStr("value");
		   		XMLFunction.Func_att_replace(grouper_att_value0);
		   	}


			xml_env.code.append(" " + grouper_att0 + "=\"" + grouper_att_value0 + "\"");
       }


       if(decos.containsKey("root_att1") && decos.containsKey("value1")){

    	   int attNo = 1;

		   while (decos.containsKey("root_att"+attNo)){

			   	if(decos.containsKey("root_att"+attNo)){
			   		grouper_att = decos.getStr("root_att"+attNo);
			   		XMLFunction.Func_att_replace(grouper_att);
			   	}

			   	if(decos.containsKey("value"+attNo)){
			   		grouper_att_value = decos.getStr("value"+attNo);
			   		XMLFunction.Func_att_replace(grouper_att_value);
			   	}


			   	xml_env.code.append(" " + grouper_att + "=\"" + grouper_att_value + "\"");

			   	attNo++;
		   }
       }


       if(Grouper_flag == 1){
    	   xml_env.code.append(">");
       }

        Log.out("G0 tag(start) : " + tag);

        while (this.hasMoreItems()) {
        	this.worknextItem();
        }

        if(Grouper_flag == 1){
        	xml_env.code.append("</" + tag + ">");
        	Grouper_flag = 0;
        }

        XMLAttribute.tagcount = 0;

        Log.out("G0 tag(end) : " + tag);

        Log.out("TFEId = " + XMLEnv.getClassID(this));

    }

    @Override
	public String getSymbol() {
        return "XMLG0";
    }

}