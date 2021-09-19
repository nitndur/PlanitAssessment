package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.ContactPage;
import pages.HomePage;
import pages.ShopPage;
import testBase.BaseTest;
import utilities.ExtentReports.*;

public class TC04_AddAndVerifyItemsInCartTest extends BaseTest {
    @Test
    public void AddAndVerifyItemsInCart(){
        ExtentTestManager.startTest("Add and verify items in cart","AddAndVerifyItemsInCart");
        ShopPage shopPage;
        CartPage cartPage;
        HomePage homePage = new HomePage(driver);

        shopPage = homePage.clickShop();
        shopPage.buyFunnyCowTwice()
                .buyFluffyBunnyOnce();
        cartPage = homePage.clickCart();
        cartPage.verifyCartCount()
                .verifyFunnyCowQuantity()
                .verifyFluffyBunnyQuantity();
    }
}
