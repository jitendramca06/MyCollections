package com.questions.java.designpattern.structural.bridge;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class Triangle extends Shape{

    public Triangle(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }
}
