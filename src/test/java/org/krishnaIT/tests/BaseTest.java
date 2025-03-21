package org.krishnaIT.tests;

import com.aventstack.extentreports.ExtentTest;
import org.krishnaIT.pages.HomePage;
import org.krishnaIT.utils.ExtentManager;
import org.openqa.selenium.WebDriver;
import org.krishnaIT.utils.WebDriverManagerUtil;
import org.testng.annotations.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import java.lang.reflect.Method;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentTest test;

    public void captureScreenshot(String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destPath = "test-output/screenshots/" + testName + ".png";
        try {
            FileHandler.copy(srcFile, new File(destPath));
            test.addScreenCaptureFromPath(destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Parameters("browser")
    @BeforeClass
    public void setup(@Optional("chrome") String browser) {
        driver = WebDriverManagerUtil.initializeDriver(browser);
        driver.manage().window().maximize();
    }
    @BeforeMethod
    public void startTestReport(Method method) {
        test = ExtentManager.startTest(method.getName());
    }
    @AfterMethod
    public void endTestReport() {
        ExtentManager.endTest();
    }
    @AfterClass
    public void tearDown() {
        if(driver != null)
            driver.quit();
    }
}
