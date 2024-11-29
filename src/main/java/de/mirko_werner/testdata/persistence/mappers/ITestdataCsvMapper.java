package de.mirko_werner.testdata.persistence.mappers;

import org.apache.commons.csv.CSVRecord;

public interface ITestdataCsvMapper<T> {

    T map(CSVRecord record);
}
