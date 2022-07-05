/*package dev.rowand.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.rowand.pages.LoginPage;
import dev.rowand.pages.ReimbursePage;
import dev.rowand.runners.LoginRunner;
import dev.rowand.runners.ReimburseRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReimburseFeatureStepImpl {
	private WebDriver driver = ReimburseRunner.driver;
	private ReimbursePage reimbursePage = ReimburseRunner.reimbursePage;
	
	@Given("a Employee is on the Reimbursement Page")
	public void a_user_is_on_the_login_page(){
		driver.get("http://localhost:8080/NewForm.html");
		
	}

	@When("the Employee types in or selects a \"<UserId>\", \"<date>\", \"<time>\", \"<location>\", \"<description>\", \"<cost>\", \"<type>\", and \"<justification>\" and clicks the submit button")
	public void the_user_types_in_their_username_and_password_and_clicks_the_login_button(String username, String password){
		reimbursePage.usernameInput.sendKeys(username);
		reimbursePage.usernameInput.sendKeys(password);
		reimbursePage.loginButton.click();;

	}

	@Then("the User should be on the HomePage")
	public void the_user_should_be_on_the_home_page(){
		
		//we need to incorporate a WAIT here...
		new WebDriverWait(driver, Duration.ofSeconds(5))
		.until(ExpectedConditions.titleContains("Home Page"));
		
	}
} */
