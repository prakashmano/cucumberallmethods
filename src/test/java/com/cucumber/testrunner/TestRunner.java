package com.cucumber.testrunner;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.cucumber.baseclass.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:src\\test\\resource\\com\\extentreport\\report11.html"}, 
features = "src\\test\\java\\com\\cucumber\\feature", 
glue = "com.cucumber.stepdefinition", monochrome=true)

public class TestRunner {
	public static WebDriver driver;

	@BeforeClass
	public static void browserLaunch() {
		driver = BaseClass.browserlaunch("chrome");
	}

	@AfterClass
	public static void quit() {
		
	}
	
}
