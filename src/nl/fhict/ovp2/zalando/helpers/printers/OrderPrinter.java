package nl.fhict.ovp2.zalando.helpers.printers;

import nl.fhict.ovp2.zalando.model.robot.ToruRobot;

import java.awt.*;
import java.text.MessageFormat;

public class OrderPrinter {

    private OrderPrinter() {}

    public static void print(int orderRun, int orderSize, String name, String versionCode) {
        if(versionCode.equals("")){
            System.out.println();
            System.out.println(MessageFormat.format("Robot {2} version: No version set - Order {0} with {1} products", orderRun, orderSize, name));
            System.out.println("--------");
        } else{
            System.out.println();
            System.out.println(MessageFormat.format("Robot {2} version: {3} - Order {0} with {1} products", orderRun, orderSize, name, versionCode));
            System.out.println("--------");
        }
    }
}