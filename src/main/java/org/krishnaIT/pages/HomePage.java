package org.krishnaIT.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    // Locators
    By logo = By.id("nava");
    By cartButton = By.id("cartur");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLogo() {
        return driver.findElement(logo);
    }


/*    public WebElement clickCartButton() {
        return driver.findElement(cartButton);
    }*/
}
