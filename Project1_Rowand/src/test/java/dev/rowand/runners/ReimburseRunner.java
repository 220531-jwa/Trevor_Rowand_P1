/*package dev.rowand.runners;
import java.io.File;


import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;

import dev.rowand.pages.ReimburseListPage;
import dev.rowand.pages.ReimbursePage;

@Suite
public class ReimburseRunner {
	public static WebDriver driver;
	public static ReimbursePage reimbursePage;
	
	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		
		reimbursePage = new ReimbursePage(driver);
		
	}
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
} */
