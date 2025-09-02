package com.mc.coffeemanager.domain.sale;

import com.mc.coffeemanager.domain.discount.policy.AmountDiscountPolicy;
import com.mc.coffeemanager.domain.order.Order;
import com.mc.coffeemanager.domain.payment.Payment;

public class SaleContext {
    public Payment init(Order order) {
        order.proceed();
        Payment payment = new Payment(order, new AmountDiscountPolicy(500));
        payment.proceed();
        return payment;
    }
}
