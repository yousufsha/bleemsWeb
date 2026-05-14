package pageElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilityFiles.DiscountFilterUtils;
import utilityFiles.PriceUtils;

public class FiltersPage extends BasePage {
	
	public FiltersPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='dv-filter-chips-wrapper']")
	WebElement filterChip;
	public String getFilterChip() {
		return wait.until(ExpectedConditions.elementToBeClickable(filterChip)).getText().trim();
	}
	
	@FindBy(xpath="//button[@data-btn-name='sort by']")
	WebElement sortBtn;
	public void clickSortBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(sortBtn)).click();
	}
	public String getSortText() {
		return wait.until(ExpectedConditions.visibilityOf(sortBtn)).getText().trim();
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Price Low to High')]")
	WebElement sortLtoH;
	public void selectSortLtoH() {
		wait.until(ExpectedConditions.elementToBeClickable(sortLtoH)).click();
	}
	
	
	@FindBy(xpath="//div[@id='itemBlock']//div[contains(text(),'KWD')]")
    List<WebElement> priceElements;
    public boolean verifyPricesLowToHigh() {
        return PriceUtils.isSortedLowToHigh(priceElements);
    }
    
//	@FindBy(xpath="//button[@data-bs-target='#filter-discount']")
//	WebElement discountBtn;
//	public void clickDiscountBtn() {
//		 WebElement discountBtn = driver.findElement(
//			        By.xpath("//button[@data-bs-target='#filter-discount']")
//			    );
//		 wait.until(ExpectedConditions.refreshed
//				 (ExpectedConditions.elementToBeClickable(discountBtn)))
//		        .click();
//	}
    
    public void clickDiscountBtn() {
        By discountBtn = By.xpath("//button[@data-bs-target='#filter-discount']");
        for (int i = 0; i < 3; i++) {
            try {
                wait.until(ExpectedConditions.refreshed(
                        ExpectedConditions.elementToBeClickable(discountBtn)))
                    .click();
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Retrying...");
            }
        }
    }
	
//	@FindBy(xpath="//button[@data-bs-target='#filter-price-range']")
//	WebElement priceRangeBtn;
//	public void clickPriceRangeBtn() {
//		wait.until(ExpectedConditions.elementToBeClickable(priceRangeBtn)).click();
//	}
	
	@FindBy(xpath="//div[@id='filter-discount']//input[@id='dis-20']")
	WebElement discountPercentage;
	public void selectDiscount() {
		discountPercentage.click();
	}
	
//	@FindBy(xpath="//div[@id='filter-price-range']//input[@id='price-2']")
//	WebElement priceRange;
//	public void selectPriceRange() {
//		priceRange.click();
//	}
	
	
	@FindBy(xpath="//div[@class='dv-discount-badge']")
	List<WebElement> checkDiscount;
	public boolean checkDiscount() {
		return DiscountFilterUtils.verifyDiscountFilter(
				checkDiscount,
	            20
	    );
	}
	
	
	
	
	
	
	
	
	
	

}
