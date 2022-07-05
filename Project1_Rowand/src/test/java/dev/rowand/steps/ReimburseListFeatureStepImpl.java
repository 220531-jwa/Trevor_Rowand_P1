/*package dev.rowand.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.rowand.pages.LoginPage;
import dev.rowand.pages.ReimburseListPage;
import dev.rowand.runners.LoginRunner;
import dev.rowand.runners.ReimburseListRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReimburseListFeatureStepImpl {
	private WebDriver driver = ReimburseListRunner.driver;
	private ReimburseListPage reimburseListPage = ReimburseListRunner.reimburseListPage;
	
	@Given("a User is on the LoginPage")
	public void a_user_is_on_the_login_page(){
		driver.get("http://localhost:8080/FormListFinance.html");
		
	}

	@When("the User types im their {string} and {string} and clicks the LoginButton")
	public void the_user_types_in_their_username_and_password_and_clicks_the_login_button(String username, String password){
		reimburseListPage.usernameInput.sendKeys(username);
		reimburseListPage.usernameInput.sendKeys(password);
		reimburseListPage.loginButton.click();;

	}

	@Then("the User should be on the HomePage")
	public void the_user_should_be_on_the_home_page(){
		
		//we need to incorporate a WAIT here...
		new WebDriverWait(driver, Duration.ofSeconds(5))
		.until(ExpectedConditions.titleContains("Home Page"));
		
	}
} */
