package com.questions.java.lambdas;

/**
 * Created by jitendra on 13 Mar, 2018
 */
interface Addable{
    int add(int a, int b);
}

public class LambdaExpressionMulParam {
    public static void main(String[] args) {

        // Multiple parameters in lambda expression
        Addable ad1=(a,b)->(a+b);
        System.out.println(ad1.add(10,20));

        // Multiple parameters with data type in lambda expression
        Addable ad2=(int a,int b)->(a+b);
        System.out.println(ad2.add(100,200));
    }
}
