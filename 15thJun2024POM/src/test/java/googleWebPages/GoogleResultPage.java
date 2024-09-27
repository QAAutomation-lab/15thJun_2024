package googleWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class GoogleResultPage extends SeleniumUtility{
	public GoogleResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getSearchedResultPageTitle() {
		return getCurrentTitleOfApplication();
	}
}
