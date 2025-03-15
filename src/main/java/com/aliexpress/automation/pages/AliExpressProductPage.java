package com.aliexpress.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AliExpressProductPage {
    private WebDriver driver;

    // Locators
    private By addToCartButton = By.xpath("//*[@id=\"card-list\"]/div[1]/div/div/a/div[1]/div[2]/div/span");

    // Constructor
    public AliExpressProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to add product to cart
    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }
}