package utilityFiles;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import base.BaseClass;

public class ScrollDownUntil extends BaseClass {
	
	public void scrollDownUntilElementVisible(WebElement element) {

	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    int maxScrolls = 10;
	    int scrollCount = 0;

	    while (scrollCount < maxScrolls) {

	        try {
	            if (element.isDisplayed()) {
	                break;
	            }
	        } catch (Exception e) {
	            // Ignore if element is not yet visible
	        }

	        js.executeScript("window.scrollBy(0, 500);"); // scroll down
	        scrollCount++;
	    }
	}

}
