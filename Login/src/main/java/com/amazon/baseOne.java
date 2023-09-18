package com.amazon;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class baseOne {
	public static WebDriver driver;
	public static FileInputStream fis;

	public static Properties p;
	public static ExtentReports rep;
	public static ExtentTest test;
	
	public  static void init() throws IOException {
		 
			fis = new FileInputStream(System.getProperty("user.dir") + "\\FilesData\\Driver.Properties");
			
			p= new Properties();

			p.load(fis);
			
			
			fis=new FileInputStream("C:\\Users\\prash\\eclipse-workspace\\Login\\src\\main\\resources\\log4j.properties");
			PropertyConfigurator.configure(fis);
			
			rep=ExtentManager.getInstance();
			
		
	}
	public static void browserLaunch() throws Exception {

		

		String browserName = p.getProperty("browser");

		if (browserName.equals("chrome")) {
			
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();

		}

		
		driver.get("https://demo.borland.com/gmopost/");
		driver.manage().timeouts().getPageLoadTimeout();
		Duration.ofSeconds(10);
		driver.manage().window().maximize();

	}
	// screen shots

	public void screenshots() throws Exception {
		Date d = new Date();

		String FileName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File newsrc = screenshot.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(newsrc,
				new File(System.getProperty("user.dir") + "\\screenshots\\" + FileName));
	}

}
