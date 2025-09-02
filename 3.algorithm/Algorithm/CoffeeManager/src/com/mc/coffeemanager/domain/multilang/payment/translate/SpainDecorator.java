package com.mc.coffeemanager.domain.multilang.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public class SpainDecorator extends PaymentDecorator {
    public SpainDecorator(Translatable<Payment> target) {
        super(target);
    }

    @Override
    public String translate() {
        Payment payment = origin();
        float price = payment.getPaymentPrice()/ 1300.0f;
        return String.format("%s\n%s tazas de\n%.2f €", target.translate() ,payment.getOrderName(), price);
    }

    @Override
    public Payment origin() {
        return target.origin();
    }
}
