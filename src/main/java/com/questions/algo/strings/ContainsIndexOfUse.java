package com.questions.algo.strings;

public class ContainsIndexOfUse {
    private static void containsImpl(String source, String target) {
        char[] sChars = source.toCharArray();
        char[] tChars = target.toCharArray();
        int tLength = 0;
        int sLength = 0;
        boolean found = false;
        while (sLength < sChars.length) {
            int index = sLength;
            tLength = 0;
            while (tLength < tChars.length) {
                if (sChars[index++] == tChars[tLength++]) {
                    if (tLength == tChars.length) {
                        found = true;
                        break;
                    }
                }else break;
            }
            sLength++;
            if (found) break;
        }

        if (found) {
            System.out.println("String found at index -" + (sLength));
        }else System.out.println("String is not found.");
    }

    public static void main(String[] args) {
        String name = "Java is a programming language.";
        containsImpl(name, "language");
    }
}
