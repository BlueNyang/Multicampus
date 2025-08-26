package com.mc.coffeemanager.domain.order;

// enum
public enum OrderStatus {

    OK(200, "Success order"),
    FAIL_SOLD_OUT(500, "Not enough stock"),
    FAIL_FORCE(400, "Force stop by user"),
    ;

    private final int code;
    private final String desc;

    OrderStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public boolean isOk() {
        return code == 200;
    }

    public boolean isFail() {
        return code != 200;
    }

    public String desc() {
        return desc;
    }

    public int code() {
        return code;
    }
}
