package com.questions.algo.gfg.amazon;

/**
 * @author Jitendra Kumar : 10/12/19
 */
public class AllPossibleStringsWithSpace {

    private static void printAllPossibleString(char[] chars, int charSize, char[] buff, int finalCharSize) {
        if (chars.length == charSize) {
            buff[finalCharSize] = '\0';
            System.out.println(new String(buff).trim());
            return;
        }
        buff[finalCharSize] = chars[charSize];
        printAllPossibleString(chars, charSize + 1, buff, finalCharSize + 1);
        buff[finalCharSize] = ' ';
        buff[finalCharSize + 1] = chars[charSize];
        printAllPossibleString(chars, charSize + 1, buff, finalCharSize + 2);
    }

    public static void main(String[] args) {
        char[] chars = {'A','B','C', 'D'};
        char[] buff = new char[2 * chars.length];
        buff[0] = chars[0];
        printAllPossibleString(chars, 1, buff, 1);
    }
}
