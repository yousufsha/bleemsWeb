package pageElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h1[@class='product-title']")
	WebElement productTitle;
	public boolean titleDisplayed() {
		return productTitle.isDisplayed();
	}
	public String getItemTitle() {
		return productTitle.getText();
	}
	
	@FindBy(xpath="//p[@class='product-desc pt-1']")
	WebElement productDiscribtion;
	public String getDiscribtion() {
		return productDiscribtion.getText();
	}
	
	
	
	
	
}
