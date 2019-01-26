package com.questions.java.designpattern.anotherexample.stauctural.bridge;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public abstract class Shape {
    protected Colour colour;

    public Shape(Colour colour) {
        this.colour = colour;
    }

    public abstract void fillColour();
}
