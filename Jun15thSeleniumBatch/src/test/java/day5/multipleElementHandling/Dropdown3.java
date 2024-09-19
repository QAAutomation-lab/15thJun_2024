package day5.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown3 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://thompsonsj.com/bootstrap-select-dropdown/");
		
		driver.findElement(By.cssSelector(".dropdown-toggle")).click();
		
		List<WebElement> options=driver.findElements(By.cssSelector(".dropdown-menu-right.show>div>a"));
		System.out.println("Option count: "+options.size());
		for(WebElement element:options) {
			System.out.println(element.getText());
		}
		
		options.get(2).click();
	}
}
/*
write a script to get 
	- total number devices
	- all each page device name from the application

*/