package supersql.test.global.html;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;

import supersql.FrontEnd;

public class TestUtils {
	public static Document launchQueryAndGetResult(String configFilename, String testFilesFolder, String[] testFilesNames, int index) {
		String[] args = new String[4];
		args[0] = "-c";
		args[1] = configFilename;
		args[2] = "-f";
		args[3] = testFilesFolder + testFilesNames[index];

		new FrontEnd(args);

		Document document = null;
		try {
			String filename = testFilesNames[index].split("\\.")[0] + ".html";
			document = Jsoup.parse(new File(testFilesFolder + filename),
					"UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("The file has not been created");
			return null;
		}
		return document;
	}
}
