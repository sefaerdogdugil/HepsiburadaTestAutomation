package com.hbtestautomation.testcases;

import com.hbtestautomation.pages.BaseTest;
import com.hbtestautomation.pages.LoginPage;
import com.hbtestautomation.utility.ReadExcelFile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class LoginDataDrivenTest extends BaseTest {

    String fileName = System.getProperty("user.dir") + "\\TestData\\TestInfo.xlsx";

    @Test(priority = 1, dataProvider = "LoginDataProvider")
    public void VerifyLogin(String userEmail, String userPwd) {
        System.out.println("Testing login with: " + userEmail + " / " + userPwd);
        LoginPage lp = new LoginPage(driver);
        lp.loginToPortal(userEmail, userPwd);

    }


    @DataProvider(name = "LoginDataProvider")
    public Object[][] LoginDataProvider() {
        List<Map<Integer, String>> data = ReadExcelFile.readExcelData(fileName, "LoginData");

        int ttlRows = ReadExcelFile.getRowCount(data);
        int ttlColumns = ReadExcelFile.getColCount(data);

        Object[][] testData = new Object[ttlRows][ttlColumns];

        for (int i = 0; i < ttlRows; i++) {
            testData[i][0] = data.get(i).get(0); // Kullanıcı adı (1. sütun)
            testData[i][1] = data.get(i).get(1); // Şifre (2. sütun)
        }
        return testData;
          // ****Hepsiburada sayfası bu işlemi otomasyon için engellediğinden dolayı çalışmıyor****
    }
}
