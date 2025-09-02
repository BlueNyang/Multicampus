package com.mc.coffeemanager.domain.discount.condition;

import com.mc.coffeemanager.domain.order.Order;

import java.time.DayOfWeek;
import java.time.OffsetDateTime;

public record PeriodCondition(DayOfWeek dayOfWeek, int startTime, int endTime) implements DiscountCondition {

    @Override
    public boolean isSatisfied(Order order) {
        OffsetDateTime orderTime = order.getOrderTime();
        return orderTime.getDayOfWeek().equals(dayOfWeek)
                && startTime <= orderTime.getHour()
                && endTime >= orderTime.getHour();
    }
}
