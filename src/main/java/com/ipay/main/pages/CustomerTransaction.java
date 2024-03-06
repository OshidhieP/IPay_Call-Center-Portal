package com.ipay.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerTransaction  extends BaseClass {

      private static final By CUSTOMER = By.id("sel-menu-customer");
      private static final By CUSTOMER_TRANSACTION = By.id("sel-menu-customer-trans");
      private static final By SEARCH = By.id("customer_search");
      private static final By SEARCH_NIC = By.id("nic");
      private static final By CLICK_SEARCH = By.name("search");
      private static final By CLICK_ELEMENT = By.xpath("(//tr/td[@role='gridcell']) [1]");
      private static final By DATE_SELECT_FROM = By.xpath("(//span[@class='input-group-addon'])[3]");
      private static final By DATE_SELECT_TO = By.xpath("(//span[@class='input-group-addon'])[4]");
      private static final By INPUT_DATE_SELECT_FROM = By.id("dateFrom");
      private static final By INPUT_DATE_SELECT_TO = By.id("(dateTo");
      private static final By DATA_LOADED = By.xpath("(//span[@class='k-pager-info k-label'])[2]");
      private static final By RECEIVED = By.xpath("(//input[@name='tranType']) [2]");
      private static final By FAILED = By.xpath("(//input[@name='tranType']) [3]");
      private static final By ALL_TRANS = By.xpath("(//input[@name='tranType']) [4]");

    public static void clickCustomer(WebDriver driver) {
        clickElement(driver, CUSTOMER);
    }
    public static void clickCustomerTransaction(WebDriver driver) {
        clickElement(driver, CUSTOMER_TRANSACTION);
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
    public static void clickElements(WebDriver driver) {
        doubleClick(driver, CLICK_ELEMENT);
    }
    public static void clickReceived(WebDriver driver) {
        doubleClick(driver, RECEIVED);
    }
    public static void clickFailed(WebDriver driver) {
        doubleClick(driver, FAILED);
    }
    public static void clickAllTransfers(WebDriver driver) {
        doubleClick(driver, ALL_TRANS);
    }

    public static void successfullyLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(DATA_LOADED));

        // Define the expected pattern using Regex
        String expectedPattern = "\\d+ - \\d+ of \\d+ items";

        // Assert that the message matches the expected pattern
        Assert.assertTrue(errorMessage.getText().matches(expectedPattern));

        // Extract and assert the "items" part using Regex
        Pattern itemsPattern = Pattern.compile("of (\\d+) items");
        Matcher matcher = itemsPattern.matcher(errorMessage.getText());

        System.out.println("Actual Error Message: " + errorMessage.getText());
    }


//    public static void clickFromDate(WebDriver driver) {
//        clickElement(driver, DATE_SELECT_FROM);
//
//    }
//    public static void clickToDate(WebDriver driver) {
//        clickElement(driver, DATE_SELECT_TO);
//    }
}
