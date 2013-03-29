package supersql.codegenerator.CSV;

import java.util.StringTokenizer;

import supersql.codegenerator.Attribute;
import supersql.codegenerator.Manager;
import supersql.common.Log;
import supersql.extendclass.ExtList;
import supersql.parser.TFEtokenizer;

public class CSVAttribute extends Attribute {

    Manager manager;

    CSVEnv csv_env;
    CSVEnv csv_env2;

	public static String value;
/*	public static String attribute;*/

    //コンストラクタ
    public CSVAttribute(Manager manager, CSVEnv xenv, CSVEnv xenv2) {
        super();
        this.manager = manager;
        this.csv_env = xenv;
        this.csv_env2 = xenv2;
/*
        //�??タベ�?ス属�?をCSVファイルに明�?
        if(decos.containsKey("att")){
        	//DBの属�?名を挿入
        	attribute = this.toString();
        	if(attribute.contains(".")){
        		attribute = attribute.substring(attribute.indexOf(".") + 1);
        	}
        	csv_env.code.append(attribute + ", ");
        }
*/
    }

    //Attributeのworkメソ�?��
    public void work(ExtList data_info){
    	//�??タベ�?スから�??タを取�?
    	value = this.getStr(data_info);
        csv_env.code.append(value + ", ");
    }
}

