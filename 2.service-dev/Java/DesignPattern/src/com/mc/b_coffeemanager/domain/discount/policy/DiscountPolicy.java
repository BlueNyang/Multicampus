package com.mc.b_coffeemanager.domain.discount.policy;

import com.mc.b_coffeemanager.domain.order.Order;

public abstract class DiscountPolicy {

    public int calculatePaymentPrice(Order order) {
        return order.getOrderPrice() - getDiscountAmount(order);
    }

    protected abstract int getDiscountAmount(Order order);
}
