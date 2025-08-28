package com.mc.coffeemanager.domain.coffee;

import com.mc.coffeemanager.domain.coffee.Coffee;

import java.time.Month;
import java.util.Arrays;

public class SeasonalCoffee extends Coffee {
    private Month[] seasons;

    public SeasonalCoffee(String name, int price, int purchasePrice, int stock, int safetyStock, int salesCnt, Month[] seasons) {
        super(name, price, purchasePrice, stock, safetyStock, salesCnt);
        this.seasons = seasons;
    }

    public Month[] getSeason() {
        return seasons;
    }

    public boolean isSeason() {
        Month currentMonth = Month.from(java.time.LocalDate.now());
        for (Month month : seasons) {
            if (month == currentMonth) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String base = super.toString().substring(0, super.toString().indexOf(")"));
        return base + ", seasons=" + Arrays.toString(seasons) + ")}";
    }
}
