package com.ipay.main.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class DriverInitialization {

//    public static WebDriver initializeDriver() {
//        WebDriverManager.chromedriver().setup();
//        return new ChromeDriver();

public static WebDriver initializeDriverWithPermissions() {
    WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    HashMap<String, Integer> prefs = new HashMap<>();
    prefs.put("profile.default_content_setting_values.media_stream_mic", 1);
    prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
    options.setExperimentalOption("prefs", prefs);

    return new ChromeDriver(options);
}
}