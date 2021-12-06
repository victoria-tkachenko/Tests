package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RemindPasswordPage extends BaseSetup{
    public RemindPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = requestSuccessLocator)
    public WebElement restorePasswordForm;
    public static final String requestSuccessLocator = "//div[contains(text(), 'Восстановление пароля')]";
}
