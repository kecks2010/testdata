package de.mirko_werner.testdata.persistence.models;

public record Address(long id, String street, String number, String postalCode, String city, String state,
                      String country, String addressType, long customerId) {

    public boolean isPrimaryAddress() {
        return addressType.equals("primary");
    }

    public boolean isSecondaryAddress() {
        return addressType.equals("secondary");
    }

    public boolean isPreAddress() {
        return addressType.equals("pre");
    }
}
