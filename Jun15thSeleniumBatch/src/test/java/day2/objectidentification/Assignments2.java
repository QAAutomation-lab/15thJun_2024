package day2.objectidentification;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignments2 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//0-30 sec, to load the element
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//0-30 sec, to load the element
		driver.findElement(By.name("username")).sendKeys("Admin");
		//0-30 sec, to load the element
		driver.findElement(By.name("password")).sendKeys("admin123");
		//0-30 sec, to load the element
		driver.findElement(By.className("orangehrm-login-button")).click();
		//0-30 sec, to load the element
		driver.findElement(By.className("oxd-userdropdown-img")).click();	
		//0-30 sec, to load the element
		driver.findElement(By.linkText("Logout")).click();

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
