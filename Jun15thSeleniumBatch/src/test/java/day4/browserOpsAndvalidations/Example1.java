package day4.browserOpsAndvalidations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example1 {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//maximize browser window
		driver.manage().window().maximize();
		//to minimize browser window
		driver.manage().window().minimize();
		//setting browser window size
		driver.manage().window().setSize(new Dimension(600,800));
		//maximize browser window
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//0-30 sec, to load the element
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//click on forgot password click
		driver.findElement(By.className("orangehrm-login-forgot")).click();
		//to come back to login page use
		driver.navigate().back();
		//if again you want to goto forgot password page dn use
		driver.navigate().forward();
		//to reload the page use
		driver.navigate().refresh();
		//if you want to move to different application or url dn use
		driver.navigate().to("https://www.google.com");
		

	}

}
