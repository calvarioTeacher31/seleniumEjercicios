package checkout;

import org.example.base.BaseTest;
import org.example.utilities.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StepOneTests extends BaseTest {
    @BeforeMethod
    public void setUp() {
        commonFlows.goToStepOne();
    }

    @Test
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

        commons.waitPageToLoad(2);

        var cartListLocator = By.className("cart_list");
        var cartList = driver.findElement(cartListLocator);

        log.info("Verificando que el cartlist esté visible");
        Assert.assertTrue(cartList.isDisplayed());
    }
}
