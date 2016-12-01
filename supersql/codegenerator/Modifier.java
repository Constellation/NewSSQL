package supersql.codegenerator;

import supersql.common.GlobalEnv;

// added by halken
public class Modifier {
	
	public static String replaceModifierValues (String property, String data_info) {
		String value = data_info;
		
		if (property.equals("height")) {
			if (!GlobalEnv.isNumber(data_info)) {
				value = data_info;
			} else {
				value = data_info + "px";
			}
		}
		
		if (property.equals("width")) {
			if (!GlobalEnv.isNumber(data_info)) {
				value = data_info;
			} else {
				value = data_info + "px";
			}
		}
		return value;
	}
	
}
