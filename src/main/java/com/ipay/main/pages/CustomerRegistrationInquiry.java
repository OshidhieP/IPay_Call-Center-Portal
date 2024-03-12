package com.ipay.main.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

import static com.ipay.main.pages.BaseClass.*;

public class CustomerRegistrationInquiry {
    private static final By CUSTOMER = By.id("sel-menu-customer");
    private static final By REGISTRATION_INQUIRY = By.id("sel-menu-customer-inquiry");
    private static final By VERIFICATION_STATUS_DROPDOWN = By.id("verificationStatus");
    private static final By VERIFICATION_STATUS_SUBMITTED = By.xpath("(//option[@value='S']) [1]");
    private static final By VERIFICATION_STATUS_APPROVED = By.xpath("(//option[@value='A']) [1]");
    private static final By VERIFICATION_STATUS_REJECTED = By.xpath("(//option[@value='R']) [1]");
    private static final By VERIFICATION_STATUS_RESUBMITTED = By.xpath("(//option[@value='RS']) [1]");
    private static final By VERIFICATION_STATUS_PENDING = By.xpath("(//option[@value='P']) [1]");
    private static final By VKYC_STATUS_DROPDOWN = By.id("vkycStatus");
    private static final By VKYC_STATUS_SUBMITTED = By.xpath("(//option[@value='S']) [2]");
    private static final By VKYC_STATUS_APPROVED = By.xpath("(//option[@value='A']) [2]");
    private static final By VKYC_STATUS_REJECTED = By.xpath("(//option[@value='R']) [2]");
    private static final By VKYC_STATUS_RESUBMITTED = By.xpath("(//option[@value='RS']) [2]");
    private static final By VKYC_STATUS_PENDING = By.xpath("(//option[@value='P']) [2]");
    private static final By REGISTRATION_DATE_FROM = By.id("dateFrom");
    private static final By REGISTRATION_DATE_TO = By.id("dateTo");
    private static final By CLICK_REGISTRATION_DATE_FROM = By.xpath("(//span[@class='input-group-addon'] )[1]");
    private static final By CLICK_REGISTRATION_DATE_TO = By.xpath("(//span[@class='input-group-addon'] )[2]");
    private static final By CLICK_REVIEW_CUSTOMER_BUTTON = By.xpath("(//a[@class='k-button k-button-icontext k-grid-viewDetails']) [2]");
    private static final By SUCCESS_REVIEW = By.xpath("//div[@class='title_left']");

    public static void clickCustomer(WebDriver driver) {
        clickElement(driver, CUSTOMER);
    }
    public static void clickRegistrationInquiry(WebDriver driver) {
        clickElement(driver, REGISTRATION_INQUIRY);
    }
    public static void clickVerificationStatusDropdown(WebDriver driver) {
        clickElement(driver, VERIFICATION_STATUS_DROPDOWN);
    }
    public static void clickVerificationStatusDropdownSubmitted(WebDriver driver) {
        clickElement(driver, VERIFICATION_STATUS_SUBMITTED);
    }
    public static void clickVerificationStatusDropdownApproved(WebDriver driver) {
        clickElement(driver, VERIFICATION_STATUS_APPROVED);
    }
    public static void clickVerificationStatusDropdownRejected(WebDriver driver) {
        clickElement(driver, VERIFICATION_STATUS_REJECTED);
    }
    public static void clickVerificationStatusDropdownReSubmitted(WebDriver driver) {
        clickElement(driver, VERIFICATION_STATUS_RESUBMITTED);
    }
    public static void clickVerificationStatusDropdownPending(WebDriver driver) {
        clickElement(driver, VERIFICATION_STATUS_PENDING);
    }
    public static void clickVKYCStatusDropdown(WebDriver driver) {
        clickElement(driver, VKYC_STATUS_DROPDOWN);
    }
    public static void clickVKYCStatusDropdownSubmitted(WebDriver driver) {
        clickElement(driver, VKYC_STATUS_SUBMITTED);
    }
    public static void clickVKYCStatusDropdownApproved(WebDriver driver) {
        clickElement(driver, VKYC_STATUS_APPROVED);
    }
    public static void clickVKYCStatusDropdownRejected(WebDriver driver) {
        clickElement(driver, VKYC_STATUS_REJECTED);
    }
    public static void clickVKYCStatusDropdownReSubmitted(WebDriver driver) {
        clickElement(driver, VKYC_STATUS_RESUBMITTED);
    }
    public static void clickVKYCStatusDropdownPending(WebDriver driver) {
        clickElement(driver, VKYC_STATUS_PENDING);
    }
    public static void setupFromDate(WebDriver driver, String date) {
        WebElement dateInput = driver.findElement(REGISTRATION_DATE_FROM);
        dateInput.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + date + "';", dateInput);

        clickElement(driver, CLICK_REGISTRATION_DATE_FROM);
    }

    public static void setupToDate(WebDriver driver, String date) {
        WebElement dateInput = driver.findElement(REGISTRATION_DATE_TO);
        dateInput.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + date + "';", dateInput);

        doubleClick(driver, CLICK_REGISTRATION_DATE_TO);
    }
    public static void clickReviewCustomer(WebDriver driver) throws InterruptedException {
        waitInSeconds(driver, 5);
        clickElement(driver, CLICK_REVIEW_CUSTOMER_BUTTON);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.elementToBeClickable(CLICK_REVIEW_CUSTOMER_BUTTON)).click();
    }

    public static void successReviewCustomer(WebDriver driver) throws InterruptedException {
        waitInSeconds(driver, 5);
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new tab (assuming it's the last one in the set)
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
        }

        // Now wait for the element in the new tab
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(SUCCESS_REVIEW));
        Assert.assertEquals(errorMessage.getText(), "Customer Information");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }

}
