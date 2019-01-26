package com.questions.java.enumexample;

/**
 * Created by jitendra on 20 Mar, 2018
 */
public enum ArithOperation1 {
    MINUS{public double apply(double x, double y) {return x-y;}},
    PLUS{public double apply(double x, double y) {return x+y;}},
    DIV{public double apply(double x, double y) {return x/y;}},
    MUL{public double apply(double x, double y) {return x*y;}};
    public abstract double apply(double x, double y);
}
