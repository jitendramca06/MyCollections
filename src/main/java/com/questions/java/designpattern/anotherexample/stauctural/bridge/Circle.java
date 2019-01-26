package com.questions.java.designpattern.anotherexample.stauctural.bridge;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class Circle extends Shape{

    public Circle(Colour colour) {
        super(colour);
    }

    @Override
    public void fillColour() {
        System.out.print("Fill Circle with");
        colour.fillColour();
    }
}
