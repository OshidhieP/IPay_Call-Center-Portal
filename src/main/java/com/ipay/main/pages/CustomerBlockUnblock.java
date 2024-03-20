package com.ipay.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.ipay.main.pages.BaseClass.*;

public class CustomerBlockUnblock {
    private static final By CUSTOMER = By.id("sel-menu-customer");
    private static final By CUSTOMER_BLOCK_UNBLOCK = By.id("sel-menu-customer-block-unblock");
    private static final By SEARCH = By.id("customer_search");
    private static final By SEARCH_NIC = By.id("nic");
    private static final By CLICK_SEARCH = By.name("search");
    private static final By CLICK_ELEMENT = By.xpath("(//tr/td[@role='gridcell']) [1]");
    private static final By DROPDOWN = By.id("action");
    private static final By CLICK_BLOCK = By.xpath("//option[@value='block']");
    private static final By CLICK_ACTIVATE= By.xpath("//option[@value='activate']");
    private static final By CLICK_CURRENT_STATUS_ACTIVATE = By.xpath("//input[@id=\"currentStatus\" and @name=\"currentStatus\" and @type=\"text\" and @value=\"Active\"]");
    private static final By CLICK_CURRENT_STATUS_BLOCK = By.xpath("//input[@id=\"currentStatus\" and @name=\"currentStatus\" and @type=\"text\" and @value=\"Blocked\"]");
    private static final By REMARK = By.id("remark");
    private static final By CLICK_SAVE = By.xpath("//button[@class='btn btn-primary']");
    private static final By CLICK_POPUP_YES = By.xpath("(//button[@class='btn btn-primary']) [2]");
    private static final By CLICK_OKAY = By.xpath("//div[@class=\"jconfirm-buttons\"]/button[@type=\"button\" and @class=\"btn btn-success\" and text()=\" OK \"]");
    private static final By POPUP_MESSAGE = By.xpath("//div[@class='jconfirm-content']");


    public static void clickCustomer(WebDriver driver) {
        clickElement(driver, CUSTOMER);
    }
    public static void clickCustomerTransaction(WebDriver driver) {
        clickElement(driver, CUSTOMER_BLOCK_UNBLOCK);
    }
    public static void search(WebDriver driver) {
        clickElement(driver, SEARCH);
    }
    public static void enterNic(WebDriver driver, String nic) {
        enterText(driver, SEARCH_NIC, nic);
    }
    public static void clickSearch(WebDriver driver) {
        clickElement(driver, CLICK_SEARCH);
    }
    public static void clickElements(WebDriver driver) throws InterruptedException {
        doubleClick(driver, CLICK_ELEMENT);
        Thread.sleep(3000);
    }
    public static void clickDropdown(WebDriver driver) {
        clickElement(driver, DROPDOWN);

        if (isElementPresent(driver, CLICK_CURRENT_STATUS_ACTIVATE)) {
            clickElement(driver, CLICK_BLOCK);
        } else {
            clickElement(driver, CLICK_ACTIVATE);
        }
    }

    // Additional method to check if an element is present
    public static boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public static void enterRemark(WebDriver driver, String remark) {
        enterText(driver, REMARK, remark);
    }
    public static void clickSave(WebDriver driver) throws InterruptedException {
        clickElement(driver, CLICK_SAVE);
        Thread.sleep(5000);
        clickElement(driver, CLICK_POPUP_YES);
        Thread.sleep(5000);
        clickElement(driver, CLICK_OKAY);
    }

    public static void popupMessageSuccess(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(POPUP_MESSAGE));

        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.contains("successfully blocked")) {
            Assert.assertEquals(actualErrorMessage, "Customer account successfully blocked");
            System.out.println("Actual Error Message: " + actualErrorMessage);
        } else if (actualErrorMessage.contains("successfully activated")) {
            Assert.assertEquals(actualErrorMessage, "Customer account successfully activated");
            System.out.println("Actual Error Message: " + actualErrorMessage);
        } else {
            // Handle unexpected message or raise an error
            Assert.fail("Unexpected error message: " + actualErrorMessage);
        }
    }

}
