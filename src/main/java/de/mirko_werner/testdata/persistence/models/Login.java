package de.mirko_werner.testdata.persistence.models;

public record Login(long id, String username, String password, String twoFactorId, String twoFactorType, long customerId) {
}
