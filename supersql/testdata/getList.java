package supersql.testdata;


public class getList {

	String in = new String();

	int listIndex;

	String sampleData;

	/*
	 * sample.txt��ɬ�פ���ʬ��������Ф�
	 */

	public String get_List(String strs) {

		in = strs;
		listIndex = in.indexOf("(");

		sampleData = in.substring(listIndex);
		return sampleData;

	}
}