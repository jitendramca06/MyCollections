package com.questions.java.functionalinterfaces;

/**
 * Created by jitendra on 13 Mar, 2018
 */
/*
An Interface that contains exactly one abstract method is known as functional interface.
It can have any number of default, static methods but can contain only one abstract method.
It can also declare methods of object class.

Functional Interface is also known as Single Abstract Method Interfaces or SAM Interfaces.
It is a new feature in Java, which helps to achieve functional programming approach.
 */

interface Sayable {
    void say(String msg); // abstract method
    //A functional interface can have methods of object class.
    // It can contain any number of Object class methods.
    int hashCode();
    String toString();
    boolean equals(Object obj);
}

public class FunctionalInterface implements Sayable{
    @Override
    public void say(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        FunctionalInterface fie = new FunctionalInterface();
        fie.say("Hello there");

        Sayable sayable = msg -> System.out.println(msg);
        sayable.say("How are you ?");
    }
}
