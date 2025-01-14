package de.mirko_werner.testdata.persistence.models;

import de.mirko_werner.testdata.persistence.enums.Country;
import de.mirko_werner.testdata.persistence.enums.State;

/**
 * @author Mirko Werner
 * Record for Address objects.
 *
 * @param id of the address entry
 * @param street of the address entry
 * @param number of the address entry
 * @param postalCode of the address entry
 * @param city of the address entry
 * @param state of the address entry
 * @param country of the address entry
 * @param addressType of the address entry. Can be primary, secondary or pre.
 * @param customerId Id of the customer, where the address entry is linked to.
 */
public record Address(long id, String street, String number, String postalCode, String city, State state,
                      Country country, String addressType, long customerId) {

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
