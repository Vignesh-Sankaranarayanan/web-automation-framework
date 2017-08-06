package com.uptake.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CommonUtilities {

	public static void waitUntilURLDOESNTContainsText(WebDriver driver, final String value) {
		Wait < WebDriver > wait = new FluentWait < WebDriver > (driver).withTimeout(
				100, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.MILLISECONDS);
		wait.until(new ExpectedCondition < Boolean > () {
			public Boolean apply(WebDriver driver) {
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				try {
					return ((!driver.getCurrentUrl().toString().contains(value)));
				} catch (Exception e) {
					return false;
				}
			}
		});
	}
	
	public static void waitUntilURLContainsText(WebDriver driver, final String value) {
		Wait < WebDriver > wait = new FluentWait < WebDriver > (driver).withTimeout(
				200, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.MILLISECONDS);
		wait.until(new ExpectedCondition < Boolean > () {
			public Boolean apply(WebDriver driver) {
				driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				String currentURL = driver.getCurrentUrl().toString();
				try {

					return ((currentURL.contains(value)));
				} catch (Exception e) {
					System.out.println(currentURL);
					return false;
				}
			}
		});
	}
}
