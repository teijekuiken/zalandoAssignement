package nl.fhict.ovp2.zalando;

import nl.fhict.ovp2.zalando.helpers.OrderListCreator;
import nl.fhict.ovp2.zalando.model.ProductCategory;
import nl.fhict.ovp2.zalando.model.robot.ToruRobot;
import nl.fhict.ovp2.zalando.helpers.printers.welcome;

public class Main {

    public static void main(String[] args) {

        welcome WelcomeMessage = new welcome();
        WelcomeMessage.welcomeMessage();

        var toruRobot = new ToruRobot("ToruBot");
        var teijeBot = new ToruRobot("TeijeBot", "v2.0", ProductCategory.DRESSES, ProductCategory.JUMPERS);
        var turboBot = new ToruRobot("turboBot", "v1.5");
        //toruRobot.pickOrders(OrderListCreator.getOrderList());
        teijeBot.pickOrders(OrderListCreator.getOrderList());
        //turboBot.pickOrders(OrderListCreator.getOrderList());
    }
}
