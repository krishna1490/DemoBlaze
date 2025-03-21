package org.krishnaIT;

import com.aventstack.extentreports.Status;
import org.krishnaIT.pages.HomePage;
import org.krishnaIT.tests.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends BaseTest {
    private HomePage homePage;

    private static final Logger logger = LoggerFactory.getLogger(HomePageTest.class);
    @BeforeClass
    public void setUpHomePage() {
        driver.get("https://www.demoblaze.com/"); // Navigate to the page
        homePage = new HomePage(driver); // Initialize HomePage object
    }

    @Test
    public void testLogo() {
            test.log(Status.INFO, "Verifying logo is displayed...");
            logger.info("Verifying logo is displayed...");
            Assert.assertTrue(homePage.getLogo().isDisplayed(), "Logo is not displayed!");
            test.log(Status.PASS, "Logo is displayed successfully!");
    }

    @Test
    public void testHomeButton(){
        test.log(Status.INFO, "Verifying Home button is displayed...");
        logger.info("Verifying Home button is displayed...");
        Assert.assertTrue(homePage.clickHomeButton().isDisplayed(),"Home button is not displayed");
        test.log(Status.PASS, "Home button is displayed successfully!");
    }
}
