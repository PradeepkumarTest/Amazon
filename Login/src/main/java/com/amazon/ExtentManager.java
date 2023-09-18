package com.amazon;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends baseOne {
	public static ExtentHtmlReporter htmlReport;
	public static ExtentReports report;

	public static ExtentReports getInstance() {
		if (htmlReport == null) {

			htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\htmlReports\\report.html");

			htmlReport.config().setDocumentTitle("Automation Report");
			htmlReport.config().setReportName("functional Report");
			htmlReport.config().setTheme(Theme.STANDARD);

			report = new ExtentReports();
			report.attachReporter(htmlReport);
			report.setSystemInfo("OS", "Windows10");
			report.setSystemInfo("TesterName", "Pradeeep");
			report.setSystemInfo("Browser", "chrome");
		}

		return report;

	}
}
