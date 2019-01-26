package com.questions.java.lambdas;

/**
 * Created by jitendra on 13 Mar, 2018
 */

interface Sayable {
    public String say();
}

public class LambdaExpressionNoParam {

    public static void main(String[] args) {
        Sayable s = () -> {
            return "I have nothing to say.";
        };
        System.out.println(s.say());

        Sayable s1 = () -> "I have nothing to say.";
        System.out.println(s1.say());
    }
}
