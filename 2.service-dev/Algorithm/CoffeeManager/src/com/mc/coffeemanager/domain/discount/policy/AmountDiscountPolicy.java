package com.mc.coffeemanager.domain.discount.policy;

import com.mc.coffeemanager.domain.discount.condition.DiscountConditionType;
import com.mc.coffeemanager.domain.order.Order;

public class AmountDiscountPolicy extends DiscountPolicy {
    private final int discountAmount;

    public AmountDiscountPolicy(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    protected int getDiscountAmount(Order order) {
        for (DiscountConditionType dct : DiscountConditionType.values()) {
            if (dct.condition().isSatisfied(order)) {
                return discountAmount;
            }
        }

        return 0;
    }
}
