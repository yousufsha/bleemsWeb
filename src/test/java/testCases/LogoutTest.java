package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import pageElement.HomePage;

public class LogoutTest extends BaseClass {

	@Test
	public void verify_Logout() {
		try {
			
			HomePage home = new HomePage(driver);
			
			home.clickAccountBtn();
			home.clickLogoutBtn();
			logger.info("*************logout button clicked***************");
			home.clickLoginbtn();
			
			boolean visiblityofContinueWithEmail = home.visiblityofContinueWithEmail();
			
			Assert.assertTrue(visiblityofContinueWithEmail);
			logger.info("*************Verified logout***************");
		}
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			
		}
		
		
	}
	
}
