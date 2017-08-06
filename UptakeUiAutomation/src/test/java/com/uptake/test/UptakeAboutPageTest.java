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

import com.uptake.pages.*;
import com.uptake.flows.*;
import com.uptake.utilities.*;

public class UptakeAboutPageTest {
	private WebDriver driver;
	
	
	@BeforeTest
	public void setup() {
		try {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Vicky and Aish\\Documents\\chromedriver.exe");
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
			System.out.print(e.getMessage());
			
		}
		
	}
	
	@Test
	public void uptakeAboutPageAssertionTest() throws InterruptedException {
		System.out.println("About Page validation Test");
		driver.get("https://uptake.com");
		AboutPage upTakeAboutPage = new AboutPage(driver);
		upTakeAboutPage.navigateToAboutPageButton().click();
		Thread.sleep(1000);
		upTakeAboutPage.verifyTitle();
		upTakeAboutPage.verifyAboutPageHeader();
		
	}
	
	@AfterTest()
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing IE browser");
			driver.quit();
		}
	}}
