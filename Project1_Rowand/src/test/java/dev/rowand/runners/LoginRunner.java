package dev.rowand.runners;

import java.io.File;


import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;

import dev.rowand.pages.LoginPage;



//@RunWith(Cucumber.class)
//@CucumberOptions(features = "src/test/resources", glue = "dev.rowand.steps")
@Suite
public class LoginRunner {

	
	public static WebDriver driver;
	public static LoginPage LoginPage;
	
	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		
		LoginPage = new LoginPage(driver);
		
	}
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
}
