/*package dev.rowand.runners;
import java.io.File;


import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;

import dev.rowand.pages.GradeOrPresPage;
import dev.rowand.pages.ReimburseListPage;

@Suite
public class GradeOrPresRunner {
	public static WebDriver driver;
	public static GradeOrPresPage gradeOrPresPage;
	
	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		
		gradeOrPresPage = new GradeOrPresPage(driver);
		
	}
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
} */
