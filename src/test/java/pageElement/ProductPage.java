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
	public String getItemTitle() {
		return productTitle.getText();
	}
	
	@FindBy(xpath="//p[@class='product-desc pt-1']")
	WebElement productDiscribtion;
	public String getDiscribtion() {
		return productDiscribtion.getText();
	}
	
	@FindBy(xpath="//span[@id='lblPrice']")
	WebElement priceLable;
	public String getPrice() {
		return wait.until(ExpectedConditions.visibilityOf(priceLable)).getText();
	}
	
	
}
