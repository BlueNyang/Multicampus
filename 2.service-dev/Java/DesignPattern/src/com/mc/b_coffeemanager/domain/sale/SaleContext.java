package com.mc.b_coffeemanager.domain.sale;

import com.mc.b_coffeemanager.domain.order.Order;
import com.mc.b_coffeemanager.domain.payment.Payment;

public class SaleContext {
    public void init(Order order) {
        order.proceed();
        Payment payment = new Payment(order);
        payment.proceed();
    }
}
