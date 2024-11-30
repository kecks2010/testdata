package de.mirko_werner.testdata.persistence.mappers;

import org.apache.commons.csv.CSVRecord;

/**
 * @author Mirko Werner
 *
 * Method for mapping from csv-entry into object.
 */
public interface ITestdataCsvMapper<T> {

    T map(CSVRecord record);
}
