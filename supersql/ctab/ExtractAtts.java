package supersql.ctab;

import java.util.Hashtable;

import supersql.common.Log;
import supersql.parser.Start_Parse;

public class ExtractAtts {
	public void extractAtts(Start_Parse parser){
		Log.info("******* Extract Atts *******");
		Hashtable atts = parser.get_att_info();
		
	}
}
