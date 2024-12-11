package de.mirko_werner.testdata.repositories;

import de.mirko_werner.testdata.persistence.enums.ProductCsvHeader;
import de.mirko_werner.testdata.persistence.mappers.ProductCsvMapper;
import de.mirko_werner.testdata.persistence.models.Product;

import java.util.List;

import static de.mirko_werner.testdata.config.FilePaths.PATH_TO_PRODUCT_CSV;

/**
 * @author Mirko Werner
 * A repository with a list of address objects where you can search for
 * a specific address onject or a list of address objects for a specific customer.
 */
public class ProductRepository extends AbstractCsvRepository {

    private static ProductRepository productRepository;
    private final List<Product> productList;

    private ProductRepository() {
        productList = readCsvEntriesAndConvert(PATH_TO_PRODUCT_CSV, ProductCsvHeader.class, ProductCsvMapper.getInstance());
    }

    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

    public Product getProduct(long id) {
        return productList.stream().filter(address -> address.id() == id).findFirst()
                .orElse(null);
    }

    public Product getRandomProduct() {

        return productList.get((int)Math.floor(productList.size() * Math.random()));
    }
}
