package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utilities.CommonFlows;
import utilities.DriverManager;
import utilities.Logs;

@Listeners({utilities.listeners.TestListeners.class, utilities.listeners.SuiteListeners.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected final Logs log = new Logs();
    protected CommonFlows commonFlows;
    protected final String regression = "Regression";
    protected final String smoke = "Smoke";

    @BeforeMethod(alwaysRun = true)
    protected void setUpBase() {
        driver = new DriverManager().initLocalDriver();

        log.debug("Maximizing the window");
        driver.manage().window().maximize();

        log.debug("Deleting all cookies");
        driver.manage().deleteAllCookies();

        initPages();

        commonFlows = new CommonFlows(driver);
        commonFlows.goToIndex();
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDownBase() {
        log.debug("Killing the driver");
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected abstract void initPages();
}
