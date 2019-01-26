package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 23/12/18
 *
 * For example, if length of the rod is 8 and the values of different pieces are given as following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 */
public class CuttingARod {

    private static int rodCutting(int[] array) {
        int[] dp = new int[array.length +1];

        dp[0] = 0;

        for (int i = 1 ; i <= array.length ; i++) {
            int maxVal = Integer.MIN_VALUE;

            for (int j = 0 ; j < i ; j++) {
                maxVal = Math.max(maxVal, array[j] + dp[i - j - 1]);
            }
            dp[i] = maxVal;
        }
        return dp[array.length];
    }
    public static void main(String[] args) {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        //Maximum Obtainable Value is 22
        System.out.println(rodCutting(arr));
    }
}
