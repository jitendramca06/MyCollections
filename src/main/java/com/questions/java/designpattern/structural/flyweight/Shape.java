package com.questions.java.designpattern.structural.flyweight;

import java.awt.*;

/**
 * Created by jitendra on 27 Feb, 2018
 */

/*
Flyweight design pattern is used when we need to create a lot of Objects of a class.
Since every object consumes memory space that can be crucial for low memory devices,
such as mobile devices or embedded systems, flyweight design pattern can be applied to
reduce the load on memory by sharing objects.

The number of Objects to be created by application should be huge.

The object creation is heavy on memory and it can be time consuming too.

The object properties can be divided into intrinsic and extrinsic properties,
extrinsic properties of an Object should be defined by the client program.
 */
public interface Shape {
    public void draw(Graphics g, int x, int y, int width, int height,
                     Color color);
}
