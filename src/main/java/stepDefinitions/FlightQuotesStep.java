package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.DriverFactory;
import utilities.TestUtil;

public class FlightQuotesStep extends DriverFactory {

	public WebDriver driver = initializeDriver();

	@Given("^Navigate to website (.+)$")
	public void navigate_to_website(String website) throws Throwable {
		driver.get(website);
		TestUtil.applyWait();
	}

	@When("^User selects origin city (.+)$")
	public void user_selects_origin_city(String origin) throws Throwable {
		FlightQuotesPage.originCityBox().click();
		TestUtil.applyWait();
		FlightQuotesPage.originCityBox().sendKeys(origin);
		TestUtil.applyWait();
		List<WebElement> originCityList = driver.findElements(
				By.xpath("//div[contains(text(), 'POPULAR CITIES')]/../div[contains(@class, 'angucomplete-row')]"));
		TestUtil.applyWait();

		for (WebElement originCity : originCityList) {
			if (originCity.getText().toUpperCase().contains("DELHI")) {
				originCity.click();
				break;
			}
		}
	}

	@And("^User selects destination city (.+)$")
	public void user_selects_destination_city(String destination) throws Throwable {
		FlightQuotesPage.destinationCityBox().click();
		TestUtil.applyWait();
		FlightQuotesPage.destinationCityBox().sendKeys(destination);
		TestUtil.applyWait();
		List<WebElement> destinationCityList = driver.findElements(
				By.xpath("//div[contains(text(), 'POPULAR CITIES')]/../div[contains(@class, 'angucomplete-row')]"));
		TestUtil.applyWait();

		for (WebElement destCity : destinationCityList) {
			if (destCity.getText().toUpperCase().contains("MUMBAI")) {
				destCity.click();
				break;
			}
		}
	}

	@And("^User selects departure date$")
	public void user_selects_departure_date() throws Throwable {
		FlightQuotesPage.departureDate().click();
		TestUtil.applyWait();
		FlightQuotesPage.arrowfwd().click();

		WebElement dt = driver.findElement(By.xpath("//td[@class='emp_Cells']/span[text()= '10']"));
		dt.click();
		TestUtil.applyWait();
	}

	@And("^User enters passenger details$")
	public void user_enters_passenger_details() throws Throwable {
		FlightQuotesPage.passengerDropdown().click();
		TestUtil.applyWait();

		List<WebElement> passengerCount = driver
				.findElements(By.xpath("//ul[@class='pagination']//a[@class='page-link']"));
		TestUtil.applyWait();
		passengerCount.get(3).click();

		TestUtil.applyWait();
		FlightQuotesPage.doneButton().click();
	}

	@And("^User clicks on Search button$")
	public void user_clicks_on_search_button() throws Throwable {
		TestUtil.applyWait();
		FlightQuotesPage.searchButton().click();
	}

	@Then("^Quotes page is displayed$")
	public void quotes_page_is_displayed() throws Throwable {
		Assert.assertTrue(FlightQuotesPage.verifyQuotesPage().isDisplayed());
		TestUtil.applyWait();
	}
}
