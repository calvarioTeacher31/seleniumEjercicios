package org.example.pageobjects.checkout;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By checkoutButton = By.id("checkout");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(checkoutButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying cart page UI elements");

        log.info("Verifying checkout button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(checkoutButton), "checkout button is not displayed");

        softAssert.assertAll();
    }

    public void clickOnCheckout() {
        log.info("Clicking on checkout");
        click(checkoutButton);
    }
}
