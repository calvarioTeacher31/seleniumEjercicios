package checkout;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.checkout.StepTwoPage;

public class StepTwoTests extends BaseTest {
    private StepTwoPage stepTwoPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToStepTwo();
    }

    @Test(groups = {smoke})
    public void verifyStepTwoPageTest() {
        stepTwoPage.verifyPage();
    }

    @Override
    protected void initPages() {
        stepTwoPage = new StepTwoPage(driver);
    }
}
