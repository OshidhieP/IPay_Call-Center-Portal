package com.ipay.tests;

import com.ipay.main.pages.CustomerSearch;
import com.ipay.main.webdriver.DriverInitialization;
import com.ipay.main.pages.LoginPage;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.ipay.main.utils.*;

public class TestClass {

    private WebDriver driver;
    private static JSONObject loginTestData;
    private static JSONObject cusSearchTestData;

    @BeforeMethod
    public void login (){
        driver = DriverInitialization.initializeDriver();
        driver.get("https://developer.ipay.lk/ipayCallCenterApp/login");
        driver.manage().window().maximize();

        loginTestData = TestDataLoader.LoginTestData();
        cusSearchTestData = TestDataLoader.CustomerSearch();

        LoginPage.enterUsername(driver, loginTestData.get("validUsername").toString());
        LoginPage.enterPassword(driver, loginTestData.get("validPassword").toString());
        LoginPage.clickLoginButton(driver);
    }

    @Test(testName = "Validate the Success Login", priority = 1)
    public void loginValidation() {
        LoginPage.validMessage(driver);//Assertion
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


//    @Test(testName = "Verify the response for merchant Customer registration using valid data", priority = 1)
//    public void merchantRegistration() throws InterruptedException {
//        MerchantRegistration.clickMerchant(driver);
//        MerchantRegistration.clickMerchantReg(driver);
//        MerchantRegistration.clickBType(driver);
//        MerchantRegistration.clickType(driver);
//        MerchantRegistration.clickSelect(driver);
//        MerchantRegistration.empNoSearch(driver, testData.get("validEmpNo").toString());
//        MerchantRegistration.clickEmpNoSearch(driver);
//        MerchantRegistration.clickNext(driver);
//        MerchantRegistration.enterMerchantName(driver, testData.get("merchantName").toString());
//        MerchantRegistration.enterBCode(driver, testData.get("businessCode").toString());
//        MerchantRegistration.bCategory(driver, testData.get("businessCategory").toString());
//        MerchantRegistration.next1(driver);
//        MerchantRegistration.enterNIC(driver, testData.get("nicNumber").toString());
//        String imagePath = new File("src/main/resources/images/nic.jpg").getAbsolutePath();
//        MerchantRegistration.uploadNic(driver, imagePath);
//        MerchantRegistration.addressLine1(driver, testData.get("addressLine1").toString());
//        MerchantRegistration.addressLine2(driver, testData.get("addressLine2").toString());
//        MerchantRegistration.cityEnter(driver, testData.get("city").toString());
//        Thread.sleep(3000);
//        MerchantRegistration.next2(driver);
//        Thread.sleep(2000);
//        MerchantRegistration.mUsername(driver, testData.get("merchantUsername").toString());
//        MerchantRegistration.mMobileNo(driver, testData.get("merchantMobileNo").toString());
//        Thread.sleep(3000);
//        MerchantRegistration.next3(driver);
//        MerchantRegistration.bank(driver, testData.get("bankName").toString());
//        MerchantRegistration.accNo(driver, testData.get("accountNumber").toString());
//        MerchantRegistration.finish(driver);
//        MerchantRegistration.invalidMessage(driver);//Assertion
//    }



//    @Test(testName = "Verify the response for merchant Customer registration without entering mandatory field", priority = 3)
//    public void merchantRegistrationNegative() {
//        MerchantRegistration.clickMerchant(driver);
//        MerchantRegistration.clickMerchantReg(driver);
//        MerchantRegistration.clickNext(driver);
//        MerchantRegistration.isErrorMessageDisplayed(driver);
//    }

//    @Test(testName = "Invalid data enter", priority = 4)
//    public void merchantNameInvalidInRegistration() throws InterruptedException {
//        MerchantRegistration.clickMerchant(driver);
//        MerchantRegistration.clickMerchantReg(driver);
//        MerchantRegistration.clickBType(driver);
//        MerchantRegistration.clickType(driver);
//        MerchantRegistration.clickSelect(driver);
//        MerchantRegistration.empNoSearch(driver, testData.get("invalidEmpNo").toString());
//        Thread.sleep(2000);
//        MerchantRegistration.errorMessageInIntroducer(driver);
//    }
//
//    @Test(testName = "Check Invalid NIC no", priority = 5)
//    public void invalidNicNo() throws InterruptedException {
//        MerchantRegistration.clickMerchant(driver);
//        MerchantRegistration.clickMerchantReg(driver);
//        MerchantRegistration.clickBType(driver);
//        MerchantRegistration.clickType(driver);
//        MerchantRegistration.clickSelect(driver);
//        MerchantRegistration.empNoSearch(driver, testData.get("validEmpNo").toString());
//        MerchantRegistration.clickEmpNoSearch(driver);
//        MerchantRegistration.clickNext(driver);
//        MerchantRegistration.enterMerchantName(driver, testData.get("merchantName").toString());
//        MerchantRegistration.enterBCode(driver, testData.get("businessCode").toString());
//        MerchantRegistration.bCategory(driver, testData.get("businessCategory").toString());
//        MerchantRegistration.next1(driver);
//        MerchantRegistration.enterNIC(driver, testData.get("invalidNicNumber").toString());
//        String imagePath = new File("src/main/resources/images/nic.jpg").getAbsolutePath();
//        MerchantRegistration.uploadNic(driver, imagePath);
//        MerchantRegistration.addressLine1(driver, testData.get("addressLine1").toString());
//        MerchantRegistration.addressLine2(driver, testData.get("addressLine2").toString());
//        MerchantRegistration.cityEnter(driver, testData.get("city").toString());
//        Thread.sleep(3000);
//        MerchantRegistration.invalidNIC(driver); //Assertion
//    }
//
//    @Test(testName = "Check Invalid Merchant Mobile No", priority = 6)
//    public void invalidMerchantMobileNo() throws InterruptedException {
//        MerchantRegistration.clickMerchant(driver);
//        MerchantRegistration.clickMerchantReg(driver);
//        MerchantRegistration.clickBType(driver);
//        MerchantRegistration.clickType(driver);
//        MerchantRegistration.clickSelect(driver);
//        MerchantRegistration.empNoSearch(driver, testData.get("validEmpNo").toString());
//        MerchantRegistration.clickEmpNoSearch(driver);
//        Thread.sleep(3000);
//        MerchantRegistration.clickNext(driver);
//        MerchantRegistration.enterMerchantName(driver, testData.get("merchantName").toString());
//        MerchantRegistration.enterBCode(driver, testData.get("businessCode").toString());
//        MerchantRegistration.bCategory(driver, testData.get("businessCategory").toString());
//        MerchantRegistration.next1(driver);
//        MerchantRegistration.enterNIC(driver, testData.get("nicNumber").toString());
//        String imagePath = new File("src/main/resources/images/nic.jpg").getAbsolutePath();
//        MerchantRegistration.uploadNic(driver, imagePath);
//        MerchantRegistration.addressLine1(driver, testData.get("addressLine1").toString());
//        MerchantRegistration.addressLine2(driver, testData.get("addressLine2").toString());
//        MerchantRegistration.cityEnter(driver, testData.get("city").toString());
//        Thread.sleep(3000);
//        MerchantRegistration.next2(driver);
//        Thread.sleep(2000);
//        MerchantRegistration.mUsername(driver, testData.get("merchantUsername").toString());
//        MerchantRegistration.mMobileNo(driver, testData.get("invalidMobileNo").toString());
//        MerchantRegistration.next3(driver);
//        Thread.sleep(3000);
//        MerchantRegistration.invalidMerchantMobileNo(driver); //Assertion
//    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
