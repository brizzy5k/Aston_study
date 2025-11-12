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
    public void checkPaymentFormContinueButton() {
        fillPaymentForm();
        checkContinueButton();
    }

    private void fillPaymentForm() {
        try {
            WebElement serviceType = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//div[contains(@class,'personal')]//*[contains(text(), 'Услуги связи')]")
                    ));
            serviceType.click();
            logger.info("Выбран тип: Услуги связи");
        } catch (Exception e) {
            logger.error("Ошибка выбора типа услуг", e);
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
        }
    }

    private void checkContinueButton() {
        WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'personal')]//button[contains(text(),'Продолжить')]")
        ));
        assertTrue(continueButton.isDisplayed(), "Кнопка 'Продолжить' не отображается");
        assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' не активна");
        logger.info("Кнопка 'Продолжить' активна и отображается");

        try {
            continueButton.click();
            logger.info("Клик по кнопке 'Продолжить' выполнен");
        } catch (ElementClickInterceptedException e) {
            logger.error("Кнопка 'Продолжить' не сработала", e);
        }

        try {
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//iframe[contains(@class,'bepaid-iframe')]")
            ));
            driver.switchTo().frame(iframe);
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//div[contains(@class,'app-wrapper__content ng-tns-c1057872785-0')]")
            ));
            logger.info("Переключение на iframe 'bepaid-iframe' произошло успешно");
        } catch (Exception e) {
            logger.error("Изменений на странице после кнопки 'Продолжить' не обнаружено", e);
        }
    }
}