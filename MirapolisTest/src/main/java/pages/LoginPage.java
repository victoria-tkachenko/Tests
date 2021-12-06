package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseSetup{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Введите ваш логин']")
    public WebElement inputLogin;

    @FindBy(xpath = "//input[@placeholder='Введите ваш пароль']")
    public WebElement inputPassword;

    @FindBy(id = "button_submit_login_form")
    public WebElement buttonSubmit;

    @FindBy(id = "show_password")
    public WebElement buttonVisiblePassword;

    @FindBy(xpath = "//input[@placeholder='Введите ваш пароль'] [@type='text']")
    public WebElement inputPasswordVisible;

    @FindBy(xpath = "//td/a/div[contains(text(), 'Забыли пароль?')] ")
    public WebElement forgotPassword;



    public LoginPage fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public MainPage submitLogin() {
        buttonSubmit.click();
        return new MainPage(driver);
    }

    public LoginPage makePasswordVisible() {
        buttonVisiblePassword.click();
        return this;
    }

    public RemindPasswordPage forgotPasswordClick() {
        forgotPassword.click();
        return new RemindPasswordPage(driver);
    }

}
