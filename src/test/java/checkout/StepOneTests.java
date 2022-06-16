package checkout;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.checkout.StepOnePage;
import pageobjects.checkout.StepTwoPage;
import utilities.DataProviders;

import static utilities.DataProviders.BAD_PERSONAL_INFO_DP;

public class StepOneTests extends BaseTest {
    private StepOnePage stepOnePage;
    private StepTwoPage stepTwoPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToStepOne();
    }

    @Test(groups = {smoke})
    public void verifyStepOnePage() {
        stepOnePage.verifyPage();
    }

    @Test(groups = {regression, smoke})
    public void validDataUserTest() {
        var userData = new DataProviders().getUserData();
        stepOnePage.fillForm(userData.getFirstname(), userData.getLastName(), userData.getZipcode());
        stepTwoPage.waitPageToLoad();
        stepTwoPage.verifyPage();
    }

    @Test(groups = {regression}, dataProvider = BAD_PERSONAL_INFO_DP,
            dataProviderClass = DataProviders.class)
    public void errorMessageTest(String firstname, String lastname, String zipcode, String errorMessageText) {
        stepOnePage.fillForm(firstname, lastname, zipcode);
        stepOnePage.verifyErrorMessageText(errorMessageText);
    }

    @Override
    protected void initPages() {
        stepOnePage = new StepOnePage(driver);
        stepTwoPage = new StepTwoPage(driver);
    }
}
