package com.adactin.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"com.cucumber.listener.com.cucumber.listener.ExtentCucumberFormatter:src/test/resource/reports/report.html"},
		features="src\\test\\java\\com\\adactin\\feature\\adactin.feature",
		glue="com.adactin.stepdefinition"
		)

public class TestRunnerAdac 
{
	public static WebDriver driver;
	@BeforeClass
	public static void driverintialize() throws Exception
	{
		driver=com.adactin.baseclass.BaseClass.getDriver("chrome");
	}
	@AfterClass
	public static void driverquit()
	{
		System.out.println("quit");
		Reporter.loadXMLConfig(new File("src/test/resource/extents_report_configuration/extentReport.xml"));
		//driver.quit();
	}


}
