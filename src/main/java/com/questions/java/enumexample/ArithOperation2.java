package com.questions.java.enumexample;

/**
 * Created by jitendra on 20 Mar, 2018
 */
public enum ArithOperation2 {
    PLUS("+"){public double apply(double x, double y) {return x+y;}};
    public abstract double apply(double x, double y);
    private final String symbol;
    ArithOperation2(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return symbol;
    }
}
