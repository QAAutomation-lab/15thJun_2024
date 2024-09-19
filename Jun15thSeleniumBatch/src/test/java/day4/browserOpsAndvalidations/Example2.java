package day4.browserOpsAndvalidations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example2 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//maximize browser window
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//0-30 sec, to load the element
		driver.get("https://online.actitime.com/uts/login.do");
		
		WebElement userNameInputField=driver.findElement(By.id("username"));
		System.out.println("is username input field visible on the screen? "+userNameInputField.isDisplayed());
		System.out.println("is username input field editable or not? "+userNameInputField.isEnabled());
		System.out.println("default name displayed on username input field is-> "+userNameInputField.getAttribute("placeholder"));
		
		
		WebElement checkBox=driver.findElement(By.id("keepLoggedInCheckBox"));
		System.out.println("is checkBox visible on the screen? "+checkBox.isDisplayed());
		System.out.println("is checkBox clickable or not? "+checkBox.isEnabled());
		System.out.println("Is checkbox by default selected? "+checkBox.isSelected());
		checkBox.click();
		System.out.println("after checkbox selected, checkbox status is--> "+checkBox.isSelected());
		
		WebElement loginButton=driver.findElement(By.id("loginButton"));
		System.out.println("is loginButton visible on the screen? "+loginButton.isDisplayed());
		System.out.println("is loginButton clickable or not? "+loginButton.isEnabled());
		System.out.println("Login button name on the screen: "+loginButton.getText());
	}

}
/*
validation on actitime
	username:
		visibility - isDisplay()
		editable - isEnabled()
		default text - getAttribute("placeholder")
	
	keep me logged in checkbox:
		visibility - isDisplay()
		clickable - isEnabled()
		default selection - isSelected()
		select and again check - isSelected()
	
	login button:
		visibility- isDisplay()
		clickable- isEnabled()
		button name- getText()
*/