package org.krishnaIT.tests;

import org.openqa.selenium.WebDriver;
import org.krishnaIT.pages.HomePage;
import org.krishnaIT.utils.WebDriverManagerUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        // Use the utility to initialize the browser (chrome or firefox)
        driver = WebDriverManagerUtil.initializeDriver("firefox"); // You can change this to "firefox" if needed
        driver.get("https://www.demoblaze.com/index.html");
        homePage = new HomePage(driver);
    }

    @Test
    public void testLogo() {
        Assert.assertTrue(homePage.getLogo().isDisplayed(), "Logo is not displayed!");
    }

    /*@Test
    public void testCart(){
        Assert.assertTrue(homePage.clickCartButton().isDisplayed(),"Cart is not displayed");
    }*/
}
