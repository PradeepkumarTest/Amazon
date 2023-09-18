package com.GMOOnline;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.ApplictionKeywords.ApplicationKeywords;

public class BaseTest {
	ApplicationKeywords app;
	
	@BeforeTest
	public void beforetest(ITestContext context) throws Exception
	{
		System.out.println("beforetest");
		app = new ApplicationKeywords();
		context.setAttribute("app", app);
		
		//init the eReportingfor the Test
		//rep = ExtentManager.getInstance();
		//test = rep.createTest(context.getCurrentXmlTest().getName());
		//test.log(Status.INFO, "Starting the Test : " + context.getCurrentXmlTest().getName());
		//app.setReport(test);
		
		//context.setAttribute("report", rep);
		//context.setAttribute("test", test);
	}
	
	@BeforeMethod
	public void beforeMethod(ITestContext context)
	{
		System.out.println("BeforeMethod");
		app = (ApplicationKeywords)context.getAttribute("app");
		//rep = (ExtentReports)context.getAttribute("report");
		//test = (ExtentTest)context.getAttribute("test");
	}
	
	}


