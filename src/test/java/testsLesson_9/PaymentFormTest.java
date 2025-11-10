package testsLesson_9;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentFormTest extends BaseTest{
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
            System.out.println("Выбран тип: Услуги связи");
        } catch (Exception e) {
            System.out.println("Ошибка выбора типа услуг");
        }

        WebElement phoneInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'телефон')]")
        ));
        phoneInput.clear();
        phoneInput.sendKeys("297777777");
        System.out.println("Введен номер: 297777777");

        try {
            WebElement amountInput = driver.findElement(
                    By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'Сумма')]")
            );
            amountInput.clear();
            amountInput.sendKeys("5");
            System.out.println("Введена сумма: 5");
        } catch (Exception e) {
            System.out.println("Поле суммы не найдено");
        }
    }

    private void checkContinueButton() {
        WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@class,'personal')]//button[contains(text(),'Продолжить')]")
        ));
        assertTrue(continueButton.isDisplayed(), "Кнопка 'Продолжить' не отображается");
        assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' не активна");
        System.out.println("Кнопка 'Продолжить' активна и отображается");

        try {
            continueButton.click();
            System.out.println("Клик по кнопке 'Продолжить' выполнен");
        } catch (ElementClickInterceptedException e) {
            System.out.println("Кнопка 'Продолжить' не сработала");
        }

        try {
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//iframe[contains(@class,'bepaid-iframe')]")
            ));
            driver.switchTo().frame(iframe);
            wait.until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//div[contains(@class,'app-wrapper__content ng-tns-c1057872785-0')]")
            ));
            System.out.println("Переключение на iframe 'bepaid-iframe' произошло успешно");
        } catch (Exception e) {
            System.out.println("Изменений на странице после кнопки 'Продолжить' не обнаружено");
        }
    }
}
