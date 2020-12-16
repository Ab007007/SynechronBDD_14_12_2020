package com.synechron.bdd.actitime.stepdefinition.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature/", glue = {
		"com" }, monochrome = true, dryRun = false, tags = "@pom",
		// plugin=
		// {"pretty","html:target/html_reports/html_reports.html","junit:target/junit_reports/junit_report.xml"
		plugin = { "json:target/cucumber.json" })
public class TestRunnerPOM {

}
