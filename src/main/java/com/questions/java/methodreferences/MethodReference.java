package com.questions.java.methodreferences;

/**
 * Created by jitendra on 13 Mar, 2018
 */
interface Sayable {
    void say();
}

public class MethodReference {
    public static void saySomething() {
        System.out.println("Hello, this is static method.");
    }

    public static void main(String[] args) {
        // Referring static method
        Sayable sayable = MethodReference::saySomething;
        // Calling interface method
        sayable.say();
    }
}
