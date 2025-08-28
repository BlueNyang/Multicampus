package com.mc.coffeemanager.domain.multilang.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public class UsaDecorator extends PaymentDecorator {
    public UsaDecorator(Translatable<Payment> target) {
        super(target);
    }

    @Override
    public String translate() {
        Payment payment = origin();
        float price = payment.getPaymentPrice()/ 1000.0f;
        return String.format("%s\n%s cups of\n%.2f $", target.translate() ,payment.getOrderName(), price);
    }

    @Override
    public Payment origin() {
        return target.origin();
    }
}
