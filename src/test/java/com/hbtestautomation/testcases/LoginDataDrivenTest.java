package com.hbtestautomation.testcases;

import com.hbtestautomation.pages.BaseTest;
import com.hbtestautomation.pages.LoginPage;
import com.hbtestautomation.utility.ReadExcelFile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDataDrivenTest extends BaseTest {

    String fileName = System.getProperty("user.dir") + "\\TestData\\TestInfo.xlsx";

    @Test(dataProvider = "LoginDataProvider")
    void VerifyLogin(String username, String password) throws InterruptedException {
        System.out.println("Test Data - Username: " + username + ", Password: " + password);
        LoginPage lp = new LoginPage(driver);
        lp.loginPortal(username, password);
        lp.clearUsernamePassword(); // Comment out if needed for debugging
    }

    @DataProvider(name = "LoginDataProvider")
    public String[][] LoginDataProvider() {
        int ttlRows = ReadExcelFile.getRowCount(fileName, "TestData");
        int ttlColumns = ReadExcelFile.getColCount(fileName, "TestData");

        String[][] data = new String[ttlRows - 1][ttlColumns]; // Java-style array declaration

        for (int i = 1; i < ttlRows; i++) {
            for (int j = 0; j < ttlColumns; j++) {
                String cellValue = ReadExcelFile.getCellValue(fileName, "TestData", i, j);
                System.out.println("Reading Cell[" + i + "][" + j + "]: " + cellValue); // Log value
                data[i - 1][j] = cellValue;
            }
        }
        return data;
    }

}
