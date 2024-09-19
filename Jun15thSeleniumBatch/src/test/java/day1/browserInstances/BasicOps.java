package day1.browserInstances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicOps {

	public static void main(String[] args) {
		//create an instance of required browser class and up cast it to WebDriver interface - runtime poly
		WebDriver driver=new ChromeDriver();
		
		//enter application URL
		driver.get("https://www.google.com");
		
		//get the current page title
		String pageTitle=driver.getTitle();
		System.out.println("Current page title is "+pageTitle);
		System.out.println("No of char in current page title is "+pageTitle.length());
		String expectedTitle="Google";
		System.out.println("Google search page validation status? "+pageTitle.equals(expectedTitle));
		
		//get the current page URL
		String pageURL=driver.getCurrentUrl();
		System.out.println("Current page URL is "+pageURL);
		System.out.println("No of char in current page URL is "+pageURL.length());
		
		//current page source code
		String pageSource=driver.getPageSource();
		System.out.println("Page source char count is: "+pageSource.length());
		
		//close current browser instance
		driver.close();
	}

}
/*
Open chrome browser
enter google search url
get page title
	- print its length
	- print title
get current url from application
	- print its length
	- print url
get page source code
	- print source code length
close the browser
*/