package com.ipay.tests;

import com.ipay.main.pages.*;
import com.ipay.main.webdriver.DriverInitialization;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.ipay.main.utils.*;

public class TestClass {

    private WebDriver driver;
    private static JSONObject loginTestData;
    private static JSONObject cusSearchTestData;
    private static JSONObject customer;

    @BeforeMethod
    public void login (){
        driver = DriverInitialization.initializeDriver();
        driver.get("https://developer.ipay.lk/ipayCallCenterApp/login");
        driver.manage().window().maximize();

        loginTestData = TestDataLoader.LoginTestData();
        cusSearchTestData = TestDataLoader.CustomerSearch();
        customer = TestDataLoader.CustomerTransaction();

        LoginPage.enterUsername(driver, loginTestData.get("validUsername").toString());
        LoginPage.enterPassword(driver, loginTestData.get("validPassword").toString());
        LoginPage.clickLoginButton(driver);
    }

    @Test(testName = "Validate the Success Login", priority = 1)
    public void loginValidation() {
        LoginPage.validMessage(driver);//Assertion
    }

    @Test(testName = "Dashboard", priority = 5)
    public void successDashboardLoaded() throws InterruptedException {
        Dashboard.clickPendingFraudulentAndVerify(driver);
        Dashboard.clickDashboard(driver);
        Dashboard.clickPendingCustomer(driver);
        Dashboard.clickDashboard(driver);
        Dashboard.clickResubmittedCustomer(driver);
        Dashboard.clickDashboard(driver);
        Dashboard.clickPendingDBA(driver);
        Dashboard.clickDashboard(driver);
        Dashboard.clickPendingOldCustomerEKYC(driver);
        Dashboard.clickDashboard(driver);
        Dashboard.clickResubmittedOldCustomerEKYC(driver);
        Dashboard.clickDashboard(driver);
        Dashboard.clickGiftRedemption(driver);
        Dashboard.clickDashboard(driver);
        Dashboard.clickOngoingTransaction(driver);
        Dashboard.clickDashboard(driver);
        Dashboard.clickPendingVKYC(driver);
        Dashboard.clickDashboard(driver);
        Dashboard.clickResubmittedVKYC(driver);
        Dashboard.clickDashboard(driver);
        Dashboard.clickCustomerFeedback(driver);
        Dashboard.clickDashboard(driver);
    }

    @Test(testName = "Validate the Invalid Login", priority = 2)
    public void loginWithInvalidCredentials() {
        LoginPage.click1(driver);
        LoginPage.click2(driver);
        LoginPage.enterUsername(driver, loginTestData.get("invalidUsername").toString());
        LoginPage.enterPassword(driver, loginTestData.get("invalidPassword").toString());
        LoginPage.clickLoginButton(driver);
        LoginPage.isErrorMessageDisplayed(driver);//Assertion
    }

    @Test(testName = "Search Customer by nic", priority = 3)
    public void searchCustomerUsingNic(){
        CustomerSearch.clickCustomer(driver);
        CustomerSearch.clickSearchCustomer(driver);
        CustomerSearch.enterNic(driver, cusSearchTestData.get("nic").toString());
        CustomerSearch.clickSearch(driver);
        CustomerSearch.clickElement(driver);
        CustomerSearch.correctPageLoadedInPerCustomer(driver);//Assertion
        CustomerSearch.clickSwitchCustomer(driver);
        CustomerSearch.clickClear(driver);
        CustomerSearch.successfullyCleared(driver);//Assertion
    }

    @Test(testName = "Search Customer by mobile no", priority = 4)
    public void searchCustomerUsingMobileNo(){
        CustomerSearch.clickCustomer(driver);
        CustomerSearch.clickSearchCustomer(driver);
        CustomerSearch.enterMobileNo(driver, cusSearchTestData.get("mobileNo").toString());
        CustomerSearch.clickSearch(driver);
        CustomerSearch.clickElement(driver);
        CustomerSearch.correctPageLoadedInPerCustomer(driver);//Assertion
        CustomerSearch.clickSwitchCustomer(driver);
        CustomerSearch.clickClear(driver);
        CustomerSearch.successfullyCleared(driver);//Assertion
    }
    @Test(testName = "Search Customer by username", priority = 4)
    public void searchCustomerUsingUsername(){
        CustomerSearch.clickCustomer(driver);
        CustomerSearch.clickSearchCustomer(driver);
        CustomerSearch.enterUsername(driver, cusSearchTestData.get("username").toString());
        CustomerSearch.clickSearch(driver);
        CustomerSearch.clickElement(driver);
        CustomerSearch.correctPageLoadedInPerCustomer(driver);//Assertion
        CustomerSearch.clickSwitchCustomer(driver);
        CustomerSearch.clickClear(driver);
        CustomerSearch.successfullyCleared(driver);//Assertion
    }
    @Test(testName = "Search Customer by email", priority = 4)
    public void searchCustomerUsingEmail(){
        CustomerSearch.clickCustomer(driver);
        CustomerSearch.clickSearchCustomer(driver);
        CustomerSearch.enterEmail(driver, cusSearchTestData.get("email").toString());
        CustomerSearch.clickSearch(driver);
        CustomerSearch.clickElement(driver);
        CustomerSearch.correctPageLoadedInPerCustomer(driver);//Assertion
        CustomerSearch.clickSwitchCustomer(driver);
        CustomerSearch.clickClear(driver);
        CustomerSearch.successfullyCleared(driver);//Assertion
    }
    @Test(testName = "Search Customer by first name", priority = 4)
    public void searchCustomerUsingFirstName(){
        CustomerSearch.clickCustomer(driver);
        CustomerSearch.clickSearchCustomer(driver);
        CustomerSearch.enterFirstName(driver, cusSearchTestData.get("firstName").toString());
        CustomerSearch.clickSearch(driver);
        CustomerSearch.clickElement(driver);
        CustomerSearch.correctPageLoadedInPerCustomer(driver);//Assertion
        CustomerSearch.clickSwitchCustomer(driver);
        CustomerSearch.clickClear(driver);
        CustomerSearch.successfullyCleared(driver);//Assertion
    }
    @Test(testName = "Search Customer by last name", priority = 4)
    public void searchCustomerUsingLastName(){
        CustomerSearch.clickCustomer(driver);
        CustomerSearch.clickSearchCustomer(driver);
        CustomerSearch.enterLastName(driver, cusSearchTestData.get("lastName").toString());
        CustomerSearch.clickSearch(driver);
        CustomerSearch.clickElement(driver);
        CustomerSearch.correctPageLoadedInPerCustomer(driver);//Assertion
        CustomerSearch.clickSwitchCustomer(driver);
        CustomerSearch.clickClear(driver);
        CustomerSearch.successfullyCleared(driver);//Assertion
    }
    @Test(testName = "Search Customer by passport no", priority = 4)
    public void searchCustomerUsingPassportNo(){
        CustomerSearch.clickCustomer(driver);
        CustomerSearch.clickSearchCustomer(driver);
        CustomerSearch.enterPassportNo(driver, cusSearchTestData.get("passportNo").toString());
        CustomerSearch.clickSearch(driver);
        CustomerSearch.clickElement(driver);
        CustomerSearch.correctPageLoadedInPerCustomer(driver);//Assertion
        CustomerSearch.clickSwitchCustomer(driver);
        CustomerSearch.clickClear(driver);
        CustomerSearch.successfullyCleared(driver);//Assertion
    }
    @Test(testName = "Search Customer by bank account no", priority = 4)
    public void searchCustomerUsingBankAccNo(){
        CustomerSearch.clickCustomer(driver);
        CustomerSearch.clickSearchCustomer(driver);
        CustomerSearch.enterBankAccNo(driver, cusSearchTestData.get("bankAccNo").toString());
        CustomerSearch.clickSearch(driver);
        CustomerSearch.clickElement(driver);
        CustomerSearch.correctPageLoadedInPerCustomer(driver);//Assertion
        CustomerSearch.clickSwitchCustomer(driver);
        CustomerSearch.clickClear(driver);
        CustomerSearch.successfullyCleared(driver);//Assertion
    }

    @Test(testName = "Customer Registration by Paid", priority = 5)
    public void customerTransactionByPaid() throws InterruptedException {
        CustomerTransaction.clickCustomer(driver);
        CustomerTransaction.clickCustomerTransaction(driver);
        CustomerTransaction.search(driver);
        CustomerTransaction.enterNic(driver, cusSearchTestData.get("nic").toString());
        CustomerTransaction.clickSearch(driver);
        CustomerTransaction.clickElements(driver);
        CustomerTransaction.successfullyLoaded(driver);
    }

    @Test(testName = "Customer Registration by Received", priority = 5)
    public void customerTransactionByReceived() throws InterruptedException {
        CustomerTransaction.clickCustomer(driver);
        CustomerTransaction.clickCustomerTransaction(driver);
        CustomerTransaction.search(driver);
        CustomerTransaction.enterNic(driver, cusSearchTestData.get("nic").toString());
        CustomerTransaction.clickSearch(driver);
        CustomerTransaction.clickElements(driver);
        CustomerTransaction.clickReceived(driver);
        CustomerTransaction.successfullyLoaded(driver);
    }

    @Test(testName = "Customer Registration by Failed", priority = 5)
    public void customerTransactionByFailed() throws InterruptedException {
        CustomerTransaction.clickCustomer(driver);
        CustomerTransaction.clickCustomerTransaction(driver);
        CustomerTransaction.search(driver);
        CustomerTransaction.enterNic(driver, cusSearchTestData.get("nic").toString());
        CustomerTransaction.clickSearch(driver);
        CustomerTransaction.clickElements(driver);
        CustomerTransaction.clickFailed(driver);
        CustomerTransaction.successfullyLoaded(driver);
    }

    @Test(testName = "Customer Registration by All Transfers", priority = 5)
    public void customerTransactionByAllTransfers() throws InterruptedException {
        CustomerTransaction.clickCustomer(driver);
        CustomerTransaction.clickCustomerTransaction(driver);
        CustomerTransaction.search(driver);
        CustomerTransaction.enterNic(driver, cusSearchTestData.get("nic").toString());
        CustomerTransaction.clickSearch(driver);
        CustomerTransaction.clickElements(driver);
        CustomerTransaction.clickAllTransfers(driver);
        CustomerTransaction.successfullyLoaded(driver);
    }

    @Test(testName = "Customer bank accounts & cards using cards", priority = 6)
    public void searchCustomerUsingBankAccNoUsingCards() throws InterruptedException {
        CustomerBankAccountsCards.clickCustomer(driver);
        CustomerBankAccountsCards.clickCustomerBankAcc(driver);
        CustomerBankAccountsCards.search(driver);
        CustomerBankAccountsCards.enterNic(driver, cusSearchTestData.get("nic").toString());
        CustomerBankAccountsCards.clickSearch(driver);
        CustomerBankAccountsCards.clickElements(driver);
        CustomerBankAccountsCards.clickCards(driver);
        CustomerBankAccountsCards.clickDelete(driver);

    }

    @Test(testName = "Customer bank accounts & cards using bank accounts", priority = 6)
    public void searchCustomerUsingBankAccNoUsingBankAcc() throws InterruptedException {
        CustomerBankAccountsCards.clickCustomer(driver);
        CustomerBankAccountsCards.clickCustomerBankAcc(driver);
        CustomerBankAccountsCards.search(driver);
        CustomerBankAccountsCards.enterNic(driver, cusSearchTestData.get("nic").toString());
        CustomerBankAccountsCards.clickSearch(driver);
        CustomerBankAccountsCards.clickElements(driver);
        CustomerBankAccountsCards.clickBank(driver);
        CustomerBankAccountsCards.clickBankDelete(driver);
    }

    @Test(testName = "Customer Reset Credential Attempts - Customer Registration", priority = 7)
    public void customerResetCredentialAttemptsCustomerRegistration() {
        CustomerResetCredentialAttempts.clickCustomer(driver);
        CustomerResetCredentialAttempts.clickCusResetCredentials(driver);
        CustomerResetCredentialAttempts.clickCusReg(driver);
        CustomerResetCredentialAttempts.enterMobileNo(driver, customer.get("mobileNo").toString());
        CustomerResetCredentialAttempts.clickSearch(driver);
        CustomerResetCredentialAttempts.clickCheckbox(driver);
        CustomerResetCredentialAttempts.clickCusResetCredentials(driver);
        CustomerResetCredentialAttempts.clickResetAttempts(driver);
        CustomerResetCredentialAttempts.successResetAttempt(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}