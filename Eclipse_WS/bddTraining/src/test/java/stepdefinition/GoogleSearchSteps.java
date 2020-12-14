package stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSteps {

	WebDriver driver = null;
	@Given("user is on google page")
	public void user_is_on_google_page() {
	   WebDriverManager.chromedriver().setup();
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.manage().window().maximize();
	   driver.get("https://www.google.com/");
	}

	/*
	 *BELOW CODE IS COMMENTED AS IT IS HANDLED IN - @When("user enters {string} in search box")
	 * 
	 * @When("user enters Synechron in search box") public void
	 * user_enters_synechron_in_search_box() {
	 * driver.findElement(By.name("q")).sendKeys("Synechron"); }
	 */
	
	
	@When("user enters {string} in search box")
	public void user_enters_in_search_box(String companyName) {
		driver.findElement(By.name("q")).sendKeys(companyName);
	}


	@When("click on search button")
	public void click_on_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("btnK")).click();
		System.out.println(" Click on Search Button");
	}

	@Then("Google will display search result(s)")
	public void google_will_display_search_results() {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> serachResults = driver.findElements(By.xpath("//h3//span"));
		System.out.println("Total search Results : " + serachResults.size());
		
		for (WebElement result : serachResults) {
			System.out.println(result.getText());
		}
		driver.close();
		System.out.println("Displays Results");
	}
	
	@When("user enters {int} in search box")
	public void user_enters_in_search_box(Integer int1) {
		driver.findElement(By.name("q")).sendKeys(int1.toString());
	}

	@Then("Google will display Exact \\({int} search results)")
	public void google_will_display_exact_search_results(Integer int1) {
	    System.out.println("Special characters are executed ");
	    List<WebElement> serachResults = driver.findElements(By.xpath("//h3//span"));
		System.out.println("Total search Results : " + serachResults.size());
		
	}


}
