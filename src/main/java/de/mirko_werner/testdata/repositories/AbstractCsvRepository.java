package de.mirko_werner.testdata.repositories;

import de.mirko_werner.testdata.persistence.mappers.ITestdataCsvMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AbstractCsvRepository {

    protected <T> List<T> readCsvEntriesAndConvert(String filePath, Class<? extends Enum<?>> header, ITestdataCsvMapper<T> mapper) {
        List<T> dataList = new ArrayList<>();
        List<T> synchronizedDataList = Collections.synchronizedList(dataList);

        try {
            try (InputStream in = getClass().getResourceAsStream(filePath)) {
                assert in != null;
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(in, StandardCharsets.UTF_8));
                final CSVFormat csvFormat = CSVFormat.Builder.create().setDelimiter(",").build();
                Iterable<CSVRecord> records = csvFormat.builder()
                        .setHeader(header)
                        .build()
                        .parse(reader);
                for (CSVRecord record : records) {
                    synchronizedDataList.add(mapper.map(record));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return synchronizedDataList;
    }
}
