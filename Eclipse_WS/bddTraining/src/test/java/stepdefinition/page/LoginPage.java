package stepdefinition.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	//Step -1
	@FindBy(id = "username")
	WebElement usernameTxtBox;

	@FindBy(name = "pwd")
	WebElement passwordTxtBox;

	@FindBy(id = "loginButton")
	WebElement loginButton;

	
	//Step-2
	public void enterUserName(String un) {
		usernameTxtBox.sendKeys(un);
	}

	public void enterPassword(String p) {
		passwordTxtBox.sendKeys(p);
	}

	public void clickOnLoginButton() {
		loginButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void login(String un, String pwd)
	{
		enterUserName(un);
		enterPassword(pwd);
		clickOnLoginButton();
	}
	
	//Step-3
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
}
