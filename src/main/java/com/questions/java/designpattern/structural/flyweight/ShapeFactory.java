package com.questions.java.designpattern.structural.flyweight;

import java.util.HashMap;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class ShapeFactory {
    private static final HashMap<ShapeType,Shape> shapes = new HashMap<ShapeType,Shape>();

    public static Shape getShape(ShapeType type) {
        Shape shapeImpl = shapes.get(type);

        if (shapeImpl == null) {
            if (type.equals(ShapeType.OVAL_FILL)) {
                shapeImpl = new Oval(true);
            } else if (type.equals(ShapeType.OVAL_NOFILL)) {
                shapeImpl = new Oval(false);
            } else if (type.equals(ShapeType.LINE)) {
                shapeImpl = new Line();
            }
            shapes.put(type, shapeImpl);
        }
        return shapeImpl;
    }

    public static enum ShapeType{
        OVAL_FILL,OVAL_NOFILL,LINE;
    }
}
