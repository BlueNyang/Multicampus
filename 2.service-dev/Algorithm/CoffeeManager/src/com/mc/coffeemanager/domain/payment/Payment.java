package com.mc.coffeemanager.domain.payment;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.discount.policy.DiscountPolicy;
import com.mc.coffeemanager.domain.multilang.payment.translate.Translatable;
import com.mc.coffeemanager.domain.order.Order;

public class Payment implements Translatable<Payment> {
    private final Order order;
    private final int paymentPrice;
    private final DiscountPolicy discountPolicy;

    public Payment(Order order, DiscountPolicy discountPolicy) {
        this.order = order;
        this.discountPolicy = discountPolicy;
        this.paymentPrice = this.discountPolicy.calculatePaymentPrice(order);
    }

    public Order getOrder() {
        return order;
    }

    public String getOrderName() {
        return order.getName();
    }

    public int getPaymentPrice() {
        return paymentPrice;
    }

    public void proceed() {
        Account account = Account.getInstance();
        account.registerSales(paymentPrice);
    }

    @Override
    public String translate() {
        return order.getName() + "잔" +
                "\n" + paymentPrice + " 원";
    }

    @Override
    public Payment origin() {
        return this;
    }
}
