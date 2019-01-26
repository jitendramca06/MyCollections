package com.questions.java.lambdas;

/**
 * Created by jitendra on 13 Mar, 2018
 */

@FunctionalInterface
        //It is optional
interface Drawable {
    public void draw();
}

public class LambdaExpression {
    public static void main(String[] args) {
        int width = 10;

        //with lambda
        Drawable d2 = () -> {
            System.out.println("Drawing " + width);
        };
        d2.draw();

        Drawable drawable = () -> System.out.println("Drawing " + width);
        drawable.draw();
    }
}
