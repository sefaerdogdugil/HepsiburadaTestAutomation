package com.hbtestautomation.testcases;

import com.hbtestautomation.pages.BaseTest;
import com.hbtestautomation.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {


    @Test(priority = 1)
    public void verifyLogin() throws  InterruptedException {
        LoginPage lp = new LoginPage(driver);
        String username = "sefaotomasyonn11@outlook.com";
        String password = "Testotomasyon11";
        lp.loginToPortal(username, password);
    }
}
