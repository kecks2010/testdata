package de.mirko_werner.testdata;

import de.mirko_werner.testdata.persistence.models.Payment;
import de.mirko_werner.testdata.repositories.PaymentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PaymentRepositoryTest {

    PaymentRepository paymentRepository = PaymentRepository.getInstance();

    @DisplayName("Get payment for id")
    @Test
    public void getPaymentForId() {
        Payment payment = new Payment(1L,"Harry Potter","DE27100777770209299700",
                "INGDDEFF123","", "", "bank", 1L);

        assertThat(paymentRepository.getPayment(1),is(notNullValue()));
        assertThat(paymentRepository.getPayment(1),is(payment));
    }

    @DisplayName("Get payment for not existing id")
    @Test
    public void getPaymentForIdNotExist() {

        assertThat(paymentRepository.getPayment(0),is(nullValue()));
    }

    @DisplayName("Get paymentList for CustomerId")
    @Test
    public void getPaymentForCustomerId() {

        assertThat(paymentRepository.getPaymentListForCustomerId(1),is(notNullValue()));
        assertThat(paymentRepository.getPaymentListForCustomerId(1).size(),is(3));
    }
}
