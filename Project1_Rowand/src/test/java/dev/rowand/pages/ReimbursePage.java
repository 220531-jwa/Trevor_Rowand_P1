package dev.rowand.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReimbursePage {
	private WebDriver driver;
	
	public ReimbursePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "userReq")
	public WebElement UserId;
	
	@FindBy(id = "gradeOrPres")
	public WebElement gOrPInput;
	
	@FindBy(xpath = "/html/body/div/button")
	public WebElement GorDButton;
	
	
}
