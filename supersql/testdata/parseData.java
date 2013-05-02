package supersql.testdata;

import java.util.StringTokenizer;

import supersql.extendclass.ExtList;

//import common.Log;

public class parseData {

	StringTokenizer st;

	String input;

	public parseData(String s) {
		input = s;
	}

	public ExtList parseData_main() {

		st = new StringTokenizer(input, "() ", true);
		ExtList result = new ExtList();

		String tok = st.nextToken();
		//  Log.out("tok =" + tok);
		if (tok.equals("(")) {
			result = p_List();
		} else {
			System.out.println("[Error] not Start at (\n");
		}
		return result;

	}

	private ExtList p_List() {

		ExtList result = new ExtList();
		String tok;

		//  Log.out("***start paren***");

		while (st.hasMoreTokens()) {
			tok = st.nextToken();
			//   Log.out("tok =" + tok);
			if (tok.equals(" ")) {
			} else if (tok.equals("(")) {
				result.add(this.p_List());
			} else if (tok.equals(")")) {
				//    Log.out("***end paren***");
				return result;
			} else {
				result.add(tok);
			}
		}

		//  System.out.println("[Error] paren mismatch");

		return result;

	}

}