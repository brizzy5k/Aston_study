package org.Aston_study.lesson_10.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Objects;

public class SeleniumDriver {
    private static ChromeOptions options;
    public static void setOptions(ChromeOptions chromeOptions) {
        options = chromeOptions;
    }

    private final static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getInstance() {
        if (Objects.isNull(driver.get())) {
            driver.set(new ChromeDriver(options));
        }
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
