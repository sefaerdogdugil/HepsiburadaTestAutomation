package com.hbtestautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    WebDriver driver;
    Actions actions;

    // constructor
    public LoginPage(WebDriver lDriver) {
        this.driver = lDriver;
        this.actions = new Actions(driver);  // Initialize Actions class here
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptButton;

    @FindBy(xpath = "//div[@id='myAccount']")
    WebElement findLogin;

    @FindBy(id = "login")
    WebElement loginclick;

    @FindBy(xpath = "//input[@id='txtUserName']")
    WebElement uname;

    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement pass;

    @FindBy(xpath = "//button[@id='btnLogin']")
    WebElement loginButton;

    // Method for login
    public void loginPortal(String username, String password) throws InterruptedException {
        acceptButton.click();
        Thread.sleep(2000);
        // Hover over the findLogin element
        actions.moveToElement(findLogin).perform();

        // Adding a wait for the hover effect to be processed
        Thread.sleep(2000);

        // Click on the login link
        loginclick.click();

        // Enter the username and password
        uname.sendKeys(username);
        pass.sendKeys(password);

        // Click the login button
        loginButton.click();
        Thread.sleep(5000);
    }

    // Method to clear username and password fields
    public void clearUsernamePassword() {
        uname.clear();
        pass.clear();
    }
}
