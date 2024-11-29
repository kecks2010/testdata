package de.mirko_werner.testdata.persistence.mappers;

import de.mirko_werner.testdata.persistence.enums.PaymentCsvHeader;
import de.mirko_werner.testdata.persistence.models.Payment;
import org.apache.commons.csv.CSVRecord;

public class PaymentCsvMapper implements ITestdataCsvMapper<Payment> {

    private static PaymentCsvMapper instance = new PaymentCsvMapper();

    private PaymentCsvMapper() {}

    public static PaymentCsvMapper getInstance() {
        if (instance == null) {
            instance = new PaymentCsvMapper();
        }
        return instance;
    }

    @Override
    public Payment map(CSVRecord record) {
        return new Payment(
                Long.parseLong(record.get(PaymentCsvHeader.id)),
                record.get(PaymentCsvHeader.accountOwner),
                record.get(PaymentCsvHeader.accountId),
                record.get(PaymentCsvHeader.paymentProvider),
                record.get(PaymentCsvHeader.entireDate),
                record.get(PaymentCsvHeader.secureCode),
                record.get(PaymentCsvHeader.paymentType),
                Long.parseLong(record.get(PaymentCsvHeader.customerId))
        );
    }
}
