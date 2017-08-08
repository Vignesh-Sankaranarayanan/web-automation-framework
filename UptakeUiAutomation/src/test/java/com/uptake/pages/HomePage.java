package com.uptake.pages;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.uptake.pages.*;
import com.uptake.flows.*;
import com.uptake.utilities.*;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driverNew) {
		this.driver = driverNew;
	}

	WebElement getHomePageSubHeaderContentTitle() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(".hero__subtitle"));
	}

	public WebElement aboutUptake() {

		return SeleniumUtil.waitForElementVisible(driver, By.linkText("About"));
	}

	public WebElement aboutUptakeHeader() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"html.fp-enabled body.light.fp-viewing-0 main.full-height article#home.fullpage.fullpage-wrapper div.section.fp-section.active.fp-table.fp-completely div.fp-tableCell div.section__content.homeSlide div.section__content__cropper div.hero__title"));
	}

	public WebElement aboutNavLink() {

		return SeleniumUtil.waitForElementVisible(driver, By.xpath("//a[contains(text(),'About')]"));

	}

	public WebElement productsNavLink() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/nav/a[2]"));

	}

	public WebElement industriesNavLink() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/nav/a[3]"));

	}

	public WebElement newsRoomNavLink() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/nav/a[4]"));

	}

	public WebElement beyondUptakeNavLink() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/nav/a[5]"));

	}

	public WebElement requestMoreInfo() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/div[2]/button"));

	}

	public WebElement uptakeImage() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/div[1]/a/img"));

	}

	public WebElement transFormText() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.xpath("/html/body/main/article/div[2]/div/div[1]/div/div/div[1]/div[1]/p"));

	}

	public WebElement transFormBelowText() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.xpath("/html/body/main/article/div[2]/div/div[1]/div/div/div[1]/div[2]/p"));

	}

	//
	public WebElement transFormVideo() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/div/div/div[1]/div/div/video"));

	}
	//

	public WebElement turningDataValueText() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath(
				"html.fp-enabled body.light.fp-viewing-2 main.full-height article#home.fullpage.fullpage-wrapper div.section.fp-section.fp-table.active.fp-completely div.fp-tableCell div.section__content.homeSlide div.section__content__cropper div.hero__title p"));

	}

	//
	public WebElement turningDataBelowText() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.xpath("/html/body/main/article/div[3]/div/div[1]/div/div[2]/p"));

	}

	public WebElement readyResults() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.xpath("/html/body/main/article/div[3]/div/div[1]/div/button"));

	}

	//
	public WebElement poweredByPeopleText() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.xpath("/html/body/main/article/div[4]/div/div[1]/div/div[1]/p"));

	}

	//
	public WebElement poweredByPeopleBelowText() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.xpath("/html/body/main/article/div[4]/div/div[1]/div/div[2]/p"));

	}

	//
	public WebElement viewOpenPositions() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.xpath("/html/body/main/article/div[4]/div/div[1]/div/button"));

	}

	public WebElement learnMore() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.xpath("/html/body/main/article/div[1]/div/div[1]/div/button"));

	}

	public By byStep2IncomeAnalysis() {
		return By.xpath("//a[contains(text(), 'Income Analysis')]");
	}

	public WebElement step2IncomeAnalysis() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("//a[contains(text(), 'Income Analysis')]"));
	}

	public WebElement step2AnnualIncomeProjections() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("//a[contains(text(), 'Income Projections')]"));
	}

	public WebElement step2IncomeSources() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("//a[contains(text(), 'Income Sources')]"));
	}

	public WebElement step2AssetAllocation() {
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("//a[contains(text(), 'Asset Allocation')]"));
	}

	public WebElement step3serviceoptions() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.cssSelector("table.layout_leftnavwrap table.leftnav >tbody>tr:nth-child(8)>td:nth-child(2)"));
	}

	public WebElement step4confirmation() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.cssSelector("table.layout_leftnavwrap table.leftnav >tbody>tr:nth-child(10)>td:nth-child(2)"));
	}

	public WebElement enrollmentstatuslabel() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.cssSelector("table.layout_leftnavwrap table.leftnavbottom td.statusLabel"));
	}

	public WebElement enrollmentstatus() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.cssSelector("table.layout_leftnavwrap table.leftnavbottom td.status"));
	}

	public By cssRetirementquestionnaire() {
		return By.xpath("//a[contains(text(), 'Retirement Questionnaire')]");
	}

	public WebElement retirementquestionnaire() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.xpath("//a[contains(text(), 'Retirement Questionnaire')]"));
	}

	public By byIntroductionLink() {
		return By.xpath("//a[contains(text(),'Introduction')]");
	}

	public WebElement introductionLink() {
		return SeleniumUtil.waitForElementVisible(driver, byIntroductionLink());
	}

	public void verifyTitle() {
		String currentPageTitle = driver.getTitle();
		Assert.assertEquals(currentPageTitle, "Analytics for the industrial internet");
	}

	public void verifyHomePageSubHeaderContentTitle(Properties prop) {
		String SectionTitle = getHomePageSubHeaderContentTitle().getText();
		Assert.assertEquals(prop.getProperty("HomePageSubHeaderContentTitle"), SectionTitle);

	}

	public WebElement navigateToAboutLine() {
		return SeleniumUtil.waitForElementVisible(driver,
				By.cssSelector("#header > div.navbar.centered-content > nav > a:nth-child(1)"));
	}

	public void clickDownArrow(int i) throws InterruptedException {

		while (i > 0) {
			driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
			i--;
			SeleniumUtil.waitForPageToLoad(driver);
			Thread.sleep(1000);
		}
	}

	public void removeAndChangeTab() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "w");
		// Switch Home page tab
		driver.switchTo().defaultContent();

	}

	public void verifyAboutPageTitle(WebDriver driver2) {
		SeleniumUtil.waitForPageToLoad(driver2);
		String currentPageTitle = driver2.getTitle();
		Assert.assertEquals(currentPageTitle, "About");
	}

	public void verifyBlogPageTitle(WebDriver driver2) {
		SeleniumUtil.waitForPageToLoad(driver2);
		String currentPageTitle = driver2.getTitle();
		Assert.assertEquals(currentPageTitle, "Uptake Named Technology Pioneer By World Economic Forum - Update Blog");
	}

	public void verifyProuctPageTitle(WebDriver driver2) {
		SeleniumUtil.waitForPageToLoad(driver2);
		String currentPageTitle = driver2.getTitle();
		Assert.assertEquals(currentPageTitle, "Products");
	}

	public void verifyCareersPageTitle(WebDriver driver2) {
		SeleniumUtil.waitForPageToLoad(driver2);
		String currentPageTitle = driver2.getTitle();
		Assert.assertEquals(currentPageTitle, "Analytics for the industrial internet");
	}

	public WebElement navigateToAboutPageButton() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"#home > div.section.fp-section.active.fp-table.fp-completely > div > div.section__content.homeSlide > div > button"));
	}

	public WebElement navigateToBlogPageButton() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"#home > div.section.video.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div > div.col-4_md-5_sm-12 > button"));
	}

	public WebElement navigateToProductPageButton() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > button"));
	}

	public WebElement navigateToCareersPageButton() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > button"));
	}

	public WebElement blogPageHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"#home > div.section.video.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div > div.col-4_md-5_sm-12 > div.hero__title > p"));
	}

	public WebElement productPageHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div.hero__title > p"));
	}

	public WebElement productPageSubHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div.hero__subtitle > p"));
	}

	public void verifyProductPageHeaderInHomePage(Properties prop) {
		String sectionTitle = productPageHeaderinHomePage().getAttribute("innerText");
		Assert.assertEquals(prop.getProperty("ProductPageHeaderInHomePage"), sectionTitle);

	}

	public void verifyProductPageSubHeaderInHomePage(Properties prop) {
		String sectionTitle = productPageSubHeaderinHomePage().getText();
		Assert.assertEquals(prop.getProperty("ProductPageSubHeaderInHomePage"), sectionTitle);

	}

	public WebElement blogPageSubHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"#home > div.section.video.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div > div.col-4_md-5_sm-12 > div.hero__subtitle > p"));
	}

	public void verifyBlogPageHeaderInHomePage(Properties prop) {
		SeleniumUtil.waitForPageToLoad(driver);
		String sectionTitle = blogPageHeaderinHomePage().getText();
		Assert.assertEquals(prop.getProperty("BlogPageHeaderInHomePage"), sectionTitle);

	}

	public void verifyBlogPageSubHeaderInHomePage(Properties prop) {
		SeleniumUtil.waitForPageToLoad(driver);
		String sectionTitle = blogPageSubHeaderinHomePage().getText();
		Assert.assertEquals(prop.getProperty("BlogPageSubHeaderInHomePage"), sectionTitle);

	}

	public void navigateBack() {
		driver.navigate().back();

	}

	public WebElement careersPageHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div.hero__title > p"));
	}

	public WebElement careersPageSubHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(
				"#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div.hero__subtitle > p"));
	}

	public void verifyCareersPageHeaderInHomePage(Properties prop) {
		SeleniumUtil.waitForPageToLoad(driver);
		String sectionTitle = careersPageHeaderinHomePage().getAttribute("innerText");
		Assert.assertEquals(prop.getProperty("CareersPageHeaderInHomePage"), sectionTitle);

	}

	public void verifyCareersPageSubHeaderInHomePage(Properties prop) {
		SeleniumUtil.waitForPageToLoad(driver);
		String sectionTitle = careersPageSubHeaderinHomePage().getText();
		Assert.assertEquals(prop.getProperty("CareersPageSubHeaderInHomePage"), sectionTitle);

	}

	public void checkBackGroundImageDisplay(Properties prop) {
		WebElement img = driver
				.findElement(By.cssSelector("#home > div.section.fp-section.fp-table.active.fp-completely"));
		assertEquals(prop.getProperty("backgroundImageCheck"), img.getAttribute("style"));

	}

	public void checkVideoUrl(Properties prop) {
		WebElement video = driver
				.findElement(By.xpath("//*[@id=\"home\"]/div[2]/div/div[1]/div/div/div[2]/div/iframe"));
		assertEquals(prop.getProperty("checkVideoUrl"), video.getAttribute("src"));

	}

}
