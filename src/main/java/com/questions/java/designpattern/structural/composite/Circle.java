package com.questions.java.designpattern.structural.composite;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class Circle implements Shape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Circle with color "+fillColor);
    }
}
