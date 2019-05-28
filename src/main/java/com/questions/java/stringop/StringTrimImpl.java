package com.questions.java.stringop;

import java.util.Stack;

/**
 * @author Jitendra Kumar : 27/5/19
 */
public class StringTrimImpl {
    private static String trim(String input) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        char[] chars = input.toCharArray();
        for (int i = 0 ; i < chars.length ; i++) {
            /**
             * Skip to add any space before starting of string
             */
            if (stack.isEmpty() && chars[i] == ' ') continue;
            if (!stack.isEmpty()) {
                char top = stack.peek();
                /**
                 * Avoid to add consecutive space into string
                 */
                if (top == ' ' && chars[i] == top) continue;
            }
            stack.push(chars[i]);
        }
        /**
         * Remove last space from string
         */
        if (!stack.isEmpty()) {
            char top = stack.peek();
            if (top == ' ') stack.pop();
        }
        /**
         * Final output
         */
        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "                    hello   hi  [AB] {A  B A}hello                ";
        System.out.println(trim(input));
        input = "               f        d     ";
        input = trim(input);
        System.out.println(input.length());
        System.out.println(input);
    }
}
