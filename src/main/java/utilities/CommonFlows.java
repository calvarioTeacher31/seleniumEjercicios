package org.example.utilities;

import org.example.pageobjects.checkout.CartPage;
import org.example.pageobjects.checkout.StepOnePage;
import org.example.pageobjects.checkout.StepTwoPage;
import org.example.pageobjects.credentials.LoginPage;
import org.example.pageobjects.shopping.HomeShoppingPage;
import org.openqa.selenium.WebDriver;

public class CommonFlows {
    private final Logs log = new Logs();
    private final WebDriver driver;

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void goToIndex() {
        var loginPage = new LoginPage(driver);

        loginPage.goToIndex();
        loginPage.waitPageToLoad();
    }

    public void loginValidUser() {
        var validCredentials = new DataProviders().getValidCredentials();
        var loginPage = new LoginPage(driver);
        var homeShoppingPage = new HomeShoppingPage(driver);

        loginPage.fillLogin(validCredentials.getUsername(), validCredentials.getPassword());
        homeShoppingPage.waitPageToLoad();
    }

    public void goToCart() {
        var homeShoppingPage = new HomeShoppingPage(driver);
        var cartPage = new CartPage(driver);

        loginValidUser();
        homeShoppingPage.addAllItemsToCart();
        homeShoppingPage.clickOnShoppingCart();
        cartPage.waitPageToLoad();
    }

    public void goToStepOne() {
        var cartPage = new CartPage(driver);
        var stepOnePage = new StepOnePage(driver);

        goToCart();
        cartPage.clickOnCheckout();
        stepOnePage.waitPageToLoad();
    }

    public void goToStepTwo() {
        var userData = new DataProviders().getUserData();
        var stepOnePage = new StepOnePage(driver);
        var stepTwoPage = new StepTwoPage(driver);

        goToStepOne();
        stepOnePage.fillForm(userData.getFirstname(), userData.getLastName(), userData.getZipcode());
        stepTwoPage.waitPageToLoad();
    }
}
