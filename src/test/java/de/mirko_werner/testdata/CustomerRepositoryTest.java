package de.mirko_werner.testdata;

import de.mirko_werner.testdata.persistence.models.Customer;
import de.mirko_werner.testdata.repositories.AddressRepository;
import de.mirko_werner.testdata.repositories.CustomerRepository;
import de.mirko_werner.testdata.repositories.LoginRepository;
import de.mirko_werner.testdata.repositories.PaymentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerRepositoryTest {

    CustomerRepository customerRepository = CustomerRepository.getInstance();
    AddressRepository addressRepository = AddressRepository.getInstance();
    PaymentRepository paymentRepository = PaymentRepository.getInstance();
    LoginRepository loginRepository = LoginRepository.getInstance();

    @DisplayName("Get customer for id")
    @Test
    public void getCustomerForId() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Customer customer = customerRepository.getCustomer(1);
        customer.setAddressList(addressRepository.getAddressListForCustomerId(1));
        customer.setPaymentList(paymentRepository.getPaymentListForCustomerId(1));
        customer.setLoginList(loginRepository.getLoginListForCustomerId(1));

        assertThat(customer,is(notNullValue()));
        assertThat(customer.getId(),is(1L));
        assertThat(customer.getGender(),is("male"));
        assertThat(customer.getFirstName(),is("Harry"));
        assertThat(customer.getLastName(),is("Potter"));
        assertThat(customer.getBirthDate(),is(simpleDateFormat.parse("1980-07-31")));
        assertThat(customer.getBirthPlace(),is("Godric's Hollow"));
        assertThat(customer.getDeathDate(),is(nullValue()));
        assertThat(customer.getDeathPlace(),is(""));
        assertThat(customer.getPhoneNumber(),is("+13225558531"));
        assertThat(customer.getMobileNumber(),is("+491731234567"));
        assertThat(customer.getEmailAddress(),is("harry.potter@mirko-werner.de"));
        assertThat(customer.getAddressList(),is(addressRepository.getAddressListForCustomerId(1)));
        assertThat(customer.getPaymentList(),is(paymentRepository.getPaymentListForCustomerId(1)));
        assertThat(customer.getLoginList(),is(loginRepository.getLoginListForCustomerId(1)));
    }

    @DisplayName("Get payment for not existing id")
    @Test
    public void getPaymentForIdNotExist() {

        assertThat(customerRepository.getCustomer(0),is(nullValue()));
    }

    @DisplayName("Get customer for firstname and lastname")
    @Test
    public void getCustomerForFirstNameAndLastName() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Customer customer = customerRepository.getCustomer("Harry", "Potter");

        assertThat(customer,is(notNullValue()));
        assertThat(customer.getId(),is(1L));
        assertThat(customer.getGender(),is("male"));
        assertThat(customer.getFirstName(),is("Harry"));
        assertThat(customer.getLastName(),is("Potter"));
        assertThat(customer.getBirthDate(),is(simpleDateFormat.parse("1980-07-31")));
        assertThat(customer.getBirthPlace(),is("Godric's Hollow"));
        assertThat(customer.getDeathDate(),is(nullValue()));
        assertThat(customer.getDeathPlace(),is(""));
        assertThat(customer.getPhoneNumber(),is("+13225558531"));
        assertThat(customer.getMobileNumber(),is("+491731234567"));
        assertThat(customer.getEmailAddress(),is("harry.potter@mirko-werner.de"));
        assertThat(customer.getAddressList(),is(addressRepository.getAddressListForCustomerId(1)));
        assertThat(customer.getPaymentList(),is(paymentRepository.getPaymentListForCustomerId(1)));
        assertThat(customer.getLoginList(),is(loginRepository.getLoginListForCustomerId(1)));
    }

    @DisplayName("Get customer for firstname as null and lastname")
    @Test
    public void getCustomerForFirstNameAsNullAndLastName() {
        Throwable exception = assertThrows(NullPointerException.class,
                () -> customerRepository.getCustomer(null, "Potter"));
        assertThat(exception.getMessage(), is("firstName and lastName cannot be null"));
    }

    @DisplayName("Get customer for firstname and lastname as null")
    @Test
    public void getCustomerForFirstNameAndLastNameAsNull() {
        Throwable exception = assertThrows(NullPointerException.class,
                () -> customerRepository.getCustomer("Harry", null));
        assertThat(exception.getMessage(), is("firstName and lastName cannot be null"));
    }
}
