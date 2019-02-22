package com.questions.java.generics;

/**
 * Created by jitendra on 13 Mar, 2018
 *
 * The goal of implementing Generics is finding bugs in compile-time, other than in run-time. Finding bugs in compile-time can save time for debugging java program, because compile-time bugs are much easier to find and fix. Generic types only exist in compile-time. This fact is the most important thing to remember for learning Java Generics.
 *
 * Stronger type checking at compile time.
 * Elimination of explicit cast.
 * Enabling better code reusability such as implementation of generic algorithms
 */
public class GenericClass<T> {
    T x, y;
    GenericClass(T var1, T var2) {
        x = var1;
        y = var2;
    }
    public void display() {
        System.out.println(x + "  " + y);
    }

    public static void main(String[] args) {
        GenericClass<String> obj = new GenericClass<>("A", "B");
        obj.display();

        GenericClass<Integer> obj1 = new GenericClass<>(10, 20);
        obj1.display();
    }
}
