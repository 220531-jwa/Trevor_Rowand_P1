/*package dev.rowand.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.rowand.pages.*;
import dev.rowand.runners.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeatureStepImpl {
private WebDriver driver = LoginRunner.driver;
private LoginPage loginPage = LoginRunner.LoginPage;

@Given("a User is on the LoginPage")
public void a_user_is_on_the_login_page(){
	driver.get("http://localhost:8080/LoginP1.html");
	
}

@When("the User types im their {string} and {string} and clicks the LoginButton")
public void the_user_types_in_their_username_and_password_and_clicks_the_login_button(String username, String password){
loginPage.usernameInput.sendKeys(username);
loginPage.usernameInput.sendKeys(password);
loginPage.loginButton.click();;

}

@Then("the User should be on the HomePage")
public void the_user_should_be_on_the_home_page(){
	
	//we need to incorporate a WAIT here...
	new WebDriverWait(driver, Duration.ofSeconds(30))
	.until(ExpectedConditions.titleContains("Home Page"));
	
}
} */
