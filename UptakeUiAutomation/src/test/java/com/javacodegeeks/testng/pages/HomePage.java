package com.javacodegeeks.testng.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.javacodegeeks.testng.utilities.SeleniumUtil;
public class HomePage //rename Homepage
{
	 private WebDriver driver;
	public HomePage(WebDriver driverNew) 
	{
		this.driver=driverNew;
	}
	
	WebElement getHomePageContentTitle() {
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector(".hero__subtitle"));
	}
	
	public WebElement aboutUptake()
	{
		
		return SeleniumUtil.waitForElementVisible(driver, By.cssSelector("html.fp-enabled body.light.fp-viewing-0 main.full-height article#home.fullpage.fullpage-wrapper div.section.fp-section.active.fp-table.fp-completely div.fp-tableCell div.section__content.homeSlide div.section__content__cropper div.hero__subtitle p"));	
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
	
	public void verifyContentTitle() {
		String SectionTitle=getHomePageContentTitle().getText();
		Assert.assertEquals("Uptake is the actionable insights platform that is challenging what�s possible in industry. It�s time to make the world more productive, safe, secure, and reliable.", SectionTitle);
				
	}
}
