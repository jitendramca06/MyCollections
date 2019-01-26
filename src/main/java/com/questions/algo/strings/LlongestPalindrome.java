package com.questions.algo.strings;

public class LlongestPalindrome {
    private static String intermediateP(String source, int left, int right) {
        if (left > right) return null;
        while (left >= 0  && right < source.length() && source.charAt(left) == source.charAt(right)) {
            left--;
            right++;
        }
        return source.substring(left+1, right);
    }

    private static String longestP(String source) {
        String longest = source.substring(0, 1);
        for (int i = 0 ; i < source.length() ; i++) {
            //For ODD section-121
            String p = intermediateP(source, i, i);
            if (p.length() > longest.length()) {
                longest = p;
            }
            //For EVEN section-1221
            p = intermediateP(source, i, i+1);
            if (p.length() > longest.length()) {
                longest = p;
            }
        }
        return longest;
    }

    private static int lengthOfLongestP(char [] chars, int start, int len) {
        if (len == 1) return 1;
        if (len == 0) return 0;
        if (chars[start] == chars[start + len - 1]) return (2 + lengthOfLongestP(chars, start + 1, len - 2));
        else return Math.max(lengthOfLongestP(chars, start + 1, len - 1), lengthOfLongestP(chars, start, len - 1));
    }

    public static void main(String[] args) {
        System.out.println(longestP("ZXYPABCDCBAKL"));
        System.out.println(lengthOfLongestP("ZXYPABCDCBAKL".toCharArray(), 0, "ZXYPABCDCBAKL".length()));
    }
}
