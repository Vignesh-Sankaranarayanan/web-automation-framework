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
	private HomePage homePage;
	private WebDriver driver;
	private Properties prop = new Properties();

	public HomePageFlow(HomePage homePageObj, WebDriver driver, Properties prop) {
		this.homePage = homePageObj;
		this.driver = driver;
		this.prop = prop;
	}

	public void testHomePageUptake() {
		try {
			driver.get(prop.getProperty("url"));
			HomePage upTakeHomePage = new HomePage(driver);
			upTakeHomePage.verifyTitle();
			upTakeHomePage.verifyHomePageSubHeaderContentTitle(prop);
			upTakeHomePage.navigateToAboutPageButton().click();
			CommonUtilities.waitUntilURLContainsText(driver, "about");
			Thread.sleep(1000);
			upTakeHomePage.verifyAboutPageTitle(driver);
			// Navigating back to home page to continue home page validations
			upTakeHomePage.navigateBack();
			CommonUtilities.waitUntilURLDOESNTContainsText(driver, "about");
			// scroll down to blog page
			upTakeHomePage.clickDownArrow(1);
			Thread.sleep(1000);
			upTakeHomePage.verifyBlogPageHeaderInHomePage(prop);
			upTakeHomePage.verifyBlogPageSubHeaderInHomePage(prop);
			// Button click to navigate to Blog Page
			// upTakeHomePage.navigateToBlogPageButton().click();
			// Product page
			// scroll down to products page
			upTakeHomePage.clickDownArrow(1);
			// upTakeHomePage.verifyProductPageHeaderInHomePage();
			Thread.sleep(1000);
			upTakeHomePage.verifyProductPageSubHeaderInHomePage(prop);
			// Button click to navigate to Product Page
			upTakeHomePage.navigateToProductPageButton().click();
			CommonUtilities.waitUntilURLContainsText(driver, "products");
			Thread.sleep(1000);
			upTakeHomePage.verifyProuctPageTitle(driver);
			// Navigating back to home page to continue home page validations
			upTakeHomePage.navigateBack();
			CommonUtilities.waitUntilURLDOESNTContainsText(driver, "products");
			// Careers page
			// scroll down to careers page
			upTakeHomePage.clickDownArrow(3);
			Thread.sleep(1000);
			upTakeHomePage.verifyCareersPageHeaderInHomePage(prop);
			upTakeHomePage.verifyCareersPageSubHeaderInHomePage(prop);
			// Button click to navigate to Careers Page
			upTakeHomePage.navigateToCareersPageButton().click();
			CommonUtilities.waitUntilURLContainsText(driver, "careers");
			Thread.sleep(1000);
			upTakeHomePage.verifyCareersPageTitle(driver);
			// Navigating back to home page to continue home page validations
			upTakeHomePage.navigateBack();
			CommonUtilities.waitUntilURLDOESNTContainsText(driver, "careers");
		} catch (Exception Iex) {
			logger.info("Home Page Test Run is interuppted" + Iex.getMessage());
		}
	}

	public void testBackgroundImage() {
		driver.get(prop.getProperty("url"));
		homePage.checkBackGroundImageDisplay(prop);

	}

	public void testVideoPlay() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		homePage.clickDownArrow(1);
		homePage.checkVideoUrl(prop);

	}

}
