package de.mirko_werner.testdata.service.idcard;

import de.mirko_werner.testdata.model.idcard.IdCard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IdCardValidator {

    private static IdCardValidator idCardValidator;
    private final IdCardGenerator idCardGenerator;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");

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
        switch (idCard.getType()) {
            case OLD_IDENTITY_CARD, NEW_IDENTITY_CARD_WITHOUT_VERSION -> {
                return checkIdCardWithoutVersion(idCard);
            }
            case NEW_IDENTITY_CARD_WITH_VERSION, PASSPORT, CHILDREN_PASSPORT, TEMPORARY_PASSPORT -> {
                return checkIdCardWithVersion(idCard);
            }
            default -> throw new IllegalArgumentException("IdCard type " + idCard.getType() + " not supported yet");
        }
    }

    public boolean isSerialnumberValid(String documentnumber, IdCard.IdCardType idCardType) {
        System.out.println(idCardType);
        System.out.println(documentnumber);
        System.out.println(documentnumber.length() == 10);
        System.out.println(this.notContainsIllegalCharcaters(documentnumber, idCardType));
        System.out.println(this.checkFirstDigit(documentnumber, idCardType));

        boolean valid = this.idCardGenerator.generateCheckDigit(documentnumber.substring(0, documentnumber.length()-1))
                .contains(documentnumber.substring(documentnumber.length()-1));

        System.out.println(valid);
        if (valid && (idCardType == IdCard.IdCardType.TEMPORARY_PASSPORT ||
                idCardType == IdCard.IdCardType.CHILDREN_PASSPORT)) {
            valid = documentnumber.length() == 8 && documentnumber.substring(1).matches("[0-9]+");

        }
        if (valid && (idCardType == IdCard.IdCardType.OLD_IDENTITY_CARD || idCardType == IdCard.IdCardType.PASSPORT ||
                idCardType == IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION ||
                idCardType == IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION)) {
            valid = documentnumber.length() == 10 &&
                    this.notContainsIllegalCharcaters(documentnumber, idCardType) &&
                    this.checkFirstDigit(documentnumber, idCardType);
        }
        return valid;
    }

    public boolean checkBirthday(String birthdayWithCheckdigit) {
        if (birthdayWithCheckdigit.length() != 7) return false;
        String birthdayWithoutCheckdigit = birthdayWithCheckdigit.substring(0, birthdayWithCheckdigit.length()-1);
        LocalDate birthDate = LocalDate.parse(birthdayWithoutCheckdigit, formatter);

        return birthDate.isBefore(LocalDate.now().minusYears(16)) &&
                idCardGenerator.generateCheckDigit(birthdayWithoutCheckdigit)
                        .contains(birthdayWithCheckdigit.substring(birthdayWithCheckdigit.length()-1));
    }

    public boolean expirationDate(String expirationDateWithCheckdigit) {
        if (expirationDateWithCheckdigit.length() != 7) return false;
        String expirationDateWithoutCheckdigit = expirationDateWithCheckdigit
                .substring(0, expirationDateWithCheckdigit.length()-1);
        LocalDate expirationDate = LocalDate.parse(expirationDateWithoutCheckdigit, formatter);

        return expirationDate.isBefore(LocalDate.now()) &&
                idCardGenerator.generateCheckDigit(expirationDateWithoutCheckdigit)
                        .contains(expirationDateWithCheckdigit.substring(1));
    }

    private boolean notContainsIllegalCharcaters(String documentnumber, IdCard.IdCardType idCardType) {
        if (idCardType == IdCard.IdCardType.OLD_IDENTITY_CARD) {
            return documentnumber.matches("[0-9]+");
        } else {
            return !documentnumber.substring(1).matches("[AEIOUBDQS]+");
        }
    }

    private boolean checkFirstDigit(String documentnumber, IdCard.IdCardType idCardType) {
        if (idCardType == IdCard.IdCardType.OLD_IDENTITY_CARD) return Character.isDigit(documentnumber.charAt(0));
        if (idCardType == IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION ||
                idCardType == IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION) {
            return Character.toString(documentnumber.charAt(0)).matches("[LMNPRTVWXY]");
        }
        if (idCardType == IdCard.IdCardType.CHILDREN_PASSPORT) {
            return Character.toString(documentnumber.charAt(0)).matches("[EFG]");
        }
        if (idCardType == IdCard.IdCardType.TEMPORARY_PASSPORT) {
            return Character.toString(documentnumber.charAt(0)).matches("[AB]");
        }
        if (idCardType == IdCard.IdCardType.PASSPORT) {
            return Character.toString(documentnumber.charAt(0)).matches("[CFGHJK]");
        }
        return false;
    }

    private boolean checkIdCardWithoutVersion(IdCard idCard) {
        return this.idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() + idCard.getBirthDate() +
                        idCard.getExpiryDate()).contains(idCard.getCheckDigit());
    }

    private boolean checkIdCardWithVersion(IdCard idCard) {
        return this.idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() + idCard.getBirthDate() +
                idCard.getExpiryDate() + idCard.getVersion()).contains(idCard.getCheckDigit());
    }
}
