package com.mc.b_coffeemanager;

import com.mc.b_coffeemanager.domain.coffee.Coffee;
import com.mc.b_coffeemanager.domain.coffee.SeasonalCoffee;
import com.mc.b_coffeemanager.presentation.Menu;

import java.time.Month;

public class Run {

    public static void main(String[] args) {
        Coffee[] coffees = {
                new Coffee("americano", 1000, 500, 10, 3, 0),
                new Coffee("mocha", 2000, 1000, 10, 3, 0),
                new Coffee("latte", 3000, 1500, 10, 3, 0),
                new Coffee("frappuccino", 4000, 2000, 10, 3, 0),
                new SeasonalCoffee("Patbingsu", 3000, 1500, 10, 3, 0,
                        new Month[]{Month.JUNE, Month.JULY, Month.AUGUST}),
        };

        new Menu(coffees).menu();

    }

}
