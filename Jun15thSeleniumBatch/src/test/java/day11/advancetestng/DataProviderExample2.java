package day11.advancetestng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilities.SeleniumUtil;


public class DataProviderExample2 extends SeleniumUtil {


	@Test(dataProvider = "getTextForSearch")
	public void testGoogleSearch(String textToBeSearched) {
		setUp("chrome", "https://www.google.com");
		typeRequiredInput(driver.findElement(By.name("q")), textToBeSearched);
		getActiveElementFromUI().sendKeys(Keys.ENTER);
		driver.quit();
	}
	
	@DataProvider
	public Object[] getTextForSearch() {
		Object[] obj= {"Selenium","Manual Testing","API Testing"};
		return obj;
	}
}
/**
Create a method with return type as Multidimension array of Object type
and also add @DataProvider tag
*/