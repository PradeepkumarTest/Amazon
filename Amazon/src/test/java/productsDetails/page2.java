package productsDetails;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class page2 {

	public WebDriver driver;
	public Alert al;
	public Actions a;

	public ArrayList<String> tabs;

	public page2(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "(//*[contains(text(),'City Shorts with Insert Pockets')])[4]")
	WebElement cityshorts;

	@FindBy(xpath = "(//*[contains(text(),'Shorts with Side Pockets')])[5]")
	WebElement DNMX;

	@FindBy(xpath = "(//div[@data-index='0'])[3]")
	WebElement size28;
	@FindBy(xpath = "(//div[@class='circle size-variant-item size-instock ']/span)[1]")
	WebElement xs;
	@FindBy(xpath = "(// div[@class='slick-initialized slick-slider size-swatch-slick'])/div/div/div")
	List<WebElement> SelectSize;

	@FindBy(css = "div.btn-gold span:nth-child(2)")
	WebElement AddToBag;

	@FindBy(css = "div.delete-btn")
	List<WebElement> DeleteAll;

	@FindBy(xpath = "//div[@class='popup-blk cart-blk']/a/div[@class='ic-cart ']")
	WebElement cart;

	@FindBy(css = "div.ic-cart ")
	WebElement cartbtn;

	@FindBy(xpath = "//div[@class='card-delete-button']//following-sibling::div")
	WebElement Deletebox;

	@FindBy(css = "div.mini-cart-btn")
	WebElement ProceedToBag;

	@FindBy(xpath = "(//div[@class='item rilrtl-products-list__item item']/a/div/div[2]/div[2])[7]")
	WebElement performax;

	@FindBy(css = "a.cart-shopping")
	WebElement continuingshopping;

	public void clickproceedTobag() {
		ProceedToBag.click();
	}

	public void clickPerformaxproduct() throws Exception {
		Thread.sleep(1000);
		performax.click();
	}

	public void continueshoppingcart() throws Exception {
		Thread.sleep(500);
		windowHandles();
		continuingshopping.click();
	}

	public void mousehover() throws Exception {
		a = new Actions(driver);
		a.moveToElement(cartbtn).perform();
		Thread.sleep(3000);
		clickproceedTobag();

	}

	public void joggersSelection() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-1000)");

		cityshorts.click();

	}

	public void TeamSpirit() throws Exception {
		Thread.sleep(5000);

		DNMX.click();

	}

	public void windowHandles() throws Exception {
		String mainwindow = driver.getWindowHandle();
		// Click on the element code goes here (This is in flash selenium)
		Set<String> windowhandles = driver.getWindowHandles();

		Iterator<String> itr = windowhandles.iterator();

		while (itr.hasNext()) {
			String ChildWindow = itr.next();
			if (!mainwindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);

			}

		}

	}

	public void getsize() throws Exception {
		windowHandles();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");

		size28.click();

	}

	public void size30() throws Exception {
		windowHandles();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		xs.click();
	}

	public void cart() {
		cart.click();

	}

	public void deleteproducts() throws Exception {
		
		try {
			for(WebElement Delete:DeleteAll) {
				Delete.click();
				Thread.sleep(1000);
				Deletebox();
			}
		}catch(StaleElementReferenceException e) {
			driver.navigate().refresh();
			for(WebElement Delete:DeleteAll) {
				Delete.click();
				Thread.sleep(1000);
				Deletebox();
			}
		}
		
			

	}

	private void Deletebox() {
		// TODO Auto-generated method stub

		Deletebox.click();
	}

	public void addtoBag() throws Exception {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AddToBag.click();
		Thread.sleep(1000);
		mousehover();
		Thread.sleep(1000);

		// Step 4: Switch to the new tab
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1)).close();
		driver.switchTo().window(tabs.get(0));
		driver.navigate().refresh();

	}

}
