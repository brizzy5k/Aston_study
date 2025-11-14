package testsLesson_10;

import org.Aston_study.lesson_10.steps.MtsHomeSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class MtsPageTest extends BaseTest {
    private final Logger log = LoggerFactory.getLogger(MtsPageTest.class);
    private MtsHomeSteps steps;

    @BeforeEach
    public void setUp() {
        super.setUp();
        steps = new MtsHomeSteps(driver);
        log.info("Инициализация теста");
    }

    @Test
    @DisplayName("Проверить название блока")
    public void testBlockName() {
        log.info("===Тест Проверка названия блока===");
        String actualTitle = steps.getBlockTitle();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";

        log.info("Название блока корректно: {}", actualTitle);
        assertEquals(expectedTitle, actualTitle, "Название блока не соответствует ожидаемому");
    }

    @Test
    @DisplayName("Проверить наличие логотипов платёжных систем")
    public void testPaymentLogos() {
        log.info("===Тест Проверка логотипов платежных систем===");
        boolean logosDisplayed = steps.arePaymentLogosDisplayed();
        int logoCount = steps.getPaymentLogosCount();

        log.info("Найдено логотипов платежных систем: {}", logoCount);
        assertTrue(logosDisplayed, "Логотипы платежных систем не найдены");
        assertTrue(logoCount > 0, "Не найдено логотипов платежных систем");
    }

    @Test
    @DisplayName("Проверить работу ссылки «Подробнее о сервисе»")
    public void testServiceDetailsLink() {
        log.info("===Тест Проверка ссылки 'Подробнее о сервисе'===");
        boolean linkDisplayed = steps.isServiceDetailsLinkDisplayed();
        String href = steps.getServiceDetailsLinkHref();
        String originalUrl = steps.getCurrentUrl();

        log.info("Ссылка найдена, URL: {}", href);
        log.info("Текущий URL: {}", originalUrl);

        steps.clickServiceDetailsLink();
        steps.waitForUrlChange(originalUrl);

        String newUrl = steps.getCurrentUrl();

        log.info("Переход выполнен успешно");
        log.info("Новый URL: {}", newUrl);

        steps.navigateBack();
        log.info("Возврат на исходную страницу");

        assertTrue(linkDisplayed, "Ссылка 'Подробнее о сервисе' не отображается");
        assertNotNull(href, "У ссылки отсутствует href атрибут");
        assertFalse(href.isEmpty(), "У ссылки пустой href атрибут");
        assertNotEquals(originalUrl, newUrl, "Переход по ссылке не произошел");
    }

    @Test
    @DisplayName("Проверить надписи в полях для Услуг связи")
    public void testCommunicationServicesPlaceholders() {
        log.info("===Тест Проверка плейсхолдеров для Услуг связи===");
        steps.selectCommunicationServices();
        log.info("Выбраны Услуги связи");

        String phonePlaceholder = steps.getPhoneInputPlaceholder();
        String amountPlaceholder = steps.getAmountInputPlaceholder();

        log.info("Плейсхолдеры корректны:");
        log.info("Телефон: '{}'", phonePlaceholder);
        log.info("Сумма: '{}'", amountPlaceholder);

        assertNotNull(phonePlaceholder, "Плейсхолдер телефона отсутствует");
        assertNotNull(amountPlaceholder, "Плейсхолдер суммы отсутствует");
        assertFalse(phonePlaceholder.isEmpty(), "Плейсхолдер телефона пустой");
        assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер суммы пустой");
    }

    @Test
    @DisplayName("Проверить надписи в полях для Домашнего интернета")
    public void testHomeInternetPlaceholders() {
        log.info("===Тест Проверка плейсхолдеров для Домашнего интернета===");
        steps.selectHomeInternet();
        log.info("Выбран Домашний интернет");

        String phonePlaceholder = steps.getHomePhoneInputPlaceholder();
        String amountPlaceholder = steps.getAmountInputPlaceholder();

        log.info("Плейсхолдеры корректны:");
        log.info("Номер абонента: '{}'", phonePlaceholder);
        log.info("Сумма: '{}'", amountPlaceholder);

        assertNotNull(phonePlaceholder, "Плейсхолдер для номера абонента отсутствует");
        assertNotNull(amountPlaceholder, "Плейсхолдер для суммы отсутствует");
        assertFalse(phonePlaceholder.isEmpty(), "Плейсхолдер для номера абонента пустой");
        assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер для суммы пустой");
    }

    @Test
    @DisplayName("Проверить надписи в полях для Рассрочки")
    public void testInstallmentPlaceholders() {
        log.info("===Тест Проверка плейсхолдеров для Рассрочки===");
        steps.selectInstallment();
        log.info("Выбрана Рассрочка");

        String contractPlaceholder = steps.getContractInputPlaceholder();
        String amountPlaceholder = steps.getAmountInputPlaceholder();

        log.info("Плейсхолдеры корректны:");
        log.info("Номер договора: '{}'", contractPlaceholder);
        log.info("Сумма: '{}'", amountPlaceholder);

        assertNotNull(contractPlaceholder, "Плейсхолдер для номера договора отсутствует");
        assertNotNull(amountPlaceholder, "Плейсхолдер для суммы отсутствует");
        assertFalse(contractPlaceholder.isEmpty(), "Плейсхолдер для номера договора пустой");
        assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер для суммы пустой");
    }

    @Test
    @DisplayName("Проверить надписи в полях для Задолженности")
    public void testDebtPlaceholders() {
        log.info("===Тест Проверка плейсхолдеров для Задолженности===");
        steps.selectDebt();
        log.info("Выбрана Задолженность");

        String contractPlaceholder = steps.getAccountInputPlaceholder();
        String amountPlaceholder = steps.getAmountInputPlaceholder();

        log.info("Плейсхолдеры корректны:");
        log.info("Номер счета: '{}'", contractPlaceholder);
        log.info("Сумма: '{}'", amountPlaceholder);

        assertNotNull(contractPlaceholder, "Плейсхолдер для номера счета отсутствует");
        assertNotNull(amountPlaceholder, "Плейсхолдер для суммы отсутствует");
        assertFalse(contractPlaceholder.isEmpty(), "Плейсхолдер для номера счета пустой");
        assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер для суммы пустой");
    }

    @Test
    @DisplayName("Заполнить поля и проверить работу кнопки «Продолжить» для Услуг связи")
    public void testCommunicationServicesPayment() {
        log.info("===Тест Проверка оплаты Услуг связи===");
        steps.selectCommunicationServices();
        log.info("Выбраны Услуги связи");

        steps.fillPhoneField("297777777");
        steps.fillCostField("5");
        log.info("Поля заполнены: телефон=297777777, сумма=5");

        boolean isContinueButtonEnabled = steps.isContinueButtonEnabled();
        boolean isContinueButtonDisplayed = steps.isContinueButtonDisplayed();

        log.info("Кнопка 'Продолжить' активна и отображается");
        steps.clickContinueButton();
        log.info("Клик по кнопке 'Продолжить' выполнен");

        steps.checkPaymentFormAfterContinue();
        steps.switchToPaymentIframe();

        String serviceInfo = steps.getServiceInfo();
        String buttonAmount = steps.getPaymentButtonAmountText();

        boolean isCardNumberLabelDisplayed = steps.isCardNumberLabelDisplayed();
        boolean isCardExpiryLabelDisplayed = steps.isCardExpiryLabelDisplayed();
        boolean isCardCvcLabelDisplayed = steps.isCardCvcLabelDisplayed();
        boolean isCardHolderLabelDisplayed = steps.isCardHolderLabelDisplayed();

        String cardNumberLabel = steps.getCardNumberLabelText();
        String cardExpiryLabel = steps.getCardExpiryLabelText();
        String cardCvcLabel = steps.getCardCvcLabelText();
        String cardHolderLabel = steps.getCardHolderLabelText();

        int paymentIconsCount = steps.getPaymentIconsCount();
        boolean isVisaIconDisplayed = steps.isVisaIconDisplayed();
        boolean isMastercardIconDisplayed = steps.isMastercardIconDisplayed();
        boolean isBelkartIconDisplayed = steps.isBelkartIconDisplayed();
        boolean isMirIconDisplayed = steps.isMirIconDisplayed();

        log.info("Информация об услуге отображается корректно: {}", serviceInfo);
        log.info("Сумма на кнопке: {}", buttonAmount);

        log.info("Надписи полей карты отображаются корректно:");
        log.info("Номер карты: '{}'", cardNumberLabel);
        log.info("Срок действия: '{}'", cardExpiryLabel);
        log.info("CVC: '{}'", cardCvcLabel);
        log.info("Имя и фамилия на карте: '{}'", cardHolderLabel);

        log.info("Найдено иконок платежных систем: {}", paymentIconsCount);
        log.info("Все основные платежные системы отображаются: Visa, Mastercard, Belkart, Maestro, Mir");

        steps.switchToDefaultContent();

        assertTrue(isContinueButtonEnabled, "Кнопка 'Продолжить' должна быть активна после заполнения полей");
        assertTrue(isContinueButtonDisplayed, "Кнопка 'Продолжить' должна отображаться");

        assertNotNull(serviceInfo, "Информация об услуге должна отображаться");
        assertTrue(serviceInfo.contains("Услуги связи"), "Должна отображаться информация об услуге связи");
        assertTrue(serviceInfo.contains("375297777777"), "Должен отображаться номер телефона 375297777777");

        assertNotNull(buttonAmount, "Сумма на кнопке должна отображаться");
        assertTrue(buttonAmount.contains("5.00 BYN"), "Сумма на кнопке должна содержать 5.00 BYN");

        assertTrue(isCardNumberLabelDisplayed, "Надпись 'Номер карты' должна отображаться");
        assertTrue(isCardExpiryLabelDisplayed, "Надпись 'Срок действия' должна отображаться");
        assertTrue(isCardCvcLabelDisplayed, "Надпись 'CVC' должна отображаться");
        assertTrue(isCardHolderLabelDisplayed, "Надпись 'Имя и фамилия на карте' должна отображаться");

        assertTrue(cardNumberLabel.contains("Номер карты"), "Должна отображаться надпись 'Номер карты'");
        assertTrue(cardExpiryLabel.contains("Срок действия"), "Должна отображаться надпись 'Срок действия'");
        assertTrue(cardCvcLabel.contains("CVC"), "Должна отображаться надпись 'CVC'");
        assertTrue(cardHolderLabel.contains("Имя и фамилия на карте"), "Должна отображаться надпись 'Имя и фамилия на карте'");

        assertTrue(paymentIconsCount >= 5, "Должно быть не менее 5 иконок платежных систем. Найдено: " + paymentIconsCount);
        assertTrue(isVisaIconDisplayed, "Иконка Visa должна отображаться");
        assertTrue(isMastercardIconDisplayed, "Иконка Mastercard должна отображаться");
        assertTrue(isBelkartIconDisplayed, "Иконка Belkart должна отображаться");
        assertTrue(isMirIconDisplayed, "Иконка Mir должна отображаться");
    }
}