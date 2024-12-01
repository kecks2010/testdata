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
import java.util.List;

/**
 * @author Mirko Werner
 *
 * Abstract class to create a repository with a list of objects from a given csv file.
 */
public class AbstractCsvRepository {

    protected <T> List<T> readCsvEntriesAndConvert(String filePath, Class<? extends Enum<?>> header, ITestdataCsvMapper<T> mapper) {
        List<T> dataList = new ArrayList<>();

        try {
            try (InputStream in = getClass().getResourceAsStream(filePath)) {
                assert in != null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                final CSVFormat csvFormat = CSVFormat.Builder.create().setDelimiter(",").build();
                Iterable<CSVRecord> csvRecords = csvFormat.builder()
                        .setHeader(header)
                        .build()
                        .parse(bufferedReader);
                for (CSVRecord csvRecord : csvRecords) {
                    dataList.add(mapper.map(csvRecord));
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }
}
