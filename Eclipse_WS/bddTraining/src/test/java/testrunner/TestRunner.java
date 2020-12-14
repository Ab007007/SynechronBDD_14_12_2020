package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/feature/createCustomer.feature",
		glue = {"stepdefinition"},
		monochrome = true,
		dryRun = false,
		plugin= {"pretty","html:target/html_reports/html_reports.html","junit:target/junit_reports/junit_report.xml"
				, "json:target/json_reports/json_reports.json"})
public class TestRunner {

}
