package test;

import java.util.Hashtable;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.TestBase;
import utilities.TestUtil;

public class Test_Signup extends TestBase {

	// String totalCount;
	boolean signin = true;

	@Test(dataProviderClass = TestUtil.class, dataProvider = "dp")
	public void test_signup(Hashtable<String, String>data) throws InterruptedException {

		if (signin == true) {
			Click(By.linkText(or.getProperty("Sign_In")));
			Thread.sleep(3000);
			signin = false;
		}
	
		SendKeys(By.id(or.getProperty("CREATE_EMAIL")), data.get("RegEmail"));

		Click(By.id(or.getProperty("SUBMIT")));
		Thread.sleep(3000);

		SendKeys(By.id(or.getProperty("CX_FIRSTNAME")), data.get("CXFirstname"));

		SendKeys(By.id(or.getProperty("CX_LASTNAME")), data.get("CXLastname"));

		SendKeys(By.id(or.getProperty("REG_PASS")), data.get("CXPassword"));

		Click(By.xpath(or.getProperty("DATE")));

		Click(By.xpath(or.getProperty("MONTH")));

		Click(By.xpath(or.getProperty("YEAR")));

		SendKeys(By.id(or.getProperty("ADDRESS")), data.get("CXAddress"));

		SendKeys(By.id(or.getProperty("CITY")), data.get("City"));

		Click(By.xpath(or.getProperty("STATE")));

		SendKeys(By.id(or.getProperty("ZIP")), data.get("ZIP"));

		SendKeys(By.id(or.getProperty("NUMBER")), data.get("Mobile"));

		SendKeys(By.id(or.getProperty("ALIAS")), "This is my alias");

		Click(By.xpath(or.getProperty("REGISTER")));
		Thread.sleep(1000);
	
		Click(By.linkText(or.getProperty("SIGN_OUT")));
		Thread.sleep(2000);
		log.debug("Successfully Sign out");
		
	}

}// class