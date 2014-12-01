package supersql.test.global.html;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link BasicOperatorTest}.
 * 
 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
 */
public class BasicOperatorTest {
	private static final String configFilename = "/Users/goto/config.ssql";
	// This string should finish with a slash
	private static final String testFilesFolder = "/Users/thomas/Documents/dev/ssql2/test_queries/basic_operators/";
	private static final String[] testFilesNames = {"connector0.sql", "connector1.sql",
			"connector2.sql", "connector3.sql", "grouper1.sql", "grouper2.sql",
			"grouper3.sql", "illegalArgumentConnector0.sql" };

	/**
	 * GENERATE HTML e.name + e.salary FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void connector0Test(){
		Element ssqlSection = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 0);
		Elements attributes = ssqlSection.getElementsByClass("att");
		
		Assert.assertEquals(1,attributes.size());
		Assert.assertTrue(attributes.first().text().matches("^.+\\d+$"));
	}
	
	/**
	 * GENERATE HTML e.name + [e.salary]! FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void illegalArgumentconnector0Test() throws IllegalArgumentException{
		TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 7);	
	}
	
	/**
	 * GENERATE HTML {e.name, e.salary} FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void connector1Test() {
		Element ssqlSection = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 1);

		Elements attributes = ssqlSection.getElementsByClass("att");

		// We should display 2 attributes
		Assert.assertEquals(2, attributes.size());

		// There should be only one table tag
		Assert.assertEquals(1, ssqlSection.getElementsByClass("con1").size());
	}

	/**
	 * GENERATE HTML {e.name ! e.salary} FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void Connector2Test() {

		Element ssqlSection = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 2);
		Assert.assertEquals(1, ssqlSection.getElementsByClass("con2").size());
		Assert.assertEquals(2, ssqlSection.getElementsByClass("att").size());
	}

	/**
	 * GENERATE HTML {e.name % e.salary} FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void Connector3Test() {
		Element ssqlSection = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 3);
		Element link = ssqlSection.getElementsByTag("a").first();
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
		Element ssqlSection = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 4);

		Assert.assertEquals(1, ssqlSection.getElementsByClass("group1").size());

		Assert.assertEquals(1, ssqlSection.getElementsByClass("horizontal").size());

	}

	/**
	 * GENERATE HTML [e.salary]! FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void Grouper2Test() {
		Element ssqlSection = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 5);

		Assert.assertEquals(1, ssqlSection.getElementsByClass("group2").size());
		
		Assert.assertEquals(1, ssqlSection.getElementsByClass("vertical").size());

	}

	/**
	 * GENERATE HTML [e.salary]% FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void Grouper3Test() {
		TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 6);

		String filename = testFilesFolder + testFilesNames[6].split("\\.")[0]
				+ "1.html";

		Element currentSsqlSection;
		int index = 0;
		while (filename != null) {
			try {
				currentSsqlSection = Jsoup.parse(new File(filename), "UTF-8").getElementById("ssql");
			} catch (IOException e) {
				e.printStackTrace();
				Assert.fail("The document " + filename + " does not exist");
				return;
			}
			Element nextLink = currentSsqlSection.getElementsByTag("a").last();
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
			Assert.assertEquals(numberOfLinks, currentSsqlSection.getElementsByTag("a").size());
			Assert.assertEquals(1,
					currentSsqlSection.getElementsByClass("linkButton").size());

			// the single attribute
			Assert.assertEquals(1, currentSsqlSection.getElementsByClass("att")
					.size());
		}

	}

	
}
