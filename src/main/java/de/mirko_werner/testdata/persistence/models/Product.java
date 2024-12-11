package de.mirko_werner.testdata.persistence.models;

/**
 * @author Mirko Werner
 * Record for Product objects.
 *
 * @param id of the product entry
 * @param name of the product entry
 * @param price of the product entry
 */
public record Product (int id, String name, double price) {
}
