package productsDetails;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class page1 {

	public WebDriver driver;

	public page1(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@placeholder='Search AJIO']")WebElement Searxhbox;

	@FindBy(xpath = "//button[@type='submit']")WebElement submitbtn;

	public void typeInSerchbox() {
		Searxhbox.sendKeys("joggers");

	}
	
	public void submit() {
		submitbtn.click();
	}

}
