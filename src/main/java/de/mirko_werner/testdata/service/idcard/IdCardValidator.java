package de.mirko_werner.testdata.service.idcard;

import de.mirko_werner.testdata.model.idcard.IdCard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Mirko Werner
 * This class contains methods to validate an idCard object for several idCard types like
 * - Old Identity Card
 * - New Identity Card without Version
 * - New Identity Card with Version
 * - Passport
 * - Temporary Passport
 * - Children Passport
 * document number, birthdate and expirydate.
 *
 * IMPORTANT: Actual only german identity cards and passports are supported!
 */
public class IdCardValidator {

    private static IdCardValidator idCardValidator;
    private final IdCardGenerator idCardGenerator;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    private IdCardValidator() {
        this.idCardGenerator = IdCardGenerator.getInstance();
    }

    public static IdCardValidator getInstance() {
        if (idCardValidator == null) {
            idCardValidator = new IdCardValidator();
        }
        return idCardValidator;
    }

    public boolean isIdCardValid(IdCard idCard) {
        boolean valid = isSerialnumberValid(idCard.getDocumentnumber(), idCard.getType()) &&
                isBirthdayValid(idCard.getBirthDate()) && isExpirationDateValid(idCard.getExpiryDate());
        switch (idCard.getType()) {
            case OLD_IDENTITY_CARD, NEW_IDENTITY_CARD_WITHOUT_VERSION, CHILDREN_PASSPORT, TEMPORARY_PASSPORT -> {
                return valid && checkCheckDigitIdCardWithoutVersion(idCard);
            }
            case NEW_IDENTITY_CARD_WITH_VERSION, PASSPORT -> {
                return valid && checkCheckDigitIdCardWithVersion(idCard);
            }
            default -> throw new IllegalArgumentException("IdCard type " + idCard.getType() + " not supported");
        }
    }

    public boolean isSerialnumberValid(String documentnumber, IdCard.IdCardType idCardType) {
        return this.idCardGenerator.generateCheckDigit(documentnumber.substring(0, documentnumber.length()-1))
                .contains(documentnumber.substring(documentnumber.length()-1)) &&
                documentnumber.length() == 10 && this.notContainsIllegalCharcaters(documentnumber, idCardType) &&
                this.checkFirstDigit(documentnumber, idCardType);
    }

    public boolean isBirthdayValid(String birthday) {
        if (birthday.length() != 7) return false;
        String birthdayWithoutCheckdigit = birthday.substring(0, birthday.length()-1);
        if (Integer.parseInt(birthday.substring(0,2)) > LocalDate.now().getYear() % 100) {
            birthdayWithoutCheckdigit = 19 + birthdayWithoutCheckdigit;
        } else birthdayWithoutCheckdigit = 20 + birthdayWithoutCheckdigit;
        LocalDate birthDate = LocalDate.parse(birthdayWithoutCheckdigit, formatter);

        return birthDate.isBefore(LocalDate.now().minusYears(16).plusDays(1)) &&
                idCardGenerator.generateCheckDigit(birthday.substring(0, birthday.length()-1))
                        .contains(birthday.substring(birthday.length()-1));
    }

    public boolean isExpirationDateValid(String expirationDate) {
        if (expirationDate.length() != 7) return false;
        String expirationDateWithoutCheckdigit = expirationDate
                .substring(0, expirationDate.length()-1);
        expirationDateWithoutCheckdigit = 20 + expirationDateWithoutCheckdigit;
        LocalDate expirationDateLocaldate = LocalDate.parse(expirationDateWithoutCheckdigit, formatter);

        return expirationDateLocaldate.isAfter(LocalDate.now().minusDays(1)) &&
                idCardGenerator.generateCheckDigit(expirationDate.substring(0, expirationDate.length()-1))
                        .contains(expirationDate.substring(expirationDate.length()-1));
    }

    private boolean notContainsIllegalCharcaters(String documentnumber, IdCard.IdCardType idCardType) {
        switch (idCardType) {
            case OLD_IDENTITY_CARD, TEMPORARY_PASSPORT, CHILDREN_PASSPORT -> {
                return documentnumber.substring(2).matches("[0-9]+");
            }
            case NEW_IDENTITY_CARD_WITHOUT_VERSION, NEW_IDENTITY_CARD_WITH_VERSION, PASSPORT -> {
                return documentnumber.substring(1).matches("^[^AEIOUBDQS]+");
            }
            default -> throw new IllegalArgumentException("IdCard type " + idCardType + " not supported");
        }
    }

    private boolean checkFirstDigit(String documentnumber, IdCard.IdCardType idCardType) {
        switch (idCardType) {
            case OLD_IDENTITY_CARD -> {
                return Character.isDigit(documentnumber.charAt(0));
            }
            case NEW_IDENTITY_CARD_WITHOUT_VERSION, NEW_IDENTITY_CARD_WITH_VERSION -> {
                return Character.toString(documentnumber.charAt(0)).matches("[LMNPRTVWXY]");
            }
            case CHILDREN_PASSPORT -> {
                return Character.toString(documentnumber.charAt(0)).matches("[EFG]");
            }
            case TEMPORARY_PASSPORT -> {
                return Character.toString(documentnumber.charAt(0)).matches("[AB]");
            }
            case PASSPORT -> {
                return Character.toString(documentnumber.charAt(0)).matches("[CFGHJK]");
            }
            default -> throw new IllegalArgumentException("IdCard type " + idCardType + " not supported");
        }
    }

    private boolean checkCheckDigitIdCardWithoutVersion(IdCard idCard) {
        return this.idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() + idCard.getBirthDate() +
                        idCard.getExpiryDate()).contains(idCard.getCheckDigit());
    }

    private boolean checkCheckDigitIdCardWithVersion(IdCard idCard) {
        return this.idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() + idCard.getBirthDate() +
                idCard.getExpiryDate() + idCard.getVersion()).contains(idCard.getCheckDigit());
    }
}
