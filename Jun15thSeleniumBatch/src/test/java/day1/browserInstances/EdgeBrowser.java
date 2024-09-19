package day1.browserInstances;

import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser {

	public static void main(String[] args) {
		//to open edge browser, create an instance of EdgeDriver class
		EdgeDriver edriver=new EdgeDriver();
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