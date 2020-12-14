package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Given("user is on login page")
	public void user_is_on_login_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user_is_on_login_page");
	}

	@When("click on login")
	public void click_on_login() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("click_on_login");
	}

	@Then("user should be able to see dashbord page")
	public void user_should_be_able_to_see_dashbord_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user_should_be_able_to_see_dashbord_page");
	}

	@When("user enter (in)valid username and/or password")
	public void user_enter_invalid_username_or_password() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user_enter_invalid_username_or_password");
	}

	@Then("user should stay on same page")
	public void user_should_stay_on_same_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("user_should_stay_on_same_page");
	}

}
