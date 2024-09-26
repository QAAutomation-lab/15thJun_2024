package ornageHRMWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".oxd-userdropdown-name")
	private WebElement userProfileIcon;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutLink;
	
	@FindBy(xpath="//a[text()='PIM']")
	private WebElement pimOptionLink;
	
	public WebElement getUserProfileIcon() {
		return userProfileIcon;
	}

	public WebElement getLoginLink() {
		return logoutLink;
	}

	public WebElement getPimOptionLink() {
		return pimOptionLink;
	}

	public void logoutFromApplication() {
		clickOnElement(userProfileIcon);
		clickOnElement(logoutLink);
	}
}
