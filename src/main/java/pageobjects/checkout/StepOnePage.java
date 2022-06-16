package pageobjects.checkout;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepOnePage extends BasePage {
    private final By continueButton = By.id("continue");
    private final By firstnameInput = By.id("first-name");
    private final By lastnameInput = By.id("last-name");
    private final By zipcodeInput = By.id("postal-code");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    public StepOnePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(continueButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying step one page UI elements");

        log.info("Verifying firstname button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(firstnameInput), "firstname input is not displayed");

        log.info("Verifying lastname button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(lastnameInput), "lastname input is not displayed");

        log.info("Verifying zipcode button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(zipcodeInput), "zipcode input is not displayed");

        log.info("Verifying continue button is displayed");
        softAssert.assertTrue(verifyIsDisplayed(continueButton), "continue button is not displayed");
    }

    public void fillForm(String firstname, String lastname, String zipcode) {
        log.info("Filling firstname input");
        type(firstnameInput, firstname);

        log.info("Filling lastname input");
        type(lastnameInput, lastname);

        log.info("Filling zipcode input");
        type(zipcodeInput, zipcode);

        log.info("Clicking on continue");
        click(continueButton);
    }

    public void verifyErrorMessageText(String text) {
        log.info("Verifying error message is displayed");
        Assert.assertTrue(verifyIsDisplayed(errorMessage));

        log.info("Verifying error message content");
        Assert.assertEquals(getText(errorMessage), text);
    }
}
