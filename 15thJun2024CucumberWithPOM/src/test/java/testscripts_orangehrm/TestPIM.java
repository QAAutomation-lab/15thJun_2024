package testscripts_orangehrm;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.SeleniumUtility;
import webpages_orangehrm.AddEmployeePage;
import webpages_orangehrm.HomePage;
import webpages_orangehrm.LoginPage;
import webpages_orangehrm.PersonalDetailsPage;
import webpages_orangehrm.PimHomePage;

public class TestPIM extends SeleniumUtility{
	WebDriver driver;
	LoginPage getLoginPage;
	HomePage getHomePage;
	PimHomePage getPimHomePage;
	PersonalDetailsPage getPersonalDetailsPage;
	AddEmployeePage getAddEmployeePage;
	@BeforeTest
	public void openBrowser() {
		driver=setUp("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@BeforeMethod
	public void precondition() {
		getLoginPage=new LoginPage(driver);
		getHomePage=new HomePage(driver);
		getPimHomePage=new PimHomePage(driver);
		getPersonalDetailsPage=new PersonalDetailsPage(driver);
		getAddEmployeePage=new AddEmployeePage(driver);
		
		getLoginPage.loginIntoOrangeHrm("Admin", "admin123");
		getHomePage.clickOnPIM();
	}
	
	@Test(priority=1)
	public void testPIM_Creation() {
		//click on Add button
		getPimHomePage.clickOnAddButton();
		//fill employee details and save it
		getAddEmployeePage.createEmployee("Mobile", "Lead", 12345);
		//navigate to PIM home page
		getHomePage.clickOnPIM();
		//search for newly created employee
		getPimHomePage.searchCreatedEmployee(12345);
		//compare search result
		String acutalMsg=getPimHomePage.getSearchResultMsg();
		String expectedMsg="(1) Record Found";
		Assert.assertEquals(acutalMsg, expectedMsg);
	}
	@Test(priority=2,dependsOnMethods = "testPIM_Creation")
	public void testPIM_Update() {
		System.out.println("**********testPIM_Update*******************");
	}
	@Test(priority=3,dependsOnMethods = "testPIM_Creation")
	public void testPIM_Delete() {
		//navigate to PIM home page
		getHomePage.clickOnPIM();
		getPimHomePage=new PimHomePage(driver);
		//search for newly created employee
		getPimHomePage.searchCreatedEmployee(12345);
		//select checkbox and delete it
		getPimHomePage.deleteCreatedEmployee();
		//validate search reasult
		String acutalMsg=getPimHomePage.getSearchResultMsg();
		String expectedMsg="No Records Found";
		Assert.assertEquals(acutalMsg, expectedMsg);
	}
	
	@AfterMethod
	public void postcondition() {
		getHomePage.logoutFromHrm();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
