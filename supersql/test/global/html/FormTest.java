package supersql.test.global.html;

import org.jsoup.nodes.Element;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for {@link BasicOperatorTest}.
 * 
 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
 */
public class FormTest {
	
	private static final String configFilename = "/Users/thomas/Documents/dev/ssql2/.ssql";
	// This string should finish with a slash
	private static final String testFilesFolder = "/Users/thomas/Documents/dev/ssql2/test_queries/form/";
	private static final String[] testFilesNames = {"insert1.sql", "insert2.sql", "delete1.sql", "delete2.sql" };

	/**
	 * GENERATE HTML {e.Id, e.Name, e.salary} @ {insert} FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void insert1Test(){
		Element ssqlSection = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 0);
		checkFormInputs(ssqlSection);
		
		Assert.assertEquals(3,ssqlSection.getElementsByAttributeValue("type", "text").size());
		Assert.assertEquals(1, ssqlSection.getElementsByClass("horizontal").size());
		Assert.assertEquals(4, ssqlSection.getElementsByClass("vertical").size());
	}
	
	/**
	 * GENERATE HTML {e.Id! e.Name! e.salary} @ {insert} FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void insert2Test(){
		Element ssqlSection = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 1);
		checkFormInputs(ssqlSection);
		
		Assert.assertEquals(3,ssqlSection.getElementsByAttributeValue("type", "text").size());
		Assert.assertEquals(2, ssqlSection.getElementsByClass("vertical").size());
		Assert.assertEquals(3, ssqlSection.getElementsByClass("horizontal").size());
	}
	
	/**
	 * GENERATE HTML {e.Id, e.Name, e.salary} @ {delete} FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void delete1Test(){
		Element ssqlSection = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 2);
		checkFormInputs(ssqlSection);
		
		Assert.assertEquals(3,ssqlSection.getElementsByAttributeValue("type", "checkbox").size());
		Assert.assertEquals(1, ssqlSection.getElementsByClass("vertical").size());
		Assert.assertEquals(4, ssqlSection.getElementsByClass("horizontal").size());
	}
	
	/**
	 * GENERATE HTML {e.Id! e.Name! e.salary} @ {delete} FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void delete2Test(){
		Element ssqlSection = TestUtils.launchQueryAndGetResult(configFilename, testFilesFolder, testFilesNames, 3);
		checkFormInputs(ssqlSection);
		
		Assert.assertEquals(3,ssqlSection.getElementsByAttributeValue("type", "checkbox").size());
		Assert.assertEquals(2, ssqlSection.getElementsByClass("vertical").size());
		Assert.assertEquals(3, ssqlSection.getElementsByClass("horizontal").size());
	}
	
	/**
	 * GENERATE HTML {e.Id, e.Name, e.salary} @ {update} FROM employee e
	 * 
	 * @author thomas@oxynum.fr (Thomas THIMOTHEE)
	 */
	@Test
	public void update1Test(){
		
	}
	
	private void checkFormInputs(Element ssqlSection){
		Assert.assertEquals(1,ssqlSection.getElementsByTag("form").size());
		Assert.assertEquals( 4,ssqlSection.getElementsByTag("input").size());
		Assert.assertEquals( 1,ssqlSection.getElementsByAttributeValue("type", "submit").size());
	}
	
}
