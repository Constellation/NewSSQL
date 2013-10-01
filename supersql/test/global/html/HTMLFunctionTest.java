package supersql.test.global.html;

import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.junit.Test;

public class HTMLFunctionTest {
	private static final String configFilename = "/Users/thomas/Documents/dev/ssql2/.ssql";
	// This string should finish with a slash
	private static final String testFilesFolder = "/Users/thomas/Documents/dev/ssql2/test_queries/html_function/";
	private static final String[] testFilesNames = { "link.sql", "image.sql" };
	
	/**
	 * GENERATE HTML link({e.name},{ "foo" + e.id + ".html"}, bar='toto') FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void linkTest(){
		Element element = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 0);
		Assert.assertEquals(1,element.getElementsByTag("a").size());
		Element a = element.getElementsByTag("a").first();
		String href = a.attr("href");
		String pattern = "^foo\\d+.html";
		Assert.assertTrue(href.matches(pattern));
		Assert.assertEquals("toto", a.attr("bar"));
	}
	
	/**
	 * GENERATE HTML image({'images/employee_' + e.id + '.jpg'}) FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void imageTest(){
		Element element = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 1);
		Assert.assertEquals(1, element.getElementsByTag("img").size());
		String src = element.getElementsByTag("img").first().attr("src");
		Assert.assertTrue(src.matches("images/employee_\\d+\\.jpg"));
	}
}
