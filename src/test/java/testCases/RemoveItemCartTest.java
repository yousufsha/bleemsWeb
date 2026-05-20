package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.CartPage;
import pageElement.HomePage;
import pageElement.ProductPage;
import pageElement.SearchPage;

public class RemoveItemCartTest extends BaseClass {

    @Test(groups = {"loginUser", "guestUser"})
    public void verify_CartQuantityItemsTest() {

        String item = "Wood & Acrylic Decor Set";
        
        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        try {

        	Thread.sleep(500);
        	home.SearchBtn(item);
        	logger.info("Search value entered : " + item);

        	search.clickSearchItem();
        	logger.info("Search product clicked");

        	String itemTitle = product.getItemTitle();

        	logger.info("Product title : " + itemTitle);

        	Assert.assertEquals(itemTitle,item,"Product title mismatch");

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
        	
        	product.setQuantity(5);

        	product.clickSendBtn();

        	logger.info("Item added to cart successfully");

            String beforeRemove = cart.getCartItemCount();
            cart.removeItems(2);
            
            String afterRemove = cart.getCartItemCount();
            
            int before = Integer.parseInt(beforeRemove.replaceAll("\\D", ""));
            logger.info("Cart Item Count : " + before);
            int after = Integer.parseInt(afterRemove.replaceAll("\\D", ""));
            logger.info("Cart Item Count : " + after);
            
            Assert.assertTrue(after <= before);
            
            
        } catch (Exception e) {

            logger.error("*********** Code Failed ***********");
            logger.error(e.getMessage());

            Assert.fail(e.getMessage());
        }
    }

   
}

