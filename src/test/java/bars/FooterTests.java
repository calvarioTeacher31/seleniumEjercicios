package bars;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.bars.FooterPage;
import utilities.MapParser;

public class FooterTests extends BaseTest {
    private FooterPage footerPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.loginValidUser();
    }

    @Test
    public void verifySocialLinkTest() {
        footerPage.verifySocialMediaLinks(new MapParser().getUrlMap());
    }

    @Override
    protected void initPages() {
        footerPage = new FooterPage(driver);
    }
}
