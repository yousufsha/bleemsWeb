package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageElement.HomePage;

public class BaseClassGuest {
	public static WebDriver driver;
    public Logger logger;

    @BeforeMethod
    public void setUp() {

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
         
         driver.get("https://pci.bleems.com/kw");
 		
        
    }

//    @AfterMethod
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

}
