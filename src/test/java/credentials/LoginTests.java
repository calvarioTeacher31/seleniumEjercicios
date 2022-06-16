package credentials;

import base.BaseTest;
import org.testng.annotations.Test;
import pageobjects.credentials.LoginPage;
import utilities.DataProviders;

public class LoginTests extends BaseTest {
    private LoginPage loginPage;

    @Test(groups = {smoke})
    public void verifyLoginPageTest() {
        loginPage.verifyPage();
    }

    @Test(groups = {regression})
    public void lockedCredentialsTest() {
        var credentials = new DataProviders().getLockedCredentials();

        loginPage.fillLogin(credentials.getUsername(), credentials.getPassword());
        loginPage.verifyLockedMessageIsDisplayed();
    }

    @Override
    protected void initPages() {
        loginPage = new LoginPage(driver);
    }
}
