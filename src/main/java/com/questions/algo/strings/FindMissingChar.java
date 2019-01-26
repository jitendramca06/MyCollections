package com.questions.algo.strings;

import java.util.Arrays;

/**
 * @author Jitendra Kumar : 9/10/18
 */
public class FindMissingChar {
    private static void findMissingChar(String word) {
        word = word.toUpperCase();
        String temp = word.replace(" ", "");
        char[] chars = temp.toCharArray();
        Arrays.sort(chars);

        for (int i = 0 ; i < chars.length - 1 ; i++) {
            int charDiff = chars[i + 1] - chars[i];

            if (charDiff > 1) {

                for (int j = 1; j < charDiff; j++) {
                    char c = (char) (chars[i] + j);
                    System.out.print(c + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        findMissingChar("Geeks For Geeks");
    }
}
