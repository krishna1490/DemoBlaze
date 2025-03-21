package org.krishnaIT.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerUtil {

    // Method to initialize ChromeDriver
    public static WebDriver initializeChromeDriver() {
        //WebDriverManager.chromedriver().driverVersion("134.0.6998.88").setup();
        WebDriverManager.chromedriver().setup(); // Automatically sets up chromedriver
        return new ChromeDriver(); // Returns a new ChromeDriver instance
    }

    // Method to initialize FirefoxDriver
    public static WebDriver initializeFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup(); // Automatically sets up geckodriver
        return new FirefoxDriver(); // Returns a new FirefoxDriver instance
    }

    // Add more methods here for other browsers (e.g., Edge, Safari, etc.) if needed

    // Utility method for selecting the browser dynamically (optional)
    public static WebDriver initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            return initializeChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            return initializeFirefoxDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }
}
