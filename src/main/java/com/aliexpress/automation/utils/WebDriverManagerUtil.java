package com.aliexpress.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManagerUtil {
    public static WebDriver setupDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}