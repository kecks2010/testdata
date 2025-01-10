package de.mirko_werner.testdata.model.idcard;

import lombok.Getter;

@Getter
public class IdCard {
    private final String nationality = "D";
    private final String documentnumber;
    private final String birthDate;
    private final Gender gender;
    private final String expiryDate;
    private final String version;
    private final String checkDigit;
    private final IdCardType type;

    public enum IdCardType {
        OLD_IDENTITY_CARD,
        NEW_IDENTITY_CARD_WITHOUT_VERSION,
        NEW_IDENTITY_CARD_WITH_VERSION,
        PASSPORT,
        TEMPORARY_PASSPORT,
        CHILDREN_PASSPORT
    }

    @Getter
    public enum Gender {
        MALE("M"),
        FEMALE("W"),
        DIVERS("X"),
        NOT_SPECIFIED("N");

        private final String abbreviation;

        Gender(String abbreviation) {
            this.abbreviation = abbreviation;
        }
    }

    public IdCard(String documentnumber, String birthDate, String expiryDate, String checkDigit, IdCardType idCardType) {
        this.documentnumber = documentnumber;
        this.birthDate = birthDate;
        this.gender = null;
        this.expiryDate = expiryDate;
        this.version = null;
        this.checkDigit = checkDigit;
        this.type = idCardType;
    }

    public IdCard(String documentnumber, String birthDate, String expiryDate, String version, String checkDigit,
                  IdCardType idCardType) {
        this.documentnumber = documentnumber;
        this.birthDate = birthDate;
        this.gender = null;
        this.expiryDate = expiryDate;
        this.version = version;
        this.checkDigit = checkDigit;
        this.type = idCardType;
    }

    public IdCard(String documentnumber, String birthDate, Gender gender, String expiryDate, String version,
                  String checkDigit, IdCardType idCardType) {
        this.documentnumber = documentnumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.expiryDate = expiryDate;
        this.version = version;
        this.checkDigit = checkDigit;
        this.type = idCardType;
    }
}
