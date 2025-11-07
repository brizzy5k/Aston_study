package org.Aston_study.lesson_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MtsPage extends BasePage {
    private By widgetTitle = By.xpath("//div[contains(@class,'pay__wrapper')]//h2[contains(text(), 'Онлайн пополнение ')]");
    private By paymentLogos = By.cssSelector(".pay__partners img");
    private By serviceDetailsLink = By.xpath("//div[contains(@class,'personal')]//a[contains(text(), 'Подробнее о сервисе')]");
    private By cookieAcceptButton = By.xpath("//div[contains(@class,'cookie')]//button[contains(text(), 'Принять')]");


    private By serviceTypeButtons = By.xpath("//div[contains(@class,'personal')]//*[contains(@class, 'service-type') or contains(text(), 'Услуги связи')]");
    private By phoneInput = By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'телефон')]");
    private By accountInput = By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'Лицевой счёт')]");
    private By contractInput = By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'Номер договора')]");
    private By amountInput = By.xpath("//div[contains(@class,'personal')]//input[contains(@placeholder, 'Сумма')]");
    private By continueButton = By.xpath("//div[contains(@class,'personal')]//button[contains(text(),'Продолжить')]");

    private By communicationServicesBtn = By.xpath("//div[contains(@class,'personal')]//*[contains(text(), 'Услуги связи')]");
    private By homeInternetBtn = By.xpath("//div[contains(@class,'personal')]//*[contains(text(), 'Домашний интернет')]");
    private By installmentBtn = By.xpath("//div[contains(@class,'personal')]//*[contains(text(), 'Рассрочка')]");
    private By debtBtn = By.xpath("//div[contains(@class,'personal')]//*[contains(text(), 'Задолженность')]");

    public MtsPage(WebDriver driver) {
        super(driver);
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

    public void enterAccountNumber(String account) {
        enterText(accountInput, account);
    }

    public void enterContractNumber(String contract) {
        enterText(contractInput, contract);
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

    public String getAccountInputPlaceholder() {
        return findElement(accountInput).getAttribute("placeholder");
    }

    public String getBillInputPlaceholder() {
        return findElement(contractInput).getAttribute("placeholder");
    }

    public String getAmountInputPlaceholder() {
        return findElement(amountInput).getAttribute("placeholder");
    }

    public boolean isPageChanged() {
        try {
            return isElementDisplayed(By.xpath("//div[contains(@class,'app-wrapper__content ng-tns-c1057872785-0')]"));
        } catch (Exception e) {
            return false;
        }
    }

    public void acceptCookies() {
        try {
            WebElement cookieOkBtn = wait.until(ExpectedConditions.elementToBeClickable(cookieAcceptButton));
            cookieOkBtn.click();
            System.out.println("Cookies приняты успешно");
        } catch (Exception e) {
            System.out.println("Куки-баннер не найден или уже закрыт");
        }
    }
}