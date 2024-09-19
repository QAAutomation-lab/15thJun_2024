package day2.objectidentification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		
		driver.get("https://online.actitime.com/uts/login.do");
		
		//identify username input field & perform required operation
		driver.findElement(By.id("username")).sendKeys("admin01");
		
		//identify password input field & perform required operation
		driver.findElement(By.name("pwd")).sendKeys("admin01");
		
		//identify login button & perform required operation
		driver.findElement(By.id("loginButton")).click();

	}
}
/*
 * TC:
 * 	open browser
 * 	enter app url
 * 	enter username as admin01
 * 	enter password as admin01
 * 	click on login
 */

/*
Step1: identify the required element using findElement(By)

findElement(By)- use to identify the element using "By" class and this class has predefined methods which are also known as locators and return the WebElement.

WebElement element=driver.findElement(By.id(""));
										.name(""));
										.linkText(""));
										.className(""));
										.partialLinkText(""));
										.tagName(""));
										.cssSelector(""));
										.xpath(""));
										
Step2: once you identify the WebElement you can perform required operation it
	a. type text  			----> sendkeys("");
	b. delete existing text ----> clear();
	c. click on element     ----> click();
	
	element.sendkeys("amdin");
	element.clear();
	element.click();
*/