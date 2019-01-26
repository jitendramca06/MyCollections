package com.questions.java.designpattern.structural.decorator;

/**
 * Created by jitendra on 27 Feb, 2018
 */
/*
Concrete Decorators – Extending the base decorator functionality and modifying the
component behavior accordingly. We can have concrete decorator classes as LuxuryCar and SportsCar.
 */
public class SportsCar extends CarDecorator {

    public SportsCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Sports Car.");
    }
}
