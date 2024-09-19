package day3.sync;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitExample1 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//0-30 sec, to load the element
		driver.get("https://www.saucedemo.com/");
		//0-30 sec, to load the element
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//0-30 sec, to load the element
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//0-30 sec, to load the element
		driver.findElement(By.id("login-button")).click();
		//0-30 sec, to load the element
		driver.findElement(By.id("react-burger-menu-btn")).click();
		//0-30 sec, to load the element
		driver.findElement(By.id("logout_sidebar_link")).click();
	}
}
/*
S1: perform login & logout operation in https://www.saucedemo.com/
	standard_user/secret_sauce

s2: perform login & logout operation in
	https://demowebshop.tricentis.com/login
	tester01@vomoto.com/Abc@12345
	
s3: perform login & logout operation in 
	https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
	Admin/admin123
*/
