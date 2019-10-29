package nl.fhict.ovp2.zalando.helpers.printers;

import java.text.MessageFormat;

public class OrderListPrinter {

    private OrderListPrinter() {}

    public static void print(int orderListSize) {
        System.out.println();
        System.out.println(MessageFormat.format("Starting orderlist with {0} orders", orderListSize));
    }
}