package nl.fhict.ovp2.zalando.model.robot;

import nl.fhict.ovp2.zalando.helpers.printers.OrderListPrinter;
import nl.fhict.ovp2.zalando.helpers.printers.OrderPrinter;
import nl.fhict.ovp2.zalando.helpers.printers.ProductPrinter;
import nl.fhict.ovp2.zalando.model.Order;
import nl.fhict.ovp2.zalando.model.Product;
import nl.fhict.ovp2.zalando.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToruRobot extends Robot {

    private final String name;
    private static final Random random = new Random();
    private String version = "";
    private ProductCategory categorie1;
    private ProductCategory categorie2;

   /*
    private Integer necessaryAisle1;
    private Integer necessaryAisle2;
    private Integer StartingAisles;
    */

    public ToruRobot(String name) {
        this.name = "<naam>-TORU-" + name;
    }

    public ToruRobot(String name, String versiecode) {
        this.name = "<naam>-TORU-" + name;
        this.version = versiecode;
    }

    public ToruRobot(String name, ProductCategory categorie1, ProductCategory categorie2) {
        this.name = "<naam>-TORU-" + name;
        this.categorie1 = categorie1;
        this.categorie2 = categorie2;
    }

    public ToruRobot(String name, String versiecode, ProductCategory categorie1, ProductCategory categorie2) {
        this.name = "<naam>-TORU-" + name;
        this.version = versiecode;
        this.categorie1 = categorie1;
        this.categorie2 = categorie2;
    }

    /*
    public ToruRobot(String name, String versiecode, ProductCategory categorie1, ProductCategory categorie2, int firstAisle, int secondAisle, int StartingAisle) {
        this.name = "<naam>-TORU-" + name;
        this.version = versiecode;
        this.categorie1 = categorie1;
        this.categorie2 = categorie2;
        this.necessaryAisle1 = firstAisle;
        this.necessaryAisle2 = secondAisle;
        this.StartingAisles = StartingAisle;
    }

    public ToruRobot(String name, String versiecode, int firstAisle, int secondAisle, int StartingAisle) {
        this.name = "<naam>-TORU-" + name;
        this.version = versiecode;
        this.necessaryAisle1 = firstAisle;
        this.necessaryAisle2 = secondAisle;
        this.StartingAisles = StartingAisle;
    }

    public ToruRobot(String name, ProductCategory categorie1, ProductCategory categorie2, int firstAisle, int secondAisle, int StartingAisle) {
        this.name = "<naam>-TORU-" + name;
        this.categorie1 = categorie1;
        this.categorie2 = categorie2;
        this.necessaryAisle1 = firstAisle;
        this.necessaryAisle2 = secondAisle;
        this.StartingAisles = StartingAisle;
    }
     */

    public String getVersion() {
        return version;
    }

    @Override
    public void pickOrders(List<Order> orderList) {
        int pickingRun = 1;
        int orderRun = 1;

        OrderListPrinter.print(orderList.size());

        for (Order order : orderList) {
            OrderPrinter.print(orderRun++, order.getOrderSize(), name, getVersion());

            pickProducts(pickingRun, order);

            pickingRun = 1;
        }
    }

    private void pickProducts(int pickingRun, Order order) {
        for (Product product : order.getProducts()) {
            if(categorie1 == null && categorie2 == null){
                ProductPrinter.print(pickingRun++, product);
                simulatePickingOrder();
            } else if(product.getProductCategory().equals(categorie1) || product.getProductCategory().equals(categorie2)){
                ProductPrinter.print(pickingRun++, product);
                simulatePickingOrder();
                } else{
                continue;
            }
        }
    }



    private void simulatePickingOrder() {
        try {
            Thread.sleep(100L + random.nextInt(2000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
