package com.questions.algo.strings;

/**
 * @author Jitendra Kumar : 22/1/19
 */
public class SwapWithoutThirdVar {
    private static void swap(String string1, String string2) {
        System.out.println(string1);
        System.out.println(string2);
        System.out.println("=======================");
        string1 = string1 + string2;
        string2 = string1.substring(0, string1.length() - string2.length());
        string1 = string1.substring(string2.length());
        System.out.println(string1);
        System.out.println(string2);
    }

    public static void main(String[] args) {
        String s1 = "HiHowAreYou";
        String s2 = "IAmFine";
        swap(s1, s2);
    }
}
