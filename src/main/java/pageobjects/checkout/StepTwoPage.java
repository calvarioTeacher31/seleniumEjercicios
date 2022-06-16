package org.example.pageobjects.checkout;

import org.example.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepTwoPage extends BasePage {
    private final By finishButton = By.id("finish");

    public StepTwoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(finishButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying step two page UI elements");

        log.info("Verifying finish button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(finishButton), "finish button is not displayed");
    }
}
