package com.questions.java.designpattern.anotherexample.stauctural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jitendra Kumar : 2/10/18
 */
public class FlyWeightPattern {
    Map<String, Shape> objectMap = new HashMap<>();

    public Shape getShape(Type type, String colour) {
        Shape shape = objectMap.get(colour);
        if (shape == null) {
            if (Type.RECTANGLE == type) {
                shape = new Rectangle(colour);
            } else if (Type.SQUARE == type) {
                shape = new Square(colour);
            }
            objectMap.put(colour, shape);
        }
        return shape;
    }
}
