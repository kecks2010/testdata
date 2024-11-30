package de.mirko_werner.testdata.persistence.models;

/**
 * @author Mirko Werner
 * Record for Login objects.
 *
 * @param id of the login entry
 * @param username of the login entry
 * @param password of the login entry
 * @param twoFactorId of the login entry. Can be an email address or a mobile phone number.
 * @param twoFactorType of the login entry. Can be email or mobile.
 * @param customerId Id of the customer, where the login entry is linked to.
 */
public record Login(long id, String username, String password, String twoFactorId, String twoFactorType, long customerId) {
}
