package com.mc.coffeemanager.domain.multilang.payment.translate;

import com.mc.coffeemanager.domain.payment.Payment;

public interface Translatable<T> {
    String translate();

    T origin();
}
