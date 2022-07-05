/*package dev.rowand.runners;
import java.io.File;


import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;

import dev.rowand.pages.ReimburseListPage;
import dev.rowand.pages.UpdateStatusPage;

@Suite
public class UpdateStatusRunner {
	public static WebDriver driver;
	public static UpdateStatusPage updateStatusPage;
	
	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		
		updateStatusPage = new UpdateStatusPage(driver);
		
	}
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
} */
