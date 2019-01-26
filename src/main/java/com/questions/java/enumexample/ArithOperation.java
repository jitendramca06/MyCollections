package com.questions.java.enumexample;

/**
 * Created by jitendra on 20 Mar, 2018
 */
public enum ArithOperation {
    PLUS,MINUS,DIV,MUL;

    public double apply(double x, double y) {
        switch (this) {
            case PLUS:return x+y;
            case MINUS:return x-y;
            case DIV:return x/y;
            case MUL:return x*y;
            default:throw new RuntimeException("Invalid Operation.");
        }
    }
}
