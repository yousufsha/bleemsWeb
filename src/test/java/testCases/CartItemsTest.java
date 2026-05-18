package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.CartPage;
import pageElement.HomePage;
import pageElement.ProductPage;
import pageElement.SearchPage;

public class CartItemsTest extends BaseClass{

	@Test(groups = {"loginUser", "guestUser"})
	public void verify_CartItemsTest() {
		try {	
			String item1 = "Bint Al Jannah";
			
			HomePage home = new HomePage(driver);
			Thread.sleep(500);
			
			home.clickSearchBtn();
			logger.info("*************Search clicked***************");
			home.enterSearchTxt(item1);
			logger.info("*************Search Value Entered***************");
			
			SearchPage search = new SearchPage(driver);
			search.clickSearchItem();
			logger.info("*************Search product clicked***************");
			
			ProductPage product = new ProductPage(driver);
			String itemTitle = product.getItemTitle();
			logger.info("*************Product title copied***************");
			System.out.println(itemTitle);
			
			Assert.assertEquals(itemTitle, item1);
			logger.info("*************Verified Product Title ***************");
			
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
			int cartBadgeCount = cart.getCartBadgeCount();

			int cartItemCount = cart.getCartItemCount();
			
			Assert.assertEquals(cartBadgeCount, cartItemCount);
			
		}
		
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			logger.info("***********Code Fails***********");
		}
	}
	
}
