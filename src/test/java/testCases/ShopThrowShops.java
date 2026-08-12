package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.CartPage;
import pageElement.FiltersPage;
import pageElement.ProductPage;
import pageElement.SectionsTabs;
import pageElement.ShopsPage;

public class ShopThrowShops extends BaseClass {
	
	@Test(groups= {"loginUser","guestUser"})
	public void Verify_shoppingViaShops() throws InterruptedException  {
		try {
			
		SectionsTabs section = new SectionsTabs(driver);
		section.clickShopSection();
		logger.info("shop section clicked");
		
		ShopsPage shop = new ShopsPage(driver);
		shop.selectFlowerShops();
		shop.verifyAllFlowerShops();
		logger.info("verified flower shops list");
		
		shop.clickFloriaShop();
		logger.info("shop clicked");
		
		String shopTitle = shop.getShopTitle();
		Assert.assertEquals(shopTitle, "Floria");
		logger.info("shop verified");
		
		FiltersPage filter = new FiltersPage(driver);
		filter.clickSortBtn();
		filter.selectSortHtoL();
		logger.info("sort verification");
		
		boolean verifyPricesHighToLow = filter.verifyPricesHighToLow();
		Assert.assertEquals(verifyPricesHighToLow, true);
		
		shop.selectFloriaItem1();
		
		ProductPage product = new ProductPage(driver);
		
		String itemTitle = product.getItemTitle();
		
		product.selectAddress();
		product.selectSavedAdderss();
		logger.info("Address selected");
		Thread.sleep(500);
		
		product.clickDate();
		logger.info("Date is clickedselected");
		
		product.selectDateAndTime();
		logger.info("Date and Time selected");
		
		product.clickSendBtn();
		logger.info("Send button clicked");
		
		CartPage cart = new CartPage(driver);
		String itemNameCart = cart.getItemNameCart();
		
		Assert.assertEquals(itemTitle, itemNameCart);
		
		
		
	}
	
	catch (Exception e) {
		
		Assert.assertFalse(true);
	
	}
	
	}
}
