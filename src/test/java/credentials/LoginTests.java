package credentials;

import org.example.base.BaseTest;
import org.example.utilities.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void urlIndexTest() {
        var currentUrl = driver.getCurrentUrl();

        log.info("Verificando que ambas url sean iguales");
        Assert.assertEquals(mainUrl, currentUrl);
    }

    @Test
    public void urlNavigationTest() {
        var currentUrlInicio = driver.getCurrentUrl();

        log.info("Yendo a stackoverflow");
        driver.get("https://stackoverflow.com/");

        commons.waitPageToLoad(2);

        log.info("Presionado atrás en el browser");
        driver.navigate().back();

        commons.waitPageToLoad(2);

        var currentUrlFinal = driver.getCurrentUrl();

        log.info("Verificando que ambas url sean iguales");
        Assert.assertEquals(currentUrlInicio, currentUrlFinal);
    }

    @Test
    public void lockedCredentialsTest() {
        var dataProvider = new DataProviders();
        var credentials = dataProvider.getLockedCredentials();
        var lockedMessage = dataProvider.getLockedMessage();

        var usernameInputLocator = By.id("user-name");
        var passwordInputLocator = By.id("password");
        var loginButtonLocator = By.id("login-button");

        var usernameInput = driver.findElement(usernameInputLocator);
        var passwordInput = driver.findElement(passwordInputLocator);
        var loginButton = driver.findElement(loginButtonLocator);

        log.info("Tipeando el username");
        usernameInput.sendKeys(credentials.getUsername());

        log.info("Tipeando el password");
        passwordInput.sendKeys(credentials.getPassword());

        log.info("Clickeando en el botón de login");
        loginButton.click();

        var lockedMessageLabelLocator = By.tagName("h3");
        var lockedMessageLabel = driver.findElement(lockedMessageLabelLocator);

        log.info("Verificando que el texto de error sea el esperado");
        Assert.assertEquals(lockedMessageLabel.getText(), lockedMessage);
    }
}