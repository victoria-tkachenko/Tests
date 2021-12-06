import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.LoginPage;
import pages.MainPage;
import pages.RemindPasswordPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.exists;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class LoginTests extends BaseTest {

    @Test
    void validDataLogin() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena")
                .fillInputPassword("1P73BP4Z")
                .submitLogin();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new MainPage(driver).requestSuccessLocator)));

        assertThat(new MainPage(driver).employeeName, isDisplayed());
    }

    @Test
    void incorrectLoginInput() {
        new LoginPage(driver)
                .fillInputLogin("123456")
                .fillInputPassword("1P73BP4Z")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации", alert.getText());
    }

    @Test
    void incorrectPasswordInput() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena")
                .fillInputPassword("123456")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации", alert.getText());
    }

    @Test
    void incorrectBothLoginAndPasswordInput() {
        new LoginPage(driver)
                .fillInputLogin("fydiujijh")
                .fillInputPassword("123456")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации", alert.getText());
    }

    @Test
    void blankPasswordInput() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации.", alert.getText());
    }

    @Test
    void blankLoginInput() {
        new LoginPage(driver)
                .fillInputPassword("123456")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации.", alert.getText());
    }

    @Test
    void blankBothLoginAndPasswordInput() {
        new LoginPage(driver)
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации.", alert.getText());
    }

    @Test
    void spaceBeforeLoginInput() {
        new LoginPage(driver)
                .fillInputLogin(" fominaelena")
                .fillInputPassword("1P73BP4Z")
                .submitLogin();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new MainPage(driver).requestSuccessLocator)));

        assertThat(new MainPage(driver).employeeName, isDisplayed());
    }

    @Test
    void spaceAfterLoginInput() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena ")
                .fillInputPassword("1P73BP4Z")
                .submitLogin();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new MainPage(driver).requestSuccessLocator)));

        assertThat(new MainPage(driver).employeeName, isDisplayed());
    }

    @Test
    void spaceOnlyLoginInput() {
        new LoginPage(driver)
                .fillInputLogin(" ")
                .fillInputPassword("1P73BP4Z")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации.", alert.getText());
    }

    @Test
    void spaceOnlyPasswordInput() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena")
                .fillInputPassword(" ")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации.", alert.getText());
    }

    @Test
    void endOfStringInLoginInput() throws UnhandledAlertException {
        new LoginPage(driver)
                .fillInputLogin("fominaelena\n")
                .fillInputPassword("1P73BP4Z")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации.", alert.getText());
        //этот текст не проходит
    }

    @Test
    void spaceBeforePasswordInput() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena")
                .fillInputPassword(" 1P73BP4Z")
                .submitLogin();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new MainPage(driver).requestSuccessLocator)));

        assertThat(new MainPage(driver).employeeName, isDisplayed());
    }

    @Test
    void spaceAfterPasswordInput() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena")
                .fillInputPassword("1P73BP4Z ")
                .submitLogin();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new MainPage(driver).requestSuccessLocator)));

        assertThat(new MainPage(driver).employeeName, isDisplayed());
    }

    @Test
    void spaceInLoginInput() {
        new LoginPage(driver)
                .fillInputLogin("fomina elena")
                .fillInputPassword("1P73BP4Z")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации", alert.getText());
    }

    @Test
    void passwordInsteadOfLoginAndLoginInsteadOfPasswordInput() {
        new LoginPage(driver)
                .fillInputLogin("1P73BP4Z")
                .fillInputPassword("fominaelena")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации", alert.getText());
    }

    @Test
    void capsLockInLoginInput() {
        new LoginPage(driver)
                .fillInputLogin("FOMINAELENA")
                .fillInputPassword("1P73BP4Z")
                .submitLogin();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new MainPage(driver).requestSuccessLocator)));

        assertThat(new MainPage(driver).employeeName, isDisplayed());
    }

    @Test
    void differentCaseLoginInput() {
        new LoginPage(driver)
                .fillInputLogin("FominaElena")
                .fillInputPassword("1P73BP4Z")
                .submitLogin();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new MainPage(driver).requestSuccessLocator)));

        assertThat(new MainPage(driver).employeeName, isDisplayed());
    }

    @Test
    void differentCasePasswordInput() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena")
                .fillInputPassword("1p73BP4z")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации", alert.getText());
    }

    @Test
    void loginWithTagInput() {
        new LoginPage(driver)
                .fillInputLogin("<fominaelena>")
                .fillInputPassword("1P73BP4Z")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации", alert.getText());
    }

    @Test
    void injectionSQL() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena")
                .fillInputPassword("'OR '1'='1'")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации", alert.getText());
    }

    @Test
    void injectionXSS() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena")
                .fillInputPassword("<script>alert(\"xss!\")</script>")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации", alert.getText());
    }

    @Test
    void injectionHTML() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena")
                .fillInputPassword("<textarea />")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации", alert.getText());
    }

    @Test
    void specSymbolsInput() {
        new LoginPage(driver)
                .fillInputLogin("fominaelena")
                .fillInputPassword("<!--:")
                .submitLogin();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Неверные данные для авторизации", alert.getText());
    }

    @Test
    void passwordBecomesVisible() {
        new LoginPage(driver)
                .makePasswordVisible();

        assertThat(new LoginPage(driver).inputPasswordVisible, exists());
    }

    @Test
    void forgotPassword (){
        new LoginPage(driver)
                .forgotPasswordClick();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new RemindPasswordPage(driver).requestSuccessLocator)));

        assertThat(new RemindPasswordPage(driver).restorePasswordForm, isDisplayed());
    }
}
