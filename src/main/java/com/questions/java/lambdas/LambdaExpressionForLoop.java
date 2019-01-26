package com.questions.java.lambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitendra on 13 Mar, 2018
 */
public class LambdaExpressionForLoop {
    public static void main(String[] args) {

        List<String> list=new ArrayList<String>();
        list.add("ankit");
        list.add("mayank");
        list.add("irfan");
        list.add("jai");

        list.forEach(
                (n)->System.out.println(n)
        );
    }
}
