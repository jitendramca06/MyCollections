package com.questions.java.lambdas;

/**
 * Created by jitendra on 13 Mar, 2018
 */

interface Addablee{
    int add(int a, int b);
}

public class LambdaExpressionWithReturn {
    public static void main(String[] args) {

        // Lambda expression without return keyword.
        Addablee ad1=(a,b)->(a+b);
        System.out.println(ad1.add(10,20));

        // Lambda expression with return keyword.
        Addablee ad2=(int a,int b)->{
            return (a+b);
        };
        System.out.println(ad2.add(100,200));
    }
}
