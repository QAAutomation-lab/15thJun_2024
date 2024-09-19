package day5.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.demoblaze.com/");
		
		//need to identify all device available  in the screen using findElements(By)
		List<WebElement> deviceList=driver.findElements(By.cssSelector("#tbodyid>div>div>div>h4>a"));
		
		System.out.println("Total number of devices: "+deviceList.size());
		
		WebElement nextBtn=driver.findElement(By.id("next2"));
		
		if(nextBtn.isDisplayed()) {
			for(int i=0;i<deviceList.size();i++) {
				System.out.println("Device name: "+deviceList.get(i).getText());
			}
			nextBtn.click();
		}else {
			/**
			 * stateElementException: when you performed any operation due to which your page or HTML 
			 * got refreshed, after that if you are performing operation on the element which was identified before page/html DOM refresh
			 */
			//deviceList=driver.findElements(By.cssSelector("#tbodyid>div>div>div>h4>a"));
			for(int i=0;i<deviceList.size();i++) {
				System.out.println("Device name: "+deviceList.get(i).getText());
			}
		}		
	}
}
/*
write a script to get 
	- total number devices
	- all each page device name from the application

*/