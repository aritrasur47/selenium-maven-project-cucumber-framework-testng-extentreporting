package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.DriverFactory;
import utilities.ExtentReportsUtils;
import cucumber.api.Scenario;

public class MasterHooks extends DriverFactory {

	@Before
	public void setup() {
		driver = initializeDriver();
	}

	@After
	public void tearDownAndScreenshotOnFailure(Scenario scenario) {
		try {
			if (driver != null && scenario.isFailed()) {
				ExtentReportsUtils.captureScreenshot();
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
		}
	}
}
