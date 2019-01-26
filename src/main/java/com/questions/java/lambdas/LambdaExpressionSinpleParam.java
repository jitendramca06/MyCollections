package com.questions.java.lambdas;

/**
 * Created by jitendra on 13 Mar, 2018
 */

interface Sayablee{
    public String say(String name);
}

public class LambdaExpressionSinpleParam {
    public static void main(String[] args) {

        // Lambda expression with single parameter.
        Sayablee s1=(name)->{
            return "Hello, "+name;
        };
        System.out.println(s1.say("robot"));

        // You can omit function parentheses
        Sayablee s2= name ->"Hello, "+name;
        System.out.println(s2.say("robot"));
    }
}
