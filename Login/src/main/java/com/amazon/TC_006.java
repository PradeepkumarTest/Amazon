package com.amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class clickDemo extends ExtentManager {
	public WebDriver driver;
	public ExtentTest test;
	public ExtentReports extent;
	public FileInputStream fis;
	public static ExtentReports repo;
	public static ExtentTest test1;
	

	public static Logger logger = Logger.getLogger(clickDemo.class);

	@Test
	public void extentReportsDemo() {

		extent = new ExtentReports();

		test = extent.createTest("My first test case");
	}

	@Test
	public void screenshots() throws Exception {
		Date d = new Date();

		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		String filepath = "";
		File newsrc = screenshot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(newsrc, new File(System.getProperty("user.dir") + "\\screenshots\\" + FileName));
	}

	

	 

	@Test
	public void m1() throws Exception {



  
	
		driver = new ChromeDriver();
		

		driver.get("https://demo.borland.com/gmopost/");
		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.properties");
		PropertyConfigurator.configure(fis);
		
		test.log(Status.INFO, "chrome browser launch");
		// Logger.info("launching chrome browser:" + driver.getCurrentUrl());

		driver.manage().window().maximize();
		
		screenshots();
		String title = driver.getTitle();
		repo=ExtentManager.getInstance();
		
		test1=repo.createTest("m1 test");
		test1.log(Status.INFO, " intially invoke the chrome browser ");
		// logger.info("get title :" + driver.getTitle());
		test1.log(Status.INFO, " Naviaget to url:");
		// log.info("launching chrome browser:");
		repo.flush();

	}
	}
