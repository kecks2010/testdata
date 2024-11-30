package de.mirko_werner.testdata.persistence.models;

/**
 * @author Mirko Werner
 * Record for Payment objects.
 *
 * @param id of the payment entry
 * @param accountOwner of the payment entry
 * @param accountId of the payment entry
 * @param paymentProvider of the payment entry
 * @param entireDate of the payment entry
 * @param secureCode of the payment entry
 * @param paymentType of the payment entry
 * @param customerId Id of the customer, where the payment entry is linked to.
 */
public record Payment(long id, String accountOwner, String accountId, String paymentProvider, String entireDate,
                      String secureCode, String paymentType, long customerId) {
}
