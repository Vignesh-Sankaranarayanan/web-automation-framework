package com.uptake.flows;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.uptake.pages.AboutPage;
import com.uptake.pages.HomePage;
import com.uptake.utilities.CommonUtilities;
import com.uptake.utilities.SeleniumUtil;

public class AboutPageFlow {
	private static final Logger logger = Logger.getLogger(AboutPageFlow.class);
	private AboutPage aboutPage;
	private WebDriver driver;
	private String _testcaseID;
	private static SoftAssert softAssert = new SoftAssert();

	public AboutPageFlow(AboutPage aboutPageObj, WebDriver driver) {
		this.aboutPage = aboutPageObj;
		this.driver = driver;

	}

	public void testAboutPageUptake(Properties prop) {
		try {
			driver.get(prop.getProperty("url"));
			AboutPage upTakeAboutPage = new AboutPage(driver);
			upTakeAboutPage.navigateToAboutPageButton().click();
			CommonUtilities.waitUntilURLContainsText(driver, "about");
			Thread.sleep(2000);
			upTakeAboutPage.verifyAboutPageHeader(prop);
			upTakeAboutPage.verifyTitle(driver);
			// navigate tp products page
			upTakeAboutPage.navigateToProductsPage().click();
			CommonUtilities.waitUntilURLContainsText(driver, "products");
			// navigate tp industries page
			upTakeAboutPage.navigateToIndustriesPage().click();
			CommonUtilities.waitUntilURLContainsText(driver, "industries");
			// navigate to Newsroom page
			upTakeAboutPage.navigateToNewsroomPage().click();
			CommonUtilities.waitUntilURLContainsText(driver, "newsroom");

		} catch (Exception Iex) {
			logger.info("About Page Test Run is interuppted" + Iex.getMessage());
		}
	}

}
