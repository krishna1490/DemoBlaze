package org.krishnaIT.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePage {
    WebDriver driver;

    // Locators
    @FindBy(id="nava")
    WebElement logo;

    @FindBy(xpath="//div[@id='navbarExample']/ul/li/a[text()='Home ']")
    WebElement home_button;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement clickHomeButton() {
        return home_button;
    }
}
