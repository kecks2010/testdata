package de.mirko_werner.testdata;

import de.mirko_werner.testdata.model.idcard.IdCard;
import de.mirko_werner.testdata.service.idcard.IdCardValidator;
import de.mirko_werner.testdata.service.idcard.IdCardGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IdCardValidatorTest {
    IdCardValidator idCardValidator = IdCardValidator.getInstance();
    IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMdd");

    @Test
    public void testIsOldIdentityCardValid() {
        IdCard oldIdentityCard = new IdCard("7403318053", "4201115", "4201115",
                "8", IdCard.IdCardType.OLD_IDENTITY_CARD);

        assertThat(idCardValidator.isIdCardValid(oldIdentityCard), is(true));
    }

    @Test
    public void testIsNewIdentityCardValid() {
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", "9901122", "3501106",
                "2", IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(true));
    }

    @Test
    public void testIsNewIdentityCardWithVerionValid() {
        IdCard newIdentityCardWithVersion = new IdCard("RN5878VMK1", "7801125",
                "3501128", "2501", "6", IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCardWithVersion), is(true));
    }

    @Test
    public void testIsPassportValid() {
        IdCard passport = new IdCard("KXYZ2N11N0", "7301120", IdCard.Gender.M,
                "3501128", "2501", "8", IdCard.IdCardType.PASSPORT);

        assertThat(idCardValidator.isIdCardValid(passport), is(true));
    }

    @Test
    public void testIsTemporaryPassportValid() {
        IdCard temporaryPassport = new IdCard("B<37962198", "6101149", IdCard.Gender.M,
                "3501140", "0", IdCard.IdCardType.TEMPORARY_PASSPORT);

        assertThat(idCardValidator.isIdCardValid(temporaryPassport), is(true));
    }

    @Test
    public void testIsChildrenPassportValid() {
        IdCard childrenPassport = new IdCard("G<40134435", "7101146", IdCard.Gender.M,
                "3501140", "0", IdCard.IdCardType.CHILDREN_PASSPORT);

        assertThat(idCardValidator.isIdCardValid(childrenPassport), is(true));
    }

    @Test
    public void testIsDocumentnumberForOldIdentityCardValid() {
        IdCard oldIdentityCard = new IdCard("7403318053", "4201115", "4201115",
                "8", IdCard.IdCardType.OLD_IDENTITY_CARD);

        assertThat(idCardValidator.isSerialnumberValid(oldIdentityCard.getDocumentnumber(),
                oldIdentityCard.getType()), is(true));
    }

    @Test
    public void testIsDocumentnumberForOldIdentityCardWithInvalidCheckDigitInDocumentnumberValid() {
        IdCard oldIdentityCard = new IdCard("3272983754", "4201115", "3501117",
                "4", IdCard.IdCardType.OLD_IDENTITY_CARD);
        assertThat(idCardValidator.isIdCardValid(oldIdentityCard), is(false));
        assertThat(idCardValidator.isSerialnumberValid(oldIdentityCard.getDocumentnumber(),
                oldIdentityCard.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForOldIdentityCardWithToShortDocumentnumberValid() {
        IdCard oldIdentityCard = new IdCard("778781837", "8401108", "3501106",
                "4", IdCard.IdCardType.OLD_IDENTITY_CARD);

        assertThat(idCardValidator.isIdCardValid(oldIdentityCard), is(false));
        assertThat(idCardValidator.isSerialnumberValid(oldIdentityCard.getDocumentnumber(),
                oldIdentityCard.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForOldIdentityCardWithToLongDocumentnumberValid() {
        IdCard oldIdentityCard = new IdCard("77878183526", "8401108", "3501106",
                "4", IdCard.IdCardType.OLD_IDENTITY_CARD);

        assertThat(idCardValidator.isIdCardValid(oldIdentityCard), is(false));
        assertThat(idCardValidator.isSerialnumberValid(oldIdentityCard.getDocumentnumber(),
                oldIdentityCard.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForOldIdentityCardWithLetterInDocumentnumberValid() {
        IdCard oldIdentityCard = new IdCard("7787818N52", "8401108", "3501106",
                "4", IdCard.IdCardType.OLD_IDENTITY_CARD);

        assertThat(idCardValidator.isIdCardValid(oldIdentityCard), is(false));
        assertThat(idCardValidator.isSerialnumberValid(oldIdentityCard.getDocumentnumber(),
                oldIdentityCard.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForOldIdentityCardWithLetterAsFirstElementInDocumentnumberValid() {
        IdCard oldIdentityCard = new IdCard("N697121869", "3101115", "3501117",
                "4", IdCard.IdCardType.OLD_IDENTITY_CARD);

        assertThat(idCardValidator.isIdCardValid(oldIdentityCard), is(false));
        assertThat(idCardValidator.isSerialnumberValid(oldIdentityCard.getDocumentnumber(),
                oldIdentityCard.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForNewIdentityCardValid() {
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", "9901122", "3501106",
                "0", IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isSerialnumberValid(newIdentityCard.getDocumentnumber(),
                newIdentityCard.getType()), is(true));
    }

    @Test
    public void testIsDocumentnumberForNewIdentityCardWithIllegalFirstCharacterInDocumentnumberValid() {
        IdCard newIdentityCard = new IdCard("12NCGFGGL4", "3901108", "3501106",
                "0", IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(false));
        assertThat(idCardValidator.isSerialnumberValid(newIdentityCard.getDocumentnumber(),
                newIdentityCard.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForNewIdentityCardWithIllegalCharacterInDocumentnumberValid() {
        IdCard newIdentityCard = new IdCard("MNROYGHF77", "9501108", "3501106",
                "8", IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(false));
        assertThat(idCardValidator.isSerialnumberValid(newIdentityCard.getDocumentnumber(),
                newIdentityCard.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForNewIdentityCardWithVersionValid() {
        IdCard newIdentityCardWithVersion = new IdCard("RN5878VMK1", "7801125",
                "3501128", "2501", "6", IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCardWithVersion), is(true));
        assertThat(idCardValidator.isSerialnumberValid(newIdentityCardWithVersion.getDocumentnumber(),
                newIdentityCardWithVersion.getType()), is(true));
    }

    @Test
    public void testIsDocumentnumberForPassportValid() {
        IdCard passport = new IdCard("KXYZ2N11N0", "7301120", IdCard.Gender.M,
                "3501128", "2501<<<<<<<<<<6", "4", IdCard.IdCardType.PASSPORT);

        assertThat(idCardValidator.isIdCardValid(passport), is(true));
        assertThat(idCardValidator.isSerialnumberValid(passport.getDocumentnumber(),
                passport.getType()), is(true));
    }

    @Test
    public void testIsDocumentnumberForPassportWithIllegalFirstCharacterInDocumentnumberValid() {
        IdCard passport = new IdCard("LN8Z7CPCY7", "9301124", IdCard.Gender.M,
                "3501128", "2501<<<<<<<<<<6", "2", IdCard.IdCardType.PASSPORT);

        assertThat(idCardValidator.isIdCardValid(passport), is(false));
        assertThat(idCardValidator.isSerialnumberValid(passport.getDocumentnumber(),
                passport.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForPassportWithIllegalCharacterInDocumentnumberValid() {
        IdCard passport = new IdCard("FX1AGML4R1", "8001128", IdCard.Gender.M,
                "3501128", "2501<<<<<<<<<<6", "0", IdCard.IdCardType.PASSPORT);

        assertThat(idCardValidator.isIdCardValid(passport), is(false));
        assertThat(idCardValidator.isSerialnumberValid(passport.getDocumentnumber(),
                passport.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForTemporaryPassportValid() {
        IdCard temporaryPassport = new IdCard("B<37962198", "6101149", IdCard.Gender.M,
                "3501140", "0", IdCard.IdCardType.TEMPORARY_PASSPORT);

        assertThat(idCardValidator.isIdCardValid(temporaryPassport), is(true));
        assertThat(idCardValidator.isSerialnumberValid(temporaryPassport.getDocumentnumber(),
                temporaryPassport.getType()), is(true));
    }

    @Test
    public void testIsDocumentnumberForTemporaryPassportWithToShortDocumentnumberValid() {
        IdCard temporaryPassport = new IdCard("B<3796219", "6101149", IdCard.Gender.M,
                "3501140", "6", IdCard.IdCardType.TEMPORARY_PASSPORT);

        assertThat(idCardValidator.isIdCardValid(temporaryPassport), is(false));
        assertThat(idCardValidator.isSerialnumberValid(temporaryPassport.getDocumentnumber(),
                temporaryPassport.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForTemporaryPassportWithToLongDocumentnumberValid() {
        IdCard temporaryPassport = new IdCard("B<379621984", "6101149", IdCard.Gender.M,
                "3501140", "8", IdCard.IdCardType.TEMPORARY_PASSPORT);

        assertThat(idCardValidator.isIdCardValid(temporaryPassport), is(false));
        assertThat(idCardValidator.isSerialnumberValid(temporaryPassport.getDocumentnumber(),
                temporaryPassport.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForTemporaryPassportWithIllegalFirstCharacterDocumentnumberValid() {
        IdCard temporaryPassport = new IdCard("F<37962196", "6101149", IdCard.Gender.M,
                "3501140", "4", IdCard.IdCardType.TEMPORARY_PASSPORT);

        assertThat(idCardValidator.isIdCardValid(temporaryPassport), is(false));
        assertThat(idCardValidator.isSerialnumberValid(temporaryPassport.getDocumentnumber(),
                temporaryPassport.getType()), is(false));
    }

    @Test
    public void testIsDocumentnumberForChildrenPassportValid() {
        IdCard childrenPassport = new IdCard("G<40134435", "7101146", IdCard.Gender.M,
                "3501140", "0", IdCard.IdCardType.CHILDREN_PASSPORT);

        assertThat(idCardValidator.isIdCardValid(childrenPassport), is(true));
        assertThat(idCardValidator.isSerialnumberValid(childrenPassport.getDocumentnumber(),
                childrenPassport.getType()), is(true));
    }

    @Test
    public void testIsDocumentnumberForChildrenWithIllegalFirstCharacterInDocumentnumberPassportValid() {
        IdCard childrenPassport = new IdCard("C<40134435", "7101146", IdCard.Gender.M,
                "3501140", "2", IdCard.IdCardType.CHILDREN_PASSPORT);

        assertThat(idCardValidator.isIdCardValid(childrenPassport), is(false));
        assertThat(idCardValidator.isSerialnumberValid(childrenPassport.getDocumentnumber(),
                childrenPassport.getType()), is(false));
    }

    @Test
    public void testIsBirthdateValid() {
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", "9901122", "3501106",
                "2", IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(true));
        assertThat(idCardValidator.isBirthdayValid(newIdentityCard.getBirthDate()), is(true));
    }

    @Test
    public void testIsBirthdateWithInvalidCheckDigitValid() {
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", "9901123", "3501106",
                "5", IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(false));
        assertThat(idCardValidator.isBirthdayValid(newIdentityCard.getBirthDate()), is(false));
    }

    @Test
    public void testIsBirthdateWithoutCheckDigitValid() {
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", "990112", "3501106",
                "0", IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(false));
        assertThat(idCardValidator.isBirthdayValid(newIdentityCard.getBirthDate()), is(false));
    }

    @Test
    public void testIsBirthdateYoungerThan16YearValid() {
        String birthdate = LocalDate.now().minusYears(16).plusDays(1)
                .format(dateTimeFormatter);
        String birthdateWithCheckdigit = idCardGenerator.generateCheckDigit(birthdate);
        String checkDigit = idCardGenerator.generateCheckDigit("RPKV2X4VT0" + birthdateWithCheckdigit +
                "3501106");
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", birthdateWithCheckdigit, "3501106",
                checkDigit, IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(false));
        assertThat(idCardValidator.isBirthdayValid(newIdentityCard.getBirthDate()), is(false));
    }

    @Test
    public void testIsBirthdate16YearValid() {
        String birthdate = LocalDate.now().minusYears(16)
                .format(dateTimeFormatter);
        String birthdateWithCheckdigit = birthdate + idCardGenerator.generateCheckDigit(birthdate);
        String checkDigit = idCardGenerator.generateCheckDigit("RPKV2X4VT0" + birthdateWithCheckdigit +
                "3501106");
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", birthdateWithCheckdigit, "3501106",
                checkDigit, IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(true));
        assertThat(idCardValidator.isBirthdayValid(newIdentityCard.getBirthDate()), is(true));
    }

    @Test
    public void testIsBirthdateOlderThan16YearValid() {
        String birthdate = LocalDate.now().minusYears(16).minusDays(1)
                .format(dateTimeFormatter);
        String birthdateWithCheckdigit = birthdate + idCardGenerator.generateCheckDigit(birthdate);
        String checkDigit = idCardGenerator.generateCheckDigit("RPKV2X4VT0" + birthdateWithCheckdigit +
                "3501106");
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", birthdateWithCheckdigit, "3501106",
                checkDigit, IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(true));
        assertThat(idCardValidator.isBirthdayValid(newIdentityCard.getBirthDate()), is(true));
    }

    @Test
    public void testIsExpirationDateValid() {
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", "9901122", "3501106",
                "2", IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(true));
        assertThat(idCardValidator.isExpirationDateValid(newIdentityCard.getExpiryDate()), is(true));
    }

    @Test
    public void testIsExpirationDateWithoutCheckDigitValid() {
        String checkDigit = idCardGenerator.generateCheckDigit("RPKV2X4VT0" + "9901122" +
                "350110");
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", "9901122", "350110",
                checkDigit, IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(false));
        assertThat(idCardValidator.isExpirationDateValid(newIdentityCard.getExpiryDate()), is(false));
    }

    @Test
    public void testIsExpirationDateIsExpiredValid() {
        String expirationDate = LocalDate.now().minusDays(1).format(dateTimeFormatter);
        String expirationDatenWithCheckdigit = expirationDate + idCardGenerator.generateCheckDigit(expirationDate);
        String checkDigit = idCardGenerator.generateCheckDigit("RPKV2X4VT0" + "9901122" +
                expirationDatenWithCheckdigit);
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", "9901122",
                expirationDatenWithCheckdigit, checkDigit, IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(false));
        assertThat(idCardValidator.isExpirationDateValid(newIdentityCard.getExpiryDate()), is(false));
    }

    @Test
    public void testIsExpirationDateExpiresTodayValid() {
        String expirationDate = LocalDate.now().format(dateTimeFormatter);
        String expirationDatenWithCheckdigit = expirationDate + idCardGenerator.generateCheckDigit(expirationDate);
        String checkDigit = idCardGenerator.generateCheckDigit("RPKV2X4VT0" + "9901122" +
                expirationDatenWithCheckdigit);
        IdCard newIdentityCard = new IdCard("RPKV2X4VT0", "9901122",
                expirationDatenWithCheckdigit, checkDigit, IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION);

        assertThat(idCardValidator.isIdCardValid(newIdentityCard), is(true));
        assertThat(idCardValidator.isExpirationDateValid(newIdentityCard.getExpiryDate()), is(true));
    }

    @Test
    public void testBlubb() {

        System.out.println(idCardGenerator.generateOldIdentityCard());
        System.out.println();
        System.out.println(idCardGenerator.generateNewIdentityCardWithoutVersion());
        System.out.println();
        System.out.println(idCardGenerator.generateNewIdentityCardWithVersion());
        System.out.println();
        System.out.println(idCardGenerator.generatePassport(IdCard.Gender.M));
        System.out.println();
        System.out.println(idCardGenerator.generateTemporaryPassport(IdCard.Gender.M));
        System.out.println();
        System.out.println(idCardGenerator.generateChildrenPassport(IdCard.Gender.M));
    }
}
