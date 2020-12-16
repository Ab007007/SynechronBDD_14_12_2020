package stepdefinition;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateandDeleteProject {
	WebDriver driver = null;
	WebDriverWait wait;
	WebElement successMsg;
	Actions ac;

	@Given("User initiates the browser and launches the {string} url")
	public void user_initiates_the_browser_and_launches_the_url(String string) {
		// Write code here that turns the phrase above into concrete actions
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(string);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@When("User enters {string} and {string} as valid credentials")
	public void user_enters_and_as_valid_credentials(String string, String string2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);

	}

	@Then("User is successfully logged in to the application")
	public void user_is_successfully_logged_in_to_the_application() {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");

	}

	@Given("User is on landing page")
	public void user_is_on_landing_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Given("User clicks on Tasks option")
	public void user_clicks_on_tasks_option() {
		// Write code here that turns the phrase above into concrete actions
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='content tasks']")))).click();

	}

	@When("User clicks on Addnew and AddnewProject buttons")
	public void user_clicks_on_addnew_and_addnew_project_buttons() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'New Project')]")).click();
		Thread.sleep(2000);

	}

	@When("User is on the CreateNewProjectPage")
	public void user_is_on_the_create_new_project_page() {
		// Write code here that turns the phrase above into concrete actions
		wait = new WebDriverWait(driver, 20);
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/*[@id='projectPopup_titlePlaceholder']"))));
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id='projectPopup_titlePlaceholder']")).getText(),
				"Create New Project");

	}

	@When("User enters {string} and {string} and {string}")
	public void user_enters_and_and(String string, String string2, String string3) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("projectPopup_projectNameField")).sendKeys(string);
		driver.findElement(By.id("projectPopup_customerSelectorPlaceholder")).click();
		// driver.findElement(By.xpath("//*[@id='ext-gen109']/li/a[contains(text(),'"+string2+"')]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='x-menu-list-item']/a"));
		for (WebElement li : list) {
			// System.out.println(li.getText());
			if (li.getText().equalsIgnoreCase(string2)) {
				li.click();
				break;
			} 
		}
		driver.findElement(By.id("projectPopup_projectDescriptionField")).sendKeys(string3);

	}

	@When("User clicks on CreateProjectButton")
	public void user_clicks_on_create_project_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("projectPopup_commitBtn")).click();
	}

	@Then("User has successfully created a project")
	public void user_has_successfully_created_a_project() {
		// Write code here that turns the phrase above into concrete actions
		wait = new WebDriverWait(driver, 20);
		successMsg = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println(successMsg);
		wait.until(ExpectedConditions.invisibilityOf(successMsg));

	}

	@When("User searches  {string} in the search box")
	public void user_searches_in_the_search_box(String string) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("(//input[@placeholder='Start typing name ...'])[1]")).sendKeys(string);

	}

	@When("User moves to the gearbox in the {string} result and clicks on the gear box")
	public void user_moves_to_the_gearbox_in_the_search_result_and_clicks_on_the_gear_box(String string) {
		// Write code here that turns the phrase above into concrete actions
		WebDriverWait wait= new WebDriverWait(driver, 20);
		ac = new Actions(driver);
		WebElement searresult = driver.findElement(By.xpath("//div[@class='itemsContainer']//div[@class='title' and contains(text(),'"+string+" ')]"));
		WebElement gearbox = driver.findElement(By.xpath("//div[@class='itemsContainer']//div[@class='title' and contains(text(),'"+ string +"')]/following-sibling::div"));
		ac.moveToElement(searresult).click(gearbox).build().perform();

	}

	@When("User clicks on the Actions button followed by delete button")
	public void user_clicks_on_the_actions_button_followed_by_delete_button() throws InterruptedException {
		wait = new WebDriverWait(driver, 20);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='actionButton'])[3]/div[@class='action']")))).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@class='deleteButton'])[4]")))).click();

	}

	@When("User clicks on delete button")
	public void clicks_on_delete_permanently_button() {
		// Write code here that turns the phrase above into concrete actions

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='buttonIcon']/span[@id='projectPanel_deleteConfirm_submitTitle']")))).click();
	}

	@Then("User has successfully deleted the project")
	public void user_has_successfully_deleted_the_project() {
		// Write code here that turns the phrase above into concrete actions
		wait = new WebDriverWait(driver, 20);

		WebElement deletionMsg = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println(deletionMsg.getText());
		wait.until(ExpectedConditions.invisibilityOf(deletionMsg));

	}
	
	@Then("User logsOut of the application")
	public void logout(){
		driver.findElement(By.id("logoutLink")).click();
		driver.quit();
	}
	
	
}
