package utilityFiles;

import java.util.List;

import org.openqa.selenium.WebElement;

public class DiscountFilterUtils {
	
	public static boolean verifyDiscountFilter(
	        List<WebElement> discountBadges,
	        int expectedDiscount) 
	{

	    for (WebElement badge : discountBadges) {
	        String text = badge.getText()
	                .replaceAll("[^0-9]", "");

	        if (!text.isEmpty()) {
	            int actualDiscount = Integer.parseInt(text);
	            if (actualDiscount < expectedDiscount) {
	                return false;
	            }
	        }
	    }
	    return true;
	}
}
