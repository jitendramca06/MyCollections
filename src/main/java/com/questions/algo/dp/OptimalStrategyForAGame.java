package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 16/12/18
 *
 *
 * F(i, j)  represents the maximum value the user can collect from
 *          i'th coin to j'th coin.
 *
 *     F(i, j)  = Max(Vi + min(F(i+2, j), F(i+1, j-1) ),
 *                    Vj + min(F(i+1, j-1), F(i, j-2) ))
 * Base Cases
 *     F(i, j)  = Vi           If j == i
 *     F(i, j)  = max(Vi, Vj)  If j == i+1
 */
public class OptimalStrategyForAGame {

    private static int optimalSol(int[] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];

        for (int i = 0 ; i < matrix.length ; ++i) {
            for (int j = 0 , k = i ; k < matrix.length ; ++j, ++k) {

                int x = ((j + 2) <= k) ? dp[j + 2][k] : 0;
                int y = ((j + 1) <= (k - 1)) ? dp[j + 1][k -1] : 0;
                int z = ((j) <= (k - 2)) ? dp[j][k - 2] : 0;
                dp[j][k] = Math.max(matrix[j] + Math.min(x, y), matrix[k] + Math.min(y, z));
            }
        }
        return dp[0][matrix.length - 1];
    }
    public static void main(String[] args) {
        int arr1[] = { 8, 15, 3, 7 };
        int n = arr1.length;
        System.out.println("" + optimalSol(arr1));
    }
}
