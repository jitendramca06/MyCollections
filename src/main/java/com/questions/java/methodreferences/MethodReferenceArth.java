package com.questions.java.methodreferences;

import java.util.function.BiFunction;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class MethodReferenceArth {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> adder1 = Arithmetic::add;
        BiFunction<Integer, Float, Float> adder2 = Arithmetic::add;
        BiFunction<Float, Float, Float> adder3 = Arithmetic::add;
        int result1 = adder1.apply(10, 20);
        float result2 = adder2.apply(10, 20.0f);
        float result3 = adder3.apply(10.0f, 20.0f);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
