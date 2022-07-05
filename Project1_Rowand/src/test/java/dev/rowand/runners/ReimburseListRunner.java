/* package dev.rowand.runners;
import java.io.File;


import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;

import dev.rowand.pages.LoginPage;
import dev.rowand.pages.ReimburseListPage;

@Suite
public class ReimburseListRunner {
	public static WebDriver driver;
	public static ReimburseListPage reimburseListPage;
	
	@BeforeAll
	public static void setup() {
		File chrome = new File("src/test/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
		
		reimburseListPage = new ReimburseListPage(driver);
		
	}
	@AfterAll
	public static void teardown() {
		driver.quit();
	}
} */
