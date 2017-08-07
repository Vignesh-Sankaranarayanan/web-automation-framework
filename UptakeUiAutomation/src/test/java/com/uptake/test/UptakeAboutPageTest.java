package com.uptake.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.uptake.pages.*;
import com.uptake.flows.*;
import com.uptake.utilities.*;

public class UptakeAboutPageTest {
	private WebDriver driver;
	private static final Logger logger = Logger.getLogger(UptakeAboutPageTest.class);

	@BeforeTest
	public void setup() {
		try {
			System.setProperty("webdriver.chrome.driver","src\\test\\resources\\config\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("--enable-automation");
			options.addArguments("--js-flags=--expose-gc");  
			options.addArguments("--enable-precise-memory-info"); 
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);       

		}catch(Exception e) {
			logger.info(e.getMessage());

		}

	}

	@Test
	public void uptakeAboutPageAssertionTest() throws InterruptedException {
		logger.info("About Page validation Test");
		logger.info("Navigate to About and Other pages in the Uptake Site");
		AboutPage abtPage= new AboutPage(driver);
		AboutPageFlow abtFlow= new AboutPageFlow(abtPage, driver);
		abtFlow.testAboutPageUptake();


	}

	@AfterTest()
	public void tearDown() {
		if(driver!=null) {
			logger.info("Closing IE browser");
			driver.quit();
		}
	}}
