package checkout;

import org.example.base.BaseTest;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    @Test(groups = {smoke})
    public void cartTest() {
        commonFlows.goToCart();
    }
}
