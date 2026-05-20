package pageElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='dv-cart-item-price']")
	WebElement cartPrice;
	public String getCartPrice() {
			String priceText = wait.until(ExpectedConditions.visibilityOf(cartPrice)).getText();
			String cleanPrice = priceText.replaceAll("[^\\d.]", "");
			return cleanPrice;
	}
	
	@FindBy(xpath="//ul[@class='ul-order-summary']//span[contains(text(),'Order total')]/following::span[contains(.,'KWD')]")
	WebElement totalCartPrice;
	public String getTotalCartPrice() {
		String priceText = wait.until(ExpectedConditions.visibilityOf(totalCartPrice)).getText();
		String cleanPrice = priceText.replaceAll("[^\\d.]", "");
		return cleanPrice;
	}
	
	@FindBy(xpath="//button[@id='chkoutBtn']")
	WebElement clickCheckoutBtn;
	public void clickCheckoutBtn() {
		clickCheckoutBtn.click();
	}
	
	
	@FindBy(xpath="//li[@class='li-order-total']//span[contains(text(),'Total')]/following::span[contains(.,'KWD')]")
	WebElement checkoutPrice;
	public String getCheckoutPrice () {
		String priceText = wait.until(ExpectedConditions.visibilityOf(checkoutPrice)).getText();
		String cleanPrice = priceText.replaceAll("[^\\d.]", "");
		return cleanPrice;
	}
	
	
	@FindBy(xpath="//input[@value='knet']")
	WebElement selectKnet;
	public void selectKnet () {
		selectKnet.click();
	}
	

	@FindBy(xpath="//button[@id='pay']")
	WebElement payBtn;
	public void ClickPayBtn () {
		payBtn.click();
	}
	
	@FindBy(xpath="//span[@class='cart-count']")
	WebElement cartBadgeCount;
	public String getCartBadgeCount() {
		String count = wait.until(ExpectedConditions.visibilityOf(cartBadgeCount)).getText();
		 return count;
	}
	
	@FindBy(xpath = "//div[@class='dv-cart-item']")
	List<WebElement> cartItemCount;
	public String getCartItemCount() {
		return String.valueOf(cartItemCount.size());
	}
	
	@FindBy(xpath = "//button[@data-btn-name='remove cart item']")
	List<WebElement> removeButtons;

	public void removeItems(int count) {
	    int totalItems = removeButtons.size();
	    if (count > totalItems) {
	        count = totalItems;
	    }
	    for (int i = 0; i < count; i++) {
	        wait.until(ExpectedConditions.elementToBeClickable(removeButtons.get(0))).click();
	        // Optional wait after removing item
	        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(
	                By.xpath("//button[@data-btn-name='remove cart item']"),totalItems - i));
	    }
	}
	
	
	
	
	
	
	
	
}
