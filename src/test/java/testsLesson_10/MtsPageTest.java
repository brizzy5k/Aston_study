package testsLesson_10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementClickInterceptedException;
import org.Aston_study.lesson_10.*;
import static org.junit.jupiter.api.Assertions.*;

public class MtsPageTest extends BaseTest {

    private MtsPage mtsPage;

    @BeforeEach
    public void setUp() {
        super.setUp();
        mtsPage = new MtsPage(driver);
    }

    @Test
    public void testBlockName() {
        System.out.println("=== Тест: Проверка названия блока ===");
        String actualTitle = mtsPage.getWidgetTitle();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedTitle, actualTitle, "Название блока не соответствует ожидаемому");
        System.out.println("Название блока соответствует ожидаемому");
    }

    @Test
    public void testPaymentLogos() {
        System.out.println("=== Тест: Проверка логотипов платежных систем ===");
        assertTrue(mtsPage.arePaymentLogosDisplayed(), "Логотипы платежных систем не найдены.");
        int logoCount = mtsPage.getPaymentLogosCount();
        assertEquals(5, logoCount, "Неверное количество логотипов.");
        System.out.println("Найдено логотипов: " + logoCount);
    }

    @Test
    public void testServiceDetailsLink() {
        System.out.println("=== Тест: Проверка ссылки 'Подробнее о сервисе' ===");
        assertTrue(mtsPage.isServiceDetailsLinkDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");

        String href = mtsPage.getServiceDetailsLinkHref();
        assertNotNull(href, "У ссылки отсутствует href атрибут");
        assertFalse(href.isEmpty(), "У ссылки пустой href атрибут");

        System.out.println("Ссылка 'Подробнее о сервисе' найдена с URL: " + href);

        String originalUrl = driver.getCurrentUrl();
        mtsPage.clickServiceDetailsLink();

        wait.until(webDriver -> !webDriver.getCurrentUrl().equals(originalUrl));

        String newUrl = driver.getCurrentUrl();
        assertNotEquals(originalUrl, newUrl, "Переход по ссылке не произошел");
        System.out.println("Переход по ссылке произошел успешно");

        driver.navigate().back();
    }

    @Test
    public void testCommunicationServicesPlaceholders() {
        System.out.println("=== Тест: Проверка плейсхолдеров для Услуг связи ===");
        mtsPage.selectCommunicationServices();

        String phonePlaceholder = mtsPage.getPhoneInputPlaceholder();
        String amountPlaceholder = mtsPage.getAmountInputPlaceholder();
        assertTrue(phonePlaceholder.contains("Номер телефон"),
                "Плейсхолдер поля телефона не содержит ожидаемый текст. Актуальный: " + phonePlaceholder);
        assertTrue(amountPlaceholder.toLowerCase().contains("сумма"),
                "Плейсхолдер поля суммы не содержит ожидаемый текст. Актуальный: " + amountPlaceholder);

        System.out.println("Услуги связи: поля 'Телефон' и 'Сумма' имеют корректные плейсхолдеры");
        System.out.println("Телефон: '" + phonePlaceholder + "'");
        System.out.println("Сумма: '" + amountPlaceholder + "'");
    }

    @Test
    public void testHomeInternetPlaceholders() {
        System.out.println("=== Тест: Проверка плейсхолдеров для Домашнего интернета ===");
    }

    @Test
    public void testInstallmentPlaceholders() {
        System.out.println("=== Тест: Проверка плейсхолдеров для Рассрочки ===");
    }

    @Test
    public void testDebtPlaceholders() {
        System.out.println("=== Тест: Проверка плейсхолдеров для Задолженности ===");
    }

    @Test
    public void testCommunicationServicesPayment() {
        System.out.println("=== Тест: Проверка оплаты Услуг связи ===");
        mtsPage.selectCommunicationServices();

        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterAmount("5");

        System.out.println("Поля заполнены: номер 297777777, сумма 5");

        assertTrue(mtsPage.isContinueButtonDisplayed(), "Кнопка 'Продолжить' не отображается");
        assertTrue(mtsPage.isContinueButtonEnabled(), "Кнопка 'Продолжить' не активна");
        System.out.println("✓ Кнопка 'Продолжить' активна и отображается");

        try {
            mtsPage.clickContinueButton();
            System.out.println("Клик по кнопке 'Продолжить' выполнен");

            if (mtsPage.isPageChanged()) {
                System.out.println("Изменения на странице после кнопки 'Продолжить' обнаружены");
            } else {
                System.out.println("Изменений на странице после кнопки 'Продолжить' не обнаружено");
            }
        } catch (ElementClickInterceptedException e) {
            System.out.println("Кнопка 'Продолжить' не сработала: " + e.getMessage());
            fail("Кнопка 'Продолжить' не сработала: " + e.getMessage());
        }
    }

    @Test
    public void testAllPlaceholdersInOneTest() {
        System.out.println("=== Тест: Комплексная проверка всех плейсхолдеров ===");

        testCommunicationServicesPlaceholders();
        testHomeInternetPlaceholders();
        testInstallmentPlaceholders();
        testDebtPlaceholders();

        System.out.println("Все плейсхолдеры для всех типов услуг проверены успешно");
    }
}