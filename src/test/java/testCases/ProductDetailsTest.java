package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.HomePage;
import pageElement.ProductPage;
import pageElement.SearchPage;

public class ProductDetailsTest extends BaseClass{


	@Test(groups= {"loginUser","guestUser"})
	public void verify_ProductDetails() {
		try {
			String searchValue = "Pink And Red Twin";
		HomePage home = new HomePage(driver);
		Thread.sleep(500);
		home.SearchBtn(searchValue);
		logger.info("*************Search Value Entered***************");
		
		SearchPage search = new SearchPage(driver);
		search.clickSearchItem();
		logger.info("*************Search product clicked***************");
		
		ProductPage product = new ProductPage(driver);
		String itemTitle = product.getItemTitle();
		logger.info("*************Product title copied***************");
		System.out.println(itemTitle);
		
		Assert.assertEquals(itemTitle, searchValue);
		logger.info("*************Verified Product Title ***************");
		
		String price = product.getProductPrice();
		System.out.println(price);
		Assert.assertFalse(price.isEmpty());
		logger.info("*************Verified Product Price not Empty ***************");
		
		String discribtion = product.getDiscribtion();
		Assert.assertFalse(discribtion.isEmpty());
		logger.info("*************Verified Product Discribtion not Empty ***************");
		
		}
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			logger.info("***********Code Fails***********");
		}
	}
}
