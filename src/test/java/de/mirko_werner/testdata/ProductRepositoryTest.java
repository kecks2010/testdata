package de.mirko_werner.testdata;

import de.mirko_werner.testdata.persistence.models.Product;
import de.mirko_werner.testdata.repositories.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProductRepositoryTest {

    ProductRepository productRepository = ProductRepository.getInstance();

    @DisplayName("Get Product for id")
    @Test
    public void getProductForId() {
        Product product = new Product(1205,"Basic Blue Jeans",30.00);

        assertThat(productRepository.getProduct(1205),is(notNullValue()));
        assertThat(productRepository.getProduct(1205),is(product));
    }

    @DisplayName("Get payment for not existing id")
    @Test
    public void getPaymentForIdNotExist() {

        assertThat(productRepository.getProduct(0),is(nullValue()));
    }
}
