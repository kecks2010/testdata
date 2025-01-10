package de.mirko_werner.testdata;

import de.mirko_werner.testdata.model.idcard.IdCard;
import de.mirko_werner.testdata.service.idcard.IdCardValidator;
import de.mirko_werner.testdata.service.idcard.IdCardGenerator;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class IdCardValidatorTest {
    IdCardValidator idCardValidator = IdCardValidator.getInstance();
    IdCardGenerator idCardGenerator = IdCardGenerator.getInstance();

    @Test
    public void testIsOldCardValid() {
        IdCard oldIdCard = idCardGenerator.generateOldIdentityCard();

        assertThat(idCardValidator.isIdCardValid(oldIdCard), is(true));
    }

    @Test
    public void testIsNewCardValid() {
        IdCard newIdCard = idCardGenerator.generateNewIdentityCardWithoutVersion();

        assertThat(idCardValidator.isIdCardValid(newIdCard), is(true));
    }

    @Test
    public void testIsNewCardWithVerionValid() {
        IdCard newIdCardWithVersion = idCardGenerator.generateNewIdentityCardWithVersion();

        assertThat(idCardValidator.isIdCardValid(newIdCardWithVersion), is(true));
    }

    @Test
    public void testIsPassportValid() {
        IdCard passport = idCardGenerator.generatePassport(IdCard.Gender.MALE);

        assertThat(idCardValidator.isIdCardValid(passport), is(true));
    }

    @Test
    public void testIsDocumentnumberOldCardValid() {
        IdCard oldIdCard = idCardGenerator.generateOldIdentityCard();

        assertThat(idCardValidator.isSerialnumberValid(oldIdCard.getDocumentnumber(), oldIdCard.getType()), is(true));
    }

    @Test
    public void testIsDocumentnumberNewCardValid() {
        IdCard newIdCard = idCardGenerator.generateNewIdentityCardWithoutVersion();

        assertThat(idCardValidator.isSerialnumberValid(newIdCard.getDocumentnumber(), newIdCard.getType()), is(true));
    }

    @Test
    public void testIsDocumentnumberNewCardWithVerionValid() {
        IdCard newIdCardWithVersion = idCardGenerator.generateNewIdentityCardWithVersion();

        assertThat(idCardValidator.isSerialnumberValid(newIdCardWithVersion.getDocumentnumber(), newIdCardWithVersion.getType()), is(true));
    }
}
