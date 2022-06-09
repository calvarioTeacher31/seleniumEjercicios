package checkout;

import org.example.base.BaseTest;
import org.example.utilities.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.example.utilities.DataProviders.BAD_PERSONAL_INFO_DP;

public class StepOneTests extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToStepOne();
    }

    @Test(groups = {regression, smoke})
    public void validDataUserTest() {
        var userData = new DataProviders().getUserData();

        var firstnameInputLocator = By.id("first-name");
        var lastnameInputLocator = By.id("last-name");
        var zipcodeInputLocator = By.id("postal-code");
        var continueButtonLocator = By.id("continue");

        var firstnameInput = driver.findElement(firstnameInputLocator);
        var lastnameInput = driver.findElement(lastnameInputLocator);
        var zipcodeInput = driver.findElement(zipcodeInputLocator);
        var continueButton = driver.findElement(continueButtonLocator);

        log.info("Tipeando firstname");
        firstnameInput.sendKeys(userData.getFirstname());

        log.info("Tipeando lastname");
        lastnameInput.sendKeys(userData.getLastName());

        log.info("Tipeando zipcode");
        zipcodeInput.sendKeys(userData.getZipcode());

        log.info("Clickeando en continue");
        continueButton.click();

        var finishButtonLocator = By.id("finish");

        commons.waitPageToLoad(finishButtonLocator, driver, 5, "Step Two Page");

        var cartListLocator = By.className("cart_list");
        var cartList = driver.findElement(cartListLocator);

        log.info("Verificando que el cartlist esté visible");
        Assert.assertTrue(cartList.isDisplayed());
    }

    @Test(groups = {regression}, dataProvider = BAD_PERSONAL_INFO_DP,
            dataProviderClass = DataProviders.class)
    public void errorMessageTest(String firstname, String lastname, String zipcode, String errorMessageText) {
        var firstnameInputLocator = By.id("first-name");
        var lastnameInputLocator = By.id("last-name");
        var zipcodeInputLocator = By.id("postal-code");
        var continueButtonLocator = By.id("continue");

        var firstnameInput = driver.findElement(firstnameInputLocator);
        var lastnameInput = driver.findElement(lastnameInputLocator);
        var zipcodeInput = driver.findElement(zipcodeInputLocator);
        var continueButton = driver.findElement(continueButtonLocator);

        log.info("Tipeando firstname");
        firstnameInput.sendKeys(firstname);

        log.info("Tipeando lastname");
        lastnameInput.sendKeys(lastname);

        log.info("Tipeando zipcode");
        zipcodeInput.sendKeys(zipcode);

        log.info("Clickeando en continue");
        continueButton.click();

        var errorMessageLocator = By.cssSelector("h3[data-test='error']");
        var errorMessage = driver.findElement(errorMessageLocator);

        Assert.assertEquals(errorMessage.getText(), errorMessageText);
    }
}
