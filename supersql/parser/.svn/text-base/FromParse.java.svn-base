package supersql.parser;

import supersql.common.Log;

public class FromParse {

	String line;

	String real_name;

	String alias;
	

	public FromParse(String line) {
		this.line = line;
		this.real_name = "";
		this.alias = "";
		this.parseString(line);
	}

	public void parseString(String line) {
		int ind = line.indexOf(" ");
		if (ind == -1) {
		    this.real_name = line;
		    this.alias = line;
		    Log.out("[FromParse] alias name omitted table = "+ line);
		} else {
		    this.real_name = line.substring(0, ind);
		    this.alias = line.substring(ind + 1);
		}
	}

	@Override
	public String toString() {
		return "{ line : " + line + ", real_name : " + real_name + ", alias : "
				+ alias + " }";
	}

	public String getLine() {
		return line;
	}

	public String getRealName() {
		return real_name;
	}

	public String getAlias() {
		return alias;
	}

}