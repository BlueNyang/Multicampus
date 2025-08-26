package com.mc.coffeemanager.domain.payment;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.order.Order;

public class Payment {
    private final Order order;
    private final int paymentPrice;

    public Payment(Order order) {
        this.order = order;
        this.paymentPrice = order.getOrderPrice();
    }

    public Order getOrder() {
        return order;
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    public void proceed() {
        Account account = Account.getInstance();
        account.registerSales(paymentPrice);
    }
}
