package com.hbtestautomation.testcases;

import com.hbtestautomation.pages.BaseTest;
import com.hbtestautomation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginForgotPassTest extends BaseTest {


    @Test(priority = 1)
    public void forgotPasswordTest() {
        LoginPage lp = new LoginPage(driver);
        boolean isResetSuccessful = lp.forgotPassword();
        Assert.assertTrue(isResetSuccessful, "Şifre sıfırlama işlemi başarısız oldu!");
    }

}
