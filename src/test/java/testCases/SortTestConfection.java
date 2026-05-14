package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.FiltersPage;
import pageElement.SectionsTabs;

public class SortTestConfection extends BaseClass {
	
	@Test(groups= {"loginUser","guestUser"})
	public void verifySort() {
		
		try {
			SectionsTabs section = new SectionsTabs(driver);
			section.clickConfectionsSection();
			logger.info("***********Confection clicked************");
			
			String sectionTitle = section.getSectionTitle();
			Assert.assertEquals(sectionTitle,"Confections");
			logger.info("*********Confection Section Confirmed*********");
			
			FiltersPage filter = new FiltersPage(driver);
			filter.clickSortBtn();
			filter.selectSortLtoH();
			logger.info("***********Price Low to High Sort Selected************");
			
			
			String sortText = filter.getSortText();
			Assert.assertEquals(sortText,"Price Low to High");
			logger.info("********** Verified Sort ************");
			
			boolean pricesLowToHigh = filter.verifyPricesLowToHigh();
			Assert.assertTrue(pricesLowToHigh);
			logger.info("$$$$$$$$$ Verified Sort price $$$$$$$$$");
			
			
	
			
		}
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			logger.info("***********Code Fails*************");
	
		}
	}

}
