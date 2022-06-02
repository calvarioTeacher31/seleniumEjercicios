package org.example.base;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.example.utilities.CommonFlows;
import org.example.utilities.Commons;
import org.example.utilities.Logs;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    protected WebDriver driver;
    protected final Logs log = new Logs();
    protected static final String mainUrl = "https://www.saucedemo.com/";
    protected Commons commons;
    protected CommonFlows commonFlows;

    @BeforeMethod
    protected void setUpBase() {
        log.debug("Seteando el driver de chrome");
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        log.debug("Maximizando la ventana");
        driver.manage().window().maximize();

        log.debug("Borrando las cookies");
        driver.manage().deleteAllCookies();

        log.info("Ir al index");
        driver.get(mainUrl);

        commons = new Commons();
        commonFlows = new CommonFlows(driver);
        commons.waitPageToLoad(2);
    }

    @AfterMethod
    protected void tearDownBase() {
        log.debug("Matando al driver");
        driver.quit();
    }
}
