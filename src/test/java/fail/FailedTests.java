package fail;

import base.BaseTest;
import org.testng.annotations.Test;
import pageobjects.checkout.StepTwoPage;

public class FailedTests extends BaseTest {
    private StepTwoPage stepTwoPage;

    @Test
    public void failTest1() {
        commonFlows.loginValidUser();
        stepTwoPage.verifyPage();
    }

    @Test
    public void failTest2() {
        commonFlows.goToStepOne();
        stepTwoPage.verifyPage();
    }

    @Override
    protected void initPages() {
        stepTwoPage = new StepTwoPage(driver);
    }
}
