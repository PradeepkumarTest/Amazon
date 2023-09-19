package gmoApp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LibraryData {
	public WebDriver driver;
	public Properties p;

	public void ReadProperyFile() throws Exception {
		try {
			FileInputStream f = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\Gmo.properties");
			p = new Properties();
			p.load(f);
		} catch (FileNotFoundException e) {

		}
	}

	public void LaunchBrowser() throws Exception {
		String browserName = p.getProperty("browser");
		switch (browserName) {

		case "chrome":
			driver = new ChromeDriver();
			
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("please give matching browser name:");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
}
