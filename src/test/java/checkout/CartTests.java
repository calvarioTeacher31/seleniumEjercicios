package checkout;

import org.example.base.BaseTest;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {
    @Test
    public void cartTest() {
        commonFlows.goToCart();
    }
}
