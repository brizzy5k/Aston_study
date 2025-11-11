package org.Aston_study.lesson_10.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private final By widgetTitle = By.xpath("//div[contains(@class,'pay__wrapper')]//h2[contains(text(), 'Онлайн пополнение')]");
    private final By paymentLogos = By.cssSelector(".pay__partners img");
    private final By serviceDetailsLink = By.xpath("//div[contains(@class,'personal')]//a[contains(text(), 'Подробнее о сервисе')]");
    private final By cookieAcceptButton = By.xpath("//div[contains(@class,'cookie')]//button[contains(text(), 'Принять')]");

    private final By communicationServicesBtn = By.xpath("//div[contains(@class,'personal')]//*[contains(text(), 'Услуги связи')]");
    private final By homeInternetBtn = By.xpath("//div[contains(@class,'personal')]//p[@class='select__option' and text()='Домашний интернет']");
    private final By installmentBtn = By.xpath("//div[contains(@class,'personal')]//p[@class='select__option' and text()='Рассрочка']");
    private final By debtBtn = By.xpath("//div[contains(@class,'personal')]//p[@class='select__option' and text()='Задолженность']");

    private final By phoneInput = By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'Номер телефона')]");
    private final By homePhoneInput = By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'Номер абонента')]");
    private final By accountInput = By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'Номер счета на 2073')]");
    private final By contractInput = By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'Номер счета на 44')]");
    private final By amountInput = By.xpath("//div[contains(@class,'pay__forms')]//input[contains(@placeholder, 'Сумма')]");

    private final By continueButton = By.xpath("//div[contains(@class,'personal')]//button[contains(text(),'Продолжить')]");
    private final By serviceSelector = By.xpath("//div[contains(@class,'personal')]//*[contains(@class, 'select')]");

    private final By bepaidIframe = By.xpath("//iframe[contains(@class,'bepaid-iframe')]");
    private final By paymentFormContent = By.xpath("//div[contains(@class,'app-wrapper__content ng-tns-c1057872785-0')]");

    private final By displayedAmount = By.xpath("//div[contains(@class,'amount') or contains(text(), '5')]");
    private final By buttonAmount = By.xpath("//button[contains(text(), '5')]");
    private final By displayedPhone = By.xpath("//div[contains(text(), '297777777')]");
    private final By cardNumberInput = By.xpath("//input[contains(@placeholder, 'Номер карты') or contains(@placeholder, 'Card number')]");
    private final By cardExpiryInput = By.xpath("//input[contains(@placeholder, 'Срок действия') or contains(@placeholder, 'Expiry')]");
    private final By cardCvvInput = By.xpath("//input[contains(@placeholder, 'CVV') or contains(@placeholder, 'CVC')]");
    private final By paymentIcons = By.xpath("//img[contains(@src, 'visa') or contains(@src, 'mastercard') or contains(@src, 'mir')]");
    private final By visaIcon = By.xpath("//img[contains(@src, 'visa')]");
    private final By mastercardIcon = By.xpath("//img[contains(@src, 'mastercard')]");
    private final By mirIcon = By.xpath("//img[contains(@src, 'mir')]");

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected WebElement findClickableElement(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void clickElement(By locator) {
        findClickableElement(locator).click();
    }

    protected void enterText(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void acceptCookies() {
        try {
            WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            cookieBtn.click();
            System.out.println("Cookies приняты успешно");
        } catch (Exception e) {
            System.out.println("Куки-баннер не найден или уже закрыт");
        }
    }

    public String getWidgetTitle() {
        return getText(widgetTitle);
    }

    public int getPaymentLogosCount() {
        return findElements(paymentLogos).size();
    }

    public boolean arePaymentLogosDisplayed() {
        return !findElements(paymentLogos).isEmpty();
    }

    public boolean isServiceDetailsLinkDisplayed() {
        return isElementDisplayed(serviceDetailsLink);
    }

    public String getServiceDetailsLinkHref() {
        return findElement(serviceDetailsLink).getAttribute("href");
    }

    public void clickServiceDetailsLink() {
        clickElement(serviceDetailsLink);
    }

    public void openServiceSelector() {
        clickElement(serviceSelector);
    }

    public void selectCommunicationServices() {
        clickElement(communicationServicesBtn);
    }

    public void selectHomeInternet() {
        clickElement(homeInternetBtn);
    }

    public void selectInstallment() {
        clickElement(installmentBtn);
    }

    public void selectDebt() {
        clickElement(debtBtn);
    }

    public void enterPhoneNumber(String phone) {
        enterText(phoneInput, phone);
    }

    public void enterAmount(String amount) {
        enterText(amountInput, amount);
    }

    public boolean isContinueButtonEnabled() {
        return findElement(continueButton).isEnabled();
    }

    public boolean isContinueButtonDisplayed() {
        return isElementDisplayed(continueButton);
    }

    public void clickContinueButton() {
        clickElement(continueButton);
    }

    public String getPhoneInputPlaceholder() {
        return findElement(phoneInput).getAttribute("placeholder");
    }

    public String getHomePhoneInputPlaceholder() {
        return findElement(homePhoneInput).getAttribute("placeholder");
    }

    public String getAccountInputPlaceholder() {
        return findElement(accountInput).getAttribute("placeholder");
    }

    public String getContractInputPlaceholder() {
        return findElement(contractInput).getAttribute("placeholder");
    }

    public String getAmountInputPlaceholder() {
        return findElement(amountInput).getAttribute("placeholder");
    }

    public boolean switchToBepaidIframe() {
        try {
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(bepaidIframe));
            driver.switchTo().frame(iframe);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPaymentFormDisplayed() {
        try {
            return findElement(paymentFormContent).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }


}
