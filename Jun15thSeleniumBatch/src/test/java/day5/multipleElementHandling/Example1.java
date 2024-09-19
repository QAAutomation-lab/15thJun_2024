package day5.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.demoblaze.com/");
		
		//need to identify all device available  in the screen using findElements(By)
		List<WebElement> deviceList=driver.findElements(By.cssSelector("#tbodyid>div>div>div>h4>a"));
		
		System.out.println("Total number of devices: "+deviceList.size());
		
		//to get one by one device name use get(index) in for loop
		for(int i=0;i<deviceList.size();i++) {
//			WebElement element=deviceList.get(i);
//			String deviceName=element.getText();
//			System.out.println("Device name: "+deviceName);
					//or
			System.out.println("Device name: "+deviceList.get(i).getText());
		}
	}
}
/*
write a script to get 
	- total number devices
	- all device name from the application

*/