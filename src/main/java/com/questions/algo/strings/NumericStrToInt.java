package com.questions.algo.strings;

public class NumericStrToInt {

    private static boolean strintToInt(String string) {
        int value = Integer.valueOf(string);
        System.out.println(value);
        int val = Integer.parseInt(string);
        System.out.println(val);

        char[] chars = string.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            if (chars[i] < 48 && chars[i] > 57) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(strintToInt("12342"));
    }
}
