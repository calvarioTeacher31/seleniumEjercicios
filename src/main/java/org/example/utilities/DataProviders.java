package org.example.utilities;

import org.example.models.CredentialsModel;
import org.example.models.UserDataModel;

public class DataProviders {
    private final Logs log = new Logs();

    public CredentialsModel getValidCredentials() {
        log.debug("Cogiendo las credenciales válidas");
        var credentialsMap = new MapParser().getCredentialsMap();
        return credentialsMap.get("valid");
    }

    public CredentialsModel getLockedCredentials() {
        log.debug("Cogiendo las credenciales inválidas");
        var credentialsMap = new MapParser().getCredentialsMap();
        return credentialsMap.get("locked");
    }

    public String getLockedMessage() {
        return "Epic sadface: Sorry, this user has been locked out.";
    }

    public UserDataModel getUserData() {
        return new UserDataModel();
    }
}
