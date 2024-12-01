package de.mirko_werner.testdata.persistence.mappers;

import de.mirko_werner.testdata.persistence.enums.CustomerCsvHeader;
import de.mirko_werner.testdata.persistence.models.Customer;
import org.apache.commons.csv.CSVRecord;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Mirko Werner
 *
 * Mapping from csv-entry into customer object.
 */
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
                convertDateAsStringToDate(record.get(CustomerCsvHeader.birthDate)),
                record.get(CustomerCsvHeader.birthPlace),
                convertDateAsStringToDate(record.get(CustomerCsvHeader.deathDate)),
                record.get(CustomerCsvHeader.deathPlace),
                record.get(CustomerCsvHeader.phoneNumber),
                record.get(CustomerCsvHeader.mobilePhoneNumber),
                record.get(CustomerCsvHeader.emailAddress)
        );
    }

    private Date convertDateAsStringToDate(String dateAsString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = simpleDateFormat.parse(dateAsString);
        } catch (ParseException e) {
            date = null;
        }

        return date;
    }


}
