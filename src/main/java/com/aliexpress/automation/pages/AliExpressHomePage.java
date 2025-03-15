package com.aliexpress.automation.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AliExpressHomePage {
    private WebDriver driver;

    // Locators
    private By searchBox = By.name("searchWords");
    private By searchButton = new By.ByXPath("//*[@id=\"_full_container_header_23_\"]/div[2]/div/div[1]/div/input[2]");

    // Constructor
    public AliExpressHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to perform search
    public void searchForItem(String item) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));



        // Wait for the search box to be visible
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        searchInput.clear();
        searchInput.sendKeys(item);

        // Wait for the search button to be clickable and then click
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        button.click();
    }
}