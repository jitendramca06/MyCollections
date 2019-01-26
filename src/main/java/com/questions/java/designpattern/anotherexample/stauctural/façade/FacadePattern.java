package com.questions.java.designpattern.anotherexample.stauctural.façade;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class FacadePattern {
    Shape circle;
    Shape square;

    public FacadePattern() {
        this.circle = new Circle();
        this.square = new Square();
    }

    public void drawCircle() {
        circle.createShape();
    }

    public void drawSquare() {
        square.createShape();
    }
}
