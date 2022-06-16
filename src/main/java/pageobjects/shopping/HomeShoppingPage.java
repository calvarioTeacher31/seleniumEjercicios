package pageobjects.shopping;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomeShoppingPage extends BasePage {
    private final By addToCartButtons = By.className("btn_inventory");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");
    private final By robotImage = By.className("peek");
    private final By shoppingCart = By.className("shopping_cart_link");
    private final By productTitle = By.xpath("//span[text()='Products']");
    private final By priceList = By.className("inventory_item_price");
    private final By nameList = By.className("inventory_item_name");
    private final By select = By.className("product_sort_container");

    public HomeShoppingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        waitPage(productTitle, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        log.info("Verifying home shopping page UI elements");

        log.info("Verifying robot image is displayed");
        softAssert.assertTrue(verifyIsDisplayed(robotImage), "robot image is not displayed");

        log.info("Verifying shopping cart is displayed");
        softAssert.assertTrue(verifyIsDisplayed(shoppingCart), "shopping cart is not displayed");

        log.info("Verifying product title is displayed");
        softAssert.assertTrue(verifyIsDisplayed(productTitle), "product title is not displayed");

        log.info("Verifying select info is displayed");
        softAssert.assertTrue(verifyIsDisplayed(select), "select is not displayed");
        softAssert.assertAll();
    }

    public int addAllItemsToCart() {
        var addToCartButtonsList = getElementList(addToCartButtons);

        log.info("Clicking on add to cart");
        for (var addToCarButton : addToCartButtonsList) {
            log.info("Adding item to cart");
            addToCarButton.click();
        }

        return addToCartButtonsList.size();
    }

    public void verifyItemCount(int number) {
        var cartCounter = Integer.parseInt(getText(shoppingCartBadge));

        log.info("Verifying item count is correct");
        Assert.assertEquals(cartCounter, number);
    }

    public void selectOption(String value) {
        log.info("Selecting price hi to low");
        selectByValue(value, select);
    }

    public void verifyItemPrice(int index, String text) {
        log.info("Verifying item price");
        var priceListX = getElementList(priceList);
        Assert.assertEquals(priceListX.get(index).getText(), text);
    }

    public void verifyItemName(int index, String text) {
        log.info("Verifying item name");
        var nameListX = getElementList(nameList);
        Assert.assertEquals(nameListX.get(index).getText(), text);
    }

    public void clickOnShoppingCart() {
        log.info("Clicking on shopping cart");
        click(shoppingCart);
    }
}
