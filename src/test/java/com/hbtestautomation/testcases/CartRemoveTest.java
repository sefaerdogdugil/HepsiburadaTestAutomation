package com.hbtestautomation.testcases;

import com.hbtestautomation.pages.BaseTest;
import com.hbtestautomation.pages.CartPage;
import com.hbtestautomation.pages.HomePage;
import org.testng.annotations.Test;

public class CartRemoveTest extends BaseTest {
    @Test(priority = 1)
    public void searchProduct() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.searchProduct("Kulaklık");
        cartPage.addToCart();
        cartPage.removeFromCart();
    }

}
