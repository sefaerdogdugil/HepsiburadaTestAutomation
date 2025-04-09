package com.hbtestautomation.testcases;

import com.hbtestautomation.pages.BaseTest;
import com.hbtestautomation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageSearchTest extends BaseTest {

    @Test(priority = 1)
    public void testSearchProduct() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Laptop");
        Assert.assertTrue(homePage.isSearchResultDisplayed());
    }
}