package com.aliexpress.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AliExpressSearchResultsPage {
    private WebDriver driver;

    // Locators
    private By firstProduct = By.cssSelector(".product-item:first-child");

    // Constructor
    public AliExpressSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to select the first product
    public void selectFirstProduct() {

    }

    public void selectFirstItem() {
    }
}