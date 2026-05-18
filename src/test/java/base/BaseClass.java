package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageElement.CartPage;
import pageElement.HomePage;
import pageElement.ProductPage;
import pageElement.SearchPage;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static WebDriver driver;
    public Logger logger;
    
    @Parameters({"user", "env", "emailId", "password"})
    @BeforeMethod
    public void setUp(String user, String env, String emailId, String password) {

    	 WebDriverManager.chromedriver().setup();
    	 
    	 // Block Notification
    	 ChromeOptions options = new ChromeOptions();
         options.addArguments("--disable-notifications");
         options.addArguments("--disable-geolocation");
         options.addArguments("--force-device-scale-factor=0.75");
         
         driver = new ChromeDriver(options);
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         
         logger = LogManager.getLogger(this.getClass());
         
      switch(env) {  
      case "test" :  driver.get("https://pci.bleems.com/kw"); break;
      case "live" : driver.get("https://www.bleems.com/kw"); break;
      }
      
      switch(user) {
      case "loginUser": {
        HomePage home = new HomePage(driver);
 		home.clickLoginbtn();
 		home.clickContinueWithEmail();
 		home.enterEmailId(emailId);
 		home.clickSubmitBtn();
 		home.enterPassword(password);
 		home.clickSubmitBtn();
 		logger.info("*************Account is logged in*****************");
      	} break;
      case "guestUser":
    	logger.info("*************Guest User*****************"); break;
    }
  
  }
    
    @AfterMethod
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed successfully");
            }
        } catch (Exception e) {
            System.out.println("Error while closing browser: " + e.getMessage());
        }
    }

    
    public void addItemToCart(HomePage home,
            SearchPage search,
            ProductPage product,
            String item) throws InterruptedException {
    	
Thread.sleep(500);
home.clickSearchBtn();
logger.info("Search clicked");

home.enterSearchTxt(item);
logger.info("Search value entered : " + item);

search.clickSearchItem();
logger.info("Search product clicked");

String itemTitle = product.getItemTitle();

logger.info("Product title : " + itemTitle);

Assert.assertEquals(
itemTitle,
item,
"Product title mismatch"
);

logger.info("Verified Product Title");


if (product.noAddress()) {
	product.selectAddress();
    product.selectSavedAdderss();
    logger.info("Address Selected");
}

Thread.sleep(500);
product.clickDate();
product.selectDateAndTime();

logger.info("Date Selected");

product.clickSendBtn();

logger.info("Item added to cart successfully");
}
    

}
