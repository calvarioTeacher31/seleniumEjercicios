package org.example.utilities;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
    private final Logs log = new Logs();
    private String browser;

    public WebDriver initLocalDriver() {
        if (browser == null) {
            log.debug("Setting chrome as default browser");
            browser = "CHROME";
        }

        switch (browser) {
            case "CHROME":
                ChromeDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "EDGE":
                EdgeDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                return null;
        }
    }
}
