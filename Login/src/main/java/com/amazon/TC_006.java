package com.amazon;



import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

;

public class TC_006 extends baseOne {
	public WebDriver driver;
	

	public static final Logger log = Logger.getLogger(TC_006.class);

	@Test
	public void m1() throws Exception {

		init();
		//log.info("init the properties files.......");
		test=rep.createTest("intialize properties file");
		test.log(Status.INFO,"initialize property files");
		
		
		
		browserLaunch();
		test.log(Status.INFO,"openingBrowser:"+p.getProperty("chrome browserLAunch"));
		//log.info("opening browser:"+p.getProperty("chromeBrowser"));
		screenshots();
		rep.flush();
	}

}
