package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilityFiles.CookieManager;

public class BaseClassGuest {
	 public static WebDriver driver;
	    public Logger logger;
	    public SoftAssert softAssert;
	    public static JavascriptExecutor js;
	    
	    @Parameters({"emailId", "password"})
	    @BeforeMethod
	    public void setUp(String emailId, String password) throws Exception {

	        WebDriverManager.chromedriver().setup();

	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        options.addArguments("--disable-geolocation");
	        options.addArguments("--force-device-scale-factor=0.75");

	        driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	        logger = LogManager.getLogger(this.getClass());
	        softAssert = new SoftAssert();

	        // Open the domain first
	        driver.get("https://pci.bleems.com/kw");

	        // Load previously saved cookies
	        CookieManager.loadCookies(driver);

	        // Re-apply session
	        driver.navigate().refresh();
	    }
	    
//	    @AfterMethod
	    public void tearDown() {
	        try {
	            if (driver != null) {
	                driver.close();
	                System.out.println("Browser closed successfully");
	                softAssert.assertAll();
	            }
	        } catch (Exception e) {
	            System.out.println("Error while closing browser: " + e.getMessage());
	        }
	    }
	    

}
