package com.mc.d_strategy.items;

public interface DamageWeight {
    int calAttackWeight(int damage);

    int calDefenceWeight(int damage);
}
