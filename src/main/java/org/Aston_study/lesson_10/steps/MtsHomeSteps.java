package org.Aston_study.lesson_10.steps;

import org.Aston_study.lesson_10.page.MtsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsHomeSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private MtsPage mtsPage;

    public MtsHomeSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.mtsPage = new MtsPage(driver);
    }

    public void acceptCookies() {
        mtsPage.acceptCookies();
    }

    public String getBlockTitle() {
        return mtsPage.getWidgetTitle();
    }

    public int getPaymentLogosCount() {
        return mtsPage.getPaymentLogosCount();
    }

    public boolean arePaymentLogosDisplayed() {
        return mtsPage.arePaymentLogosDisplayed();
    }

    public boolean isServiceDetailsLinkDisplayed() {
        return mtsPage.isServiceDetailsLinkDisplayed();
    }

    public String getServiceDetailsLinkHref() {
        return mtsPage.getServiceDetailsLinkHref();
    }

    public void clickServiceDetailsLink() {
        mtsPage.clickServiceDetailsLink();
    }

    public void selectCommunicationServices() {
        mtsPage.openServiceSelector();
        mtsPage.selectCommunicationServices();
    }

    public void selectHomeInternet() {
        mtsPage.openServiceSelector();
        mtsPage.selectHomeInternet();
    }

    public void selectInstallment() {
        mtsPage.openServiceSelector();
        mtsPage.selectInstallment();
    }

    public void selectDebt() {
        mtsPage.openServiceSelector();
        mtsPage.selectDebt();
    }

    public void fillPhoneField(String phone) {
        mtsPage.enterPhoneNumber(phone);
    }

    public void fillCostField(String amount) {
        mtsPage.enterAmount(amount);
    }

    public void clickContinueButton() {
        mtsPage.clickContinueButton();
    }

    public boolean isContinueButtonDisplayed() {
        return mtsPage.isContinueButtonDisplayed();
    }

    public boolean isContinueButtonEnabled() {
        return mtsPage.isContinueButtonEnabled();
    }

    public String getPhoneInputPlaceholder() {
        return mtsPage.getPhoneInputPlaceholder();
    }

    public String getHomePhoneInputPlaceholder() {
        return mtsPage.getHomePhoneInputPlaceholder();
    }

    public String getAmountInputPlaceholder() {
        return mtsPage.getAmountInputPlaceholder();
    }

    public String getAccountInputPlaceholder() {
        return mtsPage.getAccountInputPlaceholder();
    }

    public String getContractInputPlaceholder() {
        return mtsPage.getContractInputPlaceholder();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void waitForUrlChange(String originalUrl) {
        wait.until(webDriver -> !webDriver.getCurrentUrl().equals(originalUrl));
    }

    public boolean switchToPaymentIframe() {
        return mtsPage.switchToBepaidIframe();
    }

    public boolean isPaymentFormDisplayed() {
        return mtsPage.isPaymentFormDisplayed();
    }

    public void switchToDefaultContent() {
        mtsPage.switchToDefaultContent();
    }

    public void checkPaymentFormAfterContinue() {
        if (switchToPaymentIframe()) {
            System.out.println("Переключение на iframe 'bepaid-iframe' произошло успешно");
            if (isPaymentFormDisplayed()) {
                System.out.println("Платежная форма отображается");
            } else {
                System.out.println("Платежная форма не отображается в iframe");
            }
            switchToDefaultContent();
        } else {
            System.out.println("Iframe 'bepaid-iframe' не найден");
        }
    }

    public String getServiceInfo() {
        return mtsPage.getServiceInfo();
    }

    public String getPaymentButtonAmountText() {
        return mtsPage.getPaymentButtonAmountText();
    }

    public boolean isCardNumberLabelDisplayed() {
        return mtsPage.isCardNumberLabelDisplayed();
    }

    public boolean isCardExpiryLabelDisplayed() {
        return mtsPage.isCardExpiryLabelDisplayed();
    }

    public boolean isCardCvcLabelDisplayed() {
        return mtsPage.isCardCvcLabelDisplayed();
    }

    public boolean isCardHolderLabelDisplayed() {
        return mtsPage.isCardHolderLabelDisplayed();
    }

    public String getCardNumberLabelText() {
        return mtsPage.getCardNumberLabelText();
    }

    public String getCardExpiryLabelText() {
        return mtsPage.getCardExpiryLabelText();
    }

    public String getCardCvcLabelText() {
        return mtsPage.getCardCvcLabelText();
    }

    public String getCardHolderLabelText() {
        return mtsPage.getCardHolderLabelText();
    }

    public int getPaymentIconsCount() {
        return mtsPage.getPaymentIconsCount();
    }

    public boolean isVisaIconDisplayed() {
        return mtsPage.isVisaIconDisplayed();
    }

    public boolean isMastercardIconDisplayed() {
        return mtsPage.isMastercardIconDisplayed();
    }

    public boolean isBelkartIconDisplayed() {
        return mtsPage.isBelkartIconDisplayed();
    }

    public boolean isMaestroIconDisplayed() {
        return mtsPage.isMaestroIconDisplayed();
    }

    public boolean isMirIconDisplayed() {
        return mtsPage.isMirIconDisplayed();
    }
}