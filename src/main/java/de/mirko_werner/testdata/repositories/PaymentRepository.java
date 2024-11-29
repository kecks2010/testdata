package de.mirko_werner.testdata.repositories;

import de.mirko_werner.testdata.persistence.enums.PaymentCsvHeader;
import de.mirko_werner.testdata.persistence.mappers.PaymentCsvMapper;
import de.mirko_werner.testdata.persistence.models.Payment;

import java.util.List;

import static de.mirko_werner.testdata.config.FilePaths.*;

public class PaymentRepository extends AbstractCsvRepository {

    private static PaymentRepository paymentRepository;
    private final List<Payment> paymentList;

    private PaymentRepository() {
        paymentList = readCsvEntriesAndConvert(PATH_TO_PAYMENT_CSV, PaymentCsvHeader.class, PaymentCsvMapper.getInstance());
    }

    public static PaymentRepository getInstance() {
        if (paymentRepository == null) {
            paymentRepository = new PaymentRepository();
        }
        return paymentRepository;
    }

    public Payment getPayment(long id) {
        return paymentList.stream()
                .filter(payment -> payment.id() == id).findFirst()
                .orElse(null);
    }

    public List<Payment> getPaymentListForCustomerId(long customerId) {
        return paymentList.stream()
                .filter(payment -> payment.customerId() == customerId).toList();
    }
}
