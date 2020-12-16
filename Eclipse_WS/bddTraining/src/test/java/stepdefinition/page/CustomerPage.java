package stepdefinition.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {

	@FindBy(id = "customerLightBox_nameField")
	WebElement customerNameTxtBox;

	@FindBy(id = "customerLightBox_descriptionField")
	WebElement customerDescTxtBox;
	
	@FindBy(id = "customerLightBox_commitBtn")
	WebElement createCustomerButton;
	
	
	public void enterCustomerName(String cn) {
		customerNameTxtBox.sendKeys(cn);
	}
	public void enterCustomerDesc(String cd) {
		customerDescTxtBox.sendKeys(cd);
	}
	public void clickOnCCButton() {
		createCustomerButton.click();
	}

	
	public CustomerPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
}
