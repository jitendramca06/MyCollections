package com.questions.java.generics;

/**
 * Created by jitendra on 13 Mar, 2018
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
