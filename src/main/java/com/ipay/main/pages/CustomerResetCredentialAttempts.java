package com.ipay.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.ipay.main.pages.BaseClass.clickElement;
import static com.ipay.main.pages.BaseClass.enterText;

public class CustomerResetCredentialAttempts {
    private static final By CUSTOMER = By.id("sel-menu-customer");
    private static final By RESET_CREDENTIALS = By.xpath("//a[text()=\"Reset Credential Attempts\"]");
    private static final By CUSTOMER_REGISTRATION = By.xpath("//a[@href=\"/ipayCallCenterApp/registrationCredentialAttempt\"]");
    private static final By ENTER_MOBILE_NO = By.id("mobile");
    private static final By CLICK_SEARCH = By.xpath("(//button[@class='btn btn-primary']) [1]");
    private static final By CLICK_CHECKBOX_RESET_ATTEMPTS = By.id("verificationRetryCountReset");
    private static final By CLICK_RESET_ATTEMPTS = By.xpath("(//button[@class='btn btn-primary']) [2]");
    private static final By SUCCESS_RESET = By.xpath("//div[@class='jconfirm-content']");

    public static void clickCustomer(WebDriver driver) {
        clickElement(driver, CUSTOMER);
    }
    public static void clickCusResetCredentials(WebDriver driver) {
        clickElement(driver, RESET_CREDENTIALS);
    }
    public static void clickCusReg(WebDriver driver) {
        clickElement(driver, CUSTOMER_REGISTRATION);
    }
    public static void enterMobileNo(WebDriver driver, String mobileNo){
        enterText(driver, ENTER_MOBILE_NO, mobileNo);
    }
    public static void clickSearch(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CLICK_SEARCH)).click();
//        clickElement(driver, CLICK_SEARCH);
    }
    public static void clickCheckbox(WebDriver driver) {
        clickElement(driver, CLICK_CHECKBOX_RESET_ATTEMPTS);
    }
    public static void clickResetAttempts(WebDriver driver) {
        clickElement(driver, CLICK_RESET_ATTEMPTS);
    }
    public static void successResetAttempt(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_RESET));
        Assert.assertEquals(errorMessage.getText(), "Attempts reset successfully.");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
}
