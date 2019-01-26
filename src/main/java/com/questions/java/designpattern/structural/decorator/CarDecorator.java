package com.questions.java.designpattern.structural.decorator;

/**
 * Created by jitendra on 27 Feb, 2018
 */
/*
Decorator – Decorator class implements the component interface and it has a
HAS-A relationship with the component interface. The component variable should be
accessible to the child decorator classes, so we will make this variable protected.
 */
public class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car c){
        this.car=c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}
