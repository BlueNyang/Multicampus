package com.mc.algorithm.f_lambda.function;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t1, T t2);
}
