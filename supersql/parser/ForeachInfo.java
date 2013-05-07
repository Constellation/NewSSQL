/*
 * Created on 2004/07/23 by kyoko
 */
package supersql.parser;

import java.util.Hashtable;
import java.util.StringTokenizer;

public class ForeachInfo {

	private String line;

	private String foreach_att;

	private StringBuffer foreach_from;

	private StringBuffer foreach_where;

	private Hashtable foreach_table;

	public ForeachInfo(String line) {
		this.line = line;
		this.foreach_att = new String();
		this.foreach_from = new StringBuffer();
		this.foreach_where = new StringBuffer();
		this.makeInfo(line);
	}

	public void makeInfo(String line) {
		StringBuffer buf = new StringBuffer();
		if (line.startsWith("(")) {
			line = line.substring(1, line.length() - 1);
		}
		StringTokenizer st = new StringTokenizer(line, " ");
		foreach_att = st.nextToken().trim();
		if(st.hasMoreTokens())
		{
		String s = st.nextToken().trim();
		while (foreach_att.endsWith(",") || s.equals(",")) {
			 foreach_att = foreach_att + s;
			 if (st.hasMoreTokens()) {
			 	s = st.nextToken().trim();
			 }
		}
		}
		if (st.hasMoreTokens()) {
			//st.nextToken();
			while (st.hasMoreTokens()) {
				String ch = st.nextToken().trim();
				if (ch.equalsIgnoreCase("WHERE")) {
					break;
				}
				foreach_from.append(ch + " ");
			}

			while (st.hasMoreTokens()) {
				String ch = st.nextToken().trim();
				foreach_where.append(ch + " ");
			}
		}

	}

	@Override
	public String toString() {
		return "{ line : " + line + ", foreach_att : " + foreach_att
				+ ", foreach_from :" + foreach_from + ", foreach_where :"
				+ foreach_where + " }";
	}

	public String getLine() {
		return line;
	}

	public String getForeachAtt() {
		return foreach_att;
	}

	public String getForeachFrom() {
		return foreach_from.toString();
	}

	public String getForeachWhere() {
		return foreach_where.toString();
	}

}

