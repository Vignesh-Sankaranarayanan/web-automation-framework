package com.uptake.test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uptake.pages.*;
import com.uptake.flows.*;
import com.uptake.utilities.*;



public class UptakeHomePageTest {
	private WebDriver driver;
	Properties prop = new Properties();
	private static final Logger logger = Logger.getLogger(UptakeHomePageTest.class);
	@BeforeTest
	public void setup() {
		try {
			System.setProperty("webdriver.chrome.driver","src\\test\\resources\\config\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("--enable-automation");
			options.addArguments("--js-flags=--expose-gc");  
			options.addArguments("--enable-precise-memory-info"); 
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			driver = new ChromeDriver(options);       

		}catch(Exception e) {
			logger.info(e.getMessage());

		}

	}
	@BeforeTest
	public void readPropertiesFile() {
		
		File file = new File("src\\test\\java\\com\\uptake\\testdata\\data.properties");
		  
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}
	
	//Test to check if the background Image in the website is displayed
	
	@Test
	public void testBackGroundImagePresent(){
		logger.info("Test Background Image Test started");
		HomePage hmePage= new HomePage(driver);
		HomePageFlow homeFlow= new 	HomePageFlow(hmePage, driver,prop);
		homeFlow.testBackgroundImage();
	    logger.info("Test Background Image Test ended");
	}
	
	//Test to check if the video  in the website can be played
	@Test
	public void testVideoPlayHomePage(){
		logger.info("Play video in home page Test started");
		HomePage hmePage= new HomePage(driver);
		HomePageFlow homeFlow= new 	HomePageFlow(hmePage, driver,prop);
		homeFlow.testVideoPlay();
		logger.info("Play video in home page Test ended");
	}

	@Test
	public void UptakeHomePageAssertionTest() throws InterruptedException {
		logger.info("Home Page validation Test started");
		HomePage hmePage= new HomePage(driver);
		HomePageFlow homeFlow= new 	HomePageFlow(hmePage, driver,prop);
		homeFlow.testHomePageUptake();
		logger.info("Home Page validation Test completed");
	}

	@AfterTest()
	public void tearDown() {
		if(driver!=null) {
			logger.info("Closing IE browser");
			driver.quit();
		}
	}



}



