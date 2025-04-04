package com.hbtestautomation.pages;

import java.io.File;
import java.io.IOException;

import com.hbtestautomation.utility.BrowserFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.hbtestautomation.utility.ConfigDataProviders;

public class BaseTest {

    public WebDriver driver;
    public ConfigDataProviders config;

    // ChromeOptions nesnesini burada oluşturuyoruz
    ChromeOptions options;

    @BeforeSuite
    public void setUpSuite() {
        config = new ConfigDataProviders();
    }

    @BeforeClass
    public void setUp() {
        // ChromeOptions nesnesini oluşturuyoruz ve ayarları yapıyoruz
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");          // Bildirimleri engelle
        options.addArguments("--disable-popup-blocking");        // Pop-up engelleme
        options.addArguments("--disable-extensions");            // Uzantıları devre dışı bırak
        options.addArguments("--incognito");                     // Gizli mod
        options.addArguments("start-maximized");                 // Tarayıcıyı maksimum yap
        options.addArguments("--disable-infobars");              // Bilgilendirme çubuklarını devre dışı bırak
        options.addArguments("--disable-features=CookiesWithSameSiteMustBeSecure"); // Çerez güvenlik özelliklerini devre dışı bırak

        // BrowserFactory ile tarayıcıyı başlatıyoruz
        driver = BrowserFactory.startApplication(config.getBrowser(), config.getStagingUrl(), options);
    }

    @AfterClass
    public void tearDown() {
        // Tarayıcıyı kapatıyoruz
        BrowserFactory.quitBrowser(driver);
    }

    // Screenshot alma metodu
    public void captureScreenShot(WebDriver driver, String testName) throws IOException {
        // WebDriver'ı TakesScreenshot arayüzüne çeviriyoruz
        TakesScreenshot screenshot = ((TakesScreenshot) driver);

        // Screenshot alıyoruz
        File src = screenshot.getScreenshotAs(OutputType.FILE);

        // Screenshot'ı kaydedeceğimiz yeri belirliyoruz
        File srcPath = new File("." + "//Screenshots//" + testName + ".png");

        // Screenshot'ı hedef dizine kopyalıyoruz
        FileUtils.copyFile(src, srcPath);
    }
}
