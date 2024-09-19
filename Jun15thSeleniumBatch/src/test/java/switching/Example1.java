package switching;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import utilities.SeleniumUtil;

public class Example1 extends SeleniumUtil{

	public static void main(String[] args) {
		Example1 ref=new Example1();
		ref.testWindowHandling();

	}
	
	public void testWindowHandling() {
		setUp("chrome", "https://etrain.info/in");
		//store HOME page id
		String homeWinId=driver.getWindowHandle();
		//perform operation on twitter, that will open new tab/window
		clickOnRequiredElement(driver.findElement(By.cssSelector(".icon-twitter")));
		//get all window ids
		Set<String> allWinIds=driver.getWindowHandles();
		/*get child window id*/
		allWinIds.remove(homeWinId);
//		Iterator<String> itr=allWinIds.iterator();
//		String childWinID=itr.next();
		
		String childWinID=allWinIds.iterator().next();
		//lets move to child window
		driver.switchTo().window(childWinID);
		
		String expectedTitle="Log in to X / X";
		String actualTitle=getCurrentPageTitle(expectedTitle);
		System.out.println("Is twitter page opened? "+actualTitle.equals(expectedTitle));
		//this will close child window/tab but control won't be shifted to home page automatically
		//driver.close();
		//now move to parent window
		driver.switchTo().window(homeWinId);
		System.out.println("Home page title: "+getCurrentPageTitle());
		
		//to close all instance at once
		driver.quit();
	}

}
