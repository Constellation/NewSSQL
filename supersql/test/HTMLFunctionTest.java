package supersql.test;

import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Test;

public class HTMLFunctionTest {
	private static final String configFilename = "/Users/goto/config.ssql";
	// This string should finish with a slash
	private static final String testFilesFolder = "/Users/goto/Documents/workspace/src'12/test_queries/html_function/";
	private static final String[] testFilesNames = { "link.sql" };
	
	/**
	 * GENERATE HTML link(e.name, file="foo.sql", att=e.id) FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void linkTest(){
		Document document = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 0);
		Assert.assertEquals(1,document.getElementsByTag("a").size());
		String href = document.getElementsByTag("a").first().attr("href");
		String pattern = "^foo_\\d+.html";
		Assert.assertTrue(href.matches(pattern));
	}
}
