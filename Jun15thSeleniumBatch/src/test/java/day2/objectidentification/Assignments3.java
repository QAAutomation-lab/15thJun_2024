package day2.objectidentification;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignments3 {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demowebshop.tricentis.com/login");
		
		driver.findElement(By.id("Email")).sendKeys("tester01@vomoto.com");
		driver.findElement(By.id("Password")).sendKeys("Abc@12345");
		driver.findElement(By.className("login-button")).click();
		
		driver.findElement(By.className("ico-logout")).click();		

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
