package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.SectionsTabs;

public class TopSectionItemsTest extends BaseClass{
	
	@Parameters({"env"})
	@Test(groups= {"loginUser","guestUser"})
	public void verify_TopSestions(String env) {
		try {
			 switch(env) {  
		      case "test" :  driver.get("https://pci.bleems.com/kw"); break;
		      case "live" : driver.get("https://www.bleems.com/kw"); break;
		      }
			
			SectionsTabs section = new SectionsTabs(driver);
			
//			boolean flowersSectionVisibility = section.flowersSectionVisibility();
//			Assert.assertTrue(flowersSectionVisibility);
//			
//			boolean confectionsSectionVisibility = section.confectionsSectionVisibility();
//			Assert.assertTrue(confectionsSectionVisibility);
//			
//			boolean giftsSectionVisibility = section.giftsSectionVisibility();
//			Assert.assertTrue(giftsSectionVisibility);
//			
//			boolean toysSectionVisibility = section.toysSectionVisibility();
//			Assert.assertTrue(toysSectionVisibility);
//			
//			
//			boolean shopSectionVisibility = section.shopSectionVisibility();
//			Assert.assertTrue(shopSectionVisibility);

			boolean occasionsSectionVisibility = section.occasionsSectionVisibility();
			Assert.assertTrue(occasionsSectionVisibility);
			
			section.clickFlowerSection();
			String sectionTitle1 = section.getSectionTitle();
			Assert.assertEquals(sectionTitle1, "Flowers");
			
			section.clickConfectionsSection();
			String sectionTitle2 = section.getSectionTitle();
			Assert.assertEquals(sectionTitle2, "Confections");
			
			section.clickGiftSection();
			String sectionTitle3 = section.getSectionTitle();
			Assert.assertEquals(sectionTitle3, "Gifts");
			
			section.clickShopSection();
			boolean exploreShopText = section.exploreShopText();
			Assert.assertTrue(exploreShopText);
			
			
		}
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			logger.info("########## Code fails ##########");
		}
	}

}
