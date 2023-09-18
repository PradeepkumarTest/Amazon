package gmoApp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApplicationFormofGMO extends LibraryData{

	@Test(priority = 0)
	public void GmoOnlineAppOpen() throws Exception {

		driver.get(p.getProperty("DmoUrl"));
		String title = driver.getTitle();
		System.out.println("title:" + title);
		Assert.assertEquals(title, p.getProperty("GmoTitle"));

	}

	@Test(priority = 1, dependsOnMethods = { "GmoOnlineAppOpen" })
	public void EnterGmoOnline() throws Exception {

		driver.findElement(By.name("bSubmit")).click();
		String title = driver.getTitle();
		System.out.println("title:" + title);

		Assert.assertEquals(title, p.getProperty("catalog"));

	}

	@Test(priority=2,dependsOnMethods = {"EnterGmoOnline"})
	public void PalceAnOrder() {
		System.out.println("this is a place ana order..");
		driver.findElement(By.name("QTY_BACKPACKS")).sendKeys("3");
		driver.findElement(By.name("bSubmit")).click();

		String title = driver.getTitle();
		System.out.println("title:" + title);

		Assert.assertEquals(title, p.getProperty("order"));

		String unitPriceOFExternal = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[4]")).getText();

		System.out.println("unitPriceOFExternal:" + unitPriceOFExternal);

		Float floatFormatunitprice = Float.parseFloat(unitPriceOFExternal.substring(2).trim());
		System.out.println("floatFormatunitprice:" + floatFormatunitprice);

		String TotalpriceOfExternal = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[5]")).getText();

		System.out.println("TotalpriceOfExternal" + TotalpriceOfExternal);

		Float floatformatTotalprice = Float.parseFloat(TotalpriceOfExternal.substring(2).trim());
		System.out.println("floatformatTotalprice" + floatformatTotalprice);

		float calcualatedFromatedprice = floatFormatunitprice*3;
		
		System.out.println("calcualatedFromatedprice:"+calcualatedFromatedprice);
		
		

		
		
		
		
	}
	
	

	@Test(priority=3,dependsOnMethods = {"PalceAnOrder"})
	public void ProceedWithOrder() {
		System.out.println("this is a proceed with order..");
		driver.findElement(By.name("bSubmit")).click();
		String Title=driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals(Title,p.getProperty("proceedWithorderBilling"),"both values are matched");
		
		driver.findElement(By.name("billName")).sendKeys(p.getProperty("Name"));
		driver.findElement(By.name("billAddress")).sendKeys(p.getProperty("Address"));
	
		
		driver.findElement(By.name("billCity")).sendKeys(p.getProperty("City"));
		
		driver.findElement(By.name("billState")).sendKeys(p.getProperty("State"));
		
		driver.findElement(By.name("billZipCode")).sendKeys(p.getProperty("Zip"));
		
		driver.findElement(By.name("billPhone")).sendKeys(p.getProperty("Phone"));
		
		driver.findElement(By.name("billEmail")).sendKeys(p.getProperty("Email"));

		WebElement Creditcard = driver.findElement(By.name("CardType"));
		Select s = new Select(Creditcard);

		 s.selectByVisibleText(" MasterCard ");
		//s.selectByValue("MasterCard");

		driver.findElement(By.name("CardNumber")).sendKeys(p.getProperty("CardNumber"));
		//

		driver.findElement(By.name("CardDate")).sendKeys(p.getProperty("Expiration"));

		driver.findElement(By.name("shipSameAsBill")).click();

		driver.findElement(By.name("bSubmit")).click();
		
		driver.findElement(By.name("bSubmit")).click();
		
	}

	@BeforeTest
	public void BeforeTest() throws Exception {
		LaunchBrowser();
	}

	@BeforeSuite
	public void BeforeSuit() throws Exception {
		ReadProperyFile();
	}

}
