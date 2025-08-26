package com.mc.coffeemanager;

import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.presentation.Menu;

public class Run {

    public static void main(String[] args) {
        Coffee[] coffees = {
                new Coffee("americano", 1000, 500, 10, 3, 0),
                new Coffee("mocha", 2000, 1000, 10, 3, 0),
                new Coffee("latte", 3000, 1500, 10, 3, 0),
                new Coffee("frupuchino", 4000, 2000, 10, 3, 0)};

        new Menu(coffees).menu();

    }

}
