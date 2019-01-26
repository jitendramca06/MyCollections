package com.questions.java.designpattern.anotherexample.stauctural.bridge;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class SampleApp {
    public static void main(String[] args) {
        Shape shape = new Circle(new Red());
        shape.fillColour();
        shape = new Square(new Green());
        shape.fillColour();
    }
}
