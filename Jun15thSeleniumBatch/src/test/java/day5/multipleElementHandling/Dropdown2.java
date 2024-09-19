package day5.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://omayo.blogspot.com/");
		
		//step1: identify dropdown 
		WebElement dropdown=driver.findElement(By.id("multiselect1"));
		//step2: create an instance of Select and pass above dropdown instance to its constructor
		Select slt=new Select(dropdown);
		//step3: allow to perform any operation on dropdown using Select class instance
		System.out.println("is dropdown allow multiple selection? "+slt.isMultiple());
		
		List<WebElement> options=slt.getOptions();
		System.out.println("Total number of options: "+options.size());
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
		System.out.println("*************Selecting value from dropdown******************");
		slt.selectByIndex(1);
		slt.selectByValue("volvox");
		slt.selectByVisibleText("Audi");
		List<WebElement> selectedOptions=slt.getAllSelectedOptions();
		System.out.println("Total option selected: "+selectedOptions.size());
		for(WebElement element: selectedOptions) {
			System.out.println(element.getText());
		}
		System.out.println("****************Unselect already selected option**************************");
//		slt.deselectByIndex(1);
//		slt.deselectByValue("volvox");
//		slt.deselectByVisibleText("Audi");
		slt.deselectAll();
	}
}
/*
write a script to get 
	- total number devices
	- all each page device name from the application

*/