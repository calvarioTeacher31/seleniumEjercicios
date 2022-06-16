package org.example.pageobjects.credentials;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By lockedMessage = By.tagName("h3");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPage() {
        log.info("Verifying login page UI elements");

        log.info("Verifying username input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(usernameInput), "username input is not displayed");

        log.info("Verifying password input is displayed");
        softAssert.assertTrue(verifyIsDisplayed(passwordInput), "username input is not displayed");

        log.info("Verifying login button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(loginButton), "username input is not displayed");
        softAssert.assertAll();
    }

    @Override
    public void waitPageToLoad() {
        waitPage(usernameInput, this.getClass().getSimpleName());
    }

    public void fillLogin(String username, String password) {
        log.info("Filling username");
        type(usernameInput, username);

        log.info("Filling password");
        type(passwordInput, password);

        log.info("Clicking on login button");
        click(loginButton);
    }

    public void verifyLockedMessageIsDisplayed() {
        log.info("Verifying locked message is displayed");
        Assert.assertTrue(verifyIsDisplayed(lockedMessage));
    }
}
