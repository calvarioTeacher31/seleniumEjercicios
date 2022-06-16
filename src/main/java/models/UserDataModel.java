package models;

import com.github.javafaker.Faker;

public class UserDataModel {
    private final String firstname;
    private final String lastName;
    private final String zipcode;

    public UserDataModel() {
        var faker = new Faker();
        firstname = faker.name().firstName();
        lastName = faker.name().lastName();
        zipcode = faker.address().zipCode();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZipcode() {
        return zipcode;
    }
}
