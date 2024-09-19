package day1.browserInstances;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser {

	public static void main(String[] args) {
		//to open firefox browser, create an instance of FirefoxDriver class
		FirefoxDriver fdriver=new FirefoxDriver();
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