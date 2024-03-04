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



//    public static void empNoSearch(WebDriver driver, String empNo) {
//        enterText(driver, ENTER_EMP_ID, empNo);
//        WebElement categoryInput = driver.findElement(ENTER_EMP_ID);
//        categoryInput.sendKeys(Keys.RETURN);
//    }

//    public static void invalidMessage(WebDriver driver) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(INVALID_MESSAGE));
//        //Assert.assertEquals("We have trouble connecting to your bank. Please try again in a little while.", "We have trouble connecting to your bank. Please try again in a little while.");
//        Assert.assertEquals(errorMessage.getText(), "Server error. Please try again later.");
//        System.out.println("Actual Error Message: " + errorMessage.getText());
//    }
//    public static void invalidNIC(WebDriver driver) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(INVALID_MESSAGE_NIC));
//        Assert.assertEquals(errorMessage.getText(), "Please enter no more than 12 characters.");
//        System.out.println("Actual Error Message: " + errorMessage.getText());
//    }
//
//    public static void invalidMerchantMobileNo(WebDriver driver) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
//        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(INVALID_MESSAGE_M_MOBILE_NO));
//        Assert.assertEquals(errorMessage.getText(), "Please enter a valid mobile no.");
//        System.out.println("Actual Error Message: " + errorMessage.getText());
//    }

}