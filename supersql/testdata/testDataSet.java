package supersql.testdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import supersql.common.GlobalEnv;
import supersql.common.Log;
import supersql.extendclass.ExtList;

public class testDataSet {

	static String input = new String();

	//static String input = "((a a1 ((b)(c)))(d d1 ((e))))";
	ExtList data_info;

	public testDataSet() {

		String filename = new String();

		filename = GlobalEnv.gettestdatafile();

		String tfebuffer = new String();

		try {
			BufferedReader myReader = new BufferedReader(new FileReader(
					filename));
			String line;
			while ((line = myReader.readLine()) != null) {
				tfebuffer = tfebuffer + line + " ";
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("file not found!");
		} catch (IOException e) {
			System.out.println("ioerror");
		}

		// Log.out("tfebuffer = " + tfebuffer);

		getList gl = new getList();
		input = gl.get_List(tfebuffer);

		Log.out("input = " + input);

		parseData p = new parseData(input);
		data_info = p.parseData_main();
		Log.out("result = " + data_info);

	}

	public ExtList getdata_info() {
		return data_info;
	}

}