package com.mc.coffeemanager.domain.multilang.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public abstract class PaymentDecorator implements Translatable<Payment> {
    Translatable<Payment> target;

    public PaymentDecorator(Translatable<Payment> target){
        super();
        target.translate();
    }
}
