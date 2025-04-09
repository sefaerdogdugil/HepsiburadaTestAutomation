package com.hbtestautomation.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(css = ".seoAnchorLink-nCW0yP4qoVI_AhEjVAY_.treeCategoryContent-XPVj5InCxOWIJtyTC35Z.treeCategoryContent-MyO6mtk47l73JXmpol8O")
    WebElement searchResult;

    @FindBy(css = ".sf-OldHeader-FpTYTu4Avgrxt5ZgRSEL")
    WebElement logoMain;

    @FindBy(css = "body > div:nth-child(2) > div:nth-child(1) > div:nth-child(5) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1)")
    List<WebElement> menuList;

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

    public boolean isSearchResultDisplayed() {
        try {
            return searchResult.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLogoMainDisplayed() {
        try {
            return logoMain.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public boolean isMenuDisplayed() {
        if (menuList == null || menuList.isEmpty()) {
            System.out.println("Menu list is empty or null.");
            return false;
        }

        try {
            System.out.println("Checking menu items:");
            for (WebElement menuItem : menuList) {
                if (menuItem.isDisplayed()) {
                    System.out.println("Menu item is displayed: " + menuItem);
                    return true;
                }
            }
            System.out.println("No menu items are displayed.");
            return false;
        } catch (Exception e) {
            System.out.println("An error occurred while checking menu display: " + e.getMessage());
            return false;
        }
    }

}



