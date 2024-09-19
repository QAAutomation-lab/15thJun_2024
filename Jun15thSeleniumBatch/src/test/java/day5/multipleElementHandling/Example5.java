package day5.multipleElementHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example5 {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testData\\AppData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("appUrl"));
		
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.cssSelector(".orangehrm-login-button")).click();
	}
}
/*
write a script to get 
	- total number devices
	- all each page device name from the application

*/