package pageElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SectionsTabs extends BasePage {
	
	public SectionsTabs(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class='custom-navbar ']/li/a[contains(text(),'Flowers')]")
	WebElement flowersSection;
	public void moveFlowersSection() {
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(flowersSection));
		action.moveToElement(flowersSection).perform();
	}
	
	@FindBy(xpath="//ul[@class='list-links']//li/a[contains(text(),'Hand Bouquets')]")
	WebElement subTypeFlower;
	public void selectHandBouquets() {
		subTypeFlower.click();
	}
	
	@FindBy(xpath="//div[@class='dv-filter-chips-wrapper']")
	WebElement filterChip;
	public String getFilterChip() {
		return filterChip.getText().trim();
	}
	
	@FindBy(xpath="//div[@id='itemGroup']//div[@id='itemBlock'][3]")
	WebElement itemList;
	public void selectItemFromList() {
		itemList.click();
	}
	
	@FindBy(xpath="//ul[@class='custom-navbar ']/li/a[contains(text(),'Confections')]")
	WebElement confectionSection;
	public void clickConfectionsSection() {
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(confectionSection)).click();
//		action.moveToElement(confectionSection).perform();
	}
	
	@FindBy(xpath="//div[@class='text-center mb-3 ']")
	WebElement sectionTitle;
	public String getSectionTitle() {
		return sectionTitle.getText().trim();
	}
	
}
