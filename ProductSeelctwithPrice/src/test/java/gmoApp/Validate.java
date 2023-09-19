package gmoApp;

import org.testng.annotations.Test;

import ToolsQAPOM.POMAlerts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
public class Validate extends LibraryData {

	@Test(priority = 0)
	public void LaunchQAApp() {
		System.out.println("Launching QA App :");

		driver.get(p.getProperty("QAUrl"));
		String Title = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, p.getProperty("QATitle"));

	}

	@Test(priority = 1)
	public void validateNormalAlert() {
		System.out.println("Normal Alert...");
		POMAlerts Objpomalert = new POMAlerts(driver);
		Objpomalert.NormalAlert.click();

		Alert alert = driver.switchTo().alert();
		String alertmessageTitle = alert.getText();
		Assert.assertEquals(alertmessageTitle, p.getProperty("AlertTitle"));
		alert.accept();

	}

	@Test(priority = 2)
	public void validateNormalAlert1() throws Exception {
		System.out.println("Normal Alert1...");
		POMAlerts Objpomalert = new POMAlerts(driver);
		Objpomalert.NormalAlert1.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());

		Alert alert = driver.switchTo().alert();
		String Title = alert.getText();
		Assert.assertEquals(Title, p.getProperty("TimeAlert"));
		alert.accept();

	}

	@Test(priority = 3)
	public void validateConfirmBox() throws Exception {
		System.out.println("confirm box...");
		POMAlerts Objpomalert = new POMAlerts(driver);
		Objpomalert.confirm.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertmessageTitle = alert.getText();
		Assert.assertEquals(alertmessageTitle, p.getProperty("confirmalert"));
		alert.accept();
		
		Assert.assertEquals(Objpomalert.confirmResult.getText(), p.getProperty("confirmResult"));

	}

	@Test(priority = 4)
	public void validatePromptBox() throws Exception {
		System.out.println("prompt box Alert...");
		POMAlerts Objpomalert = new POMAlerts(driver);
		Objpomalert.prompt.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		String alertmessageTitle = alert.getText();
		Assert.assertEquals(alertmessageTitle, p.getProperty("promptalert"));
	alert.sendKeys(p.getProperty("promptresultText"));
	alert.accept();
	
	String promptboxtext=Objpomalert.promptResult.getText();

	Assert.assertEquals(promptboxtext, p.getProperty("promptresult"));
		
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("launch browser inside before Test");
		try {
			LaunchBrowser();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() throws Exception {
		System.out.println("Read propertyfile inside Beforesuit");
		ReadProperyFile();
	}

	@AfterSuite
	public void afterSuite() {
	}

}
