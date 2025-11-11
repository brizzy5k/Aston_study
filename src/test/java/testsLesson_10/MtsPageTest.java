package testsLesson_10;

import org.Aston_study.lesson_10.steps.MtsHomeSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MtsPageTest extends BaseTest {
    private MtsHomeSteps steps;

    @BeforeEach
    public void setUp() {
        super.setUp();
        steps = new MtsHomeSteps(driver);
        System.out.println("Инициализация теста");
    }

    @Test
    @DisplayName("Проверить название блока")
    public void testBlockName() {
        System.out.println("===Тест Проверка названия блока===");
        String actualTitle = steps.getBlockTitle();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedTitle, actualTitle, "Название блока не соответствует ожидаемому");
        System.out.println("Название блока корректно: " + actualTitle);
    }

    @Test
    @DisplayName("Проверить наличие логотипов платёжных систем")
    public void testPaymentLogos() {
        System.out.println("===Тест Проверка логотипов платежных систем===");
        assertTrue(steps.arePaymentLogosDisplayed(), "Логотипы платежных систем не найдены");
        int logoCount = steps.getPaymentLogosCount();
        assertTrue(logoCount > 0, "Не найдено логотипов платежных систем");
        System.out.println("Найдено логотипов платежных систем: " + logoCount);
    }

    @Test
    @DisplayName("Проверить работу ссылки «Подробнее о сервисе»")
    public void testServiceDetailsLink() {
        System.out.println("===Тест Проверка ссылки 'Подробнее о сервисе'===");
        assertTrue(steps.isServiceDetailsLinkDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");

        String href = steps.getServiceDetailsLinkHref();
        assertNotNull(href, "У ссылки отсутствует href атрибут");
        assertFalse(href.isEmpty(), "У ссылки пустой href атрибут");
        System.out.println("Ссылка найдена, URL: " + href);

        String originalUrl = steps.getCurrentUrl();
        System.out.println("Текущий URL: " + originalUrl);

        steps.clickServiceDetailsLink();
        steps.waitForUrlChange(originalUrl);

        String newUrl = steps.getCurrentUrl();
        assertNotEquals(originalUrl, newUrl, "Переход по ссылке не произошел");
        System.out.println("Переход выполнен успешно");
        System.out.println("Новый URL: " + newUrl);

        steps.navigateBack();
        System.out.println("Возврат на исходную страницу");
    }

    @Test
    @DisplayName("Проверить надписи в полях для Услуг связи")
    public void testCommunicationServicesPlaceholders() {
        System.out.println("===Тест Проверка плейсхолдеров для Услуг связи===");
        steps.selectCommunicationServices();
        System.out.println("Выбраны Услуги связи");

        String phonePlaceholder = steps.getPhoneInputPlaceholder();
        String amountPlaceholder = steps.getAmountInputPlaceholder();

        assertNotNull(phonePlaceholder, "Плейсхолдер телефона отсутствует");
        assertNotNull(amountPlaceholder, "Плейсхолдер суммы отсутствует");
        assertFalse(phonePlaceholder.isEmpty(), "Плейсхолдер телефона пустой");
        assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер суммы пустой");

        System.out.println("Плейсхолдеры корректны:");
        System.out.println("Телефон: '" + phonePlaceholder + "'");
        System.out.println("Сумма: '" + amountPlaceholder + "'");
    }

    @Test
    @DisplayName("Проверить надписи в полях для Домашнего интернета")
    public void testHomeInternetPlaceholders() {
        System.out.println("===Тест Проверка плейсхолдеров для Домашнего интернета===");
        steps.selectHomeInternet();
        System.out.println("Выбран Домашний интернет");

        String phonePlaceholder = steps.getHomePhoneInputPlaceholder();
        String amountPlaceholder = steps.getAmountInputPlaceholder();

        assertNotNull(phonePlaceholder, "Плейсхолдер для номера абонента отсутствует");
        assertNotNull(amountPlaceholder, "Плейсхолдер для суммы отсутствует");
        assertFalse(phonePlaceholder.isEmpty(), "Плейсхолдер для номера абонента пустой");
        assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер для суммы пустой");

        System.out.println("Плейсхолдеры корректны:");
        System.out.println("Номер абонента: '" + phonePlaceholder + "'");
        System.out.println("Сумма: '" + amountPlaceholder + "'");
    }

    @Test
    @DisplayName("Проверить надписи в полях для Рассрочки")
    public void testInstallmentPlaceholders() {
        System.out.println("===Тест Проверка плейсхолдеров для Рассрочки===");
        steps.selectInstallment();
        System.out.println("Выбрана Рассрочка");

        String contractPlaceholder = steps.getContractInputPlaceholder();
        String amountPlaceholder = steps.getAmountInputPlaceholder();

        assertNotNull(contractPlaceholder, "Плейсхолдер для номера договора отсутствует");
        assertNotNull(amountPlaceholder, "Плейсхолдер для суммы отсутствует");
        assertFalse(contractPlaceholder.isEmpty(), "Плейсхолдер для номера договора пустой");
        assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер для суммы пустой");

        System.out.println("Плейсхолдеры корректны:");
        System.out.println("Номер договора: '" + contractPlaceholder + "'");
        System.out.println("Сумма: '" + amountPlaceholder + "'");
    }

    @Test
    @DisplayName("Проверить надписи в полях для Задолженности")
    public void testDebtPlaceholders() {
        System.out.println("===Тест Проверка плейсхолдеров для Задолженности===");
        steps.selectDebt();
        System.out.println("Выбрана Задолженность");

        String contractPlaceholder = steps.getAccountInputPlaceholder();
        String amountPlaceholder = steps.getAmountInputPlaceholder();

        assertNotNull(contractPlaceholder, "Плейсхолдер для номера счета отсутствует");
        assertNotNull(amountPlaceholder, "Плейсхолдер для суммы отсутствует");
        assertFalse(contractPlaceholder.isEmpty(), "Плейсхолдер для номера счета пустой");
        assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер для суммы пустой");

        System.out.println("Плейсхолдеры корректны:");
        System.out.println("Номер счета: '" + contractPlaceholder + "'");
        System.out.println("Сумма: '" + amountPlaceholder + "'");
    }

    @Test
    @DisplayName("Заполнить поля и проверить работу кнопки «Продолжить» для Услуг связи")
    public void testCommunicationServicesPayment() {
        System.out.println("===Тест Проверка оплаты Услуг связи===");
        steps.selectCommunicationServices();
        System.out.println("Выбраны Услуги связи");

        steps.fillPhoneField("297777777");
        steps.fillCostField("5");
        System.out.println("Поля заполнены: телефон=297777777, сумма=5");

        assertTrue(steps.isContinueButtonEnabled(), "Кнопка 'Продолжить' должна быть активна после заполнения полей");
        assertTrue(steps.isContinueButtonDisplayed(), "Кнопка 'Продолжить' должна отображаться");
        System.out.println("Кнопка 'Продолжить' активна и отображается");

        steps.clickContinueButton();
        System.out.println("Клик по кнопке 'Продолжить' выполнен");

        steps.checkPaymentFormAfterContinue();
        steps.switchToPaymentIframe();

        String serviceInfo = steps.getServiceInfo();
        assertNotNull(serviceInfo, "Информация об услуге должна отображаться");
        assertTrue(serviceInfo.contains("Услуги связи"), "Должна отображаться информация об услуге связи");
        assertTrue(serviceInfo.contains("375297777777"), "Должен отображаться номер телефона 375297777777");
        System.out.println("Информация об услуге отображается корректно: " + serviceInfo);

        String buttonAmount = steps.getPaymentButtonAmountText();
        assertNotNull(buttonAmount, "Сумма на кнопке должна отображаться");
        assertTrue(buttonAmount.contains("5.00 BYN"), "Сумма на кнопке должна содержать 5.00 BYN");
        System.out.println("Сумма на кнопке: " + buttonAmount);

        assertTrue(steps.isCardNumberLabelDisplayed(), "Надпись 'Номер карты' должна отображаться");
        assertTrue(steps.isCardExpiryLabelDisplayed(), "Надпись 'Срок действия' должна отображаться");
        assertTrue(steps.isCardCvcLabelDisplayed(), "Надпись 'CVC' должна отображаться");
        assertTrue(steps.isCardHolderLabelDisplayed(), "Надпись 'Имя и фамилия на карте' должна отображаться");

        String cardNumberLabel = steps.getCardNumberLabelText();
        String cardExpiryLabel = steps.getCardExpiryLabelText();
        String cardCvcLabel = steps.getCardCvcLabelText();
        String cardHolderLabel = steps.getCardHolderLabelText();

        assertTrue(cardNumberLabel.contains("Номер карты"), "Должна отображаться надпись 'Номер карты'");
        assertTrue(cardExpiryLabel.contains("Срок действия"), "Должна отображаться надпись 'Срок действия'");
        assertTrue(cardCvcLabel.contains("CVC"), "Должна отображаться надпись 'CVC'");
        assertTrue(cardHolderLabel.contains("Имя и фамилия на карте"), "Должна отображаться надпись 'Имя и фамилия на карте'");

        System.out.println("Надписи полей карты отображаются корректно:");
        System.out.println("Номер карты: '" + cardNumberLabel + "'");
        System.out.println("Срок действия: '" + cardExpiryLabel + "'");
        System.out.println("CVC: '" + cardCvcLabel + "'");
        System.out.println("Имя и фамилия на карте: '" + cardHolderLabel + "'");

        int paymentIconsCount = steps.getPaymentIconsCount();
        assertTrue(paymentIconsCount >= 5, "Должно быть не менее 5 иконок платежных систем. Найдено: " + paymentIconsCount);
        System.out.println("Найдено иконок платежных систем: " + paymentIconsCount);

        assertTrue(steps.isVisaIconDisplayed(), "Иконка Visa должна отображаться");
        assertTrue(steps.isMastercardIconDisplayed(), "Иконка Mastercard должна отображаться");
        assertTrue(steps.isBelkartIconDisplayed(), "Иконка Belkart должна отображаться");
        //assertTrue(steps.isMaestroIconDisplayed(), "Иконка Maestro должна отображаться");
        assertTrue(steps.isMirIconDisplayed(), "Иконка Mir должна отображаться");
        System.out.println("Все основные платежные системы отображаются: Visa, Mastercard, Belkart, Maestro, Mir");

        steps.switchToDefaultContent();
    }
}