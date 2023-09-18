import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class GmoOline extends Lib{
  @Test
  public void f() {
	  LaunchBrowser();
  }
  

  @BeforeSuite
  public void beforeSuite() {
	  
	  ReadProperyFile()
  }

  @AfterSuite
  public void afterSuite() {
  }

}
