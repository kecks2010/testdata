package de.mirko_werner.testdata.persistence.mappers;

import de.mirko_werner.testdata.persistence.enums.AddressCsvHeader;
import de.mirko_werner.testdata.persistence.models.Address;
import org.apache.commons.csv.CSVRecord;

public class AddressCsvMapper implements ITestdataCsvMapper<Address> {

    private static AddressCsvMapper instance;

    private AddressCsvMapper() {}

    public static AddressCsvMapper getInstance() {
        if (instance == null) {
            instance = new AddressCsvMapper();
        }
        return instance;
    }

    @Override
    public Address map(CSVRecord record) {
        return new Address(
                Long.parseLong(record.get(AddressCsvHeader.id)),
                record.get(AddressCsvHeader.street),
                record.get(AddressCsvHeader.number),
                record.get(AddressCsvHeader.postalCode),
                record.get(AddressCsvHeader.city),
                record.get(AddressCsvHeader.state),
                record.get(AddressCsvHeader.country),
                record.get(AddressCsvHeader.addressType),
                Long.parseLong(record.get(AddressCsvHeader.customerId)));
    }
}
