package day3.sync;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitExample1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//0-30 sec, to load the element
		driver.get("https://online.actitime.com/uts/login.do");
		
		driver.findElement(By.id("username")).sendKeys("admin01");
		driver.findElement(By.name("pwd")).sendKeys("admin01");
		driver.findElement(By.id("loginButton")).click();
		
		String expectedHomePageTitle="actiTIME - Enter Time-Track";
		
		//explicit wait(conditional wait)- FluentWait
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
							  .withTimeout(Duration.ofSeconds(20))
							  .pollingEvery(Duration.ofSeconds(5))
							  .ignoring(NoSuchElementException.class);		
		
		//here WebDriver will wait for 20 sec max to get expected title
		//wait.until(ExpectedConditions.titleIs(expectedHomePageTitle));
			//or here WebDriver will wait for 20 sec max for logout link to be available for click
		wait.until(ExpectedConditions.elementToBeClickable(By.id("logoutLink")));
		
		String actualHomePageTitle=driver.getTitle();
		System.out.println("Expected Home page title: "+expectedHomePageTitle);
		System.out.println("Actual Home page title: "+actualHomePageTitle);
		
		System.out.println("Is home page displayed after login ? "+expectedHomePageTitle.equals(actualHomePageTitle));
		
		driver.findElement(By.id("logoutLink")).click();
	}

}
/*
open browser
enter application url
enter username
enter password
click on login button
validate home page title is "actiTIME - Enter Time-Track"
click on logout link
close browser



*/