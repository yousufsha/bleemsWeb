package pageElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h1[@class='product-title']")
	WebElement productTitle;
	public boolean titleDisplayed() {
		return productTitle.isDisplayed();
	}
	public String getTitle() {
		return productTitle.getText();
	}
	
	@FindBy(xpath="//p[@class='product-desc pt-1']")
	WebElement productDiscribtion;
	public String getDiscribtion() {
		return productDiscribtion.getText();
	}
	
	@FindBy(xpath="//h6[contains(text(),'Take Bleems with you')]")
	WebElement pageEnd;
	public String getEndText() {
		 wait.until(ExpectedConditions.visibilityOf(pageEnd));
		js.executeScript("arguments[0].scrollIntoView(true);",pageEnd);
		return pageEnd.getText().trim();
	}
	
	
	
}
