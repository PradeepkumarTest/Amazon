package ToolsQAPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMAlerts {

	public WebDriver driver;

	public POMAlerts(WebDriver driver) {
	this.driver=driver;
	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="alertButton")
	public WebElement NormalAlert;
	
	@FindBy(id="timerAlertButton")
	public WebElement NormalAlert1;
	
	@FindBy(id="confirmButton")
	public WebElement confirm;
	
	@FindBy(id="promtButton")
	public WebElement prompt;
	
	@FindBy(id="confirmResult")
	public WebElement confirmResult;
	
	
	@FindBy(id="promptResult")
	public WebElement promptResult;
	
	
	
	
	
	
	
}
