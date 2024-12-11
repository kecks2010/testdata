package de.mirko_werner.testdata;

import de.mirko_werner.testdata.persistence.models.Address;
import de.mirko_werner.testdata.persistence.models.Country;
import de.mirko_werner.testdata.repositories.AddressRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AddressRepositoriesTest {

    private final AddressRepository addressRepository = AddressRepository.getInstance();

    @DisplayName("Get address for existing id")
    @Test
    void testGetAddress() {
        Address address = new Address(1L, "Karolinenpl.", "5", "64289", "Darmstadt",
                "Hessen", Country.getCountryByName("Germany"), "primary", 1L);

        assertThat(addressRepository.getAddress(1), is(notNullValue()));
        assertThat(addressRepository.getAddress(1), is(address));
    }

    @DisplayName("Get address for not existing id")
    @Test
    void testGetAddressNotExist() {

        assertThat(addressRepository.getAddress(0), is(nullValue()));
    }

    @DisplayName("Get addressList for existing customerId")
    @Test
    void testGetAddressListForCustomerId() {

        assertThat(addressRepository.getAddressListForCustomerId(1), is(notNullValue()));
        assertThat(addressRepository.getAddressListForCustomerId(1).size(), is(3));
    }
}
