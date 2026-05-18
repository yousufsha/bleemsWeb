package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.CartPage;
import pageElement.HomePage;
import pageElement.ProductPage;
import pageElement.SearchPage;

public class CheckoutTest extends BaseClass{
	
	String searchValue = "Mille Foglie Raspberry";
	
//	String searchValue = "Dishdasha Cake";
	@Test(groups= {"loginUser","guestUser"})
	public void verify_CheckoutPrice() {
		try {
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
		logger.info("*************Verified Product Title ***************");
		
		String productPrice = product.getProductPrice();
		Assert.assertFalse(productPrice.isEmpty());
		System.out.println(productPrice);
		logger.info("*************Verified Product Price not Empty ***************");
		
		String discribtion = product.getDiscribtion();
		Assert.assertFalse(discribtion.isEmpty());
		logger.info("*************Verified Product Discribtion not Empty ***************");
		
		product.selectAddress();
		logger.info("***********Send button clicked*************");
		
		product.selectSavedAdderss();
		logger.info("********* Address Selected ***********");
		Thread.sleep(500);
		
		product.clickDate();
		product.selectDateAndTime();
		logger.info("********* Date Selected ******************");
		
		product.clickSendBtn();
		
		CartPage cart = new CartPage(driver);
		String cartPrice = cart.getCartPrice();
		Assert.assertEquals(productPrice, cartPrice);
		
		String totalCartPrice = cart.getTotalCartPrice();
		System.out.println(totalCartPrice);
		
		cart.clickCheckoutBtn();
		logger.info("************* Checkout button clicked **************");
		
		String checkoutPrice = cart.getCheckoutPrice();
		Assert.assertEquals(checkoutPrice, totalCartPrice);
		
		cart.selectKnet();
		logger.info("************* Knet Selected **************");
		
		
		cart.ClickPayBtn();
		
		Assert.assertTrue(true);
		logger.info("************* Verified Checkout successfull *************");
		
		}
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			logger.info("***********Code Fails***********");
		}
	}
	

}
