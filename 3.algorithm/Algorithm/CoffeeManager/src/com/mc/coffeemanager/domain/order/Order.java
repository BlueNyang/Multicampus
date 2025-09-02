package com.mc.coffeemanager.domain.order;

import com.mc.coffeemanager.domain.coffee.Coffee;

import java.time.OffsetDateTime;

public class Order {
    private final String name;
    private final Coffee coffee;
    private final int orderCnt;
    private final int orderPrice;
    private final OffsetDateTime orderTime;
    private OrderStatus status;

    public static Order createOrder(Coffee coffee, int orderCnt) {

        Order order = new Order(coffee, orderCnt);
        order.status = OrderStatus.determineStatus(order);
        return order;
    }

    private Order(Coffee coffee, int orderCnt) {
        this.name = coffee.getName() + "[" + orderCnt + "]";
        this.coffee = coffee;
        this.orderCnt = orderCnt;
        this.orderPrice = coffee.getPrice() * orderCnt;
        this.orderTime = OffsetDateTime.now();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public int getOrderCnt() {
        return orderCnt;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public OffsetDateTime getOrderTime() {
        return orderTime;
    }

    public void proceed() {
        coffee.provide(orderCnt);
    }
}
