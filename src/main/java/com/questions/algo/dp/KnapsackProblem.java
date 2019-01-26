package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 16/12/18
 *
 * Time Complexity: O(nW) where n is the number of items and W is the capacity of knapsack.
 */
public class KnapsackProblem {
    private static int knapsack(int[] values, int[] weight, int W) {
        int[][] dp = new int[values.length + 1][W + 1];

        for (int i = 0 ; i <= values.length ; i++) {
            for (int w = 0 ; w <= W ; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weight[i - 1] <= w)
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weight[i-1]], dp[i - 1][w]);
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }
        return dp[values.length][W];
    }
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        System.out.println(knapsack(val, wt, W));
    }
}
