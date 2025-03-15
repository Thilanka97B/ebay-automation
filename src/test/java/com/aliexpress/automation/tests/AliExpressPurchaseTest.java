package com.aliexpress.automation.tests;

import com.aliexpress.automation.pages.AliExpressHomePage;
import com.aliexpress.automation.pages.AliExpressLoginPage;
import com.aliexpress.automation.pages.AliExpressSearchResultsPage;
import com.aliexpress.automation.pages.AliExpressProductPage;
import com.aliexpress.automation.utils.WebDriverManagerUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AliExpressPurchaseTest {
    private WebDriver driver;
    private AliExpressHomePage homePage;
    private AliExpressLoginPage loginPage;
    private AliExpressSearchResultsPage searchResultsPage;
    private AliExpressProductPage productPage;

    @BeforeClass
    public void setUp() {
        // Initialize the WebDriver using the utility class
        driver = WebDriverManagerUtil.setupDriver();

        // Set the browser to full-screen mode
        driver.manage().window().fullscreen(); // Full-screen mode
        driver.get("https://www.aliexpress.com/");

        // Initialize page objects
        homePage = new AliExpressHomePage(driver);
        loginPage = new AliExpressLoginPage(driver);
        searchResultsPage = new AliExpressSearchResultsPage(driver);
        productPage = new AliExpressProductPage(driver);
    }

    @Test
    public void testPurchaseFlow() {
        // Ensure the browser is in full-screen mode before performing actions
        driver.manage().window().fullscreen(); // Set to full-screen mode

        // Perform login
        loginPage.login("bhagyathilanka@gmail.com", "973383566Vb"); // Replace with valid credentials

        // Search for a product
        homePage.searchForItem("laptop");
        searchResultsPage.selectFirstProduct();
        productPage.addToCart();

        // Additional assertions can be added here
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}