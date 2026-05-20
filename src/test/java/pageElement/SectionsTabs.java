package pageElement;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

public class SectionsTabs extends BasePage {
	
	public SectionsTabs(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@alt='logo']")
	WebElement bleemsLogo;
	public boolean TxtBleemsLogo () {
		return bleemsLogo.isDisplayed();
	}
	
	
	@FindBy(xpath="//div[contains(@class,'owl-item active')][1]")
	WebElement banner;
	public boolean banner () {
		WebElement bannerImg = wait.until(ExpectedConditions.visibilityOf(banner));
		return bannerImg.isDisplayed();
	}
	
	
	
	@FindBy(xpath="//ul[@class='custom-navbar ']/li/a[contains(text(),'Flowers')]")
	WebElement flowersSection;
	public void moveFlowersSection() {
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(flowersSection));
		action.moveToElement(flowersSection).perform();
	}
	
	
	@FindBy(xpath="//ul[@class='custom-navbar ']/li/a[contains(text(),'Confections')]")
	WebElement confectionsSection;
	public void clickConfectionsSection() {
		wait.until(ExpectedConditions.elementToBeClickable(confectionsSection)).click();
	}
	
	@FindBy(xpath="//ul[@class='custom-navbar ']/li/a[contains(text(),'Gifts')]")
	WebElement giftsSection;
	public void clickGiftSection() {
		wait.until(ExpectedConditions.elementToBeClickable(giftsSection)).click();
	}
	
	@FindBy(xpath="//ul[@class='custom-navbar ']/li/a[contains(text(),'Toys')]")
	WebElement toysSection;
	public void clickToysSection () {
		toysSection.click();
	}
	
	@FindBy(xpath="//ul[@class='custom-navbar ']/li/a[contains(text(),'Occasions')]")
	WebElement occasionsSection;
	public void clickOccasionsSection () {
		occasionsSection.click();
	}
	
	@FindBy(xpath="//ul[@class='custom-navbar ']/li/a[contains(text(),'Shops')]")
	WebElement shopsSection;
	
	public boolean flowersSectionVisibility() {
		WebElement flowerVisible = wait.until(ExpectedConditions.visibilityOf(flowersSection));
		return flowerVisible.isDisplayed();
	}
	
	public boolean confectionsSectionVisibility() {
		WebElement confectionVisible = wait.until(ExpectedConditions.visibilityOf(confectionsSection));
		return confectionVisible.isDisplayed();
	}
	
	public boolean giftsSectionVisibility() {
		WebElement giftVisible = wait.until(ExpectedConditions.visibilityOf(giftsSection));
		return giftVisible.isDisplayed();
	}
	
	public boolean toysSectionVisibility() {
		WebElement toyVisible = wait.until(ExpectedConditions.visibilityOf(toysSection));
		return toyVisible.isDisplayed();
	}
	
	public boolean occasionsSectionVisibility() {
		WebElement occasionVisible = wait.until(ExpectedConditions.visibilityOf(occasionsSection));
		return occasionVisible.isDisplayed();
	}
	
	public boolean shopSectionVisibility() { 
		WebElement shopVisible = wait.until(ExpectedConditions.visibilityOf(shopsSection));
		return shopVisible.isDisplayed();
	}
	
	@FindBy(xpath="//ul[@class='list-links']//li/a[contains(text(),'Hand Bouquets')]")
	WebElement subTypeFlower;
	public void selectHandBouquets() {
		subTypeFlower.click();
	}
	
	@FindBy(xpath="//div[@id='itemGroup']//div[@id='itemBlock'][3]")
	WebElement itemList;
	public void selectItemFromList() {
		itemList.click();
	}
	
	@FindBy(xpath="//div[@class='text-center mb-3 ']")
	WebElement sectionTitle;
	public String getSectionTitle() {
		return sectionTitle.getText().trim();
	}
	
	
	@FindBy(xpath="//section[@class='custom-row ']//h2")
	List<WebElement> customRow;
	public void verifyCustomRowTitles(SoftAssert softAssert) {
	    for (WebElement element : customRow) {
	        String title = element.getText().trim();
	        softAssert.assertFalse(title.isEmpty(),"Custom row title is empty");
	    }
	}
}
