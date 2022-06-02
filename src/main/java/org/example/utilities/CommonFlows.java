package org.example.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonFlows {
    private final Logs log = new Logs();
    private final WebDriver driver;
    private final Commons commons = new Commons();

    public CommonFlows(WebDriver driver) {
        this.driver = driver;
    }

    public void loginValidUser() {
        var validCredentials = new DataProviders().getValidCredentials();

        var usernameInputLocator = By.id("user-name");
        var passwordInputLocator = By.id("password");
        var loginButtonLocator = By.id("login-button");

        var usernameInput = driver.findElement(usernameInputLocator);
        var passwordInput = driver.findElement(passwordInputLocator);
        var loginButton = driver.findElement(loginButtonLocator);

        log.info("Tipeando el username");
        usernameInput.sendKeys(validCredentials.getUsername());

        log.info("Tipeando el password");
        passwordInput.sendKeys(validCredentials.getPassword());

        log.info("Clickeando en el botón de login");
        loginButton.click();

        commons.waitPageToLoad(2);
    }

    public void goToCart() {
        loginValidUser();
        var addToCartButtonsLocator = By.className("btn_inventory");
        var addToCartButtonsList = driver.findElements(addToCartButtonsLocator);

        log.info("Clickeando en el primer add to cart button");
        addToCartButtonsList.get(0).click();

        var shoppingCartBadgeLocator = By.className("shopping_cart_badge");
        var shoppingCartBadge = driver.findElement(shoppingCartBadgeLocator);

        log.info("Clickeando en el botón de carrito");
        shoppingCartBadge.click();
        commons.waitPageToLoad(2);
    }

    public void goToStepOne() {
        goToCart();

        var checkoutButtonLocator = By.id("checkout");
        var checkoutButton = driver.findElement(checkoutButtonLocator);

        log.info("Clickeando en el botón de checkout");
        checkoutButton.click();
        commons.waitPageToLoad(2);
    }
}
