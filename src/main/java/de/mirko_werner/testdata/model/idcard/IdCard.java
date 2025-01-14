package de.mirko_werner.testdata.model.idcard;

import lombok.Getter;

/**
 * @author Mirko Werner
 * A class for IdCard objects like identity card or passport.
 *
 * IMPORTANT: Actual only german identity cards or passports are supported.
 */
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
        M,
        F,
        X,
        NOT_SPECIFIED
    }

    public IdCard(String documentnumber, String birthDate, String expiryDate, String checkDigit, IdCardType idCardType) {
        if (idCardType != IdCardType.OLD_IDENTITY_CARD && idCardType != IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION) {
            throw new IllegalArgumentException("IdCardType must be OLD_IDENTITY_CARD or NEW_IDENTITY_CARD_WITHOUT_VERSION");
        }
        this.documentnumber = documentnumber;
        this.birthDate = birthDate;
        this.gender = null;
        this.expiryDate = expiryDate;
        this.version = null;
        this.checkDigit = checkDigit;
        this.type = idCardType;
    }

    public IdCard(String documentnumber, String birthDate, Gender gender, String expiryDate, String checkDigit,
                  IdCardType idCardType) {
        if (idCardType != IdCardType.TEMPORARY_PASSPORT && idCardType != IdCardType.CHILDREN_PASSPORT) {
            throw new IllegalArgumentException("IdCardType must be TEMPORARY_PASSPORT or CHILDREN_PASSPORT");
        }
        this.documentnumber = documentnumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.expiryDate = expiryDate;
        this.version = null;
        this.checkDigit = checkDigit;
        this.type = idCardType;
    }

    public IdCard(String documentnumber, String birthDate, String expiryDate, String version, String checkDigit,
                  IdCardType idCardType) {
        if (idCardType != IdCardType.NEW_IDENTITY_CARD_WITH_VERSION) {
            throw new IllegalArgumentException("IdCardType must be NEW_IDENTITY_CARD_WITH_VERSION");
        }
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
        if (idCardType != IdCardType.PASSPORT && idCardType != IdCardType.CHILDREN_PASSPORT &&
                idCardType != IdCardType.TEMPORARY_PASSPORT) {
            throw new IllegalArgumentException("IdCardType must be PASSPORT_WITH_VERSION or CHILDREN_PASSPORT" +
                    "or TEMPORARY_PASSPORT");
        }
        this.documentnumber = documentnumber;
        this.birthDate = birthDate;
        this.gender = gender;
        this.expiryDate = expiryDate;
        this.version = version;
        this.checkDigit = checkDigit;
        this.type = idCardType;
    }

    public String toString() {
        switch (this.type) {
            case OLD_IDENTITY_CARD -> {
                return this.documentnumber + this.nationality + "<<" + this.birthDate + "<" + this.expiryDate +
                        "<<<<<<<" + this.checkDigit;
            }
            case NEW_IDENTITY_CARD_WITHOUT_VERSION -> {
                return "IDD<<" + this.documentnumber + "<<<<<<<<<<<<<<<\n" +
                        this.getBirthDate() + "<" + this.expiryDate + this.nationality + "<<<<<<<<<<<<<" +
                        this.checkDigit;
            }
            case NEW_IDENTITY_CARD_WITH_VERSION -> {
                return "IDD<<" + this.documentnumber + "<<<<<<<<<<<<<<<\n" +
                        this.getBirthDate() + "<" + this.expiryDate + this.nationality + "<<" + this.version +
                        "<<<<<<<" + this.checkDigit;
            }
            case PASSPORT -> {
                return this.documentnumber + this.nationality + "<<" + this.birthDate + this.gender + this.expiryDate +
                        this.version + this.checkDigit;
            }
            case TEMPORARY_PASSPORT, CHILDREN_PASSPORT -> {
                return this.documentnumber + this.nationality + "<<" + this.birthDate + this.gender + this.expiryDate +
                        "<<<<<<<<<<<<<<<" + this.checkDigit;
            }
            default -> throw new IllegalStateException("Unexpected value: " + this.type);
        }
    }
}
