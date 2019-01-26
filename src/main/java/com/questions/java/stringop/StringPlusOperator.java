package com.questions.java.stringop;

/**
 * Created by jitendra on 09 Feb, 2018
 */
public class StringPlusOperator {
    private static String stringCancat(String str) {
        String [] strings = str.split("//+");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strings) {
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        System.out.println(stringCancat("Hi"+", I"+" Am" + " Jitendra"));
    }
}
