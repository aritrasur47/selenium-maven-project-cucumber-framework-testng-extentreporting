package runners;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import utilities.ExtentReportsUtils;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src/test/java/features" }, 
					 glue = { "stepDefinitions" }, 
					 monochrome = true, 
					 tags = {}, 
					 plugin = { "pretty", "html:target/cucumber",
							 	"json:target/cucumber.json", 
							 	"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" })

public class MainRunner extends AbstractTestNGCucumberTests {
	@AfterClass
	public static void writeExtentReport() throws IOException {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/src/main/java/utilities/ExtentsConfig.xml"));
		Reporter.setSystemInfo("OS", "macOS");
		Reporter.setSystemInfo("Java", "14.0.1");
		Reporter.setSystemInfo("Maven", "3.5.0");
		Reporter.setSystemInfo("Selenium", "3.141.59");
		Reporter.setSystemInfo("Quality Analyst", "Aritra");
		ExtentReportsUtils.copyLatestExtentReport();
	}
}