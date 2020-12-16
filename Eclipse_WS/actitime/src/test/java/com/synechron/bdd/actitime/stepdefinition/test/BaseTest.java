package com.synechron.bdd.actitime.stepdefinition.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	WebDriver driver;

	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	@After
	public void captureScreenShot(Scenario scenario) throws IOException {

		if (scenario.isFailed()) {
			System.out.println("Scenario " + scenario.getName() + " is failed");
			Date d = new Date();
			TakesScreenshot ss = (TakesScreenshot) driver;
			File screenShot = ss.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenShot,
					new File("ss/screenShot_" + d.toString().replace(" ", "_").replace(":", "_") + ".png"));
		} else {
			System.out.println("Scenario " + scenario.getName() + " is passed");
			System.out.println("-------------------------------------------------------------");
			System.out.println("Scenario Details : " + scenario.getName() + "\n Scenario id " + scenario.getId());
			scenario.log("I'm from after method");
		}
	}

}
