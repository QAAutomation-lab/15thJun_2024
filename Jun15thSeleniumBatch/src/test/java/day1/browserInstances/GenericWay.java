package day1.browserInstances;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericWay {

	public static void main(String[] args) {
		// to open chrome browser, create an instance of ChromeDriver class
		WebDriver driver1 = new ChromeDriver();
		// to open firefox browser, create an instance of FirefoxDriver class
		WebDriver driver2 = new FirefoxDriver();
		// to open edge browser, create an instance of EdgeDriver class
		WebDriver driver3 = new EdgeDriver();
	}
}
/*
 * a browser opened by selenium: Selenium always opens a new browser, it won;t
 * work on already opened browser brower opened by selenium won't be having- -
 * browser history - search or download - Cookies -plugins & add-ons
 */