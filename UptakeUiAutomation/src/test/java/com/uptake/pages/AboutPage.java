
package com.uptake.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.uptake.pages.*;
import com.uptake.flows.*;
import com.uptake.utilities.*;

public class AboutPage 
{
	 private WebDriver driver;
	public AboutPage(WebDriver driverNew) 
	{
		this.driver=driverNew;
	}
	
	WebElement getAboutPageHeaderContentTitle() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(".hero__subtitle"));
	}
	
	public WebElement navigateToAboutPageButton() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#home > div.section.fp-section.active.fp-table.fp-completely > div > div.section__content.homeSlide > div > button"));
	}
	
	public void verifyTitle() {
		String currentPageTitle = driver.getTitle();
		Assert.assertEquals(currentPageTitle, "About");
	}
	
	public void verifyAboutPageHeader() {
		String sectionTitle=getAboutPageHeaderContentTitle().getText();
		Assert.assertEquals("Uptake is transforming industry with our unrivaled data science and predictive analytics. Monitoring assets in over 94 countries, we power data-driven businesses and deliver greater value to global companies by putting super-charged decision-making power into the hands of our customers.", sectionTitle);
				
	}
}