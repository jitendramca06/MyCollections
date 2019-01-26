package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 23/12/18
 */
public class PartitionProblem {

    private static boolean canBePartitioned(int[] array) {
        int sum = 0;
        for (int i = 0 ; i < array.length ; i++) {
            sum = sum + array[i];
        }

        if (sum % 2 == 0) return false;
        boolean[][] dp = new boolean[sum/2 + 1][array.length + 1];

        for (int i = 0 ; i <= sum/2 ; i++) {
            dp[i][0] = false;
        }

        for (int i = 0 ; i <= array.length ; i++) {
            dp[0][i] = true;
        }

        for (int i = 1; i < sum/2 + 1 ; i++) {
            for (int j = 1 ; j < array.length + 1 ; j++) {
                dp[i][j] = dp[i][j - 1];
                if (i >= array[j - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - array[j - 1]][j - 1];
                }
            }
        }
        return dp[0][array.length - 1];
    }
    public static void main(String[] args) {
        int arr[] = {3, 1, 1, 2, 2,1};
        System.out.println(canBePartitioned(arr));
    }
}
