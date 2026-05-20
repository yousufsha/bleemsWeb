package pageElement;

import org.openqa.selenium.By;
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
	public String getProductPrice() {
		String priceText = wait.until(ExpectedConditions.visibilityOf(priceLable)).getText();
		String cleanPrice = priceText.replaceAll("[^\\d.]", "");
		return cleanPrice;
	}
	
	@FindBy(xpath="//button[@id='addToCartBtn']")
	WebElement sendBtn;
	public void clickSendBtn() {
		   js.executeScript("arguments[0].scrollIntoView({block: 'center'});", sendBtn);
		wait.until(ExpectedConditions.elementToBeClickable(sendBtn));
		sendBtn.click();
	}
	
	@FindBy(xpath="//a[normalize-space()='Select area']")
	WebElement selectAddress;
	public void selectAddress() {
		selectAddress.click();
	}
	
	
	@FindBy(xpath="//div[@class='dv-saved-address-list']//li[2]")
	WebElement selectSavedAdderss;
	public void selectSavedAdderss() {
		selectSavedAdderss.click();
	}
	
	
	@FindBy(xpath="//input[@id='txtDeliveryArea']")
	WebElement deliveryAreaTxt;
	public void enterDeliverydAddress() {
		deliveryAreaTxt.sendKeys("Hawally");
		deliveryAreaTxt.click();
	}
	
	@FindBy(xpath="//div[@class='pac-container pac-logo']//div[1]")
	WebElement selectGoogleAddress;
	public void selectGoogleAddress() {
		selectGoogleAddress.click();
	}
	

	public void enterAndSelectDeliveryAddressGuest() {
	    deliveryAreaTxt.sendKeys("Hawally");
	    deliveryAreaTxt.click();

	    WebElement address = wait.until(
	            ExpectedConditions.elementToBeClickable(
	                    By.xpath("//div[@class='pac-container pac-logo']//div[1]")));
	    address.click();
	}
	
	@FindBy(xpath="//select[@id='ddlFlavour']")
	WebElement clickFlavour;
	
	@FindBy(xpath="//option[@value='1']")
	WebElement selectFlavour;
	
	public void selectFlavour() {
	    try {
	        if (clickFlavour.isDisplayed()) {
	            wait.until(ExpectedConditions.elementToBeClickable(clickFlavour)).click();
	            wait.until(ExpectedConditions.elementToBeClickable(selectFlavour)).click();
	        }
	    } catch (Exception e) {
	        System.out.println("Flavour option not available");
	    }
	}
	
	
	@FindBy(xpath="//input[@id='txtDeliveryDate']")
	WebElement clickDate;
	public void clickDate() {
		clickDate.click();
	}
	
	@FindBy(xpath="//div[@class='air-datepicker-nav--action']")
	WebElement nextMonth;
	
	@FindBy(xpath="//div[normalize-space()='5']")
	WebElement selectDate1;
	@FindBy(xpath="//div[normalize-space()='6']")
	WebElement selectDate2;
	
	@FindBy(xpath="//button[@id='10-00---14-00']")
	WebElement selectTime;
	
	@FindBy(xpath="//button[@id='14-00---18-00']")
	WebElement selectTime2;
	
	public void selectDateAndTime() {
		nextMonth.click();
		
		try {
		if(selectDate1.isEnabled()) {
		WebElement date = wait.until(ExpectedConditions.elementToBeClickable(selectDate1));
		date.click();
		} else {
			selectDate2.click();		
			} 
		}catch(Exception e) {
			selectDate2.click();
		}
		
		try {
		    if (selectTime.isDisplayed()) {
		        selectTime.click();
		    } else {
		        selectTime2.click();
		    }
		} catch (Exception e) {
		    selectTime2.click();
		}	
	}
	
	
	@FindBy(xpath="//button[@data-btn-name='select location']//span[@class='location-text'][normalize-space()='Kuwait']")
	WebElement noAddress;
	public boolean noAddress() {
		 try {
		        wait.until(ExpectedConditions.visibilityOf(noAddress));
		        return noAddress.isDisplayed();
		    } catch (Exception e) {
		        return false;
		    }
	}
	
	@FindBy(xpath="//button[@id='inc']")
	WebElement quantityIncBtn;
	public void setQuantity(int quantity) {
		 if (quantity < 1) {
		        throw new IllegalArgumentException("Quantity must be at least 1");
		    }
		for(int i=1;i<quantity;i++) {
			wait.until(ExpectedConditions.elementToBeClickable(quantityIncBtn)).click();
		}
	}
	
	
	
	
	
	
	
	
	
}
