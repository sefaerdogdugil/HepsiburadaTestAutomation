package com.hbtestautomation.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;


public class CartPage {
    private static final Logger logger = LoggerFactory.getLogger(CartPage.class);

    WebDriver driver;
    Actions action;
    WebDriverWait wait;

    public CartPage(WebDriver lDriver) {
        this.driver = lDriver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }


    public boolean addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean allSuccessful = true;
        String originalWindow = driver.getWindowHandle();

        for (int i = 0; i < 5; i++) {
            try {
                String productXPath = "//li[@id='i" + i + "']//a";
                WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productXPath)));
                productLink.click();

                // Yeni sekme açılmasını bekle
                wait.until(driver -> driver.getWindowHandles().size() > 1);
                for (String windowHandle : driver.getWindowHandles()) {
                    if (!windowHandle.equals(originalWindow)) {
                        driver.switchTo().window(windowHandle);
                        break;
                    }
                }

                // Sepete Ekle butonunu bul ve tıkla
                WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@data-test-id='addToCart']")));
                addToCartBtn.click();

                logger.info("✅ Sepete eklendi: i{}", i);

                // Kısa bekleme (opsiyonel)
                Thread.sleep(1500);

                // Sekmeyi kapat ve ana pencereye dön
                driver.close();
                driver.switchTo().window(originalWindow);

                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='i0']")));

            } catch (Exception e) {
                logger.error("❌ Hata oluştu: i{} - {}", i, e.getMessage());
                allSuccessful = false;
                try {
                    driver.switchTo().window(originalWindow);
                } catch (Exception ignore) {}
            }
        }

        return allSuccessful;
    }
}

