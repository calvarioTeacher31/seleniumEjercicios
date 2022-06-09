package org.example.utilities;

import org.example.models.CredentialsModel;
import org.example.models.UserDataModel;
import org.testng.annotations.DataProvider;

public class DataProviders {
    private final Logs log = new Logs();
    public static final String BAD_PERSONAL_INFO_DP = "Bad Personal Info Data Provider";

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

    @DataProvider(name = BAD_PERSONAL_INFO_DP)
    public Object[][] badCredentialsDataProvider() {
        var userData = new UserDataModel();
        var errorMessageMap = new MapParser().getErrorMessageMap();

        var firstname = userData.getFirstname();
        var lastname = userData.getLastName();
        var zipcode = userData.getZipcode();
        var blank = "";

        var missingFirstname = errorMessageMap.get("missingFirstname").getErrorMessage();
        var missingLastname = errorMessageMap.get("missingLastname").getErrorMessage();
        var missingZipcode = errorMessageMap.get("missingZipcode").getErrorMessage();

        return new Object[][]{
                {blank, lastname, zipcode, missingFirstname},
                {firstname, blank, zipcode, missingLastname},
                {firstname, lastname, blank, missingZipcode},
        };
    }
}
