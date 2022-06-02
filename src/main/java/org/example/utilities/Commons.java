package org.example.utilities;

public class Commons {
    private final Logs log = new Logs();

    public void waitPageToLoad(int seconds) {
        var milliSeconds = seconds * 1000;
        try {
            var message = String.format("Esperando que cargue la página por: %d segundos", seconds);
            log.debug(message);
            Thread.sleep(milliSeconds);
        } catch (InterruptedException interruptedException) {
            log.debug(interruptedException.getLocalizedMessage());
        }
    }
}
