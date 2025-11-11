package testsLesson_10;

import org.Aston_study.lesson_10.driver.SeleniumDriver;
import org.Aston_study.lesson_10.page.MtsPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {
    protected  WebDriver driver;
    protected  WebDriverWait wait;
    protected  MtsPage mtsPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        SeleniumDriver.setOptions(options);
        driver = SeleniumDriver.getInstance();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.mts.by");
        mtsPage = new MtsPage(driver);
        mtsPage.acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        SeleniumDriver.closeDriver();
    }
}