package com.uptake.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uptake.pages.*;
import com.uptake.flows.*;
import com.uptake.utilities.*;



public class UptakeHomePageTest {
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
	//CommonUtilities.waitUntilURLContainsText(page07.getDriver(), "TAS_ICMA/app");
	@Test
	public void UptakeHomePageAssertionTest() throws InterruptedException {
		System.out.println("Home Page validation Test");
		driver.get("http://uptake.com");
		HomePage upTakeHomePage = new HomePage(driver);
		upTakeHomePage.verifyTitle();
		upTakeHomePage.verifyHomePageSubHeaderContentTitle();
		upTakeHomePage.navigateToAboutPageButton().click();
		CommonUtilities.waitUntilURLContainsText(driver, "about");
		upTakeHomePage.verifyAboutPageTitle();
		//Navigating back to home page to continue home page validations
		upTakeHomePage.navigateBack();
		CommonUtilities.waitUntilURLDOESNTContainsText(driver, "about");
		upTakeHomePage.verifyBlogPageHeaderInHomePage();
		upTakeHomePage.verifyBlogPageSubHeaderInHomePage();
		//Button click to navigate to Blog Page
		upTakeHomePage.navigateToBlogPageButton().click();
		CommonUtilities.waitUntilURLContainsText(driver, "blog");
		upTakeHomePage.verifyBlogPageTitle();
		//Navigating back to home page to continue home page validations
		upTakeHomePage.navigateBack();
		CommonUtilities.waitUntilURLDOESNTContainsText(driver, "blog");
		//Product page
		upTakeHomePage.verifyProductPageHeaderInHomePage();
		upTakeHomePage.verifyProductPageSubHeaderInHomePage();
		//Button click to navigate to Product Page
		upTakeHomePage.navigateToProductPageButton().click();
		CommonUtilities.waitUntilURLContainsText(driver, "products");
		upTakeHomePage.verifyProuctPageTitle();
		//Navigating back to home page to continue home page validations
		upTakeHomePage.navigateBack();
		CommonUtilities.waitUntilURLDOESNTContainsText(driver, "products");
		
		//Careers page
		upTakeHomePage.verifyCareersPageHeaderInHomePage();
		upTakeHomePage.verifyCareersPageSubHeaderInHomePage();
		//Button click to navigate to Careers Page
		upTakeHomePage.navigateToCareersPageButton().click();
		CommonUtilities.waitUntilURLContainsText(driver, "careers");
		upTakeHomePage.verifyCareersPageTitle();
		//Navigating back to home page to continue home page validations
		upTakeHomePage.navigateBack();
		CommonUtilities.waitUntilURLDOESNTContainsText(driver, "careers");
		
	}
	
	@AfterTest()
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing IE browser");
			driver.quit();
		}
	}
	
	
		
		}



