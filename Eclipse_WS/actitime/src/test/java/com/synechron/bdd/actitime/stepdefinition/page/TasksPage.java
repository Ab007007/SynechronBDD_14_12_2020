package com.synechron.bdd.actitime.stepdefinition.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage {

	
	
	@FindBy(xpath = "//div[@class='addNewContainer']")
	WebElement addNewButton;
	
	@FindBy(xpath = "//div[contains(text(),'New Customer')]")
	WebElement newCustomerButton;
	
	public void clickOnAddNew() {
		addNewButton.click();
	}
	
	public void clickOnNewCustomerCreation() {
		newCustomerButton.click();
	}
	
	public TasksPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	
		PageFactory.initElements(driver, this);
	}
	

}
