package ornageHRMTestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ornageHRMWebPages.HomePage;
import ornageHRMWebPages.LoginPage;
import utilities.SeleniumUtility;

public class LoginLogoutText extends SeleniumUtility{
	WebDriver driver;
	LoginPage getLoginPage;
	HomePage getHomePage;
	
	@BeforeTest
	public void precondition() {
		driver=setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		getLoginPage=new LoginPage(driver);
		getHomePage=new HomePage(driver);
	}
	@Test
	public void testLoginFlow() {
		getLoginPage.loginIntoApplication("Admin", "admin123");
		String expectedUrl="dashboard";
		String actualUrl=getCurrentUrlOfApplication();
		Assert.assertTrue(actualUrl.contains(expectedUrl));
	}
	
	@AfterTest
	public void postCondition() {
		getHomePage.logoutFromApplication();
		driver.quit();
	}
}
