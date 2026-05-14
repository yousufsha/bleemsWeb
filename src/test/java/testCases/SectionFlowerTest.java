package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.FiltersPage;
import pageElement.ProductPage;
import pageElement.SectionsTabs;

public class SectionFlowerTest extends BaseClass{
	
	@Test(groups= {"loginUser","guestUser"})
	public void verifySectionFlower() {
		try {
			
		SectionsTabs section = new SectionsTabs(driver);
		
		section.moveFlowersSection();
		logger.info("**********Section flower selected************");
		section.selectHandBouquets();
		logger.info("****************SubType Hand Bouquets Selected********************");
		
		FiltersPage filter = new FiltersPage(driver);
		
		String filterChip = filter.getFilterChip();
		Assert.assertEquals(filterChip, "Hand Bouquets");
		
		section.selectItemFromList();
		logger.info("********Item Selected**********");
		
		ProductPage product = new ProductPage(driver);
		String discribtion = product.getDiscribtion();
		
		Assert.assertTrue(discribtion.contains("bouquet"));
		logger.info("*************Verified Flower Section***************");
		
		
		}
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			logger.info("**********Code fails**********");
		}
		
		
		
	}

}
