package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.HomePage;
import pageElement.ProductPage;
import pageElement.SearchPage;

public class SearchTest extends BaseClass {

	@Test(groups= {"loginUser","guestUser"})
	public void Verify_SearchItem() {
		try {
			
			HomePage home = new HomePage(driver);
			
//			home.clickCartBtn();
//			logger.info("***********Cart clicked***********");
			
			Thread.sleep(500);
			home.clickSearchBtn();
			logger.info("***********Search clicked***********");
			home.enterSearchTxt("Love");
			logger.info("***********Search key inserted***********");

			SearchPage search = new SearchPage(driver);
			search.selectItem();
			logger.info("****************Item Clicked*****************");
			
			
			ProductPage product = new ProductPage(driver);
			boolean titleDisplayed = product.titleDisplayed();
			Assert.assertTrue(titleDisplayed);
			logger.info("****************Search Verified*****************");
		}
		
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
		}
		
		
		
		
	}
	
}
