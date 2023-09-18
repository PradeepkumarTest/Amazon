package productsDetails;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest1 {

	public static WebDriver driver;
	public Properties app;

	public WebDriver WebIntialize() throws Exception {

		File projectpath = new File(System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream(projectpath + "\\src\\test\\resources\\app.properties");

		app = new Properties();

		app.load(fis);

		String browserName = app.getProperty("browser");
		if (browserName.equals("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();

		}
		driver.get(app.getProperty("url"));
		driver.manage().window().maximize();
		return driver;

	}

	
	

}
