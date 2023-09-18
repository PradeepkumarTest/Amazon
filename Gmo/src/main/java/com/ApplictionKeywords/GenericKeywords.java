package com.ApplictionKeywords;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import dev.failsafe.Timeout;

public class GenericKeywords {

	public String projectPath = System.getProperty("user.dir");
	public FileInputStream fis;
	public Properties mainprop;
	public Properties childProp;
	public WebDriver driver;
	public Properties p;
	public String actual;
	public String expected;

	public void openBrowser(String browserName) {

		if (p.getProperty(browserName).equals("chrome")) {
			driver = new ChromeDriver();
		} else if (p.getProperty(browserName).equals("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();

	}

	public void navigateUrl(String url) {
		driver.get(p.getProperty(url));
	}

	public void clickElement(String locatorKey) {
		getElement(locatorKey).click();
		// driver.findElement(By.cssSelector(locatorKey)).click();
	}

	public void typeText(String locatorKey, String textKey) {
		getElement(locatorKey).sendKeys(p.getProperty(textKey));
	}

	public void selectOption(String locatorKey, String textKey) {
		getElement(locatorKey).sendKeys(p.getProperty(textKey));
	}

	
	public void TotalPriceValidation(String locatorKey) {
		String text=getText(locatorKey);
		String Actualvalue=text.substring(2).trim();
		String expected = "39.98";
		System.out.println("these are after comapring values of actual n expected values of totalprices :"+Actualvalue+"....."+expected);

		if (Actualvalue.equals(expected)) {
			System.out.println("both are equal");
		} else {
			System.out.println("both are not equal");
		}
	}
	public String getText(String locatorKey) {
		String getText = getElement(locatorKey).getText();
		
		return getText;

	}

	public WebElement getElement(String locatorKey) {
		WebElement element = null;

		// check for Element Present
		if (!isElementPresent(locatorKey))
			// report as failure
			System.out.println("Element is not Present : " + locatorKey);

		element = driver.findElement(getLocator(locatorKey));
		return element;
	}

	public boolean isElementPresent(String locatorKey) {
		System.out.println("Checking for Element Presence: " + locatorKey);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));
		return true;
	}

	public By getLocator(String locatorKey) {
		By by = null;

		if (locatorKey.endsWith("_id")) {
			by = By.id(p.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_name")) {
			by = By.name(p.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_classname")) {
			by = By.className(p.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_xpath")) {
			by = By.xpath(p.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_css")) {
			by = By.cssSelector(p.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_linktext")) {
			by = By.linkText(p.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_partiallinktext")) {
			by = By.partialLinkText(p.getProperty(locatorKey));
		}

		return by;
	}

}
