package stepdefinition.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import stepdefinition.page.CustomerPage;
import stepdefinition.page.DashboardPage;
import stepdefinition.page.LoginPage;
import stepdefinition.page.TasksPage;

public class CustomerTest  {
	WebDriver driver = null;
	LoginPage loginPage = null;
	DashboardPage dashPage = null;
	TasksPage taskPage = null;
	CustomerPage custPage = null;
	
	@Given("pomuser has browser object")
	public void pomuser_has_browser_object() {
	
		driver = new BaseTest().getDriver();
	    loginPage = new LoginPage(driver);
	    dashPage = new DashboardPage(driver);
	    taskPage = new TasksPage(driver);
	    custPage = new CustomerPage(driver);
	}

	@Given("actitime application is launched")
	public void actitime_application_is_launched() {
	    driver.get("http://localhost/login.do");
	}

	@Then("pomuser login to the application")
	public void pomuser_login_to_the_application() {
	   loginPage.login("admin", "manager");
	}

	@Given("pomuser is on dashboard page")
	public void pomuser_is_on_dashboard_page() {
	    dashPage.verifyTitle("actiTIME - Enter Time-Track");
	}

	@When("pomuser click on tasks tab")
	public void pomuser_click_on_tasks_tab() {
		dashPage.clickOnTasks();
	    
	}

	@When("pomuser click on createNew customer button on taskspage")
	public void pomuser_click_on_create_new_customer_button_on_taskspage() {
		taskPage.clickOnAddNew();
		taskPage.clickOnNewCustomerCreation();
	
	}

	@Then("Enter {string} 	and {string} respectively")
	public void enter_and_respectively(String customername, String customerdesc) {
		custPage.enterCustomerName(customername);
		custPage.enterCustomerDesc(customerdesc);
	}

	@When("pomuser click on create new customer button")
	public void pomuser_click_on_create_new_customer_button() {
		custPage.clickOnCCButton();
	}

	@Then("customer will be created successfully and success message is validated")
	public void customer_will_be_created_successfully_and_success_message_is_validated() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement successMsg = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println(successMsg.getText());
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
	
	}

	@Then("pomuser logout of actitime")
	public void pomuser_logout_of_actitime() {
		dashPage.logout();
	
	}


}
