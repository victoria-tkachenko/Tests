import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import static pages.Configuration.BASE_URL;

public class BaseTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    LoginPage loginPage;
    Cookie cookie;

    @BeforeAll
    static void beforeAll() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 5);
        loginPage = new LoginPage(driver);
        driver.get(BASE_URL);
    }

    @AfterEach
    void tearDown() {
            driver.quit();
    }
}
