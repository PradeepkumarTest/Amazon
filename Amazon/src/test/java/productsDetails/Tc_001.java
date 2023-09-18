package productsDetails;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Tc_001 extends BaseTest1 {
	public page1 ajio;
	public page2 ajio1;

	@Test
	public void JoggersOrder() throws Exception {

		WebIntialize();
		ajio = new page1(driver);
		ajio.typeInSerchbox();

		ajio.submit();

		ajio1 = new page2(driver);

		ajio1.joggersSelection();

		ajio1.getsize();
		ajio1.addtoBag();

		ajio1.TeamSpirit();
		ajio1.size30();
		ajio1.addtoBag();

		Thread.sleep(1000);

		ajio1.mousehover();

		ajio1.deleteproducts();

		Thread.sleep(3000);
		ajio1.continueshoppingcart();

		ajio.typeInSerchbox();

		ajio.submit();

		ajio1.joggersSelection();

		ajio1.size30();
		ajio1.addtoBag();

	}

}
