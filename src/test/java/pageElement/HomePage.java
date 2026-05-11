package pageElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
	super(driver);
	}
	
	@FindBy(xpath="//button[@class='btn btn-login dropdown-account track-btn']")
	WebElement loginbtn;
	public void clickLoginbtn() {
		wait.until(ExpectedConditions.visibilityOf(loginbtn));
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();
	}
	
	@FindBy(xpath="//button[@class='btn-block btn-email track-btn']")
	WebElement continueWithEmail;
	public void clickContinueWithEmail() {
		continueWithEmail.click();
	}
	
	public boolean visiblityofContinueWithEmail() {
		return continueWithEmail.isEnabled();
	}
	
	@FindBy(xpath="//input[@id='Login_Email']")
	WebElement emailTxtField;
	public String enterEmailId(String emailId) {
		emailTxtField.sendKeys(emailId);
		return emailId;
	}
	
	@FindBy(xpath="//button[@id='btnSubmit']")
	WebElement submitBtn;
	public void clickSubmitBtn() {
			submitBtn.click();
	}
	
	@FindBy(xpath="//input[@name='Login.Password']")
	WebElement passwordTxtField;
	public String enterPassword(String password) {
		passwordTxtField.sendKeys(password);;
		return password;
	}
	
	@FindBy(xpath="//button[@id='dropdownAccount']")
	WebElement accountBtn;
	public void clickAccountBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(accountBtn));
		accountBtn.click();
	}
	
	@FindBy(xpath="//a[@class='dropdown-item']//div[contains(text(),'My Account')]")
	WebElement myAccountBtn;
	public boolean checkVisiblityMyAccount() {
		wait.until(ExpectedConditions.visibilityOf(myAccountBtn));
		return myAccountBtn.isDisplayed();
	}
	
	@FindBy(xpath="//div[@class='dropdown-menu show']/li[8]/div[@onclick='logout()']")
	WebElement logoutBtn;
	public void clickLogoutBtn() {
		wait.until(ExpectedConditions.visibilityOf(logoutBtn));
		 try {
		        logoutBtn.click();
		    } catch (Exception e) {
		        js.executeScript("arguments[0].click();", logoutBtn);
		    }
	}
	
	@FindBy(xpath="//a[@id='searchButton1']")
	WebElement searchBtn;
	public void clickSearchBtn() {
		searchBtn.click();
	}
	
	@FindBy(xpath="//input[@id='search-box']")
	WebElement searchTxtField;
	public void enterSearchTxt(String search) {
		wait.until(ExpectedConditions.visibilityOf(searchTxtField)).sendKeys(search);
	}
	
	@FindBy(xpath="//a[@href='https://pci.bleems.com/kw/cart']")
	WebElement cartBtn;
	public void clickCartBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(cartBtn)).click();
	}
	
	@FindBy(xpath="//h6[contains(text(),'Take Bleems with you')]")
	WebElement pageEnd;
	public String getEndText() {
		 wait.until(ExpectedConditions.visibilityOf(pageEnd));
		js.executeScript("arguments[0].scrollIntoView(true);",pageEnd);
		return pageEnd.getText().trim();
	}
}
