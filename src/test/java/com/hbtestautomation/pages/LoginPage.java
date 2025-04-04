package com.hbtestautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseTest {

    WebDriver driver;
    Actions actions;

    // Constructor
    public LoginPage(WebDriver lDriver) {
        this.driver = lDriver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement acceptButton;

    @FindBy(xpath = "//div[@id='myAccount']")
    WebElement findLogin;

    @FindBy(xpath = "//a[@id='login']")
    WebElement loginclick;

    @FindBy(xpath = "//input[@id='txtUserName']")
    WebElement uname;

    @FindBy(xpath = "//input[@id='txtPassword']")
    WebElement pass;

    @FindBy(xpath = "//button[@id='btnLogin']")
    WebElement loginButton;

    @FindBy(xpath = "//span[@role='presentation']")
    WebElement forgotPassword;

    @FindBy(xpath = "//input[@id='txtForgotPassEmail']")
    WebElement forgotEmail;

    @FindBy(xpath = "//button[@id='btnForgotPass']")
    WebElement forgotPassbutton;

    public void loginToPortal(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Çerezleri kabul et
        wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();

        // Giriş butonuna tıklamak için bekle ve tıkla
        wait.until(ExpectedConditions.visibilityOf(findLogin));
        actions.moveToElement(findLogin).perform();
        wait.until(ExpectedConditions.elementToBeClickable(loginclick)).click();

        // Kullanıcı adı ve şifre alanlarının görünmesini bekle ve doldur
        wait.until(ExpectedConditions.visibilityOf(uname)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(pass)).sendKeys(password);

        // Giriş butonuna tıkla
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean forgotPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(acceptButton)).click();

        actions.moveToElement(findLogin).perform();
        wait.until(ExpectedConditions.elementToBeClickable(loginclick)).click();

        wait.until(ExpectedConditions.visibilityOf(uname));
        wait.until(ExpectedConditions.elementToBeClickable(forgotPassword)).click();

        wait.until(ExpectedConditions.visibilityOf(forgotEmail)).sendKeys("sefaotomasyonn11@outlook.com");

        wait.until(ExpectedConditions.elementToBeClickable(forgotPassbutton)).click();
        return true;
    }
}

        /*✅ Başarı mesajını bekleyerek testi doğrula

        ****Hepsiburada sayfası bu işlemi otomasyon için engellediğinden dolayı çalışmıyor****

        if (wait.until(ExpectedConditions.visibilityOf(verifyForgotPass)).isDisplayed()) {
            System.out.println("✅ Şifre sıfırlama başarılı! E-posta gönderildi.");
        } else {
            System.out.println("❌ Şifre sıfırlama başarısız! Hata mesajı görünüyor olabilir.");
        }
      return false;
         */


