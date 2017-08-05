package com.javacodegeeks.testng.utilities;



import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.testng.log4testng.Logger;
import javax.imageio.ImageIO;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class SeleniumUtil {
	private static final Logger logger = Logger.getLogger(SeleniumUtil.class);
	private static final String JQUERY_ACTIVE_CONNECTIONS_QUERY = "return $.active == 0;";
	private static ImageUtil image = new ImageUtil();



	public static boolean waitForElementNotPresent(WebDriver driver, final By locator, final WebElement context,
			String errorMessage) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					context.findElement(locator);
					return false;
				} catch (Exception e) {
					return true;
				}
			}
		};
		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("This element should not be present: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	public static boolean waitForElementNotPresent(WebDriver driver, final By locator, final WebElement context) {
		return waitForElementNotPresent(driver, locator, context, "");
	}

	public static WebElement waitForElementPresent(WebDriver driver, final By locator, String errorMessage) {
		Function<WebDriver, WebElement> waitFn = new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		};
		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Element: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	public static WebElement waitForElementPresent(WebDriver driver, final By locator) {
		return waitForElementPresent(driver, locator, "");
	}

	public static List<WebElement> waitForAllElementsPresent(WebDriver driver, final By locator, String errorMessage) {
		Function<WebDriver, List<WebElement>> waitFn = new Function<WebDriver, List<WebElement>>() {
			
			public List<WebElement> apply(WebDriver driver) {
				return driver.findElements(locator);
			}
		};
		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Elements: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	public static List<WebElement> waitForAllElementsPresent(WebDriver driver, final By locator) {
		return waitForAllElementsPresent(driver, locator, "");
	}

	public static WebElement waitForElementPresent(WebDriver driver, final By locator, final WebElement context,
			String errorMessage) {
		Function<WebDriver, WebElement> waitFn = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return context.findElement(locator);
			}
		};
		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Element: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	public static WebElement waitForElementPresent(WebDriver driver, final By locator, final WebElement context) {
		return waitForElementPresent(driver, locator, context, "");
	}

	public static WebElement waitForElementVisible(WebDriver driver, final By locator, String errorMessage) {
		Function<WebDriver, WebElement> waitFn = new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				try {
					WebElement el = driver.findElement(locator);
					if (el.isDisplayed()) {
						return el;
					}
				} catch (Exception e) {
				}
				return null;
			}
		};

		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Element: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	public static WebElement waitForElementVisible(WebDriver driver, final By locator) {
		return waitForElementVisible(driver, locator, "");

	}

	public static WebElement waitForElementVisible(WebDriver driver, final By locator, final WebElement context,
			String errorMessage) {
		Function<WebDriver, WebElement> waitFn = new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				try {
					WebElement el = context.findElement(locator);
					if (el.isDisplayed()) {
						return el;
					}
				} catch (Exception e) {
				}
				return null;
			}
		};
		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Element: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	public static WebElement waitForElementVisible(WebDriver driver, final By locator, final WebElement context) {
		return waitForElementVisible(driver, locator, context, "");
	}

	public static WebElement waitForElementVisible(WebDriver driver, final By locator, final WebElement context,
			int seconds, String errorMessage) {
		Function<WebDriver, WebElement> waitFn = new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				try {
					WebElement el = context.findElement(locator);
					if (el.isDisplayed()) {
						return el;
					}
				} catch (Exception e) {
				}
				return null;
			}
		};
		WebDriverWait wait = createWait(driver, seconds);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Element: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	public static WebElement waitForElementVisible(WebDriver driver, final By locator, final WebElement context,
			int seconds) {
		return waitForElementVisible(driver, locator, context, seconds, "");

	}

	public static WebElement waitForElementVisibleAndContentNotEmpty(WebDriver driver, final By locator,
			final WebElement context) {
		Function<WebDriver, WebElement> waitFn = new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				try {
					WebElement el = context.findElement(locator);
					if (el.isDisplayed() && !"".equals(el.getText())) {
						return el;
					}
				} catch (Exception e) {
				}
				return null;
			}
		};
		WebDriverWait wait = createWait(driver);
		wait.withMessage("Cannot find Element or content is empty: " + locator.toString());
		return wait.until(waitFn);
	}

	public static List<WebElement> waitForAllElementsPresent(WebDriver driver, final By locator,
			final WebElement context, String errorMessage) {
		Function<WebDriver, List<WebElement>> waitFn = new Function<WebDriver, List<WebElement>>() {
			
			public List<WebElement> apply(WebDriver driver) {
				try {
					List<WebElement> els = context.findElements(locator);
					if (els.size() > 0) {
						return els;
					}
					return null;

				} catch (Exception e) {
				}
				return null;
			}
		};
		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Elements: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	public static List<WebElement> waitForAllElementsPresent(WebDriver driver, final By locator,
			final WebElement context) {
		return waitForAllElementsPresent(driver, locator, context, "");

	}

	public static List<WebElement> waitForAllElementsVisible(WebDriver driver, final By locator, String errorMessage) {
		Function<WebDriver, List<WebElement>> waitFn = new Function<WebDriver, List<WebElement>>() {
			
			public List<WebElement> apply(WebDriver driver) {
				try {
					List<WebElement> els = driver.findElements(locator);
					int count = 0;
					for (WebElement el : els) {
						if (el.isDisplayed()) {
							count++;
						}
					}

					if (count == els.size() && els.size() > 0) {
						return els;
					}

				} catch (Exception e) {
				}
				return null;
			}
		};
		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Elements: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	public static List<WebElement> waitForAllElementsVisible(WebDriver driver, final By locator) {
		return waitForAllElementsVisible(driver, locator, "");
	}

	public static List<WebElement> waitForAllElementsVisible(WebDriver driver, final By locator,
			final WebElement context, String errorMessage) {
		Function<WebDriver, List<WebElement>> waitFn = new Function<WebDriver, List<WebElement>>() {
			
			public List<WebElement> apply(WebDriver driver) {
				try {
					List<WebElement> els = context.findElements(locator);
					int count = 0;
					for (WebElement el : els) {
						if (el.isDisplayed()) {
							count++;
						}
					}

					if (count == els.size() && els.size() > 0) {
						return els;
					}

				} catch (Exception e) {
				}
				return null;
			}
		};

		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Elements: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	public static List<WebElement> waitForAllElementsVisible(WebDriver driver, final By locator,
			final WebElement context) {
		return waitForAllElementsVisible(driver, locator, context, "");
	}

	public static WebElement waitForElementVisible(WebDriver driver, final WebElement el, String errorMessage) {
		Function<WebDriver, WebElement> waitFn = new Function<WebDriver, WebElement>() {
			
			public WebElement apply(WebDriver driver) {
				try {
					if (el.isDisplayed()) {
						return el;
					}
				} catch (Exception e) {
				}
				return null;
			}
		};
		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Element: " + el.toString());
		}
		return wait.until(waitFn);
	}

	public static WebElement waitForElementVisible(WebDriver driver, final WebElement el) {
		return waitForElementVisible(driver, el, "");
	}

	public static void waitForElementNotVisible(WebDriver driver, final By locator, String errorMessage) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				return !isElementVisible(driver, locator);
			}
		};

		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("This element should not be visible: " + locator.toString());
		}
		wait.until(waitFn);
	}

	public static void waitForElementNotVisible(WebDriver driver, final By locator) {
		waitForElementNotVisible(driver, locator, "");
	}

	public static void waitForAllElementsNotVisible(WebDriver driver, final By locator, String errorMessage) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				try {

					for (WebElement el : driver.findElements(locator)) {
						if (el.isDisplayed()) {
							return false;
						}
					}

				} catch (Exception ex) {
					return true;
				}
				return true;
			}
		};

		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("These elements should not be visible: " + locator.toString());
		}
		wait.until(waitFn);
	}

	public static void waitForAllElementsNotVisible(WebDriver driver, final By locator) {
		waitForAllElementsNotVisible(driver, locator, "");
	}

	public static void waitForElementNotVisible(WebDriver driver, final By locator, int seconds, String errorMessage) {

		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				return !isElementVisible(driver, locator);
			}
		};

		WebDriverWait wait = createWait(driver, seconds);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("This element should not be visible: " + locator.toString());
		}
		wait.until(waitFn);
	}

	public static void waitForElementNotVisible(WebDriver driver, final By locator, int seconds) {
		waitForElementNotVisible(driver, locator, seconds, "");

	}

	public static void waitForElementNotVisible(WebDriver driver, final By locator, final WebElement context,
			String errorMessage) {
		sleep(1);
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				return !isElementVisible(context, locator);
			}
		};
		WebDriverWait wait = createWait(driver);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("This element should not be visible: " + locator.toString());
		}
		wait.until(waitFn);
	}

	public static void waitForElementNotVisible(WebDriver driver, final By locator, final WebElement context) {
		waitForElementNotVisible(driver, locator, context, "");

	}

	public static void waitForElementNotVisible(WebDriver driver, final By locator, final WebElement context,
			int seconds, String errorMessage) {
		sleep(1);
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				return !isElementVisible(context, locator);
			}
		};
		WebDriverWait wait = createWait(driver, seconds);
		if (errorMessage != null && !errorMessage.equals("")) {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("This element should not be visible: " + locator.toString());
		}
		wait.until(waitFn);
	}

	public static void waitForElementNotVisible(WebDriver driver, final By locator, final WebElement context,
			int seconds) {
		waitForElementNotVisible(driver, locator, context, seconds, "");

	}

	public static void waitForElementNotPresent(WebDriver driver, final By locator, String errorMessage) {
		sleep(1);
		if (isElementPresent(driver, locator)) {
			Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
				
				public Boolean apply(WebDriver driver) {
					return !isElementPresent(driver, locator);
				}
			};
			WebDriverWait wait = createWait(driver);
			if (errorMessage != null && !errorMessage.equals("")) {
				wait.withMessage(errorMessage);
			} else {
				wait.withMessage("This element should not be present: " + locator.toString());
			}
			wait.until(waitFn);
		}

	}

	public static void waitForElementNotPresent(WebDriver driver, final By locator) {
		waitForElementNotPresent(driver, locator, "");
	}

	public static void sleep(double seconds) {
		try {
			Thread.sleep((long) (1000 * seconds));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Boolean isElementPresent(WebElement context, By locator) {
		try {
			context.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Boolean isElementPresent(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Boolean isElementVisible(WebElement context, By locator) {
		try {
			WebElement el = context.findElement(locator);
			if (el.isDisplayed()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public static Boolean isElementVisible(WebDriver driver, By locator) {
		try {
			WebElement el = driver.findElement(locator);
			if (el.isDisplayed()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public static WebDriverWait createWait(WebDriver driver) {
		return new WebDriverWait(driver,60, 180);
	}

	public static WebDriverWait createWait(WebDriver driver, long timeOutInSeconds, long sleepInMillis) {
		return new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
	}

	public static WebDriverWait createWait(WebDriver driver, long timeOutInSeconds) {
		return new WebDriverWait(driver, timeOutInSeconds);
	}

	public static int getVisibleElementCount(WebDriver driver, final By locator) {
		List<WebElement> list = driver.findElements(locator);
		int displayedCount = 0;
		for (WebElement elem : list) {
			if (elem.isDisplayed()) {
				displayedCount++;
			}
		}
		return displayedCount;
	}

	public static void blur(WebDriver driver, WebElement el) {
		StringBuilder sb = new StringBuilder();
		sb.append("var fireOnThis = arguments[0];");
		sb.append("var evObj = document.createEvent('MouseEvents');");
		sb.append("evObj.initEvent( 'blur', true, true );");
		sb.append("fireOnThis.dispatchEvent(evObj);");
		((JavascriptExecutor) driver).executeScript(sb.toString(), el);
	}

	public static Object getPageHTML(WebDriver driver) {
		String code = "var htmlTag=document.getElementsByTagName('html')[0].innerHTML;return htmlTag;";
		return ((JavascriptExecutor) driver).executeScript(code, new Object[] { null });
	}

	public static Object getInnerHTML(WebDriver driver, WebElement el) {
		String code = "var htmlTag=arguments[0].innerHTML;return htmlTag;";
		return ((JavascriptExecutor) driver).executeScript(code, el);
	}

	public static void mouseUp(WebDriver driver, WebElement el) {
		String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'mouseup', true, true );" + "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, el);
	}

	public static void mouseDown(WebDriver driver, WebElement el) {
		String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'mousedown', true, true );" + "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, el);
	}

	public static void mouseOver(WebDriver driver, WebElement el) {
		String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'mouseover', true, true );" + "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, el);
	}

	public static void scrollIntoView(WebDriver driver, WebElement el) {
		String code = "var obj = arguments[0];" + "obj.scrollIntoView(true);";
		((JavascriptExecutor) driver).executeScript(code, el);
	}

	private static String getPageState(WebDriver driver) {
		WebElement el = driver.findElement(By.cssSelector("body"));
		String code = "return document.readyState";
		String result = (String) ((JavascriptExecutor) driver).executeScript(code, el);
		logger.info("[page load state]:" + result);
		return result;
	}

	public static void waitForPageToLoad(WebDriver driver) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				String status = getPageState(driver);
//				if (Util.getBrowserType().equalsIgnoreCase("firefox")) {
//					return status.equals("complete") || status.equals("interactive");
//				} else {
//					return status.equals("complete");
//				}
				return status.equals("complete");
			}
		};
		createWait(driver).until(waitFn);
	}

	public static void mouseLeave(WebDriver driver, WebElement el) {
		String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'mouseout', true, true );" + "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, el);
	}

	public static void jsClick(WebDriver driver, WebElement el) {
		String code = "var fireOnThis = arguments[0];" + "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initEvent( 'click', true, true );" + "fireOnThis.dispatchEvent(evObj);";
		((JavascriptExecutor) driver).executeScript(code, el);
	}

	public static void dragAndDropOffset(WebDriver driver, WebElement el, int offsetX, int offsetY) {
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(el, offsetX, offsetY).build().perform();
	}

	public static void dragAndDropToElementContainner(WebDriver driver, WebElement source, WebElement target) {
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).build().perform();

	}

	

	public static String getBrowserName(WebDriver driver) {
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		return caps.getBrowserName();
	}

	public static String getInnerText(WebDriver driver, WebElement e) {
		String code = "return arguments[0].innerText || arguments[0].textContent;";
		return (String) ((JavascriptExecutor) driver).executeScript(code, e);
	}

	public static Object runJs(WebDriver driver, String js, Object[] args) {
		return ((JavascriptExecutor) driver).executeScript(js, args);
	}

	public static String scrollBottom(WebDriver driver, WebElement e) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String code = "var obj = arguments[0]; obj.scrollTop = obj.scrollHeight";
		return (String) ((JavascriptExecutor) driver).executeScript(code, e);
	}

	public static String scrollTop(WebDriver driver, WebElement e) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		String code = "var obj = arguments[0]; obj.scrollTop = 0";
		return (String) ((JavascriptExecutor) driver).executeScript(code, e);
	}

	public static void doubleClick(WebDriver driver, By by) {
		Actions doubleClick = new Actions(driver);
		doubleClick.doubleClick(driver.findElement(by)).perform();
	}

	public static void doubleClick(WebDriver driver, WebElement el) {
		Actions doubleClick = new Actions(driver);
		doubleClick.doubleClick(el).perform();
	}

	public static void doubleClick(WebDriver driver, By by, WebElement context) {
		Actions doubleClick = new Actions(driver);
		doubleClick.doubleClick(context.findElement(by)).perform();
	}

	public static void hover(WebDriver driver, WebElement el) {
		Actions action = new Actions(driver);
		action.moveToElement(el).build().perform();
	}

	public static boolean isTextPresent(WebDriver driver, String text) {
		try {
			return driver.getPageSource().contains(text);
		} catch (Exception e) {
			return false;
		}
	}

	public static void waitForTextPresent(WebDriver driver, final String text, final int seconds) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				return SeleniumUtil.isTextPresent(driver, text);
			}
		};
		WebDriverWait wait = createWait(driver);
		wait.withMessage("This text is not present:" + text);
		wait.until(waitFn);

	}

	public static void waitForTextPresent(WebDriver driver, final String text) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				return SeleniumUtil.isTextPresent(driver, text);
			}
		};
		WebDriverWait wait = createWait(driver);
		wait.withMessage("This text is not present:" + text);
		wait.until(waitFn);

	}

	public static void waitForTextNotPresent(WebDriver driver, final String text, int seconds) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				return !SeleniumUtil.isTextPresent(driver, text);
			}
		};
		WebDriverWait wait = createWait(driver);
		wait.withMessage("This text should not be present:" + text);
		wait.until(waitFn);
	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	public static void closeAlert(WebDriver driver, boolean acceptAlert) {
		Alert alert = driver.switchTo().alert();
		if (acceptAlert) {
			alert.accept();
		} else {
			alert.dismiss();
		}
	}

	private static ExpectedCondition<Boolean> noActiveConnections = new ExpectedCondition<Boolean>() {
		
		public Boolean apply(WebDriver driver) {
			JavascriptExecutor jsExec = (JavascriptExecutor) driver;
			return (Boolean) jsExec.executeScript(JQUERY_ACTIVE_CONNECTIONS_QUERY);
		}
	};

	public static boolean waitUntilAllAjaxRequestCompletes(WebDriver driver) {
		Boolean status = false;
		try {
			status = SeleniumUtil.createWait(driver).until(noActiveConnections);
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public static boolean waitUntilAllAjaxRequestCompletes(WebDriver driver, int seconds) {
		Boolean status = false;
		try {
			status = SeleniumUtil.createWait(driver, seconds).until(noActiveConnections);
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public static void waitForElementRefreshed(WebDriver driver, WebElement element, int seconds) {
		SeleniumUtil.createWait(driver, seconds).withMessage("This element is not refreshed.")
				.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

	public static void waitForElementRefreshed(WebDriver driver, WebElement element) {
		SeleniumUtil.createWait(driver).until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	}

	public static void waitForElementValueToBeChanged(WebDriver driver, final By locator, int seconds,
			final String oldValue) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				try {
					return !driver.findElement(locator).getText().equals(oldValue);
				} catch (Exception e) {
				}
				return false;
			}
		};
		SeleniumUtil.createWait(driver, seconds)
				.withMessage("The value of this element:" + locator.toString() + " is not changed.").until(waitFn);
	}

	public static void waitForElementValueToBeChanged(WebDriver driver, final WebElement context, final By locator,
			int seconds, final String oldValue) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				try {
					return !context.findElement(locator).getText().equals(oldValue);
				} catch (Exception e) {

				}
				return false;
			}
		};
		SeleniumUtil.createWait(driver, seconds)
				.withMessage("The value of this element:" + locator.toString() + " is not changed.").until(waitFn);
	}

	public static void waitForElementValueToBeChanged(WebDriver driver, final By locator, final String oldValue) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				try {
					return !driver.findElement(locator).getText().equals(oldValue);
				} catch (Exception e) {

				}
				return false;
			}
		};
		SeleniumUtil.createWait(driver)
				.withMessage("The value of this element:" + locator.toString() + " is not changed.").until(waitFn);
	}

	public static void waitForElementValueToBeChanged(WebDriver driver, final WebElement context, final By locator,
			final String oldValue) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				try {
					return !context.findElement(locator).getText().equals(oldValue);
				} catch (Exception e) {

				}
				return false;
			}
		};
		SeleniumUtil.createWait(driver)
				.withMessage("The value of this element:" + locator.toString() + " is not changed.").until(waitFn);
	}

	public static void waitForTextToBePresentInElement(WebDriver driver, By locator, int seconds, String text) {
		SeleniumUtil.createWait(driver, seconds)
				.withMessage("The text[" + text + "] is not in elment:" + locator.toString())
				.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public static void waitForTextToBePresentInElement(WebDriver driver, By locator, String text) {
		SeleniumUtil.createWait(driver).withMessage("The text[" + text + "] is not in elment:" + locator.toString())
				.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}

	public static String getSelectVal(WebDriver driver, By by) {
		Select ddl = new Select(driver.findElement(by));
		String curVal = ddl.getFirstSelectedOption().getText();
		return curVal;
	}

	public static void SetSelectVal(WebDriver driver, By by, String value) {
		Select ddl = new Select(driver.findElement(by));
		ddl.selectByVisibleText(value);
	}
	
	public static void SetSelectVal(WebElement webElement, String value) {
		Select ddl = new Select(webElement);
		ddl.selectByVisibleText(value);
	}

	// Add methods to compare image
	public static byte[] takeScreenshot(WebDriver driver) throws IOException {
		WebDriver augmentedDriver = new Augmenter().augment(driver);
		return ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BYTES);
	}

	
	public static BufferedImage createElementImage(WebDriver driver, WebElement webElement) throws IOException {
		Point location = webElement.getLocation();
		Dimension size = webElement.getSize();

		BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(takeScreenshot(driver)));
		BufferedImage croppedImage = originalImage.getSubimage(location.getX(), location.getY(), size.getWidth(),
				size.getHeight());
		return croppedImage;
	}

	public static void screenshotByElement(WebDriver driver, WebElement el, String imagePath) {
		BufferedImage image = null;
		try {
			image = createElementImage(driver, el);
			File file = new File(imagePath);
			if (file.exists()) {
				file.delete();
			}
			ImageIO.write(image, "PNG", new File(imagePath));
		} catch (Exception e) {
			logger.error("[SeleniumUtil--screenshotByElement]--" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static boolean findImageByElement(WebDriver driver, final WebElement el, final String standardImagePath) {
		// Check if the standard image exist
		File file = new File(standardImagePath);
		if (!file.exists()) {
			logger.error("[SeleniumUtil--findImageByElement]--The standard image doesn't exit...");
			return false;
		}

		BufferedImage expectedImage = null;
		BufferedImage actualIamge = null;
		try {
			expectedImage = ImageIO.read(new FileInputStream(file));
			actualIamge = createElementImage(driver, el);
			if (image.compareImage(actualIamge, expectedImage)) {
				return true;
			} else {
				return false;
			}

		} catch (IOException e) {
			logger.error("[SeleniumUtil--findImageByElement]--" + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	public static void waitForElementImageVisible(WebDriver driver, final WebElement el, final String standardImagePath) {

		// Check if the standard image exist
		File file = new File(standardImagePath);
		if (!file.exists()) {
			throw new RuntimeException("[SeleniumUtil--waitForElementImageVisible]--The standard image doesn't exit...");
		}

		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			
			public Boolean apply(WebDriver driver) {
				if (findImageByElement(driver, el, standardImagePath)) {
					return true;
				}
				return false;
			}
		};
		WebDriverWait wait = createWait(driver);
		wait.withMessage("Cann't find the image element in current page: " + standardImagePath).until(waitFn);
	}

	public static WebElement waitforElementToBeClickable(WebDriver driver, final By locator, int timeWaitSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeWaitSec);
		return wait.withMessage("Cannot wait for Element to be clickable: " + locator.toString()).until(
				ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement waitforElementToBeClickable(WebDriver driver, final WebElement element, int timeWaitSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeWaitSec);
		return wait.withMessage("Cannot wait for Element to be clickable").until(
				ExpectedConditions.elementToBeClickable(element));
	}

		public static boolean waitforElementToBeSelectable(WebDriver driver, final By locator, int timeWaitSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeWaitSec);
		return wait.withMessage("Cannot wait for Element to be clickable: " + locator.toString()).until(
				ExpectedConditions.elementToBeSelected(locator));
	}

	public static boolean waitforElementToBeSelectable(WebDriver driver, final WebElement element, int timeWaitSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeWaitSec);
		return wait.withMessage("Cannot wait for Element to be clickable").until(
				ExpectedConditions.elementToBeSelected(element));
	}

}
