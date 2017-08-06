package com.uptake.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.uptake.pages.*;
import com.uptake.flows.*;
import com.uptake.utilities.*;

public class HomePage //rename Homepage
{
	 private WebDriver driver;
	public HomePage(WebDriver driverNew) 
	{
		this.driver=driverNew;
	}
	
	WebElement getHomePageSubHeaderContentTitle() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(".hero__subtitle"));
	}
	
	public WebElement aboutUptake()
	{
		
		return SeleniumUtil.waitForElementVisible(driver, By.linkText("About"));	
	}
	
	public WebElement aboutUptakeHeader()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("html.fp-enabled body.light.fp-viewing-0 main.full-height article#home.fullpage.fullpage-wrapper div.section.fp-section.active.fp-table.fp-completely div.fp-tableCell div.section__content.homeSlide div.section__content__cropper div.hero__title"));	
	}
	public WebElement aboutNavLink()
	{
	
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("//a[contains(text(),'About')]"));
		
	}
	
	public WebElement productsNavLink()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/nav/a[2]"));
		
	}
	
	public WebElement industriesNavLink()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/nav/a[3]"));
		
	}
	
	public WebElement newsRoomNavLink()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/nav/a[4]"));
		
	}
	
	public WebElement beyondUptakeNavLink()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/nav/a[5]"));
		
	}
	
	public WebElement requestMoreInfo()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/div[2]/button"));
		
	}
	
	
	public WebElement uptakeImage()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/header/div[1]/div[1]/a/img"));
		
	}
	
	public WebElement transFormText()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/main/article/div[2]/div/div[1]/div/div/div[1]/div[1]/p"));
		
	}
	
	public WebElement transFormBelowText()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/main/article/div[2]/div/div[1]/div/div/div[1]/div[2]/p"));
		
	}
	
	
//
	public WebElement transFormVideo()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/div/div/div[1]/div/div/video"));
		
	}
//
	
	public WebElement turningDataValueText()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("html.fp-enabled body.light.fp-viewing-2 main.full-height article#home.fullpage.fullpage-wrapper div.section.fp-section.fp-table.active.fp-completely div.fp-tableCell div.section__content.homeSlide div.section__content__cropper div.hero__title p"));
		
	}
//
	public WebElement turningDataBelowText()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/main/article/div[3]/div/div[1]/div/div[2]/p"));
		
	}
	
	public WebElement readyResults()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/main/article/div[3]/div/div[1]/div/button"));
		
	}
	
	//
	public WebElement poweredByPeopleText()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/main/article/div[4]/div/div[1]/div/div[1]/p"));
		
	}
	//
	public WebElement poweredByPeopleBelowText()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/main/article/div[4]/div/div[1]/div/div[2]/p"));
		
	}
	//
	public WebElement viewOpenPositions()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/main/article/div[4]/div/div[1]/div/button"));
		
	}
	

	public WebElement learnMore()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("/html/body/main/article/div[1]/div/div[1]/div/button"));
		
	}
	
	
	public By byStep2IncomeAnalysis(){
		return By.xpath("//a[contains(text(), 'Income Analysis')]");
	}
	public WebElement step2IncomeAnalysis(){
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("//a[contains(text(), 'Income Analysis')]"));
	}
	public WebElement step2AnnualIncomeProjections(){
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("//a[contains(text(), 'Income Projections')]"));
	}
	
	public WebElement step2IncomeSources(){
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("//a[contains(text(), 'Income Sources')]"));
	}
	public WebElement step2AssetAllocation(){
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("//a[contains(text(), 'Asset Allocation')]"));
	}

	public WebElement step3serviceoptions()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("table.layout_leftnavwrap table.leftnav >tbody>tr:nth-child(8)>td:nth-child(2)"));	
	}
	public WebElement step4confirmation()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("table.layout_leftnavwrap table.leftnav >tbody>tr:nth-child(10)>td:nth-child(2)"));	
	}
	public WebElement enrollmentstatuslabel()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("table.layout_leftnavwrap table.leftnavbottom td.statusLabel"));	
	}
	public WebElement enrollmentstatus()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("table.layout_leftnavwrap table.leftnavbottom td.status"));	
	}
	
	public By cssRetirementquestionnaire(){
		return By.xpath("//a[contains(text(), 'Retirement Questionnaire')]");
	}
	public WebElement retirementquestionnaire()
	{
		return SeleniumUtil.waitForElementVisible(driver, By.xpath("//a[contains(text(), 'Retirement Questionnaire')]"));
	}
	
	public By byIntroductionLink(){
		return By.xpath("//a[contains(text(),'Introduction')]");
	}
	
	public WebElement introductionLink(){
		return SeleniumUtil.waitForElementVisible(driver, byIntroductionLink());
	}
	public void verifyTitle() {
		String currentPageTitle = driver.getTitle();
		Assert.assertEquals(currentPageTitle, "Analytics for the industrial internet");
	}
	
	public void verifyHomePageSubHeaderContentTitle() {
		String SectionTitle=getHomePageSubHeaderContentTitle().getText();
		Assert.assertEquals("Uptake is the actionable insights platform that is challenging what’s possible in industry. It’s time to make the world more productive, safe, secure, and reliable.", SectionTitle);
				
	}

	public WebElement navigateToAboutLine() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#header > div.navbar.centered-content > nav > a:nth-child(1)"));	
	}

	public void verifyAboutPageTitle() {
		String currentPageTitle = driver.getTitle();
		Assert.assertEquals(currentPageTitle, "About");	
	}
	
	public void verifyBlogPageTitle() {
		String currentPageTitle = driver.getTitle();
		Assert.assertEquals(currentPageTitle, "Uptake Named Technology Pioneer By World Economic Forum - Update Blog");	
	}
	
	public void verifyProuctPageTitle() {
		String currentPageTitle = driver.getTitle();
		Assert.assertEquals(currentPageTitle, "Products");	
	}
	
	public void verifyCareersPageTitle() {
		String currentPageTitle = driver.getTitle();
		Assert.assertEquals(currentPageTitle, "Careers");	
	}
	
	public WebElement navigateToAboutPageButton() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#home > div.section.fp-section.active.fp-table.fp-completely > div > div.section__content.homeSlide > div > button"));
	}
	
	public WebElement navigateToBlogPageButton() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#home > div.section.video.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div > div.col-4_md-5_sm-12 > button"));
	}
	
	public WebElement navigateToProductPageButton() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > button"));
	}
	
	public WebElement navigateToCareersPageButton() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > button"));
	}
	
	
	public WebElement blogPageHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#home > div.section.video.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div > div.col-4_md-5_sm-12 > div.hero__title > p"));
	}
	
	public WebElement productPageHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div.hero__title > p"));
	}
	
	public WebElement productPageSubHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div.hero__subtitle > p"));
	}
	public void verifyProductPageHeaderInHomePage() {
		String sectionTitle=productPageHeaderinHomePage().getText();
		Assert.assertEquals("Turning Data to Value.<br>FAST.", sectionTitle);
				
	}
	
	public void verifyProductPageSubHeaderInHomePage() {
		String sectionTitle=productPageSubHeaderinHomePage().getText();
		Assert.assertEquals("Uptake can deploy a new data science model in under an hour, delivering value to our customers FAST. Can your platform do that?", sectionTitle);
				
	}
	
	public WebElement blogPageSubHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#home > div.section.video.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div > div.col-4_md-5_sm-12 > div.hero__subtitle > p"));
	}
	
	public void verifyBlogPageHeaderInHomePage() {
		String sectionTitle=blogPageHeaderinHomePage().getText();
		Assert.assertEquals("Transforming the Way the World Works", sectionTitle);
				
	}
	
	public void verifyBlogPageSubHeaderInHomePage() {
		String sectionTitle=blogPageSubHeaderinHomePage().getText();
		Assert.assertEquals("Uptake is proud to be named a 2017 Technology Pioneer by the World Economic Forum. See how we are driving value for major industries like energy, construction, aviation, rail, and manufacturing.", sectionTitle);
				
	}

	public void navigateBack() {
		driver.navigate().back();
		
	}

	public WebElement careersPageHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div.hero__title > p"));
	}
	
	public WebElement careersPageSubHeaderinHomePage() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("#home > div.section.fp-section.fp-table.active.fp-completely > div > div.section__content.homeSlide > div > div.hero__subtitle > p"));
	}
	public void verifyCareersPageHeaderInHomePage() {
		String sectionTitle=careersPageHeaderinHomePage().getText();
		Assert.assertEquals("Turning Data to Value.<br>FAST.", sectionTitle);
				
	}
	
	public void verifyCareersPageSubHeaderInHomePage() {
		String sectionTitle=careersPageSubHeaderinHomePage().getText();
		Assert.assertEquals("Uptake can deploy a new data science model in under an hour, delivering value to our customers FAST. Can your platform do that?", sectionTitle);
				
	}
	
}
