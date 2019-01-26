package com.questions.java.designpattern.structural.bridge;

/**
 * Created by jitendra on 27 Feb, 2018
 */
public class BridgePatternTest {
    public static void main(String[] args) {
        Shape tri = new Triangle(new RedColor());
        tri.applyColor();

        Shape pent = new Pentagon(new GreenColor());
        pent.applyColor();
    }
}
