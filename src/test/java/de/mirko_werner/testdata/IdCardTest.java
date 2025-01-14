package de.mirko_werner.testdata;

import de.mirko_werner.testdata.model.idcard.IdCard;
import de.mirko_werner.testdata.service.idcard.IdCardGenerator;
import de.mirko_werner.testdata.service.idcard.IdCardValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class IdCardTest {

    IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();
    IdCardValidator idCardValidator = IdCardValidator.getInstance();

    @Test
    public void testOldIdentityCardWithoutBirthday() {
        IdCard idCard = idCardGenerator.generateOldIdentityCard();

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(nullValue())),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.OLD_IDENTITY_CARD))
        );
    }

    @Test
    public void testOldIdentityCardWithBirthday() {
        LocalDate localDate = LocalDate.of(1981,12,8);

        IdCard idCard = idCardGenerator.generateOldIdentityCard(localDate);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(nullValue())),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.OLD_IDENTITY_CARD))
        );
    }

    @Test
    public void testOldIdentityCardWithBirthdayAndExpiryDate() {
        LocalDate localDate = LocalDate.of(1981,12,8);

        IdCard idCard = idCardGenerator.generateOldIdentityCard(localDate, LocalDate.now().plusYears(5));

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(nullValue())),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.OLD_IDENTITY_CARD))
        );
    }

    @Test
    public void testNewIdentityCardWithoutVersionAndWithoutBirthday() {
        IdCard idCard = idCardGenerator.generateNewIdentityCardWithoutVersion();

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(nullValue())),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION))
        );
    }

    @Test
    public void testNewIdentityCardWithoutVersionAndWithBirthday() {
        LocalDate localDate = LocalDate.of(1981,12,8);

        IdCard idCard = idCardGenerator.generateNewIdentityCardWithoutVersion(localDate);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(nullValue())),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION))
        );
    }

    @Test
    public void testNewIdentityCardWithoutVersionAndWithBirthdayAndExpiryDate() {
        LocalDate localDate = LocalDate.of(1981,12,8);

        IdCard idCard = idCardGenerator.generateNewIdentityCardWithoutVersion(localDate, LocalDate.now().plusYears(5));

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(nullValue())),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION))
        );
    }

    @Test
    public void testNewIdentityCardWithVersionAndWithoutBirthday() {
        IdCard idCard = idCardGenerator.generateNewIdentityCardWithVersion();

        assertAll(
                () -> assertThat(idCard.getVersion(), is(notNullValue())),
                () -> assertThat(idCard.getGender(), is(nullValue())),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION))
        );
    }

    @Test
    public void testNewIdentityCardWithVersionAndWithBirthday() {
        LocalDate localDate = LocalDate.of(1981,12,8);

        IdCard idCard = idCardGenerator.generateNewIdentityCardWithVersion(localDate);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(notNullValue())),
                () -> assertThat(idCard.getGender(), is(nullValue())),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION))
        );
    }

    @Test
    public void testNewIdentityCardWithVersionAndWithBirthdayAndExpiryDate() {
        LocalDate localDate = LocalDate.of(1981,12,8);

        IdCard idCard = idCardGenerator.generateNewIdentityCardWithVersion(localDate, LocalDate.now().plusYears(5));

        assertAll(
                () -> assertThat(idCard.getVersion(), is(notNullValue())),
                () -> assertThat(idCard.getGender(), is(nullValue())),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION))
        );
    }

    @Test
    public void testNewPassportWithoutBirthdayForMale() {
        IdCard idCard = idCardGenerator.generatePassport(IdCard.Gender.M);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(notNullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.M)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.PASSPORT))
        );
    }

    @Test
    public void testNewPassportWithoutBirthdayForFemaeMale() {
        IdCard idCard = idCardGenerator.generatePassport(IdCard.Gender.F);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(notNullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.F)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.PASSPORT))
        );
    }

    @Test
    public void testNewPassportWithoutBirthdayForDivers() {
        IdCard idCard = idCardGenerator.generatePassport(IdCard.Gender.X);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(notNullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.X)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.PASSPORT))
        );
    }

    @Test
    public void testNewPassportWithBirthdayForMale() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCard idCard = idCardGenerator.generatePassport(localDate, IdCard.Gender.M);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(notNullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.M)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.PASSPORT))
        );
    }

    @Test
    public void testNewPassportWithBirthdayAndExpiryDateForMale() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCard idCard = idCardGenerator.generatePassport(localDate, LocalDate.now(), IdCard.Gender.M);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(notNullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.M)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.PASSPORT))
        );
    }

    @Test
    public void testNewPassportTemporaryWithoutBirthdayForMale() {
        IdCard idCard = idCardGenerator.generateTemporaryPassport(IdCard.Gender.M);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.M)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.TEMPORARY_PASSPORT))
        );
    }

    @Test
    public void testNewTemporaryPassportWithoutBirthdayForFemaeMale() {
        IdCard idCard = idCardGenerator.generateTemporaryPassport(IdCard.Gender.F);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.F)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.TEMPORARY_PASSPORT))
        );
    }

    @Test
    public void testNewTemporaryPassportWithoutBirthdayForDivers() {
        IdCard idCard = idCardGenerator.generateTemporaryPassport(IdCard.Gender.X);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.X)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.TEMPORARY_PASSPORT))
        );
    }

    @Test
    public void testNewTemporaryPassportWithBirthdayForMale() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCard idCard = idCardGenerator.generateTemporaryPassport(localDate, IdCard.Gender.M);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.M)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.TEMPORARY_PASSPORT))
        );
    }

    @Test
    public void testNewTemporaryPassportWithBirthdayAndExpiryDateForMale() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCard idCard = idCardGenerator.generateTemporaryPassport(localDate, LocalDate.now(), IdCard.Gender.M);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.M)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.TEMPORARY_PASSPORT))
        );
    }

    @Test
    public void testNewChildrenTemporaryWithoutBirthdayForMale() {
        IdCard idCard = idCardGenerator.generateChildrenPassport(IdCard.Gender.M);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.M)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.CHILDREN_PASSPORT))
        );
    }

    @Test
    public void testNewChildrenPassportWithoutBirthdayForFemaeMale() {
        IdCard idCard = idCardGenerator.generateChildrenPassport(IdCard.Gender.F);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.F)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.CHILDREN_PASSPORT))
        );
    }

    @Test
    public void testNewChildrenPassportWithoutBirthdayForDivers() {
        IdCard idCard = idCardGenerator.generateChildrenPassport(IdCard.Gender.X);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.X)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.CHILDREN_PASSPORT))
        );
    }

    @Test
    public void testNewChildrenPassportWithBirthdayForMale() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCard idCard = idCardGenerator.generateChildrenPassport(localDate, IdCard.Gender.M);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.M)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.CHILDREN_PASSPORT))
        );
    }

    @Test
    public void testNewChildrenPassportWithBirthdayAndExpiryDateForMale() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCard idCard = idCardGenerator.generateChildrenPassport(localDate, LocalDate.now(), IdCard.Gender.M);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getGender(), is(IdCard.Gender.M)),
                () -> assertThat(idCardValidator.isIdCardValid(idCard), is(true)),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.CHILDREN_PASSPORT))
        );
    }
}
