package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {
	public static WebDriver driver;
	public static Actions action;
	public static WebDriverWait wait;
	public FileInputStream fis;
	public Properties prop;
	public String filePath;
	
	public Properties getPropertyFileInstance(String filePath) {
		prop=new Properties();
		try {
			fis=new FileInputStream(filePath);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public String getDataFromPropertyFile(String key) {
		return prop.getProperty(key);
	}
	
	public WebDriver setUp(String browserName, String appUrl) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(appUrl);
		action = new Actions(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		return driver;
	}
	
	public void typeRequiredInput(WebElement element, String input) {
		waitForElementToBeClickable(element);
		element.clear();
		element.sendKeys(input);
	}
	
	public void clickOnRequiredElement(WebElement element) {
		waitForElementToBeClickable(element);
		element.click();
	}
	
	public boolean isElementPresent(WebElement element) {
		waitForElementToBeVisible(element);
		return element.isDisplayed();
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public String getCurrentPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public Select getDropdownInstance(WebElement element) {
		return new Select(element);
	}
	
	public List<WebElement> getDropdownOptions(WebElement element){
		Select select=getDropdownInstance(element);
		return select.getOptions();
	}
	
	public String getAttributeNameForElement(WebElement element, String attributeName) {
		waitForElementToBeVisible(element);
		String value=element.getAttribute(attributeName);
		return value;
	}
	
	/**
	 * TODO:
	 * 		method for css attribute
	 * 		method for co-ordinates
	 * 		method for mouse and keyboard operations
	 */
	public WebElement getActiveElementFromUI() {
		return driver.switchTo().activeElement();
	}
}
