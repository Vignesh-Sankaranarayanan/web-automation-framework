
package com.uptake.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.uptake.pages.*;
import com.uptake.flows.*;
import com.uptake.utilities.*;

public class AboutPage {
	private WebDriver driver;

	public AboutPage(WebDriver driverNew) {
		this.driver = driverNew;
	}

	WebElement getAboutPageHeaderContentTitle(Properties prop) {
		// return SeleniumUtil.waitForElementVisible(driver,
		// By.cssSelector(".hero__subtitle"));
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(".hero__subtitle"),
				prop.getProperty("aboutPageSubHeader"));
	}

	public WebElement navigateToAboutPageButton() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"#home > div.section.fp-section.active.fp-table.fp-completely > div > div.section__content.homeSlide > div > button"));
	}

	public WebElement navigateToProductsPage() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.cssSelector("#header > div.navbar.centered-content > nav > a:nth-child(2)"));
	}

	public WebElement navigateToIndustriesPage() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.cssSelector("#header > div.navbar.centered-content > nav > a:nth-child(3)"));
	}

	public WebElement navigateToNewsroomPage() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.cssSelector("#header > div.navbar.centered-content > nav > a:nth-child(4)"));
	}

	public WebElement navigateToBeyondUptakePage() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.cssSelector("#header > div.navbar.centered-content > nav > a:nth-child(5)"));
	}

	public WebElement navigateToBlogUptakePage() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.cssSelector("#header > div.navbar.centered-content > nav > a:nth-child(6)"));
	}

	public void verifyTitle(WebDriver driver) {
		SeleniumUtil.waitForPageToLoad(driver);
		String currentPageTitle = driver.getTitle();
		Assert.assertEquals(currentPageTitle, "About");
	}

	public void verifyAboutPageHeader(Properties prop) {
		String sectionTitle = getAboutPageHeaderContentTitle(prop).getText();
		Assert.assertEquals(prop.getProperty("aboutPageSubHeader"), sectionTitle);

	}
}