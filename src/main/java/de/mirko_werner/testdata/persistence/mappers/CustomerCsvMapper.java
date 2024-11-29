package de.mirko_werner.testdata.persistence.mappers;

import de.mirko_werner.testdata.persistence.enums.CustomerCsvHeader;
import de.mirko_werner.testdata.persistence.models.Customer;
import org.apache.commons.csv.CSVRecord;

public class CustomerCsvMapper implements ITestdataCsvMapper<Customer> {

    private static CustomerCsvMapper instance;

    private CustomerCsvMapper() {}

    public static CustomerCsvMapper getInstance() {
        if (instance == null) {
            instance = new CustomerCsvMapper();
        }
        return instance;
    }

    @Override
    public Customer map(CSVRecord record) {
        return new Customer(
                Long.parseLong(record.get(CustomerCsvHeader.id)),
                record.get(CustomerCsvHeader.gender),
                record.get(CustomerCsvHeader.firstName),
                record.get(CustomerCsvHeader.lastName),
                record.get(CustomerCsvHeader.birthDate),
                record.get(CustomerCsvHeader.birthPlace),
                record.get(CustomerCsvHeader.deathDate),
                record.get(CustomerCsvHeader.deathPlace),
                record.get(CustomerCsvHeader.phoneNumber),
                record.get(CustomerCsvHeader.mobilePhoneNumber),
                record.get(CustomerCsvHeader.emailAddress)
        );
    }
}
