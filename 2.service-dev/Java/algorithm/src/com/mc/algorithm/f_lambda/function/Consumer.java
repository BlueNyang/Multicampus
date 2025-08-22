package com.mc.algorithm.f_lambda.function;

@FunctionalInterface
public interface Consumer<E> {
    void accept(E e);
}
