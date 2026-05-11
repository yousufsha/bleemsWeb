package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import pageElement.HomePage;

public class LoginTest extends BaseClass {
	
	@Test
	public void verify_login() {
		
		try {
		
		HomePage home = new HomePage(driver);
		
		home.clickAccountBtn();
		
		logger.info("*************Account button is clicked*****************");
		
		boolean checkVisiblityMyAccount = home.checkVisiblityMyAccount();
		Assert.assertTrue(checkVisiblityMyAccount);
		logger.info("*************logged in Verified*****************");
		}
		
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
		}
		
	}

}
