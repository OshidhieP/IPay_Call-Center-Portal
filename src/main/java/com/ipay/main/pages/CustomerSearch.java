package com.ipay.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CustomerSearch extends BaseClass {

    private static final By CUSTOMER = By.id("sel-menu-customer");
    private static final By SEARCH_CUSTOMER = By.id("sel-menu-customer-search");
    private static final By SEARCH_NIC = By.id("nic");
    private static final By SEARCH_MOBILE_NO = By.id("mobileNo");
    private static final By SEARCH_USERNAME = By.id("username");
    private static final By SEARCH_EMAIL= By.id("email");
    private static final By SEARCH_PASSPORT_NO = By.id("passport");
    private static final By SEARCH_BANK_ACC_NO = By.id("bankAccountNo");
    private static final By SEARCH_F_NAME = By.id("firstName");
    private static final By SEARCH_L_NAME = By.id("lastName");
    private static final By CLICK_SEARCH = By.name("search");
    private static final By CLICK_ELEMENT = By.xpath("(//tr/td[@role='gridcell']) [1]");
    private static final By CUSTOMER_EXISTS = By.xpath("//a[@onclick='showCustomerSearch();']");
    private static final By SWITCH_CUSTOMER_EXISTS = By.xpath("//div[@class='col-md-12']");
    private static final By CLICK_CLEAR = By.xpath("(//button[@class='btn btn-default'])[1]");
    private static final By ITEMS_CLEARED = By.xpath("//span[@class='k-pager-info k-label']");
//    private static final By
//    private static final By
//    private static final By
//    private static final By
//    private static final By

    public static void clickCustomer(WebDriver driver) {
        clickElement(driver, CUSTOMER);
    }
    public static void clickSearchCustomer(WebDriver driver) {
        clickElement(driver, SEARCH_CUSTOMER);
    }
    public static void enterNic(WebDriver driver, String nic) {
        enterText(driver, SEARCH_NIC, nic);
    }
    public static void enterMobileNo(WebDriver driver, String mobileNo) {
        enterText(driver, SEARCH_MOBILE_NO, mobileNo);
    }
    public static void enterUsername(WebDriver driver, String username) {
        enterText(driver,SEARCH_USERNAME, username);
    }
    public static void enterEmail(WebDriver driver, String email) {
        enterText(driver,SEARCH_EMAIL , email);
    }
    public static void enterPassportNo(WebDriver driver, String passport) {
        enterText(driver,SEARCH_PASSPORT_NO , passport);
    }
    public static void enterBankAccNo(WebDriver driver, String bankAccNo) {
        enterText(driver,SEARCH_BANK_ACC_NO , bankAccNo);
    }
    public static void enterFirstName(WebDriver driver, String firstName) {
        enterText(driver,SEARCH_F_NAME , firstName);
    }
    public static void enterLastName(WebDriver driver, String lastName) {
        enterText(driver, SEARCH_L_NAME, lastName);
    }
    public static void clickSearch(WebDriver driver) {
        clickElement(driver, CLICK_SEARCH);
    }
    public static void clickElement(WebDriver driver) {
        doubleClick(driver, CLICK_ELEMENT);
    }
    public static void clickSwitchCustomer(WebDriver driver) {
        clickElement(driver, CUSTOMER_EXISTS);
    }
    public static void clickClear(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(CLICK_CLEAR)).click();
    }
    public static void correctPageLoadedInPerCustomer(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(SWITCH_CUSTOMER_EXISTS));
        Assert.assertEquals(errorMessage.getText(), "Switch Customer");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
    public static void successfullyCleared(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(ITEMS_CLEARED));
        Assert.assertEquals(errorMessage.getText(), "No items to display");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }

//    public static void empNoSearch(WebDriver driver, String empNo) {
//        enterText(driver, ENTER_EMP_ID, empNo);
//        WebElement categoryInput = driver.findElement(ENTER_EMP_ID);
//        categoryInput.sendKeys(Keys.RETURN);
//    }
}