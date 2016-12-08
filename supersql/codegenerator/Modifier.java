package supersql.codegenerator;

import java.util.ArrayList;

import supersql.common.GlobalEnv;

// added by halken
public class Modifier {
	
	public static ArrayList<String> replaceModifierValues (String property, String data_info) {
		String value = data_info;
		
		if (property.equals("align") || property.equals("text-align")) {
			property = "text-align";
		}
		
		if (property.equals("bgcolor") || property.equals("background-color")) {
			property = "background-color";
		}
		
		if (property.equals("color") || property.equals("font-color")) {
			property = "color";
		}
		
		if (property.equals("height")) {
			if (!GlobalEnv.isNumber(data_info)) {
				value = data_info;
			} else {
				value = data_info + "px";
			}
		}
		
		if (property.equals("padding")) {
			if (!GlobalEnv.isNumber(data_info)) {
				value = data_info;
			} else {
				value = data_info + "px";
			}
		}
		
		if (property.equals("size") || property.equals("font-size")) {
			property = "font-size";
			if (!GlobalEnv.isNumber(data_info)) {
				value = data_info;
			} else {
				value = data_info + "px";
			}
		}
		
		if (property.equals("valign") || property.equals("vertical-align")) {
			property = "vertical-align";
		}
		
		if (property.equals("width")) {
			if (!GlobalEnv.isNumber(data_info)) {
				value = data_info;
			} else {
				value = data_info + "px";
			}
		}
		
		ArrayList<String> data = new ArrayList<String>();
		data.add(property);
		data.add(value);
		return data;
	}
	
}
