package basicTestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.SeleniumUtil;

public class ActitimeLoginValidation extends SeleniumUtil{
	
	@Test(priority=1,enabled=false)
	public void testLoginPageValidationWithOutAssert() {
		setUp("chrome", "https://online.actitime.com/qk/login.do");
		String expectedTitle="actiTIME -Login";
		String actualTitle=getCurrentPageTitle();
		System.out.println("Login page validation status: "+actualTitle.equals(expectedTitle));
		driver.quit();
	}
	
	@Test(priority=2,enabled=false)
	public void testLoginPageValidationWithAssert() {
		setUp("chrome", "https://online.actitime.com/qk/login.do");
		String expectedTitle="actiTIME -Login";
		String actualTitle=getCurrentPageTitle();
		//System.out.println("Login page validation status: "+actualTitle.equals(expectedTitle));
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=3,enabled=false)
	public void testLoginPageValidationWithAssert2() {
		setUp("chrome", "https://online.actitime.com/qk/login.do");
		String expectedTitle="actiTIME -Login";
		String actualTitle=getCurrentPageTitle();
		//System.out.println("Login page validation status: "+actualTitle.equals(expectedTitle));
		Assert.assertEquals(actualTitle, expectedTitle,"Either login page not opened or title got changed..");
	}
	
	@Test(priority=4,enabled=false)
	public void testLoginPageValidationWithAssert3() {
		setUp("chrome", "https://online.actitime.com/qk/login.do");
		String expectedTitle="actiTIME - Login";
		String actualTitle=getCurrentPageTitle();
		//System.out.println("Login page validation status: "+actualTitle.equals(expectedTitle));
		Assert.assertEquals(actualTitle, expectedTitle,"Either login page not opened or title got changed..");
	}
	
	@Test(priority=5,enabled=true)
	public void testLoginPageValidationWithAssert4() {
		setUp("chrome", "https://online.actitime.com/qk/login.do");
		WebElement usernameInputField=driver.findElement(By.id("username"));
		boolean res=isElementPresent(usernameInputField);
		//Assert.assertTrue(res); //or
		Assert.assertTrue(res,"Username input field is not available in the login page");
	}
}
/*
* Validation in testng:
* 		Assert.
* 				assertEqual(arg1,arg2);
* 				assertEqual(arg1,arg2,"msg on validation fail");
* 				assertTrue(boolean condition);
* 				assertTrue(boolean condition,"msg on validation fail");
* 				assertFalse(boolean condition);
* 				assertFalse(boolean condition,"msg on validation fail");
*/