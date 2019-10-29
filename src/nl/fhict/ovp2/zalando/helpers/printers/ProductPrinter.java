package nl.fhict.ovp2.zalando.helpers.printers;

import nl.fhict.ovp2.zalando.model.Product;

import java.text.MessageFormat;

public class ProductPrinter {

    private ProductPrinter() {}

    public static void print(int pickingRun, Product product) {
        System.out.println(MessageFormat.format("Pickup {1} - {0}", product, pickingRun));
    }
}