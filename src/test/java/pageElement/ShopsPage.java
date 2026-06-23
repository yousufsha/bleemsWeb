package pageElement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilityFiles.ScrollDownUntil;

public class ShopsPage extends BasePage {

	public ShopsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[normalize-space()='Flowers']")
	WebElement flowerShops;
	public void selectFlowerShops() {
		wait.until(ExpectedConditions.elementToBeClickable(flowerShops)).click();
	}
	
	@FindBy(xpath="//div[contains(@class,'brand-a-z-item-type') and contains(normalize-space(),'Flowers')]")
	List<WebElement> flowersShop;
	public boolean verifyAllFlowerShops() {
	    if (flowersShop.isEmpty()) {
	        return false;
	    }
	    for (WebElement shop : flowersShop) {
	        String text = shop.getText().trim();
	        if (!text.contains("Flowers")) {
	            System.out.println("Invalid item found: " + text);
	            return false;
	        }
	    }
	    return true;
	}
	
	@FindBy(xpath="//a[@data-name='floria']")
	WebElement floriaShop;
	public void clickFloriaShop() {
		ScrollDownUntil.scrollDownUntilElementVisible(floriaShop);
		floriaShop.click();
	}
	
	@FindBy(xpath="//h1[@class='title-banner']")
	WebElement ShopTitle;
	public String getShopTitle() {
		return wait.until(ExpectedConditions.visibilityOf(ShopTitle)).getText().trim();
	}
	
	
	
	
	
	
	
	
	
	
}
