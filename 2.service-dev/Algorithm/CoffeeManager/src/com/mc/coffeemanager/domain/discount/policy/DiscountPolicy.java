package com.mc.coffeemanager.domain.discount.policy;

import com.mc.coffeemanager.domain.order.Order;

public abstract class DiscountPolicy {

    public int calculatePaymentPrice(Order order) {
        return order.getOrderPrice() - getDiscountAmount(order);
    }

    protected abstract int getDiscountAmount(Order order);
}
