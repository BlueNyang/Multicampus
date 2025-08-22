package com.mc.algorithm.f_lambda;

import com.mc.algorithm.f_lambda.function.Consumer;
import com.mc.algorithm.f_lambda.function.Function;
import com.mc.algorithm.f_lambda.function.Predicate;
import com.mc.algorithm.f_lambda.function.Supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyLambda {
    // 1. Omit the type of parameters
    // 2. Omit the parentheses if there is only one parameter
    // 3. Omit the {} if the body contains only one statement
    // 3. Omit the return statement if the body contains only return statement
    public static void main(String[] args) {
        testConsumer(username -> System.out.println("Hello, " + username + "!"));
        testConsumer(username -> {
            System.out.println("================================");
            System.out.println("Hello, " + username + "!");
            System.out.println("================================");
        });

        testSupplier(() -> "Hello, World!");
        testSupplier(() -> {
            System.out.println("Generating greeting...");
            return "Hello, World!";
        });

        testFunction((a, b) -> "결과: " + (a + b));
        testFunction((a, b) -> {
            System.out.println("a + b = " + (a + b));
            return "결과: " + (a + b);
        });

        testPredicate(n -> n % 2 == 0);
        testPredicate(n -> {
            System.out.print("Checking if " + n + " is even:");
            return n % 2 == 0;
        });

        testConsumer(System.out::println);

        // map()
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            nums.add(i);
        }
        nums = nums.stream().map(n -> n * 10).toList();
        System.out.println(Arrays.toString(nums.toArray()));
    }

    public static void testConsumer(Consumer<String> fnc) {
        fnc.accept("Username");
    }

    public static void testSupplier(Supplier<String> fnc) {
        System.out.println(fnc.get());
    }

    public static void testFunction(Function<Integer, String> fnc) {
        System.out.println(fnc.apply(1000, 2000));
    }

    public static void testPredicate(Predicate<Integer> fnc) {
        System.out.println("Predicate function called");
        System.out.println(fnc.test(9999)); // true
    }
}
