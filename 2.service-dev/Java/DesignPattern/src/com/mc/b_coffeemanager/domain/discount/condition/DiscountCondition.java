package com.mc.b_coffeemanager.domain.discount.condition;

import com.mc.b_coffeemanager.domain.order.Order;

public interface DiscountCondition {
    boolean isSatisfied(Order order);
}
