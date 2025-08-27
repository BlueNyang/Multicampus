package com.mc.b_coffeemanager.domain.discount.condition;

import java.time.DayOfWeek;

public enum DiscountConditionType {
    ORDER_PRICE(new OrderPriceCondition(10000, Integer.MAX_VALUE)),
    MONDAY_AM(new PeriodCondition(DayOfWeek.MONDAY, 9, 12)),
    WEDNESDAY_PM(new PeriodCondition(DayOfWeek.WEDNESDAY, 13, 19));

    private final DiscountCondition discountCondition;

    private DiscountConditionType(DiscountCondition discountCondition) {
        this.discountCondition = discountCondition;
    }

    public DiscountCondition condition() {
        return discountCondition;
    }
}
