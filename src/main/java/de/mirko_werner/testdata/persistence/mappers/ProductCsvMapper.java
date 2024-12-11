package de.mirko_werner.testdata.persistence.mappers;

import de.mirko_werner.testdata.persistence.enums.ProductCsvHeader;
import de.mirko_werner.testdata.persistence.models.Product;
import org.apache.commons.csv.CSVRecord;

/**
 * @author Mirko Werner
 *
 * Mapping from csv-entry into product object.
 */
public class ProductCsvMapper implements ITestdataCsvMapper<Product> {

    private static ProductCsvMapper instance = new ProductCsvMapper();

    private ProductCsvMapper() {}

    public static ProductCsvMapper getInstance() {
        if (instance == null) {
            instance = new ProductCsvMapper();
        }
        return instance;
    }

    @Override
    public Product map(CSVRecord record) {
        return new Product(
                Integer.parseInt(record.get(ProductCsvHeader.id)),
                record.get(ProductCsvHeader.name),
                Double.parseDouble(record.get(ProductCsvHeader.price)));
    }
}
