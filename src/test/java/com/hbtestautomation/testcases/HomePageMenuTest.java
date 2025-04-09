package com.hbtestautomation.testcases;

import com.hbtestautomation.pages.BaseTest;
import com.hbtestautomation.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageMenuTest extends BaseTest {
    @Test(priority = 1)
    public void testMenuIsLoaded() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isMenuDisplayed());


    }

}
