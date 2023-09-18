package com.GMOOnline;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GMOData extends BaseTest {
	
	@Test
	public void doLogin() throws Exception {
		System.out.println("doLogin");
		// test.log(Status.INFO, "doLogin");
		app.openBrowser("chromebrowser");
		app.navigateUrl("gmourl");

		app.clickElement("enter_name");
		app.typeText("paddedsocks_name","orderquantity_name");
		
		app.clickElement("placeAnOrder_name");
		
		app.getText("Totlaprice_xpath");
		app.TotalPriceValidation("Totlaprice_xpath");
	
		app.clickElement("proceedwithOrder_name");
		
	
		// app.typeText("useremail_id", "rediffuser");
		// app.typeText("userpassword_id", "rediffpassword");
		// app.clickElement("loginsubmit_id");

	}

}
