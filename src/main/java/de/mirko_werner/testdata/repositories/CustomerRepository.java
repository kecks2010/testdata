package de.mirko_werner.testdata.repositories;

import de.mirko_werner.testdata.persistence.enums.CustomerCsvHeader;
import de.mirko_werner.testdata.persistence.mappers.CustomerCsvMapper;
import de.mirko_werner.testdata.persistence.models.Customer;

import java.util.List;

import static de.mirko_werner.testdata.config.FilePaths.PATH_TO_CUSTOMER_CSV;

/**
 * @author Mirko Werner
 * A repository with a list of customer objects where you can search for
 * a specific customer or a customer with specific characteristics.
 */
public class CustomerRepository extends AbstractCsvRepository {

    private static CustomerRepository customerRepository;
    private final List<Customer> customerList;

    private CustomerRepository() {
        customerList = readCsvEntriesAndConvert(PATH_TO_CUSTOMER_CSV, CustomerCsvHeader.class, CustomerCsvMapper.getInstance());

        for (Customer customer : customerList) {
            customer.setAddressList(AddressRepository.getInstance().getAddressListForCustomerId(customer.getId()));
            customer.setPaymentList(PaymentRepository.getInstance().getPaymentListForCustomerId(customer.getId()));
            customer.setLoginList(LoginRepository.getInstance().getLoginListForCustomerId(customer.getId()));
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
        if (firstName == null || lastName == null) {throw new NullPointerException("firstName and lastName cannot be null");}
        return customerList.stream()
                .filter(customer -> customer.getFirstName().equals(firstName))
                .filter(customer -> customer.getLastName().equals(lastName)).findFirst()
                .orElse(null);
    }
}
