package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClassGuest;
import pageElement.SectionsTabs;

public class FilterTestConfection extends BaseClassGuest {
	
	@Test
	public void verifyFilters() {
		
		try {
			SectionsTabs section = new SectionsTabs(driver);
			section.clickConfectionsSection();
			logger.info("***********Confection clicked************");
			
			String sectionTitle = section.getSectionTitle();
			Assert.assertEquals(sectionTitle,"Confections");
			logger.info("*********Section Confirmed*********");
			
		}
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			logger.info("***********Code Fails*************");
	
		}
	}

}
