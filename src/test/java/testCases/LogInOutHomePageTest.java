package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.HomePage;
import pageElement.SectionsTabs;

public class LogInOutHomePageTest extends BaseClass{

	@Test(groups= {"loginUser","guestUser"})
	public void verify_HomePageElements() {
		try {
		HomePage home = new HomePage(driver);
		SectionsTabs section = new SectionsTabs(driver); 
		
		home.clickAccountBtn();
		logger.info("*************Account button is clicked*****************");
		
		boolean checkVisiblityMyAccount = home.checkVisiblityMyAccount();
		softAssert.assertTrue(checkVisiblityMyAccount);
		home.clickAccountBtn();
		logger.info("************ log in Verified *****************");
		

		softAssert.assertTrue(section.TxtBleemsLogo(),"Bleems logo validation failed");
		softAssert.assertTrue(section.banner(), "Banner validation failed");
		softAssert.assertTrue(section.flowersSectionVisibility(),"Flower Section validation failed");
		softAssert.assertTrue(section.confectionsSectionVisibility());
		softAssert.assertTrue(section.giftsSectionVisibility());
		softAssert.assertTrue(section.toysSectionVisibility());
		softAssert.assertTrue(section.occasionsSectionVisibility());
		softAssert.assertTrue(section.shopSectionVisibility());
		section.verifyCustomRowTitles(softAssert);
		
		String endText = home.getEndText();
		System.out.println(endText);
		Assert.assertEquals(endText, "Take Bleems with you");
		logger.info("*************verified Homepage Loaded**************");
		
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
		logger.info("**********Code fail*********");
		}
		
		
	}
}
