package com.amazon;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public  class ExtentManager {
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;


	  @Test
	  
	  public static ExtentReports getInstance() {
		  if (htmlReport == null) {
				new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports.html\\reports.html");
				System.getProperty("user.dir");
				htmlReport.config().setDocumentTitle("Automation Report");
				htmlReport.config().setReportName("functional Report");
				htmlReport.config().setTheme(Theme.DARK);

				report = new ExtentReports();
				report.attachReporter(htmlReport);
				report.setSystemInfo("OS", "Windows10");
				report.setSystemInfo("TesterName", "Pradeeep");
				report.setSystemInfo("Browser", "chrome");
	  }
	  
	  return report;
	  
	  }
}
