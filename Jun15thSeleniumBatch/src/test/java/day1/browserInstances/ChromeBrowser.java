package day1.browserInstances;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

	public static void main(String[] args) {
		//to open chrome browser, create an instance of ChromeDriver class
		ChromeDriver cdriver=new ChromeDriver();
	}
}
/*
a browser opened by selenium:
	* Selenium always opens a new browser, it won;t work on already opened browser
	* brower opened by selenium won't be having-
	 		- browser history - search or download
	 		- Cookies
	 		-plugins & add-ons
*/