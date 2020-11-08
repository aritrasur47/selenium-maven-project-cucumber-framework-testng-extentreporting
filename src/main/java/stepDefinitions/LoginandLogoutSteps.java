package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverFactory;
import utilities.TestUtil;

public class LoginandLogoutSteps extends DriverFactory {

	public WebDriver driver = initializeDriver();

	@Given("^Navigate to (.+) website$")
	public void navigate_to_website(String website) throws Throwable {
		driver.get(website);
		TestUtil.applyWait();
	}

	@Given("^User clicks on Signin button on the landing page$")
	public void user_clicks_on_signin_button_on_the_landing_page() throws Throwable {
		LoginandLogoutPage.signinDropdown().click();
		TestUtil.applyWait();
	}

	@Given("^User clicks on Customer login in the dropdown$")
	public void user_clicks_on_Customer_login_in_the_dropdown() throws Throwable {
		LoginandLogoutPage.customerloginButton().click();
		TestUtil.applyWait();
	}

	@When("^User enters mobile number (.+)$")
	public void user_enters_mobile_number(String mobile) throws Throwable {
		LoginandLogoutPage.mobilenumberBox().click();
		TestUtil.applyWait();
		LoginandLogoutPage.mobilenumberBox().sendKeys(mobile);
		TestUtil.applyWait();
	}

	@And("^User enters password (.+)$")
	public void user_enters_password(String password) throws Throwable {
		LoginandLogoutPage.passwordBox().sendKeys(password);
		TestUtil.applyWait();
	}

	@And("^User clicks on signin button$")
	public void user_clicks_on_signin_button() throws Throwable {
//		Assert.fail("Failed");
		LoginandLogoutPage.signinButton().click();
		TestUtil.applyWait();
	}

	@Then("^Verify that the user is successfully logged in$")
	public void verify_that_the_user_is_successfully_logged_in() throws Throwable {
		LoginandLogoutPage.verifyButtonDropdown().click();
		TestUtil.applyWait();
		Assert.assertTrue(LoginandLogoutPage.logoutText().isDisplayed());
	}

	@And("^User clicks on Logout$")
	public void user_clicks_on_logout() throws Throwable {
		TestUtil.applyWait();
		LoginandLogoutPage.logoutButton().click();
		TestUtil.applyWait();
		LoginandLogoutPage.logoutPopUpConfirm().click();
	}
}
