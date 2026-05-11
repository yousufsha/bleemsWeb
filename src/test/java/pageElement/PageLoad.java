package pageElement;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageLoad extends BasePage {
	
	  public PageLoad(WebDriver driver) {
	        super(driver);
	    }

	    public void waitForPageLoad() {

	        WebDriverWait wait =
	                new WebDriverWait(driver, Duration.ofSeconds(30));

	        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
	                        .executeScript("return document.readyState")
	                        .equals("complete"));
	    }
}
