package nl.fhict.ovp2.zalando.helpers;

import nl.fhict.ovp2.zalando.model.Order;
import nl.fhict.ovp2.zalando.model.Product;
import nl.fhict.ovp2.zalando.model.ProductCategory;
import nl.fhict.ovp2.zalando.model.warehouse.Aisle;
import nl.fhict.ovp2.zalando.model.warehouse.Coordinate;
import nl.fhict.ovp2.zalando.model.warehouse.Location;

import java.util.*;

public class OrderListCreator {

    private static final Random random = new Random();
    private static final int MAX_ORDERS = 15;
    private static final int MAX_NAME_LENGTH = 11;
    private static final int MAX_PATHS = 21;
    private static final int MIN_PATH = 10;
    private static final double COORDINATE_FACTOR = 100;
    private static final int MAX_PRODUCTS = 8;
    private static final int MIN_NAME_SIZE = 5;
    private static final int MIN_ORDERS = 3;
    private static final int MIN_PRODUCTS = 2;
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    private OrderListCreator() {}

    public static List<Order> getOrderList() {
        List<Order> orderList = new ArrayList<>();

        for (int i = 0; i < random.nextInt(MAX_ORDERS) + MIN_ORDERS; i++) {
            Order order = new Order(new ArrayList<>());

            for (int j = 0; j < random.nextInt(MAX_PRODUCTS) + MIN_PRODUCTS; j++) {
                order.addProduct(getNewRandomProduct());
            }
            orderList.add(order);
        }

        return orderList;
    }

    private static Product getNewRandomProduct() {
        return new Product(
                getRandomName(MAX_NAME_LENGTH),
                getRandomProductCategory(),
                getRandomWarehouseLocation());
    }

    private static String getRandomName(int nameSize) {
        final StringBuilder randomName = new StringBuilder();

        for (int i = 0; i < random.nextInt(nameSize) + MIN_NAME_SIZE; i++) {
            randomName.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        return randomName.toString();
    }

    private static ProductCategory getRandomProductCategory() {
        var productCategories = Arrays.asList(ProductCategory.values());
        return Collections.unmodifiableList(productCategories).get(random.nextInt(productCategories.size()));
    }

    private static Location getRandomWarehouseLocation() {
        return new Location(
                Integer.toString(random.nextInt(MAX_PATHS) + MIN_PATH),
                new Aisle(getRandomName(1).substring(0, 1),
                        getRandomName(1).substring(0, 2),
                        new Coordinate(
                                random.nextDouble() * COORDINATE_FACTOR,
                                random.nextDouble() * COORDINATE_FACTOR, 0.5)));
    }
}
