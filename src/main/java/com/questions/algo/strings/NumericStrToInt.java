package com.questions.algo.strings;

public class NumericStrToInt {

    private static void strintToInt(String string) {
        int value = Integer.valueOf(string);
        System.out.println(value);
        int val = Integer.parseInt(string);
        System.out.println(val);

        char[] chars = string.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            if (chars[i] >= 48 && chars[i] <= 57) {
                System.out.print(chars[i]);
            }
        }
    }

    public static void main(String[] args) {
        strintToInt("12342");
    }
}
