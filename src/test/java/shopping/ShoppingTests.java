package shopping;

import org.example.base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingTests extends BaseTest {
    @BeforeMethod
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test
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
}
