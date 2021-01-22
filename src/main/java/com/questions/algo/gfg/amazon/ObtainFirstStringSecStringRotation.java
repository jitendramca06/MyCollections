package com.questions.algo.gfg.amazon;

/**
 * @author Jitendra Kumar : 06/12/19
 */
public class ObtainFirstStringSecStringRotation {
    private static boolean canObtainFString(String firstS, String secondS) {
        if (firstS == null || secondS == null) return false;
        if (firstS.length() != secondS.length()) return false;

        /**
         * sub string of length l-2 + sub string of length 2
         */
        String clockWise = secondS.substring(2) + secondS.substring(0, 2);
        /**
         *
         */
        String antiClockWise = secondS.substring(secondS.length() - 2) + secondS.substring(0, secondS.length() -2);
        return firstS.equals(clockWise) || firstS.equals(antiClockWise);
    }
    public static void main(String[] args) {
        String first = "ABCDEF";
        String second = "EFABCD";
        System.out.println(canObtainFString(first, second));
    }
}
