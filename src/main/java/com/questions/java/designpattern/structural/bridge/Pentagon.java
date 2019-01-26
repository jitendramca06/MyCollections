package com.questions.java.designpattern.structural.bridge;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class Pentagon extends Shape{

    public Pentagon(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    }
}
