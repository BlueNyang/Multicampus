package com.mc.coffeemanager.domain.discount.condition;

import com.mc.coffeemanager.domain.order.Order;

public interface DiscountCondition {
    boolean isSatisfied(Order order);
}
