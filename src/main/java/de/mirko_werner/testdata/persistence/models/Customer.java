package de.mirko_werner.testdata.persistence.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Customer {

    private final long id;
    private final String gender;
    private final String firstName;
    private final String lastName;
    private final String birthDate;
    private final String birthPlace;
    private final String deathDate;
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

    public Customer(long id, String gender, String firstName, String lastName, String birthDate, String birthPlace,
                    String deathDate, String deathPlace, String phoneNumber, String mobilePhoneNumber,
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
