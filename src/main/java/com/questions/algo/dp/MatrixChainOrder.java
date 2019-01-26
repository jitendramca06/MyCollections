package com.questions.algo.dp;

/**
 * @author Jitendra Kumar : 23/12/18
 */
public class MatrixChainOrder {

    private static int matrixMal(int[] matrix) {
        int[][] dp = new int[matrix.length][matrix.length];
        int mul = 0;
        for (int i = 0 ; i < matrix.length ; i++)
            dp[i][i] = 0;
        for (int l = 2 ; l < matrix.length ; l++) {
            for (int i = 0 ; i < matrix.length - l ; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1 ; k < j ;k++) {
                    mul = dp[i][k] + dp[k][j] + matrix[i]*matrix[k] * matrix[j];
                    if (mul < dp[i][j])
                        dp[i][j] = mul;
                }
            }
        }
        return dp[0][matrix.length - 1];
    }
    public static void main(String[] args) {
        int arr[] = new int[] {1, 2, 3, 4};
        System.out.println(matrixMal(arr));
    }
}
