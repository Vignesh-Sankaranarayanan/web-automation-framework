package com.uptake.flows;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.uptake.pages.AboutPage;
import com.uptake.pages.HomePage;
import com.uptake.utilities.CommonUtilities;

public class AboutPageFlow {
	private static final Logger logger = Logger.getLogger(AboutPageFlow.class);
	private AboutPage page01;
	private WebDriver driver;
	private String _testcaseID;
	private static SoftAssert softAssert = new SoftAssert();

	public AboutPageFlow(AboutPage page01, WebDriver driver) {
		this.page01 = page01;
		this.driver = driver;

	}

	public void testAboutPageUptake(Properties prop) {
		try {
			driver.get("https://uptake.com");
			AboutPage upTakeAboutPage = new AboutPage(driver);
			upTakeAboutPage.navigateToAboutPageButton().click();
			CommonUtilities.waitUntilURLContainsText(driver, "about");
			Thread.sleep(1000);
			upTakeAboutPage.verifyTitle(driver);
			upTakeAboutPage.verifyAboutPageHeader(prop);
			// navigate tp products page
			upTakeAboutPage.navigateToProductsPage().click();
			CommonUtilities.waitUntilURLContainsText(driver, "products");
			Thread.sleep(1000);

			// navigate tp industries page
			upTakeAboutPage.navigateToIndustriesPage().click();
			CommonUtilities.waitUntilURLContainsText(driver, "industries");
			Thread.sleep(1000);

			// navigate to Newsroom page
			upTakeAboutPage.navigateToNewsroomPage().click();
			CommonUtilities.waitUntilURLContainsText(driver, "newsroom");
			Thread.sleep(1000);

		} catch (InterruptedException Iex) {
			logger.info("About Page Test Run is interuppted" + Iex.getMessage());
		}
	}

}
