package com.uptake.flows;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
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
	private static SoftAssert softAssert = new SoftAssert();

	public HomePageFlow(HomePage page01, WebDriver driver) {
		this.page01 = page01;
		this.driver = driver;

	}

	public void testHomePageUptake() {
		try {
			driver.get("http://uptake.com");
			HomePage upTakeHomePage = new HomePage(driver);
			upTakeHomePage.verifyTitle();
			upTakeHomePage.verifyHomePageSubHeaderContentTitle();
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
			upTakeHomePage.verifyBlogPageHeaderInHomePage();
			upTakeHomePage.verifyBlogPageSubHeaderInHomePage();
			// Button click to navigate to Blog Page
			// upTakeHomePage.navigateToBlogPageButton().click();
			Thread.sleep(2000);
			// upTakeHomePage.verifyBlogPageTitle(driver);
			// Close blog tab
			// upTakeHomePage.removeAndChangeTab();
			// Thread.sleep(2000);
			// CommonUtilities.waitUntilURLDOESNTContainsText(driver, "blog");
			// Product page
			// scroll down to products page
			upTakeHomePage.clickDownArrow(1);
			// upTakeHomePage.verifyProductPageHeaderInHomePage();
			upTakeHomePage.verifyProductPageSubHeaderInHomePage();
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
			upTakeHomePage.verifyCareersPageHeaderInHomePage();
			upTakeHomePage.verifyCareersPageSubHeaderInHomePage();
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

}
