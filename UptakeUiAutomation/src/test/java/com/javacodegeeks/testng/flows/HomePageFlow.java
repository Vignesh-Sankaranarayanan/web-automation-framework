package com.javacodegeeks.testng.flows;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.javacodegeeks.testng.pages.HomePage;
import com.javacodegeeks.testng.utilities.SeleniumUtil;

public class HomePageFlow {
	private static final Logger logger = Logger.getLogger(HomePageFlow.class);
	private HomePage page01;
	private WebDriver driver;
	private String _testcaseID;
	private static SoftAssert softAssert= new SoftAssert();

	public HomePageFlow(
			HomePage page01, WebDriver driver) {
		this.page01 = page01;
		this.driver=driver;
		

		
	}

	public void TestLeftNavigationPage(WebDriver driverNew) {
		
		try {
		logger.info("started testing the left navigation page");
		driverNew.navigate().to("https://uptake.com/");
	    softAssert.assertEquals(
	    		page01.aboutNavLink().getText(),
	    		  "About",
	       "ASSERTION ERROR: Test Uptake Home page" + page01.aboutNavLink().getText() + "Expected Value in UI Home  Value:-About" );
	     
	  softAssert.assertAll();
		
		logger.info("completed testing the left navigation page");
		}
		catch(Exception ex) {
			logger.info(ex.getMessage());
			System.out.println(ex.getMessage());
			
		}
	}
}
