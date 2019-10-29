package nl.fhict.ovp2.zalando.model.robot;

import nl.fhict.ovp2.zalando.model.Order;

import java.util.List;

abstract class Robot {

    public abstract void pickOrders(List<Order> orderList);

}
