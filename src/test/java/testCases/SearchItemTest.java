package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.HomePage;
import pageElement.ProductPage;
import pageElement.SearchPage;

public class SearchItemTest extends BaseClass {
	
	@Test(groups= {"loginUser","guestUser"})
	public void verify_itemSearch() {
		try {
			String searchValue = "Luxury Bouquet 150";
		HomePage home = new HomePage(driver);
		Thread.sleep(500);
		home.clickSearchBtn();
		logger.info("*************Search clicked***************");
		home.enterSearchTxt(searchValue);
		logger.info("*************Search Value Entered***************");
		
		SearchPage search = new SearchPage(driver);
		search.clickSearchItem();
		logger.info("*************Search product clicked***************");
		
		ProductPage product = new ProductPage(driver);
		String itemTitle = product.getItemTitle();
		logger.info("*************Product title copied***************");
		System.out.println(itemTitle);
		Assert.assertEquals(itemTitle, searchValue);
		logger.info("*************Verified Search Item***************");
		}
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			logger.info("***********Code Fails***********");
		}
	}
	
	

}
