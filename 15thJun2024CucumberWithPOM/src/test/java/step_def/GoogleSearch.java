package step_def;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;

public class GoogleSearch extends SeleniumUtility{
	
	@Given("user is on Google search page")
	public void user_is_on_Google_search_page() {
		setUp("chrome", "https://www.google.com");
	}
	
	@When("^user enters (.+) and press enter button$")
	public void user_enters_and_press_enter_button(String text){
		typeInput(driver.findElement(By.name("q")), text);
		getActitveElement().sendKeys(Keys.ENTER);
	}
	
	@Then("^Validate search page is having title as (.+)$")
	public void validate_search_page_is_having_title_as(String title) {
		String actualTitle=getCurrentTitleOfApplication(title);
		Assert.assertEquals(actualTitle, title);
	}
}
