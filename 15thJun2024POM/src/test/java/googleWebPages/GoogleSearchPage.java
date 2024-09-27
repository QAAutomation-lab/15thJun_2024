package googleWebPages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SeleniumUtility;

public class GoogleSearchPage extends SeleniumUtility{
	public GoogleSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="q")
	private WebElement searchInputField;
	
	@FindBy(css="ul.G43f7e>li>div>*:nth-child(2)>div>*:first-child>span")
	private List<WebElement> suggestionList;

	public WebElement getSearchInputField() {
		return searchInputField;
	}

	public List<WebElement> getSuggestionList() {
		return suggestionList;
	}
	
	public int getSuggestionCount() {
		return suggestionList.size();
	}
	
	public void typeRequiredText(String text) {
		typeInput(searchInputField, text);
	}
	
	public void pressEnterButton() {
		getActitveElement().sendKeys(Keys.ENTER);
	}
}
