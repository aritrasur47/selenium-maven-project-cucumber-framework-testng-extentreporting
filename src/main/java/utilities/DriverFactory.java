package utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import pageObjects.FlightQuotes_Page;
import pageObjects.LoginandLogout_Page;

public class DriverFactory {
	public static WebDriver driver;
	public static LoginandLogout_Page LoginandLogoutPage;
	public static FlightQuotes_Page FlightQuotesPage;

	public WebDriver initializeDriver() {

		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
			prop.load(fis);
			String browserName = prop.getProperty("browser");
			System.out.println("Test starting with " + browserName + "driver");

			if (browserName.contains("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constant.CHROME_DRIVER_DIRECTORY);
				ChromeOptions options = new ChromeOptions();
				if (browserName.contains("headless")) {
					options.addArguments("--headless");
				}
				driver = new ChromeDriver(options);

			} else if (browserName.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", Constant.GECKO_DRIVER_DIRECTORY);
				driver = new FirefoxDriver();
			}

		} catch (Exception e) {
			System.out.println("Unable to load browser: " + e.getMessage());
		} finally {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			LoginandLogoutPage = PageFactory.initElements(driver, LoginandLogout_Page.class);
			FlightQuotesPage = PageFactory.initElements(driver, FlightQuotes_Page.class);
		}
		return driver;
	}
}
