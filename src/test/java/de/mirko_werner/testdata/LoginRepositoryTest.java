package de.mirko_werner.testdata;

import de.mirko_werner.testdata.persistence.models.Login;
import de.mirko_werner.testdata.repositories.LoginRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginRepositoryTest {

    LoginRepository loginRepository = LoginRepository.getInstance();

    @DisplayName("Get login for id")
    @Test
    public void getLoginForId() {
        Login login = new Login(1L,"harry-potter@mirko-werner.de","Tester123!",
                "harry-potter@mirko-werner.de","email", 1L);

        assertThat(loginRepository.getLogin(1),is(notNullValue()));
        assertThat(loginRepository.getLogin(1),is(login));
    }

    @DisplayName("Get login for not existing id")
    @Test
    public void getLoginForIdNotExist() {

        assertThat(loginRepository.getLogin(0),is(nullValue()));
    }

    @DisplayName("Get loginList for CustomerId")
    @Test
    public void getLoginForCustomerId() {

        assertThat(loginRepository.getLoginListForCustomerId(1),is(notNullValue()));
        assertThat(loginRepository.getLoginListForCustomerId(1).size(),is(2));
    }
}
