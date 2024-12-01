package de.mirko_werner.testdata.persistence.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * @author Mirko Werner
 *
 * Class for Customer objects.
 */
@Getter
public final class Customer {

    private final long id;
    private final String gender;
    private final String firstName;
    private final String lastName;
    private final Date birthDate;
    private final String birthPlace;
    private final Date deathDate;
    private final String deathPlace;
    private final String phoneNumber;
    private final String mobileNumber;
    private final String emailAddress;
    @Setter
    private List<Address> addressList;
    @Setter
    private List<Payment> paymentList;
    @Setter
    private List<Login> loginList;

    /**
     * Constructor for Customer objects
     *
     * @param id of the customer entry
     * @param gender of the customer entry
     * @param firstName of the customer entry
     * @param lastName of the customer entry
     * @param birthDate of the customer entry
     * @param birthPlace of the customer entry
     * @param deathDate of the customer entry
     * @param deathPlace of the customer entry
     * @param phoneNumber of the customer entry
     * @param mobilePhoneNumber of the customer entry
     * @param emailAddress of the customer entry
     */
    public Customer(long id, String gender, String firstName, String lastName, Date birthDate, String birthPlace,
                    Date deathDate, String deathPlace, String phoneNumber, String mobilePhoneNumber,
                    String emailAddress) {
        this.id = id;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.deathDate = deathDate;
        this.deathPlace = deathPlace;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobilePhoneNumber;
        this.emailAddress = emailAddress;
    }
}
