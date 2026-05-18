package pageElement;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public BasePage (WebDriver driver)
	{
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	js = (JavascriptExecutor) driver;
	PageFactory.initElements (driver, this);
	}


	@FindBy(xpath="")
	WebElement X;
	public void X () {
		X.click();
	}
	
}
