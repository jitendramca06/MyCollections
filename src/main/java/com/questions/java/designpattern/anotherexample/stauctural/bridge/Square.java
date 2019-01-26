package com.questions.java.designpattern.anotherexample.stauctural.bridge;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class Square extends Shape{

    public Square(Colour colour) {
        super(colour);
    }
    @Override
    public void fillColour() {
        System.out.print("Fill Square with");
        colour.fillColour();
    }
}
