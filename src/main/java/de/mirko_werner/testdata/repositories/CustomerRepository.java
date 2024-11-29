package de.mirko_werner.testdata.repositories;

import de.mirko_werner.testdata.persistence.enums.CustomerCsvHeader;
import de.mirko_werner.testdata.persistence.enums.PaymentCsvHeader;
import de.mirko_werner.testdata.persistence.mappers.CustomerCsvMapper;
import de.mirko_werner.testdata.persistence.mappers.PaymentCsvMapper;
import de.mirko_werner.testdata.persistence.models.Customer;
import de.mirko_werner.testdata.persistence.models.Payment;

import java.util.List;

import static de.mirko_werner.testdata.config.FilePaths.PATH_TO_CUSTOMER_CSV;

public class CustomerRepository extends AbstractCsvRepository {

    private static CustomerRepository customerRepository;
    private final LoginRepository loginRepository = LoginRepository.getInstance();
    private final PaymentRepository paymentRepository = PaymentRepository.getInstance();
    private final AddressRepository addressRepository = AddressRepository.getInstance();
    private final List<Customer> customerList;

    private CustomerRepository() {
        customerList = readCsvEntriesAndConvert(PATH_TO_CUSTOMER_CSV, CustomerCsvHeader.class, CustomerCsvMapper.getInstance());

        for (Customer customer : customerList) {
            customer.setAddressList(addressRepository.getAddressListForCustomerId(customer.getId()));
            customer.setPaymentList(paymentRepository.getPaymentListForCustomerId(customer.getId()));
            customer.setLoginList(loginRepository.getLoginListForCustomerId(customer.getId()));
        }
    }

    public static CustomerRepository getInstance() {
        if (customerRepository == null) {
            customerRepository = new CustomerRepository();
        }
        return customerRepository;
    }

    public Customer getCustomer(int id) {
        return customerList.stream()
                .filter(customer -> customer.getId() == id).findFirst()
                .orElse(null);
    }

    public Customer getCustomer(String firstName, String lastName) {
        return customerList.stream()
                .filter(customer -> customer.getFirstName().equals(firstName))
                .filter(customer -> customer.getLastName().equals(lastName)).findFirst()
                .orElse(null);
    }
}
