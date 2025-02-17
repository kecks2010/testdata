package de.mirko_werner.testdata.service.idcard;

import de.mirko_werner.testdata.model.idcard.IdCard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Mirko Werner
 * This class contains methods to create an idCard object for several idCard types.
 * - Old Identity Card
 * - New Identity Card without Version
 * - New Identity Card with Version
 * - Passport
 * - Temporary Passport
 * - Children Passport
 *
 * If you want to get an ID card with a specific date of birth and/or a specific expiration date,
 * you must be sure that the date is valid. Normally you must be 16 years old to get an ID card
 * and the expiration date must not have passed. Otherwise, data checks may fail.
 *
 * For passports, you need a gender, but the gender has no effect of the generated data.
 *
 * IMPORTANT: Actual only german identity cards and passports are supported!
 */
public class IdCardGenerator {

    private static IdCardGenerator idCardGenerator;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMdd");
    private IdCard.IdCardType idCardType;

    private IdCardGenerator() {}

    public static IdCardGenerator getInstance() {
        if (idCardGenerator == null) {
            idCardGenerator = new IdCardGenerator();
        }
        return idCardGenerator;
    }

    public IdCard generateOldIdentityCard() {
        idCardType = IdCard.IdCardType.OLD_IDENTITY_CARD;
        return generateIdCard(IdCard.Gender.NOT_SPECIFIED);
    }

    public IdCard generateNewIdentityCardWithoutVersion() {
        idCardType = IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION;
        return generateIdCard(IdCard.Gender.NOT_SPECIFIED);
    }

    public IdCard generateNewIdentityCardWithVersion() {
        idCardType = IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION;
        return generateIdCard(IdCard.Gender.NOT_SPECIFIED);
    }

    public IdCard generatePassport(IdCard.Gender gender) {
        idCardType = IdCard.IdCardType.PASSPORT;
        return generateIdCard(gender);
    }

    public IdCard generateTemporaryPassport(IdCard.Gender gender) {
        idCardType = IdCard.IdCardType.TEMPORARY_PASSPORT;
        return generateIdCard(gender);
    }

    public IdCard generateChildrenPassport(IdCard.Gender gender) {
        idCardType = IdCard.IdCardType.CHILDREN_PASSPORT;
        return generateIdCard(gender);
    }

    private IdCard generateIdCard(IdCard.Gender gender) {
        return generateIdCard(getBirthdayAge(), LocalDate.now().plusYears(10), gender);
    }

    public IdCard generateOldIdentityCard(LocalDate birthday) {
        idCardType = IdCard.IdCardType.OLD_IDENTITY_CARD;
        return generateIdCard(birthday, IdCard.Gender.NOT_SPECIFIED);
    }

    public IdCard generateNewIdentityCardWithoutVersion(LocalDate birthday) {
        idCardType = IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION;
        return generateIdCard(birthday, IdCard.Gender.NOT_SPECIFIED);
    }

    public IdCard generateNewIdentityCardWithVersion(LocalDate birthday) {
        idCardType = IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION;
        return generateIdCard(birthday, IdCard.Gender.NOT_SPECIFIED);
    }

    public IdCard generatePassport(LocalDate birthday, IdCard.Gender gender) {
        idCardType = IdCard.IdCardType.PASSPORT;
        return generateIdCard(birthday, gender);
    }

    public IdCard generateTemporaryPassport(LocalDate birthday, IdCard.Gender gender) {
        idCardType = IdCard.IdCardType.TEMPORARY_PASSPORT;
        return generateIdCard(birthday, gender);
    }

    public IdCard generateChildrenPassport(LocalDate birthday, IdCard.Gender gender) {
        idCardType = IdCard.IdCardType.CHILDREN_PASSPORT;
        return generateIdCard(birthday, gender);
    }

    private IdCard generateIdCard(LocalDate birthday, IdCard.Gender gender) {
        return generateIdCard(birthday, LocalDate.now().plusYears(10), gender);
    }

    public IdCard generateOldIdentityCard(LocalDate birthday, LocalDate expirationDate) {
        idCardType = IdCard.IdCardType.OLD_IDENTITY_CARD;
        return generateIdCard(birthday, expirationDate, IdCard.Gender.NOT_SPECIFIED);
    }

    public IdCard generateNewIdentityCardWithoutVersion(LocalDate birthday, LocalDate expirationDate) {
        idCardType = IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION;
        return generateIdCard(birthday, expirationDate, IdCard.Gender.NOT_SPECIFIED);
    }

    public IdCard generateNewIdentityCardWithVersion(LocalDate birthday, LocalDate expirationDate) {
        idCardType = IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION;
        return generateIdCard(birthday,expirationDate, IdCard.Gender.NOT_SPECIFIED);
    }

    public IdCard generatePassport(LocalDate birthday, LocalDate expirationDate, IdCard.Gender gender) {
        idCardType = IdCard.IdCardType.PASSPORT;
        return generateIdCard(birthday, expirationDate, gender);
    }

    public IdCard generateTemporaryPassport(LocalDate birthday, LocalDate expirationDate, IdCard.Gender gender) {
        idCardType = IdCard.IdCardType.TEMPORARY_PASSPORT;
        return generateIdCard(birthday, expirationDate, gender);
    }

    public IdCard generateChildrenPassport(LocalDate birthday, LocalDate expirationDate, IdCard.Gender gender) {
        idCardType = IdCard.IdCardType.CHILDREN_PASSPORT;
        return generateIdCard(birthday, expirationDate, gender);
    }

    private IdCard generateIdCard(LocalDate birthday, LocalDate expirationDate, IdCard.Gender gender) {
        String tempDocumentnumber = generateTempDocumentnumber();
        String documentnumber = tempDocumentnumber + generateCheckDigit(tempDocumentnumber);
        String birthdate = birthday.format(dateTimeFormatter) +
                generateCheckDigit(birthday.format(dateTimeFormatter));
        String tempExpiryDate = dateTimeFormatter.format(expirationDate);
        String expiryDate = tempExpiryDate + generateCheckDigit(tempExpiryDate);
        String checkDigit = generateCheckDigit(documentnumber + birthdate + expiryDate);

        if (idCardType == IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION ||
                idCardType == IdCard.IdCardType.OLD_IDENTITY_CARD) {
            return new IdCard(documentnumber, birthdate, expiryDate, checkDigit, idCardType);
        }
        if (idCardType == IdCard.IdCardType.TEMPORARY_PASSPORT || idCardType == IdCard.IdCardType.CHILDREN_PASSPORT) {
            return new IdCard(documentnumber, birthdate, gender, expiryDate, checkDigit, idCardType);
        }

        String version = generateVersion();
        checkDigit = generateCheckDigit(documentnumber + birthdate + expiryDate + version);

        if (idCardType == IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION) {

            return new IdCard(documentnumber, birthdate, expiryDate, version, checkDigit, idCardType);
        }
        if (idCardType == IdCard.IdCardType.PASSPORT) {
            return new IdCard(documentnumber, birthdate, gender, expiryDate, version, checkDigit, idCardType);
        }

        throw new IllegalStateException("Unexpected idCard type: " + idCardType);
    }

    private String generateTempDocumentnumber() {
        if (idCardType == IdCard.IdCardType.OLD_IDENTITY_CARD) {
            return generateAuthorityCode() + generateIdNumber();
        }
        if (idCardType == IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION ||
                idCardType == IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION) {
            return generateLetterIdentityCard() + generateDocumentnumber();
        }
        if (idCardType == IdCard.IdCardType.PASSPORT) {
            return generateLetterPassport() + generateDocumentnumber();
        }
        if (idCardType == IdCard.IdCardType.TEMPORARY_PASSPORT) {
            return generateLetterTemporaryPassport() + "<" + generateAuthorityCode() +
                    generateIdNumber().substring(0, 3);
        }
        if (idCardType == IdCard.IdCardType.CHILDREN_PASSPORT) {
            return generateLetterChildrenPassport() + "<" + generateAuthorityCode() +
                    generateIdNumber().substring(0, 3);
        }
        throw new IllegalStateException("Unexpected idCard type: " + idCardType);
    }

    private LocalDate getBirthdayAge() {
        int lowerAge = 15;
        int upperAge = 99;
        int age = (int) (Math.random() * (upperAge - lowerAge) + lowerAge);

        return LocalDate.now().minusYears(age);
    }

    private char generateLetterIdentityCard() {
        char[] letters = {'L','M','N','P','R','T','V','W','X','Y'};

        int position = (int) (Math.random() * letters.length);

        return letters[position];
    }

    private char generateLetterPassport() {
        char[] letters = {'C','F','G','H','J','K'};

        int position = (int) (Math.random() * letters.length);

        return letters[position];
    }

    private char generateLetterTemporaryPassport() {
        char[] letters = {'A','B'};

        int position = (int) (Math.random() * letters.length);

        return letters[position];
    }

    private char generateLetterChildrenPassport() {
        char[] letters = {'E','F','G'};

        int position = (int) (Math.random() * letters.length);

        return letters[position];
    }

    private String generateAuthorityCode() {
        int lowerLimit = 10000;
        int upperLimit = 19999;

        int authorityCode = (int) (Math.random() * (upperLimit - lowerLimit) + lowerLimit);

        return String.valueOf(authorityCode).substring(1);
    }

    private String generateIdNumber() {
        int lowerLimit = 100000;
        int upperLimit = 199999;

        int authorityCode = (int) (Math.random() * (upperLimit - lowerLimit) + lowerLimit);

        return String.valueOf(authorityCode).substring(1);
    }

    private String generateDocumentnumber() {
        char[] letters = {'C','F','G','H','J','K','L','M','N','P','R','T','V','W','X','Y','Z','1','2','3','4','5','6',
                '7','8','9'};

        StringBuilder documentnumber = new StringBuilder();

        for (int counter = 0; counter < 8; counter++) {
            int position = (int) (Math.random() * letters.length);
            documentnumber.append(letters[position]);
        }
        return documentnumber.toString();
    }

    private String generateVersion() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMM");
        String version = LocalDate.now().format(dateTimeFormatter);

        if (idCardType.equals(IdCard.IdCardType.PASSPORT)) {
            return version + "<<<<<<<<<<" + this.generateCheckDigit(version + "<<<<<<<<<<");
        } else return version;
    }

    public String generateCheckDigit(String input) {
        int[] weight = {7,3,1};
        int checkDigit = 0;

        for (int positionInString = 0; positionInString < input.length(); positionInString++) {
            if (((int) input.charAt(positionInString) - 64) > 0) {
                checkDigit += (((int) input.charAt(positionInString) - 55) * weight[positionInString % 3]) % 10;
            }
            else {
                if (input.charAt(positionInString) != '<') {
                    checkDigit += Character.getNumericValue(input.charAt(positionInString)) * weight[positionInString % 3];
                }
            }
        }
        return String.valueOf(checkDigit % 10);
    }
}
