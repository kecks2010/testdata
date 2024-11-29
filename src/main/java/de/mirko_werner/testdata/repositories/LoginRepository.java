package de.mirko_werner.testdata.repositories;

import de.mirko_werner.testdata.persistence.enums.LoginCsvHeader;
import de.mirko_werner.testdata.persistence.mappers.LoginCsvMapper;
import de.mirko_werner.testdata.persistence.models.Login;

import java.util.List;

import static de.mirko_werner.testdata.config.FilePaths.PATH_TO_LOGIN_CSV;

public class LoginRepository extends AbstractCsvRepository {

    private static LoginRepository loginRepository;
    private final List<Login> loginList;

    private LoginRepository() {
        loginList = readCsvEntriesAndConvert(PATH_TO_LOGIN_CSV, LoginCsvHeader.class, LoginCsvMapper.getInstance());
    }

    public static LoginRepository getInstance() {
        if (loginRepository == null) {
            loginRepository = new LoginRepository();
        }
        return loginRepository;
    }

    public Login getLogin(long id) {
        return loginList.stream().filter(login -> login.id() == id).findFirst()
                .orElse(null);
    }

    public List<Login> getLoginListForCustomerId(long customerId) {
        return loginList.stream()
                .filter(login -> login.customerId() == customerId).toList();
    }
}
