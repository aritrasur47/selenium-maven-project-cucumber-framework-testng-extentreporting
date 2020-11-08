package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import stepDefinitions.MasterHooks;

public class FlightQuotes_Page extends MasterHooks {

	// Origin city
	@FindBy(xpath = "//div[@ng-show=\"AirlineSearchIsVisible && BookingType != 'MULTICITY'\"]//input[@placeholder='Select Origin City']")
	WebElement originCityBox;

	// Origin city list
//	@FindBy(xpath = "//div[contains(text(), 'POPULAR CITIES')]/../div[contains(@class, 'angucomplete-row')]")
//	WebElement originCityList;

	// Destination city
	@FindBy(xpath = "//div[@ng-show=\"AirlineSearchIsVisible && BookingType != 'MULTICITY'\"]//input[@placeholder='Select Destination City']")
	WebElement destinationCityBox;

	// Destinationcity list
//	@FindBy(xpath = "//div[contains(text(), 'POPULAR CITIES')]/../div[contains(@class, 'angucomplete-row')]")
//	WebElement destinationCityList;

	// departure date
	@FindBy(xpath = "//div[contains(@class, 'calender-trigger')]//label[contains(@class,'datepicker')]")
	WebElement departureDate;

	// arrow forward
	@FindBy(xpath = "//div[@ng-show=\"AirlineSearchIsVisible && BookingType != 'MULTICITY'\"]//span[@style='cursor: pointer;']/i[text() = 'arrow_forward']")
	WebElement arrowfwd;

	// Passenger dropdown
	@FindBy(xpath = "//p[@ng-click = 'TravellerDropdown()']")
	WebElement passengerDropdown;

	// Passenger selection
	// @FindBy(xpath = "//ul[@class =
	// 'pagination']//a[@ng-click='AdultIncrement(2);']")
	@FindBy(xpath = "//ul[@class='pagination']//a[@class='page-link']") // need loop to rotate the list
	WebElement passengerSelect;

	// Done button
	@FindBy(xpath = "//input[@value='Done']")
	WebElement doneButton;

	// Search Button
	@FindBy(xpath = "//input[@value = 'Search']")
	WebElement searchButton;

	// Verify Button
	@FindBy(xpath = "//div[contains(@class, 'search-card')]")
	WebElement verifyQuotesPage;

	// ===============================

	public WebElement originCityBox() {
		return originCityBox;
	}

//	public WebElement originCityList() {
//		return originCityList;
//	}

	public WebElement destinationCityBox() {
		return destinationCityBox;
	}

//	public WebElement destinationCityList() {
//		return destinationCityList;
//	}

	public WebElement departureDate() {
		return departureDate;
	}

	public WebElement arrowfwd() {
		return arrowfwd;
	}

	public WebElement passengerDropdown() {
		return passengerDropdown;
	}

	public WebElement passengerSelect() {
		return passengerSelect;
	}

	public WebElement doneButton() {
		return doneButton;
	}

	public WebElement searchButton() {
		return searchButton;
	}

	public WebElement verifyQuotesPage() {
		return verifyQuotesPage;
	}
}
