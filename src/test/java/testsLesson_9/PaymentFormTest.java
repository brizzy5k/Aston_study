package testsLesson_9;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentFormTest extends BaseTest{
    private final Logger logger = LoggerFactory.getLogger(PaymentFormTest.class);

    @Test
    public void checkPaymentFormTest() {
        try {
            WebElement serviceType = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[contains(@class,'personal')]//*[contains(text(), 'Услуги связи')]")
                    ));
            serviceType.click();
            logger.info("Выбран тип: Услуги связи");
        } catch (Exception e) {
            logger.error("Ошибка выбора типа услуг", e);
            fail("Не удалось выбрать тип услуг");
        }

        WebElement phoneInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'телефон')]")
        ));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");
        logger.info("Введен номер: 297777777");

        try {
            WebElement amountInput = driver.findElement(
                    By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'Сумма')]")
            );
            amountInput.clear();
            amountInput.sendKeys("5");
            logger.info("Введена сумма: 5");
        } catch (Exception e) {
            logger.error("Поле суммы не найдено", e);
            fail("Не удалось ввести сумму");
        }

        WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'personal')]//button[contains(text(),'Продолжить')]")
        ));
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        logger.info("Кнопка 'Продолжить' отображается");
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        logger.info("Кнопка 'Продолжить' активна");

        try {
            continueButton.click();
            logger.info("Клик по кнопке 'Продолжить' выполнен");
        } catch (ElementClickInterceptedException e) {
            logger.error("Кнопка 'Продолжить' не сработала", e);
            fail("Не удалось кликнуть по кнопке 'Продолжить'");
        }

        boolean isServiceInfoFound = false;
        String foundText = "";

        try {
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//iframe[contains(@class,'bepaid-iframe')]")
            ));
            driver.switchTo().frame(iframe);
            logger.info("Переключение на iframe 'bepaid-iframe' произошло успешно");

            WebElement uniqueInfoElement = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//*[contains(text(), 'Оплата: Услуги связи') and contains(text(), 'Номер:375297777777')]")
            ));
            wait.until(ExpectedConditions.visibilityOf(uniqueInfoElement));
            isServiceInfoFound = true;
            foundText = uniqueInfoElement.getText();
            logger.info("Найдена уникальная информация: '{}'", foundText);

        } catch (Exception e) {
            logger.error("Уникальная информация не найдена в iframe", e);
        } finally {
            driver.switchTo().defaultContent();
        }

        assertTrue(isServiceInfoFound,
                "Не найдена уникальная информация в iframe. " +
                        "Ожидалось: 'Оплата: Услуги связи Номер:375297777777'");
    }
}