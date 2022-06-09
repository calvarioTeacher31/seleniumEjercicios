package shopping;

import org.example.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingTests extends BaseTest {
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test(groups = {regression, smoke})
    public void productsListTest() {
        var addToCartButtonsLocator = By.className("btn_inventory");
        var addToCartButtonsList = driver.findElements(addToCartButtonsLocator);

        log.info("Haciendo click en add to cart");
        for (var addToCarButton : addToCartButtonsList) {
            addToCarButton.click();
        }

        var shoppingCartBadgeLocator = By.className("shopping_cart_badge");
        var shoppingCartBadge = driver.findElement(shoppingCartBadgeLocator);

        var cartCounter = Integer.parseInt(shoppingCartBadge.getText());

        log.info("Verificando la cantidad de productos");
        Assert.assertEquals(cartCounter, addToCartButtonsList.size());
    }

    @Test(groups = {smoke}, enabled = false)
    public void staleElementTest() {
        var robotImageLocator = By.className("peek");
        var shoppingCartLocator = By.className("shopping_cart_link");

        log.info("Verificando robot image is displayed");
        var robotImage = driver.findElement(robotImageLocator);

        Assert.assertTrue(robotImage.isDisplayed());

        log.info("Click en checkout");
        var shoppingCart = driver.findElement(shoppingCartLocator);
        shoppingCart.click();

        var checkoutButtonLocator = By.id("checkout");
        commons.waitPageToLoad(checkoutButtonLocator, driver, 5, "Cart Page");

        log.info("Click en continue");
        var continueButtonLocator = By.id("continue-shopping");
        var continueButton = driver.findElement(continueButtonLocator);
        continueButton.click();

        var productsLabelLocator = By.xpath("//span[text()='Products']");
        commons.waitPageToLoad(productsLabelLocator, driver, 5, "Home Shopping page");

        robotImage = driver.findElement(robotImageLocator);
        log.info("Verificando que el robot image is displayed");
        Assert.assertTrue(robotImage.isDisplayed());
    }

    @Test(groups = {regression})
    public void selectPriceTest() {
        var selectLocator = By.className("product_sort_container");
        var selectWebElement = driver.findElement(selectLocator);

        log.info("Selecting price hi to low");
        var select = new Select(selectWebElement);
        select.selectByValue("hilo");

        var priceListLocator = By.className("inventory_item_price");
        //var priceList = driver.findElements(priceListLocator);
        var firstPrice = driver.findElement(priceListLocator);

        log.info("Verifying first price list is $49.99");
        Assert.assertEquals(firstPrice.getText(), "$49.99");
    }

    @Test(groups = {regression})
    public void selectNameTest() {
        var selectLocator = By.className("product_sort_container");
        var selectWebElement = driver.findElement(selectLocator);

        log.info("Selecting name Z to A");
        var select = new Select(selectWebElement);
        select.selectByValue("za");

        var nameLocator = By.className("inventory_item_name");
        var firstName = driver.findElement(nameLocator);

        log.info("Verifying first name is Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(firstName.getText(), "Test.allTheThings() T-Shirt (Red)");
    }
}
