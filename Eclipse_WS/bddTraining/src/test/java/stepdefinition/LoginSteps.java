package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

	WebDriver driver = null;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user_is_on_login_page");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
		
		
	}

	@When("click on login")
	public void click_on_login() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("click_on_login");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);
	}

	@Then("user should be able to see dashbord page")
	public void user_should_be_able_to_see_dashbord_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user_should_be_able_to_see_dashbord_page");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("logoutLink")).click();
		driver.close();
	}

	@When("user enter (in)valid {string} and/or {string}")
	public void user_enter_invalid_username_or_password(String un, String pwd) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user_enter_invalid_username_or_password");
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		
		
	}

	@Then("user should stay on same page")
	public void user_should_stay_on_same_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user_should_stay_on_same_page");
		System.out.println(driver.getTitle());
		driver.close();
	}
	
	
	//------------------------step definitions for using example -----------------------------
	
	@Given("superuser is on login page")
	public void superuser_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user_is_on_login_page");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
	}

	@When("superuser enter {} and {}")
	public void superuser_enter_admin_and_manager(String un, String pwd) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
	}

	@When("click on loginbutton")
	public void click_on_loginbutton() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("click_on_login");
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);
	}

	@Then("user should be able to see dashbord page or stay on loginpage")
	public void user_should_be_able_to_see_dashbord_page_or_stay_on_loginpage() {
	    // Write code here that turns the phrase above into concrete actions
		String str = driver.getTitle();
		if(str.equals("actiTIME - Login")) {
			driver.close();
			System.out.println("Invalid login");
		}
		else
		{
			System.out.println("Valid login " + driver.getTitle());
			driver.findElement(By.id("logoutLink")).click();
			driver.close();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
