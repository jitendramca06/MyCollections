package com.questions.java.designpattern.anotherexample.stauctural.flyweight;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class SampleApp {
    public static void main(String[] args) {
        FlyWeightPattern flyWeightPattern = new FlyWeightPattern();
        Rectangle shape = (Rectangle) flyWeightPattern.getShape(Type.RECTANGLE, "red");
        shape.setLength(11);
        shape.setWidth(12);
        shape.createShape();

        Square square = (Square) flyWeightPattern.getShape(Type.SQUARE, "green");
        square.setLength(13);
        square.setWidth(14);
        square.createShape();
    }
}
