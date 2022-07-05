/*package dev.rowand.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.rowand.pages.GradeOrPresPage;
import dev.rowand.pages.LoginPage;
import dev.rowand.runners.GradeOrPresRunner;
import dev.rowand.runners.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddGradeOrPResFeatureStepImpl {
	private WebDriver driver = GradeOrPresRunner.driver;
	private GradeOrPresPage gradeOrPresPage = GradeOrPresRunner.gradeOrPresPage;
	
	@Given("a Employee is on the GradeOrPres Page")
	public void a_employee_is_on_the_gradeorpres_page(){
		driver.get("http://localhost:8080/GradeOrPres.html");
		
	}

	@When("the Employee types in the {int} and the {string} fields and clicks the button")
	public void the_employee_types_in_the_userid_and_gradeorpresentation_fields_and_clicks_the_button(String username, String password){
		gradeOrPresPage.usernameInput.sendKeys(username);
		gradeOrPresPage.usernameInput.sendKeys(password);
		gradeOrPresPage.loginButton.click();;

	}

	@Then("the Grading Format or Presentation is added to the Form")
	public void the_grading_format_or_presentation_is_added_to_the_form(){
		
		//we need to incorporate a WAIT here...
		new WebDriverWait(driver, Duration.ofSeconds(5))
		.until(ExpectedConditions.titleContains("Home Page"));
		
	}
} */
