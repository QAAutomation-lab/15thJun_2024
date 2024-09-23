package day11.advancetestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import utilities.SeleniumUtil;

public class TestParallelExecution{
	WebDriver driver;
	@Test
	public void testLoginOfVtiger() {
		driver=new FirefoxDriver();
		/*implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		/*maximize browser window*/
		driver.manage().window().maximize();
			driver.get("https://demo.vtiger.com/vtigercrm/index.php");
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("Test@123");
			driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
	}
	@Test
	public void testLoginOfActitime() {
		driver=new ChromeDriver();
		/*implicit wait*/
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		/*maximize browser window*/
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/");		 
			driver.findElement(By.id("username")).sendKeys("admin");
			driver.findElement(By.cssSelector("input[name='pwd']")).sendKeys("manager");
			driver.findElement(By.cssSelector("input[name='pwd']")).sendKeys(Keys.ENTER);
	}
}
