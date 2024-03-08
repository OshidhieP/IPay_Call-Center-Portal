package com.ipay.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.ipay.main.pages.BaseClass.*;

public class CustomerBankAccountsCards {
    private static final By CUSTOMER = By.id("sel-menu-customer");
    private static final By CUSTOMER_BANK_ACC = By.id("sel-menu-customer-bank-acc");
    private static final By SEARCH = By.id("customer_search");
    private static final By SEARCH_NIC = By.id("nic");
    private static final By CLICK_SEARCH = By.name("search");
    private static final By CLICK_ELEMENT = By.xpath("(//tr/td[@role='gridcell']) [1]");
    private static final By CLICK_CARDS = By.xpath("//li[@onclick=\"clickTab('cards')\"]");
    private static final By CLICK_BANK = By.xpath("//li[@onclick=\"clickTab('bank_accounts')\"]");
    private static final By CARD_CLICK_DELETE = By.xpath("(//a[@class='k-button k-button-icontext k-grid-delete']) [11]");
    private static final By BANK_CLICK_DELETE = By.xpath("(//a[@class='k-button k-button-icontext k-grid-delete']) [1]");
    private static final By DELETE_MSG = By.xpath("//div[@class='jconfirm-content']");

    public static void clickCustomer(WebDriver driver) {
        clickElement(driver, CUSTOMER);
    }
    public static void clickCustomerBankAcc(WebDriver driver) {
        clickElement(driver, CUSTOMER_BANK_ACC);
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

    public static void clickCards(WebDriver driver) throws InterruptedException {
        Thread.sleep(20000);
        clickElement(driver, CLICK_CARDS);
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // Wait up to 120 seconds
//      wait.until(ExpectedConditions.elementToBeClickable(CLICK_CARDS)).click();
    }

    public static void clickDelete(WebDriver driver) {
        clickElement(driver, CARD_CLICK_DELETE);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(DELETE_MSG));

        Assert.assertEquals(errorMessage.getText(), "Already Deleted Card");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }

    public static void clickBank(WebDriver driver) throws InterruptedException {
        Thread.sleep(20000);
        clickElement(driver, CLICK_BANK);
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // Wait up to 120 seconds
//      wait.until(ExpectedConditions.elementToBeClickable(CLICK_CARDS)).click();
    }

    public static void clickBankDelete(WebDriver driver) {
        clickElement(driver, BANK_CLICK_DELETE);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(DELETE_MSG));

        Assert.assertEquals(errorMessage.getText(), "Already Deleted Bank Account");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }


//    public static void successfullyDeleted(WebDriver driver) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(DELETE_MSG));
//        Assert.assertEquals(errorMessage.getText(), "Already Deleted Card");
//        System.out.println("Actual Error Message: " + errorMessage.getText());
//    }
}
