package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.FiltersPage;
import pageElement.SectionsTabs;

public class FilterGiftTest extends BaseClass {
	
	@Test
	public void VerifyFilterGift() {
		try {
		SectionsTabs section = new SectionsTabs(driver);
		section.clickGiftSection();
		logger.info("********** Gift Section Clicked ***********");
		
		FiltersPage filter = new FiltersPage(driver);
		
		filter.clickDiscountBtn();
		logger.info("************** Discount button clicked ***************");
		filter.selectDiscount();
		logger.info("************** Discount Selected ***************");
	
		String discountChip = filter.getFilterChip();
		Assert.assertEquals(discountChip,"20%");
		logger.info("************** Discount chip verified ***************");
		
		boolean checkDiscount = filter.checkDiscount();
		Assert.assertTrue(checkDiscount);
		logger.info("*************** Verified Discount Applied ***************");

		}
		
		catch(Exception e) {
			System.out.println(e);
			Assert.assertFalse(true);
			logger.info("******** Code Fail *******");
		}
		
	}
	
	
	

}
