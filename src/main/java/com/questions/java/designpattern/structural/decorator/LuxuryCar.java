package com.questions.java.designpattern.structural.decorator;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}
