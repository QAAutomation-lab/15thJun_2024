package googleTestScripts;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import googleWebPages.GoogleResultPage;
import googleWebPages.GoogleSearchPage;
import utilities.SeleniumUtility;

public class TestGoogleSearchFlow extends SeleniumUtility{
	
	GoogleSearchPage getGoogleSearchPage;
	GoogleResultPage getGoogleResultPage;
	@BeforeTest
	public void precondition() {
		driver=setUp("chrome", "https://www.google.com");
		getGoogleSearchPage=new GoogleSearchPage(driver);
		getGoogleResultPage=new GoogleResultPage(driver);
	}
	
	@Test
	public void testGoogleSuggestionCount() {
		getGoogleSearchPage.typeRequiredText("Selenium");
		int count=getGoogleSearchPage.getSuggestionCount();
		Assert.assertEquals(count, 10);
	}
	
	@Test
	public void testSuggestionSelection() {
		getGoogleSearchPage.pressEnterButton();
		String actualTitle=getGoogleResultPage.getSearchedResultPageTitle();
		Assert.assertEquals(actualTitle, "Selenium - Google Search");
	}
	
	@AfterTest
	public void postConditions() {
		driver.quit();
	}
}
