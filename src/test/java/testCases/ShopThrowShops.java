package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.FiltersPage;
import pageElement.HomePage;
import pageElement.SectionsTabs;
import pageElement.ShopsPage;

public class ShopThrowShops extends BaseClass {
	
	@Test
	public void Verify_shoppingViaShop() throws InterruptedException  {
		try {
			
		SectionsTabs section = new SectionsTabs(driver);
		section.clickShopSection();
		
		
		ShopsPage shop = new ShopsPage(driver);
		shop.selectFlowerShops();
		shop.verifyAllFlowerShops();
		
		shop.clickFloriaShop();
		logger.info("shop clicked");
		
		String shopTitle = shop.getShopTitle();
		Assert.assertEquals(shopTitle, "floria");
		logger.info("shop verified");
		
		FiltersPage filter = new FiltersPage(driver);
		filter.clickSortBtn();
		filter.selectSortHtoL();
		logger.info("sort verification");
		
		boolean verifyPricesHighToLow = filter.verifyPricesHighToLow();
		Assert.assertEquals(verifyPricesHighToLow, true);
		
		Thread.sleep(20000);
	}
	
	catch (Exception e) {
		
		Assert.assertFalse(true);
	
	}
	
	}
}
