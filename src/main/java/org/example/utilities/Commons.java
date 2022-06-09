package org.example.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Commons {
    private final Logs log = new Logs();

    public void waitPageToLoad(By locator, WebDriver driver, int timeOut, String nombre) {
        var mensaje = String.format("Esperando que cargue %s por %d segundos", nombre, timeOut);
        log.info(mensaje);
        
        var wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
