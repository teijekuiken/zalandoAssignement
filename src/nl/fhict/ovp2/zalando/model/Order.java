package nl.fhict.ovp2.zalando.model;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.List;

public class Order {

    private final List<Product> productList;

    public Order(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    @Override
    public String toString() {
        return MessageFormat.format("Order products: {0}", productList);
    }

    public int getOrderSize() {
        return productList.size();
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(productList);
    }
}
