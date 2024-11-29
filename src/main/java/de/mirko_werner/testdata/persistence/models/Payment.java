package de.mirko_werner.testdata.persistence.models;

public record Payment(long id, String accountOwner, String accoundId, String paymentProvider, String entireDatem,
                      String secureCode, String paymentType, long customerId) {
}
