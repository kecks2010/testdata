package de.mirko_werner.testdata.persistence.mappers;

import de.mirko_werner.testdata.persistence.enums.LoginCsvHeader;
import de.mirko_werner.testdata.persistence.enums.PaymentCsvHeader;
import de.mirko_werner.testdata.persistence.models.Login;
import org.apache.commons.csv.CSVRecord;

public class LoginCsvMapper implements ITestdataCsvMapper {

    private static LoginCsvMapper instance = new LoginCsvMapper();

    private LoginCsvMapper() {}

    public static LoginCsvMapper getInstance() {
        if (instance == null) {
            instance = new LoginCsvMapper();
        }
        return instance;
    }

    @Override
    public Login map(CSVRecord record) {
        return new Login(
                Long.parseLong(record.get(LoginCsvHeader.id)),
                record.get(LoginCsvHeader.username),
                record.get(LoginCsvHeader.password),
                record.get(LoginCsvHeader.twoFactorId),
                record.get(LoginCsvHeader.twoFactorType),
                Long.parseLong(record.get(PaymentCsvHeader.customerId))
        );
    }
}
