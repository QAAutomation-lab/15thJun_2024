package ddtexamples;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utilities.ExcelUtility;
import utilities.SeleniumUtil;

public class Example2 extends SeleniumUtil{
	String appUrl;
	String username;
	String password;
	String expectedResult;
	String actualResult;
	boolean status;
	@BeforeTest
	public void getData() {
		appUrl=ExcelUtility.getCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "Sheet1", 1, 0);
		username=ExcelUtility.getCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "Sheet1", 1, 1);
		password=ExcelUtility.getCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "Sheet1", 1, 2);
		expectedResult=ExcelUtility.getCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "Sheet1", 1, 3);
	}

	@Test
	public void testOrangeHRM() {
		setUp("chrome", appUrl);
		typeRequiredInput(driver.findElement(By.id("username")), username);
		typeRequiredInput(driver.findElement(By.name("pwd")), password);
		clickOnRequiredElement(driver.findElement(By.id("loginButton")));
		actualResult=getCurrentPageTitle(expectedResult);
		status=actualResult.equals(actualResult);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@AfterTest
	public void updateReport() {
		ExcelUtility.updateCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "Sheet1", 1, 4, actualResult);
		if(status) {
			ExcelUtility.updateCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "Sheet1", 1, 5, "Pass");
		}else {
			ExcelUtility.updateCellValue(".\\src\\test\\resources\\testData\\AppData.xlsx", "Sheet1", 1, 5, "Fail");
		}
	}
}
