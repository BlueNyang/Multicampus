package com.mc.coffeemanager.domain.discount.condition;

import com.mc.coffeemanager.domain.order.Order;

public record OrderPriceCondition(int min, int max) implements DiscountCondition {
    /**
     * @param min : 할인을 위한 주문금액의 최소 범위값
     * @param max : 할인을 위한 주문금액의 최대 범위값
     */
    public OrderPriceCondition {

        if (min < 0 || max < 0) {
            throw new IllegalArgumentException("min, max는 0보다 작을 수 없습니다.");
        }

        if (max <= min) {
            throw new IllegalArgumentException("max는 min 보다 커야합니다.");
        }

    }

    @Override
    public boolean isSatisfied(Order order) {
        return order.getOrderPrice() >= min && order.getOrderPrice() < max;
    }
}
