package stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCustomer {

	WebDriver driver = null;
	@Given("User is loggedin to the actitime application using {string} and {string}")
	public void user_is_loggedin_to_the_actitime_application_using_and(String un, String pwd) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);
		
	}

	@When("User click on tasks tab")
	public void user_click_on_tasks_tab() {
		driver.findElement(By.xpath("//div[text()='TASKS']/parent::a")).click();
	}

	@Then("User is navigated to tasks page")
	public void user_is_navigated_to_tasks_page() {
	   Assert.assertEquals(driver.getTitle(), "actiTIME - Task List");
	   
	}

	@When("User click on Add new customer button")
	public void user_click_on_add_new_customer_button() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();
		Thread.sleep(2000);
	}

	@Then("Create customer page is displayed")
	public void create_customer_page_is_displayed() {
		Assert.assertEquals(driver.findElement(By.id("customerLightBox_titlePlaceholder")).getText(), "Create New Customer");
	
	}

	@When("User enters {string} and  {string} and click on create cutomer button")
	public void user_enters_and_and_click_on_create_cutomer_button(String cn, String cd) {
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
		driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
		driver.findElement(By.id("customerLightBox_commitBtn")).click();
	
	}

	@Then("success message should be displayed and disappeared")
	public void success_message_should_be_displayed_and_disappeared() {
	   
	}

	@Then("user validates the message")
	public void user_validates_the_message() {
	   
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement successMsg = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println(successMsg.getText());
		wait.until(ExpectedConditions.invisibilityOf(successMsg));
	
	}

	@Then("logout from the application")
	public void logout_from_the_application() {
		driver.findElement(By.id("logoutLink")).click();
		driver.close();
	}
	
	
	@When("User enters customername and customerdescription repeatedly to create mulitple customer")
	public void user_enters_customername_and_customerdescription_repeatedly_to_create_mulitple_customer(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> data = dataTable.asMaps();
		String cn, cd ;
		for( int i = 0; i < data.size() ; i++) {
			
			cn = data.get(i).get("customername");
			cd = data.get(i).get("customerdesc");
			driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
			driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("customerLightBox_nameField"))));
			driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
			driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
			driver.findElement(By.id("customerLightBox_commitBtn")).click();
			
			WebElement successMsg = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
			System.out.println(successMsg.getText());
			wait.until(ExpectedConditions.invisibilityOf(successMsg));
			
		}
		
	}

	@When("User enters customername and customerdescription repeatedly as list to create mulitple customer")
	public void user_enters_customername_and_customerdescription_repeatedly_as_list_to_create_mulitple_customer(DataTable dataTable) throws InterruptedException {
		List<List<String>> data = dataTable.asLists();
		String cn, cd ;
		for( int i = 0; i < data.size() ; i++) {
			
			cn = data.get(i).get(0);
			cd = data.get(i).get(1);
			driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
			driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("customerLightBox_nameField"))));
			driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
			driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
			driver.findElement(By.id("customerLightBox_commitBtn")).click();
			
			WebElement successMsg = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
			System.out.println(successMsg.getText());
			wait.until(ExpectedConditions.invisibilityOf(successMsg));
			
		}
		
	}

	@When("User enters customername and customerdescription as mapdata")
	public void user_enters_customername_and_customerdescription_as_mapdata(DataTable dataTable) throws InterruptedException {
		 Map<String, String> data = dataTable.asMap(String.class, String.class);
			
		 	System.out.println(data);
		 	String customer_name_with_delimeter = data.get("customername");
		 	String customer_desc_with_delimeter = data.get("customerdesc");
		 	
		 System.out.println(customer_name_with_delimeter);
		 System.out.println(customer_desc_with_delimeter);
		 	
//			driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
//			driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();
//			WebDriverWait wait = new WebDriverWait(driver, 20);
//			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("customerLightBox_nameField"))));
//			driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
//			driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
//			driver.findElement(By.id("customerLightBox_commitBtn")).click();
//			
//			WebElement successMsg = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
//			System.out.println(successMsg.getText());
//			wait.until(ExpectedConditions.invisibilityOf(successMsg));
			
	}

	
	@When("User enters customername and customerdescription as listdata")
	public void user_enters_customername_and_customerdescription_as_listdata(DataTable dataTable) throws InterruptedException {
			List<String> data = dataTable.asList();
			
			String cn = data.get(0);
			String cd = data.get(1);
			driver.findElement(By.xpath("//div[@class='addNewContainer']")).click();
			driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("customerLightBox_nameField"))));
			driver.findElement(By.id("customerLightBox_nameField")).sendKeys(cn);
			driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cd);
			driver.findElement(By.id("customerLightBox_commitBtn")).click();
			
			WebElement successMsg = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
			System.out.println(successMsg.getText());
			wait.until(ExpectedConditions.invisibilityOf(successMsg));
			
	}

}
