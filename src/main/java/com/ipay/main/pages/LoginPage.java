package com.ipay.main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BaseClass{

    private static final By USERNAME_FIELD = By.name("j_username_cc");
    private static final By PASSWORD_FIELD = By.name("j_password_cc");
    private static final By LOGIN_BUTTON = By.xpath("//button[@class='btn btn-primary btn-login']");
    private static final By ERROR_MESSAGE = By.xpath("//div[@class='alert alert-block alert-danger fade in']");
    private static final By VALID_MESSAGE = By.xpath("//div[@class='nav toggle header']");
    private static final By CLICK_1 = By.xpath("//a[@class ='user-profile dropdown-toggle']");
    private static final By CLICK_2 = By.xpath("//a/i[@class='fa fa-sign-out pull-left']");

    public static void enterUsername(WebDriver driver, String username) {
        enterText(driver, USERNAME_FIELD, username);
    }

    public static void enterPassword(WebDriver driver, String password) {
        enterText(driver, PASSWORD_FIELD, password);
    }

    public static void clickLoginButton(WebDriver driver) {
        clickElement(driver, LOGIN_BUTTON);
    }

    public static void click1(WebDriver driver) {
        clickElement(driver, CLICK_1);
    }
    public static void click2(WebDriver driver) {
        clickElement(driver, CLICK_2);
    }


    public static void validMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(VALID_MESSAGE));
        Assert.assertEquals(errorMessage.getText(), "iPay Call Center Portal");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }

    public static void isErrorMessageDisplayed(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        Assert.assertEquals(errorMessage.getText(), "Invalid username or password");
        System.out.println("Actual Error Message: " + errorMessage.getText());
    }
}
