package com.mc.b_coffeemanager.domain.order;

import com.mc.b_coffeemanager.domain.coffee.Coffee;
import com.mc.b_coffeemanager.domain.coffee.SeasonalCoffee;
import com.mc.b_coffeemanager.domain.purchase.Purchase;

// enum
public enum OrderStatus {

    OK(200, "Success order"),
    FAIL_SOLD_OUT(300, "Not enough stock"),
    FAIL_FORCE(400, "Force stop by user"),
    FAIL_SEASON(401, "Not available in this season");

    private final int code;
    private final String desc;

    OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static OrderStatus determineStatus(Order order) {
        int orderCnt = order.getOrderCnt();
        Coffee coffee = order.getCoffee();

        if (orderCnt > coffee.getStock()) {
            Purchase purchase = new Purchase(coffee, orderCnt);
            if (!purchase.proceed()) {
                return FAIL_SOLD_OUT;
            }
        }

        if (coffee instanceof SeasonalCoffee seasonalCoffee) {
            if (!seasonalCoffee.isSeason()) {
                return OrderStatus.FAIL_SEASON;
            }
        }

        return OK;
    }

    public boolean isOk() {
        return code == OK.code;
    }

    public boolean isFail() {
        return code != OK.code;
    }

    public String desc() {
        return desc;
    }

    public int code() {
        return code;
    }
}
