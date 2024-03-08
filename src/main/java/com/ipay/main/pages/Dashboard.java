package com.ipay.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.ipay.main.pages.BaseClass.clickElement;

public class Dashboard {
    private static final By CLICK_DASHBOARD = By.id("sel-menu-dash");
    private static final By CLICK_PENDING_FLATULENT_ACTIVITIES = By.xpath("(//a[@href=\"/ipayCallCenterApp/fraudulentActivity\"]) [2]");
    private static final By SUCCESS_CLICK_PENDING_FLATULENT_ACTIVITIES = By.xpath("//div[@class='x_title']");
    private static final By CLICK_PENDING_CUSTOMER_REVIEWS = By.xpath("//a[contains(@href, '/ipayCallCenterApp/customerRegistrationInquiry?action=S&mode=ekyc')]");
    private static final By SUCCESS_CLICK_PENDING_CUSTOMER_REVIEWS = By.xpath("//div[@class='x_title']");
    private static final By CLICK_RESUBMIT_CUSTOMER_REVIEWS = By.xpath("//p/a[@href=\"/ipayCallCenterApp/customerRegistrationInquiry?action=RS\"]");
    private static final By SUCCESS_CLICK_RESUBMIT_CUSTOMER_REVIEWS = By.xpath("//div[@class='x_title']");
    private static final By CLICK_PENDING_DBA_REQUESTS = By.xpath("(//a[text()='View Details...']) [4]");
    private static final By SUCCESS_CLICK_PENDING_DBA_REQUESTS = By.xpath("//div[@class='x_title']");
    private static final By CLICK_PENDING_OLD_CUS_EKYC = By.xpath("(//a[text()='View Details...']) [5]");
    private static final By SUCCESS_CLICK_PENDING_OLD_CUS_EKYC = By.xpath("//div[@class='x_title']");
    private static final By CLICK_RESUBMIT_PENDING_OLD_CUS_EKYC = By.xpath("(//a[text()='View Details...']) [6]");
    private static final By SUCCESS_CLICK_RESUBMIT_PENDING_OLD_CUS_EKYC = By.xpath("//div[@class='x_title']");
    private static final By CLICK_GIFT_REDEMPTION = By.xpath("(//a[text()='View Details...']) [7]");
    private static final By SUCCESS_CLICK_GIFT_REDEMPTION = By.xpath("//div[@class='x_title']");
    private static final By CLICK_ONGOING_TRANSACTIONS = By.xpath("//p/a[@href=\"/ipayCallCenterApp/transactionScheduler/ongoingTransatcionSchedulerPage\"]");
    private static final By SUCCESS_CLICK_ONGOING_TRANSACTIONS = By.xpath("//div[@class='x_title']");
    private static final By CLICK_PENDING_VKYC_REVIEWS = By.xpath("(//a[text()='View Details...']) [9]");
    private static final By SUCCESS_CLICK_PENDING_VKYC_REVIEWS = By.xpath("//div[@class=\"x_title\" and h2[text()=\"Customer Registration Inquiry\"]]");
    private static final By CLICK_RESUBMIT_VKYC = By.xpath("(//a[text()='View Details...']) [10]");
    private static final By SUCCESS_CLICK_RESUBMIT_VKYC = By.xpath("//div[@class='x_title']");
    private static final By CLICK_CUSTOMER_FEEDBACK = By.xpath("(//a[text()='View Details...']) [11]");
    private static final By SUCCESS_CLICK_CUSTOMER_FEEDBACK = By.xpath("//div[@class='x_title']");

    public static void clickDashboard(WebDriver driver) throws InterruptedException {
        clickElement(driver, CLICK_DASHBOARD);
        Thread.sleep(3000);
    }

    public static void clickPendingFraudulentAndVerify(WebDriver driver) {
        clickElement(driver, CLICK_PENDING_FLATULENT_ACTIVITIES);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CLICK_PENDING_FLATULENT_ACTIVITIES));

        Assert.assertEquals(errorMessage.getText(), "Fraudulent Activity Review");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
    public static void clickPendingCustomer(WebDriver driver) {
        clickElement(driver, CLICK_PENDING_CUSTOMER_REVIEWS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CLICK_PENDING_CUSTOMER_REVIEWS));

        Assert.assertEquals(errorMessage.getText(), "Customer Registration Inquiry");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
    public static void clickResubmittedCustomer(WebDriver driver) {
        clickElement(driver, CLICK_RESUBMIT_CUSTOMER_REVIEWS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CLICK_RESUBMIT_CUSTOMER_REVIEWS));

        Assert.assertEquals(errorMessage.getText(), "Customer Registration Inquiry");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
    public static void clickPendingDBA(WebDriver driver) {
        clickElement(driver, CLICK_PENDING_DBA_REQUESTS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CLICK_PENDING_DBA_REQUESTS));

        Assert.assertEquals(errorMessage.getText(), "DBA Request Inquiry");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
    public static void clickPendingOldCustomerEKYC(WebDriver driver) {
        clickElement(driver, CLICK_PENDING_OLD_CUS_EKYC);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CLICK_PENDING_OLD_CUS_EKYC));

        Assert.assertEquals(errorMessage.getText(), "Old Customers EKYC Inquiry");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
    public static void clickResubmittedOldCustomerEKYC(WebDriver driver) {
        clickElement(driver, CLICK_RESUBMIT_PENDING_OLD_CUS_EKYC);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CLICK_RESUBMIT_PENDING_OLD_CUS_EKYC));

        Assert.assertEquals(errorMessage.getText(), "Old Customers EKYC Inquiry");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
    public static void clickGiftRedemption(WebDriver driver) {
        clickElement(driver, CLICK_GIFT_REDEMPTION);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CLICK_GIFT_REDEMPTION));

        Assert.assertEquals(errorMessage.getText(), "Gift Redemption Reminders");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
    public static void clickOngoingTransaction(WebDriver driver) {
        clickElement(driver, CLICK_ONGOING_TRANSACTIONS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CLICK_ONGOING_TRANSACTIONS));

        Assert.assertEquals(errorMessage.getText(), "Scheduler Transactions");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
    public static void clickPendingVKYC(WebDriver driver) {
        clickElement(driver, CLICK_PENDING_VKYC_REVIEWS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CLICK_PENDING_VKYC_REVIEWS));

        Assert.assertEquals(errorMessage.getText(), "Customer Registration Inquiry");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
    public static void clickResubmittedVKYC(WebDriver driver) {
        clickElement(driver, CLICK_RESUBMIT_VKYC);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CLICK_RESUBMIT_VKYC));

        Assert.assertEquals(errorMessage.getText(), "Customer Registration Inquiry");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
    public static void clickCustomerFeedback(WebDriver driver) {
        clickElement(driver, CLICK_CUSTOMER_FEEDBACK);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_CLICK_CUSTOMER_FEEDBACK));

        Assert.assertEquals(errorMessage.getText(), "Customer Feedback");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
}
