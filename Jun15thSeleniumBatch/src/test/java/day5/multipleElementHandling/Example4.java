package day5.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example4 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.automationtesting.in/Register.html");
		
		//need to identify menu names from screen using findElements(By)
		List<WebElement> menuList=driver.findElements(By.cssSelector(".navbar-nav>li>a"));
		
		System.out.println("Total number of Menu: "+menuList.size());
		
		for(int i=0;i<menuList.size();i++) {
			System.out.println(menuList.get(i).getText());
		}		
	}
}
/*
write a script to get 
	- total number devices
	- all each page device name from the application

*/