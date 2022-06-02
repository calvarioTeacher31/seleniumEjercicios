package org.example.utilities;

import org.example.models.CredentialsModel;

import java.util.HashMap;

public class MapParser {
    private final Logs log = new Logs();

    public HashMap<String, CredentialsModel> getCredentialsMap() {
        log.debug("Creando map de credenciales");
        var map = new HashMap<String, CredentialsModel>();
        var credentialsList = new ExcelReader().getCredentials();

        for (var credential : credentialsList) {
            map.put(credential.getKey(), credential);
        }

        return map;
    }
}
