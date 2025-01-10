package de.mirko_werner.testdata;

import de.mirko_werner.testdata.model.idcard.IdCard;
import de.mirko_werner.testdata.service.idcard.IdCardValidator;
import de.mirko_werner.testdata.service.idcard.IdCardGenerator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class IdCardTest {

    IdCardValidator idCardValidator = IdCardValidator.getInstance();

    @Test
    public void testOldIdCardWithoutBirthday() {
        IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();

        IdCard idCard = idCardGenerator.generateOldIdentityCard();

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getDocumentnumber().substring(idCard.getDocumentnumber().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber()
                                .substring(0, idCard.getDocumentnumber().length()-1)))),
                () -> assertThat(idCard.getBirthDate().substring(idCard.getBirthDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getBirthDate()
                                .substring(0, idCard.getBirthDate().length()-1)))),
                () -> assertThat(idCard.getExpiryDate().substring(idCard.getExpiryDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getExpiryDate()
                                .substring(0, idCard.getExpiryDate().length()-1)))),
                () -> assertThat(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() +
                                idCard.getBirthDate() + idCard.getExpiryDate()),
                        is(idCard.getCheckDigit())),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.OLD_IDENTITY_CARD))
        );
    }

    @Test
    public void testOldIdCardWithBirthday() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();

        IdCard idCard = idCardGenerator.generateOldIdentityCard(localDate);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getDocumentnumber().substring(idCard.getDocumentnumber().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber()
                                .substring(0, idCard.getDocumentnumber().length()-1)))),
                () -> assertThat(idCard.getBirthDate().substring(idCard.getBirthDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getBirthDate()
                                .substring(0, idCard.getBirthDate().length()-1)))),
                () -> assertThat(idCard.getExpiryDate().substring(idCard.getExpiryDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getExpiryDate()
                                .substring(0, idCard.getExpiryDate().length()-1)))),
                () -> assertThat(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() +
                                idCard.getBirthDate() + idCard.getExpiryDate()),
                        is(idCard.getCheckDigit())),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.OLD_IDENTITY_CARD))
        );
    }

    @Test
    public void testOldIdCardWithBirthdayAndExpiryDate() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();

        IdCard idCard = idCardGenerator.generateOldIdentityCard(localDate, LocalDate.now().plusYears(5));

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getDocumentnumber().substring(idCard.getDocumentnumber().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber()
                                .substring(0, idCard.getDocumentnumber().length()-1)))),
                () -> assertThat(idCard.getBirthDate().substring(idCard.getBirthDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getBirthDate()
                                .substring(0, idCard.getBirthDate().length()-1)))),
                () -> assertThat(idCard.getExpiryDate().substring(idCard.getExpiryDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getExpiryDate()
                                .substring(0, idCard.getExpiryDate().length()-1)))),
                () -> assertThat(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() +
                                idCard.getBirthDate() + idCard.getExpiryDate()),
                        is(idCard.getCheckDigit())),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.OLD_IDENTITY_CARD))
        );
    }

    @Test
    public void testNewIdCardWithoutVersionAndWithoutBirthday() {
        IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();

        IdCard idCard = idCardGenerator.generateNewIdentityCardWithoutVersion();

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getDocumentnumber().substring(idCard.getDocumentnumber().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber()
                                .substring(0, idCard.getDocumentnumber().length()-1)))),
                () -> assertThat(idCard.getBirthDate().substring(idCard.getBirthDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getBirthDate()
                                .substring(0, idCard.getBirthDate().length()-1)))),
                () -> assertThat(idCard.getExpiryDate().substring(idCard.getExpiryDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getExpiryDate()
                                .substring(0, idCard.getExpiryDate().length()-1)))),
                () -> assertThat(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() +
                                idCard.getBirthDate() + idCard.getExpiryDate()),
                        is(idCard.getCheckDigit())),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION))
        );
    }

    @Test
    public void testNewIdCardWithoutVersionAndWithBirthday() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();

        IdCard idCard = idCardGenerator.generateNewIdentityCardWithoutVersion(localDate);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getDocumentnumber().substring(idCard.getDocumentnumber().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber()
                                .substring(0, idCard.getDocumentnumber().length()-1)))),
                () -> assertThat(idCard.getBirthDate().substring(idCard.getBirthDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getBirthDate()
                                .substring(0, idCard.getBirthDate().length()-1)))),
                () -> assertThat(idCard.getExpiryDate().substring(idCard.getExpiryDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getExpiryDate()
                                .substring(0, idCard.getExpiryDate().length()-1)))),
                () -> assertThat(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() +
                                idCard.getBirthDate() + idCard.getExpiryDate()),
                        is(idCard.getCheckDigit())),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION))
        );
    }

    @Test
    public void testNewIdCardWithoutVersionAndWithBirthdayAndExpiryDate() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();

        IdCard idCard = idCardGenerator.generateNewIdentityCardWithoutVersion(localDate, LocalDate.now().plusYears(5));

        assertAll(
                () -> assertThat(idCard.getVersion(), is(nullValue())),
                () -> assertThat(idCard.getDocumentnumber().substring(idCard.getDocumentnumber().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber()
                                .substring(0, idCard.getDocumentnumber().length()-1)))),
                () -> assertThat(idCard.getBirthDate().substring(idCard.getBirthDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getBirthDate()
                                .substring(0, idCard.getBirthDate().length()-1)))),
                () -> assertThat(idCard.getExpiryDate().substring(idCard.getExpiryDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getExpiryDate()
                                .substring(0, idCard.getExpiryDate().length()-1)))),
                () -> assertThat(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() +
                                idCard.getBirthDate() + idCard.getExpiryDate()),
                        is(idCard.getCheckDigit())),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITHOUT_VERSION))
        );
    }

    @Test
    public void testNewIdCardWithVersionAndWithoutBirthday() {
        IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();

        IdCard idCard = idCardGenerator.generateNewIdentityCardWithVersion();

        assertAll(
                () -> assertThat(idCard.getVersion(), is(notNullValue())),
                () -> assertThat(idCard.getDocumentnumber().substring(idCard.getDocumentnumber().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber()
                                .substring(0, idCard.getDocumentnumber().length()-1)))),
                () -> assertThat(idCard.getBirthDate().substring(idCard.getBirthDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getBirthDate()
                                .substring(0, idCard.getBirthDate().length()-1)))),
                () -> assertThat(idCard.getExpiryDate().substring(idCard.getExpiryDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getExpiryDate()
                                .substring(0, idCard.getExpiryDate().length()-1)))),
                () -> assertThat(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() +
                                idCard.getBirthDate() + idCard.getExpiryDate() + idCard.getVersion()),
                        is(idCard.getCheckDigit())),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION))
        );
    }

    @Test
    public void testNewIdCardWithVersionAndWithBirthday() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();

        IdCard idCard = idCardGenerator.generateNewIdentityCardWithVersion(localDate);

        assertAll(
                () -> assertThat(idCard.getVersion(), is(notNullValue())),
                () -> assertThat(idCard.getDocumentnumber().substring(idCard.getDocumentnumber().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber()
                                .substring(0, idCard.getDocumentnumber().length()-1)))),
                () -> assertThat(idCard.getBirthDate().substring(idCard.getBirthDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getBirthDate()
                                .substring(0, idCard.getBirthDate().length()-1)))),
                () -> assertThat(idCard.getExpiryDate().substring(idCard.getExpiryDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getExpiryDate()
                                .substring(0, idCard.getExpiryDate().length()-1)))),
                () -> assertThat(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() +
                                idCard.getBirthDate() + idCard.getExpiryDate() + idCard.getVersion()),
                        is(idCard.getCheckDigit())),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION))
        );
    }

    @Test
    public void testNewIdCardWithVersionAndWithBirthdayAndExpiryDate() {
        LocalDate localDate = LocalDate.of(1981,12,8);
        IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();

        IdCard idCard = idCardGenerator.generateNewIdentityCardWithVersion(localDate, LocalDate.now().plusYears(5));

        assertAll(
                () -> assertThat(idCard.getVersion(), is(notNullValue())),
                () -> assertThat(idCard.getDocumentnumber().substring(idCard.getDocumentnumber().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber()
                                .substring(0, idCard.getDocumentnumber().length()-1)))),
                () -> assertThat(idCard.getBirthDate().substring(idCard.getBirthDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getBirthDate()
                                .substring(0, idCard.getBirthDate().length()-1)))),
                () -> assertThat(idCard.getExpiryDate().substring(idCard.getExpiryDate().length()-1),
                        is(idCardGenerator.generateCheckDigit(idCard.getExpiryDate()
                                .substring(0, idCard.getExpiryDate().length()-1)))),
                () -> assertThat(idCardGenerator.generateCheckDigit(idCard.getDocumentnumber() +
                                idCard.getBirthDate() + idCard.getExpiryDate() + idCard.getVersion()),
                        is(idCard.getCheckDigit())),
                () -> assertThat(idCard.getType(),is(IdCard.IdCardType.NEW_IDENTITY_CARD_WITH_VERSION))
        );
    }
}
