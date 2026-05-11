package pageElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage{
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//a[@class='list-group-item'][3]")
	WebElement item;
	public void selectItem() {
		item.click();
	}
	







}
