package com.hbtestautomation.testcases;

import com.hbtestautomation.pages.BaseTest;
import com.hbtestautomation.pages.CartPage;
import com.hbtestautomation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageAddCartTest extends BaseTest {
    @Test
    public void searchProduct() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        homePage.searchProduct("Kulaklık");
        cartPage.addToCart();
        Assert.assertTrue(homePage.isSearchResultDisplayed());
    }

}
