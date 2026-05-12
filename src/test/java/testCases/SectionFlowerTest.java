package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClassGuest;
import pageElement.ProductPage;
import pageElement.SectionsTabs;

public class SectionFlowerTest extends BaseClassGuest{
	
	@Test
	public void verifySectionFlower() {
		try {
			
		SectionsTabs section = new SectionsTabs(driver);
		section.moveFlowersSection();
		logger.info("**********Section flower selected************");
		section.selectHandBouquets();
		logger.info("****************SubType Hand Bouquets Selected********************");
		
		String filterChip = section.getFilterChip();
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
