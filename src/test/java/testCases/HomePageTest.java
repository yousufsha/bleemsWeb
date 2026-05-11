package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.HomePage;

public class HomePageTest extends BaseClass{

	@Test
	public void verify_HomePageElements() {
		try {
		HomePage home = new HomePage(driver);
		Thread.sleep(200);
		
		String endText = home.getEndText();
		System.out.println(endText);
		Assert.assertEquals(endText, "Take Bleems with you");
		logger.info("*************verified Homepage Loaded**************");
		}
		catch(Exception e) {
		System.out.println(e);
		Assert.assertFalse(true);
		logger.info("**********Code fail*********");
		}
		
		
	}
}
