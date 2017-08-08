package com.uptake.flows;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.uptake.pages.*;
import com.uptake.utilities.*;

public class HomePageFlow {
	private static final Logger logger = Logger.getLogger(HomePageFlow.class);
	private HomePage page01;
	private WebDriver driver;
	private String _testcaseID;
	private Properties prop= new Properties();
	private static SoftAssert softAssert = new SoftAssert();

	public HomePageFlow(HomePage page01, WebDriver driver, Properties prop) {
		this.page01 = page01;
		this.driver = driver;
		this.prop=prop;
	}

	public void testHomePageUptake() {
		try {
			driver.get("http://uptake.com");
			HomePage upTakeHomePage = new HomePage(driver);
			upTakeHomePage.verifyTitle();
			upTakeHomePage.verifyHomePageSubHeaderContentTitle(prop);
			upTakeHomePage.navigateToAboutPageButton().click();
			CommonUtilities.waitUntilURLContainsText(driver, "about");
			Thread.sleep(3000);
			upTakeHomePage.verifyAboutPageTitle(driver);
			// Navigating back to home page to continue home page validations
			upTakeHomePage.navigateBack();
			CommonUtilities.waitUntilURLDOESNTContainsText(driver, "about");
			// scroll down to blog page
			upTakeHomePage.clickDownArrow(1);
			Thread.sleep(5000);
			upTakeHomePage.verifyBlogPageHeaderInHomePage(prop);
			upTakeHomePage.verifyBlogPageSubHeaderInHomePage(prop);
			// Button click to navigate to Blog Page
			// upTakeHomePage.navigateToBlogPageButton().click();
			Thread.sleep(2000);
			// Product page
			// scroll down to products page
			upTakeHomePage.clickDownArrow(1);
			// upTakeHomePage.verifyProductPageHeaderInHomePage();
			upTakeHomePage.verifyProductPageSubHeaderInHomePage(prop);
			// Button click to navigate to Product Page
			upTakeHomePage.navigateToProductPageButton().click();
			CommonUtilities.waitUntilURLContainsText(driver, "products");
			Thread.sleep(3000);
			upTakeHomePage.verifyProuctPageTitle(driver);
			// Navigating back to home page to continue home page validations
			upTakeHomePage.navigateBack();
			CommonUtilities.waitUntilURLDOESNTContainsText(driver, "products");

			// Careers page
			// scroll down to careers page
			upTakeHomePage.clickDownArrow(1);
			Thread.sleep(1000);
			upTakeHomePage.clickDownArrow(1);
			Thread.sleep(1000);
			upTakeHomePage.clickDownArrow(1);
			Thread.sleep(1000);
			upTakeHomePage.verifyCareersPageHeaderInHomePage(prop);
			upTakeHomePage.verifyCareersPageSubHeaderInHomePage(prop);
			// Button click to navigate to Careers Page
			upTakeHomePage.navigateToCareersPageButton().click();
			CommonUtilities.waitUntilURLContainsText(driver, "careers");
			Thread.sleep(3000);
			upTakeHomePage.verifyCareersPageTitle(driver);
			// Navigating back to home page to continue home page validations
			upTakeHomePage.navigateBack();
			CommonUtilities.waitUntilURLDOESNTContainsText(driver, "careers");
		} catch (InterruptedException Iex) {
			logger.info("Home Page Test Run is interuppted" + Iex.getMessage());
		}
	}

	public void testBackgroundImage() {
		 driver.get("http://uptake.com");
		 page01.checkBackGroundImageDisplay();
	    
		
	}

	public void testVideoPlay() {
		driver.get("http://uptake.com");
		page01.clickDownArrow(1);
		page01.checkVideoUrl();
	    
		
	}

}
