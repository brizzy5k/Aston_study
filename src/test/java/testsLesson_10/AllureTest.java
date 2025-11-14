package testsLesson_10;

import io.qameta.allure.*;
import org.Aston_study.lesson_10.steps.MtsHomeSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Тесты веб-приложения МТС")
@Feature("Основная функциональность платежного блока")
public class AllureTest extends BaseTest {
    private final Logger log = LoggerFactory.getLogger(AllureTest.class);
    private MtsHomeSteps steps;

    @BeforeEach
    @Step("Инициализация тестового окружения")
    public void setUp() {
        super.setUp();
        steps = new MtsHomeSteps(driver);
        log.info("Инициализация теста");
    }

    @Test
    @DisplayName("Проверить название блока")
    @Story("Проверка отображения элементов интерфейса")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Тест проверяет, что заголовок блока соответствует ожидаемому значению")
    public void testBlockName() {
        Allure.step("Выполнить проверку названия блока", () -> {
            log.info("===Тест Проверка названия блока===");
            String actualTitle = steps.getBlockTitle();
            String expectedTitle = "Онлайн пополнение\nбез комиссии";

            log.info("Название блока корректно: {}", actualTitle);
            assertEquals(expectedTitle, actualTitle, "Название блока не соответствует ожидаемому");
        });
    }

    @Test
    @DisplayName("Проверить наличие логотипов платёжных систем")
    @Story("Проверка отображения элементов интерфейса")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет отображение логотипов платежных систем и их количество")
    public void testPaymentLogos() {
        Allure.step("Проверить отображение логотипов платежных систем", () -> {
            log.info("===Тест Проверка логотипов платежных систем===");
            boolean logosDisplayed = steps.arePaymentLogosDisplayed();
            int logoCount = steps.getPaymentLogosCount();

            log.info("Найдено логотипов платежных систем: {}", logoCount);
            assertTrue(logosDisplayed, "Логотипы платежных систем не найдены");
            assertTrue(logoCount > 0, "Не найдено логотипов платежных систем");
        });
    }

    @Test
    @DisplayName("Проверить работу ссылки «Подробнее о сервисе»")
    @Story("Проверка навигации и ссылок")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет функциональность ссылки 'Подробнее о сервисе' и переход по ней")
    public void testServiceDetailsLink() {
        Allure.step("Проверить работу ссылки 'Подробнее о сервисе'", () -> {
            log.info("===Тест Проверка ссылки 'Подробнее о сервисе'===");

            Allure.step("Проверить отображение ссылки", () -> {
                boolean linkDisplayed = steps.isServiceDetailsLinkDisplayed();
                assertTrue(linkDisplayed, "Ссылка 'Подробнее о сервисе' не отображается");
            });

            Allure.step("Проверить атрибут href ссылки", () -> {
                String href = steps.getServiceDetailsLinkHref();
                log.info("Ссылка найдена, URL: {}", href);
                assertNotNull(href, "У ссылки отсутствует href атрибут");
                assertFalse(href.isEmpty(), "У ссылки пустой href атрибут");
            });

            Allure.step("Выполнить переход по ссылке", () -> {
                String originalUrl = steps.getCurrentUrl();
                log.info("Текущий URL: {}", originalUrl);

                steps.clickServiceDetailsLink();
                steps.waitForUrlChange(originalUrl);

                String newUrl = steps.getCurrentUrl();
                log.info("Переход выполнен успешно");
                log.info("Новый URL: {}", newUrl);
                assertNotEquals(originalUrl, newUrl, "Переход по ссылке не произошел");
            });

            Allure.step("Вернуться на исходную страницу", () -> {
                steps.navigateBack();
                log.info("Возврат на исходную страницу");
            });
        });
    }

    @Test
    @DisplayName("Проверить надписи в полях для Услуг связи")
    @Story("Проверка плейсхолдеров форм")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет корректность плейсхолдеров в форме Услуг связи")
    public void testCommunicationServicesPlaceholders() {
        Allure.step("Проверить плейсхолдеры для Услуг связи", () -> {
            log.info("===Тест Проверка плейсхолдеров для Услуг связи===");

            Allure.step("Выбрать услуги связи", () -> {
                steps.selectCommunicationServices();
                log.info("Выбраны Услуги связи");
            });

            Allure.step("Проверить плейсхолдеры полей", () -> {
                String phonePlaceholder = steps.getPhoneInputPlaceholder();
                String amountPlaceholder = steps.getAmountInputPlaceholder();

                log.info("Плейсхолдеры корректны:");
                log.info("Телефон: '{}'", phonePlaceholder);
                log.info("Сумма: '{}'", amountPlaceholder);

                assertNotNull(phonePlaceholder, "Плейсхолдер телефона отсутствует");
                assertNotNull(amountPlaceholder, "Плейсхолдер суммы отсутствует");
                assertFalse(phonePlaceholder.isEmpty(), "Плейсхолдер телефона пустой");
                assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер суммы пустой");
            });
        });
    }

    @Test
    @DisplayName("Проверить надписи в полях для Домашнего интернета")
    @Story("Проверка плейсхолдеров форм")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет корректность плейсхолдеров в форме Домашнего интернета")
    public void testHomeInternetPlaceholders() {
        Allure.step("Проверить плейсхолдеры для Домашнего интернета", () -> {
            log.info("===Тест Проверка плейсхолдеров для Домашнего интернета===");

            Allure.step("Выбрать домашний интернет", () -> {
                steps.selectHomeInternet();
                log.info("Выбран Домашний интернет");
            });

            Allure.step("Проверить плейсхолдеры полей", () -> {
                String phonePlaceholder = steps.getHomePhoneInputPlaceholder();
                String amountPlaceholder = steps.getAmountInputPlaceholder();

                log.info("Плейсхолдеры корректны:");
                log.info("Номер абонента: '{}'", phonePlaceholder);
                log.info("Сумма: '{}'", amountPlaceholder);

                assertNotNull(phonePlaceholder, "Плейсхолдер для номера абонента отсутствует");
                assertNotNull(amountPlaceholder, "Плейсхолдер для суммы отсутствует");
                assertFalse(phonePlaceholder.isEmpty(), "Плейсхолдер для номера абонента пустой");
                assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер для суммы пустой");
            });
        });
    }

    @Test
    @DisplayName("Проверить надписи в полях для Рассрочки")
    @Story("Проверка плейсхолдеров форм")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет корректность плейсхолдеров в форме Рассрочки")
    public void testInstallmentPlaceholders() {
        Allure.step("Проверить плейсхолдеры для Рассрочки", () -> {
            log.info("===Тест Проверка плейсхолдеров для Рассрочки===");

            Allure.step("Выбрать рассрочку", () -> {
                steps.selectInstallment();
                log.info("Выбрана Рассрочка");
            });

            Allure.step("Проверить плейсхолдеры полей", () -> {
                String contractPlaceholder = steps.getContractInputPlaceholder();
                String amountPlaceholder = steps.getAmountInputPlaceholder();

                log.info("Плейсхолдеры корректны:");
                log.info("Номер договора: '{}'", contractPlaceholder);
                log.info("Сумма: '{}'", amountPlaceholder);

                assertNotNull(contractPlaceholder, "Плейсхолдер для номера договора отсутствует");
                assertNotNull(amountPlaceholder, "Плейсхолдер для суммы отсутствует");
                assertFalse(contractPlaceholder.isEmpty(), "Плейсхолдер для номера договора пустой");
                assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер для суммы пустой");
            });
        });
    }

    @Test
    @DisplayName("Проверить надписи в полях для Задолженности")
    @Story("Проверка плейсхолдеров форм")
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест проверяет корректность плейсхолдеров в форме Задолженности")
    public void testDebtPlaceholders() {
        Allure.step("Проверить плейсхолдеры для Задолженности", () -> {
            log.info("===Тест Проверка плейсхолдеров для Задолженности===");

            Allure.step("Выбрать задолженность", () -> {
                steps.selectDebt();
                log.info("Выбрана Задолженность");
            });

            Allure.step("Проверить плейсхолдеры полей", () -> {
                String contractPlaceholder = steps.getAccountInputPlaceholder();
                String amountPlaceholder = steps.getAmountInputPlaceholder();

                log.info("Плейсхолдеры корректны:");
                log.info("Номер счета: '{}'", contractPlaceholder);
                log.info("Сумма: '{}'", amountPlaceholder);

                assertNotNull(contractPlaceholder, "Плейсхолдер для номера счета отсутствует");
                assertNotNull(amountPlaceholder, "Плейсхолдер для суммы отсутствует");
                assertFalse(contractPlaceholder.isEmpty(), "Плейсхолдер для номера счета пустой");
                assertFalse(amountPlaceholder.isEmpty(), "Плейсхолдер для суммы пустой");
            });
        });
    }

    @Test
    @DisplayName("Заполнить поля и проверить работу кнопки «Продолжить» для Услуг связи")
    @Story("Проверка процесса оплаты")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Тест проверяет полный процесс оплаты Услуг связи, включая заполнение формы и переход к платежной форме")
    public void testCommunicationServicesPayment() {
        Allure.step("Проверить процесс оплаты Услуг связи", () -> {
            log.info("===Тест Проверка оплаты Услуг связи===");

            Allure.step("Выбрать услуги связи", () -> {
                steps.selectCommunicationServices();
                log.info("Выбраны Услуги связи");
            });

            Allure.step("Заполнить поля формы", () -> {
                steps.fillPhoneField("297777777");
                steps.fillCostField("5");
                log.info("Поля заполнены: телефон=297777777, сумма=5");
            });

            Allure.step("Проверить кнопку 'Продолжить'", () -> {
                boolean isContinueButtonEnabled = steps.isContinueButtonEnabled();
                boolean isContinueButtonDisplayed = steps.isContinueButtonDisplayed();

                log.info("Кнопка 'Продолжить' активна и отображается");
                assertTrue(isContinueButtonEnabled, "Кнопка 'Продолжить' должна быть активна после заполнения полей");
                assertTrue(isContinueButtonDisplayed, "Кнопка 'Продолжить' должна отображаться");
            });

            Allure.step("Нажать кнопку 'Продолжить'", () -> {
                steps.clickContinueButton();
                log.info("Клик по кнопке 'Продолжить' выполнен");
            });

            Allure.step("Проверить платежную форму", () -> {
                steps.checkPaymentFormAfterContinue();
                steps.switchToPaymentIframe();

                Allure.step("Проверить информацию об услуге", () -> {
                    String serviceInfo = steps.getServiceInfo();
                    log.info("Информация об услуге отображается корректно: {}", serviceInfo);
                    assertNotNull(serviceInfo, "Информация об услуге должна отображаться");
                    assertTrue(serviceInfo.contains("Услуги связи"), "Должна отображаться информация об услуге связи");
                    assertTrue(serviceInfo.contains("375297777777"), "Должен отображаться номер телефона 375297777777");
                });

                Allure.step("Проверить сумму на кнопке оплаты", () -> {
                    String buttonAmount = steps.getPaymentButtonAmountText();
                    log.info("Сумма на кнопке: {}", buttonAmount);
                    assertNotNull(buttonAmount, "Сумма на кнопке должна отображаться");
                    assertTrue(buttonAmount.contains("5.00 BYN"), "Сумма на кнопке должна содержать 5.00 BYN");
                });

                Allure.step("Проверить надписи полей карты", () -> {
                    boolean isCardNumberLabelDisplayed = steps.isCardNumberLabelDisplayed();
                    boolean isCardExpiryLabelDisplayed = steps.isCardExpiryLabelDisplayed();
                    boolean isCardCvcLabelDisplayed = steps.isCardCvcLabelDisplayed();
                    boolean isCardHolderLabelDisplayed = steps.isCardHolderLabelDisplayed();

                    String cardNumberLabel = steps.getCardNumberLabelText();
                    String cardExpiryLabel = steps.getCardExpiryLabelText();
                    String cardCvcLabel = steps.getCardCvcLabelText();
                    String cardHolderLabel = steps.getCardHolderLabelText();

                    log.info("Надписи полей карты отображаются корректно:");
                    log.info("Номер карты: '{}'", cardNumberLabel);
                    log.info("Срок действия: '{}'", cardExpiryLabel);
                    log.info("CVC: '{}'", cardCvcLabel);
                    log.info("Имя и фамилия на карте: '{}'", cardHolderLabel);

                    assertTrue(isCardNumberLabelDisplayed, "Надпись 'Номер карты' должна отображаться");
                    assertTrue(isCardExpiryLabelDisplayed, "Надпись 'Срок действия' должна отображаться");
                    assertTrue(isCardCvcLabelDisplayed, "Надпись 'CVC' должна отображаться");
                    assertTrue(isCardHolderLabelDisplayed, "Надпись 'Имя и фамилия на карте' должна отображаться");

                    assertTrue(cardNumberLabel.contains("Номер карты"), "Должна отображаться надпись 'Номер карты'");
                    assertTrue(cardExpiryLabel.contains("Срок действия"), "Должна отображаться надпись 'Срок действия'");
                    assertTrue(cardCvcLabel.contains("CVC"), "Должна отображаться надпись 'CVC'");
                    assertTrue(cardHolderLabel.contains("Имя и фамилия на карте"), "Должна отображаться надпись 'Имя и фамилия на карте'");
                });

                Allure.step("Проверить иконки платежных систем", () -> {
                    int paymentIconsCount = steps.getPaymentIconsCount();
                    boolean isVisaIconDisplayed = steps.isVisaIconDisplayed();
                    boolean isMastercardIconDisplayed = steps.isMastercardIconDisplayed();
                    boolean isBelkartIconDisplayed = steps.isBelkartIconDisplayed();
                    boolean isMirIconDisplayed = steps.isMirIconDisplayed();

                    log.info("Найдено иконок платежных систем: {}", paymentIconsCount);
                    log.info("Все основные платежные системы отображаются: Visa, Mastercard, Belkart, Maestro, Mir");

                    assertTrue(paymentIconsCount >= 5, "Должно быть не менее 5 иконок платежных систем. Найдено: " + paymentIconsCount);
                    assertTrue(isVisaIconDisplayed, "Иконка Visa должна отображаться");
                    assertTrue(isMastercardIconDisplayed, "Иконка Mastercard должна отображаться");
                    assertTrue(isBelkartIconDisplayed, "Иконка Belkart должна отображаться");
                    assertTrue(isMirIconDisplayed, "Иконка Mir должна отображаться");
                });

                Allure.step("Вернуться к основному контенту", () -> {
                    steps.switchToDefaultContent();
                });
            });
        });
    }
}