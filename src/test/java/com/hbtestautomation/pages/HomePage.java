package com.hbtestautomation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    WebDriver driver;
    Actions action;

    public HomePage(WebDriver lDriver) {
        this.driver = lDriver;
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@aria-label='Site İçi Arama']")
    WebElement searchBox;

    @FindBy(xpath = "//input[@placeholder='Ürün, kategori veya marka ara']")
    WebElement searchIndex;

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptButton;

    public void searchProduct(String productName) throws InterruptedException {

        Thread.sleep(5000);
        acceptButton.click();
        Thread.sleep(10000);

        try {
            searchBox.click();
        } catch (StaleElementReferenceException e) {
            searchBox.click();
        }
        Thread.sleep(5000);

        searchIndex.sendKeys(productName);
        action.sendKeys(Keys.ENTER).perform();  // ACTIONS nesnesi üzerinden ENTER tuşu gönderiliyor
    }
}
