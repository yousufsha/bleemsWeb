package utilityFiles;

import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ScrollUpUtils extends BaseClass {
	
	public static void scrollUntilElementVisible(WebElement element) {
	    int maxScrolls = 10;
	    int scrollCount = 0;

	    while (!element.isDisplayed() && scrollCount < maxScrolls) {
	        js.executeScript("window.scrollBy(0, -500);"); // scroll up
	        scrollCount++;

	        try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

}
