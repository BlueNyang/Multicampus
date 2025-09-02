package com.mc.coffeemanager.domain.multilang.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public class ChinaDecorator extends PaymentDecorator{
    public ChinaDecorator(Translatable<Payment> target) {
        super(target);
    }

    @Override
    public String translate() {
        Payment payment = origin();
        float price = payment.getPaymentPrice()/ 200.0f;

        return String.format("%s\n%s 杯\n%.2f 元", target.translate() ,payment.getOrderName(), price);
    }

    @Override
    public Payment origin() {
        return target.origin();
    }
}
