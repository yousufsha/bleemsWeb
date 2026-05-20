package testCases;

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
			String item = "Romance Bento Cake 26";
			
			HomePage home = new HomePage(driver);
			Thread.sleep(500);
			
			home.SearchBtn(item);
			logger.info("************* Search item ***************");
			
			
			SearchPage search = new SearchPage(driver);
			search.clickSearchItem();
			logger.info("*************Search product clicked***************");
			
			ProductPage product = new ProductPage(driver);
			String itemTitle = product.getItemTitle();
			logger.info("*************Product title copied***************");
			System.out.println(itemTitle);
			
			Assert.assertEquals(itemTitle, item);
			logger.info("*************Verified Product Title ***************");
			
			product.selectAddress();
			logger.info("***********Send button clicked*************");
			
			product.selectSavedAdderss();
			logger.info("********* Address Selected ***********");
			Thread.sleep(500);
			
			product.selectFlavour();
			
			product.clickDate();
			product.selectDateAndTime();
			logger.info("********* Date Selected ******************");
			
			product.clickSendBtn();
			
			CartPage cart = new CartPage(driver);
			String cartItemCount = cart.getCartItemCount();
			String cartBadgeCount = cart.getCartBadgeCount();
			
			logger.info("Cart Badge Count : " + cartBadgeCount);
            logger.info("Cart Item Count : " + cartItemCount);
			Assert.assertEquals(cartBadgeCount, cartItemCount,"Count mismatch");
		}
		
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			logger.info("***********Code Fails***********");
		}
	}
	
}
