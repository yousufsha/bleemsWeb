package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageElement.CartPage;
import pageElement.HomePage;
import pageElement.ProductPage;
import pageElement.SearchPage;

public class MutipleCartItems extends BaseClass {

    @Test(groups = {"loginUser", "guestUser"})
    public void verify_MultipleCartItemsTest() {

        String[] items = {
                "Bint Al Jannah",
                "Holy Month Cake Painting",
                "White Shaped Bowl",
                "Rise Of Love 1",
                "Perfect Iaso Hand"
        };

        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

        try {

            for (String item : items) {

                addItemToCart(home, search, product, item);
            }

            int cartBadgeCount = cart.getCartBadgeCount();
            int cartItemCount = cart.getCartItemCount();

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

