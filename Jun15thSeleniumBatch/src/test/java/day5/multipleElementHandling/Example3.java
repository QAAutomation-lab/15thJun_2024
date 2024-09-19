package day5.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example3 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		//need to identify all available suggestions in the screen using findElements(By)
		List<WebElement> suggestionList=driver.findElements(By.cssSelector("ul.G43f7e>li>div>div:nth-of-type(2)>*:first-child>*:first-child>span"));
		
		System.out.println("Total number of suggestionList: "+suggestionList.size());
		
		for(int i=0;i<suggestionList.size();i++) {
			//to avoid: StaleElementReferenceException, re-identify suggestion list
			suggestionList=driver.findElements(By.cssSelector("ul.G43f7e>li>div>div:nth-of-type(2)>*:first-child>*:first-child>span"));
			System.out.println(suggestionList.get(i).getText());
		}		
	}
}
/*
write a script to get 
	- total number devices
	- all each page device name from the application

*/