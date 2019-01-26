package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 23/12/18
 *
 * Time Complexity: O(mn)
 */
public class CoinChange {

    private static long count(int[] array, int sum) {
        long[] dp = new long[sum + 1];
        dp[0] = 1;

        for (int i = 0 ; i < array.length ; i++) {
            for (int j = array[i] ; j <= sum ; j++) {
                dp[j] = dp[j] + dp[j - array[i]];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int sum = 10;
        System.out.println(count(arr, sum));
    }
}
