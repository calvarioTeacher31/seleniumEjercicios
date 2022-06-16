package org.example.base;

import org.example.utilities.CommonFlows;
import org.example.utilities.DriverManager;
import org.example.utilities.Logs;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners{}

public abstract class BaseTest {
    protected WebDriver driver;
    protected final Logs log = new Logs();
    protected CommonFlows commonFlows;
    protected final String regression = "Regression";
    protected final String smoke = "Smoke";

    @BeforeMethod(alwaysRun = true)
    protected void setUpBase() {
        driver = new DriverManager().initLocalDriver();

        log.debug("Maximizando la ventana");
        driver.manage().window().maximize();

        log.debug("Borrando las cookies");
        driver.manage().deleteAllCookies();

        initPages();

        commonFlows = new CommonFlows(driver);
        commonFlows.goToIndex();
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDownBase() {
        log.debug("Matando al driver");
        driver.quit();
        log.info("");
    }

    protected abstract void initPages();
}
