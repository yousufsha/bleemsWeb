package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.CartPage;
import pageElement.HomePage;
import pageElement.ProductPage;
import pageElement.SearchPage;

public class CartQuantityItems extends BaseClass {

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
        	
        	product.setQuantity(3);

        	product.clickSendBtn();

        	logger.info("Item added to cart successfully");

            String cartItemCount = cart.getCartItemCount();
            String cartBadgeCount = cart.getCartBadgeCount();

            logger.info("Cart Badge Count : " + cartBadgeCount);
            logger.info("Cart Item Count : " + cartItemCount);

            Assert.assertEquals(
                    cartBadgeCount,
                    cartItemCount,
                    "Cart badge count does not match cart items count"
            );

        } catch (Exception e) {

            logger.error("*********** Code Failed ***********");
            logger.error(e.getMessage());

            Assert.fail(e.getMessage());
        }
    }

   
}

