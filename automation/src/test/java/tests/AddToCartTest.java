
package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

public class AddToCartTest extends BaseTest {
    @Test
    public void testAddToCart() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        new ProductPage(driver).addToCart();
    }
}
