package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 15/12/18
 *
 * Count ways to reach the nth stair using step 1, 2 or 3
 *
 * How Code is Working :
 * Suppose you have n stairs then you can hop either 1 step, 2 step, 3 step.
 * 1. If you hop 1 step then remaining stairs = n-1
 * 2. If you hop 2 step then remaining stairs = n-2
 * 3. If you hop 3 step then remaining stairs = n-3
 *
 * If you hop 1 step then again you can hop 1 step, 2 step, 3 step until n equals 0.
 * Repeat this process and count total number of ways to reach at nth stair using step 1, 2, 3.
 */
public class CountWaysToReachTheNthStair {

    private static int totalWays(int stairs) {
        int[] n = new int[stairs + 1];

        n[0] = 1;
        n[1] = 1;
        n[2] = 2;

        for (int i = 3 ; i <= stairs ; i++) {
            n[i] = n[i - 1] + n[i - 2] + n[i - 3];
        }

        return n[stairs];
    }
    public static void main(String[] args) {
        int stairs = 4;
        System.out.println(totalWays(stairs));
    }
}
