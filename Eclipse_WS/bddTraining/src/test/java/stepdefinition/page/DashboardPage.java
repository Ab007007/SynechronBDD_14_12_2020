package stepdefinition.page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	WebDriver driver ;
	@FindBy(xpath = "//div[text()='TASKS']/parent::a")
	WebElement tasksTab;
	
	
	@FindBy(id = "logoutLink")
	WebElement logoutLink;
	

	public void verifyTitle(String expectedTitle)
	{
		Assert.assertEquals(expectedTitle, driver.getTitle());
	}
	public void clickOnTasks() {
		
		tasksTab.click();
	}
	
	public void logout() {
		logoutLink.click();
	}
	
	public DashboardPage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
