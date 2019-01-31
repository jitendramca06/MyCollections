package com.questions.algo.dp.others;

/**
 * @author Jitendra Kumar : 31/1/19
 */
public class LongestIncreasingSumSubsequence {
    private static int LISS(int[] array) {
        int[] dp = new int[array.length];
        for (int i = 0 ; i < array.length ; i++) {
            dp[i] = array[i];
        }

        for (int i = 1; i < array.length ; i++) {
            for (int j = 0 ; j < i ; j++) {
                if (array[j] < array[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + array[i]);
                }
            }
        }

        int max = dp[0];
        for (int i = 1 ; i < array.length ; i++) {
            if (max < dp[i]) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int array[] = {3, 1, 5, 0, 6, 4, 9};
        System.out.println(LISS(array));
    }
}
