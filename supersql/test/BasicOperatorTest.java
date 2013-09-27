package supersql.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import supersql.FrontEnd;

/**
 * Tests for {@link BasicOperatorTest}.
 * 
 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
 */
public class BasicOperatorTest {
	private static final String projectFolder = "/Users/thomas/Documents/dev/ssql2/";
	private static final String configFilename = "/Users/thomas/Documents/dev/ssql2/.ssql";
	// This string should finish with a slash
	private static final String testFilesFolder = "/Users/thomas/Documents/dev/ssql2/test_queries/";
	private static final String[] testFilesNames = { "connector1.sql",
			"connector2.sql", "connector3.sql", "grouper1.sql", "grouper2.sql",
			"grouper3.sql" };

	/**
	 * GENERATE HTML {e.name, e.salary} FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void connector1Test() {
		Document document = launchQueryAndGetResult(0);

		Elements attributes = document.getElementsByClass("att");

		// We should display 2 attributes
		Assert.assertEquals(2, attributes.size());

		// There should be only one table tag
		Assert.assertEquals(1, document.getElementsByTag("table").size());

		Assert.assertEquals(1, document.getElementsByTag("tr").size());
		Assert.assertEquals(2, document.getElementsByTag("tr").first()
				.getElementsByTag("td").size());
	}

	/**
	 * GENERATE HTML {e.name ! e.salary} FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void Connector2Test() {

		Document document = launchQueryAndGetResult(1);
		Assert.assertEquals(2, document.getElementsByTag("tr").size());
		Assert.assertEquals(1, document.getElementsByTag("tr").first()
				.getElementsByTag("td").size());
		Assert.assertEquals(2, document.getElementsByClass("att").size());
	}

	/**
	 * GENERATE HTML {e.name % e.salary} FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void Connector3Test() {
		Document document = launchQueryAndGetResult(2);
		Element link = document.getElementsByTag("a").first();
		Assert.assertNotNull("There is no link in the page", link);
		String filename = testFilesFolder + link.attr("href");
		Document secondDocument = null;
		try {
			secondDocument = Jsoup.parse(new File(filename), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail("The second file for the third dimension connector has not been created");
		}
		Assert.assertEquals(1, secondDocument.getElementsByClass("att").size());
	}

	/**
	 * GENERATE HTML [e.salary], FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void Grouper1Test() {
		Document document = launchQueryAndGetResult(3);

		int numberOfAttributes = document.getElementsByClass("att").size();

		Assert.assertEquals(1, document.getElementsByTag("table").size());

		Assert.assertEquals(numberOfAttributes + 1, document
				.getElementsByClass("nest").size());

		Assert.assertEquals(1, document.getElementsByTag("tr").size());

		Assert.assertEquals(numberOfAttributes, document.getElementsByTag("td")
				.size());
	}

	/**
	 * GENERATE HTML [e.salary]! FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void Grouper2Test() {
		Document document = launchQueryAndGetResult(4);

		int numberOfAttributes = document.getElementsByClass("att").size();

		Assert.assertEquals(1, document.getElementsByTag("table").size());

		Assert.assertEquals(numberOfAttributes + 1, document
				.getElementsByClass("nest").size());

		Assert.assertEquals(numberOfAttributes, document.getElementsByTag("tr")
				.size());
		Assert.assertEquals(numberOfAttributes, document.getElementsByTag("td")
				.size());
	}

	/**
	 * GENERATE HTML [e.salary]% FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void Grouper3Test() {
		launchQueryAndGetResult(5);

		String filename = testFilesFolder + testFilesNames[5].split("\\.")[0]
				+ "1.html";

		Document currentDocument;
		int index = 0;
		while (filename != null) {
			try {
				currentDocument = Jsoup.parse(new File(filename), "UTF-8");
			} catch (IOException e) {
				e.printStackTrace();
				Assert.fail("The document " + filename + " does not exist");
				return;
			}
			Element nextLink = currentDocument.getElementsByTag("a").last();
			int numberOfLinks = 2;
			if(index == 0){
				numberOfLinks = ++index;
			}
			if (nextLink.html().contains("next")) {
				filename = nextLink.attr("href");
			} else {
				filename = null;
				numberOfLinks = 1;
			}
			// next button
			Assert.assertEquals(numberOfLinks, currentDocument.getElementsByTag("a").size());
			Assert.assertEquals(1,
					currentDocument.getElementsByClass("linkButton").size());

			// the single attribute
			Assert.assertEquals(1, currentDocument.getElementsByClass("att")
					.size());
		}

	}

	private Document launchQueryAndGetResult(int index) {
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
