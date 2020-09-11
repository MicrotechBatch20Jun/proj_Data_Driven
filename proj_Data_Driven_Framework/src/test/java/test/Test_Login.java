package test;

import java.util.Hashtable;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestUtil;
import base.TestBase;

public class Test_Login extends TestBase {
	
	//String totalCount;
	boolean SignInFlag=true;
	
	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	void test_login(Hashtable<String,String> data )  throws InterruptedException {
		if (SignInFlag==true) {
			Click(By.linkText(or.getProperty("Sign_In")));
			Thread.sleep(2000);
			SignInFlag=false;
		}
			
		SendKeys(By.xpath(or.getProperty("EMAIL_ADDRESS")), data.get("Email"));
	
		SendKeys(By.xpath(or.getProperty("PASSWORD")), data.get("Password"));
		
		Click(By.xpath(or.getProperty("SUBMIT_LOGIN")));
		Thread.sleep(2000);
		
		Click(By.linkText(or.getProperty("SIGN_OUT")));
		Thread.sleep(2000);
		log.debug("Successfully Sign out");
		
		boolean verify_log_in_form = isDisplayed(By.id(or.getProperty("LOG_IN_FORM")));
		Assert.assertEquals(verify_log_in_form, true);
	
	}
	
}//class


