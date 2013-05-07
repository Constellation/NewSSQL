package supersql.testdata;


public class getList {

	private String in = new String();

	private int listIndex;

	private String sampleData;

	public String get_List(String strs) {

		in = strs;
		listIndex = in.indexOf("(");

		sampleData = in.substring(listIndex);
		return sampleData;

	}
}