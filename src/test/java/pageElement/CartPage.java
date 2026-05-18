package pageElement;

import java.util.List;

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
	public int getCartBadgeCount() {
		String count = cartBadgeCount.getText();
		 return Integer.parseInt(count);
	}
	
	@FindBy(xpath = "//div[@class='dv-cart-item']")
	List<WebElement> cartItemCount;
	public int getCartItemCount() {
	   return cartItemCount.size();
	}
	
}
