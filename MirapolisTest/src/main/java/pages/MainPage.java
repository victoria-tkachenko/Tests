package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseSetup{
    public MainPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = requestSuccessLocator)
    public WebElement employeeName;
    public static final String requestSuccessLocator = "//*[contains(text(), ' Фомина Елена Сергеевна')]";

}
