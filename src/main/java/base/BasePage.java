package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.Logs;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected Logs log = new Logs();
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;
    protected int timeout;
    private final String mainUrl = "https://www.saucedemo.com/";

    public BasePage(WebDriver driver) {
        this(driver, 5);
    }

    public BasePage(WebDriver driver, int timeout) {
        this.driver = driver;
        this.timeout = timeout;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(this.timeout));
        softAssert = new SoftAssert();
    }

    private WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    private Select getSelect(By locator) {
        return new Select(findElement(locator));
    }

    protected List<WebElement> getElementList(By locator) {
        return driver.findElements(locator);
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void type(By locator, String text) {
        findElement(locator).sendKeys(text);
    }

    protected void waitVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitPage(By locator, String className) {
        var message = String.format("Wait %s page to load for %d seconds", className, timeout);
        log.info(message);

        waitVisibility(locator);

        message = String.format("%s page loaded successfully", className);
        log.info(message);
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }

    protected String getHref(By locator) {
        return findElement(locator).getAttribute("href");
    }

    protected boolean verifyIsDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    protected boolean verifyIsEnabled(By locator) {
        return findElement(locator).isEnabled();
    }

    protected void selectByValue(String value, By locator) {
        var select = getSelect(locator);
        select.selectByValue(value);
    }

    public void goToIndex() {
        log.info("Going to the index page");
        driver.get(mainUrl);
    }

    public abstract void waitPageToLoad();

    public abstract void verifyPage();
}
