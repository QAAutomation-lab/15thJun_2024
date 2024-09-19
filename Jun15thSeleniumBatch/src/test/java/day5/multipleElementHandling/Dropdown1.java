package day5.multipleElementHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demo.automationtesting.in/Register.html");
		
		//step1: identify dropdown 
		WebElement dropdown=driver.findElement(By.id("Skills"));
		//step2: create an instance of Select and pass above dropdown instance to its constructor
		Select slt=new Select(dropdown);
		//step3: allow to perform any operation on dropdown using Select class instance
		System.out.println("is dropdown allow multiple selection? "+slt.isMultiple());
		
		System.out.println("Default/already selected option name: "+slt.getFirstSelectedOption().getText());
		
		List<WebElement> options=slt.getOptions();
		System.out.println("Total number of options: "+options.size());
		
		for(int i=0;i<options.size();i++) {
			System.out.println(options.get(i).getText());
		}
		System.out.println("*************Selecting value from dropdown******************");
		slt.selectByIndex(2);
		System.out.println("Dropdown option selection based on index: "+slt.getFirstSelectedOption().getText());
		
		slt.selectByValue("Art Design");
		System.out.println("Dropdown option selection based on value: "+slt.getFirstSelectedOption().getText());
	
		slt.selectByVisibleText("Backup Management");
		System.out.println("Dropdown option selection based on VisibleText: "+slt.getFirstSelectedOption().getText());
	
	}
}
/*
write a script to get 
	- total number devices
	- all each page device name from the application

*/