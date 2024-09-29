package step_def;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.SeleniumUtility;

public class ActitimeLoginTest extends SeleniumUtility {
	
	@Given("User is on actitime login page")
	public void user_is_on_actitime_login_page() {
		setUp("chrome", "https://online.actitime.com/qk/login.do");
	}

	@When("User enters username as {string}")
	public void user_enters_username_as(String username) {
		typeInput(driver.findElement(By.id("username")), username);
	}

	@And("User enters password as {string}")
	public void user_enters_password_as(String password) {
		typeInput(driver.findElement(By.name("pwd")), password);
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
		clickOnElement(driver.findElement(By.id("loginButton")));
	}

	@Then("User should navigate to Actitime Home page with title {string}")
	public void user_should_navigate_to_actitime_home_page_with_title(String title) {
		String actualTitle=getCurrentTitleOfApplication(title);
		Assert.assertEquals(actualTitle, title);
	}

	@And("User close the browser")
	public void user_close_the_browser() {
		driver.quit();
	}
}
