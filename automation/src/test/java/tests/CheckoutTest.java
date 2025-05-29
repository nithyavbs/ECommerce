
package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {
    @Test
    public void testCompleteCheckout() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
        new ProductPage(driver).addToCart();
        new CheckoutPage(driver).completeCheckout("John", "Doe", "12345");
    }
}
