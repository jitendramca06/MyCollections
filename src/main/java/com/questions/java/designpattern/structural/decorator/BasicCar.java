package com.questions.java.designpattern.structural.decorator;

/**
 * Created by jitendra on 27 Feb, 2018
 */

/*
Component Implementation – The basic implementation of the component interface.
We can have BasicCar class as our component implementation.
 */
public class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }
}
