package com.questions.algo.strings;

/** * Java program to show you how to check if a String is palindrome or not.
 * * An String is said to be palindrome if it is equal to itself after reversing.
 * * In this program, you will learn how to check if a string is a palindrome in java using recursion
 * * and for loop both. * * */

public class Palindrome {
    public static void main(String args[]) {
        System.out.println("Is aaa palindrom?: " + isPalindromString("aaa"));
        System.out.println("Is abc palindrom?: " + isPalindromString("abc"));
        System.out.println("Is bbbb palindrom?: " + isPalindromString("bbbb"));
        System.out.println("Is defg palindrom?: " + isPalindromString("abba"));
        System.out.println("Is defg palindrom?: " + isPelindrome("abba"));
        System.out.println("Is defg palindrom?: " + isPelindrome("abcba"));
    }

    /**
     * Java method to check if given String is Palindrome * @param text * @return true if text is palindrome, otherwise false
     */
    public static boolean isPalindromString(String text) {
        String reverse = reverse(text);
        if (text.equals(reverse)) {
            return true;
        }
        return false;
    }

    /**
     * Java method to reverse String using recursion * @param input * @return reversed String of input
     */
    public static String reverse(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.charAt(input.length() - 1) + reverse(input.substring(0, input.length() - 1));
    }

    private static boolean isPelindrome(String string) {
        int left = 0;
        int right = string.length() - 1;

        while (left < right && string.charAt(left) == string.charAt(right)) {
            left++;
            right--;
        }
        if (left >= right) return true;
        return false;
    }

}
