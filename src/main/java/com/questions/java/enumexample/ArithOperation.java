package com.questions.java.enumexample;

/**
 * Created by jitendra on 20 Mar, 2018
 * <p>
 * Enums are lists of constants. When you need a predefined list of values which do not represent some kind of numeric or textual data, you should use an enum. You should always use enums when a variable (especially a method parameter) can only take one out of a small set of possible values
 * <p>
 * If you use enums instead of integers (or String codes), you increase compile-time checking and avoid errors from passing in invalid constants, and you document which values are legal to use.
 */
public enum ArithOperation {
    PLUS, MINUS, DIV, MUL;

    public double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case DIV:
                return x / y;
            case MUL:
                return x * y;
            default:
                throw new RuntimeException("Invalid Operation.");
        }
    }
}
