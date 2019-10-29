package nl.fhict.ovp2.zalando.model;

import nl.fhict.ovp2.zalando.model.warehouse.Location;

import java.text.MessageFormat;

public class Product {

    private final String code;
    private final ProductCategory productCategory;
    private final Location location;

    public Product(String code, ProductCategory productCategory, Location location) {
        this.code = code;
        this.productCategory = productCategory;
        this.location = location;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Product code: {0}, category: {1}, location: {2}", code, productCategory, location);
    }
}
