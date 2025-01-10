package de.mirko_werner.testdata.persistence.mappers;

import de.mirko_werner.testdata.persistence.enums.AddressCsvHeader;
import de.mirko_werner.testdata.persistence.models.Address;
import de.mirko_werner.testdata.persistence.enums.Country;
import de.mirko_werner.testdata.persistence.enums.State;
import org.apache.commons.csv.CSVRecord;

/**
 * @author Mirko Werner
 *
 * Mapping from csv-entry into address object.
 */
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
                State.getStateByName(record.get(AddressCsvHeader.state)),
                Country.getCountryByName(record.get(AddressCsvHeader.country)),
                record.get(AddressCsvHeader.addressType),
                Long.parseLong(record.get(AddressCsvHeader.customerId)));
    }
}
