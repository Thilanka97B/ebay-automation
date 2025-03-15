package com.aliexpress.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AliExpressLoginPage {
    private WebDriver driver;

    // Locators
    // Click on the icon to open the Sign-in/Register dropdown (XPath for the icon)
    private By signInIcon = By.xpath("//*[@id='_full_container_header_23_']/div[2]/div/div[2]/div[3]/span[1]/svg/path");
    private By signInButton = By.xpath("/html/body/div[11]/div/div/div[2]/div/div/div[1]/button"); // Updated locator for the sign-in button
    private By emailField = By.id("fm-login-id"); // Locator for the email input field
    private By passwordField = By.id("fm-login-password"); // Locator for the password input field
    private By submitButton = By.className("fm-button"); // Locator for the submit button

    // Constructor
    public AliExpressLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to log in
    public void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the "Sign in / Register" icon is visible before hovering over it
        WebElement signInIconElement = wait.until(ExpectedConditions.visibilityOfElementLocated(signInIcon));

        // Create an instance of Actions class
        Actions actions = new Actions(driver);

        // Hover over the "Sign in / Register" icon (no click, just hover)
        actions.moveToElement(signInIconElement).perform();

        // Click the sign-in button
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();

        // Wait for the email field to be visible and enter the email
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);

        // Wait for the password field to be visible and enter the password
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);

        // Click the submit button
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
}