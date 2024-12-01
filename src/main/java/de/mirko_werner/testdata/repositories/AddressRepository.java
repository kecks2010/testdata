package de.mirko_werner.testdata.repositories;

import de.mirko_werner.testdata.persistence.enums.AddressCsvHeader;
import de.mirko_werner.testdata.persistence.mappers.AddressCsvMapper;
import de.mirko_werner.testdata.persistence.models.Address;

import java.util.List;

import static de.mirko_werner.testdata.config.FilePaths.*;

/**
 * @author Mirko Werner
 * A repository with a list of address objects where you can search for
 * a specific address onject or a list of address objects for a specific customer.
 */
public class AddressRepository extends AbstractCsvRepository {

    private static AddressRepository addressRepository;
    private final List<Address> addressList;

    private AddressRepository() {
        addressList = readCsvEntriesAndConvert(PATH_TO_ADDRESS_CSV, AddressCsvHeader.class, AddressCsvMapper.getInstance());
    }

    public static AddressRepository getInstance() {
        if (addressRepository == null) {
            addressRepository = new AddressRepository();
        }
        return addressRepository;
    }

    public Address getAddress(long id) {
        return addressList.stream().filter(address -> address.id() == id).findFirst()
                .orElse(null);
    }

    public List<Address> getAddressListForCustomerId(long customerId) {
        return addressList.stream()
                .filter(address -> address.customerId() == customerId).toList();
    }
}
