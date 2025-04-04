package com.hbtestautomation.testcases;

import com.hbtestautomation.pages.BaseTest;
import com.hbtestautomation.pages.HomePage;
import org.testng.annotations.Test;

public class SearchTests extends BaseTest {

    @Test(priority = 1)
    public void testSearchProduct() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Laptop");
    }
}