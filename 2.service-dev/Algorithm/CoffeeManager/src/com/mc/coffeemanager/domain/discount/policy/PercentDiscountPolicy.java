package com.mc.coffeemanager.domain.discount.policy;

import com.mc.coffeemanager.domain.discount.condition.DiscountConditionType;
import com.mc.coffeemanager.domain.order.Order;

public class PercentDiscountPolicy extends DiscountPolicy {
    private final double percent;

    public PercentDiscountPolicy(double percent) {
        if (percent < 0 || percent > 1) {
            throw new IllegalArgumentException("Percent must be between 0 and 1");
        }

        this.percent = percent;
    }

    @Override
    protected int getDiscountAmount(Order order) {
        for (DiscountConditionType dct : DiscountConditionType.values()) {
            if (dct.condition().isSatisfied(order)) {
                return (int) (order.getOrderPrice() * percent);
            }
        }

        return 0;
    }
}
