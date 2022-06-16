package shopping;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.shopping.HomeShoppingPage;

public class ShoppingTests extends BaseTest {
    private HomeShoppingPage homeShoppingPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test(groups = {smoke})
    public void verifyHomeShoppingPageTest() {
        homeShoppingPage.verifyPage();
    }

    @Test(groups = {regression, smoke})
    public void productsListTest() {
        var tam = homeShoppingPage.addAllItemsToCart();
        homeShoppingPage.verifyItemCount(tam);
    }

    @Test(groups = {regression})
    public void selectPriceTest() {
        homeShoppingPage.selectOption("hilo");
        homeShoppingPage.verifyItemPrice(0, "$49.99");
    }

    @Test(groups = {regression})
    public void selectNameTest() {
        homeShoppingPage.selectOption("za");
        homeShoppingPage.verifyItemName(0, "Test.allTheThings() T-Shirt (Red)");
    }

    @Override
    protected void initPages() {
        homeShoppingPage = new HomeShoppingPage(driver);
    }
}
